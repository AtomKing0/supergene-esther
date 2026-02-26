package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j8 implements ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final JSONObject f12713a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f12714a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f12715b = false;

        private a() {
        }
    }

    public j8(@Nullable JSONObject jSONObject) {
        this.f12713a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.ec
    public boolean c() {
        return this.f12713a.optBoolean("clickCheck", false);
    }
}
