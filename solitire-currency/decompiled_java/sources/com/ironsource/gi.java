package com.ironsource;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gi {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final c f12293e = new c(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final String f12294f = "capping";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final String f12295g = "pacing";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final String f12296h = "delivery";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final String f12297i = "expiredDurationInMinutes";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f12298j = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final JSONObject f12299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, d> f12300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final d f12301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<String, d> f12302d;

    static final class a extends kotlin.jvm.internal.v implements h9.l<JSONObject, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12303a = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(@NotNull JSONObject it) {
            kotlin.jvm.internal.t.i(it, "it");
            return new d(it);
        }
    }

    static final class b extends kotlin.jvm.internal.v implements h9.l<JSONObject, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12304a = new b();

        b() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(@NotNull JSONObject it) {
            kotlin.jvm.internal.t.i(it, "it");
            return new d(it);
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final b8 f12305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final tn f12306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final aa f12307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f12308d;

        public d(@NotNull JSONObject features) throws JSONException {
            b8 b8Var;
            tn tnVar;
            kotlin.jvm.internal.t.i(features, "features");
            if (features.has(gi.f12294f)) {
                JSONObject jSONObject = features.getJSONObject(gi.f12294f);
                kotlin.jvm.internal.t.h(jSONObject, "features.getJSONObject(key)");
                b8Var = new b8(jSONObject);
            } else {
                b8Var = null;
            }
            this.f12305a = b8Var;
            if (features.has(gi.f12295g)) {
                JSONObject jSONObject2 = features.getJSONObject(gi.f12295g);
                kotlin.jvm.internal.t.h(jSONObject2, "features.getJSONObject(key)");
                tnVar = new tn(jSONObject2);
            } else {
                tnVar = null;
            }
            this.f12306b = tnVar;
            this.f12307c = features.has(gi.f12296h) ? new aa(features.getBoolean(gi.f12296h)) : null;
            this.f12308d = features.has(gi.f12297i) ? features.getLong(gi.f12297i) : 60L;
        }

        @Nullable
        public final b8 a() {
            return this.f12305a;
        }

        @Nullable
        public final aa b() {
            return this.f12307c;
        }

        public final long c() {
            return this.f12308d;
        }

        @Nullable
        public final tn d() {
            return this.f12306b;
        }
    }

    public gi(@NotNull JSONObject configurations) {
        kotlin.jvm.internal.t.i(configurations, "configurations");
        this.f12299a = configurations;
        this.f12300b = new jo(configurations).a(b.f12304a);
        this.f12301c = new d(configurations);
        this.f12302d = new r2(configurations).a(a.f12303a);
    }

    @NotNull
    public final Map<String, d> a() {
        return this.f12302d;
    }

    @NotNull
    public final JSONObject b() {
        return this.f12299a;
    }

    @NotNull
    public final d c() {
        return this.f12301c;
    }

    @NotNull
    public final Map<String, d> d() {
        return this.f12300b;
    }
}
