import javax.swing.JOptionPane;
import java.util.Scanner;
class math2 {
    public static void main(String[] args) {
        String x = JOptionPane.showInputDialog(null,"a? ", "Input a", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(x);
        String y = JOptionPane.showInputDialog(null,"b? ", "Input b", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(y);
        if (a==0){
            if (b==0){
                System.out.println("infinite solutions");
            }
            else{
                System.out.println("no possible solution");
            }
        }
        else{
            if (b==0){
                System.out.println("0");
            }
            else {
                System.out.println(-b/a);
            }
        }

        }
    }
