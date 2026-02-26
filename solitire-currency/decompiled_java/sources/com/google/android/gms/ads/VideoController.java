package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzfj;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoController {

    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;

    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;

    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();

    @Nullable
    private zzdq zzb;

    @Nullable
    private VideoLifecycleCallbacks zzc;

    @KeepForSdk
    public int getPlaybackState() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return 0;
            }
            try {
                return zzdqVar.zzh();
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call getPlaybackState on video controller.", e10);
                return 0;
            }
        }
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z10;
        synchronized (this.zza) {
            z10 = this.zzb != null;
        }
        return z10;
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return false;
            }
            try {
                return zzdqVar.zzo();
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call isClickToExpandEnabled.", e10);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return false;
            }
            try {
                return zzdqVar.zzp();
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call isUsingCustomPlayerControls.", e10);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return true;
            }
            try {
                return zzdqVar.zzq();
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call isMuted on video controller.", e10);
                return true;
            }
        }
    }

    public void mute(boolean z10) {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzj(z10);
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call mute on video controller.", e10);
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzk();
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call pause on video controller.", e10);
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzl();
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call play on video controller.", e10);
            }
        }
    }

    public void setVideoLifecycleCallbacks(@Nullable VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfj zzfjVar;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            if (videoLifecycleCallbacks == null) {
                zzfjVar = null;
            } else {
                try {
                    zzfjVar = new zzfj(videoLifecycleCallbacks);
                } catch (RemoteException e10) {
                    zzm.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e10);
                }
            }
            zzdqVar.zzm(zzfjVar);
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzdq zzdqVar = this.zzb;
            if (zzdqVar == null) {
                return;
            }
            try {
                zzdqVar.zzn();
            } catch (RemoteException e10) {
                zzm.zzh("Unable to call stop on video controller.", e10);
            }
        }
    }

    @Nullable
    public final zzdq zza() {
        zzdq zzdqVar;
        synchronized (this.zza) {
            zzdqVar = this.zzb;
        }
        return zzdqVar;
    }

    public final void zzb(@Nullable zzdq zzdqVar) {
        synchronized (this.zza) {
            this.zzb = zzdqVar;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }

        public void onVideoMute(boolean z10) {
        }
    }
}
