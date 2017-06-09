package com.android.iiet;

public class gsmethod {
      
	int roll_no;
	String maths1;
	String physics;
	String mos;
	String eg;

	public gsmethod(){}
	
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getMaths1() {
		return maths1;
	}
	public void setMaths1(String maths1) {
		this.maths1 = maths1;
	}
	public String getPhysics() {
		return physics;
	}
	public void setPhysics(String physics) {
		this.physics = physics;
	}
	public String getMos() {
		return mos;
	}
	public void setMos(String mos) {
		this.mos = mos;
	}
	public String getEg() {
		return eg;
	}
	public void setEg(String eg) {
		this.eg = eg;
	}
	public gsmethod(int roll_no, String maths1, String physics, String mos,
			String eg) {

		this.roll_no = roll_no;
		this.maths1 = maths1;
		this.physics = physics;
		this.mos = mos;
		this.eg = eg;
	}
	

}
