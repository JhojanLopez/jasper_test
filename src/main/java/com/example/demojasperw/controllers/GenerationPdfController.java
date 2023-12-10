package com.example.demojasperw.controllers;

import com.example.demojasperw.models.JasperDTO;
import com.example.demojasperw.models.RequestPdfDto;
import com.example.demojasperw.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class GenerationPdfController {
    private final ReportService reportService;

    @PostMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody RequestPdfDto requestPdfDto) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "archivo.pdf");
        JasperDTO jasperDTO = reportService.generatePdfReport(requestPdfDto);
        return new ResponseEntity<>(jasperDTO.getJasperByte(), headers, HttpStatus.OK);
    }
}
