/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int totalMeetings = intervals.size();
        int[] start = new int[totalMeetings];
        int[] end = new int[totalMeetings];
        for (int i = 0; i < totalMeetings; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int max = 0;
        int openRooms = 0;
        while (i < totalMeetings && j < totalMeetings) {
            if (start[i] < end[j]) {
                openRooms++;
                i++;
            } else if (start[i] > end[i]) {
                openRooms--;
                j++;
            } else {
                i++;
                j++;
            }
            max = Math.max(openRooms, max);
        }
        return max;
    }
}


/*
idea: 
1) when an end time comes around a room closes
2) when a start time hits a room opens
variables:
    maxRooms - max rooms open in one
    
psuedo:
    

    
*/