package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.nio.charset.Charset;

import com.itextpdf.text.Document; 
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.*;
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

public class pdftest {
	
	static File file = new File("C:/practice/pdfTest.pdf");
	static String chrome = "C:/Program Files/Google/Chrome/Application/chrome.exe";
	static String cssPath = "C:/practice/csstest.css";
	static String fontPath = "C:/practice/malgun.ttf";
	
   public static void main(String[] args) {

      //Document 생성, 페이지 여백 설정
      Document document = new Document(PageSize.A4,50,50,50,50);
      
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
           
    	  //Pipelines
    	  PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
    	  HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
    	  CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
          
    	  XMLWorker worker = new XMLWorker(css, true);
    	  XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));
         
    	  String command = "ipconfig";
    	  String ip = cmd.OutputIP(command);
           
    	  String htmlStr = "<html><head><body style='font-family: MalgunGothic;'>"
                     	+ "<p>PDF 안에 들어갈 내용입니다.</p>"
                     	+ "<h3>한글, English, 123, !@##$#%${}</h3>"
                     	+ "<table>"
                     	+ "<tr><td>번호</td><td>이름</td><td>성별</td></tr>"
                     	+ "<tr><td>1</td><td>나비</td><td>여</td></tr>"
                     	+ "<tr><td>2</td><td>홍길동</td><td>"+ ip + "</td></tr>"
                     	+ "</table>"
                     	+ "</body></head></html>";
          
    	  StringReader strReader = new StringReader(htmlStr);
    	  xmlParser.parse(strReader);
          
    	  document.close();
    	  writer.close();
         
         
    	  chromeBuilder();
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         document.close();
      }
      
   }
   
   public static void pdfwriter(Document document) {
	   
   }
   
   public static void chromeBuilder() {
	   try {
	    	  new ProcessBuilder(chrome,file.getAbsolutePath()).start();
	    	  
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
   }

}