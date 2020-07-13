package multithreading;

import java.util.concurrent.Semaphore;

/**
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 *
 * @author 21489
 */
public class H2O {
    private Semaphore s1, s2, s3, s4;

    public H2O() {
        // H线程信号量
        s1 = new Semaphore(2);
        // O线程信号量
        s2 = new Semaphore(1);
        // 反应条件信号量
        s3 = new Semaphore(0);
        // 反应条件信号量
        s4 = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // 保证只有2个H线程进入执行
        s1.acquire();
        // 释放H原子到达信号
        s3.release();
        // 等待O原子到达
        s4.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        // 相当于唤醒1个H线程
        s1.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // 保证只有1个O线程进入执行
        s2.acquire();
        // 释放O原子到达信号，因为有2个H线程等待所以释放2个
        s4.release(2);
        // 等待H原子到达，2个原因同上
        s3.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        // 相当于唤醒1个O线程
        s2.release();
    }

}
