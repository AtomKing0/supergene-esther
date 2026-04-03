package com.ironsource;

import com.ironsource.sdk.IronSourceNetwork;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class om implements nm {
    @Override // com.ironsource.nm
    @NotNull
    public String a() {
        String version = IronSourceNetwork.getVersion();
        kotlin.jvm.internal.t.h(version, "getVersion()");
        return version;
    }

    @Override // com.ironsource.nm
    public void a(@NotNull mi adInstance, @NotNull pm loadParams) throws Exception {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(loadParams, "loadParams");
        IronSourceNetwork.loadAd(adInstance, loadParams.a());
    }
}
