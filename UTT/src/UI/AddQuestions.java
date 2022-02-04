package UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class AddQuestions extends JPanel {
	private JTextField question;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField asnwer3;
	private JTextField answer4;
	private JTextField answer5;
	JButton saveTest;
	JButton nextQuestion;
	JButton back;

	/**
	 * Create the panel.
	 */
	public AddQuestions() {
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0432\u043E\u043F\u0440\u043E\u0441\u044B \u0438 \u043E\u0442\u0432\u0435\u0442\u044B");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(231, 40, 292, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0412\u043E\u043F\u0440\u043E\u0441:\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(76, 117, 85, 29);
		add(lblNewLabel_1);
		
		question = new JTextField();
		question.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		question.setColumns(10);
		question.setBounds(171, 116, 593, 30);
		add(question);
		
		JLabel lblNewLabel_2 = new JLabel("\u0412\u0430\u0440\u0438\u0430\u043D\u0442\u044B \u043E\u0442\u0432\u0435\u0442\u043E\u0432:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(76, 205, 183, 30);
		add(lblNewLabel_2);
		
		answer1 = new JTextField();
		answer1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		answer1.setColumns(10);
		answer1.setBounds(105, 268, 593, 30);
		add(answer1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0410:\r\n");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(76, 268, 32, 29);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u0411:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(76, 308, 32, 29);
		add(lblNewLabel_1_1_1);
		
		answer2 = new JTextField();
		answer2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		answer2.setColumns(10);
		answer2.setBounds(105, 308, 593, 30);
		add(answer2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\u0412:");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(76, 347, 32, 29);
		add(lblNewLabel_1_1_1_1);
		
		asnwer3 = new JTextField();
		asnwer3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		asnwer3.setColumns(10);
		asnwer3.setBounds(105, 347, 593, 30);
		add(asnwer3);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("\u0413:");
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(76, 386, 32, 29);
		add(lblNewLabel_1_1_1_2);
		
		answer4 = new JTextField();
		answer4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		answer4.setColumns(10);
		answer4.setBounds(105, 386, 593, 30);
		add(answer4);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("\u0414:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_1.setBounds(76, 426, 32, 29);
		add(lblNewLabel_1_1_1_2_1);
		
		answer5 = new JTextField();
		answer5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		answer5.setColumns(10);
		answer5.setBounds(105, 426, 593, 30);
		add(answer5);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u041F\u0440\u0430\u0432\u0438\u043B\u044C\u043D\u044B\u0439 \u043E\u0442\u0432\u0435\u0442");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(671, 206, 129, 30);
		add(lblNewLabel_2_1);
		
		JCheckBox correct1 = new JCheckBox("");
		correct1.setBounds(734, 271, 21, 21);
		add(correct1);
		
		JCheckBox correct2 = new JCheckBox("");
		correct2.setBounds(735, 313, 21, 21);
		add(correct2);
		
		JCheckBox correct3 = new JCheckBox("");
		correct3.setBounds(734, 352, 21, 21);
		add(correct3);
		
		JCheckBox correct4 = new JCheckBox("");
		correct4.setBounds(735, 391, 21, 21);
		add(correct4);
		
		JCheckBox correct5 = new JCheckBox("");
		correct5.setBounds(735, 432, 21, 21);
		add(correct5);
		
		back = new JButton("\u041D\u0430\u0437\u0430\u0434");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setBackground(new Color(109,141,143));
		back.setBounds(26, 520, 193, 40);
		add(back);
		
		saveTest = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0442\u0435\u0441\u0442");
		saveTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		saveTest.setBackground(new Color(109, 141, 143));
		saveTest.setBounds(292, 520, 193, 40);
		add(saveTest);
		
		nextQuestion = new JButton("\u0421\u043B\u0435\u0434\u0443\u044E\u0449\u0438\u0439 \u0432\u043E\u043F\u0440\u043E\u0441");
		nextQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nextQuestion.setBackground(new Color(109, 141, 143));
		nextQuestion.setBounds(555, 521, 215, 40);
		add(nextQuestion);

	}
	
	public JButton getSaveTest() {
		return saveTest;
	}

	public void setSaveTest(JButton saveTest) {
		this.saveTest = saveTest;
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

	public JTextField getAsnwer3() {
		return asnwer3;
	}

	public void setAsnwer3(JTextField asnwer3) {
		this.asnwer3 = asnwer3;
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
	
	
}
