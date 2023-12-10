package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import com.example.demojasperw.utils.PdfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {
    @Value("${templates.jasper.path}")
    private String templateDefault;
    @Value("${templates.jasper.directory}")
    private String jasperDirectory;
    private final JasperReportManager jasperReportManager;
    public JasperDTO generatePdfReport(Map<String, Object> parameters) throws Exception {
        return jasperReportManager.generatePdf(parameters);
    }

    public JasperDTO generatePdfReportNoJrLoader(String template, Map<String, Object> parameters) throws Exception {

        return PdfUtils.generatePdfFromJrxml(PdfUtils
                .getInternalFile(jasperDirectory.concat("\\").concat(template)),parameters);
    }
}
