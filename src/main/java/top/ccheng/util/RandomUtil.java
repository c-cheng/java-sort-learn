package top.ccheng.util;

import java.util.Random;

/**
 * @author ccheng
 * @date 2018/9/17
 */
public class RandomUtil {
    private static final Random RANDOM = new Random();

    /**
     * 产生 length 个 minInt 到 maxInt 之间的整数
     * @param length 数组长度
     * @param minInt 最小整数
     * @param maxInt 最大整数
     * @return 随机数组
     */
    public static int[] randomIntArray(int length, int minInt, int maxInt){
        int [] array = new int[length];
        for (int i = 0; i < length; i++){
            array[i] = minInt + RANDOM.nextInt(maxInt - minInt);
        }
        return array;
    }

    /**
     * 产品 length 个 0 到 maxInt 之间的整数
     * @param length 数组长度
     * @param maxInt 最大整数
     * @return 随机数组
     */
    public static int[] randomIntArray(int length, int maxInt){
        return randomIntArray(length, 0, maxInt);
    }
}
