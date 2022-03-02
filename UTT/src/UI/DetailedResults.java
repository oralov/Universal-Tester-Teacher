package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Beans.Question;

import Database.DBManager;

import main.FlowManager;

import net.miginfocom.swing.MigLayout;

public class DetailedResults extends JPanel {
    String          name      = "Без имени";
    String          testName  = "";
    int             score     = 0;
    DBManager       dbManager = new DBManager();;
    JPanel          panel_3;
    private JButton exitToMenu;
    int             grade;
    String          date;

    /**
     * Create the panel.
     */
    public DetailedResults() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Результаты теста");

        lblNewLabel.setBounds(311, 28, 195, 33);
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
        exitToMenu.setBounds(10, 31, 200, 40);
        
    }

    public JButton getExitToMenu() {
		return exitToMenu;
	}

	public void setExitToMenu(JButton exitToMenu) {
		this.exitToMenu = exitToMenu;
	}

	public void addResults() throws SQLException {
        readPicture("picture.jpg");
        
    }

    public int calcGrade(int score, int amount) {
        grade = score * 100 / amount;

        return grade;
    }

    public void readPicture(String filename) throws SQLException {
        dbManager.setConnection();

        String            selectSQL = "SELECT image FROM results WHERE date= '" + date + "'";
        System.out.println(date);
        ResultSet         rs        = null;
        FileOutputStream  fos       = null;
        PreparedStatement pstmt     = null;

        try {
            rs = dbManager.executeQuery(selectSQL);

            // write binary stream into file
            File file = new File(filename);

            fos = new FileOutputStream(file);
            System.out.println("Writing BLOB to file " + file.getAbsolutePath());

            while (rs.next()) {
                InputStream input  = rs.getBinaryStream("image");
                byte[]      buffer = new byte[2048];

                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (fos != null) {
                    fos.close();
                }
            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }

        dbManager.closeConnection();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public JButton getExitTest() {
        return exitToMenu;
    }

    public void setExitTest(JButton exitTest) {
        this.exitToMenu = exitTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel getPanel_3() {
        return panel_3;
    }

    public void setPanel_3(JPanel panel_3) {
        this.panel_3 = panel_3;
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D    g2         = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
    
    public void back(MainWindow window, JPanel prevPanel, JPanel nextPanel) {
    	exitToMenu.addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				 prevPanel.setVisible(false);
                 window.add(nextPanel);
                 nextPanel.setVisible(true);
				
			}
		 });
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
