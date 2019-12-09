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
public class AddAnExamToAstudentFrame extends JDialog {
	
	private JTextField textFieldCE;
	private JTextField textFieldMatricola;
	private JTextField textFieldVote;

	public AddAnExamToAstudentFrame(Controller ctrl) {
		
		setIconImage(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_control_panel_64px.png")).getImage());
		setTitle("Add panel");
		setMinimumSize(new Dimension(Controller.getAdmin().getWidth() / 2, Controller.getAdmin().getHeight() / 2));
		setLocationRelativeTo(Controller.getAdmin());
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(52, 73, 85));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Add an exam to a student");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		panelTitle.add(lblTitle);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		getContentPane().add(panelMenu, BorderLayout.CENTER);

		JPanel panelCE = new JPanel();
		panelCE.setBackground(Color.WHITE);

		JPanel panelMatricola = new JPanel();
		panelMatricola.setBackground(Color.WHITE);

		JPanel panelVote = new JPanel();
		panelVote.setBackground(Color.WHITE);

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
						.addComponent(panelVote, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelMatricola, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelCE, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
						.addComponent(panelButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addComponent(panelResponse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCE, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(panelMatricola, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(panelVote, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(panelButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(28))
		);

		JLabel lblResponse = new JLabel("");
		panelResponse.add(lblResponse);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setForeground(new Color(74,101,114));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(ctrl.addAnExamToAstudent(textFieldCE.getText(), textFieldMatricola.getText().toUpperCase(), textFieldVote.getText())){
					lblResponse.setForeground(Color.GREEN);
					lblResponse.setText("Exam successfully added to a student.");
				}else {
					lblResponse.setForeground(Color.RED);
					lblResponse.setText("Error occured while adding the exam to the student.");
				}
				
				textFieldCE.setText(null);
				textFieldMatricola.setText(null);
				textFieldVote.setText(null);
			}
		});
		panelButton.add(btnAdd);

		JLabel lblVote = new JLabel("Vote         ");
		lblVote.setForeground(new Color(74,101,114));
		lblVote.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		panelVote.add(lblVote);

		textFieldVote = new JTextField();
		textFieldVote.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		textFieldVote.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textFieldVote.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblResponse.setText(null);
			}
		});
		panelVote.add(textFieldVote);
		textFieldVote.setColumns(15);

		JLabel lblMatricola = new JLabel("Matricola ");
		lblMatricola.setForeground(new Color(74,101,114));
		lblMatricola.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
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

		JLabel lblCE = new JLabel("Exam Cod.");
		lblCE.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		lblCE.setForeground(new Color(74,101,114));
		panelCE.add(lblCE);

		textFieldCE = new JTextField();
		textFieldCE.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		textFieldCE.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textFieldCE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblResponse.setText(null);
			}
		});
		panelCE.add(textFieldCE);
		textFieldCE.setColumns(15);
		panelMenu.setLayout(gl_panelMenu);
	}
}

