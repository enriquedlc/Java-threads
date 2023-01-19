package threads;

import resources.Table;

public class Diner implements Runnable {
    private String name;
    private Table table;
    private final int TIME_TO_CONSUME_MILIS = 5000;

    public Diner(String name, Table table) {
        this.name = name;
        this.table = table;
    }

    public void run() {
        while (table.getCupcake() > 0) {
            table.takeCupcake(name);
            try {
                Thread.sleep(TIME_TO_CONSUME_MILIS); // tarda 10 segundos en comerse una magdalena
                System.out.println(name + " se ha terminado de comer una magdalena");
                // System.out.println("Magdalenas restantes: " + mesa.getMagdalenas());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
