package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ForEachOneBit.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ForEachOneBitKt {
    public static final void forEachOneBit(int i10, @NotNull p<? super Integer, ? super Integer, k0> body) {
        t.i(body, "body");
        int i11 = 0;
        while (i10 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i10);
            body.mo4invoke(Integer.valueOf(iLowestOneBit), Integer.valueOf(i11));
            i11++;
            i10 ^= iLowestOneBit;
        }
    }
}
