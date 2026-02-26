package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private kc f12170a;

    private final class a extends er {
        public a() {
        }

        @Override // com.ironsource.er, java.lang.Runnable
        public void run() {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
            try {
                mediationAdditionalData.put("duration", a());
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
            zn.P.a(new kb(44, mediationAdditionalData));
        }
    }

    public final void a(@NotNull sd applicationLifecycleService) {
        kotlin.jvm.internal.t.i(applicationLifecycleService, "applicationLifecycleService");
        this.f12170a = new kc(applicationLifecycleService, new a());
    }
}
