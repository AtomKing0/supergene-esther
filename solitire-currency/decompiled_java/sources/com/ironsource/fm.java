package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.IronSourceNetwork;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class fm implements em {
    @Override // com.ironsource.em
    public void a(@NotNull mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        try {
            IronSourceNetwork.destroyAd(adInstance);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.ADAPTER_API.verbose("destroy ad with identifier: " + adInstance.e() + " failed. error: " + e10.getMessage());
        }
    }
}
