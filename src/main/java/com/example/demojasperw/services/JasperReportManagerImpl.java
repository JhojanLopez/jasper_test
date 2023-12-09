package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import com.example.demojasperw.utils.PdfUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JasperReportManagerImpl implements JasperReportManager {
    @Value("${templates.jasper.path}")
    private String defaultTemplate;
    private JasperReport defaultReport;

    @PostConstruct
    public void preCompile() {

        try (InputStream inputStream = new ByteArrayInputStream(PdfUtils
                .getInternalFile(defaultTemplate).getBytes(StandardCharsets.UTF_8))) {
            this.defaultReport = JasperCompileManager.compileReport(inputStream);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*
    @PostConstruct
    public void preCompile() {

        try (InputStream inputStream = new ByteArrayInputStream(PdfUtils.getInternalFile(templateDefault).getBytes(StandardCharsets.UTF_8))) {
            JasperCompileManager.compileReport(inputStream);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    /**
     * Busca una plantilla Jasper (jrxml) la compila y genera PDF.
     *
     * @param templateRoute Ruta de la plantilla.
     * @param parameters    Parámetros a pasar a la plantilla.
     * @return Arreglo de bytes con el cotenido del PDF.
     * @throws JRException Sí ocurrió un error durante la generación del PDF con
     *                     Jasper.
     * @throws IOException Sí no se encontró la ruta de la plantilla.
     */
    @Override
    public JasperDTO generatePdf(Map<String, Object> parameters)
            throws JRException, IOException {
        log.info("[JasperReportManagerImpl] -> [generatePdfFromJrxml]");
        JasperPrint print = JasperFillManager.fillReport(defaultReport, parameters, new JREmptyDataSource());

        return JasperDTO.builder()
                .jasperByte(JasperExportManager.exportReportToPdf(print))
                .pages(print.getPages().size())
                .build();
    }
}
