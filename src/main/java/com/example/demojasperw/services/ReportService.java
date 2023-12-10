package com.example.demojasperw.services;

import com.example.demojasperw.models.JasperDTO;
import com.example.demojasperw.models.RequestPdfDto;

import java.util.Map;

public interface ReportService {
    JasperDTO generatePdfReport(RequestPdfDto requestPdfDto) throws Exception;
}
