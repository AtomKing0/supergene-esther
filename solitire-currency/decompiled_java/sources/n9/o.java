package n9;

import kotlin.jvm.internal.t;
import n9.g;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes5.dex */
public class o extends n {
    public static double c(double d10, double d11) {
        return d10 < d11 ? d11 : d10;
    }

    public static float d(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    public static int e(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long f(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    @NotNull
    public static <T extends Comparable<? super T>> T g(@NotNull T t10, @NotNull T minimumValue) {
        t.i(t10, "<this>");
        t.i(minimumValue, "minimumValue");
        return t10.compareTo(minimumValue) < 0 ? minimumValue : t10;
    }

    public static double h(double d10, double d11) {
        return d10 > d11 ? d11 : d10;
    }

    public static float i(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    public static int j(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long k(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static double l(double d10, double d11, double d12) {
        if (d11 <= d12) {
            return d10 < d11 ? d11 : d10 > d12 ? d12 : d10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d12 + " is less than minimum " + d11 + '.');
    }

    public static float m(float f10, float f11, float f12) {
        if (f11 <= f12) {
            return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f12 + " is less than minimum " + f11 + '.');
    }

    public static int n(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static int o(int i10, @NotNull f<Integer> range) {
        t.i(range, "range");
        if (range instanceof e) {
            return ((Number) q(Integer.valueOf(i10), (e) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i10 < ((Number) range.getStart()).intValue() ? ((Number) range.getStart()).intValue() : i10 > ((Number) range.getEndInclusive()).intValue() ? ((Number) range.getEndInclusive()).intValue() : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static long p(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + '.');
    }

    @NotNull
    public static <T extends Comparable<? super T>> T q(@NotNull T t10, @NotNull e<T> range) {
        t.i(t10, "<this>");
        t.i(range, "range");
        if (!range.isEmpty()) {
            return (!range.a(t10, range.getStart()) || range.a(range.getStart(), t10)) ? (!range.a(range.getEndInclusive(), t10) || range.a(t10, range.getEndInclusive())) ? t10 : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @NotNull
    public static g r(int i10, int i11) {
        return g.f31721d.a(i10, i11, -1);
    }

    @NotNull
    public static g s(@NotNull g gVar) {
        t.i(gVar, "<this>");
        return g.f31721d.a(gVar.e(), gVar.b(), -gVar.f());
    }

    @NotNull
    public static g t(@NotNull g gVar, int i10) {
        t.i(gVar, "<this>");
        n.a(i10 > 0, Integer.valueOf(i10));
        g.a aVar = g.f31721d;
        int iB = gVar.b();
        int iE = gVar.e();
        if (gVar.f() <= 0) {
            i10 = -i10;
        }
        return aVar.a(iB, iE, i10);
    }

    @NotNull
    public static i u(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? i.f31729e.a() : new i(i10, i11 - 1);
    }
}
