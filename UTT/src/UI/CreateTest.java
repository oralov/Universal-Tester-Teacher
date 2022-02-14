package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import main.FlowManager;

import net.miginfocom.swing.MigLayout;

public class CreateTest extends JPanel {
    EditTest        editTest = new EditTest();
    private JButton backBtn;
    private JButton addBtn;
    JPanel          panel_3;

    /**
     * Create the panel.
     */
    public CreateTest() {
        setBackground(new Color(193, 216, 219));
        setLayout(null);

        JLabel lblNewLabel =
            new JLabel(
                "\u0421\u043F\u0440\u0430\u0432\u043E\u0447\u043D\u0438\u043A \u0422\u0435\u0441\u0442\u043E\u0432");

        lblNewLabel.setBounds(281, 31, 226, 24);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(lblNewLabel);
        backBtn = new JButton("");
        backBtn.setBounds(10, 31, 39, 33);
        backBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\arrow.png"));
        backBtn.setContentAreaFilled(true);
        add(backBtn);
        addBtn = new JButton("");
        addBtn.setBounds(751, 98, 39, 33);
        addBtn.setIcon(new ImageIcon("C:\\Users\\oralo\\eclipse-workspace\\UTT\\src\\icons\\plus.png"));
        addBtn.setContentAreaFilled(true);
        add(addBtn);

        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 163, 785, 411);
        scrollPane.setBorder(null);
        add(scrollPane);
        panel_3 = new JPanel();
        panel_3.setBackground(new Color(193, 216, 219));
        scrollPane.setViewportView(panel_3);
        panel_3.setLayout(new MigLayout("left center, wrap, gapy 5"));
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
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


//~ Formatted by Jindent --- http://www.jindent.com
