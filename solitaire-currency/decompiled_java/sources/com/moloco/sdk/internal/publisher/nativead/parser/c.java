package com.moloco.sdk.internal.publisher.nativead.parser;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.nativead.model.a;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.service_locator.a;
import h9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;
import v8.s;
import v8.u;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", l = {113}, m = "prepareImageAsset")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18205j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18206k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18207l;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18206k = obj;
            this.f18207l |= Integer.MIN_VALUE;
            return c.f(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", l = {37, 58}, m = "prepareNativeAssets-exY8QGI")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f18208j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18209k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18210l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18211m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18212n;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18211m = obj;
            this.f18212n |= Integer.MIN_VALUE;
            return c.a(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.parser.c$c, reason: collision with other inner class name */
    public static final class C0319c extends v implements h9.a<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Context f18213g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0319c(Context context) {
            super(0);
            this.f18213g = context;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d invoke() {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(this.f18213g);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1", f = "PrepareNativeAssets.kt", l = {61}, m = "invokeSuspend")
    public static final class d extends l implements p<o0, z8.d<? super List<? extends s<? extends a.AbstractC0316a, ? extends t<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18214j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18215k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ List<a.AbstractC0316a> f18216l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> f18217m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f18218n;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1$1$1", f = "PrepareNativeAssets.kt", l = {60}, m = "invokeSuspend")
        public static final class a extends l implements p<o0, z8.d<? super s<? extends a.AbstractC0316a, ? extends t<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public Object f18219j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public int f18220k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ a.AbstractC0316a f18221l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> f18222m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ long f18223n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(a.AbstractC0316a abstractC0316a, v8.l<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar, long j10, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f18221l = abstractC0316a;
                this.f18222m = lVar;
                this.f18223n = j10;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s<? extends a.AbstractC0316a, ? extends t<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> dVar) {
                return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new a(this.f18221l, this.f18222m, this.f18223n, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a.AbstractC0316a abstractC0316a;
                Object objE = a9.d.e();
                int i10 = this.f18220k;
                if (i10 == 0) {
                    u.b(obj);
                    a.AbstractC0316a abstractC0316a2 = this.f18221l;
                    v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar = this.f18222m;
                    long j10 = this.f18223n;
                    this.f18219j = abstractC0316a2;
                    this.f18220k = 1;
                    Object objH = c.h(abstractC0316a2, lVar, j10, this);
                    if (objH == objE) {
                        return objE;
                    }
                    abstractC0316a = abstractC0316a2;
                    obj = objH;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    abstractC0316a = (a.AbstractC0316a) this.f18219j;
                    u.b(obj);
                }
                return y.a(abstractC0316a, obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends a.AbstractC0316a> list, v8.l<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar, long j10, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f18216l = list;
            this.f18217m = lVar;
            this.f18218n = j10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super List<? extends s<? extends a.AbstractC0316a, ? extends t<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            d dVar2 = new d(this.f18216l, this.f18217m, this.f18218n, dVar);
            dVar2.f18215k = obj;
            return dVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18214j;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.f18215k;
                List<a.AbstractC0316a> list = this.f18216l;
                v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar = this.f18217m;
                long j10 = this.f18218n;
                ArrayList arrayList = new ArrayList(w.v(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(k.b(o0Var, null, null, new a((a.AbstractC0316a) it.next(), lVar, j10, null), 3, null));
                }
                this.f18214j = 1;
                obj = kotlinx.coroutines.f.a(arrayList, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1", f = "PrepareNativeAssets.kt", l = {51}, m = "invokeSuspend")
    public static final class e extends l implements p<o0, z8.d<? super List<? extends s<? extends a.AbstractC0316a, ? extends t.b<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18224j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18225k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ List<a.AbstractC0316a> f18226l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> f18227m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f18228n;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1$1$1", f = "PrepareNativeAssets.kt", l = {40}, m = "invokeSuspend")
        public static final class a extends l implements p<o0, z8.d<? super s<? extends a.AbstractC0316a, ? extends t.b<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f18229j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ a.AbstractC0316a f18230k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> f18231l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ long f18232m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(a.AbstractC0316a abstractC0316a, v8.l<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar, long j10, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f18230k = abstractC0316a;
                this.f18231l = lVar;
                this.f18232m = j10;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s<? extends a.AbstractC0316a, t.b<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> dVar) {
                return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new a(this.f18230k, this.f18231l, this.f18232m, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws com.moloco.sdk.internal.publisher.nativead.parser.b {
                Object objE = a9.d.e();
                int i10 = this.f18229j;
                if (i10 == 0) {
                    u.b(obj);
                    a.AbstractC0316a abstractC0316a = this.f18230k;
                    v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar = this.f18231l;
                    long j10 = this.f18232m;
                    this.f18229j = 1;
                    obj = c.h(abstractC0316a, lVar, j10, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                t tVar = (t) obj;
                if (tVar instanceof t.b) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "PrepareNativeAssets", "Successfully prepared native asset: " + this.f18230k.a(), null, false, 12, null);
                    return y.a(this.f18230k, tVar);
                }
                if (!(tVar instanceof t.a)) {
                    throw new q();
                }
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "PrepareNativeAssets", "Failed to prepare required native asset: " + this.f18230k.a(), null, false, 12, null);
                throw new com.moloco.sdk.internal.publisher.nativead.parser.b(this.f18230k.a(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((t.a) tVar).a());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(List<? extends a.AbstractC0316a> list, v8.l<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar, long j10, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f18226l = list;
            this.f18227m = lVar;
            this.f18228n = j10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super List<? extends s<? extends a.AbstractC0316a, t.b<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> dVar) {
            return ((e) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            e eVar = new e(this.f18226l, this.f18227m, this.f18228n, dVar);
            eVar.f18225k = obj;
            return eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18224j;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.f18225k;
                List<a.AbstractC0316a> list = this.f18226l;
                v8.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar = this.f18227m;
                long j10 = this.f18228n;
                ArrayList arrayList = new ArrayList(w.v(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(k.b(o0Var, null, null, new a((a.AbstractC0316a) it.next(), lVar, j10, null), 3, null));
                }
                this.f18224j = 1;
                obj = kotlinx.coroutines.f.a(arrayList, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", l = {148, 155}, m = "prepareVideoAsset-exY8QGI")
    public static final class f extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18233j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18234k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f18235l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18236m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18237n;

        public f(z8.d<? super f> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18236m = obj;
            this.f18237n |= Integer.MIN_VALUE;
            return c.g(null, null, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull android.content.Context r11, @org.jetbrains.annotations.NotNull java.util.List<? extends com.moloco.sdk.internal.publisher.nativead.model.a.AbstractC0316a> r12, long r13, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.internal.publisher.nativead.parser.b>> r15) {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.parser.c.a(android.content.Context, java.util.List, long, z8.d):java.lang.Object");
    }

    public static /* synthetic */ Object c(a.AbstractC0316a.b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f fVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            fVar = a.g.f18914a.a();
        }
        return f(bVar, fVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(com.moloco.sdk.internal.publisher.nativead.model.a.AbstractC0316a.b r7, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f r8, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> r9) {
        /*
            boolean r0 = r9 instanceof com.moloco.sdk.internal.publisher.nativead.parser.c.a
            if (r0 == 0) goto L13
            r0 = r9
            com.moloco.sdk.internal.publisher.nativead.parser.c$a r0 = (com.moloco.sdk.internal.publisher.nativead.parser.c.a) r0
            int r1 = r0.f18207l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18207l = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.parser.c$a r0 = new com.moloco.sdk.internal.publisher.nativead.parser.c$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f18206k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18207l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.f18205j
            com.moloco.sdk.internal.publisher.nativead.model.a$a$b r7 = (com.moloco.sdk.internal.publisher.nativead.model.a.AbstractC0316a.b) r7
            v8.u.b(r9)
            goto L47
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            v8.u.b(r9)
            java.lang.String r9 = r7.c()
            r0.f18205j = r7
            r0.f18207l = r3
            java.lang.Object r9 = r8.b(r9, r0)
            if (r9 != r1) goto L47
            return r1
        L47:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f$a r9 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f.a) r9
            boolean r8 = r9 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f.a.b
            if (r8 == 0) goto L95
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE     // Catch: java.lang.Exception -> L7e
            java.lang.String r1 = "PrepareNativeAssets"
            java.lang.String r2 = "Successfully loaded image asset media"
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L7e
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f$a$b r9 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f.a.b) r9     // Catch: java.lang.Exception -> L7e
            java.io.File r8 = r9.a()     // Catch: java.lang.Exception -> L7e
            java.lang.String r8 = r8.getAbsolutePath()     // Catch: java.lang.Exception -> L7e
            java.lang.String r9 = "mediaCacheResult.file.absolutePath"
            kotlin.jvm.internal.t.h(r8, r9)     // Catch: java.lang.Exception -> L7e
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> L7e
            java.lang.String r9 = "parse(this)"
            kotlin.jvm.internal.t.h(r8, r9)     // Catch: java.lang.Exception -> L7e
            com.moloco.sdk.internal.t$b r9 = new com.moloco.sdk.internal.t$b
            com.moloco.sdk.internal.publisher.nativead.model.b$b r0 = new com.moloco.sdk.internal.publisher.nativead.model.b$b
            r0.<init>(r7, r8)
            r9.<init>(r0)
            goto Laa
        L7e:
            r7 = move-exception
            r3 = r7
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r1 = "PrepareNativeAssets"
            java.lang.String r2 = "Failed to prepare image asset"
            r4 = 0
            r5 = 8
            r6 = 0
            com.moloco.sdk.internal.MolocoLogger.warn$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.internal.t$a r7 = new com.moloco.sdk.internal.t$a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f r8 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_IMAGE_PREPARE_ASSET_UNKNOWN_ERROR
            r7.<init>(r8)
            return r7
        L95:
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r1 = "PrepareNativeAssets"
            java.lang.String r2 = "Failed to fetch image asset media"
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            com.moloco.sdk.internal.MolocoLogger.warn$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.internal.t$a r9 = new com.moloco.sdk.internal.t$a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_IMAGE_ASSET_MEDIA_FETCH_ERROR
            r9.<init>(r7)
        Laa:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.parser.c.f(com.moloco.sdk.internal.publisher.nativead.model.a$a$b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(com.moloco.sdk.internal.publisher.nativead.model.a.AbstractC0316a.d r11, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d r12, long r13, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> r15) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.parser.c.g(com.moloco.sdk.internal.publisher.nativead.model.a$a$d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d, long, z8.d):java.lang.Object");
    }

    public static final Object h(a.AbstractC0316a abstractC0316a, v8.l<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lVar, long j10, z8.d<? super t<com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> dVar) {
        if (abstractC0316a instanceof a.AbstractC0316a.C0317a) {
            return new t.b(new b.a((a.AbstractC0316a.C0317a) abstractC0316a));
        }
        if (abstractC0316a instanceof a.AbstractC0316a.b) {
            return c((a.AbstractC0316a.b) abstractC0316a, null, dVar, 2, null);
        }
        if (abstractC0316a instanceof a.AbstractC0316a.c) {
            return new t.b(new b.c((a.AbstractC0316a.c) abstractC0316a));
        }
        if (abstractC0316a instanceof a.AbstractC0316a.d) {
            return g((a.AbstractC0316a.d) abstractC0316a, lVar.getValue(), j10, dVar);
        }
        throw new q();
    }
}
