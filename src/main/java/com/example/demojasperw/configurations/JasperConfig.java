package com.example.demojasperw.configurations;

import com.example.demojasperw.models.JasperDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class JasperConfig {
    @Value("${templates.jasper.path}")
    private String templateDefault;
    /* bean jasper context
    @Bean
    public JasperReportsContext jasperReportsContext() throws JRException {
        return DefaultJasperReportsContext.getInstance();
    }
*/
    /*@Bean
    public JasperReport defaultReport() throws JRException, IOException {
        try (InputStream inputStream = new ByteArrayInputStream(templateDefault.getBytes(StandardCharsets.UTF_8))) {
            return JasperCompileManager.compileReport(inputStream);
        }
        //InputStream inputStream = new ByteArrayInputStream(templateDefault.getBytes(StandardCharsets.UTF_8));
    }*/
}
