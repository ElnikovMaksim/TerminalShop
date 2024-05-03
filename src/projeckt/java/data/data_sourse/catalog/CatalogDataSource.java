package projeckt.java.data.data_sourse.catalog;

import projeckt.java.data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

// Получение каталога

public abstract class CatalogDataSource {
    public abstract ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator);

    public abstract ArrayList<Product> getCatalog(int page, int limit);

    public abstract Product productById(String id);
}
