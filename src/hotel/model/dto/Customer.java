package hotel.model.dto;

public class Customer {
	/** �� �̸� */
	private String cname;
	
	/** �� ��ȭ��ȣ */
	private String phone;
	
	/** �� �̸��� */
	private String email;
	
	/** �� �ο��� */
	private int personCount;

	public Customer() {}
	public Customer(String cname, String phone, String email, int personCount) {
		super();
		this.cname = cname;
		this.phone = phone;
		this.email = email;
		this.personCount = personCount;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPersonCount() {
		return personCount;
	}

	public void setPersonCount(int personCount) {
		this.personCount = personCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[�̸�]");
		builder.append(cname);
		builder.append(", [��ȭ��ȣ]");
		builder.append(phone);
		builder.append(", [�̸���]");
		builder.append(email);
		builder.append(",\t [�ο���]");
		builder.append(personCount);
		
		return builder.toString();
	}
	
	
}
