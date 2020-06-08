package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.domain.SimpleUnitMeasurement;
import com.carpe_cosmos.unit_measure.exceptions.UnitMeasureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UnitMeasureBaseTypeTest {


    @Test
    public void isBaseUnitDimensionTest() {
        Assertions.assertTrue(UnitMeasureBaseType.METER.isBaseUnitDimension());
        Assertions.assertTrue(UnitMeasureBaseType.GRAM.isBaseUnitDimension());
        Assertions.assertTrue(UnitMeasureBaseType.SECOND.isBaseUnitDimension());
        Assertions.assertTrue(UnitMeasureBaseType.AMPERE.isBaseUnitDimension());
        Assertions.assertTrue(UnitMeasureBaseType.KELVIN.isBaseUnitDimension());
        Assertions.assertTrue(UnitMeasureBaseType.MOLE.isBaseUnitDimension());
        Assertions.assertTrue(UnitMeasureBaseType.CANDELA.isBaseUnitDimension());
        Assertions.assertTrue(UnitMeasureBaseType.EACH.isBaseUnitDimension());
    }

    @Test
    public void findBySymbolTestNormalSet() throws Exception {
        Assertions.assertEquals(UnitMeasureBaseType.METER, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "m"));
        Assertions.assertEquals(UnitMeasureBaseType.GRAM, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "g"));
        Assertions.assertEquals(UnitMeasureBaseType.SECOND, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "s"));
        Assertions.assertEquals(UnitMeasureBaseType.AMPERE, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "A"));
        Assertions.assertEquals(UnitMeasureBaseType.KELVIN, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "K"));
        Assertions.assertEquals(UnitMeasureBaseType.MOLE, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "mole"));
        Assertions.assertEquals(UnitMeasureBaseType.CANDELA, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "cd"));
        Assertions.assertEquals(UnitMeasureBaseType.EACH, UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "ea"));
    }

    @Test
    public void findBySymbolTestFailure() {
        Throwable thrown = assertThrows(UnitMeasureException.class, () ->
                UnitMeasureType.findBySymbol(UnitMeasureBaseType.class, "z"));
        assertEquals("No UnitMeasureBaseType Enum with symbol of z.", thrown.getMessage());
    }

    @Test
    public void findByFundamentalMeasurementTypeTestNormalSet() throws Exception {
        Assertions.assertEquals(UnitMeasureBaseType.METER, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.LENGTH));
        Assertions.assertEquals(UnitMeasureBaseType.GRAM, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.MASS));
        Assertions.assertEquals(UnitMeasureBaseType.SECOND, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.TIME));
        Assertions.assertEquals(UnitMeasureBaseType.AMPERE, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.ELECTRICAL_CURRENT));
        Assertions.assertEquals(UnitMeasureBaseType.KELVIN, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.TEMPERATURE));
        Assertions.assertEquals(UnitMeasureBaseType.MOLE, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.AMOUNT_OF_SUBSTANCE));
        Assertions.assertEquals(UnitMeasureBaseType.CANDELA, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.LUMINOUS_INTENSITY));
        Assertions.assertEquals(UnitMeasureBaseType.EACH, UnitMeasureBaseType.findByFundamentalMeasurementType(FundamentalMeasurementType.UNIT_LESS_NUMBER));
    }

    @Test
    public void findByFundamentalMeasurementTypeTestFailure() {
        Throwable thrown = assertThrows(UnitMeasureException.class, () ->
                UnitMeasureBaseType.findByFundamentalMeasurementType(null));
        assertEquals("No UnitMeasureBaseType Enum with fundamentalMeasurementType of null.", thrown.getMessage());
    }

    @Test
    public void getNumeratorDimensionList() {
        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.METER).build()).toArray(),
                UnitMeasureBaseType.METER.getNumeratorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.GRAM).build()).toArray(),
                UnitMeasureBaseType.GRAM.getNumeratorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.SECOND).build()).toArray(),
                UnitMeasureBaseType.SECOND.getNumeratorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.AMPERE).build()).toArray(),
                UnitMeasureBaseType.AMPERE.getNumeratorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.KELVIN).build()).toArray(),
                UnitMeasureBaseType.KELVIN.getNumeratorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.MOLE).build()).toArray(),
                UnitMeasureBaseType.MOLE.getNumeratorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.CANDELA).build()).toArray(),
                UnitMeasureBaseType.CANDELA.getNumeratorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(UnitMeasureBaseType.EACH).build()).toArray(),
                UnitMeasureBaseType.EACH.getNumeratorSimpleUnitMeasurementList().toArray());

    }

    @Test
    public void getDenominatorDimensionList() {
        Assertions.assertArrayEquals(
                Collections.emptyList().toArray(),
                UnitMeasureBaseType.METER.getDenominatorSimpleUnitMeasurementList().toArray());

        Assertions.assertArrayEquals(
                Collections.emptyList().toArray(),
                UnitMeasureBaseType.EACH.getDenominatorSimpleUnitMeasurementList().toArray());
    }

    @Test
    public void getDefaultUnitPrefix() {
        Assertions.assertEquals(UnitPrefix.KILO, UnitMeasureBaseType.GRAM.getDefaultUnitPrefix());
        Assertions.assertEquals(UnitPrefix.UNO, UnitMeasureBaseType.METER.getDefaultUnitPrefix());
        Assertions.assertEquals(UnitPrefix.UNO, UnitMeasureBaseType.SECOND.getDefaultUnitPrefix());
        Assertions.assertEquals(UnitPrefix.UNO, UnitMeasureBaseType.AMPERE.getDefaultUnitPrefix());
        Assertions.assertEquals(UnitPrefix.UNO, UnitMeasureBaseType.KELVIN.getDefaultUnitPrefix());
        Assertions.assertEquals(UnitPrefix.UNO, UnitMeasureBaseType.MOLE.getDefaultUnitPrefix());
        Assertions.assertEquals(UnitPrefix.UNO, UnitMeasureBaseType.CANDELA.getDefaultUnitPrefix());
        Assertions.assertEquals(UnitPrefix.UNO, UnitMeasureBaseType.EACH.getDefaultUnitPrefix());
    }

    @Test
    public void getFundamentalMeasurementType() {
        Assertions.assertEquals(FundamentalMeasurementType.MASS, UnitMeasureBaseType.GRAM.getFundamentalMeasurementType());
        Assertions.assertEquals(FundamentalMeasurementType.LENGTH, UnitMeasureBaseType.METER.getFundamentalMeasurementType());
        Assertions.assertEquals(FundamentalMeasurementType.TIME, UnitMeasureBaseType.SECOND.getFundamentalMeasurementType());
        Assertions.assertEquals(FundamentalMeasurementType.ELECTRICAL_CURRENT, UnitMeasureBaseType.AMPERE.getFundamentalMeasurementType());
        Assertions.assertEquals(FundamentalMeasurementType.TEMPERATURE, UnitMeasureBaseType.KELVIN.getFundamentalMeasurementType());
        Assertions.assertEquals(FundamentalMeasurementType.AMOUNT_OF_SUBSTANCE, UnitMeasureBaseType.MOLE.getFundamentalMeasurementType());
        Assertions.assertEquals(FundamentalMeasurementType.LUMINOUS_INTENSITY, UnitMeasureBaseType.CANDELA.getFundamentalMeasurementType());
        Assertions.assertEquals(FundamentalMeasurementType.UNIT_LESS_NUMBER, UnitMeasureBaseType.EACH.getFundamentalMeasurementType());
    }
}
