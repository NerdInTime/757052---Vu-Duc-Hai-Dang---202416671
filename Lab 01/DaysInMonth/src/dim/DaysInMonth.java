package dim;

import java.util.Scanner;
class DaysInMonth {
    public static void main(String[] args) {
        boolean invalid= true;
        Scanner sc = new Scanner(System.in);
        int year = 0;
        while (invalid){
            System.out.println("Enter year:");
            if (!sc.hasNextInt()){
                System.out.println("Invalid. Try again with int.");
                sc.next();
            }
            else {
                year = sc.nextInt();
                if (year<0){
                    System.out.println("Invalid. Try again.");
            }
                else {invalid=false;}
        }
        }
        sc.nextLine();
        System.out.println("Enter month:");
        String y = sc.nextLine().trim();
        String month=y.toLowerCase();
        switch (month){
            case "1":
            case "jan":
            case "january":
            case "jan.":
            case "3":
            case "mar":
            case "march":
            case "mar.":
            case "5":
            case "may":
            case "may.":
            case "7":
            case "jul":
            case "july":
            case "jul.":
            case "8":
            case "aug":
            case "august":
            case "aug.":
            case "10":
            case "oct":
            case "october":
            case "oct.":
            case "12":
            case "dec":
            case "december":
            case "dec.":
                    System.out.println("31 days");
                    break;
            case "4":
            case "apr":
            case "april":
            case "apr.":
            case "6":
            case "jun":
            case "june":
            case "jun.":
            case "9":
            case "sep":
            case "sept.":
            case "september":
            case "11":
            case "november":
            case "nov":
            case "nov.":
                System.out.println("30 days");
                break;
            case "2":
            case "feb":
            case "february":
            case "feb.":
                if ((year%4==0)&&((year%100 != 0) || (year%400==0))){
                    System.out.println("29 days");
                }
                else {
                    System.out.println("28 days");
                }
                break;
            default:
                    System.out.println("Invalid input.");   
        }
        }
}

