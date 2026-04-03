package com.google.android.gms.measurement.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhd implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzgy zza;

    zzhd(zzgy zzgyVar) {
        this.zza = zzgyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z10, boolean z11) {
        int i10 = zzhf.zza[zzsVar.ordinal()];
        zzgd zzgdVarZzn = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? this.zza.zzj().zzn() : this.zza.zzj().zzp() : z10 ? this.zza.zzj().zzw() : !z11 ? this.zza.zzj().zzv() : this.zza.zzj().zzu() : z10 ? this.zza.zzj().zzm() : !z11 ? this.zza.zzj().zzh() : this.zza.zzj().zzg() : this.zza.zzj().zzc();
        int size = list.size();
        if (size == 1) {
            zzgdVarZzn.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgdVarZzn.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgdVarZzn.zza(str);
        } else {
            zzgdVarZzn.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
