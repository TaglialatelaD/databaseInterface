package UI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

import Controller.Controller;
import Student.Student;

@SuppressWarnings("serial")
public class SearchStudentFrame extends JDialog{
	
	private JTextField textField;

	public SearchStudentFrame(Controller ctrl) {
		
		setIconImage(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_control_panel_64px.png")).getImage());
		setTitle("Search panel");
		setMinimumSize(new Dimension(Controller.getAdmin().getWidth() / 2, Controller.getAdmin().getHeight() / 2));
		setLocationRelativeTo(Controller.getAdmin());
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(52, 73, 85));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblStudentsList = new JLabel("Search for a student");
		lblStudentsList.setForeground(Color.WHITE);
		lblStudentsList.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		panelTitle.add(lblStudentsList);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		getContentPane().add(panelMenu, BorderLayout.CENTER);
		
		JPanel panelMatricola = new JPanel();
		panelMatricola.setBackground(Color.WHITE);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(Color.WHITE);
		
		JPanel panelResponse = new JPanel();
		panelResponse.setBackground(Color.WHITE);
		
		JPanel panelStudent = new JPanel();
		panelStudent.setBackground(Color.WHITE);
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelStudent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelMatricola, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelResponse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGap(30)
					.addComponent(panelResponse, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(panelMatricola, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(panelButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelStudent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(36))
		);
		
		JLabel lblResult = new JLabel();
		panelStudent.add(lblResult);
		
		JLabel lblResponse = new JLabel("");
		panelResponse.add(lblResponse);
		
		JButton btnRemove = new JButton("Search");
		btnRemove.setFocusPainted(false);
		btnRemove.setForeground(new Color(74,101,114));
		btnRemove.setBackground(Color.WHITE);
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				Student student = ctrl.searchStudent(textField.getText().toUpperCase());
				
				if(student == null){
					lblResponse.setForeground(Color.RED);
					lblResponse.setText("Student not found");
				}else {
					lblResponse.setForeground(Color.GREEN);
					lblResponse.setText("Student found");
					lblResult.setText(student.getMatricola() + " " + student.getFirstName() +  " " + student.getLastName());
				}
				
				textField.setText(null);
				
			}
		});
		panelButton.add(btnRemove);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setForeground(new Color(74,101,114));
		lblMatricola.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		panelMatricola.add(lblMatricola);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblResponse.setText(null);
			}
		});
		panelMatricola.add(textField);
		textField.setColumns(15);
		panelMenu.setLayout(gl_panelMenu);
	}
}
