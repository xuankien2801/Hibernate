package vn.edu.hcmus.fit.sv18120045.hibernate;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	JLabel emailLabel = new JLabel("E-MAIL");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JTextField emailTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("Show Password");
	
	LoginFrame(){
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}
	
	public void setLocationAndSize() {
		emailLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		emailTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(emailLabel);
		container.add(passwordLabel);
		container.add(emailTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
	}
	
	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		//LOGIN Button
		if (e.getSource() == loginButton) {
			String emailText;
			String passText;
			emailText = emailTextField.getText();
			passText = passwordField.getText();
			if (emailText.equalsIgnoreCase("admin") && passText.equalsIgnoreCase("admin")) {
				JOptionPane.showMessageDialog(this, "Login Succesful");
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Email or Password");
			}	
		}
		
		//RESET Button
		if (e.getSource() == resetButton) {
            emailTextField.setText("");
            passwordField.setText("");
        }

		//showPassword CHECKBOX
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
	}
	
	public static void main(String[] a) {
		LoginFrame frame = new LoginFrame();
		frame.setTitle("LOGIN FORM");
		frame.setVisible(true);
		frame.setBounds(10, 10, 370, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
}

