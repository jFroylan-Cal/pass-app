package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.app.PasswordGenerator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class window extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtfPassword;
	private JTextField txtfSize;
	JButton btnGenerate;
	PasswordGenerator passGen;
	JRadioButton rbtnAlphaNumeric;
	JRadioButton rbtnAlphaNumSpec;

	/**
	 * Create the frame.
	 */
	public window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		components();
		setTitle("Password Generator");
		setResizable(false);
		setLocationRelativeTo(null);

	}

	private void components() {
		setBounds(100, 100, 440, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Password Generator");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(23, 11, 162, 27);
		contentPane.add(lblTitle);

		txtfPassword = new JTextField();
		txtfPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtfPassword.setBounds(23, 212, 245, 20);
		contentPane.add(txtfPassword);
		txtfPassword.setColumns(10);

		btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(this);
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerate.setBounds(308, 211, 89, 23);
		contentPane.add(btnGenerate);

		JLabel lblAlphaNumeric = new JLabel("Alpha-Numeric");
		lblAlphaNumeric.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlphaNumeric.setBounds(23, 63, 98, 14);
		contentPane.add(lblAlphaNumeric);

		JLabel lblAlphaNumericSpecial = new JLabel("Alpha-Numeric-Special Characters");
		lblAlphaNumericSpecial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlphaNumericSpecial.setBounds(24, 116, 210, 14);
		contentPane.add(lblAlphaNumericSpecial);

		txtfSize = new JTextField();
		txtfSize.setEnabled(false);
		txtfSize.setBounds(51, 162, 46, 20);
		contentPane.add(txtfSize);
		txtfSize.setColumns(10);

		JLabel lblSize = new JLabel("Size: ");
		lblSize.setBounds(23, 165, 46, 14);
		contentPane.add(lblSize);

		rbtnAlphaNumSpec = new JRadioButton("");
		rbtnAlphaNumSpec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfSize.setEnabled(true);
				if(rbtnAlphaNumeric.isSelected()) {
					rbtnAlphaNumeric.setSelected(false);
				}
			}
		});
		rbtnAlphaNumSpec.setBounds(240, 114, 109, 23);
		contentPane.add(rbtnAlphaNumSpec);

		rbtnAlphaNumeric = new JRadioButton("");
		rbtnAlphaNumeric.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfSize.setEnabled(true);
				if(rbtnAlphaNumSpec.isSelected()) {
					rbtnAlphaNumSpec.setSelected(false);
				}
			}
		});
		rbtnAlphaNumeric.setBounds(125, 61, 109, 23);
		contentPane.add(rbtnAlphaNumeric);
	}

	public void setTypeOfPassword(PasswordGenerator passGen) {
		this.passGen = passGen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnGenerate == e.getSource()) {
			if (txtfSize.getText().isEmpty() || txtfSize.getText().equals("") || txtfSize.getText().length() == 0
					|| !txtfSize.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Need a valid password size", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			if (rbtnAlphaNumeric.isSelected()) {
				int size = Integer.parseInt(txtfSize.getText());
				String password = passGen.passwordAlphaNumeric(size);
				txtfPassword.setText(password);
				rbtnAlphaNumeric.setSelected(false);
			}
			if (rbtnAlphaNumSpec.isSelected()) {
				int size = Integer.parseInt(txtfSize.getText());
				String password = passGen.passwordComplete(size);
				txtfPassword.setText(password);
				rbtnAlphaNumSpec.setSelected(false);
			}
		}
	}
}
