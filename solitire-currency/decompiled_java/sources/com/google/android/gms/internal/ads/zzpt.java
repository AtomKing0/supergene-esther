package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpt {

    @Nullable
    private final Context zza;
    private Boolean zzb;

    public zzpt() {
        this.zza = null;
    }

    public final zzoq zza(zzaf zzafVar, zzh zzhVar) {
        boolean zBooleanValue;
        AudioManager audioManager;
        zzafVar.getClass();
        zzhVar.getClass();
        int i10 = zzet.zza;
        if (i10 < 29 || zzafVar.zzA == -1) {
            return zzoq.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
                this.zzb = Boolean.FALSE;
            } else {
                String parameters = audioManager.getParameters("offloadVariableRateSupported");
                boolean z10 = false;
                if (parameters != null && parameters.equals("offloadVariableRateSupported=1")) {
                    z10 = true;
                }
                this.zzb = Boolean.valueOf(z10);
            }
            zBooleanValue = this.zzb.booleanValue();
        }
        String str = zzafVar.zzm;
        str.getClass();
        int iZza = zzbn.zza(str, zzafVar.zzj);
        if (iZza == 0 || i10 < zzet.zzg(iZza)) {
            return zzoq.zza;
        }
        int iZzh = zzet.zzh(zzafVar.zzz);
        if (iZzh == 0) {
            return zzoq.zza;
        }
        try {
            AudioFormat audioFormatZzw = zzet.zzw(zzafVar.zzA, iZzh, iZza);
            return i10 >= 31 ? zzps.zza(audioFormatZzw, zzhVar.zza().zza, zBooleanValue) : zzpr.zza(audioFormatZzw, zzhVar.zza().zza, zBooleanValue);
        } catch (IllegalArgumentException unused) {
            return zzoq.zza;
        }
    }

    public zzpt(@Nullable Context context) {
        this.zza = context;
    }
}
