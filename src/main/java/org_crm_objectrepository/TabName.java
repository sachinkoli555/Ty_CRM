package org_crm_objectrepository;

public enum TabName {

	Contacts("Contacts"), Leads("Leads"), Opportunities("Opportunities"), Products("Products"), Documents("Documents"),
	Email("Email"), Organizations("Organizations"),Dashboard("Dashboard"),SIGNOUT("sing out");

	String tabName;

	public String getTabName() {
		return tabName;
	}

	private TabName(String tabName) {
		this.tabName = tabName;
	}
}
