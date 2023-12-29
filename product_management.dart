import 'dart:io';
class Product {
  int id;
  String name;
  int price;
  double quantity;

  Product(this.id, this.name, this.price, this.quantity);
}
void main() {
  List<Product> products = [];
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
        inputProducts(products);
        break;
      case '2':
        sortProductsByPrice(products);
        break;
      case '3':
        analyzeProducts(products);
        break;
      case '4':
        findProductsWithHighestTotalPrice(products);
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

void inputProducts(List<Product> products) {
  print("Enter the total number of products:");
  int totalProducts = int.parse(stdin.readLineSync()!);

  for (int i = 0; i < totalProducts; i++) {
    int productId, productPrice;
    String productName;
    double productQuantity;
    int productIndex = i+1;
    print("Inputting information of product $productIndex");
    do {
      print("Enter ID (must be an integer):");
      productId = int.tryParse(stdin.readLineSync()!)??0;
    } while (productId <=0 );
    do {
      print("Enter name (from 2 to 200 characters):");
      productName = stdin.readLineSync()!;
    } while (productName.length < 2 || productName.length > 200);
    do {
      print("Enter price (from 0 to 1000):");
      productPrice = int.tryParse(stdin.readLineSync()!)??0;
    } while (productPrice == null || productPrice < 0 || productPrice > 1000);
    do {
      print("Enter quantity (must be greater than 0):");
      productQuantity = double.tryParse(stdin.readLineSync()!)??0;
    } while (productQuantity == null || productQuantity <= 0);

    products.add(Product(productId, productName, productPrice, productQuantity));
  }
}

void sortProductsByPrice(List<Product> products) {
  products.sort((a, b) => a.price.compareTo(b.price));
  print("Sorted list of products by price:");
  products.forEach((product) {
    print("${product.id} - ${product.name}, Price: ${product.price}, Quantity: ${product.quantity}");
  });
}

void analyzeProducts(List<Product> products) {
  print("Enter a specific price:");
  int specificPrice = int.parse(stdin.readLineSync()!);

  int count = products.where((product) => product.price == specificPrice).length;
  print("There are $count products with price: $specificPrice.");

  List<Product> highestPriceProducts = findProductsByPrice(products, specificPrice);
  print("Products with the highest price:");
  highestPriceProducts.forEach((product) {
    print("${product.id} - ${product.name}, Price: ${product.price}, Quantity: ${product.quantity}");
  });
}

List<Product> findProductsByPrice(List<Product> products, int specificPrice) {
  return products.where((product) => product.price == specificPrice).toList();
}

void findProductsWithHighestTotalPrice(List<Product> products) {
  double maxTotalPrice = products.map((product) => product.quantity * product.price).reduce((a, b) => a > b ? a : b);
  List<Product> highestTotalPriceProducts = products.where((product) => product.quantity * product.price == maxTotalPrice).toList();
  print("Products with the highest total price:");
  highestTotalPriceProducts.forEach((product) {
    print("${product.id} - ${product.name}, Total Price: ${product.quantity * product.price}");
  });
}
