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
}
