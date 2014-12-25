package converters;

import java.io.File;

import model.LogicalColumn;
import model.Repository;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LogicalColumnConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class type) {
		// TODO Auto-generated method stub
		return type.equals(LogicalColumn.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		XStream stream = new XStream();
		stream.ignoreUnknownElements();
		stream.autodetectAnnotations(true);
		stream.alias("Repository", Repository.class);
		Repository repository = (Repository) stream.fromXML(new File(reader
				.getAttribute("xlink:href")
				.replaceFirst("\\.\\.\\/\\.\\.\\/\\.\\.", "isup_super_cube")
				.replaceFirst("\\.\\.\\/\\.\\.", "isup_super_cube")));
		return repository.getLogicalColumn();
	}

}
