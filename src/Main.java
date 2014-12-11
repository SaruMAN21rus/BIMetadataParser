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
		List<String[]> logicalTableList = new ArrayList<>();
		List<String[]> physicalTableList = new ArrayList<>();
		List<String[]> logicalLevelList = new ArrayList<>();
		List<String[]> logicalKeyList = new ArrayList<>();
		List<String[]> dimensionList = new ArrayList<>();
		List<String[]> physicalKeyList = new ArrayList<>();
		List<String[]> physicalComplexJoinList = new ArrayList<>();
		List<String[]> physicalForeignKeyList = new ArrayList<>();
		List<String[]> logicalForeignKeyList = new ArrayList<>();
		List<String[]> logicalComplexJoinList = new ArrayList<>();
		List<String[]> presentationTableList = new ArrayList<>();
		for (String[] metadata : metadataList) {
			if (StringUtils.isNotBlank(metadata[3])) {
				if ("RefPhysicalColumn".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "dataType", "length",
							"nullable", "externalName", "aggrRule", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					
					
					physicalColumnList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalColumn".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "dataType", "nullable",
							"type", "commutative", "defaultRule", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalColumnList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefPresentationColumn".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					presentationColumnList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalTableSource".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "type", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalTableSourceList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalTable".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "primary", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalTableList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefPhysicalTable".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					physicalTableList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalLevel".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "primary", "chronologicalKey", "grandTotal", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalLevelList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalKey".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "primary", "chronologicalKey", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalKeyList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefDimension".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "timeDimension", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					dimensionList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefPhysicalKey".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "primary", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					physicalKeyList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefPhysicalComplexJoin".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					physicalComplexJoinList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefPhysicalForeignKey".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					physicalForeignKeyList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalForeignKey".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalForeignKeyList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefLogicalComplexJoin".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "type", "driving", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					logicalComplexJoinList.addAll(concateArray(saxp.getMetadata()));
				}
				if ("RefPresentationTable".equalsIgnoreCase(metadata[4])) {
					String[] col = { "id", "name", "qName" };
					saxp = new SAXPars(col, null);
					parser.parse(
							new File(metadata[3].replaceFirst(".",
									"isup_super_cube")), saxp);
					presentationTableList.addAll(concateArray(saxp.getMetadata()));
				}
			}
		}
		printToCSV(metadataList, "NameIndex.csv");
		printToCSV(physicalColumnList, "PhysicalColumns.csv");
		printToCSV(logicalColumnList, "LogicalColumns.csv");
		printToCSV(presentationColumnList, "PresentationColumns.csv");
		printToCSV(logicalTableSourceList, "LogicalTableSource.csv");
		printToCSV(logicalTableList, "LogicalTables.csv");
		printToCSV(physicalTableList, "PhysicalTables.csv");
		printToCSV(logicalLevelList, "LogicalLevels.csv");
		printToCSV(logicalKeyList, "LogicalKeys.csv");
		printToCSV(dimensionList, "Dimensions.csv");
		printToCSV(physicalKeyList, "physicalKeyList.csv");
		printToCSV(physicalComplexJoinList, "physicalComplexJoinList.csv");
		printToCSV(physicalForeignKeyList, "physicalForeignKeyList.csv");
		printToCSV(logicalForeignKeyList, "logicalForeignKeyList.csv");
		printToCSV(logicalComplexJoinList, "logicalComplexJoinList.csv");
		printToCSV(presentationTableList, "presentationTableList.csv");
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
	
	private static List<String[]> concateArray(List<String[]> list) {
		List<String[]> result = new ArrayList<>();
		List<String[]> firstCols = new ArrayList<>();
		String currentQName = "";
		for (String[] str : list) {
			if (str[str.length - 1].equals(currentQName)) {
				firstCols.remove(firstCols.size() - 1);
				if (firstCols.size() > 0) {
					String[] b = firstCols.get(firstCols.size() - 1);
					currentQName = b[b.length - 1];
				}
			} else {
				String[] row = new String[0];
				currentQName = str[str.length - 1];
				for (String[] cols : firstCols) {
					row = ArrayUtils.addAll(row, cols);
				}
				row = ArrayUtils.addAll(row, str);
				result.add(row);
				firstCols.add(str);
			}
		}
		return result;
	}

}
