package dateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Time {

//    public static void main(String[] args) {
//        dateTime.Time time = new dateTime.Time("6/11/2018 1:30");
//        time.calculatePastTime();
//        System.out.println(time.pastTimeToString());
//    }

    public Date date = null;
    public int pastTimeInMinutes = 0;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public Time(String date) {
        try {
            setDate(getSimpleDateFormat().parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPastTimeInMinutes() {
        return pastTimeInMinutes;
    }

    public void setPastTimeInMinutes(int pastTimeInMinutes) {
        this.pastTimeInMinutes = pastTimeInMinutes;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void calculatePastTime(){
        long currentTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long diff = currentTime - getDate().getTime();
        setPastTimeInMinutes((int) (diff / 1000 / 60));
    }

    public String pastTimeToString(){
        if (getPastTimeInMinutes() >= 525600){
            return getPastTimeInMinutes() / 60 / 24 / 365 + " лет назад";
        }

        if (getPastTimeInMinutes() >= 1440){
            return getPastTimeInMinutes() / 60 / 24 + " дней назад";
        }

        if (getPastTimeInMinutes() >= 60){
            return getPastTimeInMinutes() / 60 + " часов назад";
        } else{
            return getPastTimeInMinutes() + " минут назад";
        }
    }
}
