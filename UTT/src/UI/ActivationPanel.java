package UI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ActivationPanel extends JPanel {
	private JTextField key;
	private JButton activateBtn;

	/**
	 * Create the panel.
	 */
	public ActivationPanel() {
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		JLabel greetings = new JLabel("\u0414\u043E\u0431\u0440\u043E \u043F\u043E\u0436\u0430\u043B\u043E\u0432\u0430\u0442\u044C \u0432 Universal Tester Teacher \r\n");
		greetings.setHorizontalAlignment(SwingConstants.CENTER);
		greetings.setBounds(151, 52, 517, 29);
		greetings.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(greetings);
		
		JLabel activationRequest = new JLabel("\u041F\u0440\u0435\u0436\u0434\u0435 \u0447\u0435\u043C \u043D\u0430\u0447\u0430\u0442\u044C \u0432\u044B \u0434\u043E\u043B\u0436\u043D\u044B \u0430\u043A\u0442\u0438\u0432\u0438\u0440\u043E\u0432\u0430\u0442\u044C \u043F\u0440\u043E\u0434\u0443\u043A\u0442");
		activationRequest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		activationRequest.setBounds(44, 175, 492, 24);
		add(activationRequest);
		
		JLabel lblNewLabel = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043A\u043B\u044E\u0447 \u043F\u0440\u043E\u0434\u0443\u043A\u0442\u0430:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(44, 258, 223, 29);
		add(lblNewLabel);
		
		key = new JTextField();
		key.setBounds(263, 258, 429, 26);
		add(key);
		key.setColumns(10);
		
	    activateBtn = new JButton("\u0410\u043A\u0442\u0438\u0432\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		activateBtn.setBackground(new Color(109,141,143));
		activateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		activateBtn.setBounds(318, 433, 171, 43);
		activateBtn.setName("activateBtn");
		add(activateBtn);
		
	}

	public JButton getActivateBtn() {
		return activateBtn;
	}

	public void setActivateBtn(JButton activateBtn) {
		this.activateBtn = activateBtn;
	}

	public JTextField getKey() {
		return key;
	}

	public void setKey(JTextField key) {
		this.key = key;
	}
	
}
