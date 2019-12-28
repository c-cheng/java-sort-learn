package top.ccheng.sort;

import java.util.concurrent.CountDownLatch;

/**
 * @author ccheng
 * @date 2018/9/17
 * 快速排序
 */
public class QuickSort extends AbstractSort{
    private static long count;

    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public void sortAsc(int[] array) {
        sort(array, 0, array.length-1, true);
    }

    @Override
    public void sortDesc(int[] array) {
        sort(array, 0, array.length-1, false);
    }

    @Override
    public long getCount() {
        return count;
    }

    /**
     * 将数组指定下标范围的数据进行快速排序
     * @param array 数组
     * @param startIndex 指定开始下标
     * @param endIndex 指定结束下标
     * @param asc true-升序、false-降序
     */
    private void sort(int[] array, int startIndex, int endIndex, boolean asc){
        count = 0;
        int length = array.length;
        if (startIndex < 0 || startIndex >= length || startIndex >= endIndex){
            return;
        }

        int middle = asc ? getMiddleByAsc(array, startIndex, endIndex) : getMiddleByDesc(array, startIndex, endIndex);
        if (middle-1 > startIndex) {
            sort(array, startIndex, middle - 1, asc);
        }
        if (middle+1 < endIndex) {
            sort(array, middle + 1, endIndex, asc);
        }
    }

    private int getMiddleByAsc(int[] array, int startIndex, int endIndex){
        //数组的第一个作为中轴
        int temp =  array[startIndex];
        while (startIndex < endIndex){
            //比中轴小的移到低端
            while (startIndex < endIndex && array[endIndex] >= temp){
                count++;
                endIndex --;
            }
            if (startIndex != endIndex) {
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;
            }

            //比中轴大的移到高端
            while (startIndex < endIndex && array[startIndex] <= temp){
                count++;
                startIndex ++;
            }
            if (startIndex != endIndex){
                array[endIndex] = array[startIndex];
                array[startIndex] = temp;
            }
        }
        //返回中轴位置
        return startIndex;
    }

    private int getMiddleByDesc(int[] array, int startIndex, int endIndex){
        //数组的第一个作为中轴
        int temp =  array[startIndex];
        while (startIndex < endIndex){
            //比中轴大的移到低端
            while (startIndex < endIndex && array[endIndex] <= temp){
                count++;
                endIndex --;
            }
            if (startIndex != endIndex) {
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;
            }

            //比中轴小的移到高端
            while (startIndex < endIndex && array[startIndex] >= temp){
                count++;
                startIndex ++;
            }
            if (startIndex != endIndex){
                array[endIndex] = array[startIndex];
                array[startIndex] = temp;
            }
        }
        //返回中轴位置
        return startIndex;
    }
}
