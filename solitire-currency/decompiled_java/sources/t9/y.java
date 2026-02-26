package t9;

import org.jetbrains.annotations.NotNull;
import s9.d0;
import s9.m0;

/* JADX INFO: compiled from: AbstractSharedFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
final class y extends d0<Integer> implements m0<Integer> {
    public y(int i10) {
        super(1, Integer.MAX_VALUE, r9.a.DROP_OLDEST);
        a(Integer.valueOf(i10));
    }

    @Override // s9.m0
    @NotNull
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(L().intValue());
        }
        return numValueOf;
    }

    public final boolean Z(int i10) {
        boolean zA;
        synchronized (this) {
            zA = a(Integer.valueOf(L().intValue() + i10));
        }
        return zA;
    }
}
