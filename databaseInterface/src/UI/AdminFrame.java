package UI;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.border.LineBorder;

import Controller.Controller;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class AdminFrame extends JFrame {
	
	public AdminFrame(Controller ctrl) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_control_panel_64px.png")).getImage());
		setMinimumSize(new Dimension(1175, 700));
		setTitle("Admin Panel");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setPreferredSize(new Dimension(800, 50));
		panelTitle.setBackground(new Color(74,101,114));
		getContentPane().add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 10));
		
		JLabel lblTitle = new JLabel("Admin Panel");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		panelTitle.add(lblTitle);
		
		JPanel panelActions = new JPanel();
		panelActions.setBorder(new LineBorder(new Color(240, 240, 240), 8));
		getContentPane().add(panelActions, BorderLayout.CENTER);
		panelActions.setLayout(new GridLayout(2, 2, 8, 8));	
		
		JPanel panelAddStudent = new JPanel();
		panelAddStudent.setBackground(Color.WHITE);
		panelActions.add(panelAddStudent);
		panelAddStudent.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblAddStudent = new JLabel("Add a Student");
		lblAddStudent.setName("lblAddStudent");
		lblAddStudent.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblAddStudent.setForeground(new Color(52,73,85));
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStudent.setHorizontalTextPosition(JLabel.CENTER);
		lblAddStudent.setVerticalTextPosition(JLabel.BOTTOM);
		lblAddStudent.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_plus_110px.png")));
		lblAddStudent.addMouseListener(createMouseAdapter(lblAddStudent, panelAddStudent, ctrl));
		panelAddStudent.add(lblAddStudent);
		
		JPanel panelRemoveStudent = new JPanel();
		panelRemoveStudent.setBackground(Color.WHITE);
		panelActions.add(panelRemoveStudent);
		panelRemoveStudent.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblRemoveStudent = new JLabel("Remove a Student");
		lblRemoveStudent.setName("lblRemoveStudent");
		lblRemoveStudent.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblRemoveStudent.setForeground(new Color(52, 73, 85));
		lblRemoveStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveStudent.setHorizontalTextPosition(JLabel.CENTER);
		lblRemoveStudent.setVerticalTextPosition(JLabel.BOTTOM);
		lblRemoveStudent.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_minus_110px.png")));
		lblRemoveStudent.addMouseListener(createMouseAdapter(lblRemoveStudent, panelRemoveStudent, ctrl));
		panelRemoveStudent.add(lblRemoveStudent);
		
		JPanel panelSearchStudent = new JPanel();
		panelSearchStudent.setBackground(Color.WHITE);
		panelActions.add(panelSearchStudent);
		panelSearchStudent.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSearchStudent = new JLabel("Search for a student");
		lblSearchStudent.setName("lblSearchForAstudent");
		lblSearchStudent.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblSearchStudent.setForeground(new Color(52, 73, 85));
		lblSearchStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchStudent.setHorizontalTextPosition(JLabel.CENTER);
		lblSearchStudent.setVerticalTextPosition(JLabel.BOTTOM);
		lblSearchStudent.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_search_110px.png")));
		lblSearchStudent.addMouseListener(createMouseAdapter(lblSearchStudent, panelSearchStudent, ctrl));
		panelSearchStudent.add(lblSearchStudent);
		
		JPanel panelShowAllStudents = new JPanel();
		panelShowAllStudents.setBackground(Color.WHITE);
		panelActions.add(panelShowAllStudents);
		panelShowAllStudents.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelFooter = new JPanel();
		panelFooter.setPreferredSize(new Dimension(800, 50));
		getContentPane().add(panelFooter, BorderLayout.SOUTH);
		panelFooter.setLayout(new BoxLayout(panelFooter, BoxLayout.X_AXIS));
		
		JPanel panelAuthor = new JPanel();
		panelAuthor.setBackground(new Color(74,101,114));
		panelFooter.add(panelAuthor);
		panelAuthor.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 15));
		
		JLabel lblAuthor = new JLabel("Pierluigi Supino");
		lblAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String url_open ="https://github.com/pierluigisupino/databaseInterface.git";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAuthor.setForeground(new Color(249,170,51));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAuthor.setForeground(Color.WHITE);
			}
		});
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		panelAuthor.add(lblAuthor);		
		
		JLabel lblShowAllStudents = new JLabel("Show all the students");
		lblShowAllStudents.setName("lblShowAllStudents");
		lblShowAllStudents.setForeground(new Color(52,73,85));
		lblShowAllStudents.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblShowAllStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowAllStudents.setHorizontalTextPosition(JLabel.CENTER);
		lblShowAllStudents.setVerticalTextPosition(JLabel.BOTTOM);
		lblShowAllStudents.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_user_110px.png")));	
		lblShowAllStudents.addMouseListener(createMouseAdapter(lblShowAllStudents, panelShowAllStudents, ctrl));
		panelShowAllStudents.add(lblShowAllStudents);
		
		JPanel panelAddExam = new JPanel();
		panelAddExam.setBackground(Color.WHITE);
		panelActions.add(panelAddExam);
		panelAddExam.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblAddAnExam = new JLabel("Add an exam");
		lblAddAnExam.setName("lblAddExam");
		lblAddAnExam.setForeground(new Color(52,73,85));
		lblAddAnExam.setBackground(Color.WHITE);
		lblAddAnExam.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblAddAnExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAnExam.setHorizontalTextPosition(JLabel.CENTER);
		lblAddAnExam.setVerticalTextPosition(JLabel.BOTTOM);
		lblAddAnExam.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_plus_110px.png")));
		lblAddAnExam.addMouseListener(createMouseAdapter(lblAddAnExam, panelAddExam, ctrl));
		panelAddExam.add(lblAddAnExam);
		
		JPanel panelRemoveExam = new JPanel();
		panelRemoveExam.setBackground(Color.WHITE);
		panelActions.add(panelRemoveExam);
		panelRemoveExam.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRemoveAnExam = new JLabel("Remove an exam");
		lblRemoveAnExam.setName("lblRemoveExam");
		lblRemoveAnExam.setForeground(new Color(52,73,85));
		lblRemoveAnExam.setBackground(Color.WHITE);
		lblRemoveAnExam.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblRemoveAnExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveAnExam.setHorizontalTextPosition(JLabel.CENTER);
		lblRemoveAnExam.setVerticalTextPosition(JLabel.BOTTOM);
		lblRemoveAnExam.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_minus_110px.png")));
		lblRemoveAnExam.addMouseListener(createMouseAdapter(lblRemoveAnExam, panelRemoveExam, ctrl));	
		panelRemoveExam.add(lblRemoveAnExam);
		
		JPanel panelAddAnExamToAstudent = new JPanel();
		panelAddAnExamToAstudent.setBackground(Color.WHITE);
		panelActions.add(panelAddAnExamToAstudent);
		panelAddAnExamToAstudent.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblAddAnExamToAstudent = new JLabel("Add an exam to a student\r\n");
		lblAddAnExamToAstudent.setName("lblAddAnExamToAstudent");
		lblAddAnExamToAstudent.setForeground(new Color(52,73,85));
		lblAddAnExamToAstudent.setBackground(Color.WHITE);
		lblAddAnExamToAstudent.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblAddAnExamToAstudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAnExamToAstudent.setHorizontalTextPosition(JLabel.CENTER);
		lblAddAnExamToAstudent.setVerticalTextPosition(JLabel.BOTTOM);
		lblAddAnExamToAstudent.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_plus_110px.png")));
		lblAddAnExamToAstudent.addMouseListener(createMouseAdapter(lblAddAnExamToAstudent, panelAddAnExamToAstudent, ctrl));
		panelAddAnExamToAstudent.add(lblAddAnExamToAstudent);
		
		JPanel panelShowAllTheExams = new JPanel();
		panelShowAllTheExams.setBackground(Color.WHITE);
		panelActions.add(panelShowAllTheExams);
		panelShowAllTheExams.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblShowAllTheExams = new JLabel("Show all the exams");
		lblShowAllTheExams.setName("lblShowAllTheExams");
		lblShowAllTheExams.setForeground(new Color(52,73,85));
		lblShowAllTheExams.setBackground(Color.WHITE);
		lblShowAllTheExams.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblShowAllTheExams.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowAllTheExams.setHorizontalTextPosition(JLabel.CENTER);
		lblShowAllTheExams.setVerticalTextPosition(JLabel.BOTTOM);
		lblShowAllTheExams.setIcon(new ImageIcon(AdminFrame.class.getResource("/resources/images/icons8_menu_110px.png")));
		lblShowAllTheExams.addMouseListener(createMouseAdapter(lblShowAllTheExams, panelShowAllTheExams, ctrl));
		panelShowAllTheExams.add(lblShowAllTheExams);
	}
	
	public MouseAdapter createMouseAdapter(JLabel lbl, JPanel panel, Controller ctrl) {
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(242, 242, 242));
			}
			public void mouseExited(MouseEvent e) {
				panel.setBackground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lbl.setForeground(new Color(249,170,51));
				lbl.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 23));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbl.setForeground(new Color(52,73,85));
				lbl.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
				
				if(lbl.getName().equals("lblAddStudent")) {
					ctrl.addStudentFrame();
				}else if(lbl.getName().equals("lblRemoveStudent")) {
					ctrl.removeStudentFrame();
				}else if(lbl.getName().equals("lblSearchForAstudent")) {
					ctrl.searchStudentFrame();
				}else if(lbl.getName().equals("lblShowAllStudents")) {
					ctrl.getAllStudents();
				}else if(lbl.getName().equals("lblAddExam")) {
					ctrl.addExamFrame();
				}else if(lbl.getName().equals("lblRemoveExam")) {
					ctrl.removeExamFrame();
				}else if(lbl.getName().equals("lblAddAnExamToAstudent")) {
					ctrl.addAnExamToAstudentFrame();
				}else if(lbl.getName().equals("lblShowAllTheExams")) {
					ctrl.getAllExams();
					
				}
			}
		};
		
		return mouseAdapter;
	}
}
