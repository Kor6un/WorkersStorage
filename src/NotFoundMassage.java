import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotFoundMassage extends JFrame implements ActionListener{
    JButton back;
    JLabel massage;

    NotFoundMassage () {
        setTitle("Сообщение");
        setSize(200, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel container = new JPanel();
        //container.setLayout(new GridBagLayout());
        back = new JButton("Назад");
        back.addActionListener(this);
        massage = new JLabel("Ничего не найдено");
        container.add(massage, BorderLayout.CENTER);
        container.add(back, BorderLayout.SOUTH);

        this.add(container, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
