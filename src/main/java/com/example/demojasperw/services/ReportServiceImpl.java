package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import com.example.demojasperw.utils.PdfUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Value("${templates.jasper.path}")
    private String templateDefault;
    @Override
    public JasperDTO generatePdfReport(Map<String, Object> parameters) throws Exception {
        String internalFile = PdfUtils.getInternalFile(templateDefault);
        return PdfUtils.generatePdfFromJrxml(internalFile, parameters);
    }
}
