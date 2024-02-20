package com.example.appdo.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeRange implements Serializable {

    private Date start;
    private Date end;

    public TimeRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 第一个时间段的结束时间早于或等于第二个时间段的开始时间，即time1.end <= time2.start，表示两个时间段不重叠。
     * 第一个时间段的开始时间晚于或等于第二个时间段的结束时间，即time1.start >= time2.end，表示两个时间段不重叠。
     * 其他情况下，即time1.end > time2.start且time1.start < time2.end，表示两个时间段重叠。
     * @param other
     * @return
     */
    public boolean isOverlap(TimeRange other) {
        return this.end.after(other.start) && this.start.before(other.end);
    }

    public boolean isOverlap2(TimeRange other) {
        return this.end.compareTo(other.start) >= 0 && this.start.compareTo(other.end) <= 0;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date start1 = format.parse("2022-01-01 09:00:00");
        Date end1 = format.parse("2022-03-01 09:30:00");
        TimeRange time1 = new TimeRange(start1, end1);

        Date start2 = format.parse("2023-02-01 09:30:00");
        Date end2 = format.parse("2023-05-01 11:00:00");
        TimeRange time2 = new TimeRange(start2, end2);

        System.out.println("Time range 1: " + start1 + " - " + end1);
        System.out.println("Time range 2: " + start2 + " - " + end2);

        if (time1.isOverlap2(time2)) {
            System.out.println("The time ranges overlap.重叠");
        } else {
            System.out.println("The time ranges do not overlap.不重叠");
        }

    }
}
