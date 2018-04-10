package joseph.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph_Hsu on 2018/4/10.
 */

class MyCalendar {
    private List<Integer> booktime;
    public MyCalendar() {
        booktime = new ArrayList<Integer>();
    }

    public boolean book(int start, int end) {

        if(booktime.size() == 0) {
            booktime.add(start);
            booktime.add(end);
            return true;
        }

        for(int i = 0; i < booktime.size(); i+=2) {
            if (!check(start, end, booktime.get(i), booktime.get(i + 1))) {
                return false;
            }
        }
        booktime.add(start);
        booktime.add(end);
        return true;
    }

    private boolean check(int start, int end, int book_s, int book_e) {
        if((book_s >= start & book_s < end) || (book_e > start & book_e <= end) || (book_s <= start & book_e >= end )) {  // return false
            return false;
        } else {
            return true;
        }
    }
}
