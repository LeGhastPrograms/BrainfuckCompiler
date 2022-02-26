import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class display {

    public static void main(String[] args) {
        JFrame window = new JFrame("Brainfuck Interpreter by LeGhast, 2022");
        JTextField input = new JTextField();
        JLabel outLabel = new JLabel("Output: ");
        JButton compileButton = new JButton("Run Code");
        JPanel buttonPanel = new JPanel();

        BrainfuckInterpreter interpreter = new BrainfuckInterpreter();

        window.setSize(500, 250);
        window.setLayout(null);
        window.add(input);
        window.add(outLabel);
        window.add(buttonPanel);
        buttonPanel.add(compileButton);

        outLabel.setSize(500, 45);
        input.setSize(500, 150);
        buttonPanel.setSize(100, 35);
        compileButton.setSize(100, 35);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input.setLocation(0, 0);
        outLabel.setLocation(0, 150);
        buttonPanel.setLocation(200, 180);

        // window.pack();

        window.setVisible(true);

        compileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outLabel.setText("Output:");
                outLabel.setVisible(false);
                outLabel.setVisible(true);
                String inputText = input.getText();
                String codeReturn = interpreter.runCode(inputText);
                outLabel.setText(outLabel.getText() + codeReturn);
                outLabel.setVisible(false);
                outLabel.setVisible(true);
            }
        });
    }
}
