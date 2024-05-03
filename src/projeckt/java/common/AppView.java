package projeckt.java.common;

import projeckt.java.data.comparators.AppComparator;
import projeckt.java.data.models.Product;

import java.util.ArrayList;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public int nowPage = 0;
    public final int pageLimit = 5;
    public boolean hasNextPage = false;
    public final ArrayList<AppComparator<Product>> availableComparator = new ArrayList<>();
    public AppComparator<Product> selectedComparator;

    protected AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }

    public void action() {

    }
}
