package de2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OpportunitiesManagement {
  private List<Opportunity> opportunities = new ArrayList<>();
  List<String> education = null;
  List<String> skills = null;

  public void add() {

    skills = List.of("quet nhanh", "quet kha nhanh");
    education = List.of("Dai hoc", "Van la dai hoc");
    Opportunity opportunity1 = new Opportunity("1", "quet nha biet thu villa", 20, skills, education);

    skills = List.of("lau nhanh", "lau kha nhanh");
    education = List.of("Dai hoc nhung la so 2", "Van la dai hoc nhung la so 2");
    Opportunity opportunity2 = new Opportunity("2", "lau nha biet thu villa", 21, skills, education);

    skills = List.of("rua bat nhanh", "rua bat kha nhanh");
    education = List.of("Dai hoc nhung la so 3", "Van la dai hoc nhung la so 3");
    Opportunity opportunity3 = new Opportunity("3", "rua bat nha biet thu villa", 25, skills, education);

    skills = List.of("giat quan ao nhanh", "giat quan ao kha nhanh");
    education = List.of("Dai hoc nhung la so 4", "Van la dai hoc nhung la so 4");
    Opportunity opportunity4 = new Opportunity("4", "giat quan ao biet thu villa", 23, skills, education);

    skills = List.of("co toilet nhanh", "co toilet kha nhanh");
    education = List.of("Dai hoc nhung la so 5", "Van la dai hoc nhung la so 5");
    Opportunity opportunity5 = new Opportunity("5", "co toilet biet thu villa", 22, skills, education);

    opportunities = List.of(opportunity1, opportunity2, opportunity3, opportunity4, opportunity5);
    this.writeFile();
  }

  public void writeFile() {
    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data_file.dat"));
      for (Opportunity opportunity : opportunities) {
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

  public void readFile() {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data_file.dat"))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] arr = line.split(" ; ");
        Opportunity opportunity = new Opportunity();
        opportunity.setId(arr[0]);
        opportunity.setJobTitle(arr[1]);
        opportunity.setExpectedSalary(Float.parseFloat(arr[2]));
        System.out.println(arr[3]);
        opportunity.setSkills(Arrays.asList(arr[3]));
        opportunity.setEducation(Arrays.asList(arr[4]));
        opportunities.add(opportunity);
      }
      bufferedReader.close();
      System.out.println(opportunities);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void findOpportunitiesByJobTitle() {
    this.readFile();
    System.out.println("Nhap ten job muon tim");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    Opportunity foundOpportunity = opportunities.stream()
        .filter((Opportunity opportunity) -> opportunity.getJobTitle().equals(input)).findAny().orElse(null);
    if (foundOpportunity != null) {
      System.out.println(foundOpportunity);
    } else {
      System.out.println("NOT_FOUND");
    }
    scanner.close();
  }
}
