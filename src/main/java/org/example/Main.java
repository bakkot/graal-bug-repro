package org.example;

import org.graalvm.polyglot.Context;

public class Main {
	public static void main(String[] args) {
		try (Context context = Context.newBuilder("js").option("engine.WarnInterpreterOnly", "false").build();) {
			context.eval("js", "" +
				"print('init');\n" +
				"try {\n" +
				"  null[0] = print('rhs');\n" +
				"} catch (e) {\n" +
				"  print('catch');\n" +
				"  // ignored\n" +
				"}\n");
		}
	}
}
