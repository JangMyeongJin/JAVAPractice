package practice;

import java.io.*;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public class PdfWriterTest {

	static File file = new File("C:/practice/pdfTest.pdf");
	static String cssPath = "C:/practice/csstest.css";
	static String fontPath = "C:/practice/malgun.ttf";
	static String chrome = "C:/Program Files/Google/Chrome/Application/chrome.exe";

	public static void main(String[] args) {

		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		PdfWriter(document);

		ChromeBuilder();
	}

	public static void PdfWriter(Document document) {

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			writer.setInitialLeading(12.5f);

			document.open();

			CSSResolver cssResolver = new StyleAttrCSSResolver();
			CssFile cssFile = XMLWorkerHelper.getCSS(new FileInputStream(cssPath));
			cssResolver.addCss(cssFile);

			XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
			fontProvider.register(fontPath, "MalgunGothic");
			CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);

			HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
			htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

			PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
			HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
			CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

			XMLWorker worker = new XMLWorker(css, true);
			XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));

			String htmlStr = OutputHtmlStr();

			StringReader strReader = new StringReader(htmlStr);
			xmlParser.parse(strReader);

			document.close();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String OutputHtmlStr() {

		String ipCmd = "ipconfig";
		String hostNameCmd = "ipconfig/all";

		String ip = cmd.OutputIP(ipCmd);
		String hostname = cmd.OutputHostName(hostNameCmd);

		
		 String htmlStr = "<html><head><body style='font-family: MalgunGothic;'>" 
				 			+ "<p>1. PC 정보</p>" 
				 			+ "<h3>PC 정보는 아래와 같습니다.</h3>" 
				 			+ "<table>" 
				 			+ "<tr><td>구분</td><td>호스트명</td><td>IP</td></tr>"
				 			+ "<tr><td>PC1</td><td>"+ hostname + "</td><td>" + ip + "</td></tr>" 
				 			+ "</table>" 
				 			+ "</body></head></html>";
		
		 

		return htmlStr;
	}

	public static void ChromeBuilder() {

		try {
			new ProcessBuilder(chrome, file.getAbsolutePath()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
