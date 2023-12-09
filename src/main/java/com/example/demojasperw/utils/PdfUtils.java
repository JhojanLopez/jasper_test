package com.example.demojasperw.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

import com.example.demojasperw.models.JasperDTO;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.*;

/**
 * @author jsbuitrago
 */
@Log4j2
public class PdfUtils {

    private PdfUtils() {
    }


    public static String getInternalFile(String filePath) throws Exception {
        log.info("Loading file {}....", filePath);
        String payload = Files.readString(Paths.get(filePath));
        return payload;
    }
}
