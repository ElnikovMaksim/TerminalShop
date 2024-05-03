package projeckt.java;

import projeckt.java.data.comparators.AppComparator;
import projeckt.java.data.comparators.PriceComparator;
import projeckt.java.data.data_sourse.cart.CartDataSource;
import projeckt.java.data.data_sourse.cart.MockCartDataSourceImpl;
import projeckt.java.data.data_sourse.order.MockOrderDataSourceImpl;
import projeckt.java.data.data_sourse.order.OrderDataSource;
import projeckt.java.data.models.Product;
import projeckt.java.data.service.ShopService;
import projeckt.java.common.AppView;
import projeckt.java.common.PageLoop;
import projeckt.java.data.data_sourse.catalog.CatalogDataSource;
import projeckt.java.data.data_sourse.catalog.MockCatalogDataSourceImpl;
import projeckt.java.view.*;

import java.util.ArrayList;

public class MyClass {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        ArrayList<AppComparator<Product>> catalogComparators = new ArrayList<>();
        catalogComparators.add(new AppComparator<>(new PriceComparator(true), "по возрастанию цены"));
        catalogComparators.add(new AppComparator<>(new PriceComparator(false), "по убыванию цены"));
        AppView catalogView = new CatalogView(shopService, catalogChildren, catalogComparators);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();

    }
}
