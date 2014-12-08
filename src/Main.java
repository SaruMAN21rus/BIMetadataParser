import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.opencsv.CSVWriter;


public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		String[] columns = {"id", "name", "qualifiedName", "xlink:href", "qName"};
		SAXPars saxp = new SAXPars(columns, null);
		parser.parse(new File("isup_super_cube/NameIndex.xml"), saxp);
		List<String[]> metadataList = saxp.getMetadata();
		List<String[]> physicalColumnList = new ArrayList<>();
		List<String[]> logicalColumnList = new ArrayList<>();
		for (String[] metadata : metadataList) {
			if ("RefPhysicalColumn".equalsIgnoreCase(metadata[4])) {
				String[] col = {"id", "name", "dataType", "length", "nullable", "externalName", "aggrRule", "qName"};
				List<String> tags = new ArrayList<>();
				tags.add("PhysicalColumn");
				tags.add("RefPhysicalTable");
				saxp = new SAXPars(col, tags);
				parser.parse(new File(metadata[3].replaceFirst(".", "isup_super_cube")), saxp);
				physicalColumnList.addAll(saxp.getMetadata());
			}
			if ("RefLogicalColumn".equalsIgnoreCase(metadata[4])) {
				String[] col = {"id", "name", "dataType", "nullable", "type", "commutative", "defaultRule", "qName"};
				List<String> tags = new ArrayList<>();
				tags.add("PhysicalColumn");
				tags.add("RefPhysicalTable");
				saxp = new SAXPars(col, null);
				parser.parse(new File(metadata[3].replaceFirst(".", "isup_super_cube")), saxp);
				logicalColumnList.addAll(saxp.getMetadata());
			}
		}
		printToCSV(physicalColumnList, "PhysicalColumns.csv");
		printToCSV(logicalColumnList, "LogicalColumns.csv");
		
		
	}
	
	private static void printToCSV(List<String[]> list, String fileName) {
		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter(fileName), '|');
			writer.writeAll(list);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
