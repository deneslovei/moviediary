package org.nnc.moviediary.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextLoader {

	public static void loadSpring() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"META-INF/spring/applicationContext-bootstrap.xml");
		appContext.close();
	}
}
