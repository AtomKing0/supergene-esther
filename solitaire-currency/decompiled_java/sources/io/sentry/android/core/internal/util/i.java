package io.sentry.android.core.internal.util;

import io.sentry.protocol.Device;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DeviceOrientations.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class i {
    @Nullable
    public static Device.DeviceOrientation a(int i10) {
        if (i10 == 1) {
            return Device.DeviceOrientation.PORTRAIT;
        }
        if (i10 != 2) {
            return null;
        }
        return Device.DeviceOrientation.LANDSCAPE;
    }
}
