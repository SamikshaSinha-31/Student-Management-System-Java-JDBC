package model;

public class Student {
	    private int id;
	    private String name;
	    private String rollNo;
	    private String department;
	    private int year;

	    public Student() {}

	    public Student(int id, String name, String rollNo, String department, int year) {
	        this.id = id;
	        this.name = name;
	        this.rollNo = rollNo;
	        this.department = department;
	        this.year = year;
	    }

	    public Student(String name, String rollNo, String department, int year) {
	        this.name = name;
	        this.rollNo = rollNo;
	        this.department = department;
	        this.year = year;
	    }

	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getRollNo() { return rollNo; }
	    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

	    public String getDepartment() { return department; }
	    public void setDepartment(String department) { this.department = department; }

	    public int getYear() { return year; }
	    public void setYear(int year) {
	        if (year <= 0) {
	            System.out.println("Invalid year");
	            return;
	        }
	        this.year = year;
	    }

	    
	    @Override
	    public String toString() {
	        return "Student{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", rollNo='" + rollNo + '\'' +
	                ", department='" + department + '\'' +
	                ", year=" + year +
	                '}';
	    }

}
