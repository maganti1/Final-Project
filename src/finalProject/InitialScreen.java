package finalProject;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.*;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.StringTokenizer;


@SuppressWarnings("serial")
public class InitialScreen extends JFrame {
	private JPanel contentPane;
	Connection con;
	Statement st;
	ResultSet rs;
	private static InitialScreen frame;
	String departing;
	String destination;
	String date;
	String month;
	String day;
	String year;
	int monthint;
	int dayint;
	int yearint;
	String formattedDate;
	String fm;
	String fd;
	String fy;
	int m;
	int d;
	int y;
	boolean flag;
	private JTextField txtMmddyy;

	@SuppressWarnings("rawtypes")
	public InitialScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//departing combobox
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(200, 57, 209, 29);
		contentPane.add(comboBox_1);

		//destination combobox
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 98, 209, 29);
		contentPane.add(comboBox);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		formattedDate = localDate.toString();

		txtMmddyy = new JTextField();
		txtMmddyy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			  txtMmddyy.setText("");
			}
		});
		txtMmddyy.setHorizontalAlignment(SwingConstants.CENTER);
		txtMmddyy.setText("MM/dd/yyyy");
		txtMmddyy.setBounds(200, 139, 209, 29);
		contentPane.add(txtMmddyy);
		txtMmddyy.setColumns(10);

		JButton btnNext = new JButton("Next");
		InitialScreen is = this;
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				departing = (String)comboBox_1.getSelectedItem();
				destination = (String)comboBox.getSelectedItem();
				date = txtMmddyy.getText();
				if (!dateChecker()) return;
				getDeparting();
				getDestination();
				setVisible(false);
				PlaneChooser pc = new PlaneChooser(is);
				pc.setVisible(true);
			}
		});
		btnNext.setBounds(230, 192, 137, 29);
		contentPane.add(btnNext);

		//Connecting to database to get Departing cities
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root","1234567890");
			st = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_UPDATABLE);
			String query = "select City from Airports"; 
			PreparedStatement p = con.prepareStatement(query);
			rs = p.executeQuery(query);  
			while(rs.next()){
				comboBox_1.setSelectedIndex(-1);
				comboBox_1.addItem(rs.getString(1));
			}
		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "ERROR");
		}try{
			st.close();
			rs.close();
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR CLOSE");
		}
		//Connecting to database to get Destination cities
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root","1234567890");
			st = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_UPDATABLE);
			String query = "select Destination from Destination"; 
			PreparedStatement p = con.prepareStatement(query);
			rs = p.executeQuery(query);  
			while(rs.next()){
				comboBox.setSelectedIndex(-1);
				comboBox.addItem(rs.getString(1));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR");
		}try{
			st.close();
			rs.close();
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR CLOSE");
		}
		JLabel lblSkyBlueReservations = DefaultComponentFactory.getInstance().createTitle("Sky Blue Reservations");
		lblSkyBlueReservations.setBounds(200, 6, 157, 16);
		contentPane.add(lblSkyBlueReservations);

		JLabel lblDeparting = DefaultComponentFactory.getInstance().createLabel("Departing:");
		lblDeparting.setBounds(124, 62, 122, 16);
		contentPane.add(lblDeparting);

		JLabel lblDestination = DefaultComponentFactory.getInstance().createLabel("Destination:");
		lblDestination.setBounds(124, 103, 122, 16);
		contentPane.add(lblDestination);

		JLabel lblDateOfTravel = DefaultComponentFactory.getInstance().createLabel("Date of Travel:");
		lblDateOfTravel.setBounds(109, 145, 120, 16);
		contentPane.add(lblDateOfTravel);

	}
	public String getDeparting(){
		return departing;
	}

	public String getDestination(){
		return destination;
	}

	public boolean dateChecker(){
		date = txtMmddyy.getText();
		StringTokenizer st = new StringTokenizer(date,"/");

		while(st.hasMoreTokens()){
			month = st.nextToken();
			monthint = Integer.parseInt(month);
			day = st.nextToken();
			dayint = Integer.parseInt(day);
			year = st.nextToken();
			yearint = Integer.parseInt(year);
		}

		StringTokenizer st1 = new StringTokenizer(formattedDate, "-");
		while(st1.hasMoreTokens()){
			fy = st1.nextToken();
			y = Integer.parseInt(fy);
			fm = st1.nextToken();
			m = Integer.parseInt(fm);
			fd = st1.nextToken();
			d = Integer.parseInt(fd);

		}
		if(dayint < d && monthint < m && yearint< y){
			JOptionPane.showMessageDialog(null, "Enter Valid Date");
			return false;
		}else{
			return true;
		}
	}
	public String getDate(){ 
		return date;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InitialScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
