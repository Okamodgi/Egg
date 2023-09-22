public class Main {
    public static void main(String[] args) {
        Thread chickenThread = new Thread(new Chicken());
        Thread eggThread = new Thread(new Egg());

        chickenThread.start();
        eggThread.start();

        try {
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (chickenThread.isAlive()) {
            System.out.println("Спор выигран курицей!");
        } else {
            System.out.println("Спор выигран яйцом!");
        }
    }
}

class Chicken implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Курица");
            try {
                Thread.sleep(100); // Для имитации процесса
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Egg implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Яйцо");
            try {
                Thread.sleep(100); // Для имитации процесса
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
