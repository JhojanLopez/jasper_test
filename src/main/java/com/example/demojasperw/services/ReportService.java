package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;

import java.util.Map;

public interface ReportService {
    JasperDTO generatePdfReport(Map<String, Object> parameters) throws Exception;
}
