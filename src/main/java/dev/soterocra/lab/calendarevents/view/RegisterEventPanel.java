package dev.soterocra.lab.calendarevents.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class RegisterEventPanel extends JPanel {
	private JTextField tfDescEvento;
	private JTextField lbDataEvento;
	private JTextField tfEncaminharEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public RegisterEventPanel() {
		setLayout(null);
		
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
		
		lbDataEvento = new JTextField();
		lbDataEvento.setBounds(166, 58, 115, 20);
		add(lbDataEvento);
		lbDataEvento.setColumns(10);
		
		tfEncaminharEmail = new JTextField();
		tfEncaminharEmail.setColumns(10);
		tfEncaminharEmail.setBounds(166, 83, 193, 20);
		add(tfEncaminharEmail);
		
		JRadioButton rdbUmavez = new JRadioButton("Uma Vez");
		buttonGroup.add(rdbUmavez);
		rdbUmavez.setBounds(161, 107, 73, 23);
		add(rdbUmavez);
		
		JRadioButton rdbSemanal = new JRadioButton("Semanal");
		buttonGroup.add(rdbSemanal);
		rdbSemanal.setBounds(236, 107, 73, 23);
		add(rdbSemanal);
		
		JRadioButton rdbMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbMensal);
		rdbMensal.setBounds(311, 107, 73, 23);
		add(rdbMensal);
		
		JCheckBox ckbAlarme = new JCheckBox("Alarme");
		ckbAlarme.setBounds(6, 148, 97, 23);
		add(ckbAlarme);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(145, 148, 89, 23);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(270, 148, 89, 23);
		add(btnLimpar);

	}

	public RegisterEventPanel(ListEventsPanel listaEventosPanel) {
		this();
	}
}
