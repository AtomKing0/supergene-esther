package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a$a, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsAttachedWindow$2", f = "ViewVisibilityTracker.kt", l = {46, 49}, m = "invokeSuspend")
    public static final class C0351a extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18993j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f18994k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ r9.r<Boolean> f18995l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f18996m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0351a(r9.r<? super Boolean> rVar, View view, z8.d<? super C0351a> dVar) {
            super(2, dVar);
            this.f18995l = rVar;
            this.f18996m = view;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C0351a c0351a = new C0351a(this.f18995l, this.f18996m, dVar);
            c0351a.f18994k = ((Boolean) obj).booleanValue();
            return c0351a;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C0351a) create(Boolean.valueOf(z10), dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super v8.k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18993j;
            if (i10 == 0) {
                v8.u.b(obj);
                if (this.f18994k) {
                    r9.r<Boolean> rVar = this.f18995l;
                    View view = this.f18996m;
                    this.f18993j = 1;
                    if (a.k(rVar, view, this) == objE) {
                        return objE;
                    }
                } else {
                    r9.r<Boolean> rVar2 = this.f18995l;
                    Boolean boolA = kotlin.coroutines.jvm.internal.b.a(false);
                    this.f18993j = 2;
                    if (rVar2.p(boolA, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsEnoughAreaVisible$2", f = "ViewVisibilityTracker.kt", l = {69}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18997j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f18998k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ r9.r<Boolean> f18999l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(r9.r<? super Boolean> rVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f18999l = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(this.f18999l, dVar);
            bVar.f18998k = ((Boolean) obj).booleanValue();
            return bVar;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super v8.k0> dVar) {
            return ((b) create(Boolean.valueOf(z10), dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super v8.k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18997j;
            if (i10 == 0) {
                v8.u.b(obj);
                boolean z10 = this.f18998k;
                r9.r<Boolean> rVar = this.f18999l;
                Boolean boolA = kotlin.coroutines.jvm.internal.b.a(z10);
                this.f18997j = 1;
                if (rVar.p(boolA, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsLifecycleResumed$2", f = "ViewVisibilityTracker.kt", l = {59, 62}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19000j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19001k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ r9.r<Boolean> f19002l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f19003m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(r9.r<? super Boolean> rVar, View view, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f19002l = rVar;
            this.f19003m = view;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            c cVar = new c(this.f19002l, this.f19003m, dVar);
            cVar.f19001k = obj;
            return cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@Nullable Boolean bool, @Nullable z8.d<? super v8.k0> dVar) {
            return ((c) create(bool, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19000j;
            if (i10 == 0) {
                v8.u.b(obj);
                if (kotlin.jvm.internal.t.d((Boolean) this.f19001k, kotlin.coroutines.jvm.internal.b.a(false))) {
                    r9.r<Boolean> rVar = this.f19002l;
                    Boolean boolA = kotlin.coroutines.jvm.internal.b.a(false);
                    this.f19000j = 2;
                    if (rVar.p(boolA, this) == objE) {
                        return objE;
                    }
                } else {
                    r9.r<Boolean> rVar2 = this.f19002l;
                    View view = this.f19003m;
                    this.f19000j = 1;
                    if (a.j(rVar2, view, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isAttachedToWindowFlow$1", f = "ViewVisibilityTracker.kt", l = {75, 91}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<r9.r<? super Boolean>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19004j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19005k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ View f19006l;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a$d$a, reason: collision with other inner class name */
        public static final class C0352a extends kotlin.jvm.internal.v implements h9.a<v8.k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ View f19007g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ b f19008h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0352a(View view, b bVar) {
                super(0);
                this.f19007g = view;
                this.f19008h = bVar;
            }

            public final void b() {
                this.f19007g.removeOnAttachStateChangeListener(this.f19008h);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ v8.k0 invoke() {
                b();
                return v8.k0.f35197a;
            }
        }

        public static final class b implements View.OnAttachStateChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r9.r<Boolean> f19009a;

            /* JADX WARN: Multi-variable type inference failed */
            public b(r9.r<? super Boolean> rVar) {
                this.f19009a = rVar;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View p02) {
                kotlin.jvm.internal.t.i(p02, "p0");
                this.f19009a.f(Boolean.TRUE);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View p02) {
                kotlin.jvm.internal.t.i(p02, "p0");
                this.f19009a.f(Boolean.FALSE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View view, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f19006l = view;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            d dVar2 = new d(this.f19006l, dVar);
            dVar2.f19005k = obj;
            return dVar2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r9.r<? super Boolean> rVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((d) create(rVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            r9.r rVar;
            Object objE = a9.d.e();
            int i10 = this.f19004j;
            if (i10 == 0) {
                v8.u.b(obj);
                rVar = (r9.r) this.f19005k;
                Boolean boolA = kotlin.coroutines.jvm.internal.b.a(this.f19006l.isAttachedToWindow());
                this.f19005k = rVar;
                this.f19004j = 1;
                if (rVar.p(boolA, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    return v8.k0.f35197a;
                }
                rVar = (r9.r) this.f19005k;
                v8.u.b(obj);
            }
            b bVar = new b(rVar);
            this.f19006l.addOnAttachStateChangeListener(bVar);
            C0352a c0352a = new C0352a(this.f19006l, bVar);
            this.f19005k = null;
            this.f19004j = 2;
            if (r9.p.a(rVar, c0352a, this) == objE) {
                return objE;
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isEnoughAreaVisibleFlow$1", f = "ViewVisibilityTracker.kt", l = {133, 134}, m = "invokeSuspend")
    public static final class e extends kotlin.coroutines.jvm.internal.l implements h9.p<s9.i<? super Boolean>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19010j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19011k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f19012l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f19013m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(View view, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f19013m = view;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            e eVar = new e(this.f19013m, dVar);
            eVar.f19012l = obj;
            return eVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull s9.i<? super Boolean> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((e) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        /* JADX WARN: Path cross not found for [B:14:0x0046, B:17:0x0050], limit reached: 24 */
        /* JADX WARN: Path cross not found for [B:17:0x0050, B:14:0x0046], limit reached: 24 */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0070 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006e -> B:12:0x003e). Please report as a decompilation issue!!! */
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
                int r1 = r8.f19011k
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L30
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r8.f19010j
                android.graphics.Rect r1 = (android.graphics.Rect) r1
                java.lang.Object r5 = r8.f19012l
                s9.i r5 = (s9.i) r5
                v8.u.b(r9)
                goto L3d
            L1b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L23:
                java.lang.Object r1 = r8.f19010j
                android.graphics.Rect r1 = (android.graphics.Rect) r1
                java.lang.Object r5 = r8.f19012l
                s9.i r5 = (s9.i) r5
                v8.u.b(r9)
                r9 = r8
                goto L62
            L30:
                v8.u.b(r9)
                java.lang.Object r9 = r8.f19012l
                r5 = r9
                s9.i r5 = (s9.i) r5
                android.graphics.Rect r1 = new android.graphics.Rect
                r1.<init>(r4, r4, r4, r4)
            L3d:
                r9 = r8
            L3e:
                android.view.View r6 = r9.f19013m
                boolean r6 = r6.isShown()
                if (r6 == 0) goto L50
                android.view.View r6 = r9.f19013m
                boolean r6 = r6.getGlobalVisibleRect(r1)
                if (r6 == 0) goto L50
                r6 = r3
                goto L51
            L50:
                r6 = r4
            L51:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r6)
                r9.f19012l = r5
                r9.f19010j = r1
                r9.f19011k = r3
                java.lang.Object r6 = r5.emit(r6, r9)
                if (r6 != r0) goto L62
                return r0
            L62:
                r9.f19012l = r5
                r9.f19010j = r1
                r9.f19011k = r2
                r6 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r6 = kotlinx.coroutines.y0.a(r6, r9)
                if (r6 != r0) goto L3e
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isLifecycleResumedFlow$lifecycle$1", f = "ViewVisibilityTracker.kt", l = {102}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<s9.i<? super Boolean>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19014j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19015k;

        public f(z8.d<? super f> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            f fVar = new f(dVar);
            fVar.f19015k = obj;
            return fVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull s9.i<? super Boolean> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((f) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19014j;
            if (i10 == 0) {
                v8.u.b(obj);
                s9.i iVar = (s9.i) this.f19015k;
                this.f19014j = 1;
                if (iVar.emit(null, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isLifecycleResumedFlow$1", f = "ViewVisibilityTracker.kt", l = {118}, m = "invokeSuspend")
    public static final class g extends kotlin.coroutines.jvm.internal.l implements h9.p<r9.r<? super Boolean>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19016j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19017k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f19018l;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a$g$a, reason: collision with other inner class name */
        public static final class C0353a extends kotlin.jvm.internal.v implements h9.a<v8.k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Lifecycle f19019g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ LifecycleEventObserver f19020h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0353a(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
                super(0);
                this.f19019g = lifecycle;
                this.f19020h = lifecycleEventObserver;
            }

            public final void b() {
                this.f19019g.removeObserver(this.f19020h);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ v8.k0 invoke() {
                b();
                return v8.k0.f35197a;
            }
        }

        public static final class b implements LifecycleEventObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r9.r<Boolean> f19021a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a$g$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0354a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f19022a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f19022a = iArr;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public b(r9.r<? super Boolean> rVar) {
                this.f19021a = rVar;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
                kotlin.jvm.internal.t.i(lifecycleOwner, "<anonymous parameter 0>");
                kotlin.jvm.internal.t.i(event, "event");
                int i10 = C0354a.f19022a[event.ordinal()];
                if (i10 == 1) {
                    this.f19021a.f(Boolean.FALSE);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f19021a.f(Boolean.TRUE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Lifecycle lifecycle, z8.d<? super g> dVar) {
            super(2, dVar);
            this.f19018l = lifecycle;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            g gVar = new g(this.f19018l, dVar);
            gVar.f19017k = obj;
            return gVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r9.r<? super Boolean> rVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((g) create(rVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19016j;
            if (i10 == 0) {
                v8.u.b(obj);
                r9.r rVar = (r9.r) this.f19017k;
                b bVar = new b(rVar);
                this.f19018l.addObserver(bVar);
                C0353a c0353a = new C0353a(this.f19018l, bVar);
                this.f19016j = 1;
                if (r9.p.a(rVar, c0353a, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }
    }

    public static final s9.h<Boolean> b(View view) {
        return g(s9.j.f(new d(view, null)));
    }

    public static final s9.h<Boolean> c(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        return (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? s9.j.z(new f(null)) : g(s9.j.f(new g(lifecycle, null)));
    }

    public static final s9.h<Boolean> f(View view) {
        return g(s9.j.z(new e(view, null)));
    }

    public static final <T> s9.h<T> g(s9.h<? extends T> hVar) {
        return s9.j.C(s9.j.p(s9.j.n(hVar)), com.moloco.sdk.internal.scheduling.c.a().getMain());
    }

    public static final Object i(r9.r<? super Boolean> rVar, View view, z8.d<? super v8.k0> dVar) {
        Object objL = s9.j.l(b(view), new C0351a(rVar, view, null), dVar);
        return objL == a9.d.e() ? objL : v8.k0.f35197a;
    }

    public static final Object j(r9.r<? super Boolean> rVar, View view, z8.d<? super v8.k0> dVar) {
        Object objL = s9.j.l(f(view), new b(rVar, null), dVar);
        return objL == a9.d.e() ? objL : v8.k0.f35197a;
    }

    public static final Object k(r9.r<? super Boolean> rVar, View view, z8.d<? super v8.k0> dVar) {
        Object objL = s9.j.l(c(ViewTreeLifecycleOwner.get(view)), new c(rVar, view, null), dVar);
        return objL == a9.d.e() ? objL : v8.k0.f35197a;
    }
}
