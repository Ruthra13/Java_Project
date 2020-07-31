package model;

import java.util.Date;

public class HomeInsurance extends Insurance{
	String docNo,name,address;
	int cid;

	public HomeInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomeInsurance(String policyNo, double premium_amount, double amount_covers, String insatallmentType,
			Date startDate, Date endDate) {
		super(policyNo, premium_amount, amount_covers, insatallmentType, startDate, endDate);
		// TODO Auto-generated constructor stub
	}
	
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
