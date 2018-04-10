package joseph.leetcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Solutions sol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sol = new Solutions();
        //List<String> ans = sol.restoreIpAddresses2("0000");
        //int[] input = {-429432,-429404,-429332,-429329,-429319,-429310,-429277,-429266};
        //int[] input = {1,3,5,4,7};
        //int ans = sol.findLengthOfLCIS(input);
        //List<Integer> ans = sol.selfDividingNumbers(1,22);
        //Log.v("joseph", String.valueOf(ans));
        MyCalendar obj = new MyCalendar();
        boolean param_1 = obj.book(23, 32);
        boolean param_2 = obj.book(26, 31);
        boolean param_3 = obj.book(6, 14);
        boolean param_4 = obj.book(0, 7);
        boolean param_5 = obj.book(21, 30);
        boolean param_6 = obj.book(26, 31);

        Log.v("joseph", Boolean.toString(param_1) + Boolean.toString(param_2) + Boolean.toString(param_3) + Boolean.toString(param_4) + Boolean.toString(param_5) + Boolean.toString(param_6));
    }
}
