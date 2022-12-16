package TimeToDefence;

import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        Forest forest = new Forest();
        Camp camp = new Camp(0);
        Semaphore sem = new Semaphore(3);

        Thread[] workers = new Thread[4];

        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(new Worker(sem, forest, camp));
            workers[i].start();
        }

        for (int i = 0; i < workers.length; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        System.out.println(camp.wood); 

        if (camp.wood >= 100){
            System.out.println("Mission completed");
        } else{
            System.out.println("Mission failed");
        }
    }
}
