package hotel.model.dto;

public class PayInfo {
	/** ���� �Ͻ� */
	private String payDate;
	
	/** ���� ����*/
	private int payPrice;
	
	/** ���� ���� */
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
		builder.append("[���� �Ͻ�]");
		builder.append(payDate);
		builder.append(", [���� ����]");
		builder.append(payPrice);
		builder.append(", [���� ����]");
		builder.append(payType);
		
		return builder.toString();
	}
	
	
}
