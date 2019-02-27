/**
 * 查找第一个值等于给定值的元素
 *
 * 查找最后一个值等于给定值的元素
 *
 * 查找第一个大于等于给定值的元素
 *
 * 查找最后一个小于等于给定值的元素
 */
public class BinarySearch {

    /**
     * 查找第一个值等于给定值的元素
     * @param a 有序数组
     * @param item 查找元素
     * @param n 数据规模
     * @return 给定元素下标，没找到返回-1
     */
    public int findFirstEqual(int[] a,int item, int n){
        int low = 0;
        int high = n-1;
        if(low==high){
            return item == a[low] ? low : -1;
        }
        while(low<=high){
            int mid = low + ((high - low) >> 2);
            if(a[mid]<item){
                low = mid + 1;
            } else if(a[mid] > item){
                high = mid - 1;
            }else{
                if(mid == 0 || a[mid - 1]!=item) return mid;
                high = mid - 1;
            }
        }
        return -1;

    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param a 有序数组
     * @param item 查找元素
     * @param n 数据规模
     * @return 给定元素下标，没找到返回-1
     */
    public int findLastEqual(int[] a, int item, int n){
        int low = 0;
        int high = n-1;
        if(low == high){
            return item == a[low]? low: -1;
        }
        while(low<=high){
            int mid = low + ((high-low)>>2);
            if(a[mid]<item){
                low = mid + 1;
            } else if(a[mid] > item){
                high = mid - 1;
            }else{
                if(mid == n-1 || a[mid+1]!=item) return mid;
                low = mid + 1;
            }
        }
        return -1;

    }

    /**
     * 查找第一个值大于等于给定值的元素
     * @param a 有序数组
     * @param item 查找元素
     * @param n 数据规模
     * @return 给定元素下标，没找到返回-1
     */
    public int findFirstGe(int[] a, int item, int n){
        int low = 0;
        int high = n -1;
        if(low==high) return a[low]==item?low:-1;
        while(low<=high){
            int mid = low + ((high - low )>>2);
            if(a[mid]<item){
                low = mid + 1;
            }else{
                if(mid == 0 || a[mid-1]<item) return mid;
                high = mid -1;
            }
        }
        return -1;
    }
    /**
     * 查找最后一个值小于等于给定值的元素
     * @param a 有序数组
     * @param item 查找元素
     * @param n 数据规模
     * @return 给定元素下标，没找到返回-1
     */
    public int findLastLe(int[] a, int item, int n){
        int low = 0;
        int high = n - 1;
        if(low == high) return a[low] == item ? low : -1;
        while(low<=high){
            int mid = low + ((high - low) >> 2);
            if(a[mid]<=item){
                if(mid == n-1 || a[mid+1] > item) return mid;
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
