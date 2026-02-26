package v8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ULong.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e0 implements Comparable<e0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f35179b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35180a;

    /* JADX INFO: compiled from: ULong.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    private /* synthetic */ e0(long j10) {
        this.f35180a = j10;
    }

    public static final /* synthetic */ e0 a(long j10) {
        return new e0(j10);
    }

    public static boolean d(long j10, Object obj) {
        return (obj instanceof e0) && j10 == ((e0) obj).g();
    }

    public static int e(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @NotNull
    public static String f(long j10) {
        return m0.f(j10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(e0 e0Var) {
        return m0.d(g(), e0Var.g());
    }

    public boolean equals(Object obj) {
        return d(this.f35180a, obj);
    }

    public final /* synthetic */ long g() {
        return this.f35180a;
    }

    public int hashCode() {
        return e(this.f35180a);
    }

    @NotNull
    public String toString() {
        return f(this.f35180a);
    }

    public static long c(long j10) {
        return j10;
    }
}
