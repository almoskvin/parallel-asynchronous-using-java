package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CartItem;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.CommonUtil;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutService {

    private PriceValidatorService priceValidatorService;

    public CheckoutService(PriceValidatorService priceValidatorService) {
        this.priceValidatorService = priceValidatorService;
    }

    public CheckoutResponse checkout(Cart cart) {
        CommonUtil.stopWatchReset();
        CommonUtil.startTimer();
        List<CartItem> expiredItems = cart.getCartItemList()
                .parallelStream()
                .map(this::updateExpired)
                .filter(CartItem::isExpired)
                .collect(Collectors.toList());
        CommonUtil.timeTaken();

        if (expiredItems.size() > 0) {
            return new CheckoutResponse(CheckoutStatus.FAILURE, expiredItems);
        }
        return new CheckoutResponse(CheckoutStatus.SUCCESS);
    }

    private CartItem updateExpired(CartItem cartItem) {
        cartItem.setExpired(priceValidatorService.isCartItemInvalid(cartItem));
        return cartItem;
    }
}
