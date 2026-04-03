package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface r0 {

    public static final class a implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final JSONObject f14612a;

        public a(@NotNull JSONObject applicationConfig) {
            kotlin.jvm.internal.t.i(applicationConfig, "applicationConfig");
            this.f14612a = applicationConfig;
        }

        @Override // com.ironsource.r0
        @NotNull
        public JSONObject a() {
            JSONObject jSONObjectOptJSONObject = this.f14612a.optJSONObject("controllerConfig");
            return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        }

        @Override // com.ironsource.r0
        public int b() {
            int iOptInt = this.f14612a.optInt("debugMode", 0);
            if (this.f14612a.optBoolean(b.f14617e, false)) {
                return 3;
            }
            return iOptInt;
        }

        @Override // com.ironsource.r0
        @NotNull
        public String c() {
            String strOptString = this.f14612a.optString("controllerUrl");
            return strOptString == null ? "" : strOptString;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f14613a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f14614b = "controllerUrl";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f14615c = "controllerConfig";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final String f14616d = "debugMode";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final String f14617e = "adptDebugMode";

        private b() {
        }
    }

    @NotNull
    JSONObject a();

    int b();

    @NotNull
    String c();
}
