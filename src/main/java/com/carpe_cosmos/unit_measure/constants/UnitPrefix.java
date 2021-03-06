package com.carpe_cosmos.unit_measure.constants;

import com.carpe_cosmos.unit_measure.exceptions.UnitPrefixException;
import lombok.Getter;

@Getter
public enum UnitPrefix {
    YOTTA(1.0E+24, 24, "septillion", "yotta-", "Y"),
    ZETTA(1.0E+21, 21, "sextillion", "zetta-", "Z"),
    EXA(1.0E+18, 18, "quintillion", "exa-", "E"),
    PETA(1.0E+15, 15, "quadrillion", "peta-", "P"),
    TERA(1.0E+12, 12, "trillion", "tera-", "T"),
    GIGA(1.0E+9, 9, "billion", "giga-", "G"),
    MEGA(1.0E+6, 6, "million", "mega-", "M"),
    KILO(1.0E+3, 3, "thousand", "kilo-", "k"),
    HECTO(1.0E+2, 2, "hundred", "hecto-", "h"),
    DECA(1.0E+1, 1, "ten", "deca-", "da"),
    UNO(1.0E+0, 0, "", "", ""),
    DECI(1.0E-1, -1, "tenth", "deci-", "d"),
    CENTI(1.0E-2, -2, "hundredth", "centi-", "c"),
    MILLI(1.0E-3, -3, "thousandth", "milli-", "m"),
    MICRO(1.0E-6, -6, "millionth", "micro", "\u00B5"),
    NANO(1.0E-9, -9, "billionth", "nano-", "n"),
    PICO(1.0E-12, -12, "trillionth", "pico-", "p"),
    FEMTO(1.0E-15, -15, "quadrillionth", "femto-", "f"),
    ATTO(1.0E-18, -18, "quintillionth", "atto-", "a"),
    ZEPTO(1.0E-21, -21, "sextillionth", "zepto-", "z"),
    YOCTO(1.0E-24, -24, "septillionth", "yocto-", "y");

    private double factor;
    private int powerOf10;
    private String inWords;
    private String prefixText;
    private String symbol;

    UnitPrefix(double factor, int powerOf10, String inWords, String prefixText, String symbol) {
        this.factor = factor;
        this.powerOf10 = powerOf10;
        this.inWords = inWords;
        this.prefixText = prefixText;
        this.symbol = symbol;
    }

    // find enum UnitPrefix by factor amount
    public static UnitPrefix findByFactor(double factor) throws UnitPrefixException {
        for (UnitPrefix unitPrefix : values()) {
            if (unitPrefix.factor == factor) {
                return unitPrefix;
            }
        }
        throw new UnitPrefixException("No UnitPrefix Enum with factor of " + factor + ".");
    }


    // find enum UnitPrefix by power of 10 amount
    public static UnitPrefix findByPowerOf10(int powerOf10) throws UnitPrefixException {
        for (UnitPrefix unitPrefix : values()) {
            if (unitPrefix.powerOf10 == powerOf10) {
                return unitPrefix;
            }
        }
        throw new UnitPrefixException("No UnitPrefix Enum with power of 10 to the " + powerOf10 + ".");
    }


    // add power of 10 value and get resulting UnitPrefix
    public UnitPrefix addPowerOf10(int powerOf10) throws UnitPrefixException {
        int sumPowerOf10 = this.powerOf10 + powerOf10;
        return findByPowerOf10(sumPowerOf10);
    }


    // sum power of 10 of this UnitPrefix and passed UnitPrefix and get the resulting UnitPrefix
    public UnitPrefix sumUnitPrefixes(UnitPrefix unitPrefix) throws UnitPrefixException {
        int sumPowerOf10 = this.powerOf10 + unitPrefix.powerOf10;
        return findByPowerOf10(sumPowerOf10);
    }


    // subtract passed UnitPrefix from this UnitPrefix and get the resulting UnitPrefix
    public UnitPrefix subtractUnitPrefixes(UnitPrefix unitPrefix) throws UnitPrefixException {
        int differencePowerOf10 = this.powerOf10 - unitPrefix.powerOf10;
        return findByPowerOf10(differencePowerOf10);
    }


    // subtract passed UnitPrefix from this UnitPrefix and return the resulting power of 10
    public int differenceInPowerOf10(UnitPrefix other) {
        return this.powerOf10 - other.powerOf10;
    }


}

