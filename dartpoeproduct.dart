import 'dart:io';

class Product {
  int id;
  String name;
  double price;
  int quantity;

  Product(this.id, this.name, this.price, this.quantity);
}

int validateIntegerInput(String prompt) {
  while (true) {
    try {
      stdout.write(prompt);
      return int.parse(stdin.readLineSync()!);
    } catch (e) {
      print('Invalid input. Please enter an integer.');
    }
  }
}

double validateFloatInput(String prompt, double minValue, double maxValue) {
  while (true) {
    try {
      stdout.write(prompt);
      var value = double.parse(stdin.readLineSync()!);
      if (value >= minValue && value <= maxValue) {
        return value;
      } else {
        print('Invalid input. Please enter a number between $minValue and $maxValue.');
      }
    } catch (e) {
      print('Invalid input. Please enter a valid number.');
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

Product addProduct() {
  var id = validateIntegerInput('Enter ID: ');
  var name = validateStringInput('Enter name: ', 2, 200);
  var price = validateFloatInput('Enter price: ', 0, 1000);
  var quantity = validateIntegerInput('Enter quantity: ');
  return Product(id, name, price, quantity);
}

List<Product> sortProductsByPrice(List<Product> products) {
  products.sort((a, b) => a.price.compareTo(b.price));
  return products;
}

void displayProducts(List<Product> products) {
  print('Sorted list of products by price:');
  for (var product in products) {
    print('ID: ${product.id}, Name: ${product.name}, Price: ${product.price}, Quantity: ${product.quantity}');
  }
}

void analyzeProducts(List<Product> products) {
  var price = validateFloatInput('Enter a specific price: ', 0, 1000);
  var count = products.where((product) => product.price == price).length;
  print('There are $count products with price: $price');
  var maxPrice = products.map((product) => product.price).reduce((a, b) => a > b ? a : b);
  var maxPriceProducts = products.where((product) => product.price == maxPrice);
  print('Product(s) with the highest price:');
  for (var product in maxPriceProducts) {
    print('ID: ${product.id}, Name: ${product.name}, Price: ${product.price}, Quantity: ${product.quantity}');
  }
}

double calculateTotalPrice(Product product) {
  return product.price * product.quantity;
}

void findProductsWithHighestTotalPrice(List<Product> products) {
  var maxTotalPrice = products.map((product) => calculateTotalPrice(product)).reduce((a, b) => a > b ? a : b);
  var maxTotalPriceProducts = products.where((product) => calculateTotalPrice(product) == maxTotalPrice);
  print('Product(s) with the highest total price:');
  for (var product in maxTotalPriceProducts) {
    print('ID: ${product.id}, Name: ${product.name}, Price: ${product.price}, Quantity: ${product.quantity}');
  }
}

void main() {
  var products = <Product>[];

  while (true) {
    stdout.write('Enter your choice (1-5): ');
    var choice = int.parse(stdin.readLineSync()!);

    switch (choice) {
      case 1:
        var product = addProduct();
        products.add(product);
        break;
      case 2:
        products = sortProductsByPrice(products);
        displayProducts(products);
        break;
      case 3:
        analyzeProducts(products);
        break;
      case 4:
        findProductsWithHighestTotalPrice(products);
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