import javax.swing.JOptionPane;	
class math {
    public static void main(String[] args) {
        String x = JOptionPane.showInputDialog(null,"First number? ", "Input first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(x);
        String y = JOptionPane.showInputDialog(null,"Second number? ", "Input second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(y);
        String op = JOptionPane.showInputDialog(null,"Operator? ", "Input the operator", JOptionPane.INFORMATION_MESSAGE);
        if (op.equals("+")){
            double result = num1 + num2;
            System.out.println(result);
        }
        if (op.equals("-")){
            double result = num1 - num2;
            System.out.println(result);
        }
        if (op.equals("*")){
            double result = num1 * num2;
            System.out.println(result);
        }
        if (op.equals("/")){
            if (num2 == 0){
                System.out.println("nuh uh");
            }
            else {
                double result = num1 / num2;
                System.out.println(result);   
            }
        }
    }
}