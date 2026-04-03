package com.ironsource;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.v8;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class zb implements en {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16396a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private String f16397b = ac.f11217j;

    public static final class a implements pd {
        a() {
        }

        @Override // com.ironsource.pd
        public void a(boolean z10) {
            if (z10) {
                return;
            }
            IronLog.API.error("failed to send impression data");
        }
    }

    private final JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceOS", "android");
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            jSONObject.put("deviceType", IronSourceUtils.getDeviceType(applicationContext));
            ri ironSourceAdvId = IronSourceUtils.getIronSourceAdvId(applicationContext);
            if (ironSourceAdvId != null) {
                jSONObject.put("advId", ironSourceAdvId.c());
                jSONObject.put("advIdType", ironSourceAdvId.d());
            }
        }
        String strN = com.ironsource.mediationsdk.p.m().n();
        if (strN != null) {
            jSONObject.put(v8.i.f15843g, strN);
        }
        return jSONObject;
    }

    @Override // com.ironsource.en
    public void a() {
    }

    public final void a(@NotNull String dataSource, @NotNull JSONObject impressionData) {
        kotlin.jvm.internal.t.i(dataSource, "dataSource");
        kotlin.jvm.internal.t.i(impressionData, "impressionData");
        if (!this.f16396a) {
            IronLog.INTERNAL.verbose("disabled from server");
            return;
        }
        try {
            JSONObject jSONObjectB = b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("externalMediationSource", dataSource);
            jSONObject.putOpt("externalMediationData", impressionData);
            jSONObject.putOpt("clientParams", jSONObjectB);
            IronLog.API.info("impressionData: " + jSONObject);
            HttpFunctions.sendPostRequest(this.f16397b, jSONObject.toString(), new a());
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.API.error("exception " + e10.getMessage() + " sending impression data");
        }
    }

    @Override // com.ironsource.en
    public void a(@Nullable List<IronSource.AD_UNIT> list, boolean z10, @Nullable m8 m8Var) {
        if (m8Var != null) {
            t3 t3VarB = m8Var.b();
            d4 d4VarE = t3VarB != null ? t3VarB.e() : null;
            kotlin.jvm.internal.t.f(d4VarE);
            this.f16396a = d4VarE.l();
            this.f16397b = m8Var.b().e().d();
        }
    }

    @Override // com.ironsource.en
    public void d(@Nullable String str) {
    }
}
