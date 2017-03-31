package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BoardingPass extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardingPass frame = new BoardingPass(new SeatChooser(new PersonalInfo(new InitialScreen(), 
							new PlaneChooser(new InitialScreen())), new InitialScreen(), new PlaneChooser(new InitialScreen())), 
							new PersonalInfo(new InitialScreen(), new PlaneChooser(new InitialScreen())), 
							new InitialScreen(), new PlaneChooser(new InitialScreen()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param sc 
	 */
	public BoardingPass(SeatChooser sc, PersonalInfo pi, InitialScreen is, PlaneChooser pc) {
		//PersonalInfo pi = new PersonalInfo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//name
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(76, 60, 196, 26);
		textField.setText(pi.getName());
		contentPane.add(textField);
		textField.setColumns(10);

		//email
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(328, 60, 196, 26);
		textField_1.setText(pi.getEmail());
		contentPane.add(textField_1);


		//depart
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(76, 116, 196, 26);
		textField_2.setText(is.departing);
		contentPane.add(textField_2);

		//dest
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(328, 116, 196, 26);
		textField_3.setText(is.destination);
		contentPane.add(textField_3);

		//date
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(76, 168, 196, 26);
		textField_4.setText(is.getDate());
		contentPane.add(textField_4);

		//airline
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(328, 168, 196, 26);
		textField_5.setText(pc.getAirline());
		contentPane.add(textField_5);

		//seatNumber
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setBounds(236, 234, 130, 26);
		textField_6.setText(sc.getSeatNumber());
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblBoardingPass = DefaultComponentFactory.getInstance().createTitle("Boarding Pass");
		lblBoardingPass.setBounds(236, 6, 188, 16);
		contentPane.add(lblBoardingPass);

		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name:");
		lblName.setBounds(76, 44, 122, 16);
		contentPane.add(lblName);

		JLabel lblEmail = DefaultComponentFactory.getInstance().createLabel("Email:");
		lblEmail.setBounds(328, 44, 120, 16);
		contentPane.add(lblEmail);

		JLabel lblDepartingCity = DefaultComponentFactory.getInstance().createLabel("Departing City:");
		lblDepartingCity.setBounds(76, 102, 120, 16);
		contentPane.add(lblDepartingCity);

		JLabel lblDestinantionCity = DefaultComponentFactory.getInstance().createLabel("Destination City:");
		lblDestinantionCity.setBounds(328, 102, 120, 16);
		contentPane.add(lblDestinantionCity);

		JLabel lblDateOfTravel = DefaultComponentFactory.getInstance().createLabel("Date of Travel:");
		lblDateOfTravel.setBounds(76, 154, 120, 16);
		contentPane.add(lblDateOfTravel);

		JLabel lblAirline = DefaultComponentFactory.getInstance().createLabel("Airline:");
		lblAirline.setBounds(328, 154, 120, 16);
		contentPane.add(lblAirline);

		JLabel lblSeatNumber = DefaultComponentFactory.getInstance().createLabel("Seat Number:");
		lblSeatNumber.setBounds(236, 217, 120, 16);
		contentPane.add(lblSeatNumber);

		JButton btnCancel = new JButton("close");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(457, 314, 117, 29);
		contentPane.add(btnCancel);
	}
}


