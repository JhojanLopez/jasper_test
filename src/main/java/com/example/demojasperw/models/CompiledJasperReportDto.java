package com.example.demojasperw.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.JasperReport;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompiledJasperReportDto {
    private String id;
    private JasperReport jasperReport;
}
