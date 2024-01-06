package tap;

import java.util.HashMap;

public class ShareData {
  private HashMap<String, String> weekend = new HashMap<>();
  private String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
  private String aDay;
  private boolean bool = true;

  public String getaDay() {
    return aDay;
  }

  public boolean isBool() {
    return bool;
  }

  public void setBool(boolean bool) {
    this.bool = bool;
  }

  public String[] getDays() {
    return days;
  }

  public void setDays(String[] days) {
    this.days = days;
  }

  public HashMap<String, String> getWeekend() {
    return weekend;
  }

  public void setWeekend(HashMap<String, String> weekend) {
    this.weekend = weekend;
  }

  public void setaDay(String aDay) {
    this.aDay = aDay;
  }

  public ShareData() {
    weekend.put("Monday", "Thu 2");
    weekend.put("Tuesday", "Thu 3");
    weekend.put("Wednesday", "Thu 4");
    weekend.put("Thursday", "Thu 5");
    weekend.put("Friday", "Thu 6");
    weekend.put("Saturday", "Thu 7");
    weekend.put("Sunday", "Chu nhat");
  }

}