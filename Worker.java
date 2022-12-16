package TimeToDefence;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Worker implements Runnable {
    int timesGoToForest = 5;
    Semaphore sem;
    Forest forest;
    Camp camp;

    Worker(Semaphore sem, Forest forest, Camp camp) {
        this.sem = sem;
        this.forest = forest;
        this.camp = camp;
    }

    @Override
    public void run() {
        while (timesGoToForest > 0) {
            try {
                sem.acquire();

                System.out.println("Worker come into the forest.");
                int wood = forest.takeWood();
                Thread.sleep(300);
                if (wood == 0)
                {
                    sem.release();
                    break;
                }
                camp.addWood(wood);
                timesGoToForest -= 1;
                System.out.println("Remain wood in  the forest " + forest.wood);
                System.out.println("Worker get out the forest");

                sem.release();

            } catch (InterruptedException e) {
                e.getMessage();
            }

        }
    }
}
