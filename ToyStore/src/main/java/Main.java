import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Добро пожаловать в магазин игрушек!");

        List<Toy> allToys = new ArrayList<>(Arrays.asList(
                new Toy(1, "Конструктор", 20, 20),
                new Toy(2, "Робот", 20, 30),
                new Toy(3, "Кукла", 60, 50),
                new Toy(4, "Машинка", 40, 25),
                new Toy(5, "Мяч", 30, 15)
        ));

        // Создание магазина игрушек
        ToyStore toyStore = new ToyStore(allToys);

        // Запуск розыгрыша 3 игрушек
        for (int i = 0; i < 3; i++) {
            Toy prizeToy = toyStore.getPrizeToy();
            System.out.println("Призовая игрушка: " + prizeToy);
            toyStore.logPrizeToy(prizeToy);
        }
    }
}