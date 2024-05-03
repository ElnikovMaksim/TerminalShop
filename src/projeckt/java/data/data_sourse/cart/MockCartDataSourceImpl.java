package projeckt.java.data.data_sourse.cart;

import projeckt.java.data.models.CartItem;
import projeckt.java.data.models.Product;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource {
   private final ArrayList<CartItem> cart = new ArrayList<>();

    @Override
   public void addToCart(Product product, int count) {
        cart.add(new CartItem(product, count));
    }

    @Override
   public ArrayList<CartItem> getCart() {
        return cart;
    }
}
