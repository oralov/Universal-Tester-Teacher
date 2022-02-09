package UI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ScrollPaneConstants;

import Beans.Question;
import Database.DBManager;
import main.FlowManager;

import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;

public class FinishTest extends JPanel {
	EditTest editTest = new EditTest();
	JPanel panel_3;
	private JButton exitToMenu;
	ArrayList<Question> questions;
	ArrayList<ButtonGroup> bgArray;

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
	
	
	public void addResults( ArrayList<Question> questions, int amount, ArrayList<ButtonGroup> bGrp) throws SQLException {
		
		panel_3.removeAll();
		this.questions = new ArrayList<Question>();
		this.bgArray = new ArrayList<ButtonGroup>();
		ResultSet rs;
		DBManager dbManager = new DBManager();
		this.questions = questions;
		this.bgArray = bGrp;
		JPanel  questionPanel;
		JPanel container;	
		JLabel text;
		JRadioButton rb;
		
		
		
		for(int i = 0; i <= amount -1; i++) {
			container = new JPanel();
			container.setBackground(new Color(193, 216, 219));
			questionPanel = new JPanel();
			questionPanel.setLayout(new MigLayout("left center, wrap, gapy 5"));
			
			text = new JLabel();
			questionPanel.setPreferredSize(new Dimension(760, 170));
			questionPanel.setBackground(new Color(193, 216, 219));
			text.setText(this.questions.get(i).getQuestionName());
			container.add(text); 
			questionPanel.add(container);
			
			for (Enumeration<AbstractButton> buttons = bgArray.get(i).getElements(); buttons.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();
				JPanel cont = new JPanel();
				cont.setLayout(new MigLayout());
			cont.setBackground(new Color(193, 216, 219));
			button.setBackground(new Color(193, 216, 219));
			
			
			cont.add(button);
			questionPanel.add(cont);
			
			if(button.isSelected()) {
			  dbManager.setConnection();
			  rs = dbManager.executeQuery("SELECT * FROM correctAnswers where fk_id = (SELECT id from questions where question = '" + this.questions.get(i).getQuestionName()
					  + "')");
			  JLabel lbl = new JLabel("");
			  if(button.getText().equals(rs.getString("answer"))) {
				  ImageIcon icon = new ImageIcon("tick.png");
				  Image img = getScaledImage(icon.getImage(), 20, 20);
				  icon = new ImageIcon(img);
				  lbl.setIcon(icon);	
				  lbl.setPreferredSize(new Dimension(10,10));
			  button.setForeground(Color.blue);
			  button.getParent().add(lbl, "gapleft 30" );
			  
			  
			}
			  else {
				  ImageIcon icon = new ImageIcon("cross.png");
				  Image img = getScaledImage(icon.getImage(), 20, 20);
				  icon = new ImageIcon(img);
				  lbl.setIcon(icon);	
				  lbl.setPreferredSize(new Dimension(10,10));
				  button.setForeground(Color.red);
				  button.getParent().add(lbl, "gapleft 30" );

			  }
			  
			}
			
			
			
			panel_3.add(questionPanel);
		}
		}
		
		
		
		
	this.bgArray.clear();
	this.questions.clear();
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (!button.isSelected()) {
            	
            	
                return button.getText();
            }
        }

        return null;
    }
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

	
}
