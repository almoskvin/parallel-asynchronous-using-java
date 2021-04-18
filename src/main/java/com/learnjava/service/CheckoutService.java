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

//        double finalPrice = calculateFinalPrice(cart);
        double finalPrice = calculateFinalPriceReduce(cart);

        System.out.println("Cart final price is " + finalPrice);
        return new CheckoutResponse(CheckoutStatus.SUCCESS, finalPrice);
    }

    private double calculateFinalPrice(Cart cart) {
        return cart.getCartItemList()
                .parallelStream()
                .map(cartItem -> cartItem.getQuantity() * cartItem.getRate())
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private double calculateFinalPriceReduce(Cart cart) {
        return cart.getCartItemList()
                .parallelStream()
                .map(cartItem -> cartItem.getQuantity() * cartItem.getRate())
                .reduce(0.0, Double::sum);
    }

    private CartItem updateExpired(CartItem cartItem) {
        cartItem.setExpired(priceValidatorService.isCartItemInvalid(cartItem));
        return cartItem;
    }
}
