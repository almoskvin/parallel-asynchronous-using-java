package com.learnjava.test;

import java.util.List;

public class FreshFruitLottery {

    public int foo(List<String> codeList, List<String> shoppingCart) {
        System.out.println("Codelist: " + codeList);
        System.out.println("ShoppingCart: " + shoppingCart);
        if (codeList != null && shoppingCart != null && shoppingCart.size() > 0) {
            if (codeList.size() == 0) {
                return 1;
            }
            for (int i = 0; shoppingCart.size() - i >= codeList.size(); i++) {
                if (shoppingCart.get(i).equalsIgnoreCase(codeList.get(0)) || codeList.get(0).equalsIgnoreCase("anything")) {
                    boolean match = true;
                    for (int j = 1; j < codeList.size(); j++) {
                        if (shoppingCart.get(i + j).equalsIgnoreCase(codeList.get(j)) || codeList.get(0).equalsIgnoreCase("anything")) {
                            continue;
                        }
                        match = false;
                    }
                    if (match) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }


}
