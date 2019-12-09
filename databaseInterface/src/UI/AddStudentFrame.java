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
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

import Controller.Controller;

@SuppressWarnings("serial")
public class AddStudentFrame extends JDialog {
	
	private JTextField textFieldMatricola;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;

	public AddStudentFrame(Controller ctrl) {
		
		setIconImage(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_control_panel_64px.png")).getImage());
		setTitle("Add panel");
		setMinimumSize(new Dimension(Controller.getAdmin().getWidth() / 2, Controller.getAdmin().getHeight() / 2));
		setLocationRelativeTo(Controller.getAdmin());
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(52, 73, 85));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Add a new student");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		panelTitle.add(lblTitle);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		getContentPane().add(panelMenu, BorderLayout.CENTER);

		JPanel panelMatricola = new JPanel();
		panelMatricola.setBackground(Color.WHITE);

		JPanel panelFirstName = new JPanel();
		panelFirstName.setBackground(Color.WHITE);

		JPanel panelLastName = new JPanel();
		panelLastName.setBackground(Color.WHITE);

		JPanel panelButton = new JPanel();
		panelButton.setBackground(Color.WHITE);

		JPanel panelResponse = new JPanel();
		panelResponse.setBackground(Color.WHITE);

		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelResponse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelLastName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelFirstName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelMatricola, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addComponent(panelResponse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMatricola, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(panelFirstName, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(panelLastName, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(panelButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(28))
		);

		JLabel lblResponse = new JLabel("");
		panelResponse.add(lblResponse);

		JButton btnCreate = new JButton("Add");
		btnCreate.setFocusPainted(false);
		btnCreate.setForeground(new Color(74,101,114));
		btnCreate.setBackground(Color.WHITE);
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(ctrl.addStudent(textFieldMatricola.getText(), textFieldFirstName.getText(), textFieldLastName.getText())) {
					lblResponse.setForeground(Color.GREEN);
					lblResponse.setText("Student successfully added.");
				}else {
					lblResponse.setForeground(Color.RED);
					lblResponse.setText("Error occured while adding the student.");
				}
				
				textFieldMatricola.setText(null);
				textFieldFirstName.setText(null);
				textFieldLastName.setText(null);
			}
		});
		panelButton.add(btnCreate);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(74,101,114));
		lblLastName.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		panelLastName.add(lblLastName);

		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		textFieldLastName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textFieldLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblResponse.setText(null);
			}
		});
		panelLastName.add(textFieldLastName);
		textFieldLastName.setColumns(15);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(74,101,114));
		lblFirstName.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		panelFirstName.add(lblFirstName);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		textFieldFirstName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textFieldFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblResponse.setText(null);
			}
		});
		panelFirstName.add(textFieldFirstName);
		textFieldFirstName.setColumns(15);

		JLabel lblMatricola = new JLabel("Matricola   ");
		lblMatricola.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		lblMatricola.setForeground(new Color(74,101,114));
		panelMatricola.add(lblMatricola);

		textFieldMatricola = new JTextField();
		textFieldMatricola.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		textFieldMatricola.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
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
