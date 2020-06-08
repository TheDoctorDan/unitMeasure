package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.domain.SimpleUnitMeasurement;
import com.carpe_cosmos.unit_measure.exceptions.UnitMeasureException;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.AMOUNT_OF_SUBSTANCE;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.ELECTRICAL_CURRENT;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.LENGTH;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.LUMINOUS_INTENSITY;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.MASS;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.TEMPERATURE;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.TIME;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.UNIT_LESS_NUMBER;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.AMPERE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.CANDELA;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.EACH;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.GRAM;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.KELVIN;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.METER;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.MOLE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.SECOND;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.findByFundamentalMeasurementType;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureType.findBySymbol;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
    public void findBySymbolTestNormalSet() throws Exception {
        assertEquals(METER, findBySymbol(UnitMeasureBaseType.class, "m"));
        assertEquals(GRAM, findBySymbol(UnitMeasureBaseType.class, "g"));
        assertEquals(SECOND, findBySymbol(UnitMeasureBaseType.class, "s"));
        assertEquals(AMPERE, findBySymbol(UnitMeasureBaseType.class, "A"));
        assertEquals(KELVIN, findBySymbol(UnitMeasureBaseType.class, "K"));
        assertEquals(MOLE, findBySymbol(UnitMeasureBaseType.class, "mole"));
        assertEquals(CANDELA, findBySymbol(UnitMeasureBaseType.class, "cd"));
        assertEquals(EACH, findBySymbol(UnitMeasureBaseType.class, "ea"));
    }

    @Test
    public void findBySymbolTestFailure() {
        Throwable thrown = assertThrows(UnitMeasureException.class, () ->
                findBySymbol(UnitMeasureBaseType.class, "z"));
        assertEquals("No UnitMeasureBaseType Enum with symbol of z.", thrown.getMessage());
    }

    @Test
    public void findByFundamentalMeasurementTypeTestNormalSet() throws Exception {
        assertEquals(METER, findByFundamentalMeasurementType(LENGTH));
        assertEquals(GRAM, findByFundamentalMeasurementType(MASS));
        assertEquals(SECOND, findByFundamentalMeasurementType(TIME));
        assertEquals(AMPERE, findByFundamentalMeasurementType(ELECTRICAL_CURRENT));
        assertEquals(KELVIN, findByFundamentalMeasurementType(TEMPERATURE));
        assertEquals(MOLE, findByFundamentalMeasurementType(AMOUNT_OF_SUBSTANCE));
        assertEquals(CANDELA, findByFundamentalMeasurementType(LUMINOUS_INTENSITY));
        assertEquals(EACH, findByFundamentalMeasurementType(UNIT_LESS_NUMBER));
    }

    @Test
    public void findByFundamentalMeasurementTypeTestFailure() {
        Throwable thrown = assertThrows(UnitMeasureException.class, () ->
                findByFundamentalMeasurementType(null));
        assertEquals("No UnitMeasureBaseType Enum with fundamentalMeasurementType of null.", thrown.getMessage());
    }

    @Test
    public void getNumeratorDimensionList() {
        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(METER).build()).toArray(),
                METER.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(GRAM).build()).toArray(),
                GRAM.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(SECOND).build()).toArray(),
                SECOND.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(AMPERE).build()).toArray(),
                AMPERE.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(KELVIN).build()).toArray(),
                KELVIN.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(MOLE).build()).toArray(),
                MOLE.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(CANDELA).build()).toArray(),
                CANDELA.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(EACH).build()).toArray(),
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
        assertEquals(UnitPrefix.KILO, GRAM.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, METER.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, SECOND.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, AMPERE.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, KELVIN.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, MOLE.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, CANDELA.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, EACH.getDefaultUnitPrefix());
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
