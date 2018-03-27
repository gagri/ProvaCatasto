package base;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndipendenteTest {
    static Indipendente indip1;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        indip1 = new Indipendente("ind","Via dei Piccardi","12","Trieste",3,true,1300);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getnPiani() {
        assertFalse("Failed getPiani",indip1.getPrezzo() <= 0);
    }

    @Test
    public void isGiardino() {
        assertSame("Failed isGiardino",true, indip1.isGiardino());
    }

    @Test
    public void print() {
    }

    @Test
    public void print1() {
    }

    @Test
    public void read() {
    }
}