package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;

public class SeatChooser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String seatNumber;
	ArrayList al = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatChooser frame = new SeatChooser(new PersonalInfo(new InitialScreen(), new PlaneChooser(new InitialScreen())), 
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
	 */
	public SeatChooser(PersonalInfo pi, InitialScreen is, PlaneChooser pc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Random rand = new Random();
		int  n = rand.nextInt(18);
		int count = 0;
		while(count!=n){
			int r = rand.nextInt(n);
			al.add(r);
			count++;
		}
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(161, 256, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSelectedSeat = DefaultComponentFactory.getInstance().createLabel("Selected Seat:");
		lblSelectedSeat.setBounds(70, 261, 120, 16);
		contentPane.add(lblSelectedSeat);

		JButton btnNext = new JButton("Next");
		SeatChooser self = this;
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatNumber = textField.getText(); 
				setVisible(false);
				BoardingPass bp = new BoardingPass(self,pi, is, pc);
				bp.setVisible(true);
			}
		});
		btnNext.setBounds(401, 284, 117, 29);
		contentPane.add(btnNext);



		JButton btnNewButton = new JButton("2");
		btnNewButton.setOpaque(true);
		if(al.contains(2)){
			btnNewButton.setBackground(Color.RED);
		}else{
			btnNewButton.setBackground(Color.GREEN);
		}
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(2)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("2");
				}
			}
		});
		btnNewButton.setBounds(6, 20, 62, 52);
		contentPane.add(btnNewButton);

		JButton button = new JButton("3");
		button.setOpaque(true);
		if(al.contains(3)){
			button.setBackground(Color.RED);
		}else{
			button.setBackground(Color.GREEN);
		}
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(3)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("3");
				}
			}
		});
		button.setBounds(6, 84, 62, 52);
		contentPane.add(button);

		JButton button_1 = new JButton("5");
		button_1.setOpaque(true);
		if(al.contains(5)){
			button_1.setBackground(Color.RED);
		}else{
			button_1.setBackground(Color.GREEN);
		}
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(5)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("5");
				}
			}
		});
		button_1.setBounds(87, 20, 62, 52);
		contentPane.add(button_1);

		JButton button_2 = new JButton("6");
		button_2.setOpaque(true);
		if(al.contains(6)){
			button_2.setBackground(Color.RED);
		}else{
			button_2.setBackground(Color.GREEN);
		}
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(6)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("6");
				}
			}
		});
		button_2.setBounds(87, 84, 62, 52);
		contentPane.add(button_2);

		JButton button_3 = new JButton("8");
		button_3.setOpaque(true);
		if(al.contains(8)){
			button_3.setBackground(Color.RED);
		}else{
			button_3.setBackground(Color.GREEN);
		}
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(8)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("8");
				}
			}
		});
		button_3.setBounds(161, 20, 62, 52);
		contentPane.add(button_3);

		JButton button_4 = new JButton("9");
		button_4.setOpaque(true);
		if(al.contains(9)){
			button_4.setBackground(Color.RED);
		}else{
			button_4.setBackground(Color.GREEN);
		}
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(9)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("9");
				}
			}
		});
		button_4.setBounds(161, 84, 62, 52);
		contentPane.add(button_4);

		JButton button_5 = new JButton("11");
		button_5.setOpaque(true);
		if(al.contains(11)){
			button_5.setBackground(Color.RED);
		}else{
			button_5.setBackground(Color.GREEN);
		}
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(11)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("11");
				}
			}
		});
		button_5.setBounds(235, 20, 62, 52);
		contentPane.add(button_5);

		JButton button_6 = new JButton("12");
		button_6.setOpaque(true);
		if(al.contains(12)){
			button_6.setBackground(Color.RED);
		}else{
			button_6.setBackground(Color.GREEN);
		}
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(12)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("12");
				}
			}
		});
		button_6.setBounds(235, 84, 62, 52);
		contentPane.add(button_6);

		JButton button_7 = new JButton("14");
		button_7.setOpaque(true);
		if(al.contains(14)){
			button_7.setBackground(Color.RED);
		}else{
			button_7.setBackground(Color.GREEN);
		}
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(14)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("14");
				}
			}
		});
		button_7.setBounds(309, 20, 62, 52);
		contentPane.add(button_7);

		JButton button_8 = new JButton("15");
		button_8.setOpaque(true);
		if(al.contains(15)){
			button_8.setBackground(Color.RED);
		}else{
			button_8.setBackground(Color.GREEN);
		}
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(15)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("15");
				}
			}
		});
		button_8.setBounds(309, 84, 62, 52);
		contentPane.add(button_8);

		JButton button_9 = new JButton("19");
		button_9.setOpaque(true);
		if(al.contains(19)){
			button_9.setBackground(Color.RED);
		}else{
			button_9.setBackground(Color.GREEN);
		}
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(19)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("19");
				}
			}
		});
		button_9.setBounds(383, 20, 62, 52);
		contentPane.add(button_9);

		JButton button_10 = new JButton("18");
		button_10.setOpaque(true);
		if(al.contains(18)){
			button_10.setBackground(Color.RED);
		}else{
			button_10.setBackground(Color.GREEN);
		}
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(18)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("18");
				}
			}
		});
		button_10.setBounds(383, 84, 62, 52);
		contentPane.add(button_10);

		JButton button_11 = new JButton("1");
		button_11.setOpaque(true);
		if(al.contains(1)){
			button_11.setBackground(Color.RED);
		}else{
			button_11.setBackground(Color.GREEN);
		}
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(1)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("1");
				}
			}
		});
		button_11.setBounds(6, 192, 62, 52);
		contentPane.add(button_11);

		JButton button_12 = new JButton("4");
		button_12.setOpaque(true);
		if(al.contains(4)){
			button_12.setBackground(Color.RED);
		}else{
			button_12.setBackground(Color.GREEN);
		}
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(4)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("4");
				}
			}
		});
		button_12.setBounds(87, 192, 62, 52);
		contentPane.add(button_12);

		JButton button_13 = new JButton("7");
		button_13.setOpaque(true);
		if(al.contains(7)){
			button_13.setBackground(Color.RED);
		}else{
			button_13.setBackground(Color.GREEN);
		}
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(7)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("7");
				}
			}
		});
		button_13.setBounds(161, 192, 62, 52);
		contentPane.add(button_13);

		JButton button_14 = new JButton("10");
		button_14.setOpaque(true);
		if(al.contains(10)){
			button_14.setBackground(Color.RED);
		}else{
			button_14.setBackground(Color.GREEN);
		}
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(10)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("10");
				}
			}
		});
		button_14.setBounds(235, 192, 62, 52);
		contentPane.add(button_14);

		JButton button_15 = new JButton("13");
		button_15.setOpaque(true);
		if(al.contains(13)){
			button_15.setBackground(Color.RED);
		}else{
			button_15.setBackground(Color.GREEN);
		}
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(13)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("13");
				}
			}
		});
		button_15.setBounds(309, 192, 62, 52);
		contentPane.add(button_15);

		JButton button_16 = new JButton("16");
		button_16.setOpaque(true);
		if(al.contains(16)){
			button_16.setBackground(Color.RED);
		}else{
			button_16.setBackground(Color.GREEN);
		}
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.contains(16)){
					JOptionPane.showMessageDialog(null, "Seat Taken, Please select another one");
				}else{
					textField.setText("16");
				}
			}
		});
		button_16.setBounds(383, 192, 62, 52);
		contentPane.add(button_16);
	}
	public String getSeatNumber(){
		return seatNumber;
	}
}
