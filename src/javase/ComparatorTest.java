package javase;

import java.util.Arrays;
import java.util.Comparator;

/*
 重写比较器，两种写法，可以配合下面的4种降序写法：
 1、匿名内部类，重写compare方法
 2、lambda表达式

 调整为降序：
 1、return b-a，存在溢出问题，不推荐
 2、return Integer.compare(b,a)
 3、if(a > b) return -1，后面省略
 4、三目运算符简化if条件，return  a < b ? -1 : 1
 5、补充：两列都降序 return a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]
 */


public class ComparatorTest {
    public static void main(String[] args) {

        // 这里必须用封装类，否则lambda表达式会报错。
        Integer[] nums = new Integer[]{1, 3, 4, 2, 6};

        // 打印用Arrays.toString(nums)
        // 正常升序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));


        // 法1：从大到小降序，不推荐的写法，存在溢出问题
        Arrays.sort(nums, (a, b) -> b - a);
        System.out.println(Arrays.toString(nums));

        // 法2：推荐，和上面等价。
        Arrays.sort(nums, (a, b) -> Integer.compare(b, a));
        System.out.println(Arrays.toString(nums));

        // 法3：降序
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // return o2 - o1; // 不推荐
                return Integer.compare(o2, o1);
            }
        });
        System.out.println(Arrays.toString(nums));


        int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        // 法1，第0列升序，第1列降序
        // 打印二维数组的方法，还有一种就是普通for循环打印
        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];

        });
        for(int[] array : arr) {
            System.out.println(Arrays.toString(array));
        }

        // 法2，两列都降序
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for(int[] array : arr) {
            System.out.println(Arrays.toString(array));
        }

        // 法3，推荐
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]));

        // 法4，右端点升序
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) {
                    return 1;
                } else if (a[1] < b[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("右端点排序");
        for(int[] array : arr) {
            System.out.println(Arrays.toString(array));
        }

    }
}
