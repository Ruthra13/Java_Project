package model;

import java.util.Date;

public class MedicalInsurance extends Insurance
{
	String dependentName;
	int dependentAge;
	String dep_Relationship;
	int cid;
	public MedicalInsurance() {
		super();
	}
	public MedicalInsurance(String policyNo, double premium_amount, double amount_covers, String insatallmentType,
			Date startDate, Date endDate) {
		super(policyNo, premium_amount, amount_covers, insatallmentType, startDate, endDate);
	}
	public MedicalInsurance(String dependentName, int dependentAge, String dep_Relationship,int cid) {
		super();
		this.dependentName = dependentName;
		this.dependentAge = dependentAge;
		this.dep_Relationship = dep_Relationship;
		this.cid = cid;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public int getDependentAge() {
		return dependentAge;
	}
	public void setDependentAge(int dependentAge) {
		this.dependentAge = dependentAge;
	}
	public String getDep_Relationship() {
		return dep_Relationship;
	}
	public void setDep_Relationship(String dep_Relationship) {
		this.dep_Relationship = dep_Relationship;
	}	
}
