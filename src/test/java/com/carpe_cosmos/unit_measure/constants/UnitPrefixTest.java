package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.exceptions.UnitPrefixException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitPrefixTest {

    @Test
    public void findByFactorTestNormalSet() throws Exception {
        UnitPrefix actualUnitPrefix;

        actualUnitPrefix = UnitPrefix.findByFactor(1D);
        assertEquals(UnitPrefix.UNO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(10D);
        assertEquals(UnitPrefix.DECA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(.1D);
        assertEquals(UnitPrefix.DECI, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(1000D);
        assertEquals(UnitPrefix.KILO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(.001D);
        assertEquals(UnitPrefix.MILLI, actualUnitPrefix);


        actualUnitPrefix = UnitPrefix.findByFactor(1.0E+24D);
        assertEquals(UnitPrefix.YOTTA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByFactor(1.0E-24D);
        assertEquals(UnitPrefix.YOCTO, actualUnitPrefix);

    }

    @Test
    public void findByFactorTestFailure() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.findByFactor(1110D));
        assertEquals("No UnitPrefix Enum with factor of 1110.0.", thrown.getMessage());
    }


    @Test
    public void findByPowerOf10TestNormalSet() throws Exception {
        UnitPrefix actualUnitPrefix;

        actualUnitPrefix = UnitPrefix.findByPowerOf10(0);
        assertEquals(UnitPrefix.UNO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(1);
        assertEquals(UnitPrefix.DECA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(-1);
        assertEquals(UnitPrefix.DECI, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(3);
        assertEquals(UnitPrefix.KILO, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(-3);
        assertEquals(UnitPrefix.MILLI, actualUnitPrefix);


        actualUnitPrefix = UnitPrefix.findByPowerOf10(24);
        assertEquals(UnitPrefix.YOTTA, actualUnitPrefix);

        actualUnitPrefix = UnitPrefix.findByPowerOf10(-24);
        assertEquals(UnitPrefix.YOCTO, actualUnitPrefix);

    }


    @Test
    public void findByPowerOf10TestFailure() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.findByPowerOf10(4));
        assertEquals("No UnitPrefix Enum with power of 10 to the 4.", thrown.getMessage());
    }

    @Test
    public void addPowerOf10TestNormalSet() throws Exception {
        assertEquals(UnitPrefix.UNO, UnitPrefix.UNO.addPowerOf10(0));
        assertEquals(UnitPrefix.DECA, UnitPrefix.UNO.addPowerOf10(1));
        assertEquals(UnitPrefix.HECTO, UnitPrefix.UNO.addPowerOf10(2));
        assertEquals(UnitPrefix.KILO, UnitPrefix.UNO.addPowerOf10(3));

        assertEquals(UnitPrefix.MEGA, UnitPrefix.KILO.addPowerOf10(3));
        assertEquals(UnitPrefix.GIGA, UnitPrefix.KILO.addPowerOf10(6));
        assertEquals(UnitPrefix.UNO, UnitPrefix.KILO.addPowerOf10(-3));

        assertEquals(UnitPrefix.UNO, UnitPrefix.UNO.addPowerOf10(-0));
        assertEquals(UnitPrefix.DECI, UnitPrefix.UNO.addPowerOf10(-1));
        assertEquals(UnitPrefix.CENTI, UnitPrefix.UNO.addPowerOf10(-2));
        assertEquals(UnitPrefix.MILLI, UnitPrefix.UNO.addPowerOf10(-3));

        assertEquals(UnitPrefix.MICRO, UnitPrefix.MILLI.addPowerOf10(-3));
    }

    @Test
    public void addPowerOf10TestNoPower4() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.UNO.addPowerOf10(4));
        assertEquals("No UnitPrefix Enum with power of 10 to the 4.", thrown.getMessage());
    }


    @Test
    public void addPowerOf10TestNoPower8() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.MEGA.addPowerOf10(2));
        assertEquals("No UnitPrefix Enum with power of 10 to the 8.", thrown.getMessage());
    }

    @Test
    public void sumUnitPrefixesTestNormalSet() throws Exception {
        assertEquals(UnitPrefix.MEGA, UnitPrefix.KILO.sumUnitPrefixes(UnitPrefix.KILO));
        assertEquals(UnitPrefix.TERA, UnitPrefix.GIGA.sumUnitPrefixes(UnitPrefix.KILO));
        assertEquals(UnitPrefix.KILO, UnitPrefix.GIGA.sumUnitPrefixes(UnitPrefix.MICRO));
    }

    @Test
    public void sumUnitPrefixesTestOutOfRange() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.PETA.sumUnitPrefixes(UnitPrefix.PETA));
        assertEquals("No UnitPrefix Enum with power of 10 to the 30.", thrown.getMessage());
    }


    @Test
    public void sumUnitPrefixesTestNotMultipleOf1000() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.DECA.sumUnitPrefixes(UnitPrefix.KILO));
        assertEquals("No UnitPrefix Enum with power of 10 to the 4.", thrown.getMessage());
    }


    @Test
    public void subtractUnitPrefixesTestNormalSet() throws Exception {
        assertEquals(UnitPrefix.KILO, UnitPrefix.MEGA.subtractUnitPrefixes(UnitPrefix.KILO));
        assertEquals(UnitPrefix.MEGA, UnitPrefix.GIGA.subtractUnitPrefixes(UnitPrefix.KILO));
        assertEquals(UnitPrefix.PETA, UnitPrefix.GIGA.subtractUnitPrefixes(UnitPrefix.MICRO));
    }

    @Test
    public void subtractUnitPrefixesTestOutOfRange() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.FEMTO.subtractUnitPrefixes(UnitPrefix.PETA));
        assertEquals("No UnitPrefix Enum with power of 10 to the -30.", thrown.getMessage());
    }


    @Test
    public void subtractUnitPrefixesTestNotMultipleOf1000() {
        Throwable thrown = assertThrows(UnitPrefixException.class, () ->
                UnitPrefix.DECI.subtractUnitPrefixes(UnitPrefix.KILO));
        assertEquals("No UnitPrefix Enum with power of 10 to the -4.", thrown.getMessage());
    }

    @Test
    public void differenceInPowerOf10() {
        assertEquals(-24, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.YOTTA));
        assertEquals(-21, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.ZETTA));
        assertEquals(-18, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.EXA));
        assertEquals(-15, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.PETA));
        assertEquals(-12, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.TERA));
        assertEquals(-9, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.GIGA));
        assertEquals(-6, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.MEGA));
        assertEquals(-3, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.KILO));
        assertEquals(-2, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.HECTO));
        assertEquals(-1, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.DECA));
        assertEquals(0, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.UNO));
        assertEquals(1, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.DECI));
        assertEquals(2, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.CENTI));
        assertEquals(3, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.MILLI));
        assertEquals(6, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.MICRO));
        assertEquals(9, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.NANO));
        assertEquals(12, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.PICO));
        assertEquals(15, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.FEMTO));
        assertEquals(18, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.ATTO));
        assertEquals(21, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.ZEPTO));
        assertEquals(24, UnitPrefix.UNO.differenceInPowerOf10(UnitPrefix.YOCTO));
    }

    @Test
    public void getFactor() {
        assertEquals(1000., UnitPrefix.KILO.getFactor(), 0.0000001);
    }

    @Test
    public void getPowerOf10() {
        assertEquals(3, UnitPrefix.KILO.getPowerOf10());
    }

    @Test
    public void getInWords() {
        assertEquals("thousand", UnitPrefix.KILO.getInWords());
    }

    @Test
    public void getPrefixText() {
        assertEquals("kilo-", UnitPrefix.KILO.getPrefixText());
    }

    @Test
    public void getSymbol() {
        assertEquals("k", UnitPrefix.KILO.getSymbol());
    }

}
