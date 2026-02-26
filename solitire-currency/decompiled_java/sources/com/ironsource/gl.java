package com.ironsource;

import com.ironsource.sdk.controller.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class gl {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f12313d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f12315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final JSONObject f12316c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final gl a(@NotNull String jsonStr) throws JSONException {
            kotlin.jvm.internal.t.i(jsonStr, "jsonStr");
            JSONObject jSONObject = new JSONObject(jsonStr);
            String adId = jSONObject.getString(f.b.f15004c);
            String command = jSONObject.getString(f.b.f15008g);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            kotlin.jvm.internal.t.h(adId, "adId");
            kotlin.jvm.internal.t.h(command, "command");
            return new gl(adId, command, jSONObjectOptJSONObject);
        }
    }

    public gl(@NotNull String adId, @NotNull String command, @Nullable JSONObject jSONObject) {
        kotlin.jvm.internal.t.i(adId, "adId");
        kotlin.jvm.internal.t.i(command, "command");
        this.f12314a = adId;
        this.f12315b = command;
        this.f12316c = jSONObject;
    }

    public static /* synthetic */ gl a(gl glVar, String str, String str2, JSONObject jSONObject, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = glVar.f12314a;
        }
        if ((i10 & 2) != 0) {
            str2 = glVar.f12315b;
        }
        if ((i10 & 4) != 0) {
            jSONObject = glVar.f12316c;
        }
        return glVar.a(str, str2, jSONObject);
    }

    @NotNull
    public final String b() {
        return this.f12315b;
    }

    @Nullable
    public final JSONObject c() {
        return this.f12316c;
    }

    @NotNull
    public final String d() {
        return this.f12314a;
    }

    @NotNull
    public final String e() {
        return this.f12315b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gl)) {
            return false;
        }
        gl glVar = (gl) obj;
        return kotlin.jvm.internal.t.d(this.f12314a, glVar.f12314a) && kotlin.jvm.internal.t.d(this.f12315b, glVar.f12315b) && kotlin.jvm.internal.t.d(this.f12316c, glVar.f12316c);
    }

    @Nullable
    public final JSONObject f() {
        return this.f12316c;
    }

    public int hashCode() {
        int iHashCode = ((this.f12314a.hashCode() * 31) + this.f12315b.hashCode()) * 31;
        JSONObject jSONObject = this.f12316c;
        return iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    @NotNull
    public String toString() {
        return "MessageToNative(adId=" + this.f12314a + ", command=" + this.f12315b + ", params=" + this.f12316c + ')';
    }

    @NotNull
    public static final gl a(@NotNull String str) throws JSONException {
        return f12313d.a(str);
    }

    @NotNull
    public final gl a(@NotNull String adId, @NotNull String command, @Nullable JSONObject jSONObject) {
        kotlin.jvm.internal.t.i(adId, "adId");
        kotlin.jvm.internal.t.i(command, "command");
        return new gl(adId, command, jSONObject);
    }

    @NotNull
    public final String a() {
        return this.f12314a;
    }
}
