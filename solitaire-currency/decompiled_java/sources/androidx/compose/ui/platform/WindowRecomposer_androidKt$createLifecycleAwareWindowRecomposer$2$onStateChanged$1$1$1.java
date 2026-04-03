package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1", f = "WindowRecomposer.android.kt", l = {386}, m = "invokeSuspend")
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {
    final /* synthetic */ s9.m0<Float> $durationScaleStateFlow;
    final /* synthetic */ MotionDurationScaleImpl $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1(s9.m0<Float> m0Var, MotionDurationScaleImpl motionDurationScaleImpl, z8.d<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1> dVar) {
        super(2, dVar);
        this.$durationScaleStateFlow = m0Var;
        this.$it = motionDurationScaleImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1(this.$durationScaleStateFlow, this.$it, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            v8.u.b(obj);
            s9.m0<Float> m0Var = this.$durationScaleStateFlow;
            final MotionDurationScaleImpl motionDurationScaleImpl = this.$it;
            s9.i<Float> iVar = new s9.i<Float>() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1.1
                @Override // s9.i
                public /* bridge */ /* synthetic */ Object emit(Float f10, z8.d dVar) {
                    return emit(f10.floatValue(), (z8.d<? super v8.k0>) dVar);
                }

                @Nullable
                public final Object emit(float f10, @NotNull z8.d<? super v8.k0> dVar) {
                    motionDurationScaleImpl.setScaleFactor(f10);
                    return v8.k0.f35197a;
                }
            };
            this.label = 1;
            if (m0Var.collect(iVar, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
        }
        throw new v8.h();
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
    }
}
