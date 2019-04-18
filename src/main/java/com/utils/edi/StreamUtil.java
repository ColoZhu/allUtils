package com.utils.edi;

import org.slf4j.Logger;

import java.lang.reflect.Method;

public class StreamUtil {

	public static void close(Object o, Logger logger) {
		if(o != null) {
			try {
		        Method setMethod = o.getClass().getMethod("close");
		        if(setMethod == null) {
		        	logger.warn("该对象没有 close 方法：" + o.getClass().getName());
		        }
		        setMethod.invoke(o);
			} catch (Exception e) {
				logger.error("关闭[流]时出现了异常：", e);
			}
		}
	}
}
