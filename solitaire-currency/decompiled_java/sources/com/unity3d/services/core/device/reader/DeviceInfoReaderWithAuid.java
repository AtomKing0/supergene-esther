package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.Device;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeviceInfoReaderWithAuid.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeviceInfoReaderWithAuid implements IDeviceInfoReader {

    @NotNull
    private final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderWithAuid(@NotNull IDeviceInfoReader _deviceInfoReader) {
        t.i(_deviceInfoReader, "_deviceInfoReader");
        this._deviceInfoReader = _deviceInfoReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    @NotNull
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        t.h(deviceInfoData, "_deviceInfoReader.deviceInfoData");
        String auid = Device.getAuid();
        if (auid != null) {
            deviceInfoData.put("auid", auid);
        }
        return deviceInfoData;
    }
}
