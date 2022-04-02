import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListAlgorithemic {

  public static void main(String[] args) {
    int nums[] = new int[] { -1, -1, -1, -1, -1, -1 };

    int pivoteIndex = pivotIndex(nums);
    System.out.print("中心索引是:" + pivoteIndex + "\n");

    int targetNums[] = new int[] { 1, 3, 5, 6 };
    int target = 7;
    System.out.print("输出：" + searchInsert(targetNums, target));

    int intervals[][] = new int[][] {
      { 1, 2 },
      { 2, 3 },
      { 1, 4 },
      { 4, 6 },
      { 7, 9 },
      { 3, 6 },
    };
    int result[][] = merge(intervals);
    System.out.print("\n");
    for (int i = 0; i < result.length; i++) {
      System.out.print("[" + result[i][0] + "," + result[i][1] + "]");
    }
  }

  /**
   * 寻找数组的中心索引
   * 给你一个整数数组 nums ，请计算数组的 中心下标 。
   * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
   * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
   * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
   * @param sums
   * @return
   */
  public static int pivotIndex(int[] nums) {
    int sum = 0;
    for (int s : nums) {
      sum += s;
    }

    int sumSub = 0;
    for (int i = 0; i < nums.length; i++) {
      if (2 * sumSub == sum - nums[i]) {
        return i;
      }
      sumSub += nums[i];
    }
    return -1;
  }

  /**
   * 搜索插入位置
   * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。请必须使用时间复杂度为 O(log n) 的算法。
   */
  public static int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return i;
      }
    }
    return nums.length;
  }

  /**
   * 合并区间
   * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
   * 1 <= intervals.length <= 104
   * intervals[i].length == 2
   * 0 <= starti <= endi <= 104
   * @param intervals
   * @return
   */
  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> resultList = new ArrayList<>();
    int temp[] = intervals[0];
    for (int i = 0; i < intervals.length; i++) {
      if (temp[1] >= intervals[i][0]) {
        temp[1] = Math.max(temp[1], intervals[i][1]);
      } else {
        resultList.add(temp);
        temp = intervals[i];
      }
    }
    resultList.add(temp);
    return resultList.toArray(new int[resultList.size()][2]);
  }
}
