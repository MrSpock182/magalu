package io.com.github.mrspock182.magalu.adapter;

public interface Adapter<T1, T2> {
    T1 cast(T2 t2);
}
