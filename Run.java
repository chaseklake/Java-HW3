//import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Run extends JFrame implements ActionListener, MouseMotionListener, MouseListener {
	// All of the components which go into the window
	JPanel window = new JPanel();
	JPanel topMenu = new JPanel();
	JButton btnAddPolice = new JButton("Add Police");
	JButton btnAddTeacher = new JButton("Add Teacher");
	JButton btnAddStudent = new JButton("Add Kid");
	JPanel statusWindow = new JPanel();
	JLabel lblStatusWindowTitle = new JLabel("Status Window:");
	JPanel leftMenu = new JPanel();
	JButton btnGetInfo = new JButton("Get Info");
	JButton btnPayDay = new JButton("Pay Everyone");
	JPanel mainWindow = new JPanel();
	JLabel lblCityHall = new JLabel("City Hall");
	JButton btnCityHall = new JButton("");
	JLabel lblSchool = new JLabel("School");
	JButton btnSchool = new JButton("");
	JTextArea lblStatusInfo = new JTextArea();
	// icons for people
	Icon policeIcon = new ImageIcon(Run.class.getResource("/images/police-icon.png"));
	Icon teacherIcon = new ImageIcon(Run.class.getResource("/images/teacher-icon.png"));
	Icon kidIcon = new ImageIcon(Run.class.getResource("/images/kid-icon.png"));
	
	// rand is for people placement in window
	Random rand = new Random();
	// The currently selected person
	JLabel currentSelect = new JLabel();
	
	// The objects which make up our city
	City lakeTown = new City();
	School school = lakeTown.getSchool();
	CityHall cityHall = lakeTown.getCityHall();
	
	public Run() {
		// This is all setting up the panels and frames
		setSize(480,400);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(window, BorderLayout.CENTER);
		window.setLayout(new BorderLayout(0, 0));
		
		window.add(topMenu, BorderLayout.NORTH);
		topMenu.setBackground(Color.LIGHT_GRAY);
		
		topMenu.add(btnAddPolice);
		
		topMenu.add(btnAddTeacher);		
		
		topMenu.add(btnAddStudent);		
		
		window.add(statusWindow, BorderLayout.SOUTH);
		statusWindow.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		statusWindow.add(lblStatusWindowTitle);
		lblStatusInfo.setText("Nothing Selected");
		
		statusWindow.add(lblStatusInfo);
		
		window.add(leftMenu, BorderLayout.WEST);
		leftMenu.setBackground(Color.LIGHT_GRAY);
		leftMenu.setLayout(new BoxLayout(leftMenu, BoxLayout.Y_AXIS));
		
		leftMenu.add(Box.createGlue());
		leftMenu.add(btnGetInfo);
		
		leftMenu.add(Box.createGlue());
		leftMenu.add(btnPayDay);
		
		leftMenu.add(Box.createGlue());
		
		window.add(mainWindow, BorderLayout.CENTER);
		mainWindow.setBackground(Color.WHITE);
		mainWindow.setLayout(null);
				
		btnSchool.setContentAreaFilled(false);
		btnSchool.setBounds(288, 11, 53, 53);
		mainWindow.add(btnSchool);
		btnSchool.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSchool.setIcon(new ImageIcon(Run.class.getResource("/images/school-icon.png")));
		
		
		lblCityHall.setBounds(20, 68, 39, 14);
		mainWindow.add(lblCityHall);
		
		btnCityHall.setBounds(10, 11, 53, 53);
		mainWindow.add(btnCityHall);
		btnCityHall.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCityHall.setContentAreaFilled(false);
		btnCityHall.setIcon(new ImageIcon(Run.class.getResource("/images/city-hall-icon.png")));
		
		lblSchool.setBounds(298, 68, 46, 14);
		mainWindow.add(lblSchool);
		
		btnSchool.addActionListener(this);
		btnCityHall.addActionListener(this);
		btnPayDay.addActionListener(this);
		btnGetInfo.addActionListener(this);
		btnAddPolice.addActionListener(this);
		btnAddTeacher.addActionListener(this);
		btnAddStudent.addActionListener(this);
		
		this.setVisible(true);
	}
	
	// Drag objects around. If you move things into places, things happen.
	public void mouseDragged(MouseEvent e) {
		if (e.getX() >  -25 && e.getX() <  25
				&& e.getY() >  -25 && e.getY() < 25) {
			currentSelect.setLocation(currentSelect.getX()+ e.getX(), currentSelect.getY()+e.getY());
		}
		
		// Moved something into the City Hall
		if (currentSelect.getY() > 10 && currentSelect.getY() < 65 
				&& currentSelect.getX() >10 && currentSelect.getX() < 64) {
			if (currentSelect.getIcon().equals(policeIcon)) {
				Police temp = new Police();
				cityHall.addOfficer(temp);
				mainWindow.remove(currentSelect);
			} else {
				int x = rand.nextInt(271) + 30;
				int y = rand.nextInt(171) + 80;
				currentSelect.setLocation(x, y);
				lblStatusInfo.setText("Can't add this person to city hall");
			}
		}
		// Moved something into the school
		if (currentSelect.getY() > 10 && currentSelect.getY() < 65 
				&& currentSelect.getX() > 287 && currentSelect.getX() < 341) {
			if (currentSelect.getIcon().equals(teacherIcon)) {
				Teacher temp = new Teacher();
				school.addTeacher(temp);
				mainWindow.remove(currentSelect);
			} else if (currentSelect.getIcon().equals(kidIcon)) {
				Kid temp = new Kid();
				school.addStudent(temp);
				mainWindow.remove(currentSelect);
			} else {
				int x = rand.nextInt(271) + 30;
				int y = rand.nextInt(171) + 80;
				currentSelect.setLocation(x, y);
				lblStatusInfo.setText("Can't add police to school");
			}				
		}
		
		repaint();
	}
	
	// Necessary evils. CurrentSelect is the currently selected JLabel object (the person being dragged)
	public void mouseMoved(MouseEvent e) {;}
	
	public void mousePressed(MouseEvent e) {
		currentSelect = (JLabel)e.getComponent();
	}
	
	public void mouseReleased(MouseEvent e) {;}

	public void mouseEntered(MouseEvent e) {;}
	
	public void mouseExited(MouseEvent e) {;}
	
	public void mouseClicked(MouseEvent e) {
		currentSelect = (JLabel)e.getComponent();
	}
	
	// All button implementations
	public void actionPerformed(ActionEvent e) {
		// School button was pressed
		if (e.getSource() == btnSchool) {
			String lbl = String.format("School Selected. Students: %d/%d  Teachers: %d/%d",
					school.getNumStudents(), lakeTown.getStudents(), 
					school.getNumTeachers(), lakeTown.getTeachers());
			lblStatusInfo.setText(lbl);
			
		} // City Hall button was pressed
		else if (e.getSource() == btnCityHall) {
			String lbl = String.format("City Hall Selected. Officers: %d/%d",
					cityHall.getNumOfficers(), lakeTown.getOfficers());
			lblStatusInfo.setText(lbl);
			
		} // Pay Day button was pressed
		else if (e.getSource() == btnPayDay) {
			lblStatusInfo.setText(lakeTown.payDay());
			
		} // Get Info button was pressed
		else if (e.getSource() == btnGetInfo) {
			lblStatusInfo.setText(lakeTown.getInfo());
			
		} // Add Police button was pressed
		else if (e.getSource() == btnAddPolice) {
			Police officer = new Police();
			lakeTown.addPerson(officer);
			
			JLabel temp = new JLabel();
			temp.setIcon(policeIcon);
			int x = rand.nextInt(271) + 30;
			int y = rand.nextInt(171) + 80;
			temp.setBounds(x, y, 25, 25);
			temp.addMouseListener(this);
			temp.addMouseMotionListener(this);
			mainWindow.add(temp);
			
			lblStatusInfo.setText("Police added");
			repaint();
			
		} // Add Teacher button was pressed
		else if (e.getSource() == btnAddTeacher) {
			Teacher teach = new Teacher();
			lakeTown.addPerson(teach);
			
			JLabel temp = new JLabel();
			temp.setIcon(teacherIcon);
			int x = rand.nextInt(271) + 30;
			int y = rand.nextInt(171) + 80;
			temp.setBounds(x, y, 25, 25);
			temp.addMouseListener(this);
			temp.addMouseMotionListener(this);
			mainWindow.add(temp);
			
			lblStatusInfo.setText("Teacher added");
			repaint();
			
		} // Add Student button was pressed
		else if (e.getSource() == btnAddStudent) {
			Kid kid = new Kid();
			lakeTown.addPerson(kid);
			
			JLabel temp = new JLabel();
			temp.setIcon(kidIcon);
			int x = rand.nextInt(271) + 30;
			int y = rand.nextInt(171) + 80;
			temp.setBounds(x, y, 20, 20);
			temp.addMouseListener(this);
			temp.addMouseMotionListener(this);
			mainWindow.add(temp);
			
			lblStatusInfo.setText("Kid added");
			repaint();
		}
	}

	// Main function which builds all this stuff
	public static void main(String[] args) {
		Run r = new Run();
	}
}