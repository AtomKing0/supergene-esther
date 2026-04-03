package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class ModalBottomSheetState extends SwipeableState<ModalBottomSheetValue> {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean isSkipHalfExpanded;

    @NotNull
    private final NestedScrollConnection nestedScrollConnection;

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetState$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass1 extends v implements l<ModalBottomSheetValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull ModalBottomSheetValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetState$2, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass2 extends v implements l<ModalBottomSheetValue, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull ModalBottomSheetValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<ModalBottomSheetState, ?> Saver(@NotNull AnimationSpec<Float> animationSpec, boolean z10, @NotNull l<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
            t.i(animationSpec, "animationSpec");
            t.i(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(ModalBottomSheetState$Companion$Saver$1.INSTANCE, new ModalBottomSheetState$Companion$Saver$2(animationSpec, z10, confirmStateChange));
        }

        @NotNull
        public final Saver<ModalBottomSheetState, ?> Saver(@NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
            t.i(animationSpec, "animationSpec");
            t.i(confirmStateChange, "confirmStateChange");
            return Saver(animationSpec, false, confirmStateChange);
        }
    }

    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, boolean z10, l lVar, int i10, k kVar) {
        this(modalBottomSheetValue, (i10 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, z10, (i10 & 8) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }

    @Nullable
    public final Object expand$material_release(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, ModalBottomSheetValue.Expanded, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    public final boolean getHasHalfExpandedState$material_release() {
        return getAnchors$material_release().values().contains(ModalBottomSheetValue.HalfExpanded);
    }

    @NotNull
    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    @Nullable
    public final Object halfExpand$material_release(@NotNull d<? super k0> dVar) {
        if (!getHasHalfExpandedState$material_release()) {
            return k0.f35197a;
        }
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, ModalBottomSheetValue.HalfExpanded, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    @Nullable
    public final Object hide(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, ModalBottomSheetValue.Hidden, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    public final boolean isSkipHalfExpanded$material_release() {
        return this.isSkipHalfExpanded;
    }

    public final boolean isVisible() {
        return getCurrentValue() != ModalBottomSheetValue.Hidden;
    }

    @Nullable
    public final Object show(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, getHasHalfExpandedState$material_release() ? ModalBottomSheetValue.HalfExpanded : ModalBottomSheetValue.Expanded, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetState(@NotNull ModalBottomSheetValue initialValue, @NotNull AnimationSpec<Float> animationSpec, boolean z10, @NotNull l<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
        super(initialValue, animationSpec, confirmStateChange);
        t.i(initialValue, "initialValue");
        t.i(animationSpec, "animationSpec");
        t.i(confirmStateChange, "confirmStateChange");
        this.isSkipHalfExpanded = z10;
        if (z10) {
            if (!(initialValue != ModalBottomSheetValue.HalfExpanded)) {
                throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
            }
        }
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }

    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, l lVar, int i10, k kVar) {
        this(modalBottomSheetValue, (i10 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i10 & 4) != 0 ? AnonymousClass2.INSTANCE : lVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetState(@NotNull ModalBottomSheetValue initialValue, @NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
        this(initialValue, animationSpec, false, confirmStateChange);
        t.i(initialValue, "initialValue");
        t.i(animationSpec, "animationSpec");
        t.i(confirmStateChange, "confirmStateChange");
    }
}
