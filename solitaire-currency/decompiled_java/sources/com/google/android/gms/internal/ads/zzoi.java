package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
final class zzoi extends AudioDeviceCallback {
    final /* synthetic */ zzom zza;

    /* synthetic */ zzoi(zzom zzomVar, zzoh zzohVar) {
        this.zza = zzomVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzom zzomVar = this.zza;
        this.zza.zzj(zzof.zzc(zzomVar.zza, zzomVar.zzh, zzomVar.zzg));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzon zzonVar = this.zza.zzg;
        int i10 = zzet.zza;
        int length = audioDeviceInfoArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            if (zzet.zzG(audioDeviceInfoArr[i11], zzonVar)) {
                this.zza.zzg = null;
                break;
            }
            i11++;
        }
        zzom zzomVar = this.zza;
        zzomVar.zzj(zzof.zzc(zzomVar.zza, zzomVar.zzh, zzomVar.zzg));
    }
}
