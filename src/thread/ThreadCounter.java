package thread;

import java.util.List;

public class ThreadCounter extends Thread {
    private int sum;
    private int id;
    private List<Integer> califications;
    private int startIndex;
    private int endIndex;

    public ThreadCounter(int id, List<Integer> califications, int startIndex, int endIndex) {
        this.id = id;
        this.califications = califications;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getSum() {
        return sum;
    }

    public void run() {
        sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += califications.get(i);
        }
        System.out.println("Thread " + id + ", que empezó en el índice " + startIndex + ", terminó en el índice " + endIndex + " y ha contado " + (endIndex - startIndex) + " calificaciones, ha sumado un total de: " + sum);
    }
}
