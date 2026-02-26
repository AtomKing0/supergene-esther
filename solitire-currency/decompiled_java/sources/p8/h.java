package p8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Buffers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    @NotNull
    public static final q8.a a(@NotNull q8.a aVar) {
        t.i(aVar, "<this>");
        while (true) {
            q8.a aVarX = aVar.x();
            if (aVarX == null) {
                return aVar;
            }
            aVar = aVarX;
        }
    }

    public static final void b(@Nullable q8.a aVar, @NotNull s8.g<q8.a> pool) {
        t.i(pool, "pool");
        while (aVar != null) {
            q8.a aVarW = aVar.w();
            aVar.A(pool);
            aVar = aVarW;
        }
    }

    public static final long c(@NotNull q8.a aVar) {
        t.i(aVar, "<this>");
        return d(aVar, 0L);
    }

    private static final long d(q8.a aVar, long j10) {
        do {
            j10 += (long) (aVar.j() - aVar.h());
            aVar = aVar.x();
        } while (aVar != null);
        return j10;
    }
}
