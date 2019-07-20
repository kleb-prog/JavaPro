package Lesson_4;

public class MyThread {
    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 5; i++) {
                        System.out.print("A");
                        try {
                            lock.wait();
                            lock.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 5; i++) {
                        System.out.print("B");
                        try {
                            lock.wait();
                            lock.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 5; i++) {
                        System.out.print("C");
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
