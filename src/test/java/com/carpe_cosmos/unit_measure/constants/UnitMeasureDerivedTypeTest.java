package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.domain.SimpleUnitMeasurement;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.carpe_cosmos.unit_measure.constants.MeasurementSystem.SYSTEM_INTERNATIONAL;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.AMPERE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.GRAM;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.METER;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.SECOND;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureDerivedType.JOULE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureDerivedType.NEWTON;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureDerivedType.OHM;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureDerivedType.PASCAL;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureDerivedType.RADIAN;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureDerivedType.VOLT;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureDerivedType.WATT;
import static com.carpe_cosmos.unit_measure.constants.UnitPrefix.KILO;
import static com.carpe_cosmos.unit_measure.constants.UnitPrefix.UNO;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UnitMeasureDerivedTypeTest {

    @Test
    void isBaseUnitDimensionTest() {
        assertFalse(NEWTON.isBaseUnitDimension());
        assertFalse(JOULE.isBaseUnitDimension());
        assertFalse(WATT.isBaseUnitDimension());
        assertFalse(PASCAL.isBaseUnitDimension());
        assertFalse(VOLT.isBaseUnitDimension());
        assertFalse(OHM.isBaseUnitDimension());
        assertFalse(RADIAN.isBaseUnitDimension());

    }

    @Test
    void getNumeratorSimpleUnitMeasurementListTest() {
        List<SimpleUnitMeasurement> expected;
        expected = asList(
                SimpleUnitMeasurement.builder().unitPrefix(KILO).unitMeasureType(GRAM).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertArrayEquals(expected.toArray(), NEWTON.getNumeratorSimpleUnitMeasurementList().toArray());

        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(NEWTON).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertArrayEquals(expected.toArray(), JOULE.getNumeratorSimpleUnitMeasurementList().toArray());

        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(JOULE).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertArrayEquals(expected.toArray(), WATT.getNumeratorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(NEWTON).build()
        );
        assertArrayEquals(expected.toArray(), PASCAL.getNumeratorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(WATT).build()
        );
        assertArrayEquals(expected.toArray(), VOLT.getNumeratorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(VOLT).build()
        );
        assertArrayEquals(expected.toArray(), OHM.getNumeratorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertArrayEquals(expected.toArray(), RADIAN.getNumeratorSimpleUnitMeasurementList().toArray());

    }

    @Test
    void getDenominatorSimpleUnitMeasurementListTest() {
        List<SimpleUnitMeasurement> expected;
        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()
        );
        assertArrayEquals(expected.toArray(), NEWTON.getDenominatorSimpleUnitMeasurementList().toArray());

        expected = Collections.emptyList();
        assertArrayEquals(expected.toArray(), JOULE.getDenominatorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()
        );
        assertArrayEquals(expected.toArray(), WATT.getDenominatorSimpleUnitMeasurementList().toArray());

        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertArrayEquals(expected.toArray(), PASCAL.getDenominatorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(AMPERE).build()
        );
        assertArrayEquals(expected.toArray(), VOLT.getDenominatorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(AMPERE).build()
        );
        assertArrayEquals(expected.toArray(), OHM.getDenominatorSimpleUnitMeasurementList().toArray());

        expected = singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertArrayEquals(expected.toArray(), RADIAN.getDenominatorSimpleUnitMeasurementList().toArray());

    }

    @Test
    void getDefaultUnitPrefixTest() {
        assertEquals(UNO, NEWTON.getDefaultUnitPrefix());
        assertEquals(UNO, JOULE.getDefaultUnitPrefix());
        assertEquals(UNO, WATT.getDefaultUnitPrefix());
        assertEquals(UNO, PASCAL.getDefaultUnitPrefix());
        assertEquals(UNO, VOLT.getDefaultUnitPrefix());
        assertEquals(UNO, OHM.getDefaultUnitPrefix());
        assertEquals(UNO, RADIAN.getDefaultUnitPrefix());

    }

    @Test
    void getSymbolTest() {
        assertEquals("n", NEWTON.getSymbol());
        assertEquals("J", JOULE.getSymbol());
        assertEquals("W", WATT.getSymbol());
        assertEquals("Pa", PASCAL.getSymbol());
        assertEquals("V", VOLT.getSymbol());
        assertEquals("\u03A9", OHM.getSymbol());
        assertEquals("rad", RADIAN.getSymbol());

    }

    @Test
    void getMeasurementSystemTest() {
        assertEquals(SYSTEM_INTERNATIONAL, NEWTON.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, JOULE.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, WATT.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, PASCAL.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, VOLT.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, OHM.getMeasurementSystem());
        assertEquals(SYSTEM_INTERNATIONAL, RADIAN.getMeasurementSystem());

    }
}
