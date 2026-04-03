package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class DrawerState {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final SwipeableState<DrawerValue> swipeableState;

    /* JADX INFO: renamed from: androidx.compose.material.DrawerState$1, reason: invalid class name */
    /* JADX INFO: compiled from: Drawer.kt */
    static final class AnonymousClass1 extends v implements l<DrawerValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull DrawerValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: Drawer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<DrawerState, DrawerValue> Saver(@NotNull l<? super DrawerValue, Boolean> confirmStateChange) {
            t.i(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(DrawerState$Companion$Saver$1.INSTANCE, new DrawerState$Companion$Saver$2(confirmStateChange));
        }
    }

    public DrawerState(@NotNull DrawerValue initialValue, @NotNull l<? super DrawerValue, Boolean> confirmStateChange) {
        t.i(initialValue, "initialValue");
        t.i(confirmStateChange, "confirmStateChange");
        this.swipeableState = new SwipeableState<>(initialValue, DrawerKt.AnimationSpec, confirmStateChange);
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object animateTo(@NotNull DrawerValue drawerValue, @NotNull AnimationSpec<Float> animationSpec, @NotNull d<? super k0> dVar) {
        Object objAnimateTo = this.swipeableState.animateTo(drawerValue, animationSpec, dVar);
        return objAnimateTo == a9.d.e() ? objAnimateTo : k0.f35197a;
    }

    @Nullable
    public final Object close(@NotNull d<? super k0> dVar) {
        Object objAnimateTo = animateTo(DrawerValue.Closed, DrawerKt.AnimationSpec, dVar);
        return objAnimateTo == a9.d.e() ? objAnimateTo : k0.f35197a;
    }

    @NotNull
    public final DrawerValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    @ExperimentalMaterialApi
    @NotNull
    public final State<Float> getOffset() {
        return this.swipeableState.getOffset();
    }

    @NotNull
    public final SwipeableState<DrawerValue> getSwipeableState$material_release() {
        return this.swipeableState;
    }

    @ExperimentalMaterialApi
    @NotNull
    public final DrawerValue getTargetValue() {
        return this.swipeableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.swipeableState.isAnimationRunning();
    }

    public final boolean isClosed() {
        return getCurrentValue() == DrawerValue.Closed;
    }

    public final boolean isOpen() {
        return getCurrentValue() == DrawerValue.Open;
    }

    @Nullable
    public final Object open(@NotNull d<? super k0> dVar) {
        Object objAnimateTo = animateTo(DrawerValue.Open, DrawerKt.AnimationSpec, dVar);
        return objAnimateTo == a9.d.e() ? objAnimateTo : k0.f35197a;
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object snapTo(@NotNull DrawerValue drawerValue, @NotNull d<? super k0> dVar) {
        Object objSnapTo = this.swipeableState.snapTo(drawerValue, dVar);
        return objSnapTo == a9.d.e() ? objSnapTo : k0.f35197a;
    }

    public /* synthetic */ DrawerState(DrawerValue drawerValue, l lVar, int i10, k kVar) {
        this(drawerValue, (i10 & 2) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getOffset$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getTargetValue$annotations() {
    }
}
