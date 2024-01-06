package bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.crypto.spec.GCMParameterSpec;

public class Opportunity {
    String Id;
    String jobTitle;
    float expectedSalary;
    List<String> skills=new ArrayList<String>();
    List<String> education=new ArrayList<String>();
    int a;
    int d;

    public Opportunity(){

    }
    public List<String> getEducation() {
        return education;
    }
    public void setEducation(List<String> education) {
        this.education = education;
    }
    public float getExpectedSalary() {
        return expectedSalary;
    }
    public void setExpectedSalary(float expectedSalary) {
        this.expectedSalary = expectedSalary;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }public String getJobTitle() {
        return jobTitle;
    }public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }public List<String> getSkills() {
        return skills;
    }public void setSkills(List<String> skills) {
        this.skills = skills;
    }
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public void input() throws IOException {
        Scanner sc= new Scanner(System.in);
           System.out.println("moi nhap id");
           Id=bf.readLine();
         do {
            System.out.println("moi nhâp id co tren 10 ki tu");
            jobTitle=bf.readLine();
         } while (jobTitle.length()<=10);
         do {
            System.out.println("moi nhâp expectedSalary tren 20 ki tu");
            expectedSalary=Float.parseFloat(bf.readLine());
         } while (expectedSalary<=20);
         
         do {
            System.out.println("moi nhap so skill phai tren 2");
            a=sc.nextInt();
           } while (a<2);
         String[] c= new String[a];
         for(int i=0;i<a;i++){
             c[i]=sc.next();
             this.skills.add(c[i]);
         }

         do {
            System.out.println("moi nhap so e phai tren 1");
            d=sc.nextInt();
           } while (d<1);
         String[] h= new String[a];
         for(int i=0;i<d;i++){
             h[i]=sc.next();
             education.add(h[i]);
         }   
        
    }
    

}
