package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzbt;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zzci;
import com.google.android.gms.ads.internal.util.zzv;
import com.google.android.gms.ads.internal.util.zzw;
import com.google.android.gms.ads.internal.util.zzy;
import com.google.android.gms.ads.internal.util.zzz;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzayq;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbas;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.internal.ads.zzboh;
import com.google.android.gms.internal.ads.zzbvi;
import com.google.android.gms.internal.ads.zzbya;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzcab;
import com.google.android.gms.internal.ads.zzcco;
import com.google.android.gms.internal.ads.zzcew;
import com.google.android.gms.internal.ads.zzeei;
import com.google.android.gms.internal.ads.zzeej;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzu {
    private static final zzu zza = new zzu();
    private final zzci zzA;
    private final zzcco zzB;
    private final zzcab zzC;
    private final com.google.android.gms.ads.internal.overlay.zza zzb;
    private final com.google.android.gms.ads.internal.overlay.zzn zzc;
    private final com.google.android.gms.ads.internal.util.zzt zzd;
    private final zzcew zze;
    private final zzab zzf;
    private final zzayq zzg;
    private final zzbze zzh;
    private final zzac zzi;
    private final zzbad zzj;
    private final Clock zzk;
    private final zzf zzl;
    private final zzbcc zzm;
    private final zzay zzn;
    private final zzbvi zzo;
    private final zzbzu zzp;
    private final zzbnf zzq;
    private final zzx zzr;
    private final zzbt zzs;
    private final com.google.android.gms.ads.internal.overlay.zzab zzt;
    private final com.google.android.gms.ads.internal.overlay.zzac zzu;
    private final zzboh zzv;
    private final zzbu zzw;
    private final zzeej zzx;
    private final zzbas zzy;
    private final zzbya zzz;

    protected zzu() {
        com.google.android.gms.ads.internal.overlay.zza zzaVar = new com.google.android.gms.ads.internal.overlay.zza();
        com.google.android.gms.ads.internal.overlay.zzn zznVar = new com.google.android.gms.ads.internal.overlay.zzn();
        com.google.android.gms.ads.internal.util.zzt zztVar = new com.google.android.gms.ads.internal.util.zzt();
        zzcew zzcewVar = new zzcew();
        int i10 = Build.VERSION.SDK_INT;
        zzab zzzVar = i10 >= 30 ? new zzz() : i10 >= 28 ? new zzy() : i10 >= 26 ? new zzw() : i10 >= 24 ? new zzv() : new com.google.android.gms.ads.internal.util.zzu();
        zzayq zzayqVar = new zzayq();
        zzbze zzbzeVar = new zzbze();
        zzac zzacVar = new zzac();
        zzbad zzbadVar = new zzbad();
        Clock defaultClock = DefaultClock.getInstance();
        zzf zzfVar = new zzf();
        zzbcc zzbccVar = new zzbcc();
        zzay zzayVar = new zzay();
        zzbvi zzbviVar = new zzbvi();
        zzbzu zzbzuVar = new zzbzu();
        zzbnf zzbnfVar = new zzbnf();
        zzx zzxVar = new zzx();
        zzbt zzbtVar = new zzbt();
        com.google.android.gms.ads.internal.overlay.zzab zzabVar = new com.google.android.gms.ads.internal.overlay.zzab();
        com.google.android.gms.ads.internal.overlay.zzac zzacVar2 = new com.google.android.gms.ads.internal.overlay.zzac();
        zzboh zzbohVar = new zzboh();
        zzbu zzbuVar = new zzbu();
        zzeei zzeeiVar = new zzeei();
        zzbas zzbasVar = new zzbas();
        zzbya zzbyaVar = new zzbya();
        zzci zzciVar = new zzci();
        zzcco zzccoVar = new zzcco();
        zzcab zzcabVar = new zzcab();
        this.zzb = zzaVar;
        this.zzc = zznVar;
        this.zzd = zztVar;
        this.zze = zzcewVar;
        this.zzf = zzzVar;
        this.zzg = zzayqVar;
        this.zzh = zzbzeVar;
        this.zzi = zzacVar;
        this.zzj = zzbadVar;
        this.zzk = defaultClock;
        this.zzl = zzfVar;
        this.zzm = zzbccVar;
        this.zzn = zzayVar;
        this.zzo = zzbviVar;
        this.zzp = zzbzuVar;
        this.zzq = zzbnfVar;
        this.zzs = zzbtVar;
        this.zzr = zzxVar;
        this.zzt = zzabVar;
        this.zzu = zzacVar2;
        this.zzv = zzbohVar;
        this.zzw = zzbuVar;
        this.zzx = zzeeiVar;
        this.zzy = zzbasVar;
        this.zzz = zzbyaVar;
        this.zzA = zzciVar;
        this.zzB = zzccoVar;
        this.zzC = zzcabVar;
    }

    public static zzeej zzA() {
        return zza.zzx;
    }

    public static Clock zzB() {
        return zza.zzk;
    }

    public static zzf zza() {
        return zza.zzl;
    }

    public static zzayq zzb() {
        return zza.zzg;
    }

    public static zzbad zzc() {
        return zza.zzj;
    }

    public static zzbas zzd() {
        return zza.zzy;
    }

    public static zzbcc zze() {
        return zza.zzm;
    }

    public static zzbnf zzf() {
        return zza.zzq;
    }

    public static zzboh zzg() {
        return zza.zzv;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzh() {
        return zza.zzb;
    }

    public static com.google.android.gms.ads.internal.overlay.zzn zzi() {
        return zza.zzc;
    }

    public static zzx zzj() {
        return zza.zzr;
    }

    public static com.google.android.gms.ads.internal.overlay.zzab zzk() {
        return zza.zzt;
    }

    public static com.google.android.gms.ads.internal.overlay.zzac zzl() {
        return zza.zzu;
    }

    public static zzbvi zzm() {
        return zza.zzo;
    }

    public static zzbya zzn() {
        return zza.zzz;
    }

    public static zzbze zzo() {
        return zza.zzh;
    }

    public static com.google.android.gms.ads.internal.util.zzt zzp() {
        return zza.zzd;
    }

    public static zzab zzq() {
        return zza.zzf;
    }

    public static zzac zzr() {
        return zza.zzi;
    }

    public static zzay zzs() {
        return zza.zzn;
    }

    public static zzbt zzt() {
        return zza.zzs;
    }

    public static zzbu zzu() {
        return zza.zzw;
    }

    public static zzci zzv() {
        return zza.zzA;
    }

    public static zzbzu zzw() {
        return zza.zzp;
    }

    public static zzcab zzx() {
        return zza.zzC;
    }

    public static zzcco zzy() {
        return zza.zzB;
    }

    public static zzcew zzz() {
        return zza.zze;
    }
}
