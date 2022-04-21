package com.cds.mx.apicds.pdfGenerator.controller;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.person.model.PersonRepository;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.skills.model.Skills;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.List;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

@Service
public class PDFGeneratorService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public void exportCv(long idPerson,HttpServletResponse response) throws IOException {

        Person person = personRepository.findPersonById(idPerson);
        if (person!=null){
            //creo un nuevo documento tamaño a4
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document,response.getOutputStream());
            //abro el documento
            document.open();
            //FUENTES------------------------------------------------------------
            Font fontName = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fontName.setSize(20);
            fontName.setColor(new Color(67,56,224,88));
            Font fontSubtitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fontSubtitle.setSize(15);
            fontSubtitle.setColor(new Color(67,56,224,88));
            Font fontPuesto = FontFactory.getFont(FontFactory.HELVETICA);
            fontPuesto.setSize(16);
            Font fontContacto = FontFactory.getFont(FontFactory.HELVETICA);
            fontContacto.setSize(12);
            Font fontDescrip = FontFactory.getFont(FontFactory.HELVETICA);
            fontDescrip.setSize(12);

            //FUENTES--------------------------------------------------------------------

            //CONTENIDO DEL DOCUMENTO-----------------------------------------------------------------------------------------
            Paragraph nombrePersona = new Paragraph("" +person.getName() + " " + person.getLastname() + " " + person.getMotherslastname(),fontName);
            nombrePersona.setAlignment(Paragraph.ALIGN_LEFT);
            nombrePersona.setSpacingAfter(5f);
            //aqui van los datos de contacto de la persona
            Paragraph puestoPersona = new Paragraph("Dessarrollador Junior",fontPuesto);
            puestoPersona.setAlignment(Paragraph.ALIGN_LEFT);
            puestoPersona.setSpacingAfter(20f);
           //aqui van los datos de contacto de la persona
            Paragraph contacto = new Paragraph("Contacto",fontSubtitle);
            contacto.setSpacingAfter(10f);
            Paragraph vision = new Paragraph("Vision",fontSubtitle);
            vision.setSpacingAfter(10f);
            vision.setSpacingBefore(5f);
            Paragraph habilidades = new Paragraph("Habilidades",fontSubtitle);
            habilidades.setSpacingAfter(10f);
            habilidades.setSpacingBefore(10f);
            Paragraph experiencia = new Paragraph("Experiencia",fontSubtitle);
            experiencia.setSpacingAfter(10f);
            experiencia.setSpacingBefore(10f);
            Paragraph educacion = new Paragraph("Educacion",fontSubtitle);
            educacion.setSpacingAfter(10f);
            educacion.setSpacingBefore(10f);
            Paragraph telefonoPersona = new Paragraph("Telefono : " + person.getCellphone(),fontContacto );
            Paragraph emailPersona = new Paragraph("Email : " + person.getEmail(),fontContacto );
            Paragraph direccionPersona = new Paragraph("Direccion : " +  person.getAddress().getStreet() +
                    " " + person.getAddress().getExtNumber() + " " + person.getAddress().getColonia() + " " + person.getAddress().getTown() +
                    " " + person.getAddress().getEstate()
                    ,fontContacto );
            //aqui va una breve descripcion sobre la persona
            Paragraph visionPersona = new Paragraph("Soy estudiante de la carrera en Dessarrolo de " +
                    "software multiplataforma , apasionado de la tecnologia , buscando siempre la " +
                    "implementacion de buenas practicas en el dessarrolo y diseño de software de alta calidad",fontDescrip);
            Paragraph educaciobPersona = new Paragraph("Universidad : " + person.getScholl(),fontDescrip);
            Paragraph tsu = new Paragraph("TSU - Dessarrollo de Software Multiplataforma",fontDescrip);

            //-LISTAS---------------------------------------------------------------------------------


            List listProjects = new List();
            List listSkiils = new List();

            for (Skills skill : person.getSkills()){
                listSkiils.add(new ListItem(skill.getDescription()));
            }
            for (Projects project : person.getProjects()){
                listProjects.add(new ListItem(project.getName()));
            }

            //-LISTAS---------------------------------------------------------------------------------

            document.add(nombrePersona);
            document.add(puestoPersona);
            document.add(contacto);
            document.add(telefonoPersona);
            document.add(emailPersona);
            document.add(direccionPersona);
            document.add(vision);
            document.add(visionPersona);
            document.add(experiencia);
            document.add(listProjects);
            document.add(habilidades);
            document.add(listSkiils);
            document.add(educacion);
            document.add(educaciobPersona);
            document.add(tsu);
            document.close();
        }
    }
}
