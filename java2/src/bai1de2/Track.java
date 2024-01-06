package bai1de2;

import java.util.Scanner;

public class Track {
  String name;
   int viewCount;
    public Track(){

    }
    public Track(String name){
      this.name=name;
      
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public void addtracks(){
        Scanner sc =new Scanner(System.in);
        System.out.println("moi nap name:");
        name=sc.next();
        System.out.println("moi nhap view");
        viewCount=sc.nextInt();
    }
}
