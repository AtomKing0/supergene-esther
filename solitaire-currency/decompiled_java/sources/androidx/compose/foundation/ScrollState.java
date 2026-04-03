package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class ScrollState implements ScrollableState {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Saver<ScrollState, ?> Saver = SaverKt.Saver(ScrollState$Companion$Saver$1.INSTANCE, ScrollState$Companion$Saver$2.INSTANCE);
    private float accumulator;

    @NotNull
    private final MutableState value$delegate;

    @NotNull
    private final MutableInteractionSource internalInteractionSource = InteractionSourceKt.MutableInteractionSource();

    @NotNull
    private MutableState<Integer> _maxValueState = SnapshotStateKt.mutableStateOf(Integer.MAX_VALUE, SnapshotStateKt.structuralEqualityPolicy());

    @NotNull
    private final ScrollableState scrollableState = ScrollableStateKt.ScrollableState(new ScrollState$scrollableState$1(this));

    /* JADX INFO: compiled from: Scroll.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final Saver<ScrollState, ?> getSaver() {
            return ScrollState.Saver;
        }
    }

    public ScrollState(int i10) {
        this.value$delegate = SnapshotStateKt.mutableStateOf(Integer.valueOf(i10), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollTo$default(ScrollState scrollState, int i10, AnimationSpec animationSpec, z8.d dVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 0.0f, null, 7, null);
        }
        return scrollState.animateScrollTo(i10, animationSpec, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setValue(int i10) {
        this.value$delegate.setValue(Integer.valueOf(i10));
    }

    @Nullable
    public final Object animateScrollTo(int i10, @NotNull AnimationSpec<Float> animationSpec, @NotNull z8.d<? super k0> dVar) {
        Object objAnimateScrollBy = ScrollExtensionsKt.animateScrollBy(this, i10 - getValue(), animationSpec, dVar);
        return objAnimateScrollBy == a9.d.e() ? objAnimateScrollBy : k0.f35197a;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float f10) {
        return this.scrollableState.dispatchRawDelta(f10);
    }

    @NotNull
    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    @NotNull
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final int getMaxValue() {
        return this._maxValueState.getValue().intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getValue() {
        return ((Number) this.value$delegate.getValue()).intValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    @Nullable
    public Object scroll(@NotNull MutatePriority mutatePriority, @NotNull h9.p<? super ScrollScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, pVar, dVar);
        return objScroll == a9.d.e() ? objScroll : k0.f35197a;
    }

    @Nullable
    public final Object scrollTo(int i10, @NotNull z8.d<? super Float> dVar) {
        return ScrollExtensionsKt.scrollBy(this, i10 - getValue(), dVar);
    }

    public final void setMaxValue$foundation_release(int i10) {
        this._maxValueState.setValue(Integer.valueOf(i10));
        if (getValue() > i10) {
            setValue(i10);
        }
    }
}
