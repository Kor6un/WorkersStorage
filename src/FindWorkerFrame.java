import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FindWorkerFrame extends JFrame implements ActionListener {
    private JLabel findBy;
    private JTextField findField;
    private JButton ok;
    private JButton clear;
    private JButton back;
    private JComboBox choice;

    private JTable results;
    private String[] header = WorkersTable.header;
    private List<Worker> findWorkers = new ArrayList<>();
    public static FindWorkersTable findWorkersTable;


    public FindWorkerFrame() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Find worker window");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(10, 1));


        findBy = new JLabel("Найти по");
        choice = new JComboBox();
        choice.addItem("по имени");
        choice.addItem("по фамилии");
        choice.addItem("по номеру паспорта");

        findField = new JTextField();

        ok = new JButton("Найти");
        ok.setActionCommand("Find");
        ok.addActionListener(this);
        clear = new JButton("Очистить");
        clear.setActionCommand("Clear");
        clear.addActionListener(this);
        back = new JButton("Назад");
        back.setActionCommand("Back");
        back.addActionListener(this);

        leftPanel.add(findBy);
        leftPanel.add(choice);
        leftPanel.add(findField);
        leftPanel.add(ok);
        leftPanel.add(clear);
        leftPanel.add(back);

        this.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();

        rightPanel.setLayout(new GridLayout(1, 1));
        findWorkersTable = new FindWorkersTable(findWorkers, header);
        findWorkersTable.fireTableDataChanged();
        results = new JTable(findWorkersTable);

        rightPanel.add(new JScrollPane(results), BorderLayout.CENTER);

        this.add(rightPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int result = choice.getSelectedIndex();
        String res = e.getActionCommand();

        switch (res) {
            case "Find":
                if (result == 0) {
                    findByName();
                } else if (result == 1) {
                    findBySurname();
                    repaint();
                } else if (result == 2) {
                    findByPassport();
                    repaint();
                }
                break;
            case "Clear":
                findField.setText("");
                findWorkers.clear();
                findWorkersTable.fireTableDataChanged();
                break;
            case "Back":
                this.dispose();
                break;
            default:
                this.dispose();
                break;
        }
    }

    private void findByName() {
        if (!findWorkers.isEmpty()){
            findWorkers = new ArrayList<>();
        }
        String name = findField.getText();
        for (int i = 0; i < WorkersTable.workers.size(); i++) {
            if (WorkersTable.workers.get(i).getName().equals(name)) {
                findWorkers.add(WorkersTable.workers.get(i));
            }
        }
        findWorkersTable.fireTableDataChanged();
    }

    private void findBySurname() {
        String surname = findField.getText();
        for (int i = 0; i < WorkersTable.workers.size(); i++) {
            if (WorkersTable.workers.get(i).getSurname().equals(surname)) {
                findWorkers.add(WorkersTable.workers.get(i));
            }
        }
        findWorkersTable.fireTableDataChanged();
    }

    private void findByPassport() {
        String passport = findField.getText();
        for (int i = 0; i < WorkersTable.workers.size(); i++) {
            if (WorkersTable.workers.get(i).getPassportNumber().equals(passport)) {
                findWorkers.add(WorkersTable.workers.get(i));
            }
        }
        findWorkersTable.fireTableDataChanged();
    }
}
