package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;

public class SetTest extends JPanel {
    private JButton    backBtn;
    JButton            editBtn;
    private JTextField name;
    private JTextField amountOfQuestions;
    private JTextField time;
    JButton            startTest;
    JLabel             testLabel;
    private JLabel error;

    

	/**
     * Create the panel.
     */
    public SetTest() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);
        testLabel = new JLabel();
        testLabel.setBounds(307, 40, 303, 34);
        testLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(testLabel);
        backBtn = new JButton("");
        backBtn.setBounds(10, 31, 39, 33);
        backBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\arrow.png"));
        backBtn.setContentAreaFilled(true);
        add(backBtn);

        JLabel lblNewLabel_1 = new JLabel("Введите параметры теста:");

        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(67, 127, 249, 24);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Ф . И . О");

        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(68, 175, 94, 24);
        add(lblNewLabel_2);
        name = new JTextField();
        name.setBounds(172, 175, 471, 24);
        add(name);
        name.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Колличество вопросов в тесте:");

        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_1.setBounds(68, 248, 297, 24);
        add(lblNewLabel_2_1);
        amountOfQuestions = new JTextField();
        amountOfQuestions.setBounds(571, 248, 72, 24);
        add(amountOfQuestions);
        amountOfQuestions.setColumns(10);

        JLabel lblNewLabel_2_1_1 = new JLabel("Время на один вопрос:");

        lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2_1_1.setBounds(67, 310, 297, 24);
        add(lblNewLabel_2_1_1);
        time = new JTextField();
        time.setColumns(10);
        time.setBounds(571, 310, 72, 24);
        add(time);
        startTest = new JButton("Начать тест");
        startTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        startTest.setBackground(new Color(109, 141, 143));
        startTest.setBounds(307, 484, 193, 40);
        add(startTest);
        
        error = new JLabel("");
        error.setBounds(67, 93, 576, 24);
        error.setForeground(Color.red);
        error.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(error);
    }

    public void clear() {
        name.setText("");
        time.setText("");
        amountOfQuestions.setText("");
    }

    public JTextField getAmountOfQuestions() {
        return amountOfQuestions;
    }

    public void setAmountOfQuestions(JTextField amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JButton getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(JButton editBtn) {
        this.editBtn = editBtn;
    }

    public String getName() {
        return name.getText();
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JButton getStartTest() {
        return startTest;
    }

    public void setStartTest(JButton startTest) {
        this.startTest = startTest;
    }

    public JLabel getTestLabel() {
        return testLabel;
    }

    public void setTestLabel(JLabel testLabel) {
        this.testLabel = testLabel;
    }

    public JTextField getTime() {
        return time;
    }

    public void setTime(JTextField time) {
        this.time = time;
    }
    
    public JLabel getError() {
		return error;
	}

	public void setError(JLabel error) {
		this.error = error;
	}
}


//~ Formatted by Jindent --- http://www.jindent.com
