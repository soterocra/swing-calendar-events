package dev.soterocra.lab.calendarevents.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import dev.soterocra.lab.calendarevents.entities.enums.FrequencyEnum;

public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date dataEvento;

	private String descEvento;
	private FrequencyEnum periodicidade;
	private String emailEncaminhar;
	private int alarme;

	public Event() {
		super();
	}

	public Event(Date dataEvento, String descEvento, FrequencyEnum periodicidade, String emailEncaminhar, int alarme) {
		super();
		this.dataEvento = dataEvento;
		this.descEvento = descEvento;
		this.periodicidade = periodicidade;
		this.emailEncaminhar = emailEncaminhar;
		this.alarme = alarme;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescEvento() {
		return descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public FrequencyEnum getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(FrequencyEnum periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getEmailEncaminhar() {
		return emailEncaminhar;
	}

	public void setEmailEncaminhar(String emailEncaminhar) {
		this.emailEncaminhar = emailEncaminhar;
	}

	public int getAlarme() {
		return alarme;
	}

	public void setAlarme(int alarme) {
		this.alarme = alarme;
	}

	public String toString() {
		SimpleDateFormat mascaraData = new SimpleDateFormat("dd/MM/yyyy");
		return (mascaraData.format(getDataEvento()) + ";" + getDescEvento() + ";" + getPeriodicidade() + ";"
				+ getEmailEncaminhar() + ";" + getAlarme());
	}
}