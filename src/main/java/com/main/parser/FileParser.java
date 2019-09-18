package com.main.parser;


import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.main.exception.FileException;
import com.main.parser.bl.FileParserBL;
import com.sun.jersey.multipart.FormDataParam;


@Path("Parser")
public class FileParser {
	
	private static final Logger LOG = LoggerFactory.getLogger(FileParser.class);
	private static FileParserBL fileParserBL;
	
	@Context
	public HttpServletResponse response;
	
	public FileParser() {
		super();
		synchronized (LOG) {
			if (fileParserBL == null) {
				fileParserBL = new FileParserBL();
			}
		}
	}
	
	public void setResponse(HttpServletResponse response){
		this.response = response;
	}
	
	@POST
	@Path("parserFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"})
	public void parserFile(@FormDataParam("attachment") File csvFile, @FormDataParam("limit") int limit, 
			@FormDataParam("minValue") float minValue) throws IOException, FileException{
		
		// Set Response Headers for File Parser
		final StringBuilder attachmentName = new StringBuilder();
		attachmentName.append("attachment; filename=").append("ParseResult.csv");
		response.setHeader("Content-disposition", attachmentName.toString());
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Accept-Ranges", "bytes");
		
		fileParserBL.parserFile(csvFile, limit, minValue, response.getOutputStream());
	}

}
