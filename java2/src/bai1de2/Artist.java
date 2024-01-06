package bai1de2;

import java.util.Scanner;

public class Artist {
    String name;
    public Artist(){

    }
    public Artist(String name){
      this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addname(){
       Scanner sc=new Scanner(System.in);
       System.out.println("moi nhap name");
       name=sc.next();
    }
}
