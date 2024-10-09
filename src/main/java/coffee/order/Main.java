package coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add("Alen");
        orderBoard.add("Yoda");
        orderBoard.add("Obi-van");

        orderBoard.draw();

        orderBoard.deliver();
        orderBoard.draw();

        orderBoard.deliver(2); // Номер замовлення, яке потрібно видати
        orderBoard.draw();
    }
}
