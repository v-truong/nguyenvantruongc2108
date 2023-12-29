import 'dart:io';

class Employee {
  String id;
  String name;
  int workingDays;
  double dailySalary;

  Employee(this.id, this.name, this.workingDays, this.dailySalary);
}

String validateIdInput(String prompt) {
  while (true) {
    stdout.write(prompt);
    var id = stdin.readLineSync()!;
    if (id.length == 6) {
      return id;
    } else {
      print('Invalid input. ID must be 6 characters long.');
    }
  }
}

String validateStringInput(String prompt, int minLength, int maxLength) {
  while (true) {
    stdout.write(prompt);
    var value = stdin.readLineSync()!;
    if (value.length >= minLength && value.length <= maxLength) {
      return value;
    } else {
      print('Invalid input. Please enter a string with a length between $minLength and $maxLength.');
    }
  }
}

int validateWorkingDaysInput(String prompt) {
  while (true) {
    stdout.write(prompt);
    var workingDays = int.tryParse(stdin.readLineSync()!);
    if (workingDays != null && workingDays >= 1 && workingDays <= 31) {
      return workingDays;
    } else {
      print('Invalid input. Please enter a number between 1 and 31.');
    }
  }
}

double validateDailySalaryInput(String prompt, double minSalary, double maxSalary) {
  while (true) {
    stdout.write(prompt);
    var dailySalary = double.tryParse(stdin.readLineSync()!);
    if (dailySalary != null && dailySalary >= minSalary && dailySalary <= maxSalary) {
      return dailySalary;
    } else {
      print('Invalid input. Please enter a number between $minSalary and $maxSalary.');
    }
  }
}

Employee addEmployee() {
  var id = validateIdInput('Enter ID: ');
  var name = validateStringInput('Enter name: ', 5, 100);
  var workingDays = validateWorkingDaysInput('Enter working days: ');
  var dailySalary = validateDailySalaryInput('Enter daily salary: ', 10, 100);
  return Employee(id, name, workingDays, dailySalary);
}

List<Employee> sortEmployeesByName(List<Employee> employees) {
  employees.sort((a, b) => a.name.compareTo(b.name));
  return employees;
}

void displayEmployees(List<Employee> employees) {
  print('Sorted list of employees by name:');
  for (var employee in employees) {
    print('ID: ${employee.id}, Name: ${employee.name}, Working Days: ${employee.workingDays}, Daily Salary: ${employee.dailySalary}');
  }
}

void analyzeEmployees(List<Employee> employees) {
  var workingDays = validateWorkingDaysInput('Enter a specific number of working days: ');
  var count = employees.where((employee) => employee.workingDays == workingDays).length;
  print('There are $count employees with $workingDays working days');
  var maxSalary = employees.map((employee) => employee.dailySalary).reduce((a, b) => a > b ? a : b);
  var maxSalaryEmployees = employees.where((employee) => employee.dailySalary == maxSalary);
  print('Employee(s) with the highest daily salary:');
  for (var employee in maxSalaryEmployees) {
    print('ID: ${employee.id}, Name: ${employee.name}, Working Days: ${employee.workingDays}, Daily Salary: ${employee.dailySalary}');
  }
}

double calculateMonthlySalary(Employee employee) {
  return employee.workingDays * employee.dailySalary;
}

void findEmployeesWithHighestMonthlySalary(List<Employee> employees) {
  var maxMonthlySalary = employees.map((employee) => calculateMonthlySalary(employee)).reduce((a, b) => a > b ? a : b);
  var maxMonthlySalaryEmployees = employees.where((employee) => calculateMonthlySalary(employee) == maxMonthlySalary);
  print('Employee(s) with the highest monthly salary:');
  for (var employee in maxMonthlySalaryEmployees) {
    print('ID: ${employee.id}, Name: ${employee.name}, Working Days: ${employee.workingDays}, Daily Salary: ${employee.dailySalary}');
  }
}

void main() {
  var employees = <Employee>[];

  while (true) {
    stdout.write('Enter your choice (1-5): ');
    var choice = int.parse(stdin.readLineSync()!);

    switch (choice) {
      case 1:
        var employee = addEmployee();
        employees.add(employee);
        break;
      case 2:
        employees = sortEmployeesByName(employees);
        displayEmployees(employees);
        break;
      case 3:
        analyzeEmployees(employees);
        break;
      case 4:
        findEmployeesWithHighestMonthlySalary(employees);
        break;
      case 5:
        return;
     default:
        print('Invalid choice. Please enter a number between 1 and 5.');
    }

    stdout.write('Do you want to continue (y/n)? ');
    var continueChoice = stdin.readLineSync()!.toLowerCase();
    if (continueChoice != 'y') {
      break;
    }
  }
}