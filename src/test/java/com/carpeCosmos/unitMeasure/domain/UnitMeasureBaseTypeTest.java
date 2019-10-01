package com.carpeCosmos.unitMeasure.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static com.carpeCosmos.unitMeasure.domain.FundamentalMeasurementType.*;
import static com.carpeCosmos.unitMeasure.domain.UnitMeasureBaseType.*;
import static com.carpeCosmos.unitMeasure.domain.UnitMeasureDerivedType.NEWTON;
import static com.carpeCosmos.unitMeasure.domain.UnitPrefix.UNO;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class UnitMeasureBaseTypeTest
{

    @Test
    public void isBaseUnitDimensionTest()
    {
        assertTrue(METER.isBaseUnitDimension());
        assertTrue(GRAM.isBaseUnitDimension());
        assertTrue(SECOND.isBaseUnitDimension());
        assertTrue(AMPERE.isBaseUnitDimension());
        assertTrue(KELVIN.isBaseUnitDimension());
        assertTrue(MOLE.isBaseUnitDimension());
        assertTrue(CANDELA.isBaseUnitDimension());
        assertTrue(EACH.isBaseUnitDimension());
        assertFalse(NEWTON.isBaseUnitDimension());
    }

    @Test
    public void findBySymbolTestNormalSet()
    {
        assertEquals(METER, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "m"));
        assertEquals(GRAM, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "g"));
        assertEquals(SECOND, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "s"));
        assertEquals(AMPERE, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "A"));
        assertEquals(KELVIN, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "K"));
        assertEquals(MOLE, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "mole"));
        assertEquals(CANDELA, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "cd"));
        assertEquals(EACH, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "ea"));
    }

    @Test(expected = NoSuchElementException.class)
    public void findBySymbolTestFailure()
    {
        UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "z");
    }

    @Test
    public void findByFundamentalMeasurementTypeTestNormalSet()
    {
        assertEquals(METER, UnitMeasureBaseType.findByFundamentalMeasurementType(LENGTH));
        assertEquals(GRAM, UnitMeasureBaseType.findByFundamentalMeasurementType(MASS));
        assertEquals(SECOND, UnitMeasureBaseType.findByFundamentalMeasurementType(TIME));
        assertEquals(AMPERE, UnitMeasureBaseType.findByFundamentalMeasurementType(ELECTRICAL_CURRENT));
        assertEquals(KELVIN, UnitMeasureBaseType.findByFundamentalMeasurementType(TEMPERATURE));
        assertEquals(MOLE, UnitMeasureBaseType.findByFundamentalMeasurementType(AMOUNT_OF_SUBSTANCE));
        assertEquals(CANDELA, UnitMeasureBaseType.findByFundamentalMeasurementType(LUMINOUS_INTENSITY));
        assertEquals(EACH, UnitMeasureBaseType.findByFundamentalMeasurementType(UNIT_LESS_NUMBER));
    }

    @Test(expected = NoSuchElementException.class)
    public void findByFundamentalMeasurementTypeTestFailure()
    {
        UnitMeasureBaseType.findByFundamentalMeasurementType(null);
    }

    @Test
    public void getNumeratorDimensionList()
    {
        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, METER)).toArray(),
                METER.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, GRAM)).toArray(),
                GRAM.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, SECOND)).toArray(),
                SECOND.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, AMPERE)).toArray(),
                AMPERE.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, KELVIN)).toArray(),
                KELVIN.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, MOLE)).toArray(),
                MOLE.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, CANDELA)).toArray(),
                CANDELA.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(new SimpleUnitMeasurement(UNO, EACH)).toArray(),
                EACH.getNumeratorSimpleUnitMeasurementList().toArray());

    }

    @Test
    public void getDenominatorDimensionList()
    {
        assertArrayEquals(
                Collections.emptyList().toArray(),
                METER.getDenominatorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                Collections.emptyList().toArray(),
                EACH.getDenominatorSimpleUnitMeasurementList().toArray());
    }

}