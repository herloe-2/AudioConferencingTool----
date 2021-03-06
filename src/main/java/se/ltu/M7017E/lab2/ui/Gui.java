package se.ltu.M7017E.lab2.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import se.ltu.M7017E.lab2.App;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9219551892569083659L;
	private App app;
	private JMenuBar menu;
	private JButton callBtn;
	private JButton hangUpBtn;
	private JList contactsList;
	private JList contactsToCallList;

	public Gui(final App app) {
		this.setJMenuBar(createMenu());
		this.app = app;
		this.setTitle("Audio conferencing tool");
		this.setSize(600, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);// center window on screen
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// use OS' native look'n'feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("Slider.paintValue", false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.add(createButtonPanel());
		this.add(createContactsPanel());

	}

	private JPanel createContactsPanel() {
		JPanel panel = new JPanel();
		JPanel contactsPanel = new JPanel();
		JPanel contactsToCallPanel = new JPanel();
		JButton addBtn = new JButton("Add");
		JButton removeBtn = new JButton("Remove");
		hangUpBtn = new JButton("Hang up");

		this.contactsList = new JList();
		JScrollPane contactScrollPane = new JScrollPane(this.contactsList);
		contactsPanel.setSize(150, 300);
		this.contactsToCallList = new JList();
		JScrollPane contactToCallScrollPane = new JScrollPane(
				this.contactsToCallList);

		// layouts
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		contactsPanel.setLayout(new BoxLayout(contactsPanel, BoxLayout.Y_AXIS));
		contactsToCallPanel.setLayout(new BoxLayout(contactsToCallPanel,
				BoxLayout.Y_AXIS));

		contactsPanel.add(addBtn);
		contactsPanel.add(contactScrollPane);

		contactsToCallPanel.add(removeBtn);
		contactsToCallPanel.add(contactToCallScrollPane);

		panel.add(contactsPanel);
		panel.add(contactsToCallPanel);
		return panel;
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		callBtn = new JButton("Call");
		hangUpBtn = new JButton("Hang up");
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(callBtn);
		panel.add(hangUpBtn);
		return panel;
	}

	private JMenuBar createMenu() {
		this.menu = new JMenuBar();

		JMenu edit = new JMenu("Edit");
		JMenuItem preferences = new JMenuItem("Preferences");
		preferences.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		edit.add(preferences);
		menu.add(edit);

		JMenu help = new JMenu("?");
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								Gui.this,
								"This is a wonderful Audio conferencing tool, really.\nMade by: THE FRENCHIES!\n\n"
										+ "· Flore Diallo\n"
										+ "· Hervé Loeffel\n"
										+ "· Clément Notin", null,
								JOptionPane.INFORMATION_MESSAGE);
			}
		});
		help.add(about);

		menu.add(help);

		return menu;
	}

}
