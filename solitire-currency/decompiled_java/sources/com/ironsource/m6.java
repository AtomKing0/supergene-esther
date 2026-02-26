package com.ironsource;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b f13153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, b> f13154b;

    static final class a extends kotlin.jvm.internal.v implements h9.l<JSONObject, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13155a = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke(@NotNull JSONObject it) {
            kotlin.jvm.internal.t.i(it, "it");
            return new b(it);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Integer f13156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final Boolean f13157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final Boolean f13158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f13159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final List<String> f13160e;

        public b(@NotNull JSONObject features) {
            kotlin.jvm.internal.t.i(features, "features");
            this.f13156a = features.has(o6.f14207a) ? Integer.valueOf(features.optInt(o6.f14207a)) : null;
            this.f13157b = features.has(o6.f14208b) ? Boolean.valueOf(features.optBoolean(o6.f14208b)) : null;
            this.f13158c = features.has("isLoadWhileShow") ? Boolean.valueOf(features.optBoolean("isLoadWhileShow")) : null;
            this.f13159d = features.has(o6.f14210d) ? features.optInt(o6.f14210d) / 100.0f : 0.15f;
            List<String> listB = features.has(o6.f14211e) ? hj.b(features.getJSONArray(o6.f14211e)) : kotlin.collections.v.n(com.ironsource.mediationsdk.l.f13634a, com.ironsource.mediationsdk.l.f13637d);
            kotlin.jvm.internal.t.h(listB, "BANNER_CONFIGURATIONS_AD…ZE_LEADERBOARD)\n        }");
            this.f13160e = listB;
        }

        @NotNull
        public final List<String> a() {
            return this.f13160e;
        }

        @Nullable
        public final Integer b() {
            return this.f13156a;
        }

        public final float c() {
            return this.f13159d;
        }

        @Nullable
        public final Boolean d() {
            return this.f13157b;
        }

        @Nullable
        public final Boolean e() {
            return this.f13158c;
        }
    }

    public m6(@NotNull JSONObject bannerConfigurations) {
        kotlin.jvm.internal.t.i(bannerConfigurations, "bannerConfigurations");
        this.f13153a = new b(bannerConfigurations);
        this.f13154b = new r2(bannerConfigurations).a(a.f13155a);
    }

    @NotNull
    public final Map<String, b> a() {
        return this.f13154b;
    }

    @NotNull
    public final b b() {
        return this.f13153a;
    }
}
