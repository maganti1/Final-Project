package finalProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;

@SuppressWarnings("serial")
public class PersonalInfo extends JFrame {
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private String name;
	private String email;
	String dob;
	String month;
	String day;
	String year;
	int yearint;
	private static PersonalInfo frame;
	private JTextField txtMmddyyyy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PersonalInfo(new InitialScreen(), new PlaneChooser(new InitialScreen()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonalInfo(InitialScreen is, PlaneChooser pc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPleaseEnterYour = DefaultComponentFactory.getInstance().createTitle("Please Enter Your Personal Information");
		lblPleaseEnterYour.setBounds(126, 6, 294, 16);
		contentPane.add(lblPleaseEnterYour);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(197, 45, 130, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBounds(197, 84, 130, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtMmddyyyy = new JTextField();
		txtMmddyyyy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMmddyyyy.setText("");
			}
		});
		txtMmddyyyy.setHorizontalAlignment(SwingConstants.CENTER);
		txtMmddyyyy.setText("MM/DD/YYYY");
		txtMmddyyyy.setBounds(197, 122, 130, 26);
		contentPane.add(txtMmddyyyy);
		txtMmddyyyy.setColumns(10);

		JLabel lblDateOfBirth = DefaultComponentFactory.getInstance().createLabel("Date of Birth:");
		lblDateOfBirth.setBounds(106, 127, 120, 16);
		contentPane.add(lblDateOfBirth);

		JButton btnNext = new JButton("Next");
		PersonalInfo self = this;

		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				email = txtEmail.getText();
				name = txtName.getText();
				if (!dateChecker()) return;
				getName();
				getEmail();
				if(!check()) return;
				setVisible(false);
				SeatChooser sc = new SeatChooser(self, is,pc);
				sc.setVisible(true);
			}
		});
		btnNext.setBounds(210, 171, 117, 29);
		contentPane.add(btnNext);

		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name:");
		lblName.setBounds(158, 50, 120, 16);
		contentPane.add(lblName);

		JLabel lblEmail = DefaultComponentFactory.getInstance().createLabel("Email:");
		lblEmail.setBounds(158, 89, 120, 16);
		contentPane.add(lblEmail);

	}
	public boolean dateChecker(){
		dob = txtMmddyyyy.getText();
		StringTokenizer st = new StringTokenizer(dob,"/");

		while(st.hasMoreTokens()){
			month = st.nextToken();
			day = st.nextToken();
			year = st.nextToken();
			yearint = Integer.parseInt(year);
		}
		if(yearint >= 2005){
			JOptionPane.showMessageDialog(null, "You must be atleast 12 years old to fly alone!");
			return false;
		}else{
			return true;
		}
	}
	public boolean check(){
		if(txtMmddyyyy.getText().isEmpty() || txtEmail.getText().isEmpty() || txtName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Please enter all required information");
			return false;
		}else{
			return true;
		}
	}
	public String getEmail(){
		return email;
	}
	public String getName(){
		return name;
	}
}
