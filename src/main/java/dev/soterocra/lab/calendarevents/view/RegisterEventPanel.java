package dev.soterocra.lab.calendarevents.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dev.soterocra.lab.calendarevents.entities.Event;
import dev.soterocra.lab.calendarevents.entities.enums.FrequencyEnum;
import dev.soterocra.lab.calendarevents.io.CalendarIO;
import dev.soterocra.lab.calendarevents.utils.CalendarUtils;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class RegisterEventPanel extends JPanel {
	private JTextField tfDescEvento;
	private JTextField tfDtEvento;
	private JTextField tfEncaminharEmail;
	private JCheckBox ckbAlarm;
	private JRadioButton rdbUmavez;
	private JRadioButton rdbSemanal;
	private JRadioButton rdbMensal;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private ListEventsPanel listaEventos;

	/**
	 * Create the panel.
	 */
	public RegisterEventPanel(ListEventsPanel listaEventosPanel) {
		setLayout(null);

		this.listaEventos = listaEventosPanel;

		JLabel lblDescEvento = new JLabel("Descrição do Evento");
		lblDescEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescEvento.setBounds(10, 11, 127, 14);
		add(lblDescEvento);

		tfDescEvento = new JTextField();
		tfDescEvento.setBounds(10, 30, 430, 20);
		add(tfDescEvento);
		tfDescEvento.setColumns(10);

		JLabel lblDataEvento = new JLabel("Data do Evento");
		lblDataEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataEvento.setBounds(10, 61, 127, 14);
		add(lblDataEvento);

		JLabel lblEncaminharEmail = new JLabel("Encaminhar e-mail");
		lblEncaminharEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEncaminharEmail.setBounds(10, 86, 127, 14);
		add(lblEncaminharEmail);

		JLabel lblPeriodicidadeDoEvento = new JLabel("Periodicidade do Evento");
		lblPeriodicidadeDoEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeriodicidadeDoEvento.setBounds(10, 111, 145, 14);
		add(lblPeriodicidadeDoEvento);

		tfDtEvento = new JTextField();
		tfDtEvento.setBounds(166, 58, 115, 20);
		add(tfDtEvento);
		tfDtEvento.setColumns(10);

		tfEncaminharEmail = new JTextField();
		tfEncaminharEmail.setColumns(10);
		tfEncaminharEmail.setBounds(166, 83, 193, 20);
		add(tfEncaminharEmail);

		rdbUmavez = new JRadioButton("Uma Vez");
		buttonGroup.add(rdbUmavez);
		rdbUmavez.setBounds(161, 107, 73, 23);
		add(rdbUmavez);

		rdbSemanal = new JRadioButton("Semanal");
		buttonGroup.add(rdbSemanal);
		rdbSemanal.setBounds(236, 107, 73, 23);
		add(rdbSemanal);

		rdbMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbMensal);
		rdbMensal.setBounds(311, 107, 73, 23);
		add(rdbMensal);

		ckbAlarm = new JCheckBox("Alarme");
		ckbAlarm.setBounds(6, 148, 97, 23);
		add(ckbAlarm);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(145, 148, 89, 23);
		add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(270, 148, 89, 23);
		add(btnLimpar);

		
		// TODO: Migrar para método setUpListeners.
		btnSalvar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamaCadastroEvento();				
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();				
			}
		});
		
	}

	private void chamaCadastroEvento() {
		CalendarIO io = new CalendarIO();
		Event event = new Event();

		Object[] newLine = new Object[5];

		event.setDataEvento(CalendarUtils.getDateFromString(tfDtEvento.getText()));
		event.setDescEvento(tfDescEvento.getText());
		event.setAlarme(ckbAlarm.isSelected() ? 1 : 0);
		event.setEmailEncaminhar(tfEncaminharEmail.getText());

		newLine[0] = tfDtEvento.getText();
		newLine[1] = tfDescEvento.getText();
		newLine[4] = ckbAlarm.isSelected() ? "LIGADO" : "DESLIGADO";
		newLine[3] = tfEncaminharEmail.getText();

		if (rdbUmavez.isSelected()) {
			event.setPeriodicidade(FrequencyEnum.UNICO);
			newLine[2] = FrequencyEnum.UNICO;
		} else if (rdbSemanal.isSelected()) {
			event.setPeriodicidade(FrequencyEnum.SEMANAL);
			newLine[2] = FrequencyEnum.SEMANAL;
		} else {
			event.setPeriodicidade(FrequencyEnum.MENSAL);
			newLine[2] = FrequencyEnum.MENSAL;
		}

		try {
			io.gravarEvento(event);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}

		listaEventos.addNewRow(newLine);
		limparCampos();

	}

	private void limparCampos() {
		tfDtEvento.setText("");
		tfDescEvento.setText("");
		ckbAlarm.setSelected(false);
		tfEncaminharEmail.setText("");
		rdbUmavez.setSelected(true);
	}

}
