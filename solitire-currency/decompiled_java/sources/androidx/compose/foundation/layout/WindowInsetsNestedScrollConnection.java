package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {

    @Nullable
    private WindowInsetsAnimationController animationController;

    @Nullable
    private b2 animationJob;

    @NotNull
    private final CancellationSignal cancellationSignal;

    @Nullable
    private kotlinx.coroutines.o<? super WindowInsetsAnimationController> continuation;

    @NotNull
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;

    @NotNull
    private final SideCalculator sideCalculator;

    @NotNull
    private final View view;

    @NotNull
    private final AndroidWindowInsets windowInsets;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
    static final class AnonymousClass1 extends v implements h9.l<Throwable, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$dispose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
    static final class C08661 extends v implements h9.l<Throwable, k0> {
        public static final C08661 INSTANCE = new C08661();

        C08661() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$onReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
    static final class C08671 extends v implements h9.l<Throwable, k0> {
        public static final C08671 INSTANCE = new C08671();

        C08671() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }
    }

    public WindowInsetsNestedScrollConnection(@NotNull AndroidWindowInsets windowInsets, @NotNull View view, @NotNull SideCalculator sideCalculator, @NotNull Density density) {
        t.i(windowInsets, "windowInsets");
        t.i(view, "view");
        t.i(sideCalculator, "sideCalculator");
        t.i(density, "density");
        this.windowInsets = windowInsets;
        this.view = view;
        this.sideCalculator = sideCalculator;
        this.density = density;
        this.cancellationSignal = new CancellationSignal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustInsets(float f10) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
            t.h(currentInsets, "it.currentInsets");
            windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, j9.c.c(f10)), 1.0f, 0.0f);
        }
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if ((windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady()) && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        kotlinx.coroutines.o<? super WindowInsetsAnimationController> oVar = this.continuation;
        if (oVar != null) {
            oVar.l(null, AnonymousClass1.INSTANCE);
        }
        this.continuation = null;
        b2 b2Var = this.animationJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX INFO: renamed from: fling-huYlsQE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m459flinghuYlsQE(long r27, float r29, boolean r30, z8.d<? super androidx.compose.ui.unit.Velocity> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m459flinghuYlsQE(long, float, boolean, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAnimationController(z8.d<? super WindowInsetsAnimationController> dVar) throws Throwable {
        Object objZ = this.animationController;
        if (objZ == null) {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.continuation = pVar;
            requestAnimationController();
            objZ = pVar.z();
            if (objZ == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
        }
        return objZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAnimationController() {
        if (this.isControllerRequested) {
            return;
        }
        this.isControllerRequested = true;
        WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1L, null, this.cancellationSignal, this);
        }
    }

    /* JADX INFO: renamed from: scroll-8S9VItk, reason: not valid java name */
    private final long m460scroll8S9VItk(long j10, float f10) {
        b2 b2Var = this.animationJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
            this.animationJob = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (!(f10 == 0.0f)) {
            if (this.windowInsets.isVisible() != (f10 > 0.0f) || windowInsetsAnimationController != null) {
                if (windowInsetsAnimationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.mo421consumedOffsetsMKHz9U(j10);
                }
                SideCalculator sideCalculator = this.sideCalculator;
                Insets hiddenStateInsets = windowInsetsAnimationController.getHiddenStateInsets();
                t.h(hiddenStateInsets, "animationController.hiddenStateInsets");
                int iValueOf = sideCalculator.valueOf(hiddenStateInsets);
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets shownStateInsets = windowInsetsAnimationController.getShownStateInsets();
                t.h(shownStateInsets, "animationController.shownStateInsets");
                int iValueOf2 = sideCalculator2.valueOf(shownStateInsets);
                Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
                t.h(currentInsets, "animationController.currentInsets");
                int iValueOf3 = this.sideCalculator.valueOf(currentInsets);
                if (iValueOf3 == (f10 > 0.0f ? iValueOf2 : iValueOf)) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m1383getZeroF1C5BW0();
                }
                float f11 = iValueOf3 + f10 + this.partialConsumption;
                int iN = n9.o.n(j9.c.c(f11), iValueOf, iValueOf2);
                this.partialConsumption = f11 - j9.c.c(f11);
                if (iN != iValueOf3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, iN), 1.0f, 0.0f);
                }
                return this.sideCalculator.mo421consumedOffsetsMKHz9U(j10);
            }
        }
        return Offset.Companion.m1383getZeroF1C5BW0();
    }

    public final void dispose() {
        kotlinx.coroutines.o<? super WindowInsetsAnimationController> oVar = this.continuation;
        if (oVar != null) {
            oVar.l(null, C08661.INSTANCE);
        }
        b2 b2Var = this.animationJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!t.d(windowInsetsAnimationController.getCurrentInsets(), windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @NotNull
    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(@NotNull WindowInsetsAnimationController controller) {
        t.i(controller, "controller");
        animationEnded();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo301onPostFlingRZ2iAVY(long j10, long j11, @NotNull z8.d<? super Velocity> dVar) {
        return m459flinghuYlsQE(j11, this.sideCalculator.showMotion(Velocity.m3898getXimpl(j11), Velocity.m3899getYimpl(j11)), true, dVar);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo302onPostScrollDzOQY0M(long j10, long j11, int i10) {
        return m460scroll8S9VItk(j11, this.sideCalculator.showMotion(Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11)));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo303onPreFlingQWom1Mo(long j10, @NotNull z8.d<? super Velocity> dVar) {
        return m459flinghuYlsQE(j10, this.sideCalculator.hideMotion(Velocity.m3898getXimpl(j10), Velocity.m3899getYimpl(j10)), false, dVar);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo304onPreScrollOzD1aCk(long j10, int i10) {
        return m460scroll8S9VItk(j10, this.sideCalculator.hideMotion(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10)));
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(@NotNull WindowInsetsAnimationController controller, int i10) {
        t.i(controller, "controller");
        this.animationController = controller;
        this.isControllerRequested = false;
        kotlinx.coroutines.o<? super WindowInsetsAnimationController> oVar = this.continuation;
        if (oVar != null) {
            oVar.l(controller, C08671.INSTANCE);
        }
        this.continuation = null;
    }
}
