package model;

public class Student {
	private String studentName;
	private String fatherName;
	private String motherName;
	private Integer fatherMoney;
	private Integer motherMoney;
	private Integer numberOfSisters;
	private Integer numberOfBrothers;

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setFatherMoney(Integer fatherMoney) {
		this.fatherMoney = fatherMoney;
	}

	public Integer getFatherMoney() {
		return fatherMoney;
	}

	public void setMotherMoney(Integer motherMoney) {
		this.motherMoney = motherMoney;
	}

	public Integer getMotherMoney() {
		return motherMoney;
	}

	public void setNumberOfSisters(Integer numberOfSisters) {
		this.numberOfSisters = numberOfSisters;
	}

	public Integer getNumberOfSisters() {
		return numberOfSisters;
	}

	public void setNumberOfBrothers(Integer numberOfBrothers) {
		this.numberOfBrothers = numberOfBrothers;
	}

	public Integer getNumberOfBrothers() {
		return numberOfBrothers;
	}
}
