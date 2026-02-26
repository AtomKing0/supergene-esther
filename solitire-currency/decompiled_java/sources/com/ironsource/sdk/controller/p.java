package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ironsource.i9;
import com.ironsource.ln;
import com.ironsource.mn;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface p {

    public static final class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private b f15098a;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String method, @NotNull mn openUrlConfigurations) {
            this(method, openUrlConfigurations, new k.b(), new k.a());
            kotlin.jvm.internal.t.i(method, "method");
            kotlin.jvm.internal.t.i(openUrlConfigurations, "openUrlConfigurations");
        }

        @Override // com.ironsource.sdk.controller.p
        @NotNull
        public c a(@NotNull Context context, @NotNull ln openUrl) {
            kotlin.jvm.internal.t.i(context, "context");
            kotlin.jvm.internal.t.i(openUrl, "openUrl");
            try {
                return this.f15098a.a(context, openUrl);
            } catch (Exception e10) {
                i9.d().a(e10);
                String message = e10.getMessage();
                String message2 = message == null || message.length() == 0 ? "" : e10.getMessage();
                kotlin.jvm.internal.t.f(message2);
                return new c.a(message2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(@org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull com.ironsource.mn r4, @org.jetbrains.annotations.NotNull com.ironsource.h r5, @org.jetbrains.annotations.NotNull com.ironsource.g r6) {
            /*
                r2 = this;
                java.lang.String r0 = "method"
                kotlin.jvm.internal.t.i(r3, r0)
                java.lang.String r0 = "openUrlConfigurations"
                kotlin.jvm.internal.t.i(r4, r0)
                java.lang.String r0 = "activityIntentFactory"
                kotlin.jvm.internal.t.i(r5, r0)
                java.lang.String r0 = "actionIntentFactory"
                kotlin.jvm.internal.t.i(r6, r0)
                r2.<init>()
                int r0 = r3.hashCode()
                r1 = -1455867212(0xffffffffa9393ab4, float:-4.112917E-14)
                if (r0 == r1) goto L49
                r6 = 109770977(0x68af8e1, float:5.2275525E-35)
                if (r0 == r6) goto L3a
                r6 = 1224424441(0x48fb3bf9, float:514527.78)
                if (r0 == r6) goto L2b
                goto L57
            L2b:
                java.lang.String r6 = "webview"
                boolean r6 = r3.equals(r6)
                if (r6 != 0) goto L34
                goto L57
            L34:
                com.ironsource.sdk.controller.p$b$d r3 = new com.ironsource.sdk.controller.p$b$d
                r3.<init>(r4, r5)
                goto L5d
            L3a:
                java.lang.String r6 = "store"
                boolean r6 = r3.equals(r6)
                if (r6 != 0) goto L43
                goto L57
            L43:
                com.ironsource.sdk.controller.p$b$c r3 = new com.ironsource.sdk.controller.p$b$c
                r3.<init>(r4, r5)
                goto L5d
            L49:
                java.lang.String r5 = "external_browser"
                boolean r5 = r3.equals(r5)
                if (r5 == 0) goto L57
                com.ironsource.sdk.controller.p$b$a r3 = new com.ironsource.sdk.controller.p$b$a
                r3.<init>(r4, r6)
                goto L5d
            L57:
                com.ironsource.sdk.controller.p$b$b r4 = new com.ironsource.sdk.controller.p$b$b
                r4.<init>(r3)
                r3 = r4
            L5d:
                r2.f15098a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.p.a.<init>(java.lang.String, com.ironsource.mn, com.ironsource.h, com.ironsource.g):void");
        }
    }

    public interface b {

        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            private final mn f15099a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final com.ironsource.g f15100b;

            public a(@NotNull mn configurations, @NotNull com.ironsource.g intentFactory) {
                kotlin.jvm.internal.t.i(configurations, "configurations");
                kotlin.jvm.internal.t.i(intentFactory, "intentFactory");
                this.f15099a = configurations;
                this.f15100b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            @NotNull
            public c a(@NotNull Context context, @NotNull ln openUrl) {
                kotlin.jvm.internal.t.i(context, "context");
                kotlin.jvm.internal.t.i(openUrl, "openUrl");
                if (TextUtils.isEmpty(openUrl.d())) {
                    return new c.a("url is empty");
                }
                Intent intentA = this.f15100b.a();
                intentA.setData(Uri.parse(openUrl.d()));
                String strC = openUrl.c();
                if (!(strC == null || strC.length() == 0)) {
                    intentA = intentA.setPackage(openUrl.c());
                    kotlin.jvm.internal.t.h(intentA, "this.setPackage(openUrl.packageName)");
                }
                if (!(context instanceof Activity)) {
                    intentA = intentA.addFlags(this.f15099a.c());
                }
                kotlin.jvm.internal.t.h(intentA, "intentFactory\n          …ations.flags) else this }");
                context.startActivity(intentA);
                return c.b.f15107a;
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.p$b$b, reason: collision with other inner class name */
        public static final class C0269b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            private final String f15101a;

            public C0269b(@NotNull String method) {
                kotlin.jvm.internal.t.i(method, "method");
                this.f15101a = method;
            }

            @Override // com.ironsource.sdk.controller.p.b
            @NotNull
            public c a(@NotNull Context context, @NotNull ln openUrl) {
                kotlin.jvm.internal.t.i(context, "context");
                kotlin.jvm.internal.t.i(openUrl, "openUrl");
                return new c.a("method " + this.f15101a + " is unsupported");
            }
        }

        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            private final mn f15102a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final com.ironsource.h f15103b;

            public c(@NotNull mn configurations, @NotNull com.ironsource.h intentFactory) {
                kotlin.jvm.internal.t.i(configurations, "configurations");
                kotlin.jvm.internal.t.i(intentFactory, "intentFactory");
                this.f15102a = configurations;
                this.f15103b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            @NotNull
            public c a(@NotNull Context context, @NotNull ln openUrl) {
                kotlin.jvm.internal.t.i(context, "context");
                kotlin.jvm.internal.t.i(openUrl, "openUrl");
                context.startActivity(new OpenUrlActivity.e(this.f15103b).a(this.f15102a.c()).a(openUrl.d()).b(true).c(true).a(context));
                return c.b.f15107a;
            }
        }

        public static final class d implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            private final mn f15104a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final com.ironsource.h f15105b;

            public d(@NotNull mn configurations, @NotNull com.ironsource.h intentFactory) {
                kotlin.jvm.internal.t.i(configurations, "configurations");
                kotlin.jvm.internal.t.i(intentFactory, "intentFactory");
                this.f15104a = configurations;
                this.f15105b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            @NotNull
            public c a(@NotNull Context context, @NotNull ln openUrl) {
                kotlin.jvm.internal.t.i(context, "context");
                kotlin.jvm.internal.t.i(openUrl, "openUrl");
                context.startActivity(new OpenUrlActivity.e(this.f15105b).a(this.f15104a.c()).a(openUrl.d()).a(this.f15104a.d()).b(true).a(context));
                return c.b.f15107a;
            }
        }

        @NotNull
        c a(@NotNull Context context, @NotNull ln lnVar);
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            private final String f15106a;

            /* JADX WARN: Multi-variable type inference failed */
            public a() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ a a(a aVar, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = aVar.f15106a;
                }
                return aVar.a(str);
            }

            @NotNull
            public final String b() {
                return this.f15106a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.t.d(this.f15106a, ((a) obj).f15106a);
            }

            public int hashCode() {
                return this.f15106a.hashCode();
            }

            @NotNull
            public String toString() {
                return "Error(errorMessage=" + this.f15106a + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull String errorMessage) {
                super(null);
                kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
                this.f15106a = errorMessage;
            }

            @NotNull
            public final a a(@NotNull String errorMessage) {
                kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
                return new a(errorMessage);
            }

            public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.k kVar) {
                this((i10 & 1) != 0 ? "" : str);
            }

            @NotNull
            public final String a() {
                return this.f15106a;
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f15107a = new b();

            private b() {
                super(null);
            }
        }

        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    @NotNull
    c a(@NotNull Context context, @NotNull ln lnVar);
}
