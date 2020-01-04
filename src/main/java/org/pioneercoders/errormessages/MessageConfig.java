package org.pioneercoders.errormessages;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class MessageConfig {

	@Bean(name = "msgProps")
	public static PropertiesFactoryBean messageMapper() {
	    PropertiesFactoryBean bean = new PropertiesFactoryBean();
	    bean.setLocation(new ClassPathResource("messages.properties"));
	    return bean;
	}
	
}
