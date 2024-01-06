package bai1de2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlbumManagement {
    Scanner sc=new Scanner(System.in);
    int a;
    public AlbumManagement(){

    }
    public List<Album> initialeAlbumnList(){
        List<Album> album=new ArrayList<Album>();
        do {
            System.out.println("nhap so album tren 2");
            this.a=sc.nextInt();
        } while (a<2);
        System.out.println(a);
        
         for(int i=0;i<a;i++){
            Album al=new Album();
            System.out.println(i);
             al.addal();
             album.add(al);
         }
        return album;
    } 
    public Track getMaxViewCount(){

        return null;
        
    }
}

