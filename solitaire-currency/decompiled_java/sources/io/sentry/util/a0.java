package io.sentry.util;

import io.sentry.x8;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SampleRateUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a0 {
    @NotNull
    public static x8 a(@NotNull x8 x8Var) {
        if (x8Var.c() != null) {
            return x8Var;
        }
        return new x8(x8Var.e(), x8Var.d(), b(null, x8Var.d(), x8Var.e()), x8Var.b(), x8Var.a());
    }

    @NotNull
    public static Double b(@Nullable Double d10, @Nullable Double d11, @Nullable Boolean bool) {
        if (d10 != null) {
            return d10;
        }
        double d12 = b0.a().d();
        return (d11 == null || bool == null) ? Double.valueOf(d12) : bool.booleanValue() ? Double.valueOf(d12 * d11.doubleValue()) : Double.valueOf(d11.doubleValue() + (d12 * (1.0d - d11.doubleValue())));
    }

    public static boolean c(@Nullable Double d10) {
        return e(d10, true);
    }

    public static boolean d(@Nullable Double d10) {
        return e(d10, true);
    }

    private static boolean e(@Nullable Double d10, boolean z10) {
        return d10 == null ? z10 : !d10.isNaN() && d10.doubleValue() >= 0.0d && d10.doubleValue() <= 1.0d;
    }

    public static boolean f(@Nullable Double d10) {
        return e(d10, true);
    }

    public static boolean g(@Nullable Double d10) {
        return h(d10, true);
    }

    public static boolean h(@Nullable Double d10, boolean z10) {
        return e(d10, z10);
    }
}
