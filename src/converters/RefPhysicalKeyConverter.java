package converters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.PhysicalKey;
import model.Repository;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class RefPhysicalKeyConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class type) {
		return type.equals(ArrayList.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		List<PhysicalKey> keys = new ArrayList<>();
		while (reader.hasMoreChildren()) {
			reader.moveDown();
			XStream stream = new XStream();
			stream.ignoreUnknownElements();
			stream.autodetectAnnotations(true);
			stream.alias("Repository", Repository.class);
			Repository repository = (Repository)stream.fromXML(new File(reader.getAttribute("xlink:href").replaceFirst("../../..", "isup_super_cube")));
			keys.add(repository.getPhysicalKey());
			reader.moveUp();
		}
		return keys;
	}

}
