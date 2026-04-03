package com.moloco.sdk.internal.publisher.nativead;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.ts.PsExtractor;
import com.moloco.sdk.internal.publisher.g0;
import com.moloco.sdk.internal.publisher.x;
import com.moloco.sdk.internal.q;
import com.moloco.sdk.internal.services.r;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdKt;
import h9.p;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f18085k = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final x f18088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.nativead.parser.a f18089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.a f18090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.a f18091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final r f18092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final AdFormatType f18093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.f f18094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.scheduling.a f18095j;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final com.moloco.sdk.internal.ortb.model.c f18096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final com.moloco.sdk.internal.publisher.nativead.model.a f18097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final com.moloco.sdk.internal.publisher.nativead.model.c f18098c;

        public b(@NotNull com.moloco.sdk.internal.ortb.model.c bid, @NotNull com.moloco.sdk.internal.publisher.nativead.model.a ortbResponse, @NotNull com.moloco.sdk.internal.publisher.nativead.model.c preparedAssets) {
            t.i(bid, "bid");
            t.i(ortbResponse, "ortbResponse");
            t.i(preparedAssets, "preparedAssets");
            this.f18096a = bid;
            this.f18097b = ortbResponse;
            this.f18098c = preparedAssets;
        }

        @NotNull
        public final com.moloco.sdk.internal.ortb.model.c a() {
            return this.f18096a;
        }

        @NotNull
        public final com.moloco.sdk.internal.publisher.nativead.model.a b() {
            return this.f18097b;
        }

        @NotNull
        public final com.moloco.sdk.internal.publisher.nativead.model.c c() {
            return this.f18098c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.d(this.f18096a, bVar.f18096a) && t.d(this.f18097b, bVar.f18097b) && t.d(this.f18098c, bVar.f18098c);
        }

        public int hashCode() {
            return (((this.f18096a.hashCode() * 31) + this.f18097b.hashCode()) * 31) + this.f18098c.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadedNativeAd(bid=" + this.f18096a + ", ortbResponse=" + this.f18097b + ", preparedAssets=" + this.f18098c + ')';
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.c$c, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", l = {239}, m = "fetchAssets-8Mi8wO0")
    public static final class C0315c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18099j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18100k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18101l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18102m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18104o;

        public C0315c(z8.d<? super C0315c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18102m = obj;
            this.f18104o |= Integer.MIN_VALUE;
            return c.this.g(null, 0L, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$fireAdLoadFailedEventOnUiThread$2", f = "NativeAdLoader.kt", l = {}, m = "invokeSuspend")
    public static final class d extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18105j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ g0 f18106k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ q f18107l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.q f18108m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g0 g0Var, q qVar, com.moloco.sdk.internal.ortb.model.q qVar2, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f18106k = g0Var;
            this.f18107l = qVar;
            this.f18108m = qVar2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new d(this.f18106k, this.f18107l, this.f18108m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18105j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.f18106k.c(this.f18107l, this.f18108m);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", l = {PsExtractor.PRIVATE_STREAM_1, 202, 209}, m = "handleAssetsFetching-yxL6bBk")
    public static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18109j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18110k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18111l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18112m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18114o;

        public e(z8.d<? super e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18112m = obj;
            this.f18114o |= Integer.MIN_VALUE;
            Object objB = c.this.b(null, null, null, 0L, this);
            return objB == a9.d.e() ? objB : v8.t.a(objB);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$handleAssetsFetching$result$1", f = "NativeAdLoader.kt", l = {190}, m = "invokeSuspend")
    public static final class f extends l implements p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18115j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.publisher.nativead.model.a f18117l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f18118m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.moloco.sdk.internal.publisher.nativead.model.a aVar, long j10, z8.d<? super f> dVar) {
            super(2, dVar);
            this.f18117l = aVar;
            this.f18118m = j10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> dVar) {
            return ((f) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new f(this.f18117l, this.f18118m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18115j;
            if (i10 == 0) {
                u.b(obj);
                c cVar = c.this;
                com.moloco.sdk.internal.publisher.nativead.model.a aVar = this.f18117l;
                long j10 = this.f18118m;
                this.f18115j = 1;
                obj = cVar.g(aVar, j10, this);
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

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", l = {143, 159}, m = "handleBidParsing-BWLJW6A")
    public static final class g extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18119j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18120k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18121l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f18122m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18124o;

        public g(z8.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18122m = obj;
            this.f18124o |= Integer.MIN_VALUE;
            Object objI = c.this.i(null, null, null, this);
            return objI == a9.d.e() ? objI : v8.t.a(objI);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", l = {175}, m = "handleOrtbParsing-BWLJW6A")
    public static final class h extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18125j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18126k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f18127l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18129n;

        public h(z8.d<? super h> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18127l = obj;
            this.f18129n |= Integer.MIN_VALUE;
            Object objJ = c.this.j(null, null, null, this);
            return objJ == a9.d.e() ? objJ : v8.t.a(objJ);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", l = {99}, m = "load-BWLJW6A")
    public static final class i extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f18130j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18132l;

        public i(z8.d<? super i> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18130j = obj;
            this.f18132l |= Integer.MIN_VALUE;
            Object objM = c.this.m(null, null, null, this);
            return objM == a9.d.e() ? objM : v8.t.a(objM);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2", f = "NativeAdLoader.kt", l = {111, 119, 126, 132}, m = "invokeSuspend")
    public static final class j extends l implements p<o0, z8.d<? super v8.t<? extends b>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f18133j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18134k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18135l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18136m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.acm.f f18138o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f18139p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ g0 f18140q;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2$1", f = "NativeAdLoader.kt", l = {}, m = "invokeSuspend")
        public static final class a extends l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f18141j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ g0 f18142k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ c f18143l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c f18144m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ long f18145n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g0 g0Var, c cVar, com.moloco.sdk.internal.ortb.model.c cVar2, long j10, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f18142k = g0Var;
                this.f18143l = cVar;
                this.f18144m = cVar2;
                this.f18145n = j10;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new a(this.f18142k, this.f18143l, this.f18144m, this.f18145n, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f18141j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.f18142k.a(MolocoAdKt.createAdInfo(this.f18143l.f18087b, kotlin.coroutines.jvm.internal.b.c(this.f18144m.e())), this.f18145n, this.f18144m.d().e());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(com.moloco.sdk.acm.f fVar, String str, g0 g0Var, z8.d<? super j> dVar) {
            super(2, dVar);
            this.f18138o = fVar;
            this.f18139p = str;
            this.f18140q = g0Var;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.t<b>> dVar) {
            return ((j) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new j(this.f18138o, this.f18139p, this.f18140q, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0116 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0166  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", l = {286}, m = "prepareAssets-8Mi8wO0")
    public static final class k extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f18146j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18148l;

        public k(z8.d<? super k> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18146j = obj;
            this.f18148l |= Integer.MIN_VALUE;
            return c.this.k(null, 0L, this);
        }
    }

    public c(@NotNull Context context, @NotNull String adUnitId, @NotNull x bidLoader, @NotNull com.moloco.sdk.internal.publisher.nativead.parser.a ortbResponseParser, @NotNull com.moloco.sdk.internal.publisher.a createLoadTimeoutManager, @NotNull com.moloco.sdk.acm.a acm, @NotNull r timeProvider) {
        t.i(context, "context");
        t.i(adUnitId, "adUnitId");
        t.i(bidLoader, "bidLoader");
        t.i(ortbResponseParser, "ortbResponseParser");
        t.i(createLoadTimeoutManager, "createLoadTimeoutManager");
        t.i(acm, "acm");
        t.i(timeProvider, "timeProvider");
        this.f18086a = context;
        this.f18087b = adUnitId;
        this.f18088c = bidLoader;
        this.f18089d = ortbResponseParser;
        this.f18090e = createLoadTimeoutManager;
        this.f18091f = acm;
        this.f18092g = timeProvider;
        AdFormatType adFormatType = AdFormatType.NATIVE;
        this.f18093h = adFormatType;
        com.moloco.sdk.acm.f fVarW = acm.w(com.moloco.sdk.internal.client_metrics_data.c.CreateToLoad.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.f18094i = fVarW.f(strC, lowerCase);
        this.f18095j = com.moloco.sdk.internal.scheduling.c.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(@org.jetbrains.annotations.Nullable com.moloco.sdk.internal.ortb.model.q r21, @org.jetbrains.annotations.NotNull com.moloco.sdk.internal.publisher.nativead.model.a r22, @org.jetbrains.annotations.NotNull com.moloco.sdk.internal.publisher.g0 r23, long r24, @org.jetbrains.annotations.NotNull z8.d<? super v8.t<com.moloco.sdk.internal.publisher.nativead.model.c>> r26) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.b(com.moloco.sdk.internal.ortb.model.q, com.moloco.sdk.internal.publisher.nativead.model.a, com.moloco.sdk.internal.publisher.g0, long, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(com.moloco.sdk.internal.publisher.nativead.model.a r16, long r17, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> r19) {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.g(com.moloco.sdk.internal.publisher.nativead.model.a, long, z8.d):java.lang.Object");
    }

    public final Object h(g0 g0Var, q qVar, com.moloco.sdk.internal.ortb.model.q qVar2, z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(this.f18095j.getMain(), new d(g0Var, qVar, qVar2, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r12, com.moloco.sdk.acm.f r13, com.moloco.sdk.internal.publisher.g0 r14, z8.d<? super v8.t<com.moloco.sdk.internal.ortb.model.c>> r15) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.i(java.lang.String, com.moloco.sdk.acm.f, com.moloco.sdk.internal.publisher.g0, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r12, com.moloco.sdk.internal.ortb.model.q r13, com.moloco.sdk.internal.publisher.g0 r14, z8.d<? super v8.t<com.moloco.sdk.internal.publisher.nativead.model.a>> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.moloco.sdk.internal.publisher.nativead.c.h
            if (r0 == 0) goto L13
            r0 = r15
            com.moloco.sdk.internal.publisher.nativead.c$h r0 = (com.moloco.sdk.internal.publisher.nativead.c.h) r0
            int r1 = r0.f18129n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18129n = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.c$h r0 = new com.moloco.sdk.internal.publisher.nativead.c$h
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f18127l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18129n
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r12 = r0.f18125j
            v8.u.b(r15)
            goto L66
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            v8.u.b(r15)
            com.moloco.sdk.internal.publisher.nativead.parser.a r15 = r11.f18089d
            java.lang.Object r12 = r15.c(r12)
            java.lang.Throwable r7 = v8.t.e(r12)
            if (r7 == 0) goto L66
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r5 = "NativeAdLoader"
            java.lang.String r6 = "handleOrtbParsing"
            r8 = 0
            r9 = 8
            r10 = 0
            com.moloco.sdk.internal.MolocoLogger.error$default(r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r15 = r11.f18087b
            com.moloco.sdk.publisher.MolocoAdError$ErrorType r2 = com.moloco.sdk.publisher.MolocoAdError.ErrorType.AD_LOAD_FAILED
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f r4 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_ORTB_RESPONSE_NULL_ERROR
            com.moloco.sdk.internal.q r15 = com.moloco.sdk.internal.r.a(r15, r2, r4)
            r0.f18125j = r12
            r0.f18126k = r12
            r0.f18129n = r3
            java.lang.Object r13 = r11.h(r14, r15, r13, r0)
            if (r13 != r1) goto L66
            return r1
        L66:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.j(java.lang.String, com.moloco.sdk.internal.ortb.model.q, com.moloco.sdk.internal.publisher.g0, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.util.List<? extends com.moloco.sdk.internal.publisher.nativead.model.a.AbstractC0316a> r8, long r9, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.internal.publisher.nativead.parser.b>> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.moloco.sdk.internal.publisher.nativead.c.k
            if (r0 == 0) goto L13
            r0 = r11
            com.moloco.sdk.internal.publisher.nativead.c$k r0 = (com.moloco.sdk.internal.publisher.nativead.c.k) r0
            int r1 = r0.f18148l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18148l = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.c$k r0 = new com.moloco.sdk.internal.publisher.nativead.c$k
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f18146j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18148l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r11)
            goto L3f
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            v8.u.b(r11)
            android.content.Context r11 = r7.f18086a
            r0.f18148l = r3
            java.lang.Object r11 = com.moloco.sdk.internal.publisher.nativead.parser.c.a(r11, r8, r9, r0)
            if (r11 != r1) goto L3f
            return r1
        L3f:
            com.moloco.sdk.internal.t r11 = (com.moloco.sdk.internal.t) r11
            boolean r8 = r11 instanceof com.moloco.sdk.internal.t.b
            if (r8 == 0) goto L51
            com.moloco.sdk.internal.t$b r8 = new com.moloco.sdk.internal.t$b
            com.moloco.sdk.internal.t$b r11 = (com.moloco.sdk.internal.t.b) r11
            java.lang.Object r9 = r11.a()
            r8.<init>(r9)
            goto L74
        L51:
            boolean r8 = r11 instanceof com.moloco.sdk.internal.t.a
            if (r8 == 0) goto L75
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            com.moloco.sdk.internal.t$a r11 = (com.moloco.sdk.internal.t.a) r11
            java.lang.Object r8 = r11.a()
            r3 = r8
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.String r1 = "NativeAdLoader"
            java.lang.String r2 = "NativeAd prepareAssets failed"
            r4 = 0
            r5 = 8
            r6 = 0
            com.moloco.sdk.internal.MolocoLogger.error$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.internal.t$a r8 = new com.moloco.sdk.internal.t$a
            java.lang.Object r9 = r11.a()
            r8.<init>(r9)
        L74:
            return r8
        L75:
            v8.q r8 = new v8.q
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.k(java.util.List, long, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull com.moloco.sdk.acm.f r12, @org.jetbrains.annotations.NotNull com.moloco.sdk.internal.publisher.g0 r13, @org.jetbrains.annotations.NotNull z8.d<? super v8.t<com.moloco.sdk.internal.publisher.nativead.c.b>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.moloco.sdk.internal.publisher.nativead.c.i
            if (r0 == 0) goto L13
            r0 = r14
            com.moloco.sdk.internal.publisher.nativead.c$i r0 = (com.moloco.sdk.internal.publisher.nativead.c.i) r0
            int r1 = r0.f18132l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18132l = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.c$i r0 = new com.moloco.sdk.internal.publisher.nativead.c$i
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f18130j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18132l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r14)
            goto L4e
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            v8.u.b(r14)
            com.moloco.sdk.internal.scheduling.a r14 = r10.f18095j
            z8.g r14 = r14.getDefault()
            com.moloco.sdk.internal.publisher.nativead.c$j r2 = new com.moloco.sdk.internal.publisher.nativead.c$j
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r12
            r7 = r11
            r8 = r13
            r4.<init>(r6, r7, r8, r9)
            r0.f18132l = r3
            java.lang.Object r14 = kotlinx.coroutines.i.g(r14, r2, r0)
            if (r14 != r1) goto L4e
            return r1
        L4e:
            v8.t r14 = (v8.t) r14
            java.lang.Object r11 = r14.j()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.m(java.lang.String, com.moloco.sdk.acm.f, com.moloco.sdk.internal.publisher.g0, z8.d):java.lang.Object");
    }
}
