package com.unity3d.ads.core.data.datasource;

import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: StaticDeviceInfoDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface StaticDeviceInfoDataSource {
    @Nullable
    Object fetch(@NotNull List<String> list, @NotNull d<? super StaticDeviceInfoOuterClass.StaticDeviceInfo> dVar);

    @NotNull
    StaticDeviceInfoOuterClass.StaticDeviceInfo fetchCached();

    @Nullable
    String getAnalyticsUserId();

    @NotNull
    String getAppName();

    @Nullable
    Object getAuid(@NotNull d<? super String> dVar);

    @Nullable
    Object getIdfi(@NotNull d<? super String> dVar);

    @NotNull
    String getManufacturer();

    @NotNull
    String getModel();

    @NotNull
    String getOsVersion();

    long getSystemBootTime();
}
