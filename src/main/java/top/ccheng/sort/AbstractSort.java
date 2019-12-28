package top.ccheng.sort;

/**
 * @author ccheng
 * @date 2018/9/17
 */
public abstract class AbstractSort {

    public int[] testSortAsc(int[] array){
        long start = System.currentTimeMillis();
        sortAsc(array);
        long end = System.currentTimeMillis();
        System.out.println("数组长度："+array.length+","+getName()+"完成，耗时："+(end-start)+"ms，循环次数："+getCount());
        return array;
    }

    public int[] testSortDesc(int[] array){
        long start = System.currentTimeMillis();
        sortDesc(array);
        long end = System.currentTimeMillis();
        System.out.println("数组长度："+array.length+","+getName()+"完成，耗时："+(end-start)+"ms，循环次数："+getCount());
        return array;
    }

    public abstract String getName();

    public abstract void sortAsc(int[] array);

    public abstract void sortDesc(int[] array);

    public abstract long getCount();
}
