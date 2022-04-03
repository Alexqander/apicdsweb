package com.cds.mx.apicds.pdfGenerator.controller;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@Service
public class PDFGeneratorService {
    public void exportCv(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();

        Image perfil = Image.getInstance(new URL(""));

    }
}
