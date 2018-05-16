package edu.century.pa6;

/*******************************************************************************
 * Author		:	Nalonsone Danddank										   *
 * Class		:	CSCI 1082												   *
 * Due Date		:	04/17/2018												   *
 * Description 	:	This program defines for build the GUI for a passengers to *
 * 					book a flights. The GUI allow passengers enter the their   *
 * 					informations to apply a reservation. The BookingGUI class  *
 * 					will contain all the GUI components and listeners. It has  *
 *  				an array of Passengers, a method to add passenger to the   *
 *  				passengers array and list all passengers.				   *
 * *****************************************************************************/
//import java awt and swing.
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ScrollPaneLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class BookingGUI extends JFrame implements ActionListener {
	//Initiate instanse aviable.
	private JPanel contentPane;
	private JTextField textFTo;
	private JTextField textFFName;
	private JTextField textFLName;
	private JTextField textFFrom;
	private JTextField textFDeparture;
	private JTextField textFReturn;
	private JComboBox comboBoxSeat;
	private JTextArea textADisplay= new JTextArea();
	//Initiate array Passenger class for get informations from customers. 
	private Passenger[] passengerList;
	private int index = 0;
	
	//Main method for call the frame. 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						BookingGUI frame = new BookingGUI();
						frame.addComponentListener(new ComponentAdapter() {
				            @Override
				            public void componentResized(ComponentEvent e) { 	
				            	frame.titleAlign(frame);
				             } } );
					} catch (Exception e) {
						e.printStackTrace();}}});
			}
	
	 // Create constructor for build the frame.
	public BookingGUI() {
		//Setup the frame.
		setTitle("Fly Any Where");
		UIManager.put("Panel.opaque", Boolean.FALSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,450);
		
		//create 20 the passengers list for hole the customer info. 
		passengerList = new Passenger[20];
		
		//create the content to hole all panel.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setOpaque(false);
		
		//create panel for buttons commands.
		JPanel operationPanel = new JPanel();
		operationPanel.setBorder(new EmptyBorder(2, 2, 2, 2));
		operationPanel.setBackground(new Color(100, 149, 237));
		operationPanel.setOpaque(false);
		contentPane.add(operationPanel, BorderLayout.NORTH);
		operationPanel.setLayout(new BorderLayout(0, 0));
		
		//create panel for input texts from passengers.
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		inputPanel.setOpaque(false);
		operationPanel.add(inputPanel, BorderLayout.CENTER);
		inputPanel.setLayout(new GridLayout(4, 4, 5, 5));
		
		//create the labels.
		JLabel lblFName = new JLabel("First Name");
		lblFName.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.add(lblFName);
		
		//create the text fields.
		textFFName = new JTextField();
		inputPanel.add(textFFName);
		textFFName.setColumns(10);
		
		JLabel lblLName = new JLabel("Last Name");
		lblLName.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.add(lblLName);
		
		textFLName = new JTextField();
		inputPanel.add(textFLName);
		textFLName.setColumns(10);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.add(lblFrom);
		
		textFFrom = new JTextField();
		inputPanel.add(textFFrom);
		textFFrom.setColumns(10);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.add(lblTo);
		
		textFTo = new JTextField();
		inputPanel.add(textFTo);
		textFTo.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.add(lblDeparture);
		
		textFDeparture = new JTextField("MM/dd/yyyy");
		inputPanel.add(textFDeparture);
		textFDeparture.setColumns(10);
		
		JLabel lblReturn = new JLabel("MM/dd/yyyy");
		lblReturn.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.add(lblReturn);
		
		textFReturn = new JTextField("MM/dd/yyyy");
		inputPanel.add(textFReturn);
		textFReturn.setColumns(10);
		
		JLabel lblSeat = new JLabel("Seat");
		lblSeat.setHorizontalAlignment(SwingConstants.TRAILING);
		inputPanel.add(lblSeat);
		
		//create a string array for seats of flights and put in the comboBox.
		String [] seatArr = {"1A","1B","1C","1D","2A","2B","2C",
				"2D","3A","3B","3C","3D","4A","4B","4C","4D","5A"
				,"5B","5C","5D","6A","6B","6C","6D","7A","7B","7C","7D"};
		comboBoxSeat = new JComboBox(seatArr);
		inputPanel.add(comboBoxSeat);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(173, 255, 47));
		buttonPanel.setOpaque(false);
		operationPanel.add(buttonPanel, BorderLayout.SOUTH);
				
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(this);
		buttonPanel.add(btnBook);
		
		JButton btnList = new JButton("List Reservations");
		buttonPanel.add(btnList);
		btnList.addActionListener(this);
		
		JButton btnClear = new JButton("Clear Console");
		buttonPanel.add(btnClear);
		btnClear.addActionListener(this);
		
		//panel for display the text area.
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(130, 135, 144)), "Console", TitledBorder
				.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(displayPanel, BorderLayout.CENTER);
		displayPanel.setLayout(new BorderLayout(0, 0));
		
		//create a scroll for text area.
		JScrollPane scrollPaneDisplay = new JScrollPane(textADisplay);
		scrollPaneDisplay.setToolTipText("");		
		scrollPaneDisplay.setLayout(new ScrollPaneLayout());
		displayPanel.add(scrollPaneDisplay, BorderLayout.CENTER);
		
		//create a menu bar and hole the menu option that including the Items.
		JMenu optionsMenu = new JMenu("Options");
		JMenuItem bookMenuItem = new JMenuItem("Book"),
				listReservMenuItem = new JMenuItem("List Reservations"),
				clearConMenuItem = new JMenuItem("Clear Console");
		bookMenuItem.addActionListener(this);
		listReservMenuItem.addActionListener(this);
		clearConMenuItem.addActionListener(this);
		optionsMenu.add(bookMenuItem);
		optionsMenu.add(listReservMenuItem);
		optionsMenu.add(clearConMenuItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(optionsMenu);
		setJMenuBar(menuBar);
		
        setLocationRelativeTo(null);
		setVisible(true);			
	}
	
	private void titleAlign(JFrame frame) {		
        Font font = frame.getFont();
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
    }
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		//the string for hole command from a click.
		String getCommand = e.getActionCommand();
		//when click the "Book" button, 
		//bookingTest() method will process.
		if(getCommand.equals("Book")) 
			bookingTest();
		//when click the "List Reservations" button, 
		//displayList() method will process.
		else if(getCommand.equals("List Reservations")) 
			displayList(passengerList);		
		//when click the "Clear Console" button, 
		//text area will clear the texts.
		else if(getCommand.equals("Clear Console")) 
			textADisplay.setText("");	
	}
	//Method for getting the information from the GUI 
	//and putting to a new passenger list array.
	private void getpassengerList() {
		Passenger customer = new Passenger();
		customer.setfName(textFFName.getText());
		customer.setlName(textFLName.getText());
		customer.setFrom(textFFrom.getText());
		customer.setTo(textFTo.getText());
		customer.setDepartureDay(
				textFDeparture.getText());
		customer.setReturnDay(				
						textFReturn.getText());
		customer.setSeat(comboBoxSeat.getSelectedItem().toString());
		passengerList[index] = customer;
		index++;	//update for new array.	
	}
	//Display the list of all passengers.
	private void displayList(Passenger[] passengerList) {
		Passenger cus = new Passenger();
		for(int i=0; i<passengerList.length;i++) {
			if(passengerList[i]==null)
				break;
			cus = passengerList[i];
			textADisplay.append("****Reservation "+(i+1)+
					"*******\n"+cus.toString()+"*********End"
							+ "*********\n");
		}		
	}
	//Testing the booking of the test.
	private void bookingTest(){
		//checking if the user putting info to the box before
		//click the book button. 
		if(!(textFFName.getText().equals("")||textFLName.getText()
				.equals("")||textFFrom.getText().equals("")||textFTo
				.getText().equals(""))){
			//Checking appropriate date.
			if(dateTest()){
				//checking if the seat reserved or not.
				if(testEqualSeat()){
					getpassengerList();
					display(textFFName.getText()+" has been reserved!");
					clearInput();
				} else display("Sorry! the seat has been reseved.") ;
			} else display("Invalid Date!!");
		} else display("Please! put the information to all boxs!");}
	
	private boolean dateTest() {
		try{
			//Comparing the date that is appropriately and correctly or not.
			if(0 <((new SimpleDateFormat("MM/dd/yyyy")
						.parse(textFDeparture.getText())).compareTo(
					new SimpleDateFormat("MM/dd/yyyy")
						.parse(textFReturn.getText()))))	
				return false;
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}	
		return true;
	}
	//checking if the seat reserved or not.
	private boolean testEqualSeat() {
		int i = 0;
		while(passengerList[i]!= null){
			if(passengerList[i].getSeat().equals(
					comboBoxSeat.getSelectedItem().toString())){
				return false;
			}	i++;
		}		
		return true;
	}
	//Display the information of passenger's reservation details.
	public void display(String text) {
		textADisplay.append(text +"\n");
	}
	//Clear the texts in the box after click the book button.
	private void clearInput() {
		textFFName.setText("");
		textFLName.setText("");
		textFFrom.setText("");
		textFTo.setText("");
		textFDeparture.setText("MM/dd/yyyy");
		textFReturn.setText("MM/dd/yyyy");
		comboBoxSeat.setSelectedIndex(0);	
	}
}
