package me.cantago.model;

public class Person {
	private String name;

	public Person() {
		this("");
	}

	public Person(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty() || name.isBlank()) {
			this.name = "null";
			return;
		}
		this.name = name;
	}
	
	public void writeOutput() {
		System.out.println("Name: " + getName());
	}

	public boolean hasSameName(Person other) {
		return getName().equalsIgnoreCase(other.getName());
	}
}
