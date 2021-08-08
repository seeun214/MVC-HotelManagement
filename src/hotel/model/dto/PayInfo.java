package hotel.model.dto;

public class PayInfo {
	/** 결제 일시 */
	private String payDate;
	
	/** 결제 가격*/
	private int payPrice;
	
	/** 결제 수단 */
	private String payType;

	public PayInfo() {}
	public PayInfo(String payDate, int payPrice, String payType) {
		super();
		this.payDate = payDate;
		this.payPrice = payPrice;
		this.payType = payType;
	}
	
	public String getPayDate() {
		return payDate;
	}
	
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	
	public int getPayPrice() {
		return payPrice;
	}
	
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}
	
	public String getPayType() {
		return payType;
	}
	
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[결제 일시]");
		builder.append(payDate);
		builder.append(", [결제 가격]");
		builder.append(payPrice);
		builder.append(", [결제 수단]");
		builder.append(payType);
		
		return builder.toString();
	}
	
	
}
