import thread.ThreadCounter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> califications = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            int randomCalification = (int) (Math.random() * 10);
            califications.add(randomCalification);
        }

        ThreadCounter[] threadCounters = new ThreadCounter[10];
        int startIndex = 0;
        int endIndex = 10000;
        for (int i = 0; i < 10; i++) {
            threadCounters[i] = new ThreadCounter(i, califications, startIndex, endIndex);
            startIndex += 10000;
            endIndex += 10000;
        }

        for (int i = 0; i < 10; i++) {
            threadCounters[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threadCounters[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los hilos han acabado su tarea");

        int totalSum = 0;
        for (int i = 0; i < 10; i++) {
            totalSum += threadCounters[i].getSum();
        }
        double media = (double) totalSum / 100000;
        System.out.println("La media aritmética es de: " + media);
    }
}
