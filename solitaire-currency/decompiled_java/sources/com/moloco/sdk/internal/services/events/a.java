package com.moloco.sdk.internal.services.events;

import com.moloco.sdk.internal.services.b;
import com.moloco.sdk.internal.services.g0;
import com.moloco.sdk.internal.services.h0;
import com.moloco.sdk.internal.services.i;
import com.moloco.sdk.internal.services.j;
import com.moloco.sdk.internal.services.l;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.w;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final u f18644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.e f18645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final h0 f18646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final l f18647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.usertracker.e f18648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final i f18649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.proto.a f18650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b f18651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final String f18652i;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.events.a$a, reason: collision with other inner class name */
    @f(c = "com.moloco.sdk.internal.services.events.CustomUserEventBuilderServiceImpl", f = "CustomUserEventBuilderServiceImpl.kt", l = {67}, m = "userAdInteractionExt")
    public static final class C0330a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18653j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18654k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f18655l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f18656m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f18657n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f18658o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public /* synthetic */ Object f18659p;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f18661r;

        public C0330a(z8.d<? super C0330a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18659p = obj;
            this.f18661r |= Integer.MIN_VALUE;
            return a.this.g(0L, null, this);
        }
    }

    @f(c = "com.moloco.sdk.internal.services.events.CustomUserEventBuilderServiceImpl", f = "CustomUserEventBuilderServiceImpl.kt", l = {52}, m = "userAdInteractionExtAsQueryParameter")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18662j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18663k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18665m;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18663k = obj;
            this.f18665m |= Integer.MIN_VALUE;
            return a.this.a(0L, null, null, this);
        }
    }

    public a(@NotNull u appInfoService, @NotNull com.moloco.sdk.internal.services.e networkInfoService, @NotNull h0 deviceInfoService, @NotNull l screenInfoService, @NotNull com.moloco.sdk.internal.services.usertracker.e userIdentifierService, @NotNull i adDataService, @NotNull com.moloco.sdk.internal.services.proto.a encoderService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b userEventConfigService, @NotNull String sdkVersion) {
        t.i(appInfoService, "appInfoService");
        t.i(networkInfoService, "networkInfoService");
        t.i(deviceInfoService, "deviceInfoService");
        t.i(screenInfoService, "screenInfoService");
        t.i(userIdentifierService, "userIdentifierService");
        t.i(adDataService, "adDataService");
        t.i(encoderService, "encoderService");
        t.i(userEventConfigService, "userEventConfigService");
        t.i(sdkVersion, "sdkVersion");
        this.f18644a = appInfoService;
        this.f18645b = networkInfoService;
        this.f18646c = deviceInfoService;
        this.f18647d = screenInfoService;
        this.f18648e = userIdentifierService;
        this.f18649f = adDataService;
        this.f18650g = encoderService;
        this.f18651h = userEventConfigService;
        this.f18652i = sdkVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(long r11, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a r13, @org.jetbrains.annotations.NotNull java.lang.String r14, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.String> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.moloco.sdk.internal.services.events.a.b
            if (r0 == 0) goto L13
            r0 = r15
            com.moloco.sdk.internal.services.events.a$b r0 = (com.moloco.sdk.internal.services.events.a.b) r0
            int r1 = r0.f18665m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18665m = r1
            goto L18
        L13:
            com.moloco.sdk.internal.services.events.a$b r0 = new com.moloco.sdk.internal.services.events.a$b
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f18663k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18665m
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.f18662j
            r14 = r11
            java.lang.String r14 = (java.lang.String) r14
            v8.u.b(r15)
            goto L59
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            v8.u.b(r15)
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b r15 = r10.f18651h
            boolean r15 = r15.c()
            if (r15 != 0) goto L4e
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r5 = "CustomUserEventBuilderServiceImpl"
            java.lang.String r6 = "Event reporting config disabled, UserAdInteractionExt not reporting"
            r7 = 0
            r8 = 4
            r9 = 0
            com.moloco.sdk.internal.MolocoLogger.debug$default(r4, r5, r6, r7, r8, r9)
            return r14
        L4e:
            r0.f18662j = r14
            r0.f18665m = r3
            java.lang.Object r15 = r10.g(r11, r13, r0)
            if (r15 != r1) goto L59
            return r1
        L59:
            java.lang.String r15 = (java.lang.String) r15
            android.net.Uri r11 = android.net.Uri.parse(r14)
            android.net.Uri$Builder r11 = r11.buildUpon()
            java.lang.String r12 = "user_ad_interaction_ext"
            android.net.Uri$Builder r11 = r11.appendQueryParameter(r12, r15)
            android.net.Uri r11 = r11.build()
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = "parse(\n            url\n …     ).build().toString()"
            kotlin.jvm.internal.t.h(r11, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.events.a.a(long, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, java.lang.String, z8.d):java.lang.Object");
    }

    public final t.d b(t.d dVar) {
        t.i.a aVarC = t.i.c();
        aVarC.b(this.f18652i);
        dVar.l(aVarC.build());
        return dVar;
    }

    public final t.d c(t.d dVar, com.moloco.sdk.internal.services.b bVar) {
        t.j.a aVarD = t.j.d();
        if (bVar instanceof b.a) {
            aVarD.c(t.j.b.CELLULAR);
            aVarD.b(((b.a) bVar).a());
        } else if (kotlin.jvm.internal.t.d(bVar, b.C0326b.f18413a)) {
            aVarD.c(t.j.b.UNKNOWN);
        } else if (kotlin.jvm.internal.t.d(bVar, b.c.f18414a)) {
            aVarD.c(t.j.b.WIFI);
        }
        dVar.k(aVarD.build());
        return dVar;
    }

    public final t.d d(t.d dVar, com.moloco.sdk.internal.services.t tVar) {
        t.a.C0350a c0350aD = t.a.d();
        c0350aD.b(tVar.a());
        c0350aD.c(tVar.b());
        dVar.c(c0350aD.build());
        return dVar;
    }

    public final t.d e(t.d dVar, g0 g0Var) {
        t.g.a aVarF = t.g.f();
        aVarF.d(g0Var.j());
        aVarF.b(g0Var.h());
        aVarF.c(t.g.b.ANDROID);
        aVarF.e(g0Var.k());
        dVar.h(aVarF.build());
        return dVar;
    }

    public final t.d f(t.d dVar, a.AbstractC0481a abstractC0481a, j jVar) {
        if (abstractC0481a instanceof a.AbstractC0481a.e) {
            dVar.i(t.h.b().build());
        } else if (abstractC0481a instanceof a.AbstractC0481a.d) {
            t.f.a aVarI = t.f.i();
            a.AbstractC0481a.d dVar2 = (a.AbstractC0481a.d) abstractC0481a;
            aVarI.c(com.moloco.sdk.internal.services.events.b.b(dVar2.b()));
            aVarI.d(com.moloco.sdk.internal.services.events.b.c(jVar));
            a.AbstractC0481a.g gVarD = dVar2.d();
            if (gVarD != null) {
                aVarI.f(com.moloco.sdk.internal.services.events.b.d(gVarD));
            }
            a.AbstractC0481a.f fVarC = dVar2.c();
            if (fVarC != null) {
                aVarI.e(com.moloco.sdk.internal.services.events.b.b(fVarC));
            }
            List<a.AbstractC0481a.c> listA = dVar2.a();
            ArrayList arrayList = new ArrayList(w.v(listA, 10));
            for (a.AbstractC0481a.c cVar : listA) {
                t.e.a aVarE = t.e.e();
                aVarE.d(com.moloco.sdk.internal.services.events.b.a(cVar.c()));
                aVarE.b(com.moloco.sdk.internal.services.events.b.b(cVar.d()));
                aVarE.c(com.moloco.sdk.internal.services.events.b.d(cVar.e()));
                arrayList.add(aVarE.build());
            }
            aVarI.b(arrayList);
            dVar.f((t.f) aVarI.build());
        } else if (abstractC0481a instanceof a.AbstractC0481a.b) {
            t.c.a aVarC = t.c.c();
            aVarC.b(((a.AbstractC0481a.b) abstractC0481a).a());
            dVar.e(aVarC.build());
        } else if (abstractC0481a instanceof a.AbstractC0481a.C0482a) {
            dVar.d(t.b.b().build());
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(long r8, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a r10, z8.d<? super java.lang.String> r11) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.events.a.g(long, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, z8.d):java.lang.Object");
    }
}
