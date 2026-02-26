package com.vungle.ads.internal.network;

import androidx.annotation.VisibleForTesting;
import com.ironsource.nb;
import com.vungle.ads.internal.model.f;
import com.vungle.ads.o;
import ga.b0;
import ga.c0;
import ga.e;
import h9.l;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: VungleApiImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements VungleApi {

    @NotNull
    private static final String VUNGLE_VERSION = "7.1.0";

    @Nullable
    private String appId;

    @NotNull
    private final com.vungle.ads.internal.network.converters.b emptyResponseConverter;

    @NotNull
    private final e.a okHttpClient;

    @NotNull
    public static final b Companion = new b(null);

    @NotNull
    private static final kotlinx.serialization.json.a json = m.b(null, a.INSTANCE, 1, null);

    /* JADX INFO: compiled from: VungleApiImpl.kt */
    static final class a extends v implements l<kotlinx.serialization.json.c, k0> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
            Json.c(true);
        }
    }

    /* JADX INFO: compiled from: VungleApiImpl.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }
    }

    public j(@NotNull e.a okHttpClient) {
        t.i(okHttpClient, "okHttpClient");
        this.okHttpClient = okHttpClient;
        this.emptyResponseConverter = new com.vungle.ads.internal.network.converters.b();
    }

    private final b0.a defaultBuilder(String str, String str2, String str3) {
        b0.a aVarA = new b0.a().s(str2).a("User-Agent", str).a("Vungle-Version", VUNGLE_VERSION).a(nb.K, nb.L);
        String str4 = this.appId;
        if (str4 != null) {
            aVarA.a("X-Vungle-App-Id", str4);
        }
        if (str3 != null) {
            aVarA.a("X-Vungle-Placement-Ref-Id", str3);
        }
        return aVarA;
    }

    static /* synthetic */ b0.a defaultBuilder$default(j jVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return jVar.defaultBuilder(str, str2, str3);
    }

    private final b0.a defaultProtoBufBuilder(String str, String str2) {
        b0.a aVarA = new b0.a().s(str2).a("User-Agent", str).a("Vungle-Version", VUNGLE_VERSION).a(nb.K, "application/x-protobuf");
        String str3 = this.appId;
        if (str3 != null) {
            aVarA.a("X-Vungle-App-Id", str3);
        }
        return aVarA;
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    @Nullable
    public com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.b> ads(@NotNull String ua2, @NotNull String path, @NotNull com.vungle.ads.internal.model.f body) {
        List<String> placements;
        t.i(ua2, "ua");
        t.i(path, "path");
        t.i(body, "body");
        try {
            kotlinx.serialization.json.a aVar = json;
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.model.f.class));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            String strC = aVar.c(kSerializerB, body);
            f.i request = body.getRequest();
            return new c(this.okHttpClient.b(defaultBuilder(ua2, path, (request == null || (placements = request.getPlacements()) == null) ? null : (String) d0.k0(placements)).j(c0.Companion.h(strC, null)).b()), new com.vungle.ads.internal.network.converters.c(o0.j(com.vungle.ads.internal.model.b.class)));
        } catch (Exception unused) {
            o.INSTANCE.logError$vungle_ads_release(101, "Error with url: " + path, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            return null;
        }
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    @Nullable
    public com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.g> config(@NotNull String ua2, @NotNull String path, @NotNull com.vungle.ads.internal.model.f body) {
        t.i(ua2, "ua");
        t.i(path, "path");
        t.i(body, "body");
        try {
            kotlinx.serialization.json.a aVar = json;
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.model.f.class));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return new c(this.okHttpClient.b(defaultBuilder$default(this, ua2, path, null, 4, null).j(c0.Companion.h(aVar.c(kSerializerB, body), null)).b()), new com.vungle.ads.internal.network.converters.c(o0.j(com.vungle.ads.internal.model.g.class)));
        } catch (Exception unused) {
            return null;
        }
    }

    @VisibleForTesting
    @NotNull
    public final e.a getOkHttpClient$vungle_ads_release() {
        return this.okHttpClient;
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    @NotNull
    public com.vungle.ads.internal.network.a<Void> pingTPAT(@NotNull String ua2, @NotNull String url) {
        t.i(ua2, "ua");
        t.i(url, "url");
        return new c(this.okHttpClient.b(defaultBuilder$default(this, ua2, ga.v.f26216k.d(url).k().c().toString(), null, 4, null).d().b()), this.emptyResponseConverter);
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    @Nullable
    public com.vungle.ads.internal.network.a<Void> ri(@NotNull String ua2, @NotNull String path, @NotNull com.vungle.ads.internal.model.f body) {
        t.i(ua2, "ua");
        t.i(path, "path");
        t.i(body, "body");
        try {
            kotlinx.serialization.json.a aVar = json;
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.model.f.class));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return new c(this.okHttpClient.b(defaultBuilder$default(this, ua2, path, null, 4, null).j(c0.Companion.h(aVar.c(kSerializerB, body), null)).b()), this.emptyResponseConverter);
        } catch (Exception unused) {
            o.INSTANCE.logError$vungle_ads_release(101, "Error with url: " + path, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            return null;
        }
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    @NotNull
    public com.vungle.ads.internal.network.a<Void> sendAdMarkup(@NotNull String url, @NotNull c0 requestBody) {
        t.i(url, "url");
        t.i(requestBody, "requestBody");
        return new c(this.okHttpClient.b(defaultBuilder$default(this, "debug", ga.v.f26216k.d(url).k().c().toString(), null, 4, null).j(requestBody).b()), this.emptyResponseConverter);
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    @NotNull
    public com.vungle.ads.internal.network.a<Void> sendErrors(@NotNull String ua2, @NotNull String path, @NotNull c0 requestBody) {
        t.i(ua2, "ua");
        t.i(path, "path");
        t.i(requestBody, "requestBody");
        return new c(this.okHttpClient.b(defaultProtoBufBuilder(ua2, ga.v.f26216k.d(path).k().c().toString()).j(requestBody).b()), this.emptyResponseConverter);
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    @NotNull
    public com.vungle.ads.internal.network.a<Void> sendMetrics(@NotNull String ua2, @NotNull String path, @NotNull c0 requestBody) {
        t.i(ua2, "ua");
        t.i(path, "path");
        t.i(requestBody, "requestBody");
        return new c(this.okHttpClient.b(defaultProtoBufBuilder(ua2, ga.v.f26216k.d(path).k().c().toString()).j(requestBody).b()), this.emptyResponseConverter);
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public void setAppId(@NotNull String appId) {
        t.i(appId, "appId");
        this.appId = appId;
    }
}
