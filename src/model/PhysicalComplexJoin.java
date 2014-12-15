package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.ExpressionConverter;
import converters.NameListConverter;

@XStreamAlias("PhysicalComplexJoin")
public class PhysicalComplexJoin {

	@XStreamAsAttribute
	private String name;
	
	@XStreamConverter(NameListConverter.class)
	@XStreamAlias("PhysicalTables")
	private String physicalTables;
	
	@XStreamAlias("Expression")
	@XStreamConverter(ExpressionConverter.class)
	private String expression;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhysicalTables() {
		return physicalTables;
	}

	public void setPhysicalTables(String physicalTables) {
		this.physicalTables = physicalTables;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
}
