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
        assertEquals(NEWTON.getNumeratorSimpleUnitMeasurementList(), expected);

        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(NEWTON).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertEquals(JOULE.getNumeratorSimpleUnitMeasurementList(), expected);

        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(JOULE).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertEquals(WATT.getNumeratorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(NEWTON).build()
        );
        assertEquals(PASCAL.getNumeratorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(WATT).build()
        );
        assertEquals(VOLT.getNumeratorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(VOLT).build()
        );
        assertEquals(OHM.getNumeratorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertEquals(RADIAN.getNumeratorSimpleUnitMeasurementList(), expected);

    }

    @Test
    void getDenominatorSimpleUnitMeasurementListTest() {
        List<SimpleUnitMeasurement> expected;
        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()
        );
        assertEquals(NEWTON.getDenominatorSimpleUnitMeasurementList(), expected);

        expected = Collections.emptyList();
        assertEquals(JOULE.getDenominatorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()
        );
        assertEquals(WATT.getDenominatorSimpleUnitMeasurementList(), expected);

        expected = asList(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build(),
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertEquals(PASCAL.getDenominatorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(AMPERE).build()
        );
        assertEquals(VOLT.getDenominatorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(AMPERE).build()
        );
        assertEquals(OHM.getDenominatorSimpleUnitMeasurementList(), expected);

        expected = Collections.singletonList(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
        );
        assertEquals(RADIAN.getDenominatorSimpleUnitMeasurementList(), expected);

    }

    @Test
    void getDefaultUnitPrefixTest() {
        assertEquals(NEWTON.getDefaultUnitPrefix(), UNO);
        assertEquals(JOULE.getDefaultUnitPrefix(), UNO);
        assertEquals(WATT.getDefaultUnitPrefix(), UNO);
        assertEquals(PASCAL.getDefaultUnitPrefix(), UNO);
        assertEquals(VOLT.getDefaultUnitPrefix(), UNO);
        assertEquals(OHM.getDefaultUnitPrefix(), UNO);
        assertEquals(RADIAN.getDefaultUnitPrefix(), UNO);

    }

    @Test
    void getSymbolTest() {
        assertEquals(NEWTON.getSymbol(), "n");
        assertEquals(JOULE.getSymbol(), "J");
        assertEquals(WATT.getSymbol(), "W");
        assertEquals(PASCAL.getSymbol(), "Pa");
        assertEquals(VOLT.getSymbol(), "V");
        assertEquals(OHM.getSymbol(), "\u03A9");
        assertEquals(RADIAN.getSymbol(), "rad");

    }

    @Test
    void getMeasurementSystemTest() {
        assertEquals(NEWTON.getMeasurementSystem(), SYSTEM_INTERNATIONAL);
        assertEquals(JOULE.getMeasurementSystem(), SYSTEM_INTERNATIONAL);
        assertEquals(WATT.getMeasurementSystem(), SYSTEM_INTERNATIONAL);
        assertEquals(PASCAL.getMeasurementSystem(), SYSTEM_INTERNATIONAL);
        assertEquals(VOLT.getMeasurementSystem(), SYSTEM_INTERNATIONAL);
        assertEquals(OHM.getMeasurementSystem(), SYSTEM_INTERNATIONAL);
        assertEquals(RADIAN.getMeasurementSystem(), SYSTEM_INTERNATIONAL);

    }
}
