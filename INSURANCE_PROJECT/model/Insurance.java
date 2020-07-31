package model;

import java.util.Date;

public class Insurance {
		private String policyNo;
		private double premium_amount;
		private double amount_covers;
		String installmentType;
		Date startDate;
		Date endDate;
		public Insurance() {
			super();
		}
		public Insurance(String policyNo, double premium_amount, double amount_covers, String insatallmentType,
			Date startDate, Date endDate) {
			super();
			this.policyNo = policyNo;
			this.premium_amount = premium_amount;
			this.amount_covers = amount_covers;
			this.installmentType = insatallmentType;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		public String getPolicyNo() {
			return policyNo;
		}
		public void setPolicyNo(String policyNo) {
			this.policyNo = policyNo;
		}
		public double getPremium_amount() {
			return premium_amount;
		}
		public void setPremium_amount(double premium_amount) {
			this.premium_amount = premium_amount;
		}
		public double getAmount_covers() {
			return amount_covers;
		}
		public void setAmount_covers(double amount_covers) {
			this.amount_covers = amount_covers;
		}
		public String getInsatallmentType() {
			return installmentType;
		}
		public void setInsatallmentType(String insatallmentType) {
			this.installmentType = insatallmentType;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
}

	



