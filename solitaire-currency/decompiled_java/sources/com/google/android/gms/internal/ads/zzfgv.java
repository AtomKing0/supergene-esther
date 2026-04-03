package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfgv implements zzfgu {
    private final ConcurrentHashMap zza;
    private final zzfhb zzb;
    private final zzfgx zzc = new zzfgx();

    public zzfgv(zzfhb zzfhbVar) {
        this.zza = new ConcurrentHashMap(zzfhbVar.zzd);
        this.zzb = zzfhbVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfhb> creator = zzfhb.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfH)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i10 = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i10++;
                sb.append(i10);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfhe) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i11 = 0; i11 < ((zzfgt) entry.getValue()).zzb(); i11++) {
                    sb.append("[O]");
                }
                for (int iZzb = ((zzfgt) entry.getValue()).zzb(); iZzb < this.zzb.zzd; iZzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfgt) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i10 < this.zzb.zzc) {
                i10++;
                sb.append(i10);
                sb.append(".\n");
            }
            com.google.android.gms.ads.internal.util.client.zzm.zze(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final zzfhb zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    @Nullable
    public final synchronized zzfhd zzb(zzfhe zzfheVar) {
        zzfhd zzfhdVarZze;
        zzfgt zzfgtVar = (zzfgt) this.zza.get(zzfheVar);
        if (zzfgtVar != null) {
            zzfhdVarZze = zzfgtVar.zze();
            if (zzfhdVarZze == null) {
                this.zzc.zze();
            }
            zzfhr zzfhrVarZzf = zzfgtVar.zzf();
            if (zzfhdVarZze != null) {
                zzbbc.zzb.zzc zzcVarZzd = zzbbc.zzb.zzd();
                zzbbc.zzb.zza.C0194zza c0194zzaZza = zzbbc.zzb.zza.zza();
                c0194zzaZza.zzf(zzbbc.zzb.zzd.IN_MEMORY);
                zzbbc.zzb.zze.zza zzaVarZzc = zzbbc.zzb.zze.zzc();
                zzaVarZzc.zzd(zzfhrVarZzf.zza);
                zzaVarZzc.zze(zzfhrVarZzf.zzb);
                c0194zzaZza.zzg(zzaVarZzc);
                zzcVarZzd.zzd(c0194zzaZza);
                zzfhdVarZze.zza.zzb().zzc().zzi(zzcVarZzd.zzbr());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfhdVarZze = null;
        }
        return zzfhdVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    @Deprecated
    public final zzfhe zzc(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, com.google.android.gms.ads.internal.client.zzw zzwVar) {
        return new zzfhf(zzlVar, str, new zzbve(this.zzb.zza).zza().zzj, this.zzb.zzf, zzwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final synchronized boolean zzd(zzfhe zzfheVar, zzfhd zzfhdVar) {
        boolean zZzh;
        zzfgt zzfgtVar = (zzfgt) this.zza.get(zzfheVar);
        zzfhdVar.zzd = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        if (zzfgtVar == null) {
            zzfhb zzfhbVar = this.zzb;
            zzfgt zzfgtVar2 = new zzfgt(zzfhbVar.zzd, zzfhbVar.zze * 1000);
            if (this.zza.size() == this.zzb.zzc) {
                int i10 = this.zzb.zzg;
                int i11 = i10 - 1;
                zzfhe zzfheVar2 = null;
                if (i10 == 0) {
                    throw null;
                }
                long jZzc = Long.MAX_VALUE;
                if (i11 == 0) {
                    for (Map.Entry entry : this.zza.entrySet()) {
                        if (((zzfgt) entry.getValue()).zzc() < jZzc) {
                            jZzc = ((zzfgt) entry.getValue()).zzc();
                            zzfheVar2 = (zzfhe) entry.getKey();
                        }
                    }
                    if (zzfheVar2 != null) {
                        this.zza.remove(zzfheVar2);
                    }
                } else if (i11 == 1) {
                    for (Map.Entry entry2 : this.zza.entrySet()) {
                        if (((zzfgt) entry2.getValue()).zzd() < jZzc) {
                            jZzc = ((zzfgt) entry2.getValue()).zzd();
                            zzfheVar2 = (zzfhe) entry2.getKey();
                        }
                    }
                    if (zzfheVar2 != null) {
                        this.zza.remove(zzfheVar2);
                    }
                } else if (i11 == 2) {
                    int iZza = Integer.MAX_VALUE;
                    for (Map.Entry entry3 : this.zza.entrySet()) {
                        if (((zzfgt) entry3.getValue()).zza() < iZza) {
                            iZza = ((zzfgt) entry3.getValue()).zza();
                            zzfheVar2 = (zzfhe) entry3.getKey();
                        }
                    }
                    if (zzfheVar2 != null) {
                        this.zza.remove(zzfheVar2);
                    }
                }
                this.zzc.zzg();
            }
            this.zza.put(zzfheVar, zzfgtVar2);
            this.zzc.zzd();
            zzfgtVar = zzfgtVar2;
        }
        zZzh = zzfgtVar.zzh(zzfhdVar);
        this.zzc.zzc();
        zzfgw zzfgwVarZza = this.zzc.zza();
        zzfhr zzfhrVarZzf = zzfgtVar.zzf();
        zzbbc.zzb.zzc zzcVarZzd = zzbbc.zzb.zzd();
        zzbbc.zzb.zza.C0194zza c0194zzaZza = zzbbc.zzb.zza.zza();
        c0194zzaZza.zzf(zzbbc.zzb.zzd.IN_MEMORY);
        zzbbc.zzb.zzg.zza zzaVarZzc = zzbbc.zzb.zzg.zzc();
        zzaVarZzc.zze(zzfgwVarZza.zza);
        zzaVarZzc.zzf(zzfgwVarZza.zzb);
        zzaVarZzc.zzg(zzfhrVarZzf.zzb);
        c0194zzaZza.zzi(zzaVarZzc);
        zzcVarZzd.zzd(c0194zzaZza);
        zzfhdVar.zza.zzb().zzc().zzj(zzcVarZzd.zzbr());
        zzf();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final synchronized boolean zze(zzfhe zzfheVar) {
        zzfgt zzfgtVar = (zzfgt) this.zza.get(zzfheVar);
        if (zzfgtVar == null) {
            return true;
        }
        return zzfgtVar.zzb() < this.zzb.zzd;
    }
}
