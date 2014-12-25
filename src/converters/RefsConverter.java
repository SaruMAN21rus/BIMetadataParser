package converters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.Repository;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


public class RefsConverter implements Converter {

	private Class<?> clazz;
	
	public RefsConverter(Class<?> arg0, Class<?> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class arg0) {
		return arg0.equals(ArrayList.class);
	}

	@Override
	public void marshal(Object arg0, HierarchicalStreamWriter arg1,
			MarshallingContext arg2) {
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0,
			UnmarshallingContext arg1) {
		List<Object> columns = new ArrayList<>();
		while (arg0.hasMoreChildren()) {
			arg0.moveDown();
			XStream stream = new XStream();
			stream.ignoreUnknownElements();
			stream.autodetectAnnotations(true);
			stream.alias("Repository", Repository.class);
			Repository repository = (Repository)stream.fromXML(new File(arg0.getAttribute("xlink:href")
					.replaceFirst("\\.\\.\\/\\.\\.\\/\\.\\.", "isup_super_cube")
					.replaceFirst("\\.\\.\\/\\.\\.", "isup_super_cube")));
			if ("PhysicalColumn".equals(clazz.getSimpleName())) {
				columns.add(repository.getPhysicalColumn());
			}
			if ("PhysicalKey".equals(clazz.getSimpleName())) {
				columns.add(repository.getPhysicalKey());
			}
			if ("PhysicalForeignKey".equals(clazz.getSimpleName())) {
				columns.add(repository.getPhysicalForeignKey());
			}
			if ("LogicalColumn".equals(clazz.getSimpleName())) {
				columns.add(repository.getLogicalColumn());
			}
			if ("LogicalTableSource".equals(clazz.getSimpleName())) {
				columns.add(repository.getLogicalTableSource());
			}
			if ("LogicalKey".equals(clazz.getSimpleName())) {
				columns.add(repository.getLogicalKey());
			}
			if ("LogicalForeignKey".equals(clazz.getSimpleName())) {
				columns.add(repository.getLogicalForeignKey());
			}
			if ("Dimension".equals(clazz.getSimpleName())) {
				columns.add(repository.getDimension());
			}
			if ("LogicalLevel".equals(clazz.getSimpleName())) {
				columns.add(repository.getLogicalLevel());
			}
			if ("LogicalComplexJoin".equals(clazz.getSimpleName())) {
				columns.add(repository.getLogicalComplexJoin());
			}
			arg0.moveUp();
		}
		return columns;
	}

}
