package uk.co.sainsbury.usecase;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Total {
    @SerializedName("gross")
    private final BigDecimal gross;

    @SerializedName("vat")
    private final BigDecimal vat;

    public Total(BigDecimal gross, BigDecimal vat) {
        this.gross = gross;
        this.vat = vat;
    }

    public BigDecimal getGross() {
        return gross;
    }

    public BigDecimal getVat() {
        return vat;
    }
}
