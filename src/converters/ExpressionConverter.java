package converters;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ExpressionConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class arg0) {
		return arg0.equals(String.class);
	}

	@Override
	public void marshal(Object arg0, HierarchicalStreamWriter arg1,
			MarshallingContext arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0,
			UnmarshallingContext arg1) {
		String expression = "";
		if (arg0.hasMoreChildren()) {
			while (arg0.hasMoreChildren()) {
				if (StringUtils.isNotBlank(arg0.getValue())) {
					expression = expression.concat(arg0.getValue());
				}
				arg0.moveDown();
				expression = expression.concat(arg0.getAttribute("name"));
				arg0.moveUp();
			}
		} else {
			expression = arg0.getValue();
		}
		return StringUtils.trim(expression).replaceAll("\n", " ").replaceAll(" +", " ");
	}

}
