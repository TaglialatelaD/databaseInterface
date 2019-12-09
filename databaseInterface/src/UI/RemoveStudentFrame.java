package UI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

import Controller.Controller;

@SuppressWarnings("serial")
public class RemoveStudentFrame extends JDialog {
	private JTextField textFieldMatricola;

	public RemoveStudentFrame(Controller ctrl) {
		
		setIconImage(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_control_panel_64px.png")).getImage());
		setTitle("Remove panel");
		setMinimumSize(new Dimension(Controller.getAdmin().getWidth() / 2, Controller.getAdmin().getHeight() / 2));
		setLocationRelativeTo(Controller.getAdmin());
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(74,101,114));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Remove a student");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		panelTitle.add(lblTitle);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		getContentPane().add(panelMenu, BorderLayout.CENTER);
		
		JPanel panelMatricola = new JPanel();
		panelMatricola.setBackground(Color.WHITE);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(Color.WHITE);
		
		JPanel panelResponse = new JPanel();
		panelResponse.setBackground(Color.WHITE);
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addComponent(panelButton, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelMatricola, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelResponse, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
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
					.addComponent(panelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(64))
		);
		
		JLabel lblResponse = new JLabel("");
		panelResponse.add(lblResponse);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFocusPainted(false);
		btnRemove.setForeground(new Color(74,101,114));
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(ctrl.removeStudent(textFieldMatricola.getText().toUpperCase())){
					lblResponse.setForeground(Color.GREEN);
					lblResponse.setText("Student successfully removed.");
				}else {
					lblResponse.setForeground(Color.RED);
					lblResponse.setText("Error occured while removing the student.");
				}
				
				textFieldMatricola.setText(null);
			}
		});
		panelButton.add(btnRemove);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setForeground(new Color(74,101,114));
		lblMatricola.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		panelMatricola.add(lblMatricola);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textFieldMatricola.setBackground(null);
		textFieldMatricola.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
		textFieldMatricola.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblResponse.setText(null);
			}
		});
		panelMatricola.add(textFieldMatricola);
		textFieldMatricola.setColumns(15);
		panelMenu.setLayout(gl_panelMenu);
	}
}
