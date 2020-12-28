package org.warship.processor;

import java.io.IOException;

import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;

public class GroovyUtil {
	private static GroovyUtil mInstance;
	private GroovyScriptEngine groovyScriptEngine;

	public static GroovyUtil getInstance() {
		if(null == mInstance) {
			mInstance = new GroovyUtil();
		}

		return mInstance;
	}


	private GroovyUtil() {
		try {
			groovyScriptEngine = new GroovyScriptEngine("src/main/java/org/warship/processor/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用于调用指定Groovy脚本中的指定方法
	 *
	 * @param scriptName 脚本名称
	 * @param methodName 方法名称
	 * @param params     方法参数
	 * @return
	 */
	@SuppressWarnings({"rawtypes"})
	public Object invokeMethod(String scriptName, String methodName, Object... params) throws Exception{
		Object ret = null;
		Class scriptClass = null;
		GroovyObject scriptInstance = null;

		System.out.println("scriptName:"+scriptName);
		System.out.println("methodName:"+methodName);
		System.out.println("params1:"+params[0]);
		System.out.println("params2:"+params[1]);
		System.out.println("params3:"+params[2]);

		scriptClass = groovyScriptEngine.loadScriptByName(scriptName);
		scriptInstance = (GroovyObject) scriptClass.newInstance();

		try {
			ret = (String) scriptInstance.invokeMethod(methodName, params);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}
}
