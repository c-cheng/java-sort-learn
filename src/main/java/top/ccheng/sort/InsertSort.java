package top.ccheng.sort;

/**
 * @author ccheng
 * @date 2018/9/17
 * 插入排序
 */
public class InsertSort extends AbstractSort{
    private static long count = 0;

    @Override
    public String getName() {
        return "插入排序";
    }

    @Override
    public void sortAsc(int[] array){
        sort(array, true);
    }

    @Override
    public void sortDesc(int[] array) {
        sort(array, false);
    }

    /**
     * 进行插入排序
     * @param array 数组数据
     * @param asc true-升序、false-降序
     */
    private void sort(int[] array, boolean asc) {
        count = 0;
        int j;
        int temp;
        for(int i = 1; i < array.length; i++){
            temp = array[i];
            if (asc){
                //升序判断
                for(j = i - 1; j >= 0 && array[j] > temp; j--){
                    count++;
                    array[ j + 1] = array[j];
                }
            }else {
                //降序判断
                for(j = i - 1; j >= 0 && array[j] < temp; j--) {
                    count++;
                    array[j + 1] = array[j];
                }
            }
            array[j+1] = temp;
        }
    }

    @Override
    public long getCount() {
        return count;
    }

}
