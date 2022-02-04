package UI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

import Database.DBManager;
import main.FlowManager;

import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

public class InTest extends JPanel {
	String testName = "";
	
	EditTest editTest = new EditTest();
	JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JLabel testTitle;
	private JButton exitTest;
	DBManager dbManager = new DBManager();
	ResultSet  rs;
	
	

	/**
	 * Create the panel.
	 * 
	 */
	public InTest() {
		//dbManager.setConnection();
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		testTitle = new JLabel("Тест о лошади Чингиз хана");
		testTitle.setBounds(260, 40, 334, 24);
		testTitle.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(testTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 74, 785, 500);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(193, 216, 219));
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new MigLayout("left center, wrap, gapy 5"));
		
		lblNewLabel_1 = new JLabel("Времени осталось на тест: 40:00:00");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 267, 23);
		add(lblNewLabel_1);
		
		exitTest = new JButton("Выход\r\n");
		exitTest.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		exitTest.setBackground(new Color(109, 141, 143));
		exitTest.setBounds(653, 5, 137, 33);
		add(exitTest);
		
		
		
		
		

	}
	
	
	public JButton getExitTest() {
		return exitTest;
	}

	public void setExitTest(JButton exitTest) {
		this.exitTest = exitTest;
	}
	
	public JPanel getPanel_3() {
		return panel_3;
	}



	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}
	
	public JLabel getTestTitle() {
		return testTitle;
	}


	public void setTestTitle(JLabel testTitle) {
		this.testTitle = testTitle;
	}
	
	
	
	
	public void addData(JPanel panel, String test, int questionAmount) throws SQLException {
		dbManager.setConnection();
		String query = "SELECT * FROM questions where fk_id = (select id from Test where name ='" + test + "')";
		rs = dbManager.executeQuery(query);
		int id;
		while(rs.next()) {
		JPanel qPanel = new JPanel();
		qPanel.setBackground(new Color(193, 216, 219));
		qPanel.setLayout(new MigLayout("left center, wrap, gapy 5"));
		qPanel.setPreferredSize(new Dimension(760, 170));
		JLabel question = new JLabel(rs.getString("question"));
		id = rs.getInt("id");
		question.setBounds(0 , 2 , 760, 25);
		qPanel.add(question);
		
		addRadioButtons(qPanel, id);
		
		panel.add(qPanel);
		
		}	
		dbManager.closeConnection();
		System.out.println("Connetion is closed");
		
	}

	public void addRadioButtons(JPanel panel, int id) throws SQLException {
		ButtonGroup rg = new ButtonGroup();
		ResultSet resultSet = dbManager.executeQuery("SELECT * FROM correctAnswers");
		
		while(resultSet.next()) {
			if(resultSet.getInt("fk_id") == id) {
		System.out.println(resultSet.getString("answer"));
			
		
		JRadioButton answers = new JRadioButton(resultSet.getString("answer"));
		answers.setBackground(new Color(193, 216, 219));
		answers.setBounds(0, 20, 50, 30);
		rg.add(answers);
		panel.add(answers);
		
			}
		}
		
		}

		
		
	
	
	
	
}
