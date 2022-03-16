package com.mindhub.duodanzaclub.services.implementations;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.lowagie.text.Document;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.mindhub.duodanzaclub.models.Productos;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.repositories.ProductoRepository;
import com.mindhub.duodanzaclub.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import sun.net.ext.ExtendedSocketOptions;


import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Service
public class PdfServiceImpl {
    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoRepository productoRepository;
    public void export(HttpServletResponse response, List<Productos> productos, Usuario usuario) throws IOException {




        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Font fontLogo = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontLogo.setSize(23);

        Paragraph logo = new Paragraph("Dúo Danza Club", fontLogo);

        Paragraph paragraph = new Paragraph("Resumen de compra", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        PdfPTable table= new PdfPTable(3);

        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.0f, 5.0f, 3.0f});
        table.setSpacingBefore(10);


        addTableHeader(table);
        addTableTransactionsContent(table, usuario, productos);

        Paragraph paragraph2= new Paragraph("Usuario: "+usuario.getNombre()+" "+usuario.getApellido(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);


        Paragraph subtitulo = new Paragraph("Detalles de compra realizada",fontTitle);
        subtitulo.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph3 = new Paragraph("Fecha de realización:" + LocalDate.now(), fontParagraph);

        document.add(logo);
        document.add(paragraph);
        document.add(paragraph2);

        document.add(subtitulo);
        document.add(paragraph3);
        document.add(table);
        document.close();
    }

    public void addTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.orange);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("Producto", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cantidad", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Precio", font));
        table.addCell(cell);

    }


    public void addTableTransactionsContent(PdfPTable table, Usuario usuario, List<Productos> productos){
        PdfPCell newCell = new PdfPCell();
        newCell.setBackgroundColor(Color.WHITE);
        newCell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

       // DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");



        AtomicInteger numero = new AtomicInteger();
        numero.set(1);

        // Agrego al PDF las transacciones filtradas por las fechas desde y Hasta
        productos.forEach(producto -> {
         //   changeColor(numero,newCell,font);
            newCell.setPhrase(new Phrase(producto.getTitulo(), font));
            table.addCell(newCell);


            newCell.setPhrase(new Phrase("---",font));
            table.addCell(newCell);



            newCell.setPhrase(new Phrase("$"+producto.getPrecio(),font));
            table.addCell(newCell);
            numero.getAndIncrement();
        });
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static void changeColor(AtomicInteger numero, PdfPCell newCell,Font font){
        if (esPar(numero.get())){
            newCell.setBackgroundColor(Color.LIGHT_GRAY);
            font.setColor(Color.DARK_GRAY);
        }else
        {
            newCell.setBackgroundColor(Color.WHITE);
            font.setColor(Color.BLACK);
        }
    }
}
