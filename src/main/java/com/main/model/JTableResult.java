package com.main.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class JTableResult {
	
	public static final String ERROR = "ERROR";
	public static final String OK = "OK";
	public String result;
	public List<?> records;
	public Object record;
	public String totalRecordCount = "";
	public String message = "";
	
	/**
	 * @return the result
	 */
	@JsonProperty("Result")
	public String getResult() {
		return result;
	}
	
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * @return the records
	 */
	@JsonProperty("Records")
	public List<?> getRecords() {
		return records;
	}
	
	/**
	 * @param records the records to set
	 */
	public void setRecords(List<?> records) {
		this.records = records;
	}
	
	/**
	 * @return the record
	 */
	@JsonProperty("Record")
	public Object getRecord() {
		return record;
	}
	
	/**
	 * @param record the record to set
	 */
	public void setRecord(Object record) {
		this.record = record;
	}
	
	/**
	 * @return the totalRecordCount
	 */
	@JsonProperty("TotalRecordCount")
	public String getTotalRecordCount() {
		return totalRecordCount;
	}
	
	/**
	 * @param totalRecordCount the totalRecordCount to set
	 */
	public void setTotalRecordCount(String totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	
	/**
	 * @return the message
	 */
	@JsonProperty("Message")
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
