package inputParams;

public class CalcInputParams {

	private String operator;
	private Integer left;
	private Integer right;
	
	public CalcInputParams() {
		
	}
	
	public CalcInputParams(String operator, Integer left, Integer right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getRight() {
		return right;
	}
	public void setRight(Integer right) {
		this.right = right;
	}
}
