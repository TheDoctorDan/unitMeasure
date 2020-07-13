package com.carpe_cosmos.unit_measure.domain;

import org.junit.jupiter.api.Test;

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
import static com.carpe_cosmos.unit_measure.constants.UnitPrefix.KILO;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleUnitMeasurementTest {
    //TODO  paramterize all ENUM values and add cross system method/test

    @Test
    void isEquivalentUnitMeasurementTest() {
        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(GRAM).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(GRAM).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(AMPERE).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(AMPERE).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(KELVIN).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(KELVIN).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(MOLE).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(MOLE).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(CANDELA).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(CANDELA).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(EACH).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(EACH).build()
                        )
        );


        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(FOOT).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(FOOT).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(SLUG).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(SLUG).build()
                        )
        );

        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(RANKINE).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(RANKINE).build()
                        )
        );


        assertTrue(
                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitPrefix(KILO).unitMeasureType(METER).build()
                        )
        );


        assertFalse(
                SimpleUnitMeasurement.builder().unitMeasureType(FOOT).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
                        )
        );


        assertFalse(
                SimpleUnitMeasurement.builder().unitMeasureType(SLUG).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(GRAM).build()
                        )
        );

        assertFalse(
                SimpleUnitMeasurement.builder().unitMeasureType(RANKINE).build()
                        .isEquivalentUnitMeasurement(
                                SimpleUnitMeasurement.builder().unitMeasureType(KELVIN).build()
                        )
        );


    }

    @Test
    void addPowerOf10ToUnitMeasurementPrefixTest() {
        //TODO create test
    }


}


