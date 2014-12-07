import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import au.com.bytecode.opencsv.CSVWriter;


public class SAXPars extends DefaultHandler {

	PhysicalTable table = new PhysicalTable();
	boolean isExpression = false;
	String expression = "";
	String expressionColumn = "";
	List<String[]> metadataList = new ArrayList<>();
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		expressionColumn = qName;
		if ("Expression".equals(qName)) {
			isExpression = true;
		} else if (isExpression) {
			expression += attributes.getValue("name");
		}
		String[] metadata = new String[4];
		metadata[0] = attributes.getValue("xlink:href");
		metadata[1] = attributes.getValue("qualifiedName");
		metadata[2] = attributes.getValue("name");
		metadata[3] = qName;
		metadataList.add(metadata);
		/*switch (qName) {
		case "RefPresentationColumn":
			metadata.setType("PresentationColumn");
			break;
		case "RefLogicalColumn":
			metadata.setType("RefLogicalColumn");
			break;
		case "RefPresentationCatalog":
			metadata.setType("RefPresentationCatalog");
			break;
		case "RefPhysicalColumn":
			//metadata = new PhysicalColumn();
			metadata.setType("RefPhysicalColumn");
			break;
		case "RefLogicalTableSource":
			metadata.setType("RefLogicalTableSource");
			break;
		case "RefLogicalTable":
			metadata.setType("RefLogicalTable");
			break;
		case "RefPhysicalTable":
			metadata.setType("RefPhysicalTable");
			break;
		case "RefLogicalLevel":
			metadata.setType("RefLogicalLevel");
			break;
		case "RefLogicalKey":
			metadata.setType("RefLogicalKey");
			break;
		case "RefDimension":
			metadata.setType("RefDimension");
			break;
		case "RefUser":
			metadata.setType("RefUser");
			break;
		case "RefGroup":
			metadata.setType("RefGroup");
			break;
		case "RefPresentationTable":
			metadata.setType("PresentationColumn");
			break;
		case "RefLogicalComplexJoin":
			metadata.setType("PresentationColumn");
			break;
		case "RefLogicalForeignKey":
			metadata.setType("PresentationColumn");
			break;
		case "RefInitBlock":
			metadata.setType("PresentationColumn");
			break;
		case "RefVariable":
			metadata.setType("PresentationColumn");
			break;
		case "RefPhysicalForeignKey":
			metadata.setType("PresentationColumn");
			break;
		case "RefPhysicalComplexJoin":
			metadata.setType("PresentationColumn");
			break;
		case "RefPhysicalKey":
			metadata.setType("PresentationColumn");
			break;
		}*/
		/*System.out.print(qName + ": ");
		for (int i = 0 ; i < attributes.getLength(); i++) {
			System.out.print(attributes.getQName(i));
			System.out.println(" = " + attributes.getValue(i));
		}*/
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (isExpression) {
			expression += new String(ch, start, length);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("Expression".equals(qName)) {
			isExpression = false;
			System.out.println(StringUtils.trim(expression).replaceAll("\n", " ").replaceAll(" +", " "));
		}
		/*switch (qName) {
		case "RefPresentationColumn":

			break;
		case "RefLogicalColumn":

			break;
		case "RefPresentationCatalog":

			break;
		case "RefPhysicalColumn":
			
			break;
		case "RefLogicalTableSource":

			break;
		case "RefLogicalTable":

			break;
		case "RefPhysicalTable":

			break;
		case "RefLogicalLevel":

			break;
		case "RefLogicalKey":

			break;
		case "RefDimension":

			break;
		case "RefUser":

			break;
		case "RefGroup":

			break;
		case "RefPresentationTable":

			break;
		case "RefLogicalComplexJoin":

			break;
		case "RefLogicalForeignKey":

			break;
		case "RefInitBlock":

			break;
		case "RefVariable":

			break;
		case "RefPhysicalForeignKey":

			break;
		case "RefPhysicalComplexJoin":

			break;
		case "RefPhysicalKey":

			break;
		}*/
	}
	
	@Override
	public void endDocument() throws SAXException {
		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter("NameIndex.csv"), '|');
			writer.writeAll(metadataList);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
