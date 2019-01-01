
package com.example.mac.practise.restApi.Config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
public class MYJavaConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){

        Resource resource;
        String activeProfile;
        PropertySourcesPlaceholderConfigurer propertySourcePlaceHolderConfigure = new PropertySourcesPlaceholderConfigurer();

        //get active profiles
        activeProfile=System.getProperty("spring.profiles.active");

        //choose different properties file for different active profiles
        if("development".equals(activeProfile)){
            resource= new ClassPathResource("application-dev.properties");
            propertySourcePlaceHolderConfigure.setLocation(resource);
        }
        else if("production".equals(activeProfile)){
            resource=new ClassPathResource("application-prod.properties");
            propertySourcePlaceHolderConfigure.setLocation(resource);
        }

        //load the property file


        return propertySourcePlaceHolderConfigure;

    }
}

