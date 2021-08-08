package hotel.model.dto;

public class Customer {
	/** 고객 이름 */
	private String cname;
	
	/** 고객 전화번호 */
	private String phone;
	
	/** 고객 이메일 */
	private String email;
	
	/** 고객 인원수 */
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
		builder.append("[이름]");
		builder.append(cname);
		builder.append(", [전화번호]");
		builder.append(phone);
		builder.append(", [이메일]");
		builder.append(email);
		builder.append(",\t [인원수]");
		builder.append(personCount);
		
		return builder.toString();
	}
	
	
}
