package com.unity3d.services.core.device;

import android.util.SparseArray;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VolumeChangeMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VolumeChangeMonitor {

    @NotNull
    private final IEventSender eventSender;

    @NotNull
    private final VolumeChange volumeChange;

    @NotNull
    private final SparseArray<VolumeChangeListener> volumeChangeListeners;

    public VolumeChangeMonitor(@NotNull IEventSender eventSender, @NotNull VolumeChange volumeChange) {
        t.i(eventSender, "eventSender");
        t.i(volumeChange, "volumeChange");
        this.eventSender = eventSender;
        this.volumeChange = volumeChange;
        this.volumeChangeListeners = new SparseArray<>();
    }

    public final void registerVolumeChangeListener(final int i10) {
        if (this.volumeChangeListeners.get(i10) == null) {
            VolumeChangeListener volumeChangeListener = new VolumeChangeListener() { // from class: com.unity3d.services.core.device.VolumeChangeMonitor$registerVolumeChangeListener$listener$1
                @Override // com.unity3d.services.core.device.VolumeChangeListener
                public int getStreamType() {
                    return i10;
                }

                @Override // com.unity3d.services.core.device.VolumeChangeListener
                public void onVolumeChanged(int i11) {
                    this.this$0.eventSender.sendEvent(WebViewEventCategory.DEVICEINFO, DeviceInfoEvent.VOLUME_CHANGED, Integer.valueOf(getStreamType()), Integer.valueOf(i11), Integer.valueOf(Device.getStreamMaxVolume(i10)));
                }
            };
            this.volumeChangeListeners.append(i10, volumeChangeListener);
            this.volumeChange.registerListener(volumeChangeListener);
        }
    }

    public final void unregisterVolumeChangeListener(int i10) {
        if (this.volumeChangeListeners.get(i10) != null) {
            VolumeChangeListener listener = this.volumeChangeListeners.get(i10);
            VolumeChange volumeChange = this.volumeChange;
            t.h(listener, "listener");
            volumeChange.unregisterListener(listener);
            this.volumeChangeListeners.remove(i10);
        }
    }
}
