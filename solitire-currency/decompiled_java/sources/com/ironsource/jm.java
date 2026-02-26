package com.ironsource;

import android.content.Context;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class jm implements im {
    @Override // com.ironsource.im
    public void a(int i10) {
        SDKUtils.setDebugMode(i10);
    }

    @Override // com.ironsource.im
    public void b(@NotNull String controllerUrl) {
        kotlin.jvm.internal.t.i(controllerUrl, "controllerUrl");
        SDKUtils.setControllerUrl(controllerUrl);
    }

    @Override // com.ironsource.im
    public void a(@NotNull Context applicationContext, @NotNull String applicationKey, @NotNull String userId, @NotNull Map<String, String> initParams) {
        kotlin.jvm.internal.t.i(applicationContext, "applicationContext");
        kotlin.jvm.internal.t.i(applicationKey, "applicationKey");
        kotlin.jvm.internal.t.i(userId, "userId");
        kotlin.jvm.internal.t.i(initParams, "initParams");
        IronSourceNetwork.initSDK(applicationContext, applicationKey, userId, initParams);
    }

    @Override // com.ironsource.im
    public void a(@NotNull fn onNetworkSDKInitListener) {
        kotlin.jvm.internal.t.i(onNetworkSDKInitListener, "onNetworkSDKInitListener");
        IronSourceNetwork.addInitListener(onNetworkSDKInitListener);
    }

    @Override // com.ironsource.im
    public void a(@NotNull String controllerConfig) {
        kotlin.jvm.internal.t.i(controllerConfig, "controllerConfig");
        SDKUtils.setControllerConfig(controllerConfig);
    }
}
