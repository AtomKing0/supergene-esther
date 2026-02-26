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

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public final class BackdropScaffoldState extends SwipeableState<BackdropValue> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final NestedScrollConnection nestedScrollConnection;

    @NotNull
    private final SnackbarHostState snackbarHostState;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldState$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    static final class AnonymousClass1 extends v implements l<BackdropValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull BackdropValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: BackdropScaffold.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<BackdropScaffoldState, ?> Saver(@NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super BackdropValue, Boolean> confirmStateChange, @NotNull SnackbarHostState snackbarHostState) {
            t.i(animationSpec, "animationSpec");
            t.i(confirmStateChange, "confirmStateChange");
            t.i(snackbarHostState, "snackbarHostState");
            return SaverKt.Saver(BackdropScaffoldState$Companion$Saver$1.INSTANCE, new BackdropScaffoldState$Companion$Saver$2(animationSpec, confirmStateChange, snackbarHostState));
        }
    }

    public /* synthetic */ BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec animationSpec, l lVar, SnackbarHostState snackbarHostState, int i10, k kVar) {
        this(backdropValue, (i10 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i10 & 4) != 0 ? AnonymousClass1.INSTANCE : lVar, (i10 & 8) != 0 ? new SnackbarHostState() : snackbarHostState);
    }

    @Nullable
    public final Object conceal(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Concealed, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    @NotNull
    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    @NotNull
    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    public final boolean isConcealed() {
        return getCurrentValue() == BackdropValue.Concealed;
    }

    public final boolean isRevealed() {
        return getCurrentValue() == BackdropValue.Revealed;
    }

    @Nullable
    public final Object reveal(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Revealed, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldState(@NotNull BackdropValue initialValue, @NotNull AnimationSpec<Float> animationSpec, @NotNull l<? super BackdropValue, Boolean> confirmStateChange, @NotNull SnackbarHostState snackbarHostState) {
        super(initialValue, animationSpec, confirmStateChange);
        t.i(initialValue, "initialValue");
        t.i(animationSpec, "animationSpec");
        t.i(confirmStateChange, "confirmStateChange");
        t.i(snackbarHostState, "snackbarHostState");
        this.snackbarHostState = snackbarHostState;
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }
}
