package androidx.compose.animation.core;

import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: InfiniteTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.InfiniteTransition$run$1", f = "InfiniteTransition.kt", l = {147, 169}, m = "invokeSuspend")
final class InfiniteTransition$run$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InfiniteTransition this$0;

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteTransition.kt */
    static final class AnonymousClass1 extends v implements h9.l<Long, k0> {
        final /* synthetic */ o0 $$this$LaunchedEffect;
        final /* synthetic */ kotlin.jvm.internal.k0 $durationScale;
        final /* synthetic */ InfiniteTransition this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InfiniteTransition infiniteTransition, kotlin.jvm.internal.k0 k0Var, o0 o0Var) {
            super(1);
            this.this$0 = infiniteTransition;
            this.$durationScale = k0Var;
            this.$$this$LaunchedEffect = o0Var;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void invoke(long r7) {
            /*
                r6 = this;
                androidx.compose.animation.core.InfiniteTransition r0 = r6.this$0
                long r0 = androidx.compose.animation.core.InfiniteTransition.access$getStartTimeNanos$p(r0)
                r2 = -9223372036854775808
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L25
                kotlin.jvm.internal.k0 r0 = r6.$durationScale
                float r0 = r0.f29829a
                kotlinx.coroutines.o0 r3 = r6.$$this$LaunchedEffect
                z8.g r3 = r3.getCoroutineContext()
                float r3 = androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r3)
                int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r0 != 0) goto L22
                r0 = r1
                goto L23
            L22:
                r0 = r2
            L23:
                if (r0 != 0) goto L53
            L25:
                androidx.compose.animation.core.InfiniteTransition r0 = r6.this$0
                androidx.compose.animation.core.InfiniteTransition.access$setStartTimeNanos$p(r0, r7)
                androidx.compose.animation.core.InfiniteTransition r0 = r6.this$0
                androidx.compose.runtime.collection.MutableVector r0 = r0.getAnimations$animation_core_release()
                int r3 = r0.getSize()
                if (r3 <= 0) goto L45
                java.lang.Object[] r0 = r0.getContent()
                r4 = r2
            L3b:
                r5 = r0[r4]
                androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState r5 = (androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState) r5
                r5.reset()
                int r4 = r4 + r1
                if (r4 < r3) goto L3b
            L45:
                kotlin.jvm.internal.k0 r0 = r6.$durationScale
                kotlinx.coroutines.o0 r3 = r6.$$this$LaunchedEffect
                z8.g r3 = r3.getCoroutineContext()
                float r3 = androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r3)
                r0.f29829a = r3
            L53:
                kotlin.jvm.internal.k0 r0 = r6.$durationScale
                float r0 = r0.f29829a
                r3 = 0
                int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r0 != 0) goto L5e
                r0 = r1
                goto L5f
            L5e:
                r0 = r2
            L5f:
                if (r0 == 0) goto L7c
                androidx.compose.animation.core.InfiniteTransition r7 = r6.this$0
                androidx.compose.runtime.collection.MutableVector r7 = r7.getAnimations$animation_core_release()
                int r8 = r7.getSize()
                if (r8 <= 0) goto L8f
                java.lang.Object[] r7 = r7.getContent()
            L71:
                r0 = r7[r2]
                androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState r0 = (androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState) r0
                r0.skipToEnd()
                int r2 = r2 + r1
                if (r2 < r8) goto L71
                goto L8f
            L7c:
                androidx.compose.animation.core.InfiniteTransition r0 = r6.this$0
                long r0 = androidx.compose.animation.core.InfiniteTransition.access$getStartTimeNanos$p(r0)
                long r7 = r7 - r0
                float r7 = (float) r7
                kotlin.jvm.internal.k0 r8 = r6.$durationScale
                float r8 = r8.f29829a
                float r7 = r7 / r8
                long r7 = (long) r7
                androidx.compose.animation.core.InfiniteTransition r0 = r6.this$0
                androidx.compose.animation.core.InfiniteTransition.access$onFrame(r0, r7)
            L8f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.InfiniteTransition$run$1.AnonymousClass1.invoke(long):void");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteTransition.kt */
    static final class AnonymousClass2 extends v implements h9.a<Float> {
        final /* synthetic */ o0 $$this$LaunchedEffect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(o0 o0Var) {
            super(0);
            this.$$this$LaunchedEffect = o0Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Float invoke() {
            return Float.valueOf(SuspendAnimationKt.getDurationScale(this.$$this$LaunchedEffect.getCoroutineContext()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteTransition.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.InfiniteTransition$run$1$3", f = "InfiniteTransition.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<Float, z8.d<? super Boolean>, Object> {
        /* synthetic */ float F$0;
        int label;

        AnonymousClass3(z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(dVar);
            anonymousClass3.F$0 = ((Number) obj).floatValue();
            return anonymousClass3;
        }

        @Nullable
        public final Object invoke(float f10, @Nullable z8.d<? super Boolean> dVar) {
            return ((AnonymousClass3) create(Float.valueOf(f10), dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return kotlin.coroutines.jvm.internal.b.a(this.F$0 > 0.0f);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Float f10, z8.d<? super Boolean> dVar) {
            return invoke(f10.floatValue(), dVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InfiniteTransition$run$1(InfiniteTransition infiniteTransition, z8.d<? super InfiniteTransition$run$1> dVar) {
        super(2, dVar);
        this.this$0 = infiniteTransition;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        InfiniteTransition$run$1 infiniteTransition$run$1 = new InfiniteTransition$run$1(this.this$0, dVar);
        infiniteTransition$run$1.L$0 = obj;
        return infiniteTransition$run$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007b -> B:12:0x0042). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = a9.b.e()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L31
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r8.L$1
            kotlin.jvm.internal.k0 r1 = (kotlin.jvm.internal.k0) r1
            java.lang.Object r4 = r8.L$0
            kotlinx.coroutines.o0 r4 = (kotlinx.coroutines.o0) r4
            v8.u.b(r9)
            r9 = r4
            goto L41
        L1b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L23:
            java.lang.Object r1 = r8.L$1
            kotlin.jvm.internal.k0 r1 = (kotlin.jvm.internal.k0) r1
            java.lang.Object r4 = r8.L$0
            kotlinx.coroutines.o0 r4 = (kotlinx.coroutines.o0) r4
            v8.u.b(r9)
            r9 = r4
            r4 = r8
            goto L56
        L31:
            v8.u.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.o0 r9 = (kotlinx.coroutines.o0) r9
            kotlin.jvm.internal.k0 r1 = new kotlin.jvm.internal.k0
            r1.<init>()
            r4 = 1065353216(0x3f800000, float:1.0)
            r1.f29829a = r4
        L41:
            r4 = r8
        L42:
            androidx.compose.animation.core.InfiniteTransition$run$1$1 r5 = new androidx.compose.animation.core.InfiniteTransition$run$1$1
            androidx.compose.animation.core.InfiniteTransition r6 = r4.this$0
            r5.<init>(r6, r1, r9)
            r4.L$0 = r9
            r4.L$1 = r1
            r4.label = r3
            java.lang.Object r5 = androidx.compose.animation.core.InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r5, r4)
            if (r5 != r0) goto L56
            return r0
        L56:
            float r5 = r1.f29829a
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L5f
            r5 = r3
            goto L60
        L5f:
            r5 = 0
        L60:
            if (r5 == 0) goto L42
            androidx.compose.animation.core.InfiniteTransition$run$1$2 r5 = new androidx.compose.animation.core.InfiniteTransition$run$1$2
            r5.<init>(r9)
            s9.h r5 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r5)
            androidx.compose.animation.core.InfiniteTransition$run$1$3 r6 = new androidx.compose.animation.core.InfiniteTransition$run$1$3
            r7 = 0
            r6.<init>(r7)
            r4.L$0 = r9
            r4.L$1 = r1
            r4.label = r2
            java.lang.Object r5 = s9.j.v(r5, r6, r4)
            if (r5 != r0) goto L42
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.InfiniteTransition$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((InfiniteTransition$run$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
