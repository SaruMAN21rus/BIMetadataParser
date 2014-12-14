package model;

public class PhysicalForeignKey {

	private String href;
	private String name;
	private String parentTable;
	private String parentTableKey;
	private String expression;
	public PhysicalForeignKey() {
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentTable() {
		return parentTable;
	}
	public void setParentTable(String parentTable) {
		this.parentTable = parentTable;
	}
	public String getParentTableKey() {
		return parentTableKey;
	}
	public void setParentTableKey(String parentTableKey) {
		this.parentTableKey = parentTableKey;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
}
