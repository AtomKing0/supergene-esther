package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class kd implements gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final JSONObject f12871a;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f12873b = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f12875d = 24;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f12872a = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f12874c = ld.SendEvent.b();

        private a() {
        }

        public final int a() {
            return f12874c;
        }
    }

    public kd(@Nullable JSONObject jSONObject) {
        this.f12871a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.gd
    public long a() {
        return ((long) this.f12871a.optInt("timeout", 24)) * 1000;
    }

    @Override // com.ironsource.gd
    @NotNull
    public ld b() {
        return ld.f13016b.a(this.f12871a.optInt("strategy", a.f12872a.a()));
    }

    @Override // com.ironsource.ec
    public boolean c() {
        return this.f12871a.optBoolean(com.ironsource.mediationsdk.metadata.a.f13691j, false);
    }
}
