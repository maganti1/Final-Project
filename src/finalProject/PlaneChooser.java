package finalProject;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class PlaneChooser extends JFrame {

	private JPanel contentPane;
	private static PlaneChooser frame;
	Connection con;
	Statement st;
	ResultSet rs;
	String Airline;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PlaneChooser(new InitialScreen());
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
	public PlaneChooser(InitialScreen is) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelectYourAirlines = DefaultComponentFactory.getInstance().createTitle("Select Your Airlines:");
		lblSelectYourAirlines.setBounds(140, 6, 153, 16);
		contentPane.add(lblSelectYourAirlines);

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(81, 34, 266, 35);
		contentPane.add(comboBox);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root","1234567890");
			st = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_UPDATABLE);
			String query = "select * from Airplanes"; 
			PreparedStatement p = con.prepareStatement(query);
			rs = p.executeQuery(query);  
			while(rs.next()){
				comboBox.setSelectedIndex(-1);
				comboBox.addItem(rs.getString(1));
			}
		}
		catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		try{
			st.close();
			rs.close();
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR CLOSE");
		}

		JButton btnNext = new JButton("Next");
		PlaneChooser pc = this;
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Airline = (String)comboBox.getSelectedItem();
				getAirline();
				setVisible(false);
				PersonalInfo pi = new PersonalInfo(is,pc);
				pi.setVisible(true);
			}
		});
		btnNext.setBounds(154, 75, 117, 29);
		contentPane.add(btnNext);
	}

	public String getAirline(){
		return Airline;
	}
}
