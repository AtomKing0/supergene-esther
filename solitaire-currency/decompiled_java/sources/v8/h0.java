package v8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UShort.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h0 implements Comparable<h0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f35185b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final short f35186a;

    /* JADX INFO: compiled from: UShort.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    private /* synthetic */ h0(short s10) {
        this.f35186a = s10;
    }

    public static final /* synthetic */ h0 a(short s10) {
        return new h0(s10);
    }

    public static boolean d(short s10, Object obj) {
        return (obj instanceof h0) && s10 == ((h0) obj).g();
    }

    @NotNull
    public static String f(short s10) {
        return String.valueOf(s10 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h0 h0Var) {
        return kotlin.jvm.internal.t.k(g() & 65535, h0Var.g() & 65535);
    }

    public boolean equals(Object obj) {
        return d(this.f35186a, obj);
    }

    public final /* synthetic */ short g() {
        return this.f35186a;
    }

    public int hashCode() {
        return e(this.f35186a);
    }

    @NotNull
    public String toString() {
        return f(this.f35186a);
    }

    public static short c(short s10) {
        return s10;
    }

    public static int e(short s10) {
        return s10;
    }
}
