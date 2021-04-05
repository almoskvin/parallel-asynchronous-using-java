package com.learnjava.service;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    PriceValidatorService priceValidatorService = new PriceValidatorService();

    CheckoutService checkoutService = new CheckoutService(priceValidatorService);

    @Test
    void checkout_static_all_good() {
        Cart cart = DataSet.createCart(6);
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);
        assertEquals(CheckoutStatus.SUCCESS, checkoutResponse.getCheckoutStatus());
    }

    @Test
    void checkout_static_expired_items() {
        System.out.println("Processors available: " + Runtime.getRuntime().availableProcessors());
        Cart cart = DataSet.createCart(25);
        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);
        assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());
    }
}