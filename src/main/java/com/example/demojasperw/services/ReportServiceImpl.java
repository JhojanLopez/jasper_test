package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import com.example.demojasperw.models.RequestPdfDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    @Value("${templates.jasper.directory}")
    private String reportDirectory;
    private final JasperReportManager jasperReportManager;
    @Override
    public JasperDTO generatePdfReport(RequestPdfDto requestPdfDto) throws Exception {
        if (requestPdfDto.getTemplateId().equals("template_default"))
            return jasperReportManager.generatePdf(true, null, requestPdfDto.getParameters());

        String internalFile = reportDirectory.concat("\\").concat(requestPdfDto.getTemplateId()).concat(".jrxml");
        return jasperReportManager.generatePdf(false, internalFile, requestPdfDto.getParameters());
    }
}
