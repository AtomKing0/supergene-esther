package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioProfile;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(33)
final class zzoc {
    @DoNotInline
    public static zzof zza(AudioManager audioManager, zzh zzhVar) {
        List<AudioProfile> directProfilesForAttributes = audioManager.getDirectProfilesForAttributes(zzhVar.zza().zza);
        HashMap map = new HashMap();
        map.put(2, new HashSet(zzgap.zzg(12)));
        for (int i10 = 0; i10 < directProfilesForAttributes.size(); i10++) {
            AudioProfile audioProfile = directProfilesForAttributes.get(i10);
            if (audioProfile.getEncapsulationType() != 1) {
                int format = audioProfile.getFormat();
                if (zzet.zzK(format) || zzof.zzb.containsKey(Integer.valueOf(format))) {
                    Integer numValueOf = Integer.valueOf(format);
                    if (map.containsKey(numValueOf)) {
                        Set set = (Set) map.get(numValueOf);
                        set.getClass();
                        set.addAll(zzgap.zzg(audioProfile.getChannelMasks()));
                    } else {
                        map.put(numValueOf, new HashSet(zzgap.zzg(audioProfile.getChannelMasks())));
                    }
                }
            }
        }
        zzfxo zzfxoVar = new zzfxo();
        for (Map.Entry entry : map.entrySet()) {
            zzfxoVar.zzf(new zzod(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return new zzof(zzfxoVar.zzi());
    }

    @Nullable
    @DoNotInline
    public static zzon zzb(AudioManager audioManager, zzh zzhVar) {
        audioManager.getClass();
        try {
            List<AudioDeviceInfo> audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes(zzhVar.zza().zza);
            if (audioDevicesForAttributes.isEmpty()) {
                return null;
            }
            return new zzon(audioDevicesForAttributes.get(0));
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
