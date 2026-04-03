package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;

/* JADX INFO: loaded from: classes2.dex */
final class StreamVolumeManager {
    private static final String TAG = "StreamVolumeManager";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private final Context applicationContext;
    private final AudioManager audioManager;
    private final Handler eventHandler;
    private final Listener listener;
    private boolean muted;

    @Nullable
    private VolumeChangeReceiver receiver;
    private int streamType;
    private int volume;

    public interface Listener {
        void onStreamTypeChanged(int i10);

        void onStreamVolumeChanged(int i10, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = StreamVolumeManager.this.eventHandler;
            final StreamVolumeManager streamVolumeManager = StreamVolumeManager.this;
            handler.post(new Runnable() { // from class: androidx.media3.exoplayer.l2
                @Override // java.lang.Runnable
                public final void run() {
                    StreamVolumeManager.access$200(streamVolumeManager);
                }
            });
        }
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        this.eventHandler = handler;
        this.listener = listener;
        AudioManager audioManager = (AudioManager) Assertions.checkStateNotNull((AudioManager) applicationContext.getSystemService("audio"));
        this.audioManager = audioManager;
        this.streamType = 3;
        this.volume = getVolumeFromManager(audioManager, 3);
        this.muted = getMutedFromManager(audioManager, this.streamType);
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            applicationContext.registerReceiver(volumeChangeReceiver, new IntentFilter(VOLUME_CHANGED_ACTION));
            this.receiver = volumeChangeReceiver;
        } catch (RuntimeException e10) {
            Log.w(TAG, "Error registering stream volume receiver", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$200(StreamVolumeManager streamVolumeManager) {
        streamVolumeManager.updateVolumeAndNotifyIfChanged();
    }

    private static boolean getMutedFromManager(AudioManager audioManager, int i10) {
        return Util.SDK_INT >= 23 ? audioManager.isStreamMute(i10) : getVolumeFromManager(audioManager, i10) == 0;
    }

    private static int getVolumeFromManager(AudioManager audioManager, int i10) {
        try {
            return audioManager.getStreamVolume(i10);
        } catch (RuntimeException e10) {
            Log.w(TAG, "Could not retrieve stream volume for stream type " + i10, e10);
            return audioManager.getStreamMaxVolume(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolumeAndNotifyIfChanged() {
        int volumeFromManager = getVolumeFromManager(this.audioManager, this.streamType);
        boolean mutedFromManager = getMutedFromManager(this.audioManager, this.streamType);
        if (this.volume == volumeFromManager && this.muted == mutedFromManager) {
            return;
        }
        this.volume = volumeFromManager;
        this.muted = mutedFromManager;
        this.listener.onStreamVolumeChanged(volumeFromManager, mutedFromManager);
    }

    public void decreaseVolume(int i10) {
        if (this.volume <= getMinVolume()) {
            return;
        }
        this.audioManager.adjustStreamVolume(this.streamType, -1, i10);
        updateVolumeAndNotifyIfChanged();
    }

    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(this.streamType);
    }

    public int getMinVolume() {
        if (Util.SDK_INT >= 28) {
            return this.audioManager.getStreamMinVolume(this.streamType);
        }
        return 0;
    }

    public int getVolume() {
        return this.volume;
    }

    public void increaseVolume(int i10) {
        if (this.volume >= getMaxVolume()) {
            return;
        }
        this.audioManager.adjustStreamVolume(this.streamType, 1, i10);
        updateVolumeAndNotifyIfChanged();
    }

    public boolean isMuted() {
        return this.muted;
    }

    public void release() {
        VolumeChangeReceiver volumeChangeReceiver = this.receiver;
        if (volumeChangeReceiver != null) {
            try {
                this.applicationContext.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e10) {
                Log.w(TAG, "Error unregistering stream volume receiver", e10);
            }
            this.receiver = null;
        }
    }

    public void setMuted(boolean z10, int i10) {
        if (Util.SDK_INT >= 23) {
            this.audioManager.adjustStreamVolume(this.streamType, z10 ? -100 : 100, i10);
        } else {
            this.audioManager.setStreamMute(this.streamType, z10);
        }
        updateVolumeAndNotifyIfChanged();
    }

    public void setStreamType(int i10) {
        if (this.streamType == i10) {
            return;
        }
        this.streamType = i10;
        updateVolumeAndNotifyIfChanged();
        this.listener.onStreamTypeChanged(i10);
    }

    public void setVolume(int i10, int i11) {
        if (i10 < getMinVolume() || i10 > getMaxVolume()) {
            return;
        }
        this.audioManager.setStreamVolume(this.streamType, i10, i11);
        updateVolumeAndNotifyIfChanged();
    }
}
