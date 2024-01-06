package bai1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class opportunities {
    Opportunity opti0 =new Opportunity();
    Opportunity opti1 =new Opportunity();
    Opportunity opti2 =new Opportunity();
    Opportunity opti3 =new Opportunity();
    Opportunity opti4 =new Opportunity();
    List<Opportunity> op =new ArrayList<Opportunity>();
    public opportunities(){

    }
    public List<Opportunity> getOp() {
        return op;
    }
    public void add(){
        try {
            opti0.input();
            opti1.input();
            opti2.input();
            opti3.input();
            opti4.input();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        op.add(opti0);
        op.add(opti1);
        op.add(opti2);
        op.add(opti3);
        op.add(opti4);
        
    }

    public void writeFile() {
        try {
          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D://hocjava//java2/src//bai1//data_file.dat"));
          for (Opportunity opportunity : op) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(opportunity.getId()).append(" ; ").append(opportunity.getJobTitle()).append(" ; ")
                .append(opportunity.getExpectedSalary()).append(" ; ")
                .append(opportunity.getSkills()).append(" ; ").append(opportunity.getEducation());
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.newLine();
          }
          bufferedWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
}
