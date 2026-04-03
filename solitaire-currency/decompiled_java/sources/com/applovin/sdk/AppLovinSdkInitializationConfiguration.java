package com.applovin.sdk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinSdkInitializationConfigurationImpl;
import com.applovin.mediation.MaxSegmentCollection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppLovinSdkInitializationConfiguration {

    public interface Builder {
        AppLovinSdkInitializationConfiguration build();

        List<String> getAdUnitIds();

        @Nullable
        String getMediationProvider();

        @Nullable
        String getPluginVersion();

        String getSdkKey();

        @Nullable
        MaxSegmentCollection getSegmentCollection();

        List<String> getTestDeviceAdvertisingIds();

        boolean isExceptionHandlerEnabled();

        Builder setAdUnitIds(List<String> list);

        Builder setExceptionHandlerEnabled(boolean z10);

        Builder setMediationProvider(@Nullable String str);

        Builder setPluginVersion(@Nullable String str);

        Builder setSegmentCollection(MaxSegmentCollection maxSegmentCollection);

        Builder setTestDeviceAdvertisingIds(List<String> list);
    }

    public static Builder builder(String str) {
        return builder(str, null);
    }

    public abstract List<String> getAdUnitIds();

    @Nullable
    public abstract String getMediationProvider();

    @Nullable
    public abstract String getPluginVersion();

    @Nullable
    public abstract String getSdkKey();

    @Nullable
    public abstract MaxSegmentCollection getSegmentCollection();

    public abstract List<String> getTestDeviceAdvertisingIds();

    public abstract boolean isExceptionHandlerEnabled();

    @Deprecated
    public static Builder builder(String str, Context context) {
        return new AppLovinSdkInitializationConfigurationImpl.BuilderImpl(str);
    }
}
