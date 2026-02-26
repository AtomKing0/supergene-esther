package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcbo implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager zza;
    private final zzcbn zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private float zzf = 1.0f;

    public zzcbo(Context context, zzcbn zzcbnVar) {
        this.zza = (AudioManager) context.getSystemService("audio");
        this.zzb = zzcbnVar;
    }

    private final void zzf() {
        if (!this.zzd || this.zze || this.zzf <= 0.0f) {
            if (this.zzc) {
                AudioManager audioManager = this.zza;
                if (audioManager != null) {
                    this.zzc = audioManager.abandonAudioFocus(this) == 0;
                }
                this.zzb.zzn();
                return;
            }
            return;
        }
        if (this.zzc) {
            return;
        }
        AudioManager audioManager2 = this.zza;
        if (audioManager2 != null) {
            this.zzc = audioManager2.requestAudioFocus(this, 3, 2) == 1;
        }
        this.zzb.zzn();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i10) {
        this.zzc = i10 > 0;
        this.zzb.zzn();
    }

    public final float zza() {
        float f10 = this.zze ? 0.0f : this.zzf;
        if (this.zzc) {
            return f10;
        }
        return 0.0f;
    }

    public final void zzb() {
        this.zzd = true;
        zzf();
    }

    public final void zzc() {
        this.zzd = false;
        zzf();
    }

    public final void zzd(boolean z10) {
        this.zze = z10;
        zzf();
    }

    public final void zze(float f10) {
        this.zzf = f10;
        zzf();
    }
}
