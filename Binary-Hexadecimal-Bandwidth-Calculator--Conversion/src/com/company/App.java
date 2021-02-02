
/*
In main start with basic code to welcome the user. Prompt the user with choices. In our case main gives the user 4
choices to pick from. This is where we take the user's choice and check to see if the user's choice is valid. We use a
while loop. If the choice is less than 1 or greater than 4 the user will be presented with an error message until the
user chooses a valid selection. Once the user selects a valid choice we break out of main.

I thought the best way to implement my code with the test mode was to have each calculation in its method. This way
when the user enters test mode we can pass values as parameters.

If the user selects choice 1 in main, we break out of main into the binary calculator method. We don't do any
calculations in this method. In this method, we give the user choices of which calculation/conversion they would like to
do. If the user selects a valid choice, which the while loop will error check, for example, choice 1, we break out of the
binary calculator method and choice 1 would break us into the binAddSubDivMul method.

binAddSubDivMul is where we do calculations/conversions. Here we prompt the user to choose 2 binary numbers. Once 2
binary numbers are taken and stored we can begin calculations to give the user a sum, difference, multiplication, and
division answers.

With the above stated this is valid for all calculations. We start in main (Level 1). Give the user choices which are
error checked. Then break out into the method of the user's choice (Level 2). In Level 2 we handle the user's choice of
what specific calculation/conversion they want to do with error checking. Once the user specifies which
calculation/conversion they would like to do we enter Level 3. Level 3 is where we ask the user for string and int
values to calculate and convert to a final result which is printed in the console.

If the user selects test mode at level 1, we break into level 2 where parameter values are passed into level 3 to give
our results
*/
package com.company;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //Welcome the user and prompt him with choices of the calculations/conversions they would like to calculate.
        System.out.println(ConsoleColors.GREEN + "Welcome to calculator/converter program" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Please choose from option 1 - 3 below" + ConsoleColors.RESET);
        System.out.println();
        System.out.println(ConsoleColors.GREEN + "(1) binary-calculator" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(2) hex-calculator" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(3) bandwidth-calculator" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(4) Test Mode" + ConsoleColors.RESET);
        System.out.println();
        System.out.print(ConsoleColors.GREEN + "Selection:");
        System.out.println();

        Scanner reader = new Scanner(System.in);
        int userChoiceOperator = reader.nextInt();//Take in the users choice.

        binaryCalculator binaryCalculator = new binaryCalculator();
        hexCalculator hexCalculator = new hexCalculator();
        bandwidthCalculator bandwidthCalculator = new bandwidthCalculator();
        testMode testMode = new testMode();

        while (userChoiceOperator < 1 || userChoiceOperator > 4) {
            //In this while loop we validate the users selection and make sure they choose between 1 and 4.
            System.out.println(ConsoleColors.RED + userChoiceOperator + " is not a valid input" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Please enter a valid selection from the list" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN + "Selection:" + ConsoleColors.RESET);
            System.out.println();
            userChoiceOperator = reader.nextInt();
        }
        if (userChoiceOperator == 1) {
            binaryCalculator.binaryCalculator();
        }
        if (userChoiceOperator == 2) {
            hexCalculator.hexCalculator();
        }
        if (userChoiceOperator == 3) {
            bandwidthCalculator.bandwidthCalculator();
        }
        if (userChoiceOperator == 4) {
            testMode.testMode();
        }
    }
}

class testMode {
    public static void testMode() {
        binaryCalculator binaryCalculator = new binaryCalculator();
        hexCalculator hexCalculator = new hexCalculator();
        bandwidthCalculator bandwidthCalculator = new bandwidthCalculator();
        System.out.println(ConsoleColors.PURPLE + "-------------------------------------------------------------");
        System.out.println("All set calculations for binary calculator");
        System.out.println("-------------------------------------------------------------");
        int bin1 = 101010101;
        int bin2 = 101010101;
        binaryCalculator.binAddSubDivMul(bin1, bin2);
        int x = 10;
        binaryCalculator.binToDec(x);
        int y = 2;
        binaryCalculator.decToBin(y);
        System.out.println("-------------------------------------------------------------");
        System.out.println("All set calculations for hexadecimal calculator");
        System.out.println("-------------------------------------------------------------");
        String z = "DAD";
        hexCalculator.hexToDec(z);
        int w = 170;
        hexCalculator.decToHex(w);
        String j = "8AB";
        String l = "B78";
        hexCalculator.hexAddSubDivMul(j, l);
        System.out.println("-------------------------------------------------------------");
        System.out.println("All set calculations for bandwidth calculator");
        System.out.println("-------------------------------------------------------------");
        double b = 800;
        bandwidthCalculator.dataUnitConverter(b);
        double d = 800;
        double c = 10;
        double g = 1;
        bandwidthCalculator.webBandCalc(d, c, g);
        double m = 800;
        bandwidthCalculator.hostBandCalc(m);
    }
}

class binaryCalculator {
    public static void binaryCalculator() {
        //Welcome the user to binary calculator and prompt him with
        // choices of the calculations/conversions they would like to do.
        System.out.println(ConsoleColors.GREEN + "-------------------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Welcome to Binary Calculator!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "You can choose from the following 3 calculations" + ConsoleColors.RESET);
        System.out.println();
        System.out.println(ConsoleColors.GREEN + "(1) Binary Calculation—Add, Subtract, Multiply, or Divide" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(2) Convert Binary Value to Decimal Value" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(3) Convert Decimal Value to Binary Value" + ConsoleColors.RESET);
        System.out.println();
        System.out.print(ConsoleColors.GREEN + "Selection:" + ConsoleColors.RESET);
        System.out.println();

        Scanner reader = new Scanner(System.in);
        int binaryChoice = reader.nextInt();

        while (binaryChoice < 1 || binaryChoice > 3) {
            //In this while loop we validate the users selection and make sure they choose between 1 and 3.
            System.out.println(ConsoleColors.RED + binaryChoice + " is not a valid input" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Please enter a valid selection from the list" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN + "Selection:" + ConsoleColors.RESET);
            System.out.println();
            binaryChoice = reader.nextInt();
        }

        if (binaryChoice == 1) {
            int bin1 = 0;
            int bin2 = 0;
            binAddSubDivMul(bin1, bin2);
        }

        if (binaryChoice == 2) {
            int x = 0;
            binToDec(x);
        }
        if (binaryChoice == 3) {
            int y = 0;
            decToBin(y);
        }
    }

    public static void binAddSubDivMul(int binX, int binY) {
        //Calculations to Add, Subtract, Multiply, and Divide binary numbers.
        if (binX == 0 && binY == 0) {
            Scanner reader = new Scanner(System.in);
            String firstBin, secondBin;
            int iParseOne, iParseTwo;

            System.out.println(ConsoleColors.GREEN + "Enter First Binary Number");
            firstBin = reader.next();

            System.out.println("Enter Second Binary Number");
            secondBin = reader.next();
            // Convert Binary numbers to decimal
            iParseOne = Integer.parseInt(firstBin, 2);
            iParseTwo = Integer.parseInt(secondBin, 2);

            System.out.println("Sum = " + Integer.toBinaryString(iParseOne + iParseTwo));
            System.out.println("Difference = " + Integer.toBinaryString(iParseOne - iParseTwo));
            System.out.println("Multiplication = " + Integer.toBinaryString(iParseOne * iParseTwo));
            System.out.println("Division = " + Integer.toBinaryString(iParseOne / iParseTwo));
            System.exit(0);
        } else if (binX == 101010101 && binY == 101010101) {
            String firstBin = Integer.toString(binX);
            String secondBin = Integer.toString(binX);
            int iParseOne, iParseTwo;

            iParseOne = Integer.parseInt(firstBin, 2);
            iParseTwo = Integer.parseInt(secondBin, 2);

            System.out.println("Sum of 101010101 + 101010101 = " + Integer.toBinaryString(iParseOne + iParseTwo));
            System.out.println("Difference of 101010101 - 101010101 = " + Integer.toBinaryString(iParseOne - iParseTwo));
            System.out.println("Multiplication of 101010101 * 101010101 = " + Integer.toBinaryString(iParseOne * iParseTwo));
            System.out.println("Division of 101010101 / 101010101 = " + Integer.toBinaryString(iParseOne / iParseTwo));
        }
    }

    public static void binToDec(int testX) {
        //Calculate binary to decimal
        if (testX == 0) {
            Scanner reader = new Scanner(System.in);
            System.out.println(ConsoleColors.GREEN + "Binary number you would like to convert");
            System.out.print("Number:");
            while (true) {
                int binConvert = reader.nextInt();
                int decimal = 0;
                int n = 0;
                while (binConvert != 0) {
                    if (binConvert % 10 > 1) {
                        System.out.println("This is not a binary number");
                        System.out.println("Binary number you would like to convert");
                        System.out.print("Number:");
                        binConvert = reader.nextInt();
                    } else {
                        int temp = binConvert % 10;
                        decimal += temp * Math.pow(2, n);
                        binConvert = binConvert / 10;
                        n++;
                    }
                }
                System.out.print("Converted Value:" + decimal);
                System.exit(0);
            }
        } else if (testX == 10) {
            int binConvert = testX;
            int decimal = 0;
            int n = 0;
            while (binConvert != 0) {
                int temp = binConvert % 10;
                decimal += temp * Math.pow(2, n);
                binConvert = binConvert / 10;
                n++;
            }
            System.out.println("Binary to decimal of 10 is " + decimal);
        }
    }

    public static void decToBin(int testY) {
        //Calculate decimal to binary
        if (testY == 0) {
            Scanner reader = new Scanner(System.in);
            System.out.println(ConsoleColors.GREEN + "Decimal number you would like to convert");
            System.out.print("Number:");

            int decConvert = reader.nextInt();

            int binary[] = new int[40];
            int index = 0;
            while (decConvert > 0) {
                binary[index++] = decConvert % 2;
                decConvert = decConvert / 2;
            }
            for (int i = index - 1; i >= 0; i--) {
                System.out.print(binary[i]);
            }
            System.out.println();
            System.exit(0);
        } else if (testY == 2) {
            int decConvert = testY;
            int binary[] = new int[40];
            int index = 0;
            while (decConvert > 0) {
                binary[index++] = decConvert % 2;
                decConvert = decConvert / 2;
            }
            System.out.print("Decimal to binary of 2 is ");
            for (int i = index - 1; i >= 0; i--) {
                System.out.print(binary[i]);
            }
            System.out.println();
        }
    }
}

class hexCalculator {
    public static void hexCalculator() {
        //Welcome the user to hexadecimal calculator and prompt him with
        // choices of the calculations/conversions they would like to do.
        System.out.println(ConsoleColors.GREEN + "-------------------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Welcome to Hexadecimal Calculator!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "You can choose from the following 3 calculations" + ConsoleColors.RESET);
        System.out.println();
        System.out.println(ConsoleColors.GREEN + "(1) Hexadecimal Calculation—Add, Subtract, Multiply, or Divide" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(2) Convert Hexadecimal Value to Decimal Value" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(3) Convert Decimal Value to Hexadecimal Value" + ConsoleColors.RESET);
        System.out.println();
        System.out.print(ConsoleColors.GREEN + "Selection:" + ConsoleColors.RESET);
        System.out.println();

        Scanner reader = new Scanner(System.in);
        int hexadecimalChoice = reader.nextInt();

        while (hexadecimalChoice < 1 || hexadecimalChoice > 3) {
            //In this while loop we validate the users selection and make sure they choose between 1 and 3.
            System.out.println(ConsoleColors.RED + hexadecimalChoice + " is not a valid input" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Please enter a valid selection from the list" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN + "Selection:" + ConsoleColors.RESET);
            System.out.println();
            hexadecimalChoice = reader.nextInt();
        }

        if (hexadecimalChoice == 1) {
            String j = "";
            String l = "";
            hexAddSubDivMul(j, l);
        }
        if (hexadecimalChoice == 2) {
            String x = "";
            hexToDec(x);
        }
        if (hexadecimalChoice == 3) {
            int y = 0;
            decToHex(y);
        }
    }

    public static void hexAddSubDivMul(String fString, String sString) {
        if (fString == "" || sString == "") {
            String firstHex, secondHex;
            int num1, num2, sum, difference, multiplication, division;

            Scanner reader = new Scanner(System.in);
            System.out.println(ConsoleColors.GREEN + "Enter your first Number:");
            firstHex = reader.nextLine();
            System.out.println("Enter your second Number:");
            secondHex = reader.nextLine();

            num1 = Integer.parseInt(firstHex, 16);
            num2 = Integer.parseInt(secondHex, 16);

            sum = num1 + num2;
            difference = num2 - num1;
            multiplication = num1 * num2;
            division = num1 / num2;
            String ans1 = Integer.toHexString(sum);
            String ans2 = Integer.toHexString(difference);
            String ans3 = Integer.toHexString(multiplication);
            String ans4 = Integer.toHexString(division);
            System.out.println("Sum is " + ans1);
            System.out.println("Difference is " + ans2);
            System.out.println("Multiplication is " + ans3);
            System.out.println("Division is " + ans4);
        } else if (fString == "8AB" || sString == "B78") {
            String firstHex, secondHex;
            int num1, num2, sum, difference, multiplication, division;

            firstHex = fString;
            secondHex = sString;

            num1 = Integer.parseInt(firstHex, 16);
            num2 = Integer.parseInt(secondHex, 16);

            sum = num1 + num2;
            difference = num2 - num1;
            multiplication = num1 * num2;
            division = num1 / num2;
            String ans1 = Integer.toHexString(sum);
            String ans2 = Integer.toHexString(difference);
            String ans3 = Integer.toHexString(multiplication);
            String ans4 = Integer.toHexString(division);
            System.out.println("Sum is " + ans1);
            System.out.println("Difference is " + ans2);
            System.out.println("Multiplication is " + ans3);
            System.out.println("Division is " + ans4);
        }
    }

    public static void hexToDec(String xTest) {
        if (xTest == "") {
            Scanner reader = new Scanner(System.in);
            System.out.print(ConsoleColors.GREEN + "Enter a hexadecimal number you would like to convert: ");
            String base = "0123456789ABCDEF";
            String hex = reader.nextLine();
            hex = hex.toUpperCase();
            int num = 0;
            for (int i = 0; i < hex.length(); i++) {
                char ch = hex.charAt(i);
                int n = base.indexOf(ch);
                num = 16 * num + n;
            }
            System.out.println("Converted hexadecimal to decimal: " + num);
        } else if (xTest == "DAD") {
            String base = "0123456789ABCDEF";
            String hex = xTest;
            hex = hex.toUpperCase();
            int num = 0;
            for (int i = 0; i < hex.length(); i++) {
                char ch = hex.charAt(i);
                int n = base.indexOf(ch);
                num = 16 * num + n;
            }
            System.out.println("Converted hexadecimal to decimal of DAD is " + num);
        }
    }

    public static void decToHex(int yTest) {
        if (yTest == 0) {
            Scanner reader = new Scanner(System.in);
            System.out.print(ConsoleColors.GREEN + "Enter a decimal number you would like to convert: ");
            int dec = reader.nextInt();
            int rem;
            String str2 = "";

            char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (dec > 0) {
                rem = dec % 16;
                str2 = hex[rem] + str2;
                dec = dec / 16;
            }
            System.out.println("Converted Decimal to hexadecimal: " + str2);
        } else if (yTest == 170) {
            int dec = yTest;
            int rem;
            String str2 = "";

            char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (dec > 0) {
                rem = dec % 16;
                str2 = hex[rem] + str2;
                dec = dec / 16;
            }
            System.out.println("Converted Decimal to hexadecimal of 170 is " + str2);
        }
    }
}

class bandwidthCalculator {
    public static void bandwidthCalculator() {
        //Welcome the user to bandwidth calculator and prompt him with
        // choices of the calculations/conversions they would like to do.
        System.out.println(ConsoleColors.GREEN + "-------------------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Welcome to Bandwidth Calculator!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "You can choose from the following 3 calculations" + ConsoleColors.RESET);
        System.out.println();
        System.out.println(ConsoleColors.GREEN + "(1) Data Unit Converter" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(2) Website Bandwidth Calculator" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "(3) Hosting Bandwidth Converter" + ConsoleColors.RESET);
        System.out.println();
        System.out.print(ConsoleColors.GREEN + "Selection:" + ConsoleColors.RESET);
        System.out.println();

        Scanner reader = new Scanner(System.in);
        int bandwidthChoice = reader.nextInt();

        while (bandwidthChoice < 1 || bandwidthChoice > 3) {
            //In this while loop we validate the users selection and make sure they choose between 1 and 3.
            System.out.println(ConsoleColors.RED + bandwidthChoice + " is not a valid input" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "Please enter a valid selection from the list" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN + "Selection:" + ConsoleColors.RESET);
            System.out.println();
            bandwidthChoice = reader.nextInt();
        }

        if (bandwidthChoice == 1) {
            double b = 0;
            dataUnitConverter(b);
        }
        if (bandwidthChoice == 2) {
            double d = 0;
            double c = 0;
            double g = 0;
            webBandCalc(d, c, g);
        }
        if (bandwidthChoice == 3) {
            double m = 0;
            hostBandCalc(m);
        }
    }

    public static void dataUnitConverter(double bTest) {
        if (bTest == 0) {
            System.out.println(ConsoleColors.GREEN + "Please select a unit you would like to convert");
            System.out.println();
            System.out.println("(1) bits (b)");
            System.out.println("(2) kilobits (kb)");
            System.out.println("(3) megabits (mb)");
            System.out.println("(4) gigabits (gb)");
            System.out.println("(5) terabits (tb)");
            System.out.println("(6) Bytes (B)");
            System.out.println("(7) Kilobytes (KB)");
            System.out.println("(8) Megabytes (MB)");
            System.out.println("(9) Gigabytes (GB)");
            System.out.println("(10) Terabytes (TB)");
            System.out.print("Selection:");
            Scanner reader = new Scanner(System.in);
            double selection = reader.nextInt();
            while (selection < 1 || selection > 10) {
                //In this while loop we validate the users selection and make sure they choose between 1 and 4.
                System.out.println(selection + " is not a valid input");
                System.out.println("Please enter a valid selection from the list");
                System.out.print("Selection:");
                System.out.println();
                selection = reader.nextInt();
            }
            if (selection == 1) {
                System.out.println("Please type in value in bits to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_bit = value;
                double size_kilobits = size_bit / 1000;
                double size_megabit = size_kilobits / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_Byte = size_bit / 8;
                double size_kilobytes = size_bit / 8000;
                double size_megabytes = size_kilobytes / 1000;
                double size_gigabytes = size_megabytes / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_kilobits + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_Byte + " (B)");
                System.out.println(size_kilobytes + " (KB)");
                System.out.println(size_megabytes + " (MB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 2) {
                System.out.println("Please type in value in kilobits to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_kilobit = value;
                double size_bit = size_kilobit * 1000;
                double size_megabit = size_kilobit / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_Byte = size_bit / 8;
                double size_kilobytes = size_bit / 8000;
                double size_megabytes = size_kilobytes / 1000;
                double size_gigabytes = size_megabytes / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_Byte + " (B)");
                System.out.println(size_kilobytes + " (KB)");
                System.out.println(size_megabytes + " (MB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 3) {
                System.out.println("Please type in value in megabits to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_megabit = value;
                double size_bit = size_megabit * 1e+6;
                double size_kilobit = size_megabit * 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_Byte = size_bit / 8;
                double size_kilobytes = size_bit / 8000;
                double size_megabytes = size_kilobytes / 1000;
                double size_gigabytes = size_megabytes / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobit + " (kb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_Byte + " (B)");
                System.out.println(size_kilobytes + " (KB)");
                System.out.println(size_megabytes + " (MB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 4) {
                System.out.println("Please type in value in gigabits to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_gigabits = value;
                double size_bit = size_gigabits * 1e+9;
                double size_kilobit = size_bit / 1000;
                double size_megabit = size_kilobit / 1000;
                double size_terabit = size_megabit / 1e+6;
                double size_Byte = size_bit / 8;
                double size_kilobytes = size_bit / 8000;
                double size_megabytes = size_kilobytes / 1000;
                double size_gigabytes = size_megabytes / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobit + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_Byte + " (B)");
                System.out.println(size_kilobytes + " (KB)");
                System.out.println(size_megabytes + " (MB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 5) {
                System.out.println("Please type in value in gigabits to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_terabits = value;
                double size_bit = size_terabits * 1e+12;
                double size_kilobit = size_bit / 1000;
                double size_megabit = size_kilobit / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_Byte = size_bit / 8;
                double size_kilobytes = size_bit / 8000;
                double size_megabytes = size_kilobytes / 1000;
                double size_gigabytes = size_megabytes / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobit + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_Byte + " (B)");
                System.out.println(size_kilobytes + " (KB)");
                System.out.println(size_megabytes + " (MB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 6) {
                System.out.println("Please type in value in bytes to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_byte = value;
                double size_bit = size_byte * 8;
                double size_kilobits = size_bit / 1000;
                double size_megabit = size_kilobits / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_kilobytes = size_byte / 1000;
                double size_megabytes = size_kilobytes / 1000;
                double size_gigabytes = size_megabytes / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobits + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_kilobytes + " (KB)");
                System.out.println(size_megabytes + " (MB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 7) {
                System.out.println("Please type in value in Kilobytes to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_kilobytes = value;
                double size_bit = size_kilobytes * 8000;
                double size_kilobits = size_bit / 1000;
                double size_megabit = size_kilobits / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_byte = size_kilobytes * 1000;
                double size_megabytes = size_kilobytes / 1000;
                double size_gigabytes = size_megabytes / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobits + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_byte + " (B)");
                System.out.println(size_megabytes + " (MB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 8) {
                System.out.println("Please type in value in megabytes to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_megabyte = value;
                double size_bit = size_megabyte * 8e+6;
                double size_kilobits = size_bit / 1000;
                double size_megabit = size_kilobits / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_byte = size_megabyte * 1e+6;
                double size_kilobyte = size_byte / 1000;
                double size_gigabytes = size_megabyte / 1000;
                double size_terabytes = size_gigabytes / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobits + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_byte + " (B)");
                System.out.println(size_kilobyte + " (KB)");
                System.out.println(size_gigabytes + " (GB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 9) {
                System.out.println("Please type in value in gigabyte to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_gigabyte = value;
                double size_bit = size_gigabyte * 8e+9;
                double size_kilobits = size_bit / 1000;
                double size_megabit = size_kilobits / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_byte = size_gigabyte * 1e+9;
                double size_kilobyte = size_byte / 1000;
                double size_megabyte = size_gigabyte * 1000;
                double size_terabytes = size_gigabyte / 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobits + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_byte + " (B)");
                System.out.println(size_kilobyte + " (KB)");
                System.out.println(size_megabyte + " (MB)");
                System.out.println(size_terabytes + " (TB)");
                System.out.println("-------------------------------------------------------------");
            }
            if (selection == 10) {
                System.out.println("Please type in value in terabytes to convert to all conversions");
                System.out.print("Selection:");
                double value = reader.nextInt();
                double size_terabyte = value;
                double size_bit = size_terabyte * 8e+12;
                double size_kilobits = size_bit / 1000;
                double size_megabit = size_kilobits / 1000;
                double size_gigabit = size_megabit / 1000;
                double size_terabit = size_gigabit / 1000;
                double size_byte = size_terabyte * 1e+12;
                double size_kilobyte = size_byte / 1000;
                double size_megabyte = size_terabyte * 1e+6;
                double size_gigabyte = size_terabyte * 1000;
                System.out.println("-------------------------------------------------------------");
                System.out.println(size_bit + " (b)");
                System.out.println(size_kilobits + " (kb)");
                System.out.println(size_megabit + " (mb)");
                System.out.println(size_gigabit + " (gb)");
                System.out.println(size_terabit + " (tb)");
                System.out.println(size_byte + " (B)");
                System.out.println(size_kilobyte + " (KB)");
                System.out.println(size_megabyte + " (MB)");
                System.out.println(size_gigabyte + " (GB)");
                System.out.println("-------------------------------------------------------------");
            }
        } else if (bTest == 800) {
            double size_byte = bTest;
            double size_bit = size_byte * 8;
            double size_kilobits = size_bit / 1000;
            double size_megabit = size_kilobits / 1000;
            double size_gigabit = size_megabit / 1000;
            double size_terabit = size_gigabit / 1000;
            double size_kilobytes = size_byte / 1000;
            double size_megabytes = size_kilobytes / 1000;
            double size_gigabytes = size_megabytes / 1000;
            double size_terabytes = size_gigabytes / 1000;
            System.out.println(bTest + " Converts to the following values:");
            System.out.println(size_bit + " (b)");
            System.out.println(size_kilobits + " (kb)");
            System.out.println(size_megabit + " (mb)");
            System.out.println(size_gigabit + " (gb)");
            System.out.println(size_terabit + " (tb)");
            System.out.println(size_kilobytes + " (KB)");
            System.out.println(size_megabytes + " (MB)");
            System.out.println(size_gigabytes + " (GB)");
            System.out.println(size_terabytes + " (TB)");
        }
    }

    public static void webBandCalc(double dTest, double cTest, double gTest) {
        if (dTest == 0 && cTest == 0 && gTest == 0) {
            Scanner reader = new Scanner(System.in);
            System.out.print(ConsoleColors.GREEN + "Page views:");
            double pView = reader.nextInt();
            System.out.print("Average Page Size:");
            double avePageSize = reader.nextInt();
            System.out.print("redundancy factor:");
            double redundancy = reader.nextInt();
            double bNeeded = pView * avePageSize * redundancy;
            double bFinal = bNeeded * 30.4375;
            double bNed = bFinal / 328.725;
            System.out.println("Bandwidth needed is " + bNed + " Mbits/s or " + bFinal + " GB per month.");
        } else if (dTest == 800 && cTest == 10 && gTest == 1) {
            double pView = dTest;
            double avePageSize = cTest;
            double redundancy = gTest;
            double bNeeded = pView * avePageSize * redundancy;
            double bFinal = bNeeded * 30.4375;
            double bNed = bFinal / 328.725;
            System.out.println("Bandwidth needed is " + bNed + " Mbits/s or " + bFinal + " GB per month.");
        }
    }

    public static void hostBandCalc(double mConv) {
        if (mConv == 0) {
            System.out.println(ConsoleColors.GREEN + "Please type in value in bytes to gigabytes to get the conversion in megabits");
            System.out.print("Selection:");

            Scanner reader = new Scanner(System.in);
            double value = reader.nextInt();

            double mb = value * 0.0031;
            System.out.println(mb + " Mbit/s");
        } else if (mConv == 800) {
            double value = mConv;

            double mb = value * 0.0031;
            System.out.println("800 bytes is " + mb + " Mbit/s");
        }
    }
}

class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
}
