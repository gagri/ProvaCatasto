package base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ProprietarioAbitazioneTest {
    ProprietarioAbitazione proprietarioAbitazione , prop;
    Proprietario p;
    Appartamento abitazione;
    Date myDate;
    @Before
    public void setUp() throws Exception {
        String myDateStr="25/08/1992";
        try {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
            myDate = dateFormat.parse(myDateStr);
            //System.out.println(dateFormat.format(myDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p=new Proprietario("GRMGAI92M65A783B" , "Grimaldi" , "Gaia", myDate, "Benevento");
        abitazione=new Appartamento ("23app" , "parco delle rose" , "via roma" , "4" , "Benevento" , "3" , 5 , 4 , 20000);

        //("23app" , "parco delle rose" ,  "via roma" , 4 ,  "Benevento" , 20000);
       prop=new ProprietarioAbitazione("GRMGAI92M65A783B" , "23app");
       proprietarioAbitazione=new ProprietarioAbitazione("GRMGAI92M65A783B" , "23app");
       proprietarioAbitazione.setProprietario(p);
       proprietarioAbitazione.setAbitazione(abitazione);


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getProprietario() throws Exception {
        assertEquals("FAILED getProprietario" , p.getCodFis() , proprietarioAbitazione.getProprietario().getCodFis());
    }

    @Test
    public void setProprietario() throws Exception {
       prop.setProprietario(p);
        //proprietarioAbitazione.getProprietario().getCodFis();
        assertEquals("FAILED setProprietario" , p.getCodFis() , prop.getProprietario().getCodFis());

    }

    @Test
    public void getAbitazione() throws Exception {
       assertEquals("FAILED getAbitazione" , "23app" , proprietarioAbitazione.getAbitazione().getIdentificativo());
    }

    @Test
    public void setAbitazione() throws Exception {
        prop.setAbitazione(abitazione);
        //proprietarioAbitazione.getProprietario().getCodFis();
        assertEquals("FAILED setAbitazione" , abitazione.getIdentificativo() , prop.getAbitazione().getIdentificativo());
    }

    @Test
    public void getCodFis() throws Exception {
        assertEquals("FAILED getCodFis" , "GRMGAI92M65A783B" , prop.getCodFis());

    }

    @Test
    public void getIdentificativo() throws Exception {
        assertEquals("FAILED getIdentificativo" , "23app" , proprietarioAbitazione.getAbitazione().getIdentificativo());
    }

    @Test
    public void read() throws Exception {
        Scanner sc=new Scanner(new File("code/src/test/resources/ProprietarioAbitazione/oracoloRead"));
        ProprietarioAbitazione proprietarioAbitazione=ProprietarioAbitazione.read(sc);
        assertEquals("GRMGAI92M65A783B" , proprietarioAbitazione.getCodFis());
        assertEquals("23app" , proprietarioAbitazione.getIdentificativo());
    }

    @Test
    public void read2() throws Exception {
        Scanner sc=new Scanner(new File("code/src/test/resources/ProprietarioAbitazione/oracoloRead2"));
        ProprietarioAbitazione proprietarioAbitazione=ProprietarioAbitazione.read(sc);


        assertNull(proprietarioAbitazione);
    }
}