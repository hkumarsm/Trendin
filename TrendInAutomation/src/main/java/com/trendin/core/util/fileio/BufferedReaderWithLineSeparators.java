package com.trendin.core.util.fileio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class BufferedReaderWithLineSeparators extends BufferedReader {
	
	private boolean EOF = false;

	public BufferedReaderWithLineSeparators(Reader in) {
		super(in);
	}

	public BufferedReaderWithLineSeparators(Reader in, int sz) {
		super(in, sz);
	}
	
	/**
	 * @return A String containing the contents of the line, including any line-termination characters, or null if the end of the stream has been reached
	 */
	@Override
	public String readLine() throws IOException {
		if(EOF) {
			return null;
		}
		
		int c;
		StringBuilder sb = new StringBuilder();
		
		while((c = this.read()) != -1 && c != '\r' && c != '\n') {
			sb.append((char)c);
		}
		
		if(c == -1) {
			EOF = true;
			return sb.toString();
		} else if (c == '\r' || c == '\n') {
			sb.append((char)c);
		}
		
		this.mark(2);
		
		c = this.read();
		if (c != -1 && (c == '\r' || c == '\n')) {
			sb.append((char)c);
		} else {
			if(c == -1) {
				EOF = true;
			}
			this.reset();
		}
		
		return sb.toString();
	}

}
