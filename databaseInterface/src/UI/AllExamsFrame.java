package UI;


import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.Controller;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class AllExamsFrame extends JDialog{
	private JTable table;
	
	public AllExamsFrame(Controller ctrl) {
		
		setIconImage(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_control_panel_64px.png")).getImage());
		setTitle("Student list panel");
		setMinimumSize(new Dimension(Controller.getAdmin().getWidth() / 2, Controller.getAdmin().getHeight() / 2));
		setLocationRelativeTo(Controller.getAdmin());
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(52,73,85));
		getContentPane().add(panelTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Exams list");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		panelTitle.add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setEnabled(false);
		table.setForeground(new Color(74,101,114));
		table.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		JTableHeader header = table.getTableHeader();
	    header.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
	    header.setForeground(new Color(52,73,85));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Exam Cod.", "Name", "Professor Name"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	public DefaultTableModel getTableModel() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		return model;
	}
	
	
}
