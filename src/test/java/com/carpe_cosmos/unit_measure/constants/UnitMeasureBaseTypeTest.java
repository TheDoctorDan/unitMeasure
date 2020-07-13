package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.domain.SimpleUnitMeasurement;
import com.carpe_cosmos.unit_measure.exceptions.UnitMeasureException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Collections;

import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.AMOUNT_OF_SUBSTANCE;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.ELECTRICAL_CURRENT;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.LENGTH;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.LUMINOUS_INTENSITY;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.MASS;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.TEMPERATURE;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.TIME;
import static com.carpe_cosmos.unit_measure.constants.FundamentalMeasurementType.UNIT_LESS_NUMBER;
import static com.carpe_cosmos.unit_measure.constants.MeasurementSystem.IMPERIAL;
import static com.carpe_cosmos.unit_measure.constants.MeasurementSystem.SYSTEM_INTERNATIONAL;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.AMPERE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.CANDELA;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.EACH;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.FOOT;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.GRAM;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.KELVIN;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.METER;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.MOLE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.RANKINE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.SECOND;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.SLUG;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.findByFundamentalMeasurementType;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureType.findBySymbol;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class UnitMeasureBaseTypeTest {


    void isBaseUnitDimensionTest(UnitMeasureBaseType unitMeasureBaseType, boolean expected) {
        assertEquals(expected, unitMeasureBaseType.isBaseUnitDimension());
    }

    void findBySymbolTestNormalSet(UnitMeasureBaseType expected, String symbol) throws Exception {
        assertEquals(expected, findBySymbol(UnitMeasureBaseType.class, symbol));
    }

    void findByFundamentalMeasurementTypeTestNormalSet(
            UnitMeasureBaseType expected,
            FundamentalMeasurementType fundamentalMeasurementType,
            MeasurementSystem measurementSystem
    ) throws Exception {
        assertEquals(expected, findByFundamentalMeasurementType(fundamentalMeasurementType, measurementSystem));
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


        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(FOOT).build()).toArray(),
                FOOT.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(SLUG).build()).toArray(),
                SLUG.getNumeratorSimpleUnitMeasurementList().toArray());

        assertArrayEquals(
                singletonList(SimpleUnitMeasurement.builder()
                        .unitMeasureType(RANKINE).build()).toArray(),
                RANKINE.getNumeratorSimpleUnitMeasurementList().toArray());

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

        assertEquals(UnitPrefix.UNO, FOOT.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, SLUG.getDefaultUnitPrefix());
        assertEquals(UnitPrefix.UNO, RANKINE.getDefaultUnitPrefix());

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

        assertEquals(LENGTH, FOOT.getFundamentalMeasurementType());
        assertEquals(MASS, SLUG.getFundamentalMeasurementType());
        assertEquals(TEMPERATURE, RANKINE.getFundamentalMeasurementType());

    }


    @Test
    void getMeasurementSystemTest() {
        assertEquals(SYSTEM_INTERNATIONAL, METER.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, GRAM.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, SECOND.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, AMPERE.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, KELVIN.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, MOLE.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, CANDELA.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, EACH.getMeasurementSystem());

        assertEquals(IMPERIAL, FOOT.getMeasurementSystem());
        assertEquals(IMPERIAL, SLUG.getMeasurementSystem());
        assertEquals(IMPERIAL, RANKINE.getMeasurementSystem());

    }


    @ParameterizedTest
    @EnumSource(UnitMeasureBaseType.class)
    public void haveAllEnums(UnitMeasureBaseType unitMeasureBaseType) throws Exception {

        String symbol;
        FundamentalMeasurementType fundamentalMeasurementType;
        MeasurementSystem measurementSystem;
        switch (unitMeasureBaseType) {
            case METER:
                symbol = "m";
                fundamentalMeasurementType = LENGTH;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;
            case GRAM:
                symbol = "g";
                fundamentalMeasurementType = MASS;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;
            case SECOND:
                symbol = "s";
                fundamentalMeasurementType = TIME;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;
            case AMPERE:
                symbol = "A";
                fundamentalMeasurementType = ELECTRICAL_CURRENT;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;
            case KELVIN:
                symbol = "K";
                fundamentalMeasurementType = TEMPERATURE;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;
            case MOLE:
                symbol = "mole";
                fundamentalMeasurementType = AMOUNT_OF_SUBSTANCE;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;
            case CANDELA:
                symbol = "cd";
                fundamentalMeasurementType = LUMINOUS_INTENSITY;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;
            case EACH:
                symbol = "ea";
                fundamentalMeasurementType = UNIT_LESS_NUMBER;
                measurementSystem = SYSTEM_INTERNATIONAL;
                break;

            case FOOT:
                symbol = "ft";
                fundamentalMeasurementType = LENGTH;
                measurementSystem = IMPERIAL;
                break;
            case SLUG:
                symbol = "slug";
                fundamentalMeasurementType = MASS;
                measurementSystem = IMPERIAL;
                break;
            case RANKINE:
                symbol = "R";
                fundamentalMeasurementType = TEMPERATURE;
                measurementSystem = IMPERIAL;
                break;

            default:
                fail("unitMeasureBaseType :" + unitMeasureBaseType + ": is missing from these test!");
                symbol = "";
                fundamentalMeasurementType = null;
                measurementSystem = null;
        }


        isBaseUnitDimensionTest(unitMeasureBaseType, true);
        findBySymbolTestNormalSet(unitMeasureBaseType, symbol);
        findByFundamentalMeasurementTypeTestNormalSet(unitMeasureBaseType, fundamentalMeasurementType, measurementSystem);

    }


    @Test
    public void findBySymbolTestFailure() {
        Throwable thrown = assertThrows(UnitMeasureException.class, () ->
                findBySymbol(UnitMeasureBaseType.class, "z"));
        assertEquals("No UnitMeasureBaseType Enum with symbol of z.", thrown.getMessage());
    }

    @Test
    public void findByFundamentalMeasurementTypeTestFailure() {
        Throwable thrown = assertThrows(UnitMeasureException.class, () ->
                findByFundamentalMeasurementType(null, null));
        assertEquals("No UnitMeasureBaseType Enum with fundamentalMeasurementType of null.", thrown.getMessage());
    }

}


