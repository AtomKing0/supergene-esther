package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BoxWithConstraints.kt */
/* JADX INFO: loaded from: classes.dex */
final class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {
    private final /* synthetic */ BoxScopeInstance $$delegate_0;
    private final long constraints;

    @NotNull
    private final Density density;

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density density, long j10, kotlin.jvm.internal.k kVar) {
        this(density, j10);
    }

    private final Density component1() {
        return this.density;
    }

    /* JADX INFO: renamed from: copy-0kLqBqw$default, reason: not valid java name */
    public static /* synthetic */ BoxWithConstraintsScopeImpl m376copy0kLqBqw$default(BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Density density, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            density = boxWithConstraintsScopeImpl.density;
        }
        if ((i10 & 2) != 0) {
            j10 = boxWithConstraintsScopeImpl.mo371getConstraintsmsEJaDk();
        }
        return boxWithConstraintsScopeImpl.m378copy0kLqBqw(density, j10);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    @Stable
    @NotNull
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment) {
        t.i(modifier, "<this>");
        t.i(alignment, "alignment");
        return this.$$delegate_0.align(modifier, alignment);
    }

    /* JADX INFO: renamed from: component2-msEJaDk, reason: not valid java name */
    public final long m377component2msEJaDk() {
        return mo371getConstraintsmsEJaDk();
    }

    @NotNull
    /* JADX INFO: renamed from: copy-0kLqBqw, reason: not valid java name */
    public final BoxWithConstraintsScopeImpl m378copy0kLqBqw(@NotNull Density density, long j10) {
        t.i(density, "density");
        return new BoxWithConstraintsScopeImpl(density, j10, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        return t.d(this.density, boxWithConstraintsScopeImpl.density) && Constraints.m3634equalsimpl0(mo371getConstraintsmsEJaDk(), boxWithConstraintsScopeImpl.mo371getConstraintsmsEJaDk());
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo371getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM */
    public float mo372getMaxHeightD9Ej5fM() {
        return Constraints.m3636getHasBoundedHeightimpl(mo371getConstraintsmsEJaDk()) ? this.density.mo293toDpu2uoSUM(Constraints.m3640getMaxHeightimpl(mo371getConstraintsmsEJaDk())) : Dp.Companion.m3692getInfinityD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM */
    public float mo373getMaxWidthD9Ej5fM() {
        return Constraints.m3637getHasBoundedWidthimpl(mo371getConstraintsmsEJaDk()) ? this.density.mo293toDpu2uoSUM(Constraints.m3641getMaxWidthimpl(mo371getConstraintsmsEJaDk())) : Dp.Companion.m3692getInfinityD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM */
    public float mo374getMinHeightD9Ej5fM() {
        return this.density.mo293toDpu2uoSUM(Constraints.m3642getMinHeightimpl(mo371getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM */
    public float mo375getMinWidthD9Ej5fM() {
        return this.density.mo293toDpu2uoSUM(Constraints.m3643getMinWidthimpl(mo371getConstraintsmsEJaDk()));
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m3644hashCodeimpl(mo371getConstraintsmsEJaDk());
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    @Stable
    @NotNull
    public Modifier matchParentSize(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return this.$$delegate_0.matchParentSize(modifier);
    }

    @NotNull
    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + ((Object) Constraints.m3646toStringimpl(mo371getConstraintsmsEJaDk())) + ')';
    }

    private BoxWithConstraintsScopeImpl(Density density, long j10) {
        this.density = density;
        this.constraints = j10;
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
    }
}
