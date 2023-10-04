import java.util.Scanner;

    class Calculator {
        private double num1;
        private double num2;

        public Calculator() {
            this.num1 = 0;
            this.num2 = 0;
        }

        public void setNum1(double num1) {
            this.num1 = num1;
        }

        public void setNum2(double num2) {
            this.num2 = num2;
        }

        public double add() {
            return num1 + num2;
        }

        public double subtract() {
            return num1 - num2;
        }

        public double multiply() {
            return num1 * num2;
        }

        public double divide() {
            if (num2 == 0) {
                System.out.println("Error: Division by zero");
                return Double.NaN;
            }
            return num1 / num2;
        }
    }

    class CalculatorApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new Calculator();

            System.out.println("Available operations: +, -, *, /");

            while (true) {
                try {
                    System.out.print("Enter an operation (+, -, *, /) or 'q' to quit: ");
                    char operator = scanner.next().charAt(0);

                    if (operator == 'q') {
                        System.out.println("Thank You!");
                        break;
                    }

                    if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                        System.out.println("Invalid operation. Please try again.");
                        continue;
                    }

                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();
                    calculator.setNum1(num1);

                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();
                    calculator.setNum2(num2);

                    double result = 0;

                    switch (operator) {
                        case '+':
                            result = calculator.add();
                            break;
                        case '-':
                            result = calculator.subtract();
                            break;
                        case '*':
                            result = calculator.multiply();
                            break;
                        case '/':
                            result = calculator.divide();
                            break;
                    }

                    System.out.println("Result: " + result);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }

            scanner.close();
        }
    }
