import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_len_second = time_to_seconds(video_len);
        int pos_second = time_to_seconds(pos);
        int op_start_second = time_to_seconds(op_start);
        int op_end_second = time_to_seconds(op_end);
        
        for(int i=0; i<commands.length; i++) {
            if(pos_second >= op_start_second && pos_second <= op_end_second) {
                pos_second = op_end_second;
            }
            
            if(commands[i].equals("prev")) {
                if(pos_second <= 10) {
                    pos_second = 0;
                } else {
                    pos_second -= 10;
                }
            } else if(commands[i].equals("next")) {
                if(pos_second >= video_len_second - 10) {
                    pos_second = video_len_second;
                } else {
                    pos_second += 10;
                }
            }
            
            if(pos_second >= op_start_second && pos_second <= op_end_second) {
                pos_second = op_end_second;
            }
        }
        
        String time = seconds_to_time(pos_second);
        return time;
    }
    
    public int time_to_seconds(String time) {
        String[] parts = time.split(":");
        int mm = Integer.parseInt(parts[0]);
        int ss = Integer.parseInt(parts[1]);
        int second = mm * 60 + ss;
        return second;
    }
    public String seconds_to_time(int second) {
        int mm = second/60;
        int ss = second%60;
        
        return String.format("%02d:%02d", mm, ss);
    }
}