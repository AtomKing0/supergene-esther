package com.unity3d.ads.core.data.datasource;

import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import s9.h;

/* JADX INFO: compiled from: DynamicDeviceInfoDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface DynamicDeviceInfoDataSource {
    @NotNull
    DynamicDeviceInfoOuterClass.DynamicDeviceInfo fetch();

    @NotNull
    String getConnectionTypeStr();

    int getCurrentUiTheme();

    @NotNull
    List<String> getLocaleList();

    @NotNull
    String getOrientation();

    int getRingerMode();

    @NotNull
    h<VolumeSettingsChange> getVolumeSettingsChange();

    boolean hasInternet();
}
