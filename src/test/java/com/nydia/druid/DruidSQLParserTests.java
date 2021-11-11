package com.nydia.druid;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import com.alibaba.druid.util.JdbcConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DruidSQLParserTests {

	static String sql = "SELECT a.id,a.name \n" +
			"FROM  USER a \n" +
			"LEFT JOIN td_order b ON b.user_id = a.id\n" +
			"WHERE a.age >= 1\n" +
			"AND a.id = (SELECT user_id FROM td_order WHERE order_no = 'no1')\n" +
			"GROUP BY a.id desc ,a.name desc \n" +
			"HAVING a.id <> 100\n" +
			"LIMIT 0, 10";

	public static void testStmt() {
		List<SQLStatement> statementList = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
		statementList.stream().forEach(e -> System.out.println(e.getDbType()));
	}

	public static void main(String[] args) {
		//testStmt();

		MySqlVisitorDemo();
	}

	public static class ExportTableAliasVisitor extends MySqlASTVisitorAdapter {
		private Map<String, SQLTableSource> aliasMap = new HashMap<String, SQLTableSource>();
		public boolean visit(SQLExprTableSource x) {
			String alias = x.getAlias();
			aliasMap.put(alias, x);
			return true;
		}

		public Map<String, SQLTableSource> getAliasMap() {
			return aliasMap;
		}
	}
	public static void MySqlVisitorDemo() {
		List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, DbType.mysql);

		ExportTableAliasVisitor visitor = new ExportTableAliasVisitor();
		for (SQLStatement stmt : stmtList) {
			stmt.accept(visitor);
		}

		SQLTableSource tableSource = visitor.getAliasMap().get("a");
		System.out.println(tableSource);
	}

}
