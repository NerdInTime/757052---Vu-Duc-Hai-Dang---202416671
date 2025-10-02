import javax.swing.JOptionPane;

class math3 {
    public static void main(String[] args) {
        try {
            String x = JOptionPane.showInputDialog(null,"First coeff? ", "Input 1st coeff", JOptionPane.INFORMATION_MESSAGE);
            double coeff1 = Double.parseDouble(x);
            String y = JOptionPane.showInputDialog(null,"Second coeff? ", "Input 2nd coeff", JOptionPane.INFORMATION_MESSAGE);
            double coeff2 = Double.parseDouble(y);
            String z = JOptionPane.showInputDialog(null,"First result ", "Input 1st result", JOptionPane.INFORMATION_MESSAGE);
            double res1 = Double.parseDouble(z);
            String d = JOptionPane.showInputDialog(null,"third coeff? ", "Input 3rd coeff", JOptionPane.INFORMATION_MESSAGE);
            double coeff3 = Double.parseDouble(d);
            String f = JOptionPane.showInputDialog(null,"fourth coeff? ", "Input 4th coeff", JOptionPane.INFORMATION_MESSAGE);
            double coeff4 = Double.parseDouble(f);
            String g = JOptionPane.showInputDialog(null,"second result? ", "Input 2nd result", JOptionPane.INFORMATION_MESSAGE);
            double res2 = Double.parseDouble(g);
            
            double det = coeff1*coeff4 - coeff2*coeff3;

            if (det == 0) {
                if ((coeff1 == 0 && coeff2 == 0 && res1 == 0) &&
                    (coeff3 == 0 && coeff4 == 0 && res2 == 0)) {
                    System.out.println("Infinite solutions (all zero system).");
                } else if ((coeff1*res2 == coeff3*res1) && (coeff2*res2 == coeff4*res1)) {
                    System.out.println("Infinite solutions (dependent equations).");
                } else {
                    System.out.println("No solution (inconsistent system).");
                }
            } else {
                double first = (coeff4*res1 - coeff2*res2) / det;
                double second = (coeff1*res2 - coeff3*res1) / det;
                System.out.println("x = " + first);
                System.out.println("y = " + second);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input, Please enter numbers only.");
        }
    }
}