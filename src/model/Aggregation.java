package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import converters.ExpressionConverter;

@XStreamAlias("Aggregation")
public class Aggregation {

	@XStreamAlias("Expression")
	@XStreamConverter(ExpressionConverter.class)
	private String expression;

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
}
