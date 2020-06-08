package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.domain.SimpleUnitMeasurement;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.carpe_cosmos.unit_measure.constants.MeasurementSystem.SYSTEM_INTERNATIONAL;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.AMPERE;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.GRAM;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.METER;
import static com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType.SECOND;
import static com.carpe_cosmos.unit_measure.constants.UnitPrefix.KILO;
import static com.carpe_cosmos.unit_measure.constants.UnitPrefix.UNO;
import static java.util.Collections.singletonList;

@Getter
public enum UnitMeasureDerivedType implements UnitMeasureType {
    //Mechanical

    NEWTON("n", SYSTEM_INTERNATIONAL,
            Arrays.asList(
                    SimpleUnitMeasurement.builder()
                            .unitPrefix(KILO).unitMeasureType(GRAM).build(),
                    SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
            ),
            Arrays.asList(
                    SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build(),
                    SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()
            ),
            UNO),

    JOULE("J", SYSTEM_INTERNATIONAL,
            Arrays.asList(
                    SimpleUnitMeasurement.builder().unitMeasureType(NEWTON).build(),
                    SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
            ),
            Collections.emptyList(),
            UNO),

    WATT("W", SYSTEM_INTERNATIONAL,
            Arrays.asList(
                    SimpleUnitMeasurement.builder().unitMeasureType(JOULE).build(),
                    SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
            ),
            singletonList(SimpleUnitMeasurement.builder().unitMeasureType(SECOND).build()),
            UNO),

    PASCAL("Pa", SYSTEM_INTERNATIONAL,
            singletonList(SimpleUnitMeasurement.builder().unitMeasureType(NEWTON).build()),
            Arrays.asList(
                    SimpleUnitMeasurement.builder().unitMeasureType(METER).build(),
                    SimpleUnitMeasurement.builder().unitMeasureType(METER).build()
            ),
            UNO),

    //Electrical
    VOLT("V", SYSTEM_INTERNATIONAL, WATT, AMPERE, UNO),

    OHM("\u03A9", SYSTEM_INTERNATIONAL, VOLT, AMPERE, UNO),

    //Angle
    RADIAN("rad", SYSTEM_INTERNATIONAL, METER, METER, UNO);

    private String symbol;
    private MeasurementSystem measurementSystem;

    private List<SimpleUnitMeasurement> numeratorSimpleUnitMeasurementList;
    private List<SimpleUnitMeasurement> denominatorSimpleUnitMeasurementList;
    private UnitPrefix defaultUnitPrefix;

    UnitMeasureDerivedType(String symbol,
                           MeasurementSystem measurementSystem,
                           List<SimpleUnitMeasurement> numeratorSimpleUnitMeasurementList,
                           List<SimpleUnitMeasurement> denominatorSimpleUnitMeasurementList,
                           UnitPrefix defaultUnitPrefix) {
        this.symbol = symbol;
        this.measurementSystem = measurementSystem;
        this.numeratorSimpleUnitMeasurementList = numeratorSimpleUnitMeasurementList;
        this.denominatorSimpleUnitMeasurementList = denominatorSimpleUnitMeasurementList;
        this.defaultUnitPrefix = defaultUnitPrefix;
    }

    UnitMeasureDerivedType(String symbol,
                           MeasurementSystem measurementSystem,
                           UnitMeasureType numeratorUnitMeasureType,
                           UnitMeasureType denominatorUnitMeasureType,
                           UnitPrefix defaultUnitPrefix) {
        this.symbol = symbol;
        this.measurementSystem = measurementSystem;
        this.numeratorSimpleUnitMeasurementList = singletonList(SimpleUnitMeasurement.builder()
                .unitMeasureType(numeratorUnitMeasureType)
                .build());
        this.denominatorSimpleUnitMeasurementList = singletonList(SimpleUnitMeasurement.builder()
                .unitMeasureType(denominatorUnitMeasureType)
                .build());
        this.defaultUnitPrefix = defaultUnitPrefix;
    }


    @Override
    public boolean isBaseUnitDimension() {
        return false;
    }

    @Override
    public List<SimpleUnitMeasurement> getNumeratorSimpleUnitMeasurementList() {
        return numeratorSimpleUnitMeasurementList;
    }

    @Override
    public List<SimpleUnitMeasurement> getDenominatorSimpleUnitMeasurementList() {
        return denominatorSimpleUnitMeasurementList;
    }

    @Override
    public UnitPrefix getDefaultUnitPrefix() {
        return this.defaultUnitPrefix;
    }


}
