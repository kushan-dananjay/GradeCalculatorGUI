import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculatorGUI extends JFrame {
    private JTextField markField;
    private JLabel resultLabel;

    public GradeCalculatorGUI() {
        setTitle("Grade Calc -Kushan ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Enter Mark:");
        markField = new JTextField();
        
        // Increase font size for title and input field
        Font biggerFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        titleLabel.setFont(biggerFont);
        markField.setFont(biggerFont);

        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();

        // Increase font size for button
        calculateButton.setFont(biggerFont);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double mark = Double.parseDouble(markField.getText());

                    String grade;

                    if (mark >= 75) {
                        grade = "A";
                    } else if (mark >= 65) {
                        grade = "B";
                    } else if (mark >= 55) {
                        grade = "C";
                    } else if (mark >= 35) {
                        grade = "S";
                    } else {
                        grade = "F";
                    }

                    // Increase font size for result label
                    resultLabel.setFont(biggerFont);
                    resultLabel.setText("                    You Got " + grade);
                } catch (NumberFormatException ex) {
                    resultLabel.setFont(biggerFont);
                    resultLabel.setText("                    Invalid input");
                }
            }
        });

        panel.add(titleLabel);
        panel.add(markField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeCalculatorGUI();
            }
        });
    }
}
