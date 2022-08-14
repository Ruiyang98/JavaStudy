package sort;


public class HeapSort2 {
    public static void main(String[] args){
        String[] sort = new String[]{"S","O","R","T","E","X","A","M","P","L","E"};
        buildMaxHeap(sort);
        heapSort(sort);
        print(sort);
    }

    /**
     * 构建堆
     * @param data
     */
    private static void buildMaxHeap(String[] data) {
        int startIndex = getParentIndex(data.length - 1);
        for(int i = startIndex; i > 0; i--) {
            maxHeap(data, data.length, i);
        }
    }

    /**
     * 调整为最大堆
     * @param data
     * @param heapSize
     * @param index
     */
    private static void maxHeap(String[] data, int heapSize, int index) {
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if(left < heapSize && data[largest].compareTo(data[left]) < 0) {
            largest = left;
        }
        if(right < heapSize && data[largest].compareTo(data[right]) < 0) {
            largest = right;
        }

        // 交换位置
        if(largest != index) {
            swap(data, largest, index);
            maxHeap(data, heapSize, largest);
        }
    }


    /**
     * 排序操作
     * @param data
     */
    private static void heapSort(String[] data) {
        for(int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            maxHeap(data, i, 0);
        }
    }

    private static void print(String[] data) {
        for(int i=0; i<data.length; i++){
            System.out.print(data[i]+",");
        }
    }

    private static int getChildRightIndex(int index) {
        return (index << 1) + 2;
    }

    private static int getChildLeftIndex(int index) {
        return (index << 1) + 1;
    }

    private static int getParentIndex(int index) {
        return (index - 1) >> 1;
    }

    private static void swap(String[] data, int i, int j) {
        String tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
