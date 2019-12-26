package com.carpeCosmos.unitMeasure.constants;

import com.carpeCosmos.unitMeasure.domain.SimpleUnitMeasurement;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.carpeCosmos.unitMeasure.constants.UnitMeasureBaseType.*;
import static com.carpeCosmos.unitMeasure.constants.UnitPrefix.KILO;
import static com.carpeCosmos.unitMeasure.constants.UnitPrefix.UNO;
import static java.util.Collections.singletonList;

@Getter
public enum UnitMeasureDerivedType implements UnitMeasureType {
    //Mechanical

    NEWTON("n",
            Arrays.asList(
                    SimpleUnitMeasurement.newBuilder().unitPrefix(KILO).unitMeasureType(GRAM).build(),
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(METER).build()
            ),
            Arrays.asList(
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(SECOND).build(),
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(SECOND).build()
            ),
            UNO),

    JOULE("J",
            Arrays.asList(
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(NEWTON).build(),
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(METER).build()
            ),
            Collections.emptyList(),
            UNO),

    WATT("W",
            Arrays.asList(
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(JOULE).build(),
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(METER).build()
            ),
            singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(SECOND).build()),
            UNO),

    PASCAL("Pa",
            singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(NEWTON).build()),
            Arrays.asList(
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(METER).build(),
                    SimpleUnitMeasurement.newBuilder().unitMeasureType(METER).build()
            ),
            UNO),

    //Electrical
    VOLT("V", WATT, AMPERE, UNO),

    OHM("\u03A9", VOLT, AMPERE, UNO),

    //Angle
    RADIAN("rad", METER, METER, UNO);

    private String symbol;

    private List<SimpleUnitMeasurement> numeratorSimpleUnitMeasurementList;
    private List<SimpleUnitMeasurement> denominatorSimpleUnitMeasurementList;
    private UnitPrefix defaultUnitPrefix;

    UnitMeasureDerivedType(String symbol, List<SimpleUnitMeasurement> numeratorSimpleUnitMeasurementList, List<SimpleUnitMeasurement> denominatorSimpleUnitMeasurementList, UnitPrefix defaultUnitPrefix) {
        this.symbol = symbol;
        this.numeratorSimpleUnitMeasurementList = numeratorSimpleUnitMeasurementList;
        this.denominatorSimpleUnitMeasurementList = denominatorSimpleUnitMeasurementList;
        this.defaultUnitPrefix = defaultUnitPrefix;
    }

    UnitMeasureDerivedType(String symbol, UnitMeasureType numeratorUnitMeasureType, UnitMeasureType denominatorUnitMeasureType, UnitPrefix defaultUnitPrefix) {
        this.symbol = symbol;
        this.numeratorSimpleUnitMeasurementList = singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(numeratorUnitMeasureType).build());
        this.denominatorSimpleUnitMeasurementList = singletonList(SimpleUnitMeasurement.newBuilder().unitMeasureType(denominatorUnitMeasureType).build());
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
