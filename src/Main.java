import resources.Table;
import threads.Diner;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(15);
        Thread diner1 = new Thread(new Diner("Comensal 1", table));
        Thread diner2 = new Thread(new Diner("Comensal 2", table));
        Thread diner3 = new Thread(new Diner("Comensal 3", table));

        diner1.setPriority(Thread.MIN_PRIORITY);
        diner2.setPriority(Thread.NORM_PRIORITY);
        diner3.setPriority(Thread.MAX_PRIORITY);

        diner1.start();
        diner2.start();
        diner3.start();
    }
}