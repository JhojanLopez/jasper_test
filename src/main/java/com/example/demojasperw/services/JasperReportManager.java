package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.util.Map;

public interface JasperReportManager {
    JasperDTO generatePdf(Map<String, Object> parameters) throws JRException, IOException;
}
