package com.example.consulting;

public class DoctorTimingAdapter {

    String FromTime;
    String ToTiming;

    public DoctorTimingAdapter(){

    }

    public DoctorTimingAdapter(String fromTime, String toTiming) {
        FromTime = fromTime;
        ToTiming = toTiming;
    }

    public String getFromTime() {
        return FromTime;
    }

    public String getToTiming() {
        return ToTiming;
    }

    public void setFromTime(String fromTime) {
        FromTime = fromTime;
    }

    public void setToTiming(String toTiming) {
        ToTiming = toTiming;
    }
}
