package top.ccheng.sort;

/**
 * @author ccheng
 * @date 2018/9/17
 * 选择排序
 */
public class SelectSort extends AbstractSort{
    private static long count;

    @Override
    public String getName() {
        return "选择排序";
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
     * 进行选择排序
     * @param array 数组数据
     * @param asc true-升序、false-降序
     */
    private void sort(int[] array, boolean asc){
        count = 0;
        int index;
        for(int i = 0; i < array.length-1; i++){
            index = i;
            for(int j = i+1; j < array.length; j++){
                count++;
                if (asc) {
                    //升序判断
                    if (array[j] < array[index]) {
                        index = j;
                    }
                }else {
                    //降序判断
                    if (array[j] > array[index]) {
                        index = j;
                    }
                }
            }

            if (index != i){
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
    }

    @Override
    public long getCount() {
        return count;
    }
}
