package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MutableCounter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DeltaCounter {
    private int count;

    public DeltaCounter() {
        this(0, 1, null);
    }

    public static /* synthetic */ DeltaCounter copy$default(DeltaCounter deltaCounter, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = deltaCounter.count;
        }
        return deltaCounter.copy(i10);
    }

    public final int component1() {
        return this.count;
    }

    @NotNull
    public final DeltaCounter copy(int i10) {
        return new DeltaCounter(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeltaCounter) && this.count == ((DeltaCounter) obj).count;
    }

    public final int getCount() {
        return this.count;
    }

    public int hashCode() {
        return this.count;
    }

    public final void plusAssign(int i10) {
        this.count += i10;
    }

    public final void setCount(int i10) {
        this.count = i10;
    }

    @NotNull
    public String toString() {
        return "DeltaCounter(count=" + this.count + ')';
    }

    public DeltaCounter(int i10) {
        this.count = i10;
    }

    public /* synthetic */ DeltaCounter(int i10, int i11, k kVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
