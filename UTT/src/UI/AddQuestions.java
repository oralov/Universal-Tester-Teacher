package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddQuestions extends JPanel {
    private JTextField question;
    private JTextField answer1;
    private JTextField answer2;
    private JTextField asnwer3;
    private JTextField answer4;
    private JTextField answer5;
    JButton            saveTest;
    JButton            nextQuestion;
    JButton            back;
    JCheckBox a1;
	JCheckBox a2;
    JCheckBox a3;
    JCheckBox a4;
    JCheckBox a5;
    private JLabel error;

    

	/**
     * Create the panel.
     */
    public AddQuestions() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);

        JLabel lblNewLabel =
            new JLabel(
                "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0432\u043E\u043F\u0440\u043E\u0441\u044B \u0438 \u043E\u0442\u0432\u0435\u0442\u044B");

        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewLabel.setBounds(231, 40, 292, 30);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u0412\u043E\u043F\u0440\u043E\u0441:\r\n");

        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(76, 140, 85, 29);
        add(lblNewLabel_1);
        question = new JTextField();
        question.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        question.setColumns(10);
        question.setBounds(171, 140, 593, 30);
        add(question);

        JLabel lblNewLabel_2 =
            new JLabel("\u0412\u0430\u0440\u0438\u0430\u043D\u0442\u044B \u043E\u0442\u0432\u0435\u0442\u043E\u0432:");

        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(76, 205, 183, 30);
        add(lblNewLabel_2);
        answer1 = new JTextField();
        answer1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        answer1.setColumns(10);
        answer1.setBounds(105, 268, 593, 30);
        add(answer1);

        JLabel lblNewLabel_1_1 = new JLabel("A:\r\n");

        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(76, 268, 32, 29);
        add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("B:");

        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(76, 308, 32, 29);
        add(lblNewLabel_1_1_1);
        answer2 = new JTextField();
        answer2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        answer2.setColumns(10);
        answer2.setBounds(105, 308, 593, 30);
        add(answer2);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("C:");

        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(76, 347, 32, 29);
        add(lblNewLabel_1_1_1_1);
        asnwer3 = new JTextField();
        asnwer3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        asnwer3.setColumns(10);
        asnwer3.setBounds(105, 347, 593, 30);
        add(asnwer3);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("D:");

        lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1_1_2.setBounds(76, 386, 32, 29);
        add(lblNewLabel_1_1_1_2);
        answer4 = new JTextField();
        answer4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        answer4.setColumns(10);
        answer4.setBounds(105, 386, 593, 30);
        add(answer4);

        JLabel lblNewLabel_1_1_1_2_1 = new JLabel("E:");

        lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1_1_1_2_1.setBounds(76, 426, 32, 29);
        add(lblNewLabel_1_1_1_2_1);
        answer5 = new JTextField();
        answer5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        answer5.setColumns(10);
        answer5.setBounds(105, 426, 593, 30);
        add(answer5);

        JLabel lblNewLabel_2_1 =
            new JLabel("\u041F\u0440\u0430\u0432\u0438\u043B\u044C\u043D\u044B\u0439 \u043E\u0442\u0432\u0435\u0442");

        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2_1.setBounds(671, 206, 129, 30);
        add(lblNewLabel_2_1);

        a1 = new JCheckBox("");

        a1.setBounds(734, 271, 21, 21);
        add(a1);

        a2 = new JCheckBox("");

        a2.setBounds(735, 313, 21, 21);
        add(a2);

        a3 = new JCheckBox("");

        a3.setBounds(734, 352, 21, 21);
        add(a3);

       a4 = new JCheckBox("");

        a4.setBounds(735, 391, 21, 21);
        add(a4);

       a5 = new JCheckBox("");

        a5.setBounds(735, 432, 21, 21);
        add(a5);
        back = new JButton();
        back.setBackground(new Color(193, 216, 219));
        back.setIcon(new ImageIcon("icons/arrow.png"));
        back.setBounds(76, 505, 39, 33);
        add(back);
        saveTest = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0442\u0435\u0441\u0442");
        saveTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        saveTest.setBackground(new Color(109, 141, 143));
        saveTest.setBounds(330, 498, 170, 40);
        add(saveTest);
        nextQuestion = new JButton();
        nextQuestion.setBackground(new Color(109, 141, 143));
        nextQuestion.setIcon(new ImageIcon("icons/arrow-next.png"));
        nextQuestion.setBounds(693, 505, 39, 33);
        add(nextQuestion);
        
        error = new JLabel("");
        error.setBounds(76, 95, 622, 30);
        error.setForeground(Color.red);
        error.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(error);
    }

    public JTextField getAnswer1() {
        return answer1;
    }

    public void setAnswer1(JTextField answer1) {
        this.answer1 = answer1;
    }

    public JTextField getAnswer2() {
        return answer2;
    }

    public void setAnswer2(JTextField answer2) {
        this.answer2 = answer2;
    }

    public JTextField getAnswer4() {
        return answer4;
    }

    public void setAnswer4(JTextField answer4) {
        this.answer4 = answer4;
    }

    public JTextField getAnswer5() {
        return answer5;
    }

    public void setAnswer5(JTextField answer5) {
        this.answer5 = answer5;
    }

    public JTextField getAsnwer3() {
        return asnwer3;
    }

    public void setAsnwer3(JTextField asnwer3) {
        this.asnwer3 = asnwer3;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JButton getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(JButton nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public JTextField getQuestion() {
        return question;
    }

    public void setQuestion(JTextField question) {
        this.question = question;
    }

    public JButton getSaveTest() {
        return saveTest;
    }

    public void setSaveTest(JButton saveTest) {
        this.saveTest = saveTest;
    }
    public JCheckBox getA1() {
		return a1;
	}

	public void setA1(JCheckBox a1) {
		this.a1 = a1;
	}

	public JCheckBox getA2() {
		return a2;
	}

	public void setA2(JCheckBox a2) {
		this.a2 = a2;
	}

	public JCheckBox getA3() {
		return a3;
	}

	public void setA3(JCheckBox a3) {
		this.a3 = a3;
	}

	public JCheckBox getA4() {
		return a4;
	}

	public void setA4(JCheckBox a4) {
		this.a4 = a4;
	}

	public JCheckBox getA5() {
		return a5;
	}

	public void setA5(JCheckBox a5) {
		this.a5 = a5;
	}
	public JLabel getError() {
		return error;
	}

	public void setError(JLabel error) {
		this.error = error;
	}
}


//~ Formatted by Jindent --- http://www.jindent.com
