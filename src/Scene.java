import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scene extends JFrame {
    private JButton buttonConnexion;
    private JTextField textField1;
    private JList list1;
    private JTextArea textAreaMessage;
    private JTextField textFieldMessage;
    private JButton envoyerButton;
    private JPanel mainPanel;
    private JPanel goodPanel;

    private String login;

    public String getLogin(){
        return login;
    }
    public Scene(){
        super();
        setContentPane(goodPanel);
        this.setSize(600,350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        buttonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textField1.getText();
                System.out.println("connexion du " +login);
            }
        });
    }
}
