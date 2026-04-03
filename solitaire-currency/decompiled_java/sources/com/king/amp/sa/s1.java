package com.king.amp.sa;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Optional.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f16940a;

    private s1(T t10) {
        this.f16940a = t10;
    }

    public static <T> s1<T> a() {
        return new s1<>(null);
    }

    public static <T> s1<T> d(T t10) {
        if (t10 != null) {
            return new s1<>(t10);
        }
        throw new NullPointerException("Value cannot be null");
    }

    public T b() {
        T t10 = this.f16940a;
        if (t10 != null) {
            return t10;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.f16940a != null;
    }

    public T e(T t10) {
        T t11 = this.f16940a;
        return t11 != null ? t11 : t10;
    }

    public String toString() {
        T t10 = this.f16940a;
        return t10 != null ? String.format("Optional[%s]", t10) : "Optional.empty";
    }
}
