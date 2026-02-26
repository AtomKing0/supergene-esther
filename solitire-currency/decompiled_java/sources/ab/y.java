package ab;

import ga.e0;
import java.util.Objects;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes5.dex */
public final class y<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ga.d0 f565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e0 f567c;

    private y(ga.d0 d0Var, T t10, e0 e0Var) {
        this.f565a = d0Var;
        this.f566b = t10;
        this.f567c = e0Var;
    }

    public static <T> y<T> c(e0 e0Var, ga.d0 d0Var) {
        Objects.requireNonNull(e0Var, "body == null");
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.O()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new y<>(d0Var, null, e0Var);
    }

    public static <T> y<T> g(T t10, ga.d0 d0Var) {
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.O()) {
            return new y<>(d0Var, t10, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f566b;
    }

    public int b() {
        return this.f565a.q();
    }

    public boolean d() {
        return this.f565a.O();
    }

    public String e() {
        return this.f565a.R();
    }

    public ga.d0 f() {
        return this.f565a;
    }

    public String toString() {
        return this.f565a.toString();
    }
}
