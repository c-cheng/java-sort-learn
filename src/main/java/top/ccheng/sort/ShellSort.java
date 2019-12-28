package top.ccheng.sort;

/**
 * @author ccheng
 * @date 2018/9/17
 */
public class ShellSort extends AbstractSort {
    private static long count;

    @Override
    public String getName() {
        return "希尔排序";
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
     * 进行希尔排序（实际为改进版插入排序）
     * @param array 数组数据
     * @param asc true-升序、false-降序
     */
    private void sort(int[] array, boolean asc) {
        count = 0;
        int temp;
        int j;
        //第一层循环是增量由 array.length/2 减少到1
        for(int increment = array.length / 2; increment > 0; increment /=2 ){
            //第二层循环是根据增量将数组分组后，循环将每一组执行插入排序
            for (int x = 0; x < increment; x++){
                //第三、四层循环实际是一个插入排序
                for(int i = x+increment; i < array.length; i += increment){
                    temp = array[i];
                    if (asc) {
                        //升序判断
                        for (j = i - increment; j >= 0 && array[j] > temp; j -= increment) {
                            count++;
                            array[j + increment] = array[j];
                            array[j] = temp;
                        }
                    }else {
                        //降序判断
                        for (j = i - increment; j >= 0 && array[j] < temp; j -= increment) {
                            count++;
                            array[j + increment] = array[j];
                            array[j] = temp;
                        }
                    }

                }
            }
        }
    }
    @Override
    public long getCount() {
        return count;
    }
}
