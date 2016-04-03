package project4;

import java.util.ArrayList;

public class Statement {
	
	private ArrayList<String> lines = new ArrayList<String>();

	public Statement() {}
	
	public void addLine(String line) {
		lines.add(line);
	}
	
	public void printStatement() {
		for (String line : lines) {
			System.out.println(line + "\n");
		}
	}
	
	public void printHTMLStatement() {
		String statementLine1 = "  ";
		String statementLine2 = "    ";
		String statementLine3 = "      ";
		System.out.println("<html>");
		System.out.println(statementLine1 + "<span>" + lines.get(0) + "</span>");
		System.out.println(statementLine1 + "<table>");
		for (int i = 1; i < lines.size() - 2; i++) {
			System.out.println(statementLine2 + "<tr>");
			System.out.println(statementLine3 + "<td>" + lines.get(i).split("\t")[0] + "</td>");
			System.out.println(statementLine3 + "<td>" + lines.get(i).split("\t")[1] + "</td>");
			System.out.println(statementLine2 + "</tr>");
		}
		System.out.println(statementLine1 + "</table>");
		System.out.println(statementLine1 + "<span>" + lines.get(lines.size() - 2) + "</span>");
		System.out.println(statementLine1 + "<span>" + lines.get(lines.size() - 1) + "</span>");
		System.out.println("</html>");
	}
	
}