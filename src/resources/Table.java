package resources;

public class Table {
    private int cupcake;

    public Table(int cupcake) {
        this.cupcake = cupcake;
    }

    public synchronized void takeCupcake(String name) {
        if (cupcake > 0) {
            cupcake--;
            System.out.println(name + " ha cogido una magdalena de la mesa");
        }
    }

    public int getCupcake() {
        return cupcake;
    }
}
