package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import model.PhysicalTable;
import model.Repository;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;

import sax.SAXPars;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;


public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XStream stream = new XStream();
		stream.ignoreUnknownElements();
		stream.autodetectAnnotations(true);
		stream.alias("Repository", Repository.class);
		List<PhysicalTable> physicalTables = new ArrayList<>();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		String[] columns = {"xlink:href", "qName"};
		SAXPars saxp = new SAXPars(columns, null);
		parser.parse(new File("isup_super_cube/NameIndex.xml"), saxp);
		
		List<String[]> metadataList = saxp.getMetadata(); 
		for (String[] metadata : metadataList) {
			if (StringUtils.isNotBlank(metadata[0])) {
				if ("RefPhysicalTable".equalsIgnoreCase(metadata[1])) {
					Repository table = (Repository)stream.fromXML(new File(metadata[0].replaceFirst(".","isup_super_cube")));
					physicalTables.add(table.getPhysicalTable());
				}
			}
		}
		try {
		      InputStream in = Main.class.getResourceAsStream("../PhysicalTables.docx");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      IContext context = report.createContext();
		      context.put("physicalTables", physicalTables);

		      OutputStream out = new FileOutputStream(new File("DocxProjectWithVelocity_Out.docx"));
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
	}

}
