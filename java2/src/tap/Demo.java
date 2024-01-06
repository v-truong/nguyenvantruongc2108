package tap;

public class Demo {
  public static void main(String[] args) {
    ShareData shareData = new ShareData();
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (shareData) {
          int random = (int) Math.floor(Math.random() * shareData.getDays().length);
          String day = shareData.getDays()[random];
          shareData.setaDay(day);
          for (int i = 0; i < 3; i++) {
            try {
              if (shareData.isBool() == true) {
                System.out.println(shareData.getaDay());
                shareData.notifyAll();
                shareData.setBool(false);
              } else {
                shareData.wait();
              }
            } catch (Exception e) {
              System.out.println(e);
            }

          }
        }
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (shareData) {
          for (int i = 0; i < 3; i++) {
            try {
              if (shareData.isBool() == true) {
                shareData.wait();
              } else {
                System.out.println(shareData.getWeekend().get(shareData.getaDay()));
                shareData.notifyAll();
                shareData.setBool(true);
              }
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });
    thread1.run();
    thread2.run();
  }
}
