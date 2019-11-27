package dev.soterocra.lab.calendarevents.view;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dev.soterocra.lab.calendarevents.io.CalendarIO;

public class ListEventsPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListEventsPanel() {
		setLayout(new BorderLayout(0, 0));

		table = new JTable(getDataColumns(), getNameColumns());
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
	}

	private Vector<String> getNameColumns() {
		Vector<String> nameColumns = new Vector<>();

		nameColumns.add("Data");
		nameColumns.add("Descrição");
		nameColumns.add("Periodicidade");
		nameColumns.add("E-mail");
		nameColumns.add("Alarme");

		return nameColumns;
	}

	private Vector<Vector<Object>> getDataColumns() {
		CalendarIO io = new CalendarIO();
		Vector<Vector<Object>> dataColumns = null;

		try {
			dataColumns = io.getEventos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR ARQUIVO", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		
		return dataColumns;

	}

	public void addNewRow(Object[] valores) {
		((DefaultTableModel) table.getModel()).addRow(valores);
	}
}
