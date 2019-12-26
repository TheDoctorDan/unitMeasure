package com.carpeCosmos.unitMeasure.domain;

import com.carpeCosmos.unitMeasure.constants.UnitMeasureType;
import com.carpeCosmos.unitMeasure.constants.UnitPrefix;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.NoSuchElementException;

import static com.carpeCosmos.unitMeasure.constants.UnitPrefix.UNO;

@Getter
@Builder(builderMethodName = "newBuilder")
@EqualsAndHashCode
public class SimpleUnitMeasurement
{
    @Builder.Default
    private UnitPrefix unitPrefix = UNO;
    @NonNull
    private UnitMeasureType unitMeasureType;



    public SimpleUnitMeasurement addPowerOf10ToUnitMeasurementPrefix(int powerOf10) throws NoSuchElementException
    {
        if(powerOf10==0)
            return this;
        UnitPrefix unitPrefixForSumPowerOf10 = this.getUnitPrefix().addPowerOf10(powerOf10);
        return SimpleUnitMeasurement.newBuilder()
                .unitPrefix(unitPrefixForSumPowerOf10)
                .unitMeasureType((this.unitMeasureType))
                .build();
    }
}
