package com.carpeCosmos.unitMeasure.constants;

import com.carpeCosmos.unitMeasure.domain.SimpleUnitMeasurement;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.NoSuchElementException;

import static com.carpeCosmos.unitMeasure.constants.FundamentalMeasurementType.*;
import static com.carpeCosmos.unitMeasure.constants.UnitMeasureBaseType.*;
import static com.carpeCosmos.unitMeasure.constants.UnitPrefix.KILO;
import static com.carpeCosmos.unitMeasure.constants.UnitPrefix.UNO;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;


public class UnitMeasureBaseTypeTest {


    @Test
    public void isBaseUnitDimensionTest() {
        assertTrue(METER.isBaseUnitDimension());
        assertTrue(GRAM.isBaseUnitDimension());
        assertTrue(SECOND.isBaseUnitDimension());
        assertTrue(AMPERE.isBaseUnitDimension());
        assertTrue(KELVIN.isBaseUnitDimension());
        assertTrue(MOLE.isBaseUnitDimension());
        assertTrue(CANDELA.isBaseUnitDimension());
        assertTrue(EACH.isBaseUnitDimension());
    }

    @Test
    public void findBySymbolTestNormalSet() {
        assertEquals(METER, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "m"));
        assertEquals(GRAM, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "g"));
        assertEquals(SECOND, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "s"));
        assertEquals(AMPERE, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "A"));
        assertEquals(KELVIN, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "K"));
        assertEquals(MOLE, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "mole"));
        assertEquals(CANDELA, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "cd"));
        assertEquals(EACH, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "ea"));
    }

    @Test
    public void findBySymbolTestFailure() {
        Throwable thrown = assertThrows(NoSuchElementException.class, () ->
                UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "z"));
        assertEquals("No UnitMeasureBaseType Enum with symbol of z.", thrown.getMessage());
    }

    @Test
    public void findByFundamentalMeasurementTypeTestNormalSet() {
        assertEquals(METER, UnitMeasureBaseType.findByFundamentalMeasurementType(LENGTH));
        assertEquals(GRAM, UnitMeasureBaseType.findByFundamentalMeasurementType(MASS));
        assertEquals(SECOND, UnitMeasureBaseType.findByFundamentalMeasurementType(TIME));
        assertEquals(AMPERE, UnitMeasureBaseType.findByFundamentalMeasurementType(ELECTRICAL_CURRENT));
        assertEquals(KELVIN, UnitMeasureBaseType.findByFundamentalMeasurementType(TEMPERATURE));
        assertEquals(MOLE, UnitMeasureBaseType.findByFundamentalMeasurementType(AMOUNT_OF_SUBSTANCE));
        assertEquals(CANDELA, UnitMeasureBaseType.findByFundamentalMeasurementType(LUMINOUS_INTENSITY));
        assertEquals(EACH, UnitMeasureBaseType.findByFundamentalMeasurementType(UNIT_LESS_NUMBER));
    }

    @Test
    public void findByFundamentalMeasurementTypeTestFailure() {
        Throwable thrown = assertThrows(NoSuchElementException.class, () ->
                UnitMeasureBaseType.findByFundamentalMeasurementType(null));
        assertEquals("No UnitMeasureBaseType Enum with fundamentalMeasurementType of null.", thrown.getMessage());
    }

    @Test
    public void getNumeratorDimensionList() {
        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(METER).build()).toArray(),
                METER.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(GRAM).build()).toArray(),
                GRAM.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(SECOND).build()).toArray(),
                SECOND.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(AMPERE).build()).toArray(),
                AMPERE.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(KELVIN).build()).toArray(),
                KELVIN.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(MOLE).build()).toArray(),
                MOLE.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(CANDELA).build()).toArray(),
                CANDELA.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(EACH).build()).toArray(),
                EACH.getNumeratorSimpleUnitMeasurementList().toArray());

    }

    @Test
    public void getDenominatorDimensionList() {
        assertArrayEquals(
                Collections.emptyList().toArray(),
                METER.getDenominatorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                Collections.emptyList().toArray(),
                EACH.getDenominatorSimpleUnitMeasurementList().toArray());
    }

    @Test
    public void getDefaultUnitPrefix() {
        assertEquals(KILO, GRAM.getDefaultUnitPrefix());
        assertEquals(UNO, METER.getDefaultUnitPrefix());
        assertEquals(UNO, SECOND.getDefaultUnitPrefix());
        assertEquals(UNO, AMPERE.getDefaultUnitPrefix());
        assertEquals(UNO, KELVIN.getDefaultUnitPrefix());
        assertEquals(UNO, MOLE.getDefaultUnitPrefix());
        assertEquals(UNO, CANDELA.getDefaultUnitPrefix());
        assertEquals(UNO, EACH.getDefaultUnitPrefix());
    }

    @Test
    public void getFundamentalMeasurementType() {
        assertEquals(MASS, GRAM.getFundamentalMeasurementType());
        assertEquals(LENGTH, METER.getFundamentalMeasurementType());
        assertEquals(TIME, SECOND.getFundamentalMeasurementType());
        assertEquals(ELECTRICAL_CURRENT, AMPERE.getFundamentalMeasurementType());
        assertEquals(TEMPERATURE, KELVIN.getFundamentalMeasurementType());
        assertEquals(AMOUNT_OF_SUBSTANCE, MOLE.getFundamentalMeasurementType());
        assertEquals(LUMINOUS_INTENSITY, CANDELA.getFundamentalMeasurementType());
        assertEquals(UNIT_LESS_NUMBER, EACH.getFundamentalMeasurementType());
    }
}