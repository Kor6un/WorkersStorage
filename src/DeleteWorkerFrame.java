import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWorkerFrame extends JFrame implements ActionListener{

    /*private JLabel textName;
    private JLabel textSurname;*/
    private JLabel textPassport;
    private JTextField name;
    private JTextField surname;
    private JTextField passportNumber;
    private JButton ok;
    private JButton clear;
    private JButton back;

    public DeleteWorkerFrame () {
        setSize(400, 150);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete worker window");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        /*textName = new JLabel("Enter name");
        name = new JTextField();
        textSurname = new JLabel("Enter surname");
        surname = new JTextField();*/
        textPassport = new JLabel("Enter passport number");
        passportNumber = new JTextField();

       /* panel.add(textName);
        panel.add(name);
        panel.add(textSurname);
        panel.add(surname);*/
        panel.add(textPassport);
        panel.add(passportNumber);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(3,1));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));

        ok = new JButton("Ok");
        ok.setActionCommand("Delete");
        ok.addActionListener(this);
        clear = new JButton("Clear");
        clear.setActionCommand("Clear");
        clear.addActionListener(this);
        back = new JButton("Back");
        back.setActionCommand("Back");
        back.addActionListener(this);
        buttonPanel.add(ok);
        buttonPanel.add(clear);
        buttonPanel.add(back);

        add(panel,BorderLayout.CENTER);
        container.add(buttonPanel);

        add(container, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String res = e.getActionCommand();
        switch (res) {
            case "Delete":
                for (int i = 0; i < WorkersTable.workers.size(); i++) {
                    if (passportNumber.getText() != null || !passportNumber.getText().isEmpty()) {
                        if (passportNumber.getText().equals(WorkersTable.workers.get(i).getPassportNumber())) {
                            WorkersTable.workers.remove(i);
                        }
                    }
                }
                MainFrame.workersTable.fireTableDataChanged();
                this.dispose();
                break;
            case "Clear":
                name.setText("");
                surname.setText("");
                passportNumber.setText("");
                break;
            case "Back":
                this.dispose();
                break;
            default:
                this.dispose();
                break;
        }
    }
}
