package coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);
    private final Queue<Order> orders = new LinkedList<>();
    private int nextOrderNumber = 1;

    public void add(String customerName) {
        Order order = new Order(nextOrderNumber++, customerName);
        orders.add(order);
        logger.info("Додано нове замовлення: номер {}, ім'я {}", order.getOrderNumber(), customerName);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            logger.warn("Список замовлень порожній");
            return null;
        }
        Order order = orders.poll();
        logger.info("Видано замовлення: номер {}, ім'я {}", order.getOrderNumber(), order.getCustomerName());
        return order;
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                logger.info("Видано замовлення за номером: {}, ім'я {}", order.getOrderNumber(), order.getCustomerName());
                return order;
            }
        }
        logger.error("Замовлення з номером {} не знайдено", orderNumber);
        return null;
    }

    public void draw() {
        logger.info("Стан черги замовлень:");
        System.out.printf("%-4s | %-10s%n", "Num", "Name");
        for (Order order : orders) {
            System.out.printf("%-4d | %-10s%n", order.getOrderNumber(), order.getCustomerName());
        }
    }
}
