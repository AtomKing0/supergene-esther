package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
final class zzoa {
    @DoNotInline
    public static boolean zza(AudioManager audioManager, @Nullable zzon zzonVar) {
        AudioDeviceInfo[] devices;
        if (zzonVar == null) {
            audioManager.getClass();
            devices = audioManager.getDevices(2);
        } else {
            devices = new AudioDeviceInfo[]{zzonVar.zza};
        }
        zzfxw<Integer> zzfxwVarZzb = zzb();
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (zzfxwVarZzb.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                return true;
            }
        }
        return false;
    }

    @DoNotInline
    private static zzfxw<Integer> zzb() {
        zzfxv zzfxvVar = new zzfxv();
        zzfxvVar.zzg(8, 7);
        int i10 = zzet.zza;
        if (i10 >= 31) {
            zzfxvVar.zzg(26, 27);
        }
        if (i10 >= 33) {
            zzfxvVar.zzf((Object) 30);
        }
        return zzfxvVar.zzi();
    }
}
