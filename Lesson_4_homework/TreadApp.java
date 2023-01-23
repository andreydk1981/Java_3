package Lesson_4_homework;

public class TreadApp {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        TreadApp treadApp = new TreadApp();
        new Thread(treadApp::printA).start();
        new Thread(treadApp::printB).start();
        new Thread(treadApp::printC).start();

    }

    private void printA() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("A");
                currentLetter = 'B';
                mon.notifyAll();
            }
        }
    }

    private void printB() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                currentLetter = 'C';
                mon.notifyAll();
            }
        }
    }

    private void printC() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'C') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("C");
                currentLetter = 'A';
                mon.notifyAll();
            }
        }
    }
}
