package projeckt.java.view;

import projeckt.java.common.AppView;
import projeckt.java.data.comparators.AppComparator;
import projeckt.java.data.comparators.PriceComparator;
import projeckt.java.data.models.Product;
import projeckt.java.data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {
    public CatalogView(ShopService shopService, ArrayList<AppView> children, ArrayList<AppComparator<Product>> comparators) {
        super("Каталог", children);
        this.shopService = shopService;
        availableComparator.addAll(comparators);
        if (!availableComparator.isEmpty()) {
            selectedComparator = availableComparator.getFirst();
        }
    }

    final ShopService shopService;

    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsc = false;
        ArrayList<Product> catalog = shopService.getCatalog(nowPage, pageLimit, selectedComparator.comparator);
        hasNextPage = catalog.size() == pageLimit;
        for (Product product : catalog) {
            System.out.println(product.id + " " + product.title + " " + product.price);
        }
        System.out.println();
    }
}
