// CSC111L - Lab 1
// Hernest Koroli

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String choice;
    int num1;
    int num2;
    int total;

    System.out.println("Would you like to add, subtract, divide, or multipliy? ");
    choice = input.nextLine();

    System.out.println("Enter the first number you'd like to " + choice + ":");
    num1 = input.nextInt();
    System.out.println("Enter the second number you'd like to " + choice + ":");
    num2 = input.nextInt();

    total = calculate(choice, num1, num2);
        
    System.out.println("Your total is: " + total);
    input.close();
}




public static int calculate(String userInput, int userNum1, int userNum2) {
    switch (userInput) {
        case "add":
            return addMe(userNum1, userNum2);
        case "subtract":
            return subtractMe(userNum1, userNum2);
        case "multiply":
            return multiplyMe(userNum1, userNum2);
        case "divide":
            return divideMe(userNum1, userNum2);
        default:
            return 0;
    }
}

public static int addMe(int num1, int num2) {
    return num1 + num2;
}

public static int subtractMe(int num1, int num2) {
    return num1 - num2;
}

public static int multiplyMe(int num1, int num2) {
    return num1 * num2;
}

public static int divideMe(int num1, int num2) {
    return num1 / num2;
}
