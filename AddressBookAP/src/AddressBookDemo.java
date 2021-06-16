
/** Code Written by @JameelAhmed
 * email l164324@lhr.nu.edu.pk
 * AP Home Work 1
 * Roll Number 16L-4324 */

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddressBookDemo implements ActionListener {
	@SuppressWarnings("rawtypes")
	ArrayList personsList;
	PersonDAO pDAO;

	JFrame appFrame;

	JLabel jlbCnic, jlbName, jlbAddress, jlbPhone, jlbGender;
	JTextField jtfCnic, jtfName, jtfAddress, jtfPhone, jtfGender;
	JButton jbbSave, jbnDelete, jbnClear, jbnUpdate, jbnSearch, jbnForward, jbnBack, jbnExit;

	String name, address, Gender;
	long phone, cnic;
	int recordNumber; // used to naviagate using >> and << buttons
	Container cPane;

	public static void main(String args[]) {
		new AddressBookDemo();
	}

	public AddressBookDemo() {
		cnic = 0;
		name = "";
		address = "";
		Gender = "";
		phone = 0; // Stores 0 to indicate no Phone Number
		recordNumber = -1;

		createGUI();

		personsList = new ArrayList();

		// creating PersonDAO object
		pDAO = new PersonDAO();

	}

	public void createGUI() {

		/* Create a frame, get its contentpane and set layout */
		appFrame = new JFrame("AP HomeWork 2 Address Book");

		cPane = appFrame.getContentPane();
		cPane.setLayout(new GridBagLayout());

		// Arrange components on contentPane and set Action Listeners to each JButton
		arrangeComponents();

		appFrame.setSize(600, 600);
		appFrame.setResizable(false);
		appFrame.setVisible(true);
		appFrame.getContentPane().setBackground(Color.orange);

		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void arrangeComponents() {
		jlbCnic = new JLabel("CNIC");
		jlbName = new JLabel("Name");
		jlbAddress = new JLabel("Address");
		jlbPhone = new JLabel("Phone");
		jlbGender = new JLabel("Gender");

		jtfName = new JTextField(100);
		jtfAddress = new JTextField(100);
		jtfPhone = new JTextField(100);
		jtfGender = new JTextField(100);
		jtfCnic = new JTextField(100);

		jbbSave = new JButton("Add");
		jbnDelete = new JButton("Delete");
		jbnClear = new JButton("Clear");
		jbnUpdate = new JButton("Update");
		jbnSearch = new JButton("Search");

		jbnForward = new JButton(">>");
		jbnBack = new JButton("<<");
		jbnExit = new JButton("Exit");

		/* add all initialized components to the container */

		GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
		gridBagConstraintsx01.gridx = 0;
		gridBagConstraintsx01.gridy = 0;
		gridBagConstraintsx01.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbName, gridBagConstraintsx01);

		GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
		gridBagConstraintsx02.gridx = 1;
		gridBagConstraintsx02.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx02.gridy = 0;
		gridBagConstraintsx02.gridwidth = 2;
		gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
		cPane.add(jtfName, gridBagConstraintsx02);

		GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
		gridBagConstraintsx03.gridx = 0;
		gridBagConstraintsx03.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx03.gridy = 1;
		cPane.add(jlbAddress, gridBagConstraintsx03);

		GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
		gridBagConstraintsx04.gridx = 1;
		gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx04.gridy = 1;
		gridBagConstraintsx04.gridwidth = 2;
		gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
		cPane.add(jtfAddress, gridBagConstraintsx04);

		GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
		gridBagConstraintsx05.gridx = 0;
		gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx05.gridy = 2;
		cPane.add(jlbPhone, gridBagConstraintsx05);

		GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
		gridBagConstraintsx06.gridx = 1;
		gridBagConstraintsx06.gridy = 2;
		gridBagConstraintsx06.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx06.gridwidth = 2;
		gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
		cPane.add(jtfPhone, gridBagConstraintsx06);

		GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
		gridBagConstraintsx07.gridx = 0;
		gridBagConstraintsx07.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx07.gridy = 3;
		cPane.add(jlbGender, gridBagConstraintsx07);

		GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
		gridBagConstraintsx08.gridx = 1;
		gridBagConstraintsx08.gridy = 3;
		gridBagConstraintsx08.gridwidth = 2;
		gridBagConstraintsx08.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
		cPane.add(jtfGender, gridBagConstraintsx08);

		GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
		gridBagConstraintsx09.gridx = 0;
		gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx09.gridy = 4;
		cPane.add(jlbCnic, gridBagConstraintsx09);

		GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
		gridBagConstraintsx10.gridx = 1;
		gridBagConstraintsx10.gridy = 4;
		gridBagConstraintsx10.gridwidth = 2;
		gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx10.fill = GridBagConstraints.BOTH;
		cPane.add(jtfCnic, gridBagConstraintsx10);

		GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
		gridBagConstraintsx11.gridx = 0;
		gridBagConstraintsx11.gridy = 5;
		gridBagConstraintsx11.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbbSave, gridBagConstraintsx11);

		GridBagConstraints gridBagConstraintsx12 = new GridBagConstraints();
		gridBagConstraintsx12.gridx = 1;
		gridBagConstraintsx12.gridy = 5;
		gridBagConstraintsx12.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnDelete, gridBagConstraintsx12);

		GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
		gridBagConstraintsx13.gridx = 2;
		gridBagConstraintsx13.gridy = 5;
		gridBagConstraintsx13.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnUpdate, gridBagConstraintsx13);

		/*
		 * GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
		 * gridBagConstraintsx14.gridx = 0; gridBagConstraintsx14.gridy = 6;
		 * gridBagConstraintsx14.insets = new Insets(5,5,5,5); cPane.add(jbnBack,
		 * gridBagConstraintsx14);
		 */

		GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
		gridBagConstraintsx15.gridx = 1;
		gridBagConstraintsx15.gridy = 6;
		gridBagConstraintsx15.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnSearch, gridBagConstraintsx15);

		/*
		 * GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
		 * gridBagConstraintsx16.gridx = 2; gridBagConstraintsx16.gridy = 6;
		 * gridBagConstraintsx16.insets = new Insets(5,5,5,5); cPane.add(jbnForward,
		 * gridBagConstraintsx16);
		 */

		GridBagConstraints gridBagConstraintsx17 = new GridBagConstraints();
		gridBagConstraintsx17.gridx = 1;
		gridBagConstraintsx17.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx17.gridy = 7;
		cPane.add(jbnClear, gridBagConstraintsx15);

		GridBagConstraints gridBagConstraintsx18 = new GridBagConstraints();
		gridBagConstraintsx18.gridx = 2;
		gridBagConstraintsx18.gridy = 7;
		gridBagConstraintsx18.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnExit, gridBagConstraintsx18);

		jbbSave.addActionListener(this);
		jbnDelete.addActionListener(this);
		jbnClear.addActionListener(this);
		jbnUpdate.addActionListener(this);
		jbnSearch.addActionListener(this);
		jbnForward.addActionListener(this);
		jbnBack.addActionListener(this);
		jbnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jbbSave) {
			savePerson();
			clear();
		}

		else if (e.getSource() == jbnDelete) {
			deletePerson();
			clear();
		}

		else if (e.getSource() == jbnUpdate) {
			updatePerson();
			clear();
		}

		else if (e.getSource() == jbnSearch) {
			searchPerson();
		}

		else if (e.getSource() == jbnForward) {
			displayNextRecord();
		}

		else if (e.getSource() == jbnBack) {
			displayPreviousRecord();
		}

		else if (e.getSource() == jbnClear) {
			clear();
		}

		else if (e.getSource() == jbnExit) {
			System.exit(0);
		}

	}

	// Save the Person into the Address Book
	public void savePerson() {
		name = jtfName.getText();
		name = name.toUpperCase(); // Save all names in Uppercase
		address = jtfAddress.getText();

		phone = Long.parseLong(jtfPhone.getText());
		Gender = jtfGender.getText();
		cnic = Long.parseLong(jtfCnic.getText());

		if (name.equals("") | address.equals("") | Gender.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter all Details.");
		} else {
			// create a PersonInfo object and pass it to PersonDAO to save it
			PersonInfo person = new PersonInfo(name, address, phone, Gender, cnic);
			pDAO.savePerson(person);
			JOptionPane.showMessageDialog(null, "Person Saved");
		}
	}

	public void deletePerson() {

		// name = jtfName.getText();
		// name = name.toUpperCase();
		cnic = Long.parseLong(jtfCnic.getText());
		if (jtfCnic.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter Cnic to delete.");
		} else {
			// remove Person of the given name from the Address Book database
			int numberOfDeleted = pDAO.removePerson(cnic);
			JOptionPane.showMessageDialog(null, numberOfDeleted + " Record(s) deleted.");
		}
	}

	public void updatePerson() {
		if (jtfCnic.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "No record to Update");

		} else {
			// PersonInfo person = (PersonInfo)personsList.get(recordNumber);

			/* get values from text fields */
			name = jtfName.getText();
			address = jtfAddress.getText();
			phone = Long.parseLong(jtfPhone.getText());
			Gender = jtfGender.getText();
			cnic = Long.parseLong(jtfCnic.getText());

			/* update data of the given person name */
			PersonInfo person = new PersonInfo(name, address, phone, Gender, cnic);
			pDAO.updatePerson(person);

			JOptionPane.showMessageDialog(null, "Person info record updated successfully.");
		}
	}

	// Perform a Case-Insensitive Search to find the Person

	public void searchPerson() 
	{

		name = jtfName.getText();
		name = name.toUpperCase();
		/* clear contents of arraylist if there are any from previous search */
		personsList.clear();

		//recordNumber = 0;

		if (jtfName.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter person Name to search.");
		} 
		else 
		{
			/* get an array list of searched persons using PersonDAO */
			personsList = pDAO.searchPerson(name);

			/*
			 * if(personsList.size() == 0){ JOptionPane.showMessageDialog(null,
			 * "No records found."); //Perform a clear if no records are found. clear(); }
			 * else { downcast the object from array list to PersonInfo PersonInfo person =
			 * (PersonInfo) personsList.get(recordNumber);
			 * 
			 * // displaying search record in text fields jtfName.setText(person.getName());
			 * jtfAddress.setText(person.getAddress());
			 * jtfPhone.setText(""+person.getPhone());
			 * jtfGender.setText(person.getGender()); jtfCnic.setText(""+person.getId()); }
			 */
		}

	}

	public void displayNextRecord() {

		// inc in recordNumber to display next person info, already stored in
		// personsList during search
		recordNumber++;

		if (recordNumber >= personsList.size()) {
			JOptionPane.showMessageDialog(null, "You have reached end of " + "search results");

			/* if user has reached the end of results, disable forward button */
			jbnForward.setEnabled(false);
			jbnBack.setEnabled(true);

			// dec by one to counter last inc
			recordNumber--;
		} else {
			jbnBack.setEnabled(true);
			PersonInfo person = (PersonInfo) personsList.get(recordNumber);

			// displaying search record in text fields
			jtfName.setText(person.getName());
			jtfAddress.setText(person.getAddress());
			jtfPhone.setText("" + person.getPhone());
			jtfGender.setText(person.getGender());
		}
	}

	public void displayPreviousRecord() {

		// dec in recordNumber to display previous person info, already
		// stored in personsList during search
		recordNumber--;

		if (recordNumber < 0) {
			JOptionPane.showMessageDialog(null, "You have reached begining " + "of search results");

			/* if user has reached the begining of results, disable back button */
			jbnForward.setEnabled(true);
			jbnBack.setEnabled(false);

			// inc by one to counter last dec
			recordNumber++;
		} else {
			jbnForward.setEnabled(true);
			PersonInfo person = (PersonInfo) personsList.get(recordNumber);

			// displaying search record in text fields
			jtfName.setText(person.getName());
			jtfAddress.setText(person.getAddress());
			jtfPhone.setText("" + person.getPhone());
			jtfGender.setText(person.getGender());
			jtfCnic.setText("" + person.getId());
		}

	}

	public void clear() {

		jtfName.setText("");
		jtfAddress.setText("");
		jtfPhone.setText("");
		jtfGender.setText("");

		/* clear contents of arraylist */
		recordNumber = -1;
		personsList.clear();
		jbnForward.setEnabled(true);
		jbnBack.setEnabled(true);
	}

}