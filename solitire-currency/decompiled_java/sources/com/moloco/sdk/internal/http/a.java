package com.moloco.sdk.internal.http;

import a8.e;
import com.moloco.sdk.internal.services.g0;
import com.moloco.sdk.internal.services.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.c;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import y7.d;
import y7.g0;
import y7.u;
import y7.y;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a, reason: collision with other inner class name */
    public static final class C0302a extends v implements l<s7.b<?>, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ t f17642g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ g0 f17643h;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a$a, reason: collision with other inner class name */
        public static final class C0303a extends v implements l<g0.a, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0303a f17644g = new C0303a();

            public C0303a() {
                super(1);
            }

            public final void a(@NotNull g0.a install) {
                kotlin.jvm.internal.t.i(install, "$this$install");
                install.b(c.a().invoke());
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(g0.a aVar) {
                a(aVar);
                return k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a$b */
        public static final class b extends v implements l<d.a, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ t f17645g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.internal.services.g0 f17646h;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.http.a$a$b$a, reason: collision with other inner class name */
            public static final class C0304a extends v implements l<e8.l, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ t f17647g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.internal.services.g0 f17648h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0304a(t tVar, com.moloco.sdk.internal.services.g0 g0Var) {
                    super(1);
                    this.f17647g = tVar;
                    this.f17648h = g0Var;
                }

                /* JADX WARN: Removed duplicated region for block: B:6:0x00ad  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void a(@org.jetbrains.annotations.NotNull e8.l r5) {
                    /*
                        r4 = this;
                        java.lang.String r0 = "$this$headers"
                        kotlin.jvm.internal.t.i(r5, r0)
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "AppBundle/"
                        r0.append(r1)
                        com.moloco.sdk.internal.services.t r1 = r4.f17647g
                        java.lang.String r1 = r1.a()
                        r0.append(r1)
                        java.lang.String r1 = "; AppVersion/"
                        r0.append(r1)
                        com.moloco.sdk.internal.services.t r1 = r4.f17647g
                        java.lang.String r1 = r1.b()
                        r0.append(r1)
                        java.lang.String r1 = "; AppKey/"
                        r0.append(r1)
                        com.moloco.sdk.publisher.Moloco r1 = com.moloco.sdk.publisher.Moloco.INSTANCE
                        java.lang.String r2 = r1.getAppKey$moloco_sdk_release()
                        r0.append(r2)
                        r2 = 59
                        r0.append(r2)
                        java.lang.String r0 = r0.toString()
                        java.lang.String r3 = "X-Moloco-App-Info"
                        r5.f(r3, r0)
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r3 = "make/"
                        r0.append(r3)
                        com.moloco.sdk.internal.services.g0 r3 = r4.f17648h
                        java.lang.String r3 = r3.f()
                        r0.append(r3)
                        java.lang.String r3 = "; model/"
                        r0.append(r3)
                        com.moloco.sdk.internal.services.g0 r3 = r4.f17648h
                        java.lang.String r3 = r3.h()
                        r0.append(r3)
                        java.lang.String r3 = "; hwv/"
                        r0.append(r3)
                        com.moloco.sdk.internal.services.g0 r3 = r4.f17648h
                        java.lang.String r3 = r3.d()
                        r0.append(r3)
                        java.lang.String r3 = "; osv/"
                        r0.append(r3)
                        com.moloco.sdk.internal.services.g0 r3 = r4.f17648h
                        java.lang.String r3 = r3.j()
                        r0.append(r3)
                        java.lang.String r3 = "; OS/Android;"
                        r0.append(r3)
                        java.lang.String r0 = r0.toString()
                        java.lang.String r3 = "X-Moloco-Device-Info"
                        r5.f(r3, r0)
                        com.moloco.sdk.publisher.MediationInfo r0 = r1.getMediationInfo$moloco_sdk_release()
                        if (r0 == 0) goto Lad
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r3 = "Mediator/"
                        r1.append(r3)
                        java.lang.String r0 = r0.getName()
                        r1.append(r0)
                        r1.append(r2)
                        java.lang.String r0 = r1.toString()
                        if (r0 != 0) goto Laf
                    Lad:
                        java.lang.String r0 = ""
                    Laf:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "SdkVersion/3.9.0; "
                        r1.append(r2)
                        r1.append(r0)
                        java.lang.String r0 = r1.toString()
                        java.lang.String r1 = "X-Moloco-SDK-Info"
                        r5.f(r1, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.http.a.C0302a.b.C0304a.a(e8.l):void");
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(e8.l lVar) {
                    a(lVar);
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(t tVar, com.moloco.sdk.internal.services.g0 g0Var) {
                super(1);
                this.f17645g = tVar;
                this.f17646h = g0Var;
            }

            public final void a(@NotNull d.a defaultRequest) {
                kotlin.jvm.internal.t.i(defaultRequest, "$this$defaultRequest");
                e.a(defaultRequest, new C0304a(this.f17645g, this.f17646h));
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(d.a aVar) {
                a(aVar);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0302a(t tVar, com.moloco.sdk.internal.services.g0 g0Var) {
            super(1);
            this.f17642g = tVar;
            this.f17643h = g0Var;
        }

        public final void a(@NotNull s7.b<?> HttpClient) {
            kotlin.jvm.internal.t.i(HttpClient, "$this$HttpClient");
            HttpClient.i(y7.g0.f36694b, C0303a.f17644g);
            s7.b.j(HttpClient, y.f36881d, null, 2, null);
            s7.b.j(HttpClient, u.f36804g, null, 2, null);
            y7.e.b(HttpClient, new b(this.f17642g, this.f17643h));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(s7.b<?> bVar) {
            a(bVar);
            return k0.f35197a;
        }
    }

    @NotNull
    public static final s7.a a(@NotNull t appInfo, @NotNull com.moloco.sdk.internal.services.g0 deviceInfo) {
        kotlin.jvm.internal.t.i(appInfo, "appInfo");
        kotlin.jvm.internal.t.i(deviceInfo, "deviceInfo");
        return s7.d.a(new C0302a(appInfo, deviceInfo));
    }
}
