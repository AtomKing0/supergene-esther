package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.ScrollKt$rememberScrollState$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scroll.kt */
    static final class AnonymousClass1 extends v implements h9.a<ScrollState> {
        final /* synthetic */ int $initial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10) {
            super(0);
            this.$initial = i10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ScrollState invoke() {
            return new ScrollState(this.$initial);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ScrollKt$scroll$2, reason: invalid class name */
    /* JADX INFO: compiled from: Scroll.kt */
    static final class AnonymousClass2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ boolean $isScrollable;
        final /* synthetic */ boolean $isVertical;
        final /* synthetic */ boolean $reverseScrolling;
        final /* synthetic */ ScrollState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z10, ScrollState scrollState, boolean z11, FlingBehavior flingBehavior, boolean z12) {
            super(3);
            this.$isVertical = z10;
            this.$state = scrollState;
            this.$isScrollable = z11;
            this.$flingBehavior = flingBehavior;
            this.$reverseScrolling = z12;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1478351300);
            OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(composer, 6);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(z8.h.f37608a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, new ScrollKt$scroll$2$semantics$1(this.$reverseScrolling, this.$isVertical, this.$isScrollable, this.$state, coroutineScope), 1, null);
            boolean z10 = this.$isVertical;
            Orientation orientation = z10 ? Orientation.Vertical : Orientation.Horizontal;
            boolean z11 = !this.$reverseScrolling;
            Modifier modifierThen = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(modifierSemantics$default, orientation), overscrollEffect).then(ScrollableKt.scrollable(companion, this.$state, orientation, overscrollEffect, this.$isScrollable, (!(composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) || z10) ? z11 : !z11, this.$flingBehavior, this.$state.getInternalInteractionSource$foundation_release())).then(new ScrollingLayoutModifier(this.$state, this.$reverseScrolling, this.$isVertical, overscrollEffect));
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    @NotNull
    public static final Modifier horizontalScroll(@NotNull Modifier modifier, @NotNull ScrollState state, boolean z10, @Nullable FlingBehavior flingBehavior, boolean z11) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        return scroll(modifier, state, z11, flingBehavior, z10, false);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            flingBehavior = null;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return horizontalScroll(modifier, scrollState, z10, flingBehavior, z11);
    }

    @Composable
    @NotNull
    public static final ScrollState rememberScrollState(int i10, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-1464256199);
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        ScrollState scrollState = (ScrollState) RememberSaveableKt.m1271rememberSaveable(new Object[0], (Saver) ScrollState.Companion.getSaver(), (String) null, (h9.a) new AnonymousClass1(i10), composer, 72, 4);
        composer.endReplaceableGroup();
        return scrollState;
    }

    private static final Modifier scroll(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, boolean z12) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ScrollKt$scroll$$inlined$debugInspectorInfo$1(scrollState, z10, flingBehavior, z11, z12) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(z12, scrollState, z11, flingBehavior, z10));
    }

    @NotNull
    public static final Modifier verticalScroll(@NotNull Modifier modifier, @NotNull ScrollState state, boolean z10, @Nullable FlingBehavior flingBehavior, boolean z11) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        return scroll(modifier, state, z11, flingBehavior, z10, true);
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            flingBehavior = null;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return verticalScroll(modifier, scrollState, z10, flingBehavior, z11);
    }
}
