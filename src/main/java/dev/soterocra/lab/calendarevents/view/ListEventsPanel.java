package dev.soterocra.lab.calendarevents.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListEventsPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListEventsPanel() {
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(151, 114, -55, -86);
		add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);

	}
}
