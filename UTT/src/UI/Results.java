package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Database.DBManager;

import main.FlowManager;

import net.miginfocom.swing.MigLayout;

public class Results extends JPanel {
    EditTest        editTest  = new EditTest();
    DBManager       dbManager = new DBManager();
    DetailedResults dtr       = new DetailedResults();
    JPanel          panel_3;
    private JButton backBtn;
    ResultSet       rs;
    String testTitle;
	String name;
    String dateFrom;
    String dateTo;
    

    /**
     * Create the panel.
     */
    public Results() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Результаты поиcка\r\n");

        lblNewLabel.setBounds(316, 32, 221, 33);
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
        backBtn = new JButton("");
        backBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\arrow.png"));
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBackground(new Color(109, 141, 143));
        backBtn.setBounds(10, 10, 39, 33);
        add(backBtn);
    }

    public void addData(MainWindow window, JPanel prevPanel, DetailedResults nextPanel)
            throws SQLException, ParseException {
        dbManager.setConnection();
        
        rs = dbManager.executeQuery("Select * from results where name= '" + name + "' AND testName = '" + testTitle + "'"
        		+ "AND date BETWEEN '" + dateFrom + "' AND '" + dateTo + "'");

        String date1 = rs.getString("date");
        Date   d     = new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").parse(date1);
        String date2 = new SimpleDateFormat("dd.MM.yyyy").format(d);

        while (rs.next()) {
            JPanel panel = new JPanel();

            panel.setLayout(new MigLayout());
            panel.setPreferredSize(new Dimension(700, 50));
            panel.setBackground(new Color(193, 216, 219));

            JButton results = new JButton(rs.getString("testName"));
            results.setBackground(new Color(109, 141, 143));

            results.setPreferredSize(new Dimension(500, 50));

            JPanel date    = new JPanel();
            JPanel name    = new JPanel();
            JLabel dateLbl = new JLabel();
            
            date.setLayout(new MigLayout());
            name.setLayout(new MigLayout());

            date.setPreferredSize(new Dimension(60, 50));
            date.setBackground(new Color(48, 155, 169));
            dateLbl.setText(date2);
            JLabel nameLbl = new JLabel("\n\n" + rs.getString("name"));
            name.setBackground(new Color(48, 155, 169));
            name.setPreferredSize(new Dimension(60, 50));
            panel.setName(rs.getString("date"));
            System.out.println(panel.getName());
            
            
            results.addActionListener(new ActionListener() {
                                          @Override
                                              public void actionPerformed(ActionEvent e) {
                                              nextPanel.setTestName(results.getText());
                                              nextPanel.setDate(panel.getName());
                                             

                                              try {
                                                  nextPanel.addResults();
                                              } catch (SQLException e1) {

                                                  // TODO Auto-generated catch block
                                                  e1.printStackTrace();
                                              }

                                              prevPanel.setVisible(false);
                                              window.add(nextPanel);
                                              nextPanel.setVisible(true);
                                              DisplayImage(nextPanel.getPanel_3(), "picture.jpg");
                                          }
                                      });
            date.add(dateLbl);
            name.add(nameLbl);
            panel.add(date);
            panel.add(results);
            panel.add(name);
            panel_3.add(panel, "gapleft 50");
            nextPanel.back(window, nextPanel, prevPanel);
        }

        dbManager.closeConnection();
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton exitTest) {
        this.backBtn = exitTest;
    }

    public JPanel getPanel_3() {
        return panel_3;
    }

    public void setPanel_3(JPanel panel_3) {
        this.panel_3 = panel_3;
    }
    
    public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
    
    
    private static void DisplayImage(JPanel jp, String url) {
	    JLabel jl=new JLabel();
	    jl.setIcon(new ImageIcon(url));
	    jp.add(jl);
	}
}


//~ Formatted by Jindent --- http://www.jindent.com
