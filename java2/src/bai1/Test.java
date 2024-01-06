package bai1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    List<Opportunity> Opp=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        opportunities o =new opportunities();
        
        o.add();
        o.writeFile();
       

    }
   
}
