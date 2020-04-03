/**  
* <p>Title: Student.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 11, 2019</p>  
* @author ����  
* @date May 11, 2019  
* @version 1.0  
*/
package SY5;

class Student {
	private int number;
	private String name;
	private String gendar;
	private int phoneNumber;
	private String cla;

	public Student(int number, String name, String gendar, int phoneNumber, String cla) {
		this.setNumber(number);
		this.setName(name);
		this.setGendar(gendar);
		this.setPhoneNumber(phoneNumber);
		this.setCla(cla);
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public String getGendar() {
		return gendar;
	}

	public void setGendar(String gendar) {
		this.gendar = gendar;
	}

	public String getCla() {
		return cla;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getNumber() {
		return this.number;
	}

	public String getName() {
		return this.name;
	}

	public float getScore() {
		return this.phoneNumber;
	}

	public String toString() {
		String s = "ѧ�ţ�" + this.number + "\n������" + this.name 
				+ "\n�Ա�:" + this.gendar + "\n�绰��" + this.phoneNumber + "\n�༶:" + this.cla;
		return s;
	}
}
