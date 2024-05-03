package projeckt.java.data.data_sourse.cart;

import projeckt.java.data.models.CartItem;
import projeckt.java.data.models.Product;

import java.util.ArrayList;

public abstract class CartDataSource {

   public abstract void addToCart(Product product, int count);
   public abstract ArrayList<CartItem> getCart();
}
