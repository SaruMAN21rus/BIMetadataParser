package converters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.PhysicalColumn;
import model.Repository;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


public class RefPhysicalColumnConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class arg0) {
		return arg0.equals(ArrayList.class);
	}

	@Override
	public void marshal(Object arg0, HierarchicalStreamWriter arg1,
			MarshallingContext arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0,
			UnmarshallingContext arg1) {
		List<PhysicalColumn> columns = new ArrayList<>();
		while (arg0.hasMoreChildren()) {
			arg0.moveDown();
			XStream stream = new XStream();
			stream.ignoreUnknownElements();
			stream.autodetectAnnotations(true);
			stream.alias("Repository", Repository.class);
			Repository repository = (Repository)stream.fromXML(new File(arg0.getAttribute("xlink:href")
					.replaceFirst("../../..\\/\\.\\.", "isup_super_cube")
					.replaceFirst("../../..", "isup_super_cube")));
			columns.add(repository.getPhysicalColumn());
			arg0.moveUp();
		}
		return columns;
	}

}
