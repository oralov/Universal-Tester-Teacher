package UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import Database.DBManager;

import javax.swing.JCheckBox;

public class EditQuestion extends JPanel {
	private JTextField question;
	String questionText;
	String answerText1;
	String answerText2;
	String answerText3;
	String answerText4;
	String answerText5;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField asnwer3;
	private JTextField answer4;
	private JTextField answer5;
	JButton saveTest;
	JButton backBtn;
    DBManager dbManager;

	/**
	 * Create the panel.
	 */
	public EditQuestion() {
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u0412\u043E\u043F\u0440\u043E\u0441\u0430");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(267, 29, 292, 30);
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
		
		saveTest = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0418\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u044F");
		saveTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		saveTest.setBackground(new Color(109, 141, 143));
		saveTest.setBounds(292, 520, 231, 40);
		
		
		saveTest.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		      dbManager = new DBManager();
		      dbManager.setConnection();
		      try {
				dbManager.executeUpdate("UPDATE questions SET question ='" + question.getText() + "' WHERE question='" + questionText + "'" );
				dbManager.executeUpdate("UPDATE correctAnswers SET answer = '" + answer1.getText() + "' WHERE answer = '" + answerText1 + "'");
				dbManager.executeUpdate("UPDATE correctAnswers SET answer = '" + answer2.getText() + "' WHERE answer = '" + answerText2 + "'");
				dbManager.executeUpdate("UPDATE correctAnswers SET answer = '" + asnwer3.getText() + "' WHERE answer = '" + answerText3 + "'");
				dbManager.executeUpdate("UPDATE correctAnswers SET answer = '" + answer4.getText() + "' WHERE answer = '" + answerText4 + "'");
				dbManager.executeUpdate("UPDATE wrongAnswers SET answer = '" + answer5.getText() + "' WHERE answer = '" + answerText5 + "'");

				dbManager.closeConnection();
		      } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    }
		});
		
		
		add(saveTest);
		
		
		
		
		
		
		
		
		
		backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\arrow.png"));
		backBtn.setContentAreaFilled(true);
		backBtn.setBounds(10, 26, 39, 33);
		add(backBtn);

	}
	
	public JButton getSaveTest() {
		return saveTest;
	}

	public void setSaveTest(JButton saveTest) {
		this.saveTest = saveTest;
	}
	
	
	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
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
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getAnswerText1() {
		return answerText1;
	}

	public void setAnswerText1(String answerText1) {
		this.answerText1 = answerText1;
	}

	public String getAnswerText2() {
		return answerText2;
	}

	public void setAnswerText2(String answerText2) {
		this.answerText2 = answerText2;
	}

	public String getAnswerText3() {
		return answerText3;
	}

	public void setAnswerText3(String answerText3) {
		this.answerText3 = answerText3;
	}

	public String getAnswerText4() {
		return answerText4;
	}

	public void setAnswerText4(String answerText4) {
		this.answerText4 = answerText4;
	}

	public String getAnswerText5() {
		return answerText5;
	}

	public void setAnswerText5(String answerText5) {
		this.answerText5 = answerText5;
	}
	
	
}
