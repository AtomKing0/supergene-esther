package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.SuspendAnimationKt;
import h9.p;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", l = {348}, m = "invokeSuspend")
final class WindowInsetsNestedScrollConnection$fling$2 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ int $current;
    final /* synthetic */ kotlin.jvm.internal.k0 $endVelocity;
    final /* synthetic */ float $flingAmount;
    final /* synthetic */ int $hidden;
    final /* synthetic */ int $shown;
    final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
    final /* synthetic */ boolean $targetShown;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1", f = "WindowInsetsConnection.android.kt", l = {332}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ WindowInsetsAnimationController $animationController;
        final /* synthetic */ int $current;
        final /* synthetic */ kotlin.jvm.internal.k0 $endVelocity;
        final /* synthetic */ float $flingAmount;
        final /* synthetic */ int $hidden;
        final /* synthetic */ int $shown;
        final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
        final /* synthetic */ boolean $targetShown;
        int label;
        final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
        static final class C00531 extends v implements p<Float, Float, k0> {
            final /* synthetic */ WindowInsetsAnimationController $animationController;
            final /* synthetic */ kotlin.jvm.internal.k0 $endVelocity;
            final /* synthetic */ int $hidden;
            final /* synthetic */ int $shown;
            final /* synthetic */ boolean $targetShown;
            final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00531(int i10, int i11, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, kotlin.jvm.internal.k0 k0Var, WindowInsetsAnimationController windowInsetsAnimationController, boolean z10) {
                super(2);
                this.$hidden = i10;
                this.$shown = i11;
                this.this$0 = windowInsetsNestedScrollConnection;
                this.$endVelocity = k0Var;
                this.$animationController = windowInsetsAnimationController;
                this.$targetShown = z10;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Float f10, Float f11) {
                invoke(f10.floatValue(), f11.floatValue());
                return k0.f35197a;
            }

            public final void invoke(float f10, float f11) {
                float f12 = this.$hidden;
                boolean z10 = false;
                if (f10 <= this.$shown && f12 <= f10) {
                    z10 = true;
                }
                if (z10) {
                    this.this$0.adjustInsets(f10);
                    return;
                }
                this.$endVelocity.f29829a = f11;
                this.$animationController.finish(this.$targetShown);
                this.this$0.animationController = null;
                b2 b2Var = this.this$0.animationJob;
                if (b2Var != null) {
                    b2.a.a(b2Var, null, 1, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10, float f10, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i11, int i12, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, kotlin.jvm.internal.k0 k0Var, WindowInsetsAnimationController windowInsetsAnimationController, boolean z10, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$current = i10;
            this.$flingAmount = f10;
            this.$spec = splineBasedFloatDecayAnimationSpec;
            this.$hidden = i11;
            this.$shown = i12;
            this.this$0 = windowInsetsNestedScrollConnection;
            this.$endVelocity = k0Var;
            this.$animationController = windowInsetsAnimationController;
            this.$targetShown = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass1(this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.this$0, this.$endVelocity, this.$animationController, this.$targetShown, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                float f10 = this.$current;
                float f11 = this.$flingAmount;
                SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = this.$spec;
                C00531 c00531 = new C00531(this.$hidden, this.$shown, this.this$0, this.$endVelocity, this.$animationController, this.$targetShown);
                this.label = 1;
                if (SuspendAnimationKt.animateDecay(f10, f11, splineBasedFloatDecayAnimationSpec, c00531, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i10, float f10, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i11, int i12, kotlin.jvm.internal.k0 k0Var, WindowInsetsAnimationController windowInsetsAnimationController, boolean z10, z8.d<? super WindowInsetsNestedScrollConnection$fling$2> dVar) {
        super(2, dVar);
        this.this$0 = windowInsetsNestedScrollConnection;
        this.$current = i10;
        this.$flingAmount = f10;
        this.$spec = splineBasedFloatDecayAnimationSpec;
        this.$hidden = i11;
        this.$shown = i12;
        this.$endVelocity = k0Var;
        this.$animationController = windowInsetsAnimationController;
        this.$targetShown = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(this.this$0, this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.$endVelocity, this.$animationController, this.$targetShown, dVar);
        windowInsetsNestedScrollConnection$fling$2.L$0 = obj;
        return windowInsetsNestedScrollConnection$fling$2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            o0 o0Var = (o0) this.L$0;
            WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.this$0;
            windowInsetsNestedScrollConnection.animationJob = kotlinx.coroutines.k.d(o0Var, null, null, new AnonymousClass1(this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, windowInsetsNestedScrollConnection, this.$endVelocity, this.$animationController, this.$targetShown, null), 3, null);
            b2 b2Var = this.this$0.animationJob;
            if (b2Var != null) {
                this.label = 1;
                if (b2Var.z(this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        this.this$0.animationJob = null;
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((WindowInsetsNestedScrollConnection$fling$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
