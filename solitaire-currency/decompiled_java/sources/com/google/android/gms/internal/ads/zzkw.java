package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkw {
    private final zznz zza;
    private final zzkv zze;
    private final zzln zzh;
    private final zzdt zzi;
    private boolean zzj;

    @Nullable
    private zzgu zzk;
    private zzwa zzl = new zzwa(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzkw(zzkv zzkvVar, zzln zzlnVar, zzdt zzdtVar, zznz zznzVar) {
        this.zza = zznzVar;
        this.zze = zzkvVar;
        this.zzh = zzlnVar;
        this.zzi = zzdtVar;
    }

    private final void zzr(int i10, int i11) {
        while (i10 < this.zzb.size()) {
            ((zzku) this.zzb.get(i10)).zzd += i11;
            i10++;
        }
    }

    private final void zzs(zzku zzkuVar) {
        zzkt zzktVar = (zzkt) this.zzf.get(zzkuVar);
        if (zzktVar != null) {
            zzktVar.zza.zzi(zzktVar.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzku zzkuVar = (zzku) it.next();
            if (zzkuVar.zzc.isEmpty()) {
                zzs(zzkuVar);
                it.remove();
            }
        }
    }

    private final void zzu(zzku zzkuVar) {
        if (zzkuVar.zze && zzkuVar.zzc.isEmpty()) {
            zzkt zzktVar = (zzkt) this.zzf.remove(zzkuVar);
            zzktVar.getClass();
            zzktVar.zza.zzp(zzktVar.zzb);
            zzktVar.zza.zzs(zzktVar.zzc);
            zzktVar.zza.zzr(zzktVar.zzc);
            this.zzg.remove(zzkuVar);
        }
    }

    private final void zzv(zzku zzkuVar) {
        zzud zzudVar = zzkuVar.zza;
        zzuj zzujVar = new zzuj() { // from class: com.google.android.gms.internal.ads.zzkm
            @Override // com.google.android.gms.internal.ads.zzuj
            public final void zza(zzuk zzukVar, zzcc zzccVar) {
                this.zza.zzf(zzukVar, zzccVar);
            }
        };
        zzks zzksVar = new zzks(this, zzkuVar);
        this.zzf.put(zzkuVar, new zzkt(zzudVar, zzujVar, zzksVar));
        zzudVar.zzh(new Handler(zzet.zzy(), null), zzksVar);
        zzudVar.zzg(new Handler(zzet.zzy(), null), zzksVar);
        zzudVar.zzm(zzujVar, this.zzk, this.zza);
    }

    private final void zzw(int i10, int i11) {
        while (true) {
            i11--;
            if (i11 < i10) {
                return;
            }
            zzku zzkuVar = (zzku) this.zzb.remove(i11);
            this.zzd.remove(zzkuVar.zzb);
            zzr(i11, -zzkuVar.zza.zzC().zzc());
            zzkuVar.zze = true;
            if (this.zzj) {
                zzu(zzkuVar);
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcc zzb() {
        if (this.zzb.isEmpty()) {
            return zzcc.zza;
        }
        int iZzc = 0;
        for (int i10 = 0; i10 < this.zzb.size(); i10++) {
            zzku zzkuVar = (zzku) this.zzb.get(i10);
            zzkuVar.zzd = iZzc;
            iZzc += zzkuVar.zza.zzC().zzc();
        }
        return new zzlc(this.zzb, this.zzl);
    }

    public final zzcc zzc(int i10, int i11, List list) {
        zzdi.zzd(i10 >= 0 && i10 <= i11 && i11 <= zza());
        zzdi.zzd(list.size() == i11 - i10);
        for (int i12 = i10; i12 < i11; i12++) {
            ((zzku) this.zzb.get(i12)).zza.zzt((zzbc) list.get(i12 - i10));
        }
        return zzb();
    }

    final /* synthetic */ void zzf(zzuk zzukVar, zzcc zzccVar) {
        this.zze.zzg();
    }

    public final void zzg(@Nullable zzgu zzguVar) {
        zzdi.zzf(!this.zzj);
        this.zzk = zzguVar;
        for (int i10 = 0; i10 < this.zzb.size(); i10++) {
            zzku zzkuVar = (zzku) this.zzb.get(i10);
            zzv(zzkuVar);
            this.zzg.add(zzkuVar);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzkt zzktVar : this.zzf.values()) {
            try {
                zzktVar.zza.zzp(zzktVar.zzb);
            } catch (RuntimeException e10) {
                zzea.zzd("MediaSourceList", "Failed to release child source.", e10);
            }
            zzktVar.zza.zzs(zzktVar.zzc);
            zzktVar.zza.zzr(zzktVar.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzug zzugVar) {
        zzku zzkuVar = (zzku) this.zzc.remove(zzugVar);
        zzkuVar.getClass();
        zzkuVar.zza.zzG(zzugVar);
        zzkuVar.zzc.remove(((zzua) zzugVar).zza);
        if (!this.zzc.isEmpty()) {
            zzt();
        }
        zzu(zzkuVar);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzcc zzk(int i10, List list, zzwa zzwaVar) {
        if (!list.isEmpty()) {
            this.zzl = zzwaVar;
            for (int i11 = i10; i11 < list.size() + i10; i11++) {
                zzku zzkuVar = (zzku) list.get(i11 - i10);
                if (i11 > 0) {
                    zzku zzkuVar2 = (zzku) this.zzb.get(i11 - 1);
                    zzkuVar.zzc(zzkuVar2.zzd + zzkuVar2.zza.zzC().zzc());
                } else {
                    zzkuVar.zzc(0);
                }
                zzr(i11, zzkuVar.zza.zzC().zzc());
                this.zzb.add(i11, zzkuVar);
                this.zzd.put(zzkuVar.zzb, zzkuVar);
                if (this.zzj) {
                    zzv(zzkuVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzkuVar);
                    } else {
                        zzs(zzkuVar);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcc zzl(int i10, int i11, int i12, zzwa zzwaVar) {
        zzdi.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzcc zzm(int i10, int i11, zzwa zzwaVar) {
        boolean z10 = false;
        if (i10 >= 0 && i10 <= i11 && i11 <= zza()) {
            z10 = true;
        }
        zzdi.zzd(z10);
        this.zzl = zzwaVar;
        zzw(i10, i11);
        return zzb();
    }

    public final zzcc zzn(List list, zzwa zzwaVar) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzwaVar);
    }

    public final zzcc zzo(zzwa zzwaVar) {
        int iZza = zza();
        if (zzwaVar.zzc() != iZza) {
            zzwaVar = zzwaVar.zzf().zzg(0, iZza);
        }
        this.zzl = zzwaVar;
        return zzb();
    }

    public final zzug zzp(zzui zzuiVar, zzyk zzykVar, long j10) {
        int i10 = zzlc.zzb;
        Object obj = zzuiVar.zza;
        Object obj2 = ((Pair) obj).first;
        zzui zzuiVarZza = zzuiVar.zza(((Pair) obj).second);
        zzku zzkuVar = (zzku) this.zzd.get(obj2);
        zzkuVar.getClass();
        this.zzg.add(zzkuVar);
        zzkt zzktVar = (zzkt) this.zzf.get(zzkuVar);
        if (zzktVar != null) {
            zzktVar.zza.zzk(zzktVar.zzb);
        }
        zzkuVar.zzc.add(zzuiVarZza);
        zzua zzuaVarZzI = zzkuVar.zza.zzI(zzuiVarZza, zzykVar, j10);
        this.zzc.put(zzuaVarZzI, zzkuVar);
        zzt();
        return zzuaVarZzI;
    }

    public final zzwa zzq() {
        return this.zzl;
    }
}
