package com.example.demo.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * java随机数生成。
 *
 * @author Danni
 * @since 2019.7.30
 */
public class RandomCreator {

    public static void main(String[] args) {
        random();
        fixRandom();
        noBoundRandom();
        threadLocalRandom();

        mathRandom();

        timeRandom();
    }

    private static void fixRandom() {
        System.out.println("固定种子，因此每次生成都是固定的：");

        Random random = new Random(5);
        for (int i = 0; i < 10; i++) {
            // 87, 92, 74, 24, 6, 5, 54, 91, 22, 21,
            System.out.print(random.nextInt(100) + ", ");
        }
        System.out.println();

        random = new Random(31);
        for (int i = 0; i < 10; i++) {
            // 32, 56, 84, 70, 23, 49, 29, 79, 16, 40,
            System.out.print(random.nextInt(100) + ", ");
        }

        System.out.println("\n");
    }

    private static void random() {
        Random random = new Random();

        System.out.println("没有种子，因此每次都随机生成：");
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(100) + ", ");
        }
        System.out.println("\n");
    }

    private static void noBoundRandom() {
        Random random = new Random();

        System.out.println("没有种子，也没有边界，因此每次随机生成一个整数：");
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt() + ", ");
        }
        System.out.println();

        System.out.println("随机生成0到15之间的随机数（这种方案有严重bug）：");
        for (int i = 0; i < 10; i++) {
            System.out.print(Math.abs(random.nextInt()) % 16 + ", ");
        }
        System.out.println("\n");
    }

    private static void threadLocalRandom() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        System.out.println("不应该使用Random，而应该使用效率更高的ThreadLocalRandom：");
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(100) + ", ");
        }
        System.out.println("\n");
    }

    private static void mathRandom() {
        int max = 100, min = 1;

        System.out.println("第二种方法，使用Math.random，范围[0, 1)：");
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * (max - min) + min);
            System.out.print(random + ", ");
        }
        System.out.println("\n");
    }

    private static void timeRandom() {
        int max = 100, min = 1;

        System.out.println("第三种方法，使用System.currentTimeMillis，范围当前时间（long），很不好，同一时间生成则一样的：");
        for (int i = 0; i < 10; i++) {
            long randomNum = System.currentTimeMillis();
            int random = (int) (randomNum % (max - min) + min);
            System.out.print(random + ", ");
        }
        System.out.println("\n");
    }
}
