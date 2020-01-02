package com.carpeCosmos.unitMeasure.constants;

import org.junit.Test;

import java.util.NoSuchElementException;

import static com.carpeCosmos.unitMeasure.constants.UnitPrefix.*;
import static org.junit.Assert.*;

public class UnitPrefixTest
{

    @Test
    public void findByFactorTestNormalSet()
    {
        UnitPrefix actualUnitPrefix;

        actualUnitPrefix = UnitPrefix.findByFactor(1D);
        assertEquals(UNO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(10D);
        assertEquals(DECA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(.1D);
        assertEquals(DECI, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(1000D);
        assertEquals(KILO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(.001D);
        assertEquals(MILLI, actualUnitPrefix);


        actualUnitPrefix = UnitPrefix.findByFactor(1.0E+24D);
        assertEquals(YOTTA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(1.0E-24D);
        assertEquals(YOCTO, actualUnitPrefix);

    }

    @Test(expected = NoSuchElementException.class)
    public void findByFactorTestFailure()
    {
        UnitPrefix.findByFactor(1110D);
    }


    @Test
    public void findByPowerOf10TestNormalSet()
    {
        UnitPrefix actualUnitPrefix;

        actualUnitPrefix = UnitPrefix.findByPowerOf10(0);
        assertEquals(UNO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(1);
        assertEquals(DECA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(-1);
        assertEquals(DECI, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(3);
        assertEquals(KILO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(-3);
        assertEquals(MILLI, actualUnitPrefix);


        actualUnitPrefix = UnitPrefix.findByPowerOf10(24);
        assertEquals(YOTTA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(-24);
        assertEquals(YOCTO, actualUnitPrefix);

    }


    @Test(expected = NoSuchElementException.class)
    public void findByPowerOf10TestFailure()
    {
        UnitPrefix.findByPowerOf10(4);
    }

    @Test
    public void addPowerOf10TestNormalSet()
    {
        assertEquals(UNO, UNO.addPowerOf10(0));
        assertEquals(DECA, UNO.addPowerOf10(1));
        assertEquals(HECTO, UNO.addPowerOf10(2));
        assertEquals(KILO, UNO.addPowerOf10(3));

        assertEquals(MEGA, KILO.addPowerOf10(3));
        assertEquals(GIGA, KILO.addPowerOf10(6));
        assertEquals(UNO, KILO.addPowerOf10(-3));

        assertEquals(UNO, UNO.addPowerOf10(-0));
        assertEquals(DECI, UNO.addPowerOf10(-1));
        assertEquals(CENTI, UNO.addPowerOf10(-2));
        assertEquals(MILLI, UNO.addPowerOf10(-3));

        assertEquals(MICRO, MILLI.addPowerOf10(-3));
    }

    @Test(expected = NoSuchElementException.class)
    public void addPowerOf10TestNoPower4() { UNO.addPowerOf10(4); }


    @Test(expected = NoSuchElementException.class)
    public void addPowerOf10TestNoPower8() { MEGA.addPowerOf10(2); }

    @Test
    public void sumUnitPrefixesTestNormalSet()
    {
        assertEquals(MEGA, KILO.sumUnitPrefixes(KILO));
        assertEquals(TERA, GIGA.sumUnitPrefixes(KILO));
        assertEquals(KILO, GIGA.sumUnitPrefixes(MICRO));
    }

    @Test(expected = NoSuchElementException.class)
    public void sumUnitPrefixesTestOutOfRange()
    {
        PETA.sumUnitPrefixes(PETA);
    }


    @Test(expected = NoSuchElementException.class)
    public void sumUnitPrefixesTestNotMultipleOf1000()
    {
        DECA.sumUnitPrefixes(KILO);
    }



    @Test
    public void subtractUnitPrefixesTestNormalSet()
    {
        assertEquals(KILO, MEGA.subtractUnitPrefixes(KILO));
        assertEquals(MEGA, GIGA.subtractUnitPrefixes(KILO));
        assertEquals(PETA, GIGA.subtractUnitPrefixes(MICRO));
    }

    @Test(expected = NoSuchElementException.class)
    public void subtractUnitPrefixesTestOutOfRange()
    {
        FEMTO.subtractUnitPrefixes(PETA);
    }


    @Test(expected = NoSuchElementException.class)
    public void subtractUnitPrefixesTestNotMultipleOf1000()
    {
        DECI.subtractUnitPrefixes(KILO);
    }

    @Test
    public void differenceInPowerOf10() {
        assertEquals(-24, UNO.differenceInPowerOf10(YOTTA));
        assertEquals(-21, UNO.differenceInPowerOf10(ZETTA));
        assertEquals(-18, UNO.differenceInPowerOf10(EXA));
        assertEquals(-15, UNO.differenceInPowerOf10(PETA));
        assertEquals(-12, UNO.differenceInPowerOf10(TERA));
        assertEquals(-9, UNO.differenceInPowerOf10(GIGA));
        assertEquals(-6, UNO.differenceInPowerOf10(MEGA));
        assertEquals(-3, UNO.differenceInPowerOf10(KILO));
        assertEquals(-2, UNO.differenceInPowerOf10(HECTO));
        assertEquals(-1, UNO.differenceInPowerOf10(DECA));
        assertEquals(0, UNO.differenceInPowerOf10(UNO));
        assertEquals(1, UNO.differenceInPowerOf10(DECI));
        assertEquals(2, UNO.differenceInPowerOf10(CENTI));
        assertEquals(3, UNO.differenceInPowerOf10(MILLI));
        assertEquals(6, UNO.differenceInPowerOf10(MICRO));
        assertEquals(9, UNO.differenceInPowerOf10(NANO));
        assertEquals(12, UNO.differenceInPowerOf10(PICO));
        assertEquals(15, UNO.differenceInPowerOf10(FEMTO));
        assertEquals(18, UNO.differenceInPowerOf10(ATTO));
        assertEquals(21, UNO.differenceInPowerOf10(ZEPTO));
        assertEquals(24, UNO.differenceInPowerOf10(YOCTO));
    }

    @Test
    public void getFactor() {
        assertEquals(1000., KILO.getFactor(), 0.0000001);
    }

    @Test
    public void getPowerOf10() {
        assertEquals(3, KILO.getPowerOf10());
    }

    @Test
    public void getInWords() {
        assertEquals("thousand", KILO.getInWords());
    }

    @Test
    public void getPrefixText() {
        assertEquals("kilo-", KILO.getPrefixText());
    }

    @Test
    public void getSymbol() {
        assertEquals("k", KILO.getSymbol());
    }

}