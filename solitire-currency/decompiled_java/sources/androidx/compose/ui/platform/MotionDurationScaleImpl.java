package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.MotionDurationScale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class MotionDurationScaleImpl implements MotionDurationScale {

    @NotNull
    private final MutableState scaleFactor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);

    @Override // androidx.compose.ui.MotionDurationScale, z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) MotionDurationScale.DefaultImpls.fold(this, r10, pVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) MotionDurationScale.DefaultImpls.get(this, cVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, z8.g.b
    public /* synthetic */ g.c getKey() {
        return androidx.compose.ui.c.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.MotionDurationScale
    public float getScaleFactor() {
        return ((Number) this.scaleFactor$delegate.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.MotionDurationScale, z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return MotionDurationScale.DefaultImpls.minusKey(this, cVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g gVar) {
        return MotionDurationScale.DefaultImpls.plus(this, gVar);
    }

    public void setScaleFactor(float f10) {
        this.scaleFactor$delegate.setValue(Float.valueOf(f10));
    }
}
