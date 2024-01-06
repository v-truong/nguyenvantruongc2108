package fillllll;

public class Test {
  public static void main(String[] args) {
    OpportunitiesManagement opportunitiesManagement = new OpportunitiesManagement();
    System.out.println("Write File: ");
    opportunitiesManagement.add();
    System.out.println("Read File: ");
    opportunitiesManagement.readFile();
    System.out.println("Find Opportunities By Job Title: ");
    opportunitiesManagement.findOpportunitiesByJobTitle();
  }
}
