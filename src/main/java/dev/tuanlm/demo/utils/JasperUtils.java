package dev.tuanlm.demo.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;


public class JasperUtils {
	public static final String REPORT_PATH = "reports/";
	
	public static byte[] generateDocxReport(String reportFile, List<?> list, Map<String, Object> parameters) throws JRException, IOException {
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				JasperCompileManager.compileReport(new ClassPathResource(reportFile).getInputStream()),
				parameters,
				new JRBeanCollectionDataSource(list));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
		exporter.exportReport();
		
		return baos.toByteArray();
	}
}
