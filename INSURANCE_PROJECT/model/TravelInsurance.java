package model;

import java.util.Date;

public class TravelInsurance extends Insurance{
	String travel_type,luggage_covers;
	int cid;

	public TravelInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TravelInsurance(String policyNo, double premium_amount, double amount_covers, String insatallmentType,
			Date startDate, Date endDate) {
		super(policyNo, premium_amount, amount_covers, insatallmentType, startDate, endDate);
		// TODO Auto-generated constructor stub
	}
	
	

	public String getLuggage_covers() {
		return luggage_covers;
	}

	public void setLuggage_covers(String luggage_covers) {
		this.luggage_covers = luggage_covers;
	}

	public String getTravel_type() {
		return travel_type;
	}

	public void setTravel_type(String travel_type) {
		this.travel_type = travel_type;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
