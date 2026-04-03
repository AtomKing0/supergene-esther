package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface o4 {

    public static final class a implements o4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final JSONObject f14202a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ironsource.o4
        @NotNull
        public com.ironsource.mediationsdk.demandOnly.p a(@NotNull String instanceId) {
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            JSONObject jSONObject = this.f14202a;
            JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject(instanceId) : null;
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("plumbus") : null;
            return strOptString != null ? new p.a(strOptString) : new p.b();
        }

        public a(@Nullable JSONObject jSONObject) {
            this.f14202a = jSONObject;
        }

        public /* synthetic */ a(JSONObject jSONObject, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? new JSONObject() : jSONObject);
        }
    }

    @NotNull
    com.ironsource.mediationsdk.demandOnly.p a(@NotNull String str);
}
