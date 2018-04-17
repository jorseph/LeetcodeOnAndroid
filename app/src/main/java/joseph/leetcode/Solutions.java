package joseph.leetcode;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Joseph_Hsu on 2018/4/3.
 */

public class Solutions {
    private final static String TAG = "Solutions";
    // nums = [2, 7, 11, 15] and target = 9
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    //255255255255 => 255.255.255.255
    //25525511135 => 255.255.11.135, 255.255.111.35
    //25525511 => 255.255.110.000 => 255.255.1.1
    //255255 => 255.255.000.000 => 25.5.2.55
    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<String>();
        if(s.length() > 12 || s.length() < 4) return ans;
        DBS(0, s, "", ans);
        return ans;

    }

    public void DBS(int count, String s, String temp, List<String> res) {
        if(count == 4) {
            if(s.isEmpty()) res.add(temp);
        }

        for(int i = 1; i < 4; i++) {
            if(s.length() < i) break;
            int val = Integer.parseInt(s.substring(0, i));
            if(val > 255 || i != String.valueOf(val).length()) continue;
            DBS(count+1, s.substring(i), temp + s.substring(0, i) + (count == 3 ? "":"."), res);
        }

    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> ans = new ArrayList<String>();
        if(s.length() > 12 || s.length() < 4) return ans;
        for(int a = 1; a < 4; a++) {
            for(int b = 1; b < 4; b++) {
                for(int c = 1; c < 4; c++) {
                    for(int d = 1; d < 4; d++) {
                        if(s.length() == a + b + c + d) {
                            String A = s.substring(0, a);
                            //Log.v(TAG, "The A is " + A);
                            String B = s.substring(a, a + b);
                            //Log.v(TAG, "The B is " + B);
                            String C = s.substring(a + b, a + b + c);
                            //Log.v(TAG, "The C is " + C);
                            String D = s.substring(a + b + c);
                            //Log.v(TAG, "The D is " + D);
                            int A_val = Integer.parseInt(s.substring(0, a));
                            int B_val = Integer.parseInt(s.substring(a, a + b));
                            int C_val = Integer.parseInt(s.substring(a + b, a + b + c));
                            int D_val = Integer.parseInt(s.substring(a + b +c));
                            if(A_val <= 255 & B_val <= 255 & C_val <= 255 & D_val <= 255) {
                                String temp = String.valueOf(A_val) + "." + String.valueOf(B_val) + "." + String.valueOf(C_val) + "." + String.valueOf(D_val);
                                if(temp.length() == s.length() + 3) ans.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int cur=1,ans = 1;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i+1] > nums[i]) {
                cur++;
                ans = Math.max(ans,cur);
            } else {
                cur = 1;
            }
        }
        return ans;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<Integer>();
        int temp;
        for(int i = left; i <= right; i++) {
            if(isSelfDividingNum(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDividingNum(int num) {
        int n = num;
        while(n > 0) {
            int temp = n % 10;
            if(temp == 0) return false;
            else if(num%temp != 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int ans = 1;
        int temp = 1;
        int start_index = 0;
        int i = 0;
        if(nums.length == 0) return 0;
        while (true){
            if(start_index + i >= nums.length - 1) break;
            if(nums[start_index+i+1] > nums[start_index+i]) {
                temp++;
                if(start_index + i == nums.length - 2) {
                    if(temp > ans) {
                        ans = temp;
                    }
                }
                i++;

            } else if(nums[start_index+i+1] < nums[start_index+i]) {
                if(temp > ans) {
                    ans = temp;
                }
                temp = 1;
                start_index = start_index + i + 1;
                i = 0;
            } else {
                i++;
            }
        }
        return ans;
    }

    // ****
    // ******//
    List<String> ans;
    boolean[] temp;
    public List<String> readBinaryWatch(int num) {
        temp = new boolean[10];
        ans = new ArrayList<String>();
        arrage(num);
        return ans;

    }

    public void arrage(int num) {
        if(num == 0) {
            ans.add(readTime(temp));
        } else {
            for (int i = 0; i < 10; i++) {
                if (!temp[i]) {
                    temp[i] = true;
                    num--;
                    arrage(num);
                    temp[i] = false;
                    num++;
                }
            }
        }
    }

    public String readTime(boolean[] time) {
        String s_time = "";
        int min = 0, hour = 0;
        for(int i = 0; i < time.length; i++) {
            if(i < 4) {
                hour += 1 << i;
            } else {
                if(time[i]) {
                    min += 1 << (i - 4);
                }
            }
        }
        s_time = String.valueOf(hour) + ":" + String.valueOf(min);
        return s_time;
    }

    public int searchInsert2(int[] nums, int target) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == nums.length - 1 & ans == 0) {
                ans = nums.length;
            }
            if(nums[i] >= target ) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (right - left)/2 + left;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int maxArea(int[] height) {
        int ans = 0, right = height.length - 1, left = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                ans = Math.max(ans, height[left]*(right - left));
                left++;
            } else {
                ans = Math.max(ans, height[right]*(right - left));
                right--;
            }
        }
        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int temp_diff = Integer.MAX_VALUE;

        if(nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = target - sum;
                if(Math.abs(temp_diff) > Math.abs(diff)) {
                    temp_diff = diff;
                    ans = sum;
                }

                if(sum < target) left++;
                else if(sum > target) right--;
                else return sum;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if(nums == null || nums.length < 3) {
            return ans;
        }  else if(nums.length == 3) {
            if(nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[0]);
                temp.add(nums[1]);
                temp.add(nums[2]);
                ans.add(temp);
                return ans;
            }
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                //temp.clear();
                List<Integer> temp = new ArrayList<Integer>();
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) left++;
                else if(sum > 0) right--;
                else {
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    while(nums[left] == nums[left + 1] & (left + 1) < right) {
                        left++;
                    }

                    while(nums[right] == nums[right - 1] & (right - 1) > left) {
                        right--;
                    }
                    left++;
                    right--;

                    while(i < nums.length - 2 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }
        }
        return ans;
    }
}
