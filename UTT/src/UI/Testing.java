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
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

public class Testing extends JPanel {
	private JButton backBtn;
	JButton editBtn;
	JPanel panel_3;
	

	/**
	 * Create the panel.
	 */
	public Testing() {
		setBackground(new Color(193, 216, 219));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Тестирование");
		lblNewLabel.setBounds(307, 40, 163, 24);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lblNewLabel);
		
		backBtn = new JButton("");
		backBtn.setBounds(10, 31, 39, 33);
		backBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\arrow.png"));
		backBtn.setContentAreaFilled(true);
		add(backBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 140, 785, 434);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(193, 216, 219));
		//addPanel(panel_3);
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new MigLayout("left center, wrap, gapy 5"));
		
		JLabel lblNewLabel_1 = new JLabel("Выберите тест:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 108, 170, 22);
		add(lblNewLabel_1);
		
		
		
		

	}
	
	
	
	public JButton getEditBtn() {
		return editBtn;
	}

	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}
	

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}
	
	public JPanel getPanel_3() {
		return panel_3;
	}

	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}
}
