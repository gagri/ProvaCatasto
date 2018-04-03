package base;


import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

import static org.junit.Assert.*;



public class GestoreTest {
    private static Gestore gestore;
    private static File soluzioni = new File("code/src/main/resources/soluzioni.txt");
    private static File proprietari = new File("code/src/main/resources/proprietari.txt");
    private static File proprieta = new File("code/src/main/resources/proprieta.txt");
    private static String path = "code/src/test/resources/Gestore/";
    private static Appartamento appartamento;
    private static Indipendente indipendente;
    private static Proprietario proprietario;
    final String newLine = System.getProperty("line.separator");

    @BeforeClass
    public static void seUpBeforeClass()throws Exception{
        Scanner scAb = new Scanner(soluzioni);
        Scanner scProp = new Scanner(proprietari);
        Scanner scPropAb = new Scanner(proprieta);
        gestore = new Gestore(scAb, scProp, scPropAb);
        proprietario = Proprietario.read(new Scanner(new File(path+"oracleProprietario")));
        appartamento = Appartamento.read(new Scanner(new File(path+"oracleAppartamento")));
        indipendente = Indipendente.read(new Scanner(new File(path+"oracleIndipendente")));
    }

    @Test
    public void printAbitazioni() throws Exception {
        File out = new File(path+"outPrintAbitazioni");
        gestore.printAbitazioni(new PrintStream(out));
        assertTrue("Failed printAbitazioni", FileUtils.contentEquals(out, soluzioni));
    }

    @Test
    public void printAbitazioni1() throws Exception {
        //TODO print su System.out
    }

    @Test
    public void printProprietari() throws Exception {
        File out = new File(path+"outPrintProprietari");
        gestore.printProprietari(new PrintStream(out));
        assertTrue("Failed printProprietari", FileUtils.contentEquals(out, proprietari));
    }

    @Test
    public void printProprietari1() throws Exception {
        //TODO print su System.out
    }

    @Test
    public void print() throws Exception {

        File oracle = new File(path+"oraclePrint");
        FileUtils.copyFile(soluzioni, oracle);
        FileUtils.write(oracle,"***********"+newLine, Charset.defaultCharset(),true);
        FileUtils.write(oracle, FileUtils.readFileToString(proprietari, Charset.defaultCharset()), Charset.defaultCharset(), true);

        File out = new File(path+"outPrint");
        gestore.print(new PrintStream(out));
        assertTrue("Failed print", FileUtils.contentEquals(oracle, out) );
    }

    @Test
    public void print1() throws Exception {
        //TODO print su System.out
    }

    @Test
    public void cercaPerCodFis() throws Exception {

        Proprietario p = gestore.cercaPerCodFis(proprietario.getCodFis());
        assertEquals("Failed cercaPerCodFis field [codFis]", p.getCodFis(), proprietario.getCodFis());
        assertEquals("Failed cercaPerCodFis field [cognome]",p.getCognome(), proprietario.getCognome());
        assertEquals("Failed cercaPerCodFis field [nome]",p.getNome(), proprietario.getNome());
        assertEquals("Failed cercaPerCodFis field [dataNascita]", p.getDataNascita(), proprietario.getDataNascita());
        assertEquals("Failed cercaPerCodFis field [luogoNascita]", p.getLuogoNascita(), proprietario.getLuogoNascita());

    }
    @Test
    public void cercaPerCodFis1() throws Exception {

        assertNull("Failed cercaPerCodFis expected null",gestore.cercaPerCodFis(""));
    }

    @Test
    public void cercaPerIdentificativo() throws Exception {
        Abitazione oracle = appartamento;
        Abitazione a =  gestore.cercaPerIdentificativo(appartamento.getIdentificativo());
        assertEquals("Failed cercaPerIdentificativo field [identificativo]", a.getIdentificativo(), oracle.getIdentificativo());
        assertEquals("Failed cercaPerIdentificativo field [via]",a.getVia(), oracle.getVia());
        assertEquals("Failed cercaPerIdentificativo field [nCiv]",a.getnCiv(),oracle.getnCiv());
        assertEquals("Failed cercaPerIdentificativo field [comune]",a.getComune(),oracle.getComune());
        assertEquals("Failed cercaPerIdentificativo field [prezzo]",a.getPrezzo(),oracle.getPrezzo(),0.0001);
    }
    @Test
    public void cercaPerIdentificativo1() throws Exception {
        Abitazione a =  gestore.cercaPerIdentificativo("2");
        assertNull(a);
    }

    @Test
    public void filtroPerComune() throws Exception {
        File oracle = new File (path+"oracleFiltroPerComune");
        Abitazione a = appartamento;
        PrintStream ps = new PrintStream(new PrintStream(oracle));
        ps.println("appartamento");
        a.print(ps);
        File out = new File(path+"outFiltroPerComune");
        gestore.filtroPerComune(a.getComune()).printAbitazioni(new PrintStream(out));

        assertTrue("Failed filtroPerComune",FileUtils.contentEquals(oracle,out));
    }

    @Test
    public void filtroPerVia() throws Exception {
        File oracle = new File (path+"oracleFiltroPerVia");
        Abitazione a = appartamento;
        PrintStream ps = new PrintStream(new PrintStream(oracle));
        ps.println("appartamento");
        a.print(ps);

        File out = new File(path+"outFiltroPerVia");
        gestore.filtroPerVia(a.getVia()).printAbitazioni(new PrintStream(out));

        assertTrue("Failed filtroPerVia",FileUtils.contentEquals(oracle,out));
    }

    @Test
    public void filtroPerLuogoNascita() throws Exception {
        File oracle = new File (path+"oracleFiltroPerLuogoNascita");

        proprietario.print(new PrintStream(oracle));

        File out = new File(path+"outFiltroPerLuogoNascita");
        gestore.filtroPerLuogoNascita("Benevento").printProprietari(new PrintStream(out));

        assertTrue("Failed filtroPerLuogoNascita",FileUtils.contentEquals(oracle,out));
    }

    @Test
    public void filtroAppartamenti() throws Exception {
        Abitazione a = (Abitazione) appartamento;
        File oracle = new File (path+"oracleFiltroAppartamenti");
        PrintStream ps = new PrintStream(new PrintStream(oracle));
        ps.println("appartamento");
        a.print(new PrintStream(ps));

        File out = new File(path+"outFiltroAppartamenti");
        gestore.filtroAppartamenti().printAbitazioni(new PrintStream(out));
        assertTrue("Failed filtroAppartamenti",FileUtils.contentEquals(oracle,out));
    }

    @Test
    public void filtroIndipendenti() throws Exception {
        Abitazione a =(Abitazione) indipendente;
        File oracle = new File (path+"oracleFiltroIndipendenti");
        PrintStream ps = new PrintStream(new PrintStream(oracle));
        ps.println("indipendente");
        a.print(ps);

        File out = new File(path+"outFiltroIndipendenti");
        gestore.filtroIndipendenti().printAbitazioni(new PrintStream(out));
        assertTrue("Failed filtroIndipendenti",FileUtils.contentEquals(oracle,out));
    }


}