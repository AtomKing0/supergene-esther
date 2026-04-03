package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", l = {391}, m = "invokeSuspend")
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt.AnonymousClass2 $self;
    final /* synthetic */ kotlin.jvm.internal.n0<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(kotlin.jvm.internal.n0<MotionDurationScaleImpl> n0Var, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt.AnonymousClass2 anonymousClass2, View view, z8.d<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> dVar) {
        super(2, dVar);
        this.$systemDurationScaleSettingConsumer = n0Var;
        this.$recomposer = recomposer;
        this.$lifecycleOwner = lifecycleOwner;
        this.$self = anonymousClass2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$lifecycleOwner, this.$self, this.$this_createLifecycleAwareWindowRecomposer, dVar);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    @Override // kotlin.coroutines.jvm.internal.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = a9.b.e()
            int r1 = r11.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r11.L$0
            kotlinx.coroutines.b2 r0 = (kotlinx.coroutines.b2) r0
            v8.u.b(r12)     // Catch: java.lang.Throwable -> L14
            goto L6c
        L14:
            r12 = move-exception
            goto L86
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            v8.u.b(r12)
            java.lang.Object r12 = r11.L$0
            r4 = r12
            kotlinx.coroutines.o0 r4 = (kotlinx.coroutines.o0) r4
            kotlin.jvm.internal.n0<androidx.compose.ui.platform.MotionDurationScaleImpl> r12 = r11.$systemDurationScaleSettingConsumer     // Catch: java.lang.Throwable -> L84
            T r12 = r12.f29834a     // Catch: java.lang.Throwable -> L84
            androidx.compose.ui.platform.MotionDurationScaleImpl r12 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r12     // Catch: java.lang.Throwable -> L84
            if (r12 == 0) goto L5d
            android.view.View r1 = r11.$this_createLifecycleAwareWindowRecomposer     // Catch: java.lang.Throwable -> L84
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L84
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Throwable -> L84
            java.lang.String r5 = "context.applicationContext"
            kotlin.jvm.internal.t.h(r1, r5)     // Catch: java.lang.Throwable -> L84
            s9.m0 r1 = androidx.compose.ui.platform.WindowRecomposer_androidKt.access$getAnimationScaleFlowFor(r1)     // Catch: java.lang.Throwable -> L84
            java.lang.Object r5 = r1.getValue()     // Catch: java.lang.Throwable -> L84
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L84
            float r5 = r5.floatValue()     // Catch: java.lang.Throwable -> L84
            r12.setScaleFactor(r5)     // Catch: java.lang.Throwable -> L84
            r5 = 0
            r6 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r7 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch: java.lang.Throwable -> L84
            r7.<init>(r1, r12, r3)     // Catch: java.lang.Throwable -> L84
            r8 = 3
            r9 = 0
            kotlinx.coroutines.b2 r12 = kotlinx.coroutines.i.d(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L84
            goto L5e
        L5d:
            r12 = r3
        L5e:
            androidx.compose.runtime.Recomposer r1 = r11.$recomposer     // Catch: java.lang.Throwable -> L7f
            r11.L$0 = r12     // Catch: java.lang.Throwable -> L7f
            r11.label = r2     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r1 = r1.runRecomposeAndApplyChanges(r11)     // Catch: java.lang.Throwable -> L7f
            if (r1 != r0) goto L6b
            return r0
        L6b:
            r0 = r12
        L6c:
            if (r0 == 0) goto L71
            kotlinx.coroutines.b2.a.a(r0, r3, r2, r3)
        L71:
            androidx.lifecycle.LifecycleOwner r12 = r11.$lifecycleOwner
            androidx.lifecycle.Lifecycle r12 = r12.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r0 = r11.$self
            r12.removeObserver(r0)
            v8.k0 r12 = v8.k0.f35197a
            return r12
        L7f:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L86
        L84:
            r12 = move-exception
            r0 = r3
        L86:
            if (r0 == 0) goto L8b
            kotlinx.coroutines.b2.a.a(r0, r3, r2, r3)
        L8b:
            androidx.lifecycle.LifecycleOwner r0 = r11.$lifecycleOwner
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r1 = r11.$self
            r0.removeObserver(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
    }
}
