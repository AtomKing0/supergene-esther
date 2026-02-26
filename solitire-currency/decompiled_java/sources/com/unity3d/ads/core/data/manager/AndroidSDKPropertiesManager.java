package com.unity3d.ads.core.data.manager;

import com.unity3d.services.core.properties.SdkProperties;

/* JADX INFO: compiled from: AndroidSDKPropertiesManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidSDKPropertiesManager implements SDKPropertiesManager {
    @Override // com.unity3d.ads.core.data.manager.SDKPropertiesManager
    public void setInitialized(boolean z10) {
        SdkProperties.setInitialized(z10);
    }
}
