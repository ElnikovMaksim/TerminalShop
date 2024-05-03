package projeckt.java.view;

import projeckt.java.common.AppView;
import projeckt.java.data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    public OrderView(ShopService shopService) {
        super("Оформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите свое имя");
        String name = scanner.nextLine();
        System.out.println("Ведите свой телефон");
        String phone = scanner.nextLine();
        System.out.println("Ведите свой адрес");
        String address = scanner.nextLine();

        shopService.createOrder(name, phone, address, "cash", "12:00");
        System.out.println("Заказ оформлен");

    }
}
