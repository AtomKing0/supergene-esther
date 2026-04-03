package androidx.compose.material;

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

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class BottomDrawerState extends SwipeableState<BottomDrawerValue> {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final NestedScrollConnection nestedScrollConnection;

    /* JADX INFO: renamed from: androidx.compose.material.BottomDrawerState$1, reason: invalid class name */
    /* JADX INFO: compiled from: Drawer.kt */
    static final class AnonymousClass1 extends v implements l<BottomDrawerValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull BottomDrawerValue it) {
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
        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(@NotNull l<? super BottomDrawerValue, Boolean> confirmStateChange) {
            t.i(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(BottomDrawerState$Companion$Saver$1.INSTANCE, new BottomDrawerState$Companion$Saver$2(confirmStateChange));
        }
    }

    public /* synthetic */ BottomDrawerState(BottomDrawerValue bottomDrawerValue, l lVar, int i10, k kVar) {
        this(bottomDrawerValue, (i10 & 2) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }

    private final boolean isOpenEnabled() {
        return getAnchors$material_release().values().contains(BottomDrawerValue.Open);
    }

    @Nullable
    public final Object close(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, BottomDrawerValue.Closed, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    @Nullable
    public final Object expand(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, BottomDrawerValue.Expanded, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    @NotNull
    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    public final boolean isClosed() {
        return getCurrentValue() == BottomDrawerValue.Closed;
    }

    public final boolean isExpanded() {
        return getCurrentValue() == BottomDrawerValue.Expanded;
    }

    public final boolean isOpen() {
        return getCurrentValue() != BottomDrawerValue.Closed;
    }

    @Nullable
    public final Object open(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, isOpenEnabled() ? BottomDrawerValue.Open : BottomDrawerValue.Expanded, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomDrawerState(@NotNull BottomDrawerValue initialValue, @NotNull l<? super BottomDrawerValue, Boolean> confirmStateChange) {
        super(initialValue, DrawerKt.AnimationSpec, confirmStateChange);
        t.i(initialValue, "initialValue");
        t.i(confirmStateChange, "confirmStateChange");
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }
}
