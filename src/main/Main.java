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

import model.Dimension;
import model.LogicalTable;
import model.PhysicalComplexJoin;
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
		List<PhysicalComplexJoin> physicalComplexJoins = new ArrayList<>();
		List<LogicalTable> logicalTables = new ArrayList<>();
		List<Dimension> dimensions = new ArrayList<>();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		String[] columns = {"xlink:href", "qName"};
		SAXPars saxp = new SAXPars(columns, null);
		parser.parse(new File("isup_super_cube/NameIndex.xml"), saxp);
		
		List<String[]> metadataList = saxp.getMetadata(); 
		for (String[] metadata : metadataList) {
			if (StringUtils.isNotBlank(metadata[0])) {
				/*if ("RefPhysicalTable".equalsIgnoreCase(metadata[1])) {
					Repository table = (Repository)stream.fromXML(new File(metadata[0].replaceFirst(".","isup_super_cube")));
					physicalTables.add(table.getPhysicalTable());
				}
				if ("RefPhysicalComplexJoin".equalsIgnoreCase(metadata[1])) {
					Repository join = (Repository)stream.fromXML(new File(metadata[0].replaceFirst(".","isup_super_cube")));
					physicalComplexJoins.add(join.getPhysicalComplexJoin());
				}
				if ("RefLogicalTable".equalsIgnoreCase(metadata[1])) {
					Repository logicalTable = (Repository)stream.fromXML(new File(metadata[0].replaceFirst(".","isup_super_cube")));
					logicalTables.add(logicalTable.getLogicalTable());
				}*/
				if ("RefDimension".equalsIgnoreCase(metadata[1])) {
					Repository dimension = (Repository)stream.fromXML(new File(metadata[0].replaceFirst(".","isup_super_cube")));
					dimensions.add(dimension.getDimension());
				}
			}
		}
	
		try {
			InputStream in = Main.class
					.getResourceAsStream("../PhysicalTables.docx");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					in, TemplateEngineKind.Velocity);

			IContext context = report.createContext();
			context.put("physicalTables", physicalTables);

			OutputStream out = new FileOutputStream(new File(
					"PhysicalTables.docx"));
			report.process(context, out);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
		try {
			InputStream in = Main.class
					.getResourceAsStream("../PhysicalComplexJoins.docx");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					in, TemplateEngineKind.Velocity);

			IContext context = report.createContext();
			context.put("physicalComplexJoins", physicalComplexJoins);

			OutputStream out = new FileOutputStream(new File(
					"PhysicalComplexJoins.docx"));
			report.process(context, out);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
		try {
			InputStream in = Main.class
					.getResourceAsStream("../LogicalTables.docx");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					in, TemplateEngineKind.Velocity);

			IContext context = report.createContext();
			context.put("logicalTables", logicalTables);

			OutputStream out = new FileOutputStream(new File(
					"LogicalTables.docx"));
			report.process(context, out);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
		try {
			InputStream in = Main.class
					.getResourceAsStream("../Dimensions.docx");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					in, TemplateEngineKind.Velocity);

			IContext context = report.createContext();
			context.put("dimensions", dimensions);

			OutputStream out = new FileOutputStream(new File(
					"Dimensions.docx"));
			report.process(context, out);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
	}

}
