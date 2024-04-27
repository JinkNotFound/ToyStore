import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class ToyStore {
    private PriorityQueue<Toy> prizeToys;
    private Map<Integer, Toy> allToys;

    public ToyStore(List<Toy> allToys) {
        this.allToys = new HashMap<>();
        for (Toy toy : allToys) {
            this.allToys.put(toy.getId(), toy);
        }
        this.prizeToys = new PriorityQueue<>(Comparator.comparingInt(Toy::getProbability).reversed());
        updatePrizeToys();
    }

    // Добавление новых игрушек
    public void addToy(Toy toy) {
        allToys.put(toy.getId(), toy);
        updatePrizeToys();
    }

    // Изменение веса (вероятности выпадения) игрушки
    public void changeToyProbability(int id, int newProbability) {
        Toy toy = allToys.get(id);
        if (toy != null) {
            toy.setProbability(newProbability);
            updatePrizeToys();
        }
    }

    // Получение призовой игрушки
    private void updatePrizeToys() {
        prizeToys.clear();
        for (Toy toy : allToys.values()) {
            prizeToys.add(toy);
        }
    }

    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.poll(); // Получение игрушки с наибольшей вероятностью
            allToys.get(prizeToy.getId()).setWeight(allToys.get(prizeToy.getId()).getWeight() - 1); // Уменьшение количества игрушки
            return prizeToy;
        }
        return null;
    }

    // Запись призовой игрушки в лог-файл
    public void logPrizeToy(Toy toy) throws IOException {
        if (toy != null) {
            try (FileWriter writer = new FileWriter("log.txt", true)) {
                writer.write("Призовая игрушка: " + toy + "\n");
            }
        }
    }
}