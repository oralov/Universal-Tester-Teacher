package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class MainMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainMenu() {
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UNIVERSAL TESTER TEACHER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(193, 84, 357, 40);
		add(lblNewLabel);
		
		JButton createTest = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0422\u0435\u0441\u0442");
		createTest.setBackground(new Color(109,141,143));
		createTest.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		createTest.setBounds(193, 199, 347, 40);
		add(createTest);
		
		JButton test = new JButton("\u0422\u0435\u0441\u0442\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435");
		test.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		test.setBackground(new Color(109, 141, 143));
		test.setBounds(193, 259, 347, 40);
		add(test);
		
		JButton results = new JButton("\u0410\u0440\u0445\u0438\u0432 \u0440\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442\u043E\u0432\r\n");
		results.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		results.setBackground(new Color(109, 141, 143));
		results.setBounds(193, 321, 347, 40);
		add(results);
		
		JButton about = new JButton("\u0421\u0432\u0435\u0434\u0435\u043D\u0438\u044F \u043E\u0431 \u044D\u0442\u043E\u0439 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0435");
		about.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		about.setBackground(new Color(109, 141, 143));
		about.setBounds(193, 385, 347, 40);
		add(about);

	}

}
