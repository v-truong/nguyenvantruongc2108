import 'dart:io';
class Employee {
  String id;
  String name;
  int workingDays;
  double dailySalary;
  Employee(this.id, this.name, this.workingDays, this.dailySalary);
    String get myVariable {
    return _myVariable;
  }
}

void main() {
  List<Employee> employees = [];
  bool continueProgram = true;
  while (continueProgram) {
    print("Enter your choice:");
    print("1. Input");
    print("2. Sort");
    print("3. Analyze");
    print("4. Find");
    print("5. Exit");
    String choice = stdin.readLineSync()!;
    switch (choice) {
      case '1':
        inputEmployees(employees);
        break;
      case '2':
        sortEmployeesByName(employees);
        break;
      case '3':
        analyzeEmployees(employees);
        break;
      case '4':
        findEmployeesWithHighestSalary(employees);
        break;
      case '5':
        continueProgram = false;
        break;
      default:
        print("Invalid choice. Please try again.");
    }
    if (continueProgram) {
      String response;
      do {
        print("Do you want to continue? (y/n)");
        response = stdin.readLineSync()!.toLowerCase();
      } while (response != 'y' && response != 'n');
      if (response == 'n') {
        continueProgram = false;
      }
    }
  }
}

void inputEmployees(List<Employee> employees) {
  print("Enter the total number of employees:");
  int totalEmployees = int.parse(stdin.readLineSync()!);
  for (int i = 0; i < totalEmployees; i++) {
    String id, name;
    int workingDays;
    double dailySalary;
    int employeeIndex = i + 1; 
    print("Inputting details for employee $employeeIndex:");
    do {
      print("Enter ID (must be 6 characters):");
      id = stdin.readLineSync()!;
    } while (id.length != 6);
    do {
      print("Enter name (from 5 to 100 characters):");
      name = stdin.readLineSync()!;
    } while (name.length < 5 || name.length > 100);
    do {
      print("Enter working days (from 1-31):");
      workingDays = int.parse(stdin.readLineSync()!);
    } while (workingDays < 1 || workingDays > 31);
    do {
      print("Enter daily salary (from 10-100):");
      dailySalary = double.parse(stdin.readLineSync()!);
    } while (dailySalary < 10 || dailySalary > 100);
    employees.add(Employee(id, name, workingDays, dailySalary));
  }
}
void sortEmployeesByName(List<Employee> employees) {
  employees.sort((a, b) => a.name.compareTo(b.name));
  print("Sorted list of employees by name:");
  employees.forEach((employee) {
    print("${employee.id} - ${employee.name}");
  });
}
void analyzeEmployees(List<Employee> employees) {
  print("Enter a specific number of working days:");
  int specificWorkingDays = int.parse(stdin.readLineSync()!);
  int count = employees.where((employee) => employee.workingDays == specificWorkingDays).length;
  print("There are $count employees with $specificWorkingDays working days.");
  List<Employee> highestSalaryEmployees = findEmployeesWithHighestSalary(employees);
  print("Employees with the highest daily salary:");
  highestSalaryEmployees.forEach((employee) {
    print("${employee.id} - ${employee.name}, Daily Salary: ${employee.dailySalary}");
  });
}
List<Employee> findEmployeesWithHighestSalary(List<Employee> employees) {
  double maxSalary = employees.map((employee) => employee.workingDays * employee.dailySalary).reduce((a, b) => a > b ? a : b);
  List<Employee> highestSalaryEmployees = employees.where((employee) => employee.workingDays * employee.dailySalary == maxSalary).toList();
  print("Employees with the highest monthly salary:");
  highestSalaryEmployees.forEach((employee) {
    print("${employee.id} - ${employee.name}, Monthly Salary: ${employee.workingDays * employee.dailySalary}");
  });
  return highestSalaryEmployees;
}
