package com.unity3d.ads.core.data.datasource;

import com.unity3d.services.core.preferences.AndroidPreferences;
import com.unity3d.services.core.properties.ClientProperties;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidAnalyticsDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidAnalyticsDataSource implements AnalyticsDataSource {
    @Override // com.unity3d.ads.core.data.datasource.AnalyticsDataSource
    @Nullable
    public String getUserId() {
        return AndroidPreferences.getString(ClientProperties.getAppName() + ".v2.playerprefs", "unity.cloud_userid");
    }
}
