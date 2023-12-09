package com.example.demojasperw.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

import com.example.demojasperw.models.JasperDTO;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.*;

/**
 * @author jsbuitrago
 */
@Log4j2
public class PdfUtils {

    private PdfUtils() {
    }

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
    public static JasperDTO generatePdfFromJrxml(String templateRoute, Map<String, Object> parameters)
            throws JRException, IOException {
        log.info("[PdfUtils] -> [generatePdfFromJrxml]");
        try (InputStream inputStream = new ByteArrayInputStream(templateRoute.getBytes(StandardCharsets.UTF_8))) {
            JasperReport report = JasperCompileManager.compileReport(inputStream);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

            return JasperDTO.builder()
                    .jasperByte(JasperExportManager.exportReportToPdf(print))
                    .pages(print.getPages().size())
                    .build();
        }
    }

    public static String getInternalFile(String filePath) throws Exception {
        log.info("Loading file {}....", filePath);
        String payload = Files.readString(Paths.get(filePath));
        return payload;
    }
}
