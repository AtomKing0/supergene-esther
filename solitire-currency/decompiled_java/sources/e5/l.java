package e5;

import java.io.Serializable;

/* JADX INFO: compiled from: Optional.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<T> implements Serializable {
    l() {
    }

    public static <T> l<T> a() {
        return a.e();
    }

    public static <T> l<T> d(T t10) {
        return new r(o.j(t10));
    }

    public abstract T b();

    public abstract boolean c();
}
