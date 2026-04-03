package q9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import q9.a;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f33196a = new k();

    private k() {
    }

    public long a() {
        return i.f33194a.c();
    }

    @NotNull
    public String toString() {
        return i.f33194a.toString();
    }

    /* JADX INFO: compiled from: TimeSource.kt */
    public static final class a implements q9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f33197a;

        private /* synthetic */ a(long j10) {
            this.f33197a = j10;
        }

        public static final /* synthetic */ a c(long j10) {
            return new a(j10);
        }

        public static long f(long j10) {
            return i.f33194a.b(j10);
        }

        public static boolean g(long j10, Object obj) {
            return (obj instanceof a) && j10 == ((a) obj).l();
        }

        public static int h(long j10) {
            return androidx.compose.animation.a.a(j10);
        }

        public static final long i(long j10, long j11) {
            return i.f33194a.a(j10, j11);
        }

        public static long j(long j10, @NotNull q9.a other) {
            t.i(other, "other");
            if (other instanceof a) {
                return i(j10, ((a) other).l());
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) k(j10)) + " and " + other);
        }

        public static String k(long j10) {
            return "ValueTimeMark(reading=" + j10 + ')';
        }

        @Override // q9.j
        public long a() {
            return f(this.f33197a);
        }

        @Override // q9.a
        public long b(@NotNull q9.a other) {
            t.i(other, "other");
            return j(this.f33197a, other);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull q9.a aVar) {
            return a.C0661a.a(this, aVar);
        }

        public boolean equals(Object obj) {
            return g(this.f33197a, obj);
        }

        public int hashCode() {
            return h(this.f33197a);
        }

        public final /* synthetic */ long l() {
            return this.f33197a;
        }

        public String toString() {
            return k(this.f33197a);
        }

        public static long e(long j10) {
            return j10;
        }
    }
}
