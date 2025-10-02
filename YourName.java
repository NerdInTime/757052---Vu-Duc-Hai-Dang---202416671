import javax.swing.JOptionPane;
public class YourName{
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Your name is?");
        JOptionPane.showMessageDialog(null,"Hello" + result + ", I am Jo!");
        System.exit(0);
    }
}