package org.warship.processor;

public class TestClass {

	public static void main(String[] args) {
		try {
			GroovyUtil.getInstance().invokeMethod("ProcessorHelper.groovy", "create"
					, "./src/main/java/org/warship/processor/"
					, "VersionClass.java"
					, "aaaaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
