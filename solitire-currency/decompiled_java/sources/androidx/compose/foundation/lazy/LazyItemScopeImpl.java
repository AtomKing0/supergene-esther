package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyItemScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyItemScopeImpl implements LazyItemScope {

    @NotNull
    private final MutableState maxHeight$delegate;

    @NotNull
    private final MutableState maxWidth$delegate;

    public LazyItemScopeImpl() {
        Dp.Companion companion = Dp.Companion;
        this.maxWidth$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m3671boximpl(companion.m3693getUnspecifiedD9Ej5fM()), null, 2, null);
        this.maxHeight$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m3671boximpl(companion.m3693getUnspecifiedD9Ej5fM()), null, 2, null);
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    @ExperimentalFoundationApi
    @NotNull
    public Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> animationSpec) {
        t.i(modifier, "<this>");
        t.i(animationSpec, "animationSpec");
        return modifier.then(new AnimateItemPlacementModifier(animationSpec, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LazyItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1(animationSpec) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    @NotNull
    public Modifier fillParentMaxHeight(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return SizeKt.m426height3ABfNKs(modifier, Dp.m3673constructorimpl(m500getMaxHeightD9Ej5fM() * f10));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    @NotNull
    public Modifier fillParentMaxSize(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return SizeKt.m442sizeVpY3zN4(modifier, Dp.m3673constructorimpl(m501getMaxWidthD9Ej5fM() * f10), Dp.m3673constructorimpl(m500getMaxHeightD9Ej5fM() * f10));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    @NotNull
    public Modifier fillParentMaxWidth(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return SizeKt.m445width3ABfNKs(modifier, Dp.m3673constructorimpl(m501getMaxWidthD9Ej5fM() * f10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public final float m500getMaxHeightD9Ej5fM() {
        return ((Dp) this.maxHeight$delegate.getValue()).m3687unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m501getMaxWidthD9Ej5fM() {
        return ((Dp) this.maxWidth$delegate.getValue()).m3687unboximpl();
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m502setMaxHeight0680j_4(float f10) {
        this.maxHeight$delegate.setValue(Dp.m3671boximpl(f10));
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m503setMaxWidth0680j_4(float f10) {
        this.maxWidth$delegate.setValue(Dp.m3671boximpl(f10));
    }
}
