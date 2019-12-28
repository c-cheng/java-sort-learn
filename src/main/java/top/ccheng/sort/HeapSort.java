package top.ccheng.sort;

import javax.xml.parsers.FactoryConfigurationError;

/**
 * @author ccheng
 * @date 2018/9/17
 */
public class HeapSort extends AbstractSort {
    private static long count = 0;

    @Override
    public String getName() {
        return "堆 排 序";
    }

    @Override
    public void sortAsc(int [] array){
        sort(array, true);
    }

    @Override
    public void sortDesc(int[] array) {
        sort(array, false);
    }

    @Override
    public long getCount() {
        return count;
    }

    /**
     * 进行堆排序
     * @param array 数组数据
     * @param asc true-大顶堆、false-小顶堆
     */
    private void sort(int[] array, boolean asc){
        count = 0;
        int len = array.length;

        //首次构建堆，从第一个非叶子结点从下至上，从右至左调整结构
        for(int i=len/2-1;i>=0;i--){
            buildHeap(array, i, len-1, asc);
        }

        //开始排序
        for (int j = len-1; j > 0; j--){
            //交换堆顶元素和最后一个元素
            swap(array, 0, j);
            //重新调整堆
            buildHeap(array, 0, j-1, asc);
        }
    }

    /**
     * 将数组指定下标范围中的数据调整为堆
     * @param array 数组
     * @param startIndex 指定开始下标
     * @param endIndex 指定结束下标
     * @param asc true-大顶堆、false-小顶堆
     */
    private static void buildHeap(int[] array, int startIndex, int endIndex, boolean asc){
        //k保存正在判断的节点
        int k=startIndex;
        //temp保存正在判断的节点的值
        int temp = array[startIndex];

        //如果当前k节点的子节点存在
        while(k*2+1<=endIndex){
            count++;
            if (asc){
                //大顶堆判断

                //默认最大值节点为k节点的左子节点
                int maxIndex=k*2+1;
                //k节点的右子节点存在，并且右子节点的值比左子节点的值大
                if(maxIndex < endIndex && array[maxIndex] < array[maxIndex+1]){
                    //maxIndex指向k的右子节点，总是记录较大子节点的索引
                    maxIndex++;
                }

                //如果temp小于其较大的子节点的值
                if(temp < array[maxIndex]){
                    //将较大子节点的值赋给k节点
                    array[k] = array[maxIndex];
                    //将maxIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=maxIndex;
                }else{
                    break;
                }
            }else {
                //小顶堆判断

                //默认最大值节点为k节点的左子节点
                int minIndex=k*2+1;
                //k节点的右子节点存在，并且右子节点的值比左子节点的值小
                if(minIndex < endIndex && array[minIndex] > array[minIndex+1]){
                    //minIndex指向k的右子节点，总是记录较小子节点的索引
                    minIndex++;
                }

                //如果temp大于其较小的子节点的值
                if(temp > array[minIndex]){
                    //将较小子节点的值赋给k节点
                    array[k] = array[minIndex];
                    //将minIndex赋予k，开始while循环的下一次循环，重新保证k节点的值小于其左右子节点的值
                    k=minIndex;
                }else{
                    break;
                }
            }
        }

        //将temp值放到最终的位置
        array[k] = temp;
    }

    /**
     * 交换数组两个下标对应的数据
     * @param a 数组
     * @param i 需要交换的下标
     * @param j 需要交换的下标
     */
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
