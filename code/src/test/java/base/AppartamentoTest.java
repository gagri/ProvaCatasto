package base;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AppartamentoTest {
     static Appartamento app1, app2;
     static PrintStream ps;
     static Scanner sc;
     static File destfile, srcFile;
     static Proprietario prop, prop1;
     static Date dataN;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        app1 = new Appartamento("app1","Quadrifoglio","Via dei Mille", "4", "BN","3",4,100,1200);
        destfile = new File("src/test/resources/Appartamenti/outAppartamenti.txt");
        srcFile = new File("src/test/resources/Appartamenti/oracleAppartamenti.txt");
        dataN = new Date("25/6/1956");
        prop1 = new Proprietario("ll","l","l",dataN,"Na");
    }


    @Test
    public void getNomePalazzo() {
        assertEquals("Failed getNomePalazzo","lo",app1.getNomePalazzo());
    }

    @Test
    public void getPiano() {
        assertEquals("Failed getPiano","3",app1.getStanze());
    }

    @Test
    public void getStanze() {
        assertEquals("Failed getStanze",4, app1.getStanze());
    }

    @Test
    public void getmQuadri() {
        assertFalse("Failed getmQuadrati",app1.getmQuadri() <= 0);
    }

    @Test
    public void getIdentificativo() {
        assertEquals("Failed getIdentificativo","app1", app1.getIdentificativo());
    }

    @Test
    public void getVia() {
        assertEquals("Failed getVia","Via dei Mille", app1.getVia());
    }

    @Test
    public void getnCiv() {
        assertEquals("Failed getnCiv","6", app1.getnCiv());
    }

    @Test
    public void getComune() {
        assertEquals("Failed getComune","BN", app1.getVia());
    }

    @Test
    public void getPrezzo() {
        assertFalse("Failed getPrezzo failed",app1.getPrezzo() <= 0);
    }

    @Test
    public void print() throws IOException {
        Boolean resConf;
        ps = new PrintStream(destfile);
        app1.print(ps);
        resConf = FileUtils.contentEquals(srcFile, destfile);
        assertTrue("Failed print", resConf);
    }

    @Test
    public void read() throws FileNotFoundException {
        Scanner scf = new Scanner(new File("src/test/resources/Appartamenti/oracleAppartamenti.txt"));
        app2 = Appartamento.read(scf);
        app1 = new Appartamento("app1","Quadrifoglio","Via dei Mille", "4", "BN","3",4,100,1200);

        assertEquals("Failed getIdentificativo in read","app1",app2.getIdentificativo());
        assertEquals("Failed getNomePalazzo in read","app1",app2.getNomePalazzo());
        assertEquals("Failed getVia in read","app1",app2.getVia());
        assertEquals("Failed getnCiv in read","app1",app2.getnCiv());
        assertEquals("Failed getComune in read","app1",app2.getComune());
        assertEquals("Failed getPiano in read","app1",app2.getPiano());
        assertEquals("Failed getmQuadri in read","app1",app2.getmQuadri());
        assertEquals("Failed getPrezzo in read","app1",app2.getPrezzo());
    }

    @Test
    public void addProprietario() {
        prop = new Proprietario("ll","l","l",dataN,"NA");
        assertEquals("Failed getCodFis in addProprietario","ll",prop.getCodFis());
        assertEquals("Failed getCognome in addProprietario","l",prop.getCognome());
        assertEquals("Failed getNome in addProprietario","l",prop.getNome());
        assertEquals("Failed getDataNascita in addProprietario",dataN,prop.getDataNascita());
        assertEquals("Failed getLuogoNascita in addProprietario","NA",prop.getLuogoNascita());
    }

    @Test
    public void getProprietari() {

    }

    @Test
    public void printProprietari() {
    }

    @Test
    public void printProprietari1() {
    }

}