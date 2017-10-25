package window.logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogToSystemIO implements LogMessageAdapter {
	static final String LINE_SEPARATOR_PATTERN =  "\r\n|[\n\r\u2028\u2029\u0085]";


	@Override
	public void log_println(String x) {
		String[] s_split = x.split(LINE_SEPARATOR_PATTERN);
		for(String s : s_split) System.out.println("#," + s);
	}

	@Override
	public void log_print(Exception e) {
		// エラーのスタックトレースを表示
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		pw.flush();
		log_println(sw.toString());
	}

}
