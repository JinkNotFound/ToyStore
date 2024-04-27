class Toy {
    private int id;
    private String name;
    private int weight;
    private int probability;

    public Toy(int id, String name, int weight, int probability) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.probability = probability;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getProbability() {
        return probability;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", probability=" + probability +
                "%}";
    }
}
