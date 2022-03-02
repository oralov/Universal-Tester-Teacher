package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class FinishWarning extends JFrame {

	private JPanel contentPane;
JButton finish;
JButton back;
JLabel editableLbl;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishWarning frame = new FinishWarning();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinishWarning() {
		setTitle("\u0412\u044B \u0434\u043E\u043F\u0443\u0441\u0442\u0438\u043B\u0438 \u043E\u0448\u0438\u0431\u043A\u0443?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(193, 216, 219));
		finish = new JButton("\u0417\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044C");
		finish.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		finish.setBounds(326, 142, 117, 34);
		finish.setBackground(new Color(109, 141, 143));
		contentPane.add(finish);
		
		back = new JButton("\u041D\u0430\u0437\u0430\u0434");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		back.setBounds(57, 142, 102, 34);
		back.setBackground(new Color(109, 141, 143));
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("\u0412\u043D\u0438\u043C\u0430\u043D\u0438\u0435!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(193, 10, 110, 34);
		contentPane.add(lblNewLabel);
		
		editableLbl = new JLabel("\u0412\u044B \u043D\u0435 \u043E\u0442\u0432\u0435\u0442\u0438\u043B\u0438 \u043D\u0430 \u0432\u043E\u043F\u0440\u043E\u0441\u044B:");
		editableLbl.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		editableLbl.setBounds(57, 67, 421, 21);
		contentPane.add(editableLbl);
		
		JLabel lblNewLabel_2 = new JLabel("\u0412\u0435\u0440\u043D\u0443\u0442\u044C\u0441\u044F \u0432 \u0442\u0435\u0441\u0442, \u0438\u043B\u0438 \u0437\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044C \u0442\u0435\u0441\u0442?");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(128, 108, 300, 24);
		contentPane.add(lblNewLabel_2);
	}
	
	
	
	
	
	public JButton getFinish() {
		return finish;
	}

	public void setFinish(JButton finish) {
		this.finish = finish;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JLabel getEditableLbl() {
		return editableLbl;
	}

	public void setEditableLbl(JLabel editableLbl) {
		this.editableLbl = editableLbl;
	}
	
}
