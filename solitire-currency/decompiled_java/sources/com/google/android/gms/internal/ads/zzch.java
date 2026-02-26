package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzch {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private final zzfxr zzh;
    private final zzfxr zzi;
    private final int zzj;
    private final int zzk;
    private final zzfxr zzl;
    private final zzcg zzm;
    private zzfxr zzn;
    private int zzo;
    private final HashMap zzp;
    private final HashSet zzq;

    @Deprecated
    public zzch() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzfxr.zzm();
        this.zzi = zzfxr.zzm();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzfxr.zzm();
        this.zzm = zzcg.zza;
        this.zzn = zzfxr.zzm();
        this.zzo = 0;
        this.zzp = new HashMap();
        this.zzq = new HashSet();
    }

    public final zzch zze(Context context) {
        CaptioningManager captioningManager;
        if ((zzet.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzo = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzn = zzfxr.zzn(locale.toLanguageTag());
            }
        }
        return this;
    }

    public final zzch zzf(int i10, int i11, boolean z10) {
        this.zze = i10;
        this.zzf = i11;
        this.zzg = true;
        return this;
    }

    protected zzch(zzci zzciVar) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzciVar.zzi;
        this.zzf = zzciVar.zzj;
        this.zzg = zzciVar.zzk;
        this.zzh = zzciVar.zzl;
        this.zzi = zzciVar.zzn;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzciVar.zzr;
        this.zzm = zzciVar.zzs;
        this.zzn = zzciVar.zzt;
        this.zzo = zzciVar.zzu;
        this.zzq = new HashSet(zzciVar.zzB);
        this.zzp = new HashMap(zzciVar.zzA);
    }
}
