package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhl {
    private final AudioManager zza;
    private final zzhj zzb;

    @Nullable
    private zzhk zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzhl(Context context, Handler handler, zzhk zzhkVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzhkVar;
        this.zzb = new zzhj(this, handler);
        this.zzd = 0;
    }

    static /* bridge */ /* synthetic */ void zzc(zzhl zzhlVar, int i10) {
        if (i10 == -3 || i10 == -2) {
            if (i10 != -2) {
                zzhlVar.zzg(3);
                return;
            } else {
                zzhlVar.zzf(0);
                zzhlVar.zzg(2);
                return;
            }
        }
        if (i10 == -1) {
            zzhlVar.zzf(-1);
            zzhlVar.zze();
        } else if (i10 == 1) {
            zzhlVar.zzg(1);
            zzhlVar.zzf(1);
        } else {
            zzea.zzf("AudioFocusManager", "Unknown focus change type: " + i10);
        }
    }

    private final void zze() {
        if (this.zzd == 0) {
            return;
        }
        if (zzet.zza < 26) {
            this.zza.abandonAudioFocus(this.zzb);
        }
        zzg(0);
    }

    private final void zzf(int i10) {
        zzhk zzhkVar = this.zzc;
        if (zzhkVar != null) {
            zzji zzjiVar = (zzji) zzhkVar;
            boolean zZzu = zzjiVar.zza.zzu();
            zzjiVar.zza.zzaf(zZzu, i10, zzjm.zzS(zZzu, i10));
        }
    }

    private final void zzg(int i10) {
        if (this.zzd == i10) {
            return;
        }
        this.zzd = i10;
        float f10 = i10 == 3 ? 0.2f : 1.0f;
        if (this.zze != f10) {
            this.zze = f10;
            zzhk zzhkVar = this.zzc;
            if (zzhkVar != null) {
                ((zzji) zzhkVar).zza.zzac();
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z10, int i10) {
        zze();
        return z10 ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
