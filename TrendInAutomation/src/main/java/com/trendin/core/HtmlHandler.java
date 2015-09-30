package com.trendin.core;

public class HtmlHandler {

	private HtmlHandler() {
	}

	public static void beginHTMLDoc(String title, StringBuffer html) {

		html.append("<!doctype html><head><meta charset=\"utf-8\"><title>"
				+ title + "</title>");
		html.append("<STYLE>a { padding: 5px; }"
				+ " a:link,a:visited {font-weight:bold;color:#000000;text-decoration:underline;}"
				+ "a:hover{color:#3B5998;text-decoration:none;}"
				+ "a:active{background-color:#3B5998;color:#000000;}</STYLE></head>");
		html.append("<body style=\"font-family: CALIBRI;font-size: 9pt; color: BLACK\" >");
	}

	public static void endHTMLDoc(StringBuffer html) {
		html.append("</body></html>");
	}

	public static void beginTable(String id, StringBuffer html) {
		html.append("<TABLE id=" + id + " class=\"static\" >");
	}

	public static void endTable(StringBuffer html) {
		html.append("</TABLE>");
	}

	public static void addSeparator(StringBuffer html) {
		html.append("<BR><HR><BR>");
	}

	public static void beginHeaderRow(StringBuffer html) {
		html.append("<TR>");
	}

	public static void endRow(StringBuffer html) {
		html.append("</TR>");
	}

	public static void addQuickLinks(StringBuffer html) {
		html.append("<TR><TD><A href=\"#links\">Quick Links</A></TD></TR>");
	}

	public static void addPageHeader(String title, StringBuffer html) {
		html.append("<TABLE width=\"100%\" >");
		html.append("<TR><TH class=\"pageheader\">" + title
				+ "</TH></TR></TABLE><BR><BR>");
	}

	public static void addPageFooter(StringBuffer html) {
		html.append("<BR><BR><TABLE width=\"100%\" >");
		html.append("<TR><TH class=\"pagefooter\">Copyright &#169; 2012-2013 <B>Numerify</B>. All rights reserved.</TH></TR></TABLE>");
	}
}
