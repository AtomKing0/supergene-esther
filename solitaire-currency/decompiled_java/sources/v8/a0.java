package v8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UByte.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a0 implements Comparable<a0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f35164b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f35165a;

    /* JADX INFO: compiled from: UByte.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    private /* synthetic */ a0(byte b10) {
        this.f35165a = b10;
    }

    public static final /* synthetic */ a0 a(byte b10) {
        return new a0(b10);
    }

    public static boolean d(byte b10, Object obj) {
        return (obj instanceof a0) && b10 == ((a0) obj).g();
    }

    @NotNull
    public static String f(byte b10) {
        return String.valueOf(b10 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a0 a0Var) {
        return kotlin.jvm.internal.t.k(g() & 255, a0Var.g() & 255);
    }

    public boolean equals(Object obj) {
        return d(this.f35165a, obj);
    }

    public final /* synthetic */ byte g() {
        return this.f35165a;
    }

    public int hashCode() {
        return e(this.f35165a);
    }

    @NotNull
    public String toString() {
        return f(this.f35165a);
    }

    public static byte c(byte b10) {
        return b10;
    }

    public static int e(byte b10) {
        return b10;
    }
}
