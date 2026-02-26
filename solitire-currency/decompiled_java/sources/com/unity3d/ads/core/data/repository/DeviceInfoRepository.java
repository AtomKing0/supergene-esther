package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.y;
import z8.d;

/* JADX INFO: compiled from: DeviceInfoRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface DeviceInfoRepository {
    @NotNull
    StaticDeviceInfoOuterClass.StaticDeviceInfo cachedStaticDeviceInfo();

    @NotNull
    y<AllowedPiiOuterClass.AllowedPii> getAllowedPii();

    @Nullable
    String getAnalyticsUserId();

    @NotNull
    String getAppName();

    @Nullable
    Object getAuidByteString(@NotNull d<? super ByteString> dVar);

    @Nullable
    Object getAuidString(@NotNull d<? super String> dVar);

    @NotNull
    String getConnectionTypeStr();

    int getCurrentUiTheme();

    @NotNull
    DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo();

    boolean getHasInternet();

    @Nullable
    Object getIdfi(@NotNull d<? super String> dVar);

    @NotNull
    List<String> getLocaleList();

    @NotNull
    String getManufacturer();

    @NotNull
    String getModel();

    @NotNull
    String getOrientation();

    @NotNull
    String getOsVersion();

    @NotNull
    PiiOuterClass.Pii getPiiData();

    int getRingerMode();

    long getSystemBootTime();

    @NotNull
    h<VolumeSettingsChange> getVolumeSettingsChange();

    @Nullable
    Object staticDeviceInfo(@NotNull d<? super StaticDeviceInfoOuterClass.StaticDeviceInfo> dVar);
}
