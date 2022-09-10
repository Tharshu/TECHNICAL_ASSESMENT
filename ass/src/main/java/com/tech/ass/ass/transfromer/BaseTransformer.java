package com.tech.ass.ass.transfromer;

public interface BaseTransformer<T, I> {

	I transform(T type);

	T reverseTransform(I type);


}