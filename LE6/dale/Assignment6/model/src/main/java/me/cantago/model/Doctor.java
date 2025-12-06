package me.cantago.model;

public class Doctor extends Person {
	private String specialty;
	private double officeVisitFee;
	
	public Doctor() {
		this("", "", 0.0);
	}

	public Doctor(String specialty) {
		this("", specialty, 0.0);
	}

	public Doctor(double officeVisitFee) {
		this("", "", officeVisitFee);
	}

	public Doctor(String specialty, double officeVisitFee) {
		this("", specialty, officeVisitFee);
	}

	public Doctor(String name, String specialty, double officeVisitFee) {
		super(name);
		setSpecialty(specialty);
		setOfficeVisitFee(officeVisitFee);
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		if (specialty == null || specialty.isEmpty() || specialty.isBlank()) {
			this.specialty = "null";
			return;
		}
		this.specialty = specialty;
	}

	public boolean hasSameSpecialty(Doctor other) {
		return getSpecialty().equalsIgnoreCase(other.getSpecialty());
	}
	
	public double getOfficeVisitFee() {
		return officeVisitFee;
	}

	public void setOfficeVisitFee(double officeVisitFee) {
		this.officeVisitFee = officeVisitFee;
	}

	public boolean hasSameVisitFee(Doctor other) {
		return getOfficeVisitFee() == other.getOfficeVisitFee();
	}
}
