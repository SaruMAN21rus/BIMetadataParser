import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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
		List<String[]> presentationColumnList = new ArrayList<>();
		List<String[]> logicalTableSourceList = new ArrayList<>();
		for (String[] metadata : metadataList) {
			if (StringUtils.isNotBlank(metadata[3])) {
				if ("RefPhysicalColumn".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "dataType", "length",
							"nullable", "externalName", "aggrRule", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					
					
					physicalColumnList.add(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalColumn".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "dataType", "nullable",
							"type", "commutative", "defaultRule", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalColumnList.add(concateArray(saxp.getMetadata()));
				}
				if ("RefPresentationColumn".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					presentationColumnList.add(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalTableSource".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "type", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalTableSourceList.add(concateArray(saxp.getMetadata()));
				}
			}
		}
		printToCSV(metadataList, "NameIndex.csv");
		printToCSV(physicalColumnList, "PhysicalColumns.csv");
		printToCSV(logicalColumnList, "LogicalColumns.csv");
		printToCSV(presentationColumnList, "PresentationColumns.csv");
		printToCSV(logicalTableSourceList, "LogicalTableSource.csv");
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
	
	private static String[] concateArray(List<String[]> list) {
		String[] result = list.get(0);
		list.remove(0);
		for (String[] str : list) {
			result = ArrayUtils.addAll(result, str);
		}
		return result;
	}

}
