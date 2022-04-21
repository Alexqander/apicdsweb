package com.cds.mx.apicds.pdfGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/cds/exportCv")
@CrossOrigin(origins = {"*"})

public class PdfCVExportController {

    @Autowired
    PDFGeneratorService pdfGeneratorService;

    @GetMapping("/{id}/pdf")
    public void generatePdf(@PathVariable(value = "id")long id, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:ss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";
        response.setHeader(headerKey,headerValue);

        pdfGeneratorService.exportCv(id,response);
    }
}
