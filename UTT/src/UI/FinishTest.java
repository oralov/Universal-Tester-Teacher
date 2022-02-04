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

public class FinishTest extends JPanel {
	EditTest editTest = new EditTest();
	JPanel panel_3;
	private JButton exitToMenu;
	
	/**
	 * Create the panel.
	 */
	public FinishTest() {
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Результаты теста");
		lblNewLabel.setBounds(330, 32, 195, 33);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 88, 785, 486);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(193, 216, 219));
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new MigLayout("left center, wrap, gapy 5"));
		
		exitToMenu = new JButton("Выход\r\n");
		exitToMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		exitToMenu.setBackground(new Color(109, 141, 143));
		exitToMenu.setBounds(10, 31, 137, 33);
		add(exitToMenu);
		
		
		
		

	}
	
	public JButton getExitTest() {
		return exitToMenu;
	}
	public void setExitTest(JButton exitTest) {
		this.exitToMenu = exitTest;
	}

	
	public JPanel getPanel_3() {
		return panel_3;
	}



	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	
}
