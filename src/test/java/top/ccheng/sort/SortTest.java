package top.ccheng.sort;


import org.junit.Test;
import top.ccheng.util.RandomUtil;

import java.util.Arrays;

public class SortTest {

    @Test
    public void testAll() {
        int[] array = RandomUtil.randomIntArray(1000000, 10000);

        int[] javaArray = javaSort(array.clone());
//        int[] bubbleArray = new BubbleSort().testSortAsc(array.clone());
        int[] quickArray = new QuickSort().testSortAsc(array.clone());
//        int[] selectArray = new SelectSort().testSortAsc(array.clone());
//        int[] insertArray = new InsertSort().testSortAsc(array.clone());
        int[] shellArray = new ShellSort().testSortAsc(array.clone());
        int[] mergeArray = new MergeSort().testSortAsc(array.clone());
        int[] heapArray = new HeapSort().testSortAsc(array.clone());

//        System.out.println(Arrays.equals(javaArray, bubbleArray));
        System.out.println(Arrays.equals(javaArray, quickArray));
//        System.out.println(Arrays.equals(javaArray, selectArray));
//        System.out.println(Arrays.equals(javaArray, insertArray));
        System.out.println(Arrays.equals(javaArray, shellArray));
        System.out.println(Arrays.equals(javaArray, mergeArray));
        System.out.println(Arrays.equals(javaArray, heapArray));

//        System.out.println(Arrays.toString(array));
    }

    private int[] javaSort(int[] array){
        long start = System.currentTimeMillis();
        Arrays.sort(array);
        long end = System.currentTimeMillis();
        System.out.println("数组长度："+array.length+", Arrays.sort排序完成，耗时："+(end-start)+"ms");
        return array;
    }
    @Test
    public void testFast(){
        int[] array = RandomUtil.randomIntArray(100000, 100000);
        new QuickSort().testSortAsc(array.clone());
        new ShellSort().testSortAsc(array.clone());
        new MergeSort().testSortAsc(array.clone());
        new HeapSort().testSortAsc(array.clone());
    }


    @Test
    public void testCurrent(){
        int[] array = RandomUtil.randomIntArray(10, 100000);
        new MergeSort().testSortAsc(array);
        System.out.println(Arrays.toString(array));
    }
}
