package br.com.android.teste;

public class Player {

	private String name;
	private int age;
	
	public Player(){
		this.name = "";
		this.age = 0;
	}
	
	public Player(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){
		
		return "Name: " + this.getName() + 
			   "\nAge: " + this.getAge();
	}
	
}
