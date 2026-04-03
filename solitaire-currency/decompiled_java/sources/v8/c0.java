package v8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UInt.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 implements Comparable<c0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f35170b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35171a;

    /* JADX INFO: compiled from: UInt.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    private /* synthetic */ c0(int i10) {
        this.f35171a = i10;
    }

    public static final /* synthetic */ c0 a(int i10) {
        return new c0(i10);
    }

    public static boolean d(int i10, Object obj) {
        return (obj instanceof c0) && i10 == ((c0) obj).g();
    }

    @NotNull
    public static String f(int i10) {
        return String.valueOf(((long) i10) & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(c0 c0Var) {
        return m0.b(g(), c0Var.g());
    }

    public boolean equals(Object obj) {
        return d(this.f35171a, obj);
    }

    public final /* synthetic */ int g() {
        return this.f35171a;
    }

    public int hashCode() {
        return e(this.f35171a);
    }

    @NotNull
    public String toString() {
        return f(this.f35171a);
    }

    public static int c(int i10) {
        return i10;
    }

    public static int e(int i10) {
        return i10;
    }
}
