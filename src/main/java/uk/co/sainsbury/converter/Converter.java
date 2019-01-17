package uk.co.sainsbury.converter;

public interface Converter<S, T> {

    T convert(S source);

}
