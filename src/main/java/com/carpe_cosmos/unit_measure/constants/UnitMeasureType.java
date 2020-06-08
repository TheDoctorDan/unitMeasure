package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.domain.SimpleUnitMeasurement;
import com.carpe_cosmos.unit_measure.exceptions.UnitMeasureException;

import java.util.List;

public interface UnitMeasureType {


    String getSymbol();

    boolean isBaseUnitDimension();

    List<SimpleUnitMeasurement> getNumeratorSimpleUnitMeasurementList();

    List<SimpleUnitMeasurement> getDenominatorSimpleUnitMeasurementList();

    UnitPrefix getDefaultUnitPrefix();


    static <T extends Enum<T> & UnitMeasureType> T findBySymbol(Class<T> enumClass, String symbol) throws UnitMeasureException {
        for (T unitDimensionType : enumClass.getEnumConstants()) {
            if (unitDimensionType.getSymbol().equals(symbol))
                return unitDimensionType;
        }
        throw new UnitMeasureException("No " + enumClass.getSimpleName() + " Enum with symbol of " + symbol + ".");
    }


}
