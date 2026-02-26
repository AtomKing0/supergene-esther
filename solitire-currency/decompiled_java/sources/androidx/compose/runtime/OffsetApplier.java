package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.h;

/* JADX INFO: compiled from: Applier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OffsetApplier<N> implements Applier<N> {

    @NotNull
    private final Applier<N> applier;
    private int nesting;
    private final int offset;

    public OffsetApplier(@NotNull Applier<N> applier, int i10) {
        t.i(applier, "applier");
        this.applier = applier;
        this.offset = i10;
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        ComposerKt.composeRuntimeError("Clear is not valid on OffsetApplier".toString());
        throw new h();
    }

    @Override // androidx.compose.runtime.Applier
    public void down(N n10) {
        this.nesting++;
        this.applier.down(n10);
    }

    @Override // androidx.compose.runtime.Applier
    public N getCurrent() {
        return this.applier.getCurrent();
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i10, N n10) {
        this.applier.insertBottomUp(i10 + (this.nesting == 0 ? this.offset : 0), n10);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i10, N n10) {
        this.applier.insertTopDown(i10 + (this.nesting == 0 ? this.offset : 0), n10);
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i10, int i11, int i12) {
        int i13 = this.nesting == 0 ? this.offset : 0;
        this.applier.move(i10 + i13, i11 + i13, i12);
    }

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onBeginChanges() {
        a.a(this);
    }

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onEndChanges() {
        a.b(this);
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i10, int i11) {
        this.applier.remove(i10 + (this.nesting == 0 ? this.offset : 0), i11);
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        int i10 = this.nesting;
        if (!(i10 > 0)) {
            ComposerKt.composeRuntimeError("OffsetApplier up called with no corresponding down".toString());
            throw new h();
        }
        this.nesting = i10 - 1;
        this.applier.up();
    }
}
