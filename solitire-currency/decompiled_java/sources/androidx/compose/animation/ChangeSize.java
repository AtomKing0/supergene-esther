package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ChangeSize {

    @NotNull
    private final Alignment alignment;

    @NotNull
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final boolean clip;

    @NotNull
    private final l<IntSize, IntSize> size;

    /* JADX INFO: renamed from: androidx.compose.animation.ChangeSize$1, reason: invalid class name */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class AnonymousClass1 extends v implements l<IntSize, IntSize> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
            return IntSize.m3825boximpl(m38invokemzRDjE0(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m38invokemzRDjE0(long j10) {
            return IntSizeKt.IntSize(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChangeSize(@NotNull Alignment alignment, @NotNull l<? super IntSize, IntSize> size, @NotNull FiniteAnimationSpec<IntSize> animationSpec, boolean z10) {
        t.i(alignment, "alignment");
        t.i(size, "size");
        t.i(animationSpec, "animationSpec");
        this.alignment = alignment;
        this.size = size;
        this.animationSpec = animationSpec;
        this.clip = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeSize copy$default(ChangeSize changeSize, Alignment alignment, l lVar, FiniteAnimationSpec finiteAnimationSpec, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            alignment = changeSize.alignment;
        }
        if ((i10 & 2) != 0) {
            lVar = changeSize.size;
        }
        if ((i10 & 4) != 0) {
            finiteAnimationSpec = changeSize.animationSpec;
        }
        if ((i10 & 8) != 0) {
            z10 = changeSize.clip;
        }
        return changeSize.copy(alignment, lVar, finiteAnimationSpec, z10);
    }

    @NotNull
    public final Alignment component1() {
        return this.alignment;
    }

    @NotNull
    public final l<IntSize, IntSize> component2() {
        return this.size;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> component3() {
        return this.animationSpec;
    }

    public final boolean component4() {
        return this.clip;
    }

    @NotNull
    public final ChangeSize copy(@NotNull Alignment alignment, @NotNull l<? super IntSize, IntSize> size, @NotNull FiniteAnimationSpec<IntSize> animationSpec, boolean z10) {
        t.i(alignment, "alignment");
        t.i(size, "size");
        t.i(animationSpec, "animationSpec");
        return new ChangeSize(alignment, size, animationSpec, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeSize)) {
            return false;
        }
        ChangeSize changeSize = (ChangeSize) obj;
        return t.d(this.alignment, changeSize.alignment) && t.d(this.size, changeSize.size) && t.d(this.animationSpec, changeSize.animationSpec) && this.clip == changeSize.clip;
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getClip() {
        return this.clip;
    }

    @NotNull
    public final l<IntSize, IntSize> getSize() {
        return this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.alignment.hashCode() * 31) + this.size.hashCode()) * 31) + this.animationSpec.hashCode()) * 31;
        boolean z10 = this.clip;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    @NotNull
    public String toString() {
        return "ChangeSize(alignment=" + this.alignment + ", size=" + this.size + ", animationSpec=" + this.animationSpec + ", clip=" + this.clip + ')';
    }

    public /* synthetic */ ChangeSize(Alignment alignment, l lVar, FiniteAnimationSpec finiteAnimationSpec, boolean z10, int i10, k kVar) {
        this(alignment, (i10 & 2) != 0 ? AnonymousClass1.INSTANCE : lVar, finiteAnimationSpec, (i10 & 8) != 0 ? true : z10);
    }
}
