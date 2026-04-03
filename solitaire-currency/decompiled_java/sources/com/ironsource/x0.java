package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class x0 implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final tm f16098a;

    public x0(@NotNull tm networkShowApi) {
        kotlin.jvm.internal.t.i(networkShowApi, "networkShowApi");
        this.f16098a = networkShowApi;
    }

    @Override // com.ironsource.w0
    public void a(@NotNull Activity activity, @NotNull mi adInstance) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        IronLog.ADAPTER_API.verbose("Show: networkInstanceId=" + adInstance.g() + " adInstanceId=" + adInstance.e());
        this.f16098a.a(activity, adInstance, new HashMap());
    }

    @Override // com.ironsource.w0
    public boolean a(@NotNull mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        return this.f16098a.a(adInstance);
    }
}
