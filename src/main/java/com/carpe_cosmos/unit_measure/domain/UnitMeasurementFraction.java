package com.carpe_cosmos.unit_measure.domain;

import com.carpe_cosmos.unit_measure.constants.UnitMeasureBaseType;
import com.carpe_cosmos.unit_measure.constants.UnitPrefix;
import com.carpe_cosmos.unit_measure.exceptions.UnitPrefixException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UnitMeasurementFraction {
    private List<SimpleUnitMeasurement> numeratorSimpleUnitMeasurementList;
    private List<SimpleUnitMeasurement> denominatorSimpleUnitMeasurementList;


    public UnitMeasurementFraction(List<SimpleUnitMeasurement> inputNumeratorSimpleUnitMeasurementList, List<SimpleUnitMeasurement> inputDenominatorSimpleUnitMeasurementList) {
        this.numeratorSimpleUnitMeasurementList = new ArrayList<>();
        this.denominatorSimpleUnitMeasurementList = new ArrayList<>();
        this.numeratorSimpleUnitMeasurementList.addAll(inputNumeratorSimpleUnitMeasurementList);
        this.denominatorSimpleUnitMeasurementList.addAll(inputDenominatorSimpleUnitMeasurementList);
    }


    public UnitMeasurementFraction() {
        this.numeratorSimpleUnitMeasurementList = new ArrayList<>();
        this.denominatorSimpleUnitMeasurementList = new ArrayList<>();
    }

    private UnitMeasurementFraction(Builder builder) {
        numeratorSimpleUnitMeasurementList = builder.numeratorSimpleUnitMeasurementList;
        denominatorSimpleUnitMeasurementList = builder.denominatorSimpleUnitMeasurementList;
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.denominatorSimpleUnitMeasurementList(this.denominatorSimpleUnitMeasurementList);
        builder.numeratorSimpleUnitMeasurementList(this.numeratorSimpleUnitMeasurementList);
        return builder;
    }


    public static UnitMeasurementFraction reduceUnitTypes(UnitMeasurementFraction inputUnitMeasurementFraction, UnitPrefix inputUnitPrefix) {

        UnitMeasurementFraction resultUnitMeasurementFraction = new Builder().build();

        if (!inputUnitPrefix.equals(UnitPrefix.UNO)) {
            resultUnitMeasurementFraction.numeratorSimpleUnitMeasurementList.add(new SimpleUnitMeasurement(inputUnitPrefix, UnitMeasureBaseType.EACH));
            resultUnitMeasurementFraction.denominatorSimpleUnitMeasurementList.add(new SimpleUnitMeasurement(UnitPrefix.UNO, UnitMeasureBaseType.EACH));
        }

        //reduce all to base types
        for (SimpleUnitMeasurement simpleUnitMeasurement : inputUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList()) {

            UnitMeasurementFraction tempUnitMeasurementFraction = reduceUnitTypes(
                    simpleUnitMeasurement.getUnitMeasureType().getNumeratorSimpleUnitMeasurementList(),
                    simpleUnitMeasurement.getUnitMeasureType().getDenominatorSimpleUnitMeasurementList(),
                    simpleUnitMeasurement.getUnitPrefix());
            resultUnitMeasurementFraction.numeratorSimpleUnitMeasurementList.addAll(tempUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList());
            resultUnitMeasurementFraction.denominatorSimpleUnitMeasurementList.addAll(tempUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList());

        }

        for (SimpleUnitMeasurement simpleUnitMeasurement : inputUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList()) {
            if (simpleUnitMeasurement.getUnitMeasureType().isBaseUnitDimension()) {
                resultUnitMeasurementFraction.denominatorSimpleUnitMeasurementList.add(new SimpleUnitMeasurement(simpleUnitMeasurement.getUnitPrefix(), simpleUnitMeasurement.getUnitMeasureType()));
            } else {
                UnitMeasurementFraction tempUnitMeasurementFraction = reduceUnitTypes(
                        simpleUnitMeasurement.getUnitMeasureType().getNumeratorSimpleUnitMeasurementList(),
                        simpleUnitMeasurement.getUnitMeasureType().getDenominatorSimpleUnitMeasurementList(),
                        simpleUnitMeasurement.getUnitPrefix());
                resultUnitMeasurementFraction.numeratorSimpleUnitMeasurementList.addAll(tempUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList());
                resultUnitMeasurementFraction.denominatorSimpleUnitMeasurementList.addAll(tempUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList());
            }
        }
        return resultUnitMeasurementFraction;
    }


    public static UnitMeasurementFraction reduceUnitTypes(List<SimpleUnitMeasurement> inputNumeratorSimpleUnitMeasurementList, List<SimpleUnitMeasurement> inputDenominatorSimpleUnitMeasurementList, UnitPrefix inputUnitPrefix) {
        UnitMeasurementFraction tempUnitMeasurementFraction = new Builder()
                .numeratorSimpleUnitMeasurementList(inputNumeratorSimpleUnitMeasurementList)
                .denominatorSimpleUnitMeasurementList(inputDenominatorSimpleUnitMeasurementList)
                .build();
        return reduceUnitTypes(tempUnitMeasurementFraction, inputUnitPrefix);
    }


    public static UnitMeasurementFraction cancelUnitTypes(UnitMeasurementFraction inputUnitMeasurementFraction) {
        List<SimpleUnitMeasurement> tempDenominatorSimpleUnitMeasurementList = new ArrayList<>(inputUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList());
        UnitMeasurementFraction resultUnitMeasurementFraction = new Builder().build();
        for (SimpleUnitMeasurement simpleUnitMeasurement : inputUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList()) {
            for (SimpleUnitMeasurement simpleUnitMeasurement1 : tempDenominatorSimpleUnitMeasurementList) {
                if (simpleUnitMeasurement.getUnitMeasureType().equals(simpleUnitMeasurement1.getUnitMeasureType())) {
                    if (simpleUnitMeasurement.getUnitPrefix().equals(simpleUnitMeasurement1.getUnitPrefix())) {
                        tempDenominatorSimpleUnitMeasurementList.remove(simpleUnitMeasurement1);
                        break;
                    } else {
                        tempDenominatorSimpleUnitMeasurementList.remove(simpleUnitMeasurement1);
                        tempDenominatorSimpleUnitMeasurementList.add(new SimpleUnitMeasurement(simpleUnitMeasurement1.getUnitPrefix(), UnitMeasureBaseType.EACH));
                        resultUnitMeasurementFraction = resultUnitMeasurementFraction.toBuilder().numeratorSimpleUnitMeasurementList(new SimpleUnitMeasurement(simpleUnitMeasurement.getUnitPrefix(), UnitMeasureBaseType.EACH)).build();
                        resultUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList().add(new SimpleUnitMeasurement(simpleUnitMeasurement.getUnitPrefix(), UnitMeasureBaseType.EACH));
                    }
                } else {
                    resultUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList().add(simpleUnitMeasurement);
                }
            }

        }
        resultUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList().addAll(tempDenominatorSimpleUnitMeasurementList);
        return resultUnitMeasurementFraction;

    }


    /* factorNumericUnitPrefixes
    Given inputUnitMeasurementFraction

     */
    public static double factorNumericUnitPrefixes(UnitMeasurementFraction outputUnitMeasurementFraction, UnitMeasurementFraction inputUnitMeasurementFraction) {
        int powerOf10 = 0;

        for (SimpleUnitMeasurement simpleUnitMeasurement : inputUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList()) {
            if (simpleUnitMeasurement.getUnitMeasureType().equals(UnitMeasureBaseType.EACH)) {
                powerOf10 += simpleUnitMeasurement.getUnitPrefix().getPowerOf10();
            } else {
                SimpleUnitMeasurement alteredSimpleUnitMeasurement;
                try {
                    alteredSimpleUnitMeasurement = simpleUnitMeasurement.addPowerOf10ToUnitMeasurementPrefix(powerOf10);
                    outputUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList().add(alteredSimpleUnitMeasurement);
                    powerOf10 = 0;
                } catch (UnitPrefixException e) {
                    outputUnitMeasurementFraction.getNumeratorSimpleUnitMeasurementList().add(simpleUnitMeasurement);
                }
            }
        }

        for (SimpleUnitMeasurement simpleUnitMeasurement : inputUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList()) {
            if (simpleUnitMeasurement.getUnitMeasureType().equals(UnitMeasureBaseType.EACH)) {
                powerOf10 -= simpleUnitMeasurement.getUnitPrefix().getPowerOf10();
            } else {
                SimpleUnitMeasurement alteredSimpleUnitMeasurement;
                try {
                    alteredSimpleUnitMeasurement = simpleUnitMeasurement.addPowerOf10ToUnitMeasurementPrefix(powerOf10);
                    outputUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList().add(alteredSimpleUnitMeasurement);
                    powerOf10 = 0;
                } catch (UnitPrefixException e) {
                    outputUnitMeasurementFraction.getDenominatorSimpleUnitMeasurementList().add(simpleUnitMeasurement);
                }
            }
        }

        return powerOf10 == 0 ? 1D : Math.pow(10., powerOf10);
    }

    public static final class Builder {
        private final List<SimpleUnitMeasurement> numeratorSimpleUnitMeasurementList;
        private final List<SimpleUnitMeasurement> denominatorSimpleUnitMeasurementList;

        public Builder() {
            this.numeratorSimpleUnitMeasurementList = new ArrayList<>();
            this.denominatorSimpleUnitMeasurementList = new ArrayList<>();
        }

        public Builder numeratorSimpleUnitMeasurementList(List<SimpleUnitMeasurement> val) {
            numeratorSimpleUnitMeasurementList.addAll(val);
            return this;
        }

        public Builder denominatorSimpleUnitMeasurementList(List<SimpleUnitMeasurement> val) {
            denominatorSimpleUnitMeasurementList.addAll(val);
            return this;
        }

        public Builder numeratorSimpleUnitMeasurementList(SimpleUnitMeasurement val) {
            numeratorSimpleUnitMeasurementList.add(val);
            return this;
        }

        public Builder denominatorSimpleUnitMeasurementList(SimpleUnitMeasurement val) {
            denominatorSimpleUnitMeasurementList.add(val);
            return this;
        }

        public UnitMeasurementFraction build() {
            return new UnitMeasurementFraction(this);
        }
    }
}
