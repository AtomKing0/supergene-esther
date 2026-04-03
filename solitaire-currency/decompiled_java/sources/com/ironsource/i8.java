package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i8 implements ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final JSONObject f12563a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f12564a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f12565b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f12566c = "curlError";

        private a() {
        }
    }

    public i8(@Nullable JSONObject jSONObject) {
        this.f12563a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.ec
    public boolean c() {
        return this.f12563a.optBoolean("enabled", false);
    }

    public final boolean d() {
        return this.f12563a.optBoolean("closeActivity", true);
    }

    public final boolean e() {
        return this.f12563a.optBoolean("reportController", true);
    }
}
