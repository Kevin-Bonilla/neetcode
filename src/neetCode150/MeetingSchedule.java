package neetCode150;

/*
 * Meeting Schedule
Solved

Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.

Example 1:

Input: intervals = [(0,30),(5,10),(15,20)]

Output: false

Explanation:

    (0,30) and (5,10) will conflict
    (0,30) and (15,20) will conflict

Example 2:

Input: intervals = [(5,8),(9,15)]

Output: true

Note:

    (0,8),(8,10) is not considered a conflict at 8

Constraints:

    0 <= intervals.length <= 500
    0 <= intervals[i].start < intervals[i].end <= 1,000,000

 */

import java.util.Comparator;
import java.util.List;

public class MeetingSchedule {
    public boolean canAttendMeetings(List<Interval> intervals) {
        //first we want to sort by start times
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        //int prevStart = 0; //not needed
        int prevEnd = 0;
        //enhanced for loop to ensure intervals was sorted correctly
        for(Interval i : intervals){
            int curStart = i.start;
            int curEnd = i.end; 
            //System.out.println("start: " + curStart + " end: " + curEnd); //debug

            if(curStart < prevEnd){ //current start is before last interval end 
                return false;
            }

            prevEnd = curEnd; //updating value for next interval
        }
        
        //if we make it to end we found no conflicts
        return true;
    }
}
