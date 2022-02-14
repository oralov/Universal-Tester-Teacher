package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateNewTest extends JPanel {
    private JTextField testName;
    JButton            nextBtn;
    JButton            backBtn;

    /**
     * Create the panel.
     */
    public CreateNewTest() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);
        backBtn = new JButton("");
        backBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\arrow.png"));
        backBtn.setBounds(21, 38, 39, 33);
        backBtn.setContentAreaFilled(true);
        add(backBtn);

        JLabel lblNewLabel = new JLabel("\u0422\u0435\u043C\u0430 \u0442\u0435\u0441\u0442\u0430:");

        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(121, 200, 102, 24);
        add(lblNewLabel);

        JLabel lblNewLabel_1 =
            new JLabel(
                "\u0421\u043E\u0437\u0434\u0430\u043D\u0438\u0435 \u043D\u043E\u0432\u043E\u0433\u043E \u0442\u0435\u0441\u0442\u0430");

        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(283, 38, 274, 33);
        add(lblNewLabel_1);
        testName = new JTextField();
        testName.setBounds(226, 200, 437, 24);
        add(testName);
        testName.setColumns(10);
        nextBtn = new JButton("\u0414\u0430\u043B\u0435\u0435");
        nextBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        nextBtn.setBackground(new Color(109, 141, 143));
        nextBtn.setBounds(298, 439, 193, 40);
        add(nextBtn);
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JButton getNextBtn() {
        return nextBtn;
    }

    public void setNextBtn(JButton nextBtn) {
        this.nextBtn = nextBtn;
    }

    public JTextField getTestName() {
        return testName;
    }

    public void setTestName(JTextField testName) {
        this.testName = testName;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
