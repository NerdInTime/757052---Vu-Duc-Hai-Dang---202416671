import java.lang.Math;
import javax.swing.JOptionPane;
class math4 {
    public static void main(String[] args) {
        String x = JOptionPane.showInputDialog(null,"First coeff (a)? ", "Input 1st coeff", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(x);
        String y = JOptionPane.showInputDialog(null,"Second coeff (b)? ", "Input 2nd coeff", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(y);
        String z = JOptionPane.showInputDialog(null,"Constant (c)? ", "Input the constant term", JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(z);
        
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinite solutions (0 = 0).");
                } else {
                    System.out.println("No solution.");
                }
            } else {
                double solution = -c / b;
                System.out.println("Linear equation solution: x = " + solution);
            }
        } else {
            double del = b*b - 4*a*c;
            if (del < 0) {
                System.out.println("No real solutions.");
            }
            else if (del == 0) {
                double result1 = -b / (2*a);  // fixed formula
                System.out.println("Overlapping solution: x = " + result1);
            }
            else {
                double result2 = (-b + Math.sqrt(del)) / (2*a);
                double result3 = (-b - Math.sqrt(del)) / (2*a);
                System.out.println("sol 1: x = " + result2);
                System.out.println("sol 2: x = " + result3);
            }
        }
    }
}