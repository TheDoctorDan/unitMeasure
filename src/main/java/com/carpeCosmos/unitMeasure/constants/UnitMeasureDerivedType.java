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
                    new SimpleUnitMeasurement(KILO, GRAM),
                    new SimpleUnitMeasurement(METER)
            ),
            Arrays.asList(
                    new SimpleUnitMeasurement(SECOND),
                    new SimpleUnitMeasurement(SECOND)
            ),
            UNO),

    JOULE("J",
            Arrays.asList(
                    new SimpleUnitMeasurement(NEWTON),
                    new SimpleUnitMeasurement(METER)
            ),
            Collections.emptyList(),
            UNO),

    WATT("W",
            Arrays.asList(
                    new SimpleUnitMeasurement(JOULE),
                    new SimpleUnitMeasurement(METER)
            ),
            singletonList(new SimpleUnitMeasurement(SECOND)),
            UNO),

    PASCAL("Pa",
            singletonList(new SimpleUnitMeasurement(NEWTON)),
            Arrays.asList(
                    new SimpleUnitMeasurement(METER),
                    new SimpleUnitMeasurement(METER)
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
        this.numeratorSimpleUnitMeasurementList = singletonList(new SimpleUnitMeasurement(numeratorUnitMeasureType));
        this.denominatorSimpleUnitMeasurementList = singletonList(new SimpleUnitMeasurement(denominatorUnitMeasureType));
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
