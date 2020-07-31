package model;

import java.util.Date;

public class LifeInsurance extends Insurance{
	int cid;
	
	public LifeInsurance() {
		super();
	}

	public LifeInsurance(String policyNo, double premium_amount, double amount_covers, String insatallmentType,
			Date startDate, Date endDate) {
		super(policyNo, premium_amount, amount_covers, insatallmentType, startDate, endDate);
		
	}
	

	public LifeInsurance(int cid) {
		super();
		this.cid = cid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}	
	
}
