package de2;

import java.util.List;

public class Opportunity {
  private String id;
  private String jobTitle;
  private float expectedSalary;
  private List<String> skills;
  private List<String> education;

  public Opportunity() {
  }

  public Opportunity(String id, String jobTitle, float expectedSalary, List<String> skills, List<String> education) {
    this.id = id;
    this.jobTitle = jobTitle;
    this.expectedSalary = expectedSalary;
    this.skills = skills;
    this.education = education;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getJobTitle() {
    return this.jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    if (jobTitle.length() < 10) {
      throw new Error("Job title must contain at least 10 characters");
    }
    this.jobTitle = jobTitle;
  }

  public float getExpectedSalary() {
    return this.expectedSalary;
  }

  public void setExpectedSalary(float expectedSalary) {
    if (expectedSalary < 20) {
      throw new Error("Expected Salary must be greater than 20");
    }
    this.expectedSalary = expectedSalary;
  }

  public List<String> getSkills() {
    return this.skills;
  }

  public void setSkills(List<String> skills) {
    // if (skills.size() < 2) {
    // throw new Error("Must include at least 2 skills");
    // }
    this.skills = skills;
  }

  public List<String> getEducation() {
    return this.education;
  }

  public void setEducation(List<String> education) {
    // if (education.size() < 1) {
    // throw new Error("Must include at least 1 education");
    // }
    this.education = education;
  }

  @Override
  public String toString() {
    return "Oppotunity [id=" + id + ", jobTitle=" + jobTitle + ", expectedSalary=" + expectedSalary + ", skills="
        + skills + ", education=" + education + "]";
  }
}
