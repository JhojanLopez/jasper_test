package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import com.example.demojasperw.utils.PdfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    @Value("${templates.jasper.path}")
    private String templateDefault;
    private final JasperReportManager jasperReportManager;
    @Override
    public JasperDTO generatePdfReport(Map<String, Object> parameters) throws Exception {
        return jasperReportManager.generatePdf(parameters);
    }
}
