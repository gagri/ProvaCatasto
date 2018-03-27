package base;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ProprietarioTest  {

    public ArrayList<Abitazione> abitazioni;
    Appartamento appartamento;
    Proprietario p;
    Date myDate, date;
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
        appartamento=new Appartamento("aab" , "Villa gioia" , "Via Roma" , "2A" , "Benevento" , "2" , 4 , 1000 , 100000);
        p.addAbitazione(appartamento);
   }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addAbitazione() throws Exception {

     assertEquals("FAILED addAbitazione" , appartamento , p.getAbitazioni().get(0));
     p.getAbitazioni().get(0).print();
        appartamento.print();

    }

    @Test
    public void getAbitazioni() throws Exception {
        assertEquals("FAILED getAbitazione", appartamento , p.getAbitazioni().get(0));

    }

    @Test
    public void printAbitazioni() throws Exception {
    }

    @Test
    public void printAbitazioni1() throws Exception {
    }

    @Test
    public void print() throws Exception {
        File f=new File("src/test/resources/Proprietario/outPrint");
        PrintStream ps=new PrintStream(f);
        p.print(ps);
        File f2=new File("src/test/resources/Proprietario/oracoloPrintProprietario");

        boolean isTwoEqual = FileUtils.contentEquals(f,f2);
        assertTrue("FAILED print", isTwoEqual);


    }

    @Test
    public void getCodFis() throws Exception {
        assertEquals("FAILED getCofFis" ,16 , p.getCodFis().length());
    }

    @Test
    public void getCognome() throws Exception {
        assertEquals("FAILED getCognome" , "Grimaldi" , p.getCognome());
    }

    @Test
    public void getNome() throws Exception {
        assertEquals("FAILED getNome" , "Gaia" , p.getNome());
    }

    @Test
    public void getLuogoNascita() throws Exception {
        assertEquals("FAILED getLuogoNascita" , "Benevento" , p.getLuogoNascita());
    }

    @Test
    public void getDataNascita() throws Exception {
        String myDateStr="25/08/1992";
        try {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
            date = dateFormat.parse(myDateStr);
            //System.out.println(dateFormat.format(myDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("FAILED getDataNascita" , date , p.getDataNascita());
    }
    @Test
    public void print1() throws Exception {
    }

    @Test
    public void read() throws Exception {
        Scanner sc=new Scanner(new File("src/test/resources/Proprietario/oracoloRead"));
        Proprietario p=Proprietario.read(sc);
        assertEquals("FAILED getCodFis in read" , "BBNASQ84G15" , p.getCodFis());
        assertEquals(" FAILED getCognome in read","Abbenante" , p.getCognome());
        assertEquals(" FAILED getNome in read" , "Pasquale" , p.getNome());
        String myDateStr="10/07/1984";
        try {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
            date = dateFormat.parse(myDateStr);
            //System.out.println(dateFormat.format(myDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(" FAILED getDataNascita in read" , date , p.getDataNascita());
        assertEquals(" FAILED getLuogoNascita in read" , "Benevento" , p.getLuogoNascita());
    }

    @Test
    public void read2() throws Exception {
        Scanner sc=new Scanner(new File("src/test/resources/Proprietario/oracoloRead2"));
        Proprietario p=Proprietario.read(sc);
        assertNull("FAILED read2" , p);
    }
}
