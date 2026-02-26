package q9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DurationUnitJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
class f {
    public static final double a(double d10, @NotNull e sourceUnit, @NotNull e targetUnit) {
        t.i(sourceUnit, "sourceUnit");
        t.i(targetUnit, "targetUnit");
        long jConvert = targetUnit.c().convert(1L, sourceUnit.c());
        return jConvert > 0 ? d10 * jConvert : d10 / sourceUnit.c().convert(1L, targetUnit.c());
    }

    public static final long b(long j10, @NotNull e sourceUnit, @NotNull e targetUnit) {
        t.i(sourceUnit, "sourceUnit");
        t.i(targetUnit, "targetUnit");
        return targetUnit.c().convert(j10, sourceUnit.c());
    }

    public static final long c(long j10, @NotNull e sourceUnit, @NotNull e targetUnit) {
        t.i(sourceUnit, "sourceUnit");
        t.i(targetUnit, "targetUnit");
        return targetUnit.c().convert(j10, sourceUnit.c());
    }
}
