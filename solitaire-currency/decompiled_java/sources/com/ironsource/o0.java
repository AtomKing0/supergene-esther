package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 implements au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final eh f14189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14190c;

    static final class a extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14191a = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.r();
        }
    }

    static final class b extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14192a = new b();

        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.o();
        }
    }

    static final class c extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14193a = new c();

        c() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.n();
        }
    }

    static final class d extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14194a = new d();

        d() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.q();
        }
    }

    static final class e extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f14195a = new e();

        e() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.o();
        }
    }

    static final class f extends kotlin.jvm.internal.v implements h9.a<IronSourceError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f14196a = new f();

        f() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return hb.f12462a.g();
        }
    }

    public o0(@NotNull String adm, @Nullable eh ehVar, boolean z10) {
        kotlin.jvm.internal.t.i(adm, "adm");
        this.f14188a = adm;
        this.f14189b = ehVar;
        this.f14190c = z10;
    }

    @Override // com.ironsource.au
    public void a() throws fq {
        a(this.f14190c, a.f14191a);
        a(this.f14189b != null, b.f14192a);
        eh ehVar = this.f14189b;
        if (ehVar != null) {
            if (ehVar.c() == gh.NonBidder) {
                a(this.f14188a.length() == 0, c.f14193a);
            }
            if (ehVar.c() == gh.Bidder) {
                a(this.f14188a.length() > 0, d.f14194a);
            }
            a(ehVar.c() != gh.NotSupported, e.f14195a);
            a(ehVar.b().length() > 0, f.f14196a);
        }
    }

    @Override // com.ironsource.au
    public /* synthetic */ void a(boolean z10, h9.a aVar) {
        av.a(this, z10, aVar);
    }
}
