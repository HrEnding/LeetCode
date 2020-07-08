package multithreading;

import java.util.concurrent.Semaphore;

/**
 * 三个不同的线程将会共用一个 PrintInOrder 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 * @author Hr_Ending
 */
public class PrintInOrder {
    public Semaphore seamFirstTwo = new Semaphore(0);

    public Semaphore seamTwoThird = new Semaphore(0);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        seamFirstTwo.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        seamFirstTwo.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        seamTwoThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        seamTwoThird.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
