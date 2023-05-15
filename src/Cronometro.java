import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cronometro implements Runnable{
private JTextField jTextField;

    public Cronometro(JTextField jTextField) {
        this.jTextField = jTextField;

    }
        @Override
        public void run() {

            while(true){
                jTextField.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").
                        format(Calendar.getInstance().getTime()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

