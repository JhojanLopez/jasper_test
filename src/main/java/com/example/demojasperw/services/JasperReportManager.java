package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.util.Map;

public interface JasperReportManager {
    JasperDTO generatePdf(boolean isDefault, String internalFile, Map<String, Object> parameters) throws Exception;
}
