package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

import main.FlowManager;

import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class ResultsSearch extends JPanel {
	

	private JLabel lblNewLabel_1;
	private JTextField nameOfTest;
	private JLabel lblNewLabel_2;
	private JTextField nameOfUser;
	private JLabel lblNewLabel_3;
	private JTextField from;
	private JLabel lblNewLabel_4;
	private JTextField to;
	private JButton search;
	private JButton backBtn;
	
	/**
	 * Create the panel.
	 */
	public ResultsSearch() {
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Поиск результатов");
		lblNewLabel.setBounds(272, 31, 218, 33);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Название теста");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(149, 163, 137, 24);
		add(lblNewLabel_1);
		
		nameOfTest = new JTextField();
		nameOfTest.setBounds(299, 163, 373, 24);
		add(nameOfTest);
		nameOfTest.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Ф . И . О\r\n");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(149, 213, 137, 24);
		add(lblNewLabel_2);
		
		nameOfUser = new JTextField();
		nameOfUser.setColumns(10);
		nameOfUser.setBounds(299, 213, 373, 24);
		add(nameOfUser);
		
		lblNewLabel_3 = new JLabel("Дата          с");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(149, 263, 137, 24);
		add(lblNewLabel_3);
		
		from = new JTextField();
		from.setColumns(10);
		from.setBounds(299, 263, 114, 24);
		add(from);
		
		lblNewLabel_4 = new JLabel("по");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(477, 263, 32, 24);
		add(lblNewLabel_4);
		
		to = new JTextField();
		to.setColumns(10);
		to.setBounds(558, 266, 114, 24);
		add(to);
		
		search = new JButton("Поиск\r\n");
		search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		search.setBackground(new Color(109, 141, 143));
		search.setBounds(310, 379, 180, 33);
		add(search);
		
		backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\arrow.png"));
		backBtn.setContentAreaFilled(true);
		backBtn.setBounds(10, 10, 39, 33);
		add(backBtn);
		
		
		
		

	}
	
	
	public JButton getSearch() {
		return search;
	}

	public void setSearch(JButton search) {
		this.search = search;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}
	

	
}
