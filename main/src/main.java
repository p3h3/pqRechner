import javax.swing.*;
import java.awt.*;

public class main {

    private static JFrame f;

    public static void main(String[] args){
        f = new JFrame("wunderbarer pq rechner");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel subPanel1 = new JPanel(new FlowLayout());

        // Begrüßung :)
        subPanel1.add(new JLabel("Hallo in Tereza's tollem PQ-Formel rechner!"));

        // a eingabe & label
        JPanel subPanel2 = new JPanel(new GridLayout(1,2));
        subPanel2.add(new JLabel("Gib a ein:", SwingConstants.CENTER));
        JTextField aField = new JTextField();
        subPanel2.add(aField);

        // b eingabe & label
        JPanel subPanel3 = new JPanel(new GridLayout(1,2));
        subPanel3.add(new JLabel("Gib b ein:", SwingConstants.CENTER));
        JTextField bField = new JTextField();
        subPanel3.add(bField);

        // c eingabe & label
        JPanel subPanel4 = new JPanel(new GridLayout(1,2));
        subPanel4.add(new JLabel("Gib c ein:", SwingConstants.CENTER));
        JTextField cField = new JTextField();
        subPanel4.add(cField);

        // ausgabe / berechnen button wuu
        JPanel subPanel5 = new JPanel(new GridLayout(1,2));
        JLabel ausgabeLabel = new JLabel("L={}", SwingConstants.CENTER);
        JButton berechnenButton = new JButton("Ausrechnen!");
        berechnenButton.addActionListener(e -> {
            // get variables from textfields and parse them to doubles
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());

                // p&q auf a=1 bringen
                b /= a;
                c /= a;

                double wurzel = (Math.pow(b, 2) / 4) - c;

                if(wurzel < 0){
                    // keine Lösung
                    ausgabeLabel.setText("Es gibt keine Lösung!");
                }else if(wurzel == 0) {
                    double x1 = -b / 2;
                    ausgabeLabel.setText("L={" + x1 + "}");
                }else{
                    double x1 = (-b / 2) + Math.sqrt(wurzel);
                    double x2 = (-b / 2) - Math.sqrt(wurzel);
                    ausgabeLabel.setText("L={" + x1 + ";" + x2 + "}");
                }

            // catching errors that could occur while parsing doubles from strings
                // (maybe there are letters in the input)
            } catch (NumberFormatException exception){
                ausgabeLabel.setText("Bitte gebe Zahlen ein!");
            }
        });

        subPanel5.add(berechnenButton);
        subPanel5.add(ausgabeLabel);

        // add all horizontal subPanels to vertical main Panel
        panel.add(subPanel1);
        panel.add(subPanel2);
        panel.add(subPanel3);
        panel.add(subPanel4);
        panel.add(subPanel5);


        // get screen size to make window size relative
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // stop process on close of main window
        f.setSize((int) (screenSize.width * 0.3), (int) (screenSize.height * 0.4));
        f.getContentPane().add(panel);
        f.setVisible(true); // making the frame visible

    }
}
