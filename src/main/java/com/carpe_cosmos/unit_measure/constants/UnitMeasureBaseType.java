package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.domain.SimpleUnitMeasurement;
import com.carpe_cosmos.unit_measure.exceptions.UnitMeasureException;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

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
import static com.carpe_cosmos.unit_measure.constants.UnitPrefix.KILO;
import static com.carpe_cosmos.unit_measure.constants.UnitPrefix.UNO;
import static java.util.Collections.singletonList;

@Getter
public enum UnitMeasureBaseType implements UnitMeasureType {
    METER("m", SYSTEM_INTERNATIONAL, LENGTH, UNO),
    GRAM("g", SYSTEM_INTERNATIONAL, MASS, KILO),
    SECOND("s", SYSTEM_INTERNATIONAL, TIME, UNO),
    AMPERE("A", SYSTEM_INTERNATIONAL, ELECTRICAL_CURRENT, UNO),
    KELVIN("K", SYSTEM_INTERNATIONAL, TEMPERATURE, UNO),
    MOLE("mole", SYSTEM_INTERNATIONAL, AMOUNT_OF_SUBSTANCE, UNO),
    CANDELA("cd", SYSTEM_INTERNATIONAL, LUMINOUS_INTENSITY, UNO),
    EACH("ea", SYSTEM_INTERNATIONAL, UNIT_LESS_NUMBER, UNO),

    FOOT("ft", IMPERIAL, LENGTH, UNO),
    SLUG("slug", IMPERIAL, MASS, UNO),
    RANKINE("R", IMPERIAL, TEMPERATURE, UNO);


    private String symbol;
    private MeasurementSystem measurementSystem;
    private FundamentalMeasurementType fundamentalMeasurementType;
    private UnitPrefix defaultUnitPrefix;

    UnitMeasureBaseType(String symbol,
                        MeasurementSystem measurementSystem,
                        FundamentalMeasurementType fundamentalMeasurementType,
                        UnitPrefix defaultUnitPrefix) {
        this.symbol = symbol;
        this.measurementSystem = measurementSystem;
        this.fundamentalMeasurementType = fundamentalMeasurementType;
        this.defaultUnitPrefix = defaultUnitPrefix;
    }

    @Override
    public boolean isBaseUnitDimension() {
        return true;
    }


    public static UnitMeasureBaseType findByFundamentalMeasurementType(FundamentalMeasurementType fundamentalMeasurementType, MeasurementSystem measurementSystem) throws UnitMeasureException {
        for (UnitMeasureBaseType unitMeasureBaseType : values()) {
            if (unitMeasureBaseType.fundamentalMeasurementType.equals(fundamentalMeasurementType) &&
                    unitMeasureBaseType.measurementSystem.equals(measurementSystem))
                return unitMeasureBaseType;
        }
        throw new UnitMeasureException("No UnitMeasureBaseType Enum with fundamentalMeasurementType of " + fundamentalMeasurementType + ".");
    }

    @Override
    public List<SimpleUnitMeasurement> getNumeratorSimpleUnitMeasurementList() {
        return singletonList(SimpleUnitMeasurement.builder().unitPrefix(UNO).unitMeasureType(this).build());
    }

    @Override
    public List<SimpleUnitMeasurement> getDenominatorSimpleUnitMeasurementList() {
        return Collections.emptyList();
    }

    @Override
    public UnitPrefix getDefaultUnitPrefix() {
        return this.defaultUnitPrefix;
    }

}
