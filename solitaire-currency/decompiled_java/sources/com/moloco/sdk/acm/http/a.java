package com.moloco.sdk.acm.http;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.acm.http.a$a, reason: collision with other inner class name */
    public static final class C0291a extends v implements l<e8.l, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f17430g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f17431h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f17432i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f17433j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f17434k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f17435l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0291a(String str, String str2, String str3, String str4, String str5, String str6) {
            super(1);
            this.f17430g = str;
            this.f17431h = str2;
            this.f17432i = str3;
            this.f17433j = str4;
            this.f17434k = str5;
            this.f17435l = str6;
        }

        public final void a(@NotNull e8.l lVar) {
            t.i(lVar, "$this$null");
            StringBuilder sb = new StringBuilder();
            String str = this.f17430g;
            String str2 = this.f17431h;
            String str3 = this.f17432i;
            if (str != null) {
                sb.append("AppBundle/" + str + ';');
            }
            if (str2 != null) {
                sb.append("AppVersion/" + str2 + ';');
            }
            if (str3 != null) {
                sb.append("AppKey/" + str3 + ';');
            }
            String string = sb.toString();
            t.h(string, "StringBuilder().apply {\n…\") }\n        }.toString()");
            StringBuilder sb2 = new StringBuilder();
            String str4 = this.f17433j;
            String str5 = this.f17434k;
            if (str4 != null) {
                sb2.append("SdkVersion/" + str4 + ';');
            }
            if (str5 != null) {
                sb2.append("Mediator/" + str5 + ';');
            }
            String string2 = sb2.toString();
            t.h(string2, "StringBuilder().apply {\n…\") }\n        }.toString()");
            StringBuilder sb3 = new StringBuilder();
            String str6 = this.f17435l;
            sb3.append("OS/Android;");
            if (str6 != null) {
                sb3.append("osv/" + str6 + ';');
            }
            String string3 = sb3.toString();
            t.h(string3, "StringBuilder().apply {\n…\") }\n        }.toString()");
            lVar.f("X-Moloco-App-Info", string);
            lVar.f("X-Moloco-Device-Info", string3);
            lVar.f("X-Moloco-SDK-Info", string2);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(e8.l lVar) {
            a(lVar);
            return k0.f35197a;
        }
    }

    @NotNull
    public final l<e8.l, k0> a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new C0291a(str4, str5, str3, str, str6, str2);
    }
}
