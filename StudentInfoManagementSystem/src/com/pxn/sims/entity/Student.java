package com.pxn.sims.entity;

public class Student {
	private String sno;
	private String sname;
	private String ssex;
	private double math;
	private double linear;
	private double java;
	private double database;
	private double construction;
	private double ave;
	private double sum;
	private int rank;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getLinear() {
		return linear;
	}
	public void setLinear(double linear) {
		this.linear = linear;
	}
	public double getJava() {
		return java;
	}
	public void setJava(double java) {
		this.java = java;
	}
	public double getDatabase() {
		return database;
	}
	public void setDatabase(double database) {
		this.database = database;
	}
	public double getConstruction() {
		return construction;
	}
	public void setConstruction(double construction) {
		this.construction = construction;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public double getAve() {
		return ave;
	}
	public void setAve(double ave) {
		this.ave = ave;
	}

	//�޲ι��캯��
    public Student() {
        super();
      }
    //�вι��캯��
	public Student(String sno, String sname, String ssex, double math, double linear, double java, double database, double construction, double ave, double sum, int rank) {
		// TODO Auto-generated constructor stub
		super();
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.math = math;
        this.linear = linear;
        this.java = java;
        this.database = database;
        this.construction = construction;
        this.ave = ave;
        this.sum = sum;
        this.rank = rank;
	}
	
	public String toString() {
		return "ѧ�ţ�"+sno+" ������"+sname+" �Ա�"+ssex+"\n"+"�����ɼ���"+math+" �ߴ��ɼ���"+linear+" Java�ɼ���"+java+" ���ݿ�ɼ���"+database+" ����ɼ���"+construction+"\n"+"ƽ���ɼ���"+ave+" �ܳɼ���"+sum+" ���Σ�"+rank+"\n";
		
	}
}
