package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Stable;
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

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public final class BottomSheetState extends SwipeableState<BottomSheetValue> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final NestedScrollConnection nestedScrollConnection;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetState$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass1 extends v implements l<BottomSheetValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull BottomSheetValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<BottomSheetState, ?> Saver(@NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super BottomSheetValue, Boolean> confirmStateChange) {
            t.i(animationSpec, "animationSpec");
            t.i(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(BottomSheetState$Companion$Saver$1.INSTANCE, new BottomSheetState$Companion$Saver$2(animationSpec, confirmStateChange));
        }
    }

    public /* synthetic */ BottomSheetState(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, l lVar, int i10, k kVar) {
        this(bottomSheetValue, (i10 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i10 & 4) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }

    @Nullable
    public final Object collapse(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, BottomSheetValue.Collapsed, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    @Nullable
    public final Object expand(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, getHasExpandedState$material_release() ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    public final boolean getHasExpandedState$material_release() {
        return getAnchors$material_release().containsValue(BottomSheetValue.Expanded);
    }

    @NotNull
    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    public final boolean isCollapsed() {
        return getCurrentValue() == BottomSheetValue.Collapsed;
    }

    public final boolean isExpanded() {
        return getCurrentValue() == BottomSheetValue.Expanded;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetState(@NotNull BottomSheetValue initialValue, @NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super BottomSheetValue, Boolean> confirmStateChange) {
        super(initialValue, animationSpec, confirmStateChange);
        t.i(initialValue, "initialValue");
        t.i(animationSpec, "animationSpec");
        t.i(confirmStateChange, "confirmStateChange");
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }
}
