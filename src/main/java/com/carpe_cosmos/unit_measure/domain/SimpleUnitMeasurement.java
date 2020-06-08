package com.carpe_cosmos.unit_measure.domain;

import com.carpe_cosmos.unit_measure.constants.UnitMeasureType;
import com.carpe_cosmos.unit_measure.constants.UnitPrefix;
import com.carpe_cosmos.unit_measure.exceptions.UnitPrefixException;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
public class SimpleUnitMeasurement {
    @Builder.Default
    private UnitPrefix unitPrefix = UnitPrefix.UNO;
    @NonNull
    private UnitMeasureType unitMeasureType;


    public boolean isEquivalentUnitMeasurement(SimpleUnitMeasurement other) {
        return this.unitMeasureType.equals(other.unitMeasureType);
    }

    public SimpleUnitMeasurement addPowerOf10ToUnitMeasurementPrefix(int powerOf10) throws UnitPrefixException {
        if (powerOf10 == 0)
            return this;
        UnitPrefix unitPrefixForSumPowerOf10 = this.getUnitPrefix().addPowerOf10(powerOf10);
        return SimpleUnitMeasurement.builder()
                .unitPrefix(unitPrefixForSumPowerOf10)
                .unitMeasureType((this.unitMeasureType))
                .build();
    }
}
