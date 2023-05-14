import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painel extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout());
    private JTextField jTextField = new JTextField();
    private JLabel jLabel = new JLabel("Time");
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");
    private Thread threadTime;


    public Painel() {

        setTitle("Cronometro");
        setResizable(false);
        setSize(new Dimension(200,240));
        setLocationRelativeTo(null);


        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(3,14,5,5);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;

        jLabel.setPreferredSize(new Dimension(30,25));
        jPanel.add(jLabel,gridBagConstraints);

        jTextField.setPreferredSize(new Dimension(128,25));
        jTextField.setEnabled(false);
        gridBagConstraints.gridy++;
        jPanel.add(jTextField,gridBagConstraints);


        gridBagConstraints.gridwidth = 1;
        startButton.setPreferredSize(new Dimension(70,25));
        gridBagConstraints.gridy++;
        jPanel.add(startButton,gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        stopButton.setPreferredSize(new Dimension(70,25));
        gridBagConstraints.gridx++;
        jPanel.add(stopButton,gridBagConstraints);
        stopButton.setEnabled(false);

        startButton.addActionListener(e -> {
            threadTime = new Thread(new Cronometro(jTextField));
            threadTime.start();
            stopButton.setEnabled(true);
            startButton.setEnabled(false);


        });

        stopButton.addActionListener(e -> {
            threadTime.stop();
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        });

        add(jPanel, BorderLayout.WEST);

        setVisible(true);
    }
}
