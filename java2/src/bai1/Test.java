package bai1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    List<Opportunity> Opp=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int min = 100000;
        int max = 999999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        System.out.println(randomNumber);
    }

    }
