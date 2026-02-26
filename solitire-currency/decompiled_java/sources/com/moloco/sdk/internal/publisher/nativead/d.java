package com.moloco.sdk.internal.publisher.nativead;

import com.moloco.sdk.internal.h;
import com.moloco.sdk.internal.ortb.model.q;
import com.moloco.sdk.internal.publisher.h0;
import com.moloco.sdk.internal.publisher.nativead.model.a;
import com.moloco.sdk.internal.publisher.r;
import com.moloco.sdk.internal.services.m;
import com.moloco.sdk.internal.w;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.ortb.model.c f18150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.nativead.model.a f18151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final m f18152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f18153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final AdFormatType f18154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final i f18155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final z f18156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final h0 f18157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final a f18158j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public List<String> f18159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public List<a.b> f18160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final i f18161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final Set<String> f18162d;

        public a(@Nullable List<String> list, @Nullable List<a.b> list2, @NotNull i persistentHttpRequest) {
            t.i(persistentHttpRequest, "persistentHttpRequest");
            this.f18159a = list;
            this.f18160b = list2;
            this.f18161c = persistentHttpRequest;
            this.f18162d = new LinkedHashSet();
        }

        public final void a() {
            List<String> list = this.f18159a;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    this.f18161c.a((String) it.next());
                }
            }
            this.f18159a = null;
            List<a.b> list2 = this.f18160b;
            if (list2 != null) {
                for (a.b bVar : list2) {
                    if (bVar.c() != null && bVar.a() == 1 && bVar.b() == 1) {
                        this.f18161c.a(bVar.c());
                    }
                }
            }
            this.f18160b = null;
        }

        public final void b(@NotNull List<String> urls) {
            t.i(urls, "urls");
            for (String str : urls) {
                if (!this.f18162d.contains(str)) {
                    this.f18161c.a(str);
                    this.f18162d.add(str);
                }
            }
        }
    }

    public static final class b extends v implements h9.a<q> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c f18163g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.ortb.model.c cVar) {
            super(0);
            this.f18163g = cVar;
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final q invoke() {
            return this.f18163g.d().e();
        }
    }

    public static final class c extends v implements h9.a<r> {
        public c() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final r invoke() {
            String strC = d.this.f18150b.c();
            if (strC != null) {
                return new r(strC, Float.valueOf(d.this.f18150b.e()));
            }
            return null;
        }
    }

    public d(@NotNull String adUnitId, @NotNull com.moloco.sdk.internal.ortb.model.c bid, @NotNull com.moloco.sdk.internal.publisher.nativead.model.a ortbResponse, @NotNull m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull AdFormatType adFormatType, @NotNull i persistentHttpRequest, @NotNull z externalLinkHandler) {
        t.i(adUnitId, "adUnitId");
        t.i(bid, "bid");
        t.i(ortbResponse, "ortbResponse");
        t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(adFormatType, "adFormatType");
        t.i(persistentHttpRequest, "persistentHttpRequest");
        t.i(externalLinkHandler, "externalLinkHandler");
        this.f18149a = adUnitId;
        this.f18150b = bid;
        this.f18151c = ortbResponse;
        this.f18152d = appLifecycleTrackerService;
        this.f18153e = customUserEventBuilderService;
        this.f18154f = adFormatType;
        this.f18155g = persistentHttpRequest;
        this.f18156h = externalLinkHandler;
        this.f18157i = b();
        this.f18158j = c();
    }

    public final h0 b() {
        return com.moloco.sdk.internal.publisher.b.a(null, this.f18152d, this.f18153e, new b(this.f18150b), new c(), (96 & 32) != 0 ? w.a() : null, (96 & 64) != 0 ? h.a() : null, this.f18154f);
    }

    public final a c() {
        com.moloco.sdk.internal.publisher.nativead.model.a aVar = this.f18151c;
        return new a(aVar.c(), aVar.b(), this.f18155g);
    }

    public final void d() {
        a.c cVarD = this.f18151c.d();
        if (cVarD != null) {
            this.f18158j.b(cVarD.a());
            this.f18156h.a(cVarD.b());
        }
        this.f18157i.onAdClicked(MolocoAdKt.createAdInfo$default(this.f18149a, null, 2, null));
    }

    public final void e() {
        this.f18158j.a();
        this.f18157i.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.f18149a, null, 2, null));
    }
}
