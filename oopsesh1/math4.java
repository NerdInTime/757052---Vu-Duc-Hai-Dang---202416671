import java.lang.Math;
import javax.swing.JOptionPane;
import java.util.Scanner;
class math4 {
    public static void main(String[] args) {
        String x = JOptionPane.showInputDialog(null,"First coeff? ", "Input 1st coeff", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(x);
        String y = JOptionPane.showInputDialog(null,"Second coeff? ", "Input 2nd coeff", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(y);
        String z = JOptionPane.showInputDialog(null,"c? ", "Input the number thats not with a variable", JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(z);
        
        double del = b*b - 4*a*c;
        if (del<0){
            System.out.println("No real solutions");
        }
        else if (del == 0){
            double result1= -b/2*a;
            System.out.println("Overlapping solution: " + result1);
        }
        else{
            double result2= (-b+Math.sqrt(del))/(2*a);
            double result3= (-b-Math.sqrt(del))/(2*a);
            System.out.println("sol 1: " + result2);
            System.out.println("sol 2: " + result3);
        }

        }
    }
