package projeckt.java.view;

import projeckt.java.common.AppView;
import projeckt.java.data.models.CartItem;
import projeckt.java.data.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    public CartView(ShopService shopService) {
        super("Корзина", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
      ArrayList<CartItem> cart = shopService.getCart();
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.product.id + " " + cartItem.product.title + " " + cartItem.count);
        }
        System.out.println();
    }
}