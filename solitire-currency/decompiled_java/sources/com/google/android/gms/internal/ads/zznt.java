package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznt implements zznx {
    public static final zzfvk zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zznr
        @Override // com.google.android.gms.internal.ads.zzfvk
        public final Object zza() {
            return zznt.zzn();
        }
    };
    private static final Random zzb = new Random();
    private final zzcb zzc;
    private final zzca zzd;
    private final HashMap zze;
    private zznw zzf;
    private zzcc zzg;

    @Nullable
    private String zzh;
    private long zzi;

    public zznt() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzl() {
        zzns zznsVar = (zzns) this.zze.get(this.zzh);
        return (zznsVar == null || zznsVar.zzd == -1) ? this.zzi + 1 : zznsVar.zzd;
    }

    private final zzns zzm(int i10, @Nullable zzui zzuiVar) {
        long j10 = Long.MAX_VALUE;
        zzns zznsVar = null;
        for (zzns zznsVar2 : this.zze.values()) {
            zznsVar2.zzg(i10, zzuiVar);
            if (zznsVar2.zzj(i10, zzuiVar)) {
                long j11 = zznsVar2.zzd;
                if (j11 == -1 || j11 < j10) {
                    zznsVar = zznsVar2;
                    j10 = j11;
                } else if (j11 == j10) {
                    int i11 = zzet.zza;
                    if (zznsVar.zze != null && zznsVar2.zze != null) {
                        zznsVar = zznsVar2;
                    }
                }
            }
        }
        if (zznsVar != null) {
            return zznsVar;
        }
        String strZzn = zzn();
        zzns zznsVar3 = new zzns(this, strZzn, i10, zzuiVar);
        this.zze.put(strZzn, zznsVar3);
        return zznsVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzns zznsVar) {
        if (zznsVar.zzd != -1) {
            this.zzi = zznsVar.zzd;
        }
        this.zzh = null;
    }

    private final void zzp(zzlo zzloVar) {
        if (zzloVar.zzb.zzo()) {
            String str = this.zzh;
            if (str != null) {
                zzns zznsVar = (zzns) this.zze.get(str);
                zznsVar.getClass();
                zzo(zznsVar);
                return;
            }
            return;
        }
        zzns zznsVar2 = (zzns) this.zze.get(this.zzh);
        zzns zznsVarZzm = zzm(zzloVar.zzc, zzloVar.zzd);
        this.zzh = zznsVarZzm.zzb;
        zzi(zzloVar);
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null || !zzuiVar.zzb()) {
            return;
        }
        if (zznsVar2 != null) {
            if (zznsVar2.zzd == zzuiVar.zzd && zznsVar2.zze != null && zznsVar2.zze.zzb == zzloVar.zzd.zzb && zznsVar2.zze.zzc == zzloVar.zzd.zzc) {
                return;
            }
        }
        zzui zzuiVar2 = zzloVar.zzd;
        String unused = zzm(zzloVar.zzc, new zzui(zzuiVar2.zza, zzuiVar2.zzd)).zzb;
        String unused2 = zznsVarZzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    @Nullable
    public final synchronized String zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized String zzf(zzcc zzccVar, zzui zzuiVar) {
        return zzm(zzccVar.zzn(zzuiVar.zza, this.zzd).zzc, zzuiVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized void zzg(zzlo zzloVar) {
        zznw zznwVar;
        String str = this.zzh;
        if (str != null) {
            zzns zznsVar = (zzns) this.zze.get(str);
            zznsVar.getClass();
            zzo(zznsVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzns zznsVar2 = (zzns) it.next();
            it.remove();
            if (zznsVar2.zzf && (zznwVar = this.zzf) != null) {
                zznwVar.zzd(zzloVar, zznsVar2.zzb, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final void zzh(zznw zznwVar) {
        this.zzf = zznwVar;
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized void zzi(zzlo zzloVar) {
        zzns zznsVar;
        this.zzf.getClass();
        if (!zzloVar.zzb.zzo()) {
            zzui zzuiVar = zzloVar.zzd;
            if (zzuiVar != null) {
                if (zzuiVar.zzd >= zzl() && ((zznsVar = (zzns) this.zze.get(this.zzh)) == null || zznsVar.zzd != -1 || zznsVar.zzc == zzloVar.zzc)) {
                }
            }
            zzns zznsVarZzm = zzm(zzloVar.zzc, zzloVar.zzd);
            if (this.zzh == null) {
                this.zzh = zznsVarZzm.zzb;
            }
            zzui zzuiVar2 = zzloVar.zzd;
            if (zzuiVar2 != null && zzuiVar2.zzb()) {
                zzns zznsVarZzm2 = zzm(zzloVar.zzc, new zzui(zzuiVar2.zza, zzuiVar2.zzd, zzuiVar2.zzb));
                if (!zznsVarZzm2.zzf) {
                    zznsVarZzm2.zzf = true;
                    zzloVar.zzb.zzn(zzloVar.zzd.zza, this.zzd);
                    this.zzd.zzi(zzloVar.zzd.zzb);
                    Math.max(0L, zzet.zzu(0L) + zzet.zzu(0L));
                    String unused = zznsVarZzm2.zzb;
                }
            }
            if (!zznsVarZzm.zzf) {
                zznsVarZzm.zzf = true;
                String unused2 = zznsVarZzm.zzb;
            }
            if (zznsVarZzm.zzb.equals(this.zzh) && !zznsVarZzm.zzg) {
                zznsVarZzm.zzg = true;
                this.zzf.zzc(zzloVar, zznsVarZzm.zzb);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized void zzj(zzlo zzloVar, int i10) {
        this.zzf.getClass();
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzns zznsVar = (zzns) it.next();
            if (zznsVar.zzk(zzloVar)) {
                it.remove();
                if (zznsVar.zzf) {
                    boolean zEquals = zznsVar.zzb.equals(this.zzh);
                    boolean z10 = false;
                    if (i10 == 0 && zEquals && zznsVar.zzg) {
                        z10 = true;
                    }
                    if (zEquals) {
                        zzo(zznsVar);
                    }
                    this.zzf.zzd(zzloVar, zznsVar.zzb, z10);
                }
            }
        }
        zzp(zzloVar);
    }

    @Override // com.google.android.gms.internal.ads.zznx
    public final synchronized void zzk(zzlo zzloVar) {
        this.zzf.getClass();
        zzcc zzccVar = this.zzg;
        this.zzg = zzloVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzns zznsVar = (zzns) it.next();
            if (!zznsVar.zzl(zzccVar, this.zzg) || zznsVar.zzk(zzloVar)) {
                it.remove();
                if (zznsVar.zzf) {
                    if (zznsVar.zzb.equals(this.zzh)) {
                        zzo(zznsVar);
                    }
                    this.zzf.zzd(zzloVar, zznsVar.zzb, false);
                }
            }
        }
        zzp(zzloVar);
    }

    public zznt(zzfvk zzfvkVar) {
        this.zzc = new zzcb();
        this.zzd = new zzca();
        this.zze = new HashMap();
        this.zzg = zzcc.zza;
        this.zzi = -1L;
    }
}
