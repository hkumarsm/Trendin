package com.trendin.core.util.datadriver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents a row in the DataDriver. Values can be referenced by their column
 * name rather than by their index in the underlying string array.
 * 
 * @author Matt
 *
 */
public class DataRow {

	protected String[] internalRow;
	protected Headers myHeaders;
	public final int length;
	private int rowNum;
	
	public int getRowNum() {
		return rowNum;
	}

	protected void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public DataRow(DataDriver parent, Headers headers)
	{
		this.myHeaders = headers;
		length = headers.size();
		if(parent.hasNext())
		{
			internalRow = parent.next();
		}
	}
	
	/**
	 * Gets the value in the specified column.
	 * 
	 * @param columnName The name of the column
	 * @return The value in that column, or null if the column doesn't exist.
	 */
	public String getItem(String columnName, boolean trim)
	{
		String value = null;
		if(myHeaders.containsKey(columnName))
		{
			int index = myHeaders.get(columnName);
			value = (index < internalRow.length)
					? (internalRow[index] == null)
					  ? ""
					  : internalRow[index]
					: "";
			if(trim) {
				value = value.trim();
			}
		}
		return value;
	}
	
	public String getItem(String columnName) {
		return getItem(columnName, true);
	}
	
	public String[] toArray()
	{
		return internalRow.clone();
	}
	
	/** 
	 * @return This row's Headers.
	 */
	public Headers getHeaders()
	{
		return myHeaders;
	}
	
	@Override
	public String toString() {
		
		Headers headers = this.getHeaders();
		Map<Integer, String> reverseHeaders = new HashMap<>();
		List<Integer> indexes = new LinkedList<>(headers.values());
		Collections.sort(indexes);
		
		for(Map.Entry<String, Integer> e : headers.entrySet()) {
			reverseHeaders.put(e.getValue(), e.getKey());
		}
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(Integer index : indexes) {
			sb.append(this.getItem(reverseHeaders.get(index)));
			if(i++ < indexes.size()) {
				sb.append(",");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Map between column names and their indices.
	 * 
	 * @author Matt Swircenski
	 *
	 */
	public static class Headers extends HashMap<String, Integer> implements Iterable<String>
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 8362872116000943441L;

		/**
		 * Constructs a new set of column headers.
		 * Gets the next row in source, and creates one column header per entry in the row.
		 * It is recommended to only use this on a freshly-created DataDriver.
		 *  
		 * @param source The DataDriver to get columns from.
		 */
		public Headers(DataDriver source)
		{
			this(source.next());
		}
		
		public Headers(String[] headers)
		{
			super();
			for(int h = 0; h < headers.length; h++)
			{
				String head = headers[h].trim();
				if(!head.isEmpty())
					this.put(head, h);
			}
		}

		/**
		 * Provides an iterator over the column names.
		 */
		@Override
		public Iterator<String> iterator() {
			return this.keySet().iterator();
		}
		
		public String[] toArray()
		{
			String[] ret = new String[this.size()];
			for(String col : this)
			{
				ret[this.get(col).intValue()] = col;
			}
			return ret;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == null) {
				return false;
			}
			
			if(!(o instanceof Headers)) {
				return false;
			}
			
			Headers other = (Headers)o;
			
			for(String k : this.keySet()) {
				if(!other.containsKey(k)) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(!(o instanceof DataRow)) {
			return false;
		}
		
		DataRow other = (DataRow)o;
		
		Headers thisHeaders = this.getHeaders();
		Headers otherHeaders = other.getHeaders();
		
		if(!thisHeaders.equals(otherHeaders)) {
			return false;
		}
		
		for(String k : thisHeaders.keySet()) {
			String val = this.getItem(k);
			String oVal = other.getItem(k);
			if(!val.equals(oVal)) {
				return false;
			}
		}
		
		return true;
	}
}
