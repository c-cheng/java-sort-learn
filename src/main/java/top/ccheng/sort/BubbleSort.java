package top.ccheng.sort;

import top.ccheng.sort.AbstractSort;

/**
 * @author ccheng
 * @date 2018-9-17
 * 冒泡排序
 */
public class BubbleSort extends AbstractSort {
    private static long count = 0;

    @Override
    public String getName() {
        return "冒泡排序";
    }

    @Override
    public void sortAsc(int[] array) {
        sort(array, true);
    }

    @Override
    public void sortDesc(int[] array) {
        sort(array, false);
    }

    /**
     * 进行冒泡排序
     * @param array 数组数据
     * @param asc true-升序、false-降序
     */
    private void sort(int[] array, boolean asc){
        count = 0;
        for(int i = array.length - 1; i >=0; i --){
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            boolean flag = true;
            for(int j = 0; j < i; j++){
                count++;
                int j1 = array[j];
                int j2 = array[j+1];
                if (asc){
                    //升序判断
                    if (j1 > j2){
                        flag = false;
                        array[j] = j2;
                        array[j+1] = j1;
                    }
                }else {
                    //降序判断
                    if (j1 < j2){
                        flag = false;
                        array[j] = j2;
                        array[j+1] = j1;
                    }
                }
            }
            if (flag){
                break;
            }
        }
    }

    @Override
    public long getCount() {
        return count;
    }
}
