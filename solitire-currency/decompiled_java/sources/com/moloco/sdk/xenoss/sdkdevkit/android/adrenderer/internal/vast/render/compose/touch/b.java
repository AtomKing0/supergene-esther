package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2", f = "Tap.kt", l = {42}, m = "invokeSuspend")
    public static final class a extends l implements p<PointerInputScope, d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21240j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f21241k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a f21242l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ p<Offset, Offset, k0> f21243m;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$a$a, reason: collision with other inner class name */
        @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2$1", f = "Tap.kt", l = {44}, m = "invokeSuspend")
        public static final class C0460a extends l implements p<o0, d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21244j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a f21245k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ PointerInputScope f21246l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ p<Offset, Offset, k0> f21247m;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$a$a$a, reason: collision with other inner class name */
            @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2$1$1", f = "Tap.kt", l = {45, 48}, m = "invokeSuspend")
            public static final class C0461a extends k implements p<AwaitPointerEventScope, d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f21248j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public /* synthetic */ Object f21249k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a f21250l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ p<Offset, Offset, k0> f21251m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0461a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, p<? super Offset, ? super Offset, k0> pVar, d<? super C0461a> dVar) {
                    super(2, dVar);
                    this.f21250l = aVar;
                    this.f21251m = pVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    C0461a c0461a = new C0461a(this.f21250l, this.f21251m, dVar);
                    c0461a.f21249k = obj;
                    return c0461a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable d<? super k0> dVar) {
                    return ((C0461a) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
                    /*
                        r5 = this;
                        java.lang.Object r0 = a9.b.e()
                        int r1 = r5.f21248j
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L26
                        if (r1 == r3) goto L1e
                        if (r1 != r2) goto L16
                        java.lang.Object r0 = r5.f21249k
                        androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
                        v8.u.b(r6)
                        goto L56
                    L16:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r0)
                        throw r6
                    L1e:
                        java.lang.Object r1 = r5.f21249k
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        v8.u.b(r6)
                        goto L3a
                    L26:
                        v8.u.b(r6)
                        java.lang.Object r6 = r5.f21249k
                        r1 = r6
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        r5.f21249k = r1
                        r5.f21248j = r3
                        r6 = 0
                        java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r6, r5)
                        if (r6 != r0) goto L3a
                        return r0
                    L3a:
                        androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                        boolean r3 = r6.getPressed()
                        boolean r4 = r6.getPreviousPressed()
                        if (r3 == r4) goto L49
                        r6.consume()
                    L49:
                        r5.f21249k = r6
                        r5.f21248j = r2
                        java.lang.Object r1 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.a(r1, r5)
                        if (r1 != r0) goto L54
                        return r0
                    L54:
                        r0 = r6
                        r6 = r1
                    L56:
                        androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                        if (r6 != 0) goto L60
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a r6 = r5.f21250l
                        r6.a()
                        goto L7a
                    L60:
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a r1 = r5.f21250l
                        r1.b()
                        h9.p<androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset, v8.k0> r1 = r5.f21251m
                        long r2 = r0.m2873getPositionF1C5BW0()
                        androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m1356boximpl(r2)
                        long r2 = r6.m2873getPositionF1C5BW0()
                        androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m1356boximpl(r2)
                        r1.mo4invoke(r0, r6)
                    L7a:
                        v8.k0 r6 = v8.k0.f35197a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.a.C0460a.C0461a.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0460a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, PointerInputScope pointerInputScope, p<? super Offset, ? super Offset, k0> pVar, d<? super C0460a> dVar) {
                super(2, dVar);
                this.f21245k = aVar;
                this.f21246l = pointerInputScope;
                this.f21247m = pVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C0460a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C0460a(this.f21245k, this.f21246l, this.f21247m, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f21244j;
                if (i10 == 0) {
                    u.b(obj);
                    this.f21245k.c();
                    PointerInputScope pointerInputScope = this.f21246l;
                    C0461a c0461a = new C0461a(this.f21245k, this.f21247m, null);
                    this.f21244j = 1;
                    if (pointerInputScope.awaitPointerEventScope(c0461a, this) == objE) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, p<? super Offset, ? super Offset, k0> pVar, d<? super a> dVar) {
            super(2, dVar);
            this.f21242l = aVar;
            this.f21243m = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            a aVar = new a(this.f21242l, this.f21243m, dVar);
            aVar.f21241k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((a) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21240j;
            if (i10 == 0) {
                u.b(obj);
                C0460a c0460a = new C0460a(this.f21242l, (PointerInputScope) this.f21241k, this.f21243m, null);
                this.f21240j = 1;
                if (p0.f(c0460a, this) == objE) {
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
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$b, reason: collision with other inner class name */
    @f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt", f = "Tap.kt", l = {62, 77}, m = "waitForUpOrCancellationInitial")
    public static final class C0462b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f21252j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f21253k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f21254l;

        public C0462b(d<? super C0462b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21253k = obj;
            this.f21254l |= Integer.MIN_VALUE;
            return b.c(null, this);
        }
    }

    @Nullable
    public static final Object b(@NotNull PointerInputScope pointerInputScope, @NotNull p<? super Offset, ? super Offset, k0> pVar, @NotNull d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a(pointerInputScope), pVar, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a0 -> B:36:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(androidx.compose.ui.input.pointer.AwaitPointerEventScope r13, z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r14) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.c(androidx.compose.ui.input.pointer.AwaitPointerEventScope, z8.d):java.lang.Object");
    }
}
