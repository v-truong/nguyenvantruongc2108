package bai1de2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

public class Album {
    Scanner sc =new Scanner(System.in);
    String name;
    List<Track> tracks=new ArrayList<>();
    List<Artist> musicians=new ArrayList<>();
    public Album(){
       
    }
    public Album(String name, List<Track> tracks,List<Artist> musicians){
     this.name=name;
     this.tracks=tracks;
     this.musicians=musicians;
    }
    public List<Artist> getMusicians() {
        return musicians;
    }
    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Track> getTracks() {
        return tracks;
    }
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
    public void addal(){
        System.out.println("moi nhap name ALBUM");
        name=sc.next();
        System.out.println("moi nhap số tracks");
        int d=sc.nextInt();
        
        for(int i=0;i<d;i++){
           Track track=new Track();
           track.addtracks();
           tracks.add(track);
        }
        System.out.println("moi nhap số  Artist");
        int k=sc.nextInt();
        
        for(int i=0;i<k;i++){
            Artist ar=new Artist();
           ar.addname();
           musicians.add(ar);
        }

    }
}
