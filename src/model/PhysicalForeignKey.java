package model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.ExpressionConverter;
import converters.ParentTableConverter;

@XStreamAlias("PhysicalForeignKey")
public class PhysicalForeignKey {

	@XStreamAsAttribute
	private String name;
	
	@XStreamAlias("ParentTable")
	@XStreamConverter(ParentTableConverter.class)
	private List<String> parentTable  = new ArrayList<>();
	
	@XStreamAlias("Expression")
	@XStreamConverter(ExpressionConverter.class)
	private String expression;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public List<String> getParentTable() {
		return parentTable;
	}
	public void setParentTable(List<String> parentTable) {
		this.parentTable = parentTable;
	}
	
	
}
