package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f20722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f20723b;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastTrackerImpl$track$1", f = "VastTracker.kt", l = {105}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20724j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20725k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20726l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20727m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20728n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20729o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f20730p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Object f20731q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f20732r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ List<String> f20733s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f20734t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ a.AbstractC0481a.f f20735u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ o f20736v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ List<a.AbstractC0481a.c> f20737w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final /* synthetic */ z f20738x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final /* synthetic */ Integer f20739y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final /* synthetic */ String f20740z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<String> list, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, a.AbstractC0481a.f fVar, o oVar, List<a.AbstractC0481a.c> list2, z zVar, Integer num, String str, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f20733s = list;
            this.f20734t = aVar;
            this.f20735u = fVar;
            this.f20736v = oVar;
            this.f20737w = list2;
            this.f20738x = zVar;
            this.f20739y = num;
            this.f20740z = str;
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
            return new a(this.f20733s, this.f20734t, this.f20735u, this.f20736v, this.f20737w, this.f20738x, this.f20739y, this.f20740z, dVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
        
            r13 = r13;
            r14 = r14;
            r11 = r11;
            r12 = r12;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009b -> B:18:0x00a3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.o.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public o(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        t.i(persistentHttpRequest, "persistentHttpRequest");
        this.f20722a = persistentHttpRequest;
        this.f20723b = p0.a(com.moloco.sdk.internal.scheduling.c.a().getDefault());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n
    public void a(@NotNull List<String> urls, @Nullable z zVar, @Nullable Integer num, @Nullable String str) {
        t.i(urls, "urls");
        f(urls, zVar, num, str, v.l(), null, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n
    public void b(@NotNull List<String> urls, @Nullable z zVar, @Nullable Integer num, @Nullable String str, @NotNull List<a.AbstractC0481a.c> renderedButtons, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull a.AbstractC0481a.f lastClickPosition) {
        t.i(urls, "urls");
        t.i(renderedButtons, "renderedButtons");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(lastClickPosition, "lastClickPosition");
        f(urls, zVar, num, str, renderedButtons, customUserEventBuilderService, lastClickPosition);
    }

    public final Object e(String str, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, a.AbstractC0481a.f fVar, long j10, List<a.AbstractC0481a.c> list, z8.d<? super String> dVar) {
        return aVar.a(j10, new a.AbstractC0481a.d(fVar, null, null, list, 6, null), str, dVar);
    }

    public final void f(List<String> list, z zVar, Integer num, String str, List<a.AbstractC0481a.c> list2, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, a.AbstractC0481a.f fVar) {
        if (list.isEmpty()) {
            return;
        }
        kotlinx.coroutines.k.d(this.f20723b, null, null, new a(list, aVar, fVar, this, list2, zVar, num, str, null), 3, null);
    }
}
