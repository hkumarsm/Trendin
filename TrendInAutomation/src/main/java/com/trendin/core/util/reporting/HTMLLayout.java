package com.trendin.core.util.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.Transform;
import org.apache.log4j.spi.LoggingEvent;

import com.sun.security.auth.module.NTSystem;

/**
 * Generates HTML layout to be used with test cases
 * 
 * @author Neo
 */
public class HTMLLayout extends Layout
{
    static String TRACE_PREFIX = "<br>&nbsp;&nbsp;&nbsp;&nbsp;"; //Indenter
    String title = "Automation Test Report";
    
    private static Date lastTime;
    private static long totalTime = 0;
    private int lvlIndex = 0;
    private int depth = 0;
    String runByString = "";
    // stack for nested keyword calls
    private LinkedList<Integer> lvlStack = new LinkedList<Integer>(){

		private static final long serialVersionUID = 1L;

		@Override
    	public String toString(){
    		StringBuffer sb = new StringBuffer();
    		for(Integer i : this)
    		{
    			sb.append("lvl").append(i).append(" ");
    		}
    		return sb.toString();
    	}
    };



    /**
     * A string constant used in naming the option for setting the the location
     * information flag. Current value of this string constant is <b>LocationInfo</b>.
     * 
     * <p>
     * Note that all option keys are case sensitive.
     */
    public static final String LOCATION_INFO_OPTION = "LocationInfo";

    /**
     * A string constant used in naming the option for setting the the HTML
     * document title. Current value of this string constant is <b>Title</b>.
     */
    public static final String TITLE_OPTION = "Title";

    /**
     * Show Time column by default
     */
    private boolean showTime = true;

    /**
     * Default header for Time column in HTML table
     */
    private String timeHeader = "<th bgcolor=\"#FFD630\">Time</th>";

    /**
     * Default header for Message column in HTML table
     */
    private String messageHeader = "<th>Open <a onclick='openAll()' href='#'>all</a><br />"
    							 + "Close <a onclick='closeAll()' href='#'>all</a></th>"
    							 + "<th> </th>"
    							 + "<th>Test Case ID</th>"
    		                     + "<th>Test Scenario</th>"
    		                     + "<th>Methods</th>"
    		                     + "<th>Error Message</th>"
    		                     + "<th>Result</th>"
    		                     + "<th>Comments</th>";
    
    // Last row was the start of a keyword row.
    private boolean lastStart = false;
    // End part of the last keyword start row. (see format method)
    private String lastRowEnd;

    private static String version, programName, hostName;
    
    private final static String DEPTH_CHAR = "&ndash;"; 
    
    public static void setInfo(String version, String programName, String hostName)
    {
    	HTMLLayout.version = version;
    	HTMLLayout.programName = programName;
    	HTMLLayout.hostName = hostName;
    }

    void appendThrowableAsHTML(String[] s, StringBuffer sbuf) 
    {
        if (s != null) 
        {
            int len = s.length;
            
            if (len == 0)
                return;
            
            sbuf.append(Transform.escapeTags(s[0]));
            sbuf.append(Layout.LINE_SEP);
            
            for (int i = 1; i < len; i++) 
            {
                sbuf.append(TRACE_PREFIX);
                sbuf.append(Transform.escapeTags(s[i]));
                sbuf.append(Layout.LINE_SEP);
            }
        }
    }
    
    private static String lvl(int i)
    {
    	return "lvl" + i;
    }

    /**
     * Returns format and time stamp
     */
    @Override
	public String format(LoggingEvent event) 
    {
    	// use valueOf to prevent null pointer exceptions
    	String eventMethod = String.valueOf(event.getProperty("event"));
        
        //Output buffer
        StringBuilder sbuf = new StringBuilder();
        
        
        String toggle = "";
        
        // flags for row shortening.
        boolean thisStart = false;	// This row is the start of a keyword
        boolean thisEnd = false;	// This row is the end of a keyword.
        boolean failure = false;	// This row is the end of a keyword that fails;
        

        String depthStr = "";
        
        
        // Row header
        sbuf.append("<tr ");    	
        switch (eventMethod)
        {
        case "startTC":
        	thisStart = true;
        case "startScenario":
        case "startUC":
        	toggle = lvl(++lvlIndex);
        	
        	if(!lvlStack.isEmpty())
        	{
	        	sbuf.append("class=\"" + lvlStack.toString() + "close-hide-temp\" ");
	        	sbuf.append("data-thisclass='" + lvl(lvlStack.peek()) + "' ");
        	}
        	sbuf.append("id='" + toggle + "' ");
        	sbuf.append(Layout.LINE_SEP);
        	lvlStack.push(lvlIndex);
        	for(int d = 0; d < depth; d++) depthStr += DEPTH_CHAR;
        	depth++;
        	break;
        case "failTC":
		case "warnTC":		
			failure = true;
		case "passTC":
		case "untestableTC":
			thisEnd = true;
    	case "passUC":
		case "failUC":
		case "passScenario":
		case "failScenario":
		case "warnScenario":
			String cur;
        	if(!lvlStack.isEmpty())
        	{
        		cur = lvl(lvlStack.pop());
        	}
        	else
        	{
        		cur = "lvl0";
        	}
        	if(!lvlStack.isEmpty())
        	{
	        	sbuf.append("class=\"" + lvlStack.toString() + "close-hide-temp\" ");
	        	sbuf.append("data-thisclass='" + lvl(lvlStack.peek()) + "' ");
        	}
        	sbuf.append("id='~" + cur + "' ");
        	sbuf.append(Layout.LINE_SEP);
        	depth--;
        	for(int d = 0; d < depth; d++) depthStr += DEPTH_CHAR;
        	break;
		case "comment":
		case "debug":
        	if(!lvlStack.isEmpty())
        	{
	        	sbuf.append("class=\"" + lvlStack.toString() + "close-hide-temp\" ");
	        	sbuf.append("data-thisclass='" + lvl(lvlStack.peek()) + "' ");
        	}
        	      	
        	sbuf.append(Layout.LINE_SEP);
        	for(int d = 0; d < depth; d++) depthStr += DEPTH_CHAR;
        }        
        sbuf.append(">");  
        // End row header

        //Display's Time Stamp
        if (showTime) 
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            
            Date curr = new Date(event.timeStamp);
            String timestamp;
            if(lastTime == null) 
            {
            	timestamp = "Started: " + formatter.format(curr);
            	try {
	            	sbuf.insert(0, "<!--" + (StringUtils.endsWithIgnoreCase(programName, ".jar") ? "Run from jar file with name '" + programName + "'" : "NOT run from jar file") + "-->");
	            	sbuf.insert(0, "<!--Run from machine with name '" + hostName + "'-->");
            	} catch(NoClassDefFoundError e) { 
            		timestamp = timestamp + "<br>Run by: Unknown user.";
            	}
            }
            else
            {
            	long totalms = curr.getTime() - lastTime.getTime();
            	totalTime += totalms;
            	timestamp = "Step: " + formatTime(totalms) + "<BR>" +
            				"Total: " + formatTime(totalTime);            	
            }
            lastTime = curr;
            sbuf.append("<td>");
            sbuf.append(timestamp);
            sbuf.append("</td>" + Layout.LINE_SEP);
            
        }
        else
        {
        	sbuf.append("<td></td>" + Layout.LINE_SEP);
        }
        
        if(toggle.isEmpty())
        {
        	sbuf.append("<td></td>" + Layout.LINE_SEP);
        }
        else
        {
	        // toggle button
	        sbuf.append("<td class='tog-off-temp' id='" + toggle + "'><span ")
	        	.append("onclick=\"tog('"+ toggle + "');togParent(this);\" ")
	       		.append("href='#" + toggle + "'></a></td>")
	        	.append(Layout.LINE_SEP);
        }
        
        String message = event.getRenderedMessage();
        
        // set depth
        if(depth > 0)
        	message = message.replaceAll("(?<=>)\\.(?=<)", depthStr);
        
        // Get start and end of the current row, if it is the start or end of a keyword.
        // The split between "start" and "end" is immediately before the Result column.
        // ("STARTED"/"PASS"/"FAIL"/etc.)
        String thisRowStart = "";
        String thisRowEnd = "";
        if(thisStart || thisEnd)
        {
        	String msg[] = message.split("(?<=<td )(?=bgcolor=#[0-9a-fA-F]{6}>(STARTED|WARNING|SKIPPED|PASS|FAIL))", 2);
        	thisRowStart = sbuf.toString() + msg[0];
            thisRowEnd = msg[1] + "</tr>" + Layout.LINE_SEP;
        }
        
        sbuf.append(message).append("</tr>").append(Layout.LINE_SEP);
        
        String ret;
        
        // In order to reduce the number of rows, then keywords that pass with
        // no sub-rows (e.g. comments) are shortened to only take up one row in
        // the report. Failing keywords need the entire ending row to get the
        // error message correctly.
        
        // If this is the start of a keyword...
        if(thisStart)
        {
        	// If the last row was the start of a keyword
        	if(lastStart)
        	{
        		// finish the last row and start this one.
        		ret = lastRowEnd + thisRowStart;
        	}
        	else
        	{
        		// otherwise, just start this row.
	        	ret = thisRowStart;
        	}
        	// Save the end of this row
        	lastRowEnd = thisRowEnd;
        }
        else
        {	        
        	// Else, if the previous row was the start of a keyword
	        if(lastStart)
	        {
	        	// And this is the end of a non-failing keyword
	        	// (i.e. the end row of the keyword that started the previous row)
	        	if(thisEnd && !failure)
	        	{
	        		// Then add the end of this row
	        		// (to the start of the previoud row)
	        		ret = thisRowEnd;
	        	}
	        	else
	        	{
	        		// Otherwise, finish the last row and add this row.
	        		ret = lastRowEnd + sbuf.toString();
	        	}
	        }
	        else
	        {
	        	// If neither this row nor the previous are starting rows,
	        	// Just add this row to output.
	        	ret = sbuf.toString();
	        }
        }
        
        // Save whether this was a start row.
        lastStart = thisStart;

        return ret;
        
        //return sbuf.toString();
    }
    
    private String formatTime(long millis)
    {
    	long ms = millis % 1000;
    	long ss = (millis / 1000) % 60;
    	long mm = (millis / (1000 * 60)) % 60;
    	long hh = (millis / (1000 * 60 * 60));
    	return String.format("%02d:%02d:%02d.%03d", hh, mm, ss, ms);
    }

    /**
     * Returns the content type output by this layout, i.e "text/html".
     */
    @Override
	public String getContentType() 
    {
        return "text/html";
    }

    /**
     * Returns the appropriate HTML footers.
     */
    @Override
	public String getFooter() 
    {
        StringBuffer sbuf = new StringBuffer();
        
        sbuf.append("</table>" + Layout.LINE_SEP);
        sbuf.append("<br>" + Layout.LINE_SEP);
        sbuf.append("</body></html>");
        
        return sbuf.toString();
    }

    /**
     * Returns appropriate HTML headers.
     */
    @Override
	public String getHeader() 
    {
        StringBuffer sbuf = new StringBuffer();
        
        sbuf.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">" 
                + Layout.LINE_SEP);
        sbuf.append("<html>" + Layout.LINE_SEP);
        sbuf.append("<head>" + Layout.LINE_SEP);
        sbuf.append("<title>" + title + "</title>" + Layout.LINE_SEP);
        // CSS
        sbuf.append("<style type='text/css'>"+ Layout.LINE_SEP);
        sbuf.append("body, table {font-family: arial,sans-serif; font-size: x-small;}"+ Layout.LINE_SEP);
        sbuf.append("th  {background: \"#FFD630\"; color: #000000; text-align: center;} "+ Layout.LINE_SEP);
        sbuf.append("th a {color: #000000;}"+ Layout.LINE_SEP);
        sbuf.append(".open-show {display: table-row;}"+ Layout.LINE_SEP);
        sbuf.append(".open-hide, .close-hide {display: none;}"+ Layout.LINE_SEP);
        sbuf.append(".tog-off span:before {content:'[+]';}"+ Layout.LINE_SEP);
        sbuf.append(".tog-on span:before {content:'[-]';}"+ Layout.LINE_SEP);
        sbuf.append(".tog-off {font-size: x-large; text-align: center;}"+ Layout.LINE_SEP);
        sbuf.append(".tog-on {font-size: x-large; text-align: center;}"+ Layout.LINE_SEP);
        sbuf.append("span {cursor:pointer;}"+ Layout.LINE_SEP);
        sbuf.append("</style>"+ Layout.LINE_SEP);
        // JS
        // Full script below. Use a minimizer to reduce file size
        /*
         	// Get class lit of an element
			function getClassList(elt) {
				var classes = elt.className;
				var ret = new Object();
				ret.elt = elt;
				ret.classList = classes.split(' ');
				ret.contains = function (cls) {
					return this.classList.indexOf(cls) >= 0;
				};
				ret.remove = function (cls) {
					var newClassList = [];
					while (this.classList.length > 0) {
						var tmp = this.classList.pop();
						if (tmp != cls)
							newClassList.push(tmp);
					}
					this.classList = newClassList;
					this.elt.className = this.classList.join(' ');
				};
				ret.add = function (cls) {
					this.classList.push(cls);
					this.elt.className = this.classList.join(' ');
				};
				ret.toggle = function (cls) {
					if (this.contains(cls))
						this.remove(cls);
					else
						this.add(cls);
				};
				ret.length = ret.classList.length;
				ret.item = function (i) {
					return this.classList[i];
				};
				return ret;
			}
			// Toggle a row's subrows on/off
			function tog(cls) {
				var rows = document.getElementsByClassName(cls);
				for (var r = 0; r < rows.length; ++r) {
					var row = rows[r];
					var clslist = getClassList(row);
					if (row.getAttribute('data-thisclass') == cls) {
						clslist.toggle('open-show');
						clslist.toggle('close-hide');
					} else {
						if (clslist.contains('open-show')) {
							clslist.remove('open-show');
							clslist.add('open-hide');
						} else if (clslist.contains('open-hide')) {
							var disp = true;
							for (var i = 0; i < clslist.length; i++) {
								var item = document.getElementById(clslist.item(i));
								if (getClassList(item).contains('close-hide')) {
									disp = false;
									break;
								}
							}
							if (disp) {
								clslist.remove('open-hide');
								clslist.add('open-show');
							}
						}
					}
				}
			}
			// Open all rows
			function openAll() {
				var closed = document.getElementsByClassName('tog-off');
				while (closed.length > 0) {
					closed[0].firstElementChild.click();
				}
			}
			// Close all rows
			function closeAll() {
				openAll();
				var open = document.getElementsByClassName('tog-on');
				while (open.length > 0) {
					open[open.length - 1].firstElementChild.click();
				}
			}
			// Toggle parent row (for [+]/[-] "buttons")
			function togParent(obj) {
				getClassList(obj.parentNode).toggle('tog-on');
				getClassList(obj.parentNode).toggle('tog-off');
			}
			// Hide all on load
			window.onload = function () {
				var close = document.getElementsByClassName('close-hide-temp');
				while (close.length > 0) {
					clslist = getClassList(close[0]);
					clslist.toggle('close-hide-temp');
					clslist.toggle('close-hide');
				}
				var togs = document.getElementsByClassName('tog-off-temp');
				while (togs.length > 0) {
					var elts = document.getElementsByClassName(togs[0].id);
					var clslist = getClassList(togs[0]);
					clslist.toggle('tog-off-temp');
					if (elts.length > 0) {
						clslist.toggle('tog-off');
					}
				}
			};

         */
        
        sbuf.append("<script>");
        sbuf.append("function getClassList(t){var e=t.className,s=new Object;return s.elt=t,s.classList=e.split(' '),s.contains=function(t){return this.classList.indexOf(t)>=0},s.remove=function(t){for(var e=[];this.classList.length>0;){var s=this.classList.pop();s!=t&&e.push(s)}this.classList=e,this.elt.className=this.classList.join(' ')},s.add=function(t){this.classList.push(t),this.elt.className=this.classList.join(' ')},s.toggle=function(t){this.contains(t)?this.remove(t):this.add(t)},s.length=s.classList.length,s.item=function(t){return this.classList[t]},s}function tog(t){for(var e=document.getElementsByClassName(t),s=0;s<e.length;++s){var o=e[s],n=getClassList(o);if(o.getAttribute('data-thisclass')==t)n.toggle('open-show'),n.toggle('close-hide');else if(n.contains('open-show'))n.remove('open-show'),n.add('open-hide');else if(n.contains('open-hide')){for(var l=!0,i=0;i<n.length;i++){var a=document.getElementById(n.item(i));if(getClassList(a).contains('close-hide')){l=!1;break}}l&&(n.remove('open-hide'),n.add('open-show'))}}}function openAll(){for(var t=document.getElementsByClassName('tog-off');t.length>0;)t[0].firstElementChild.click()}function closeAll(){openAll();for(var t=document.getElementsByClassName('tog-on');t.length>0;)t[t.length-1].firstElementChild.click()}function togParent(t){getClassList(t.parentNode).toggle('tog-on'),getClassList(t.parentNode).toggle('tog-off')}window.onload=function(){for(var t=document.getElementsByClassName('close-hide-temp');t.length>0;)o=getClassList(t[0]),o.toggle('close-hide-temp'),o.toggle('close-hide');for(var e=document.getElementsByClassName('tog-off-temp');e.length>0;){var s=document.getElementsByClassName(e[0].id),o=getClassList(e[0]);o.toggle('tog-off-temp'),s.length>0&&o.toggle('tog-off')}};");
        sbuf.append("</script>"+ Layout.LINE_SEP);
        sbuf.append("</head>" + Layout.LINE_SEP);
        // HTML body
        sbuf.append("<body bgcolor=\"#FFFFFF\" topmargin=\"6\" leftmargin=\"6\">"
                + Layout.LINE_SEP);
        sbuf.append("<span id='open-hide'></span><span id='open-show'></span><span id='close-hide'></span>" + Layout.LINE_SEP);
        sbuf.append("<hr size=\"1\" noshade>" + Layout.LINE_SEP);
        sbuf.append("<div style=\"text-align:center\"><B><h1>Automation Test Report <h1></B></div>" + Layout.LINE_SEP);
        sbuf.append("<div style=\"text-align:center\"> <h3> Generated by <a href=\"http://www.qualitestgroup.com\" target=\"_top\">Qualitest Automation Framework</a> using <a href=\"http://www.testng.org\" target=\"_top\">TestNG</a> <h3></div>" + Layout.LINE_SEP);
        sbuf.append(Layout.LINE_SEP);
        try {
        	NTSystem x = new NTSystem();
        	runByString = x.getDomain() + "\\" + x.getName();
        } catch(Exception e){
        	runByString = "Default User.";
        }
        sbuf.append("<table align=\"center\" cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#FF6600\" width=\"35%\"> <font color=\"#5C5CE6\"> <tr> <td bgcolor=\"#FFD630\" width=\"35%\"> <b> Application Name: <b> </td> <td align=\"center\"> <b> <a href=\"http://www.trendin.com\" target=\"_top\"> TrendIn.com <b> </td> </tr> <tr> <td bgcolor=\"#FFD630\" width=\"35%\"> <b> Started at: <b> </td> <td align=\"center\"> <b>" + new java.util.Date() +"<b> </td></tr> <tr> <td bgcolor=\"#FFD630\" width=\"35%\"> <b> Run by: <b> </td> <td align=\"center\"> <b>" + runByString +"<b> </td></tr> </font> </table> <br>" + Layout.LINE_SEP + Layout.LINE_SEP + Layout.LINE_SEP);
        sbuf.append("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\">"  + Layout.LINE_SEP);
        sbuf.append("<tr bgcolor=\"#FFD630\">" + Layout.LINE_SEP);
        sbuf.append("<th>Time</th>" + Layout.LINE_SEP);
        sbuf.append(messageHeader + Layout.LINE_SEP);
        sbuf.append("</tr>" + Layout.LINE_SEP);
        return sbuf.toString();
    }   
    /**
     * Returns the current value of the <b>MessageHeader</b> option.
     */
    public String getMessageHeader()
    {
        return messageHeader;
    }

    /**
     * Returns the current value of the <b>ShowTime</b> option.
     */
    public boolean getShowTime() 
    {
        return showTime;
    }

    /**
     * Returns the current value of the <b>TimeHeader</b> option.
     */
    public String getTimeHeader() 
    {
        return timeHeader;
    }

    /**
     * Returns the current value of the <b>Title</b> option.
     */
    public String getTitle() 
    {
        return title;
    }

    /**
     * The HTML layout handles the throwable contained in logging events. Hence,
     * this method return <code>false</code>.
     */
    @Override
	public boolean ignoresThrowable() 
    {
        return false;
    }

    /**
     * The <b>MessageHeader</b> option takes a String value. This option sets
     * the table header for the message column in the HTML table layout.
     * <p/>
     * <p>
     * Defaults to '&lt;th&gt;Message&lt;/th&gt;'.
     */
    public void setMessageHeader(String msgHeader) 
    {
        this.messageHeader = msgHeader;
    }

    public void setShowTime(boolean flag) 
    {
        showTime = flag;
    }

    /**
     * The <b>TimeHeader</b> option takes a String value. This option sets the
     * table header for the time column in the HTML table layout.
     * <p/>
     * <p>
     * Defaults to '&lt;th&gt;Time&lt;/th&gt;'.
     */
    public void setTimeHeader(String timeHeader) 
    {
        this.timeHeader = timeHeader;
    }

    /**
     * The <b>Title</b> option takes a String value. This option sets the
     * document title of the generated HTML document.
     * 
     * <p>
     * Defaults to 'Log4J Log Messages'.
     */
    public void setTitle(String title) 
    {
        this.title = title;
    }
    
    /**
     * No options to activate.
     */
    @Override
	public void activateOptions() {}
}
