
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI2 implements ActionListener {

    private static JLabel U_label;
    private static JTextField userText;
    private static JLabel P_label;
    private static JPasswordField passwordText;
    private static JLabel S_label;
    private static JLabel Sum_label;
    private static JLabel Avg_label;
    private static JButton button;
    private static JButton button2;
    private static JButton button3;
    private static JButton button4;
    private static JTextField input;

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        frame.setTitle("Login & Calculator (Sorta)");

        panel.setLayout(null);

        U_label = new JLabel("User");
        U_label.setBounds(10, 20, 80, 25);
        panel.add(U_label);

        P_label = new JLabel("Password");
        P_label.setBounds(10, 50, 80, 25);
        panel.add(P_label);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        passwordText.setVisible(true);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.setToolTipText("Click this button to login");
        button.addActionListener(new GUI2());
        button.setActionCommand("login1");
        panel.add(button);

        button2 = new JButton("Log out");
        button2.setBounds(100, 80, 150, 25);
        button2.addActionListener(new GUI2());
        button2.setToolTipText("Log out");
        button2.setActionCommand("logout");
        panel.add(button2);

        input = new JTextField(50);
        input.setBounds(300, 20, 165, 25);
        panel.add(input);
        input.setVisible(false);

        button3 = new JButton("Get Sum");
        button3.setBounds(300, 60, 100, 25);
        button3.setToolTipText("Click here to get the sum");
        button3.setActionCommand("Sum");
        button3.addActionListener(new GUI2());
        panel.add(button3);
        button3.setVisible(false);

        button4 = new JButton("Get Average");
        button4.setBounds(400, 60, 100, 25);
        button4.setToolTipText("Click here to get the Average");
        button4.setActionCommand("Avg");
        button4.addActionListener(new GUI2());
        panel.add(button4);
        button4.setVisible(false);

        Sum_label = new JLabel("");
        Sum_label.setBounds(300, 100, 200, 25);
        panel.add(Sum_label);

        Avg_label = new JLabel("");
        Avg_label.setBounds(300, 150, 200, 25);
        panel.add(Avg_label);

        S_label = new JLabel();
        S_label.setBounds(10, 110, 300, 25);
        panel.add(S_label);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand(); // gets which specific button the action event is coming from
        String user = userText.getText();
        String password = passwordText.getText();

        switch (command) {

            case "login1":

                if (user.contentEquals("Grape") && password.equals("grape")) {
                    S_label.setText("Logged in with button 1");
                    input.setVisible(true);
                    button3.setVisible(true);
                    button4.setVisible(true);
                    userText.setText("");
                    passwordText.setText("");
                } else {
                    S_label.setText("");
                }

                break;

            case "logout":

                S_label.setText("Logged out");
                input.setVisible(false);
                button3.setVisible(false);
                button4.setVisible(false);
                Sum_label.setText("");
                Avg_label.setText("");
                userText.setText("");
                passwordText.setText("");

                break;

            case "Sum":

                int sum = GUI2.GetSum();
                String s = Integer.toString(sum);

                Sum_label.setText("The sum is: " + s);

                break;

            case "Avg":

                double avg = GUI2.GetAvg();
                String a = Double.toString(avg);

                Avg_label.setText("The average is: " + a);

        }

    }

    public static int GetSum() {

        int sum = 0;

        int[] dataArray = GUI2.GetIntArray();

        for (int j = 0; j < dataArray.length; j++) {
            sum += dataArray[j];
        }
        return sum;
    }

    public static double GetAvg() {

        double avg = 0;

        int sum = GUI2.GetSum();

        int[] data = GUI2.GetIntArray();

        avg = (double) (sum) / (data.length);

        return avg;

    }

    public static int[] GetIntArray() {

        String data = input.getText();
        String[] dataSArray = data.split(", ");
        int[] dataArray = new int[dataSArray.length];

        for (int i = 0; i < dataSArray.length; i++) {
            dataArray[i] = Integer.parseInt(dataSArray[i]);
        }
        return dataArray;

    }
}
