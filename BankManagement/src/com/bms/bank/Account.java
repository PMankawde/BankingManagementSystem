package com.bms.bank;

public class Account {
	double bal;
    double trans;
    String customerName;
    String customerId;
    
    public Account() {
		super();
	}

    	
	public Account(String customerName, String customerId) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
	}


	public Account(double bal, double trans, String customerName, String customerId) {
		super();
		this.bal = bal;
		this.trans = trans;
		this.customerName = customerName;
		this.customerId = customerId;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public double getTrans() {
		return trans;
	}

	public void setTrans(double trans) {
		this.trans = trans;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    
}
