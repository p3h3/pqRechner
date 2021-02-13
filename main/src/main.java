import javax.swing.*;
import java.awt.*;

public class main {

    private static JFrame f;

    public static void main(String[] args){
        f = new JFrame("wunderbarer pq rechner");

        JPanel mainPanel = new JPanel(new GridLayout(4, 2));

        // Begrüßung :)
        mainPanel.add(new JLabel("Hallo in Tereza's tollem PQ-Formel rechner!"));

        // platzhalter uffff
        mainPanel.add(new JLabel(""));

        // a eingabe & label
        mainPanel.add(new JLabel("Gib a ein:", SwingConstants.CENTER));
        JTextField aField = new JTextField();
        mainPanel.add(aField);

        // b eingabe & label
        mainPanel.add(new JLabel("Gib b ein:", SwingConstants.CENTER));
        JTextField bField = new JTextField();
        mainPanel.add(bField);

        // c eingabe & label
        mainPanel.add(new JLabel("Gib c ein:", SwingConstants.CENTER));
        JTextField cField = new JTextField();
        mainPanel.add(bField);


        // get screen size to make window size relative
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // stop process on close of main window
        f.setSize((int) (screenSize.width * 0.3), (int) (screenSize.height * 0.4));
        f.getContentPane().add(mainPanel);
        f.setVisible(true); // making the frame visible

    }

    private static double calc(double a, double b, double c){
        b /= a;
        c /= a;

        double wurzel = (Math.pow(b, 2) / 4) - c;

        if(wurzel < 0){
            // keine Lösung
            return -1;
        }else if(wurzel == 0) {
            double x1 = -b / 2;
            return x1;
        }else{
            double x1 = (-b / 2) + Math.sqrt(wurzel);
            double x2 = (-b / 2) - Math.sqrt(wurzel);
        }
        return 0;
    }
}
