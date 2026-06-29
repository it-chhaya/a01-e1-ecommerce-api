package co.istad.chhaya.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceHandlersConfig implements WebMvcConfigurer {

    @Value("${file-upload.client-path}")
    private String clientPath;

    @Value("${file-upload.server-path}")
    private String serverPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(clientPath + "/**")
                .addResourceLocations("file:" + serverPath);
        // Resource Type
        // 1. Classpath Resource (classpath:)
        // 2. File system Resource (file:)
        // 3. Internet (http:)
    }
}
