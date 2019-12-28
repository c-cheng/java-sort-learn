package top.ccheng.sort;

/**
 * @author ccheng
 * @date 2018/9/17
 */
public class MergeSort extends AbstractSort {
    private static long count = 0;

    @Override
    public String getName() {
        return "归并排序";
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
     * 进行归并排序
     * @param array 数组数据
     * @param left 左下标
     * @param right 右下标
     * @param asc true-升序、false-降序
     */
    private void sort(int[] array, int left, int right, boolean asc){
        count = 0;
        if (left < array.length && right < array.length && left < right){
            int middle = (left+right)/2;
            //将数组左边部分进行排序
            sort(array, left, middle, asc);
            //将数组右边部分进行排序
            sort(array, middle+1, right, asc);
            //将排好序的左右两边进行合并
            merge(array, left, middle, right, asc);
        }
    }

    private void merge(int[] array, int left, int middle, int right, boolean asc){
        //临时数组，用来存放合并数据
        int[] temp = new int[right-left+1];
        int tempIndex = 0;
        //左右两边指针下标
        int l=left,r=middle+1;

        if (asc) {
            //升序判断

            //将两边较小的数字整理出来
            while (l <= middle && r <= right) {
                count++;
                if (array[l] < array[r]) {
                    temp[tempIndex++] = array[l++];
                } else {
                    temp[tempIndex++] = array[r++];
                }
            }
        }else {
            //降序判断

            //将两边较小的数字整理出来
            while (l <= middle && r <= right) {
                count++;
                if (array[l] > array[r]) {
                    temp[tempIndex++] = array[l++];
                } else {
                    temp[tempIndex++] = array[r++];
                }
            }
        }

        //如果左边还有剩余数字，整理到临时数组
        while (l <= middle){
            count++;
            temp[tempIndex++] = array[l++];
        }

        //如果右边还有剩余数字，整理到临时数组
        while (r <= right){
            count++;
            temp[tempIndex++] = array[r++];
        }

        //将临时数组中整理好的数据替换到原数组
        for (int i = 0 ; i < temp.length; i ++){
            count++;
            array[left+i] = temp[i];
        }
    }
}
