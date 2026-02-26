package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanm implements zzang {
    final /* synthetic */ zzano zza;
    private final zzej zzb = new zzej(new byte[4], 4);

    public zzanm(zzano zzanoVar) {
        this.zza = zzanoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzek zzekVar) {
        if (zzekVar.zzm() == 0 && (zzekVar.zzm() & 128) != 0) {
            zzekVar.zzL(6);
            int iZzb = zzekVar.zzb() / 4;
            for (int i10 = 0; i10 < iZzb; i10++) {
                zzekVar.zzF(this.zzb, 4);
                zzej zzejVar = this.zzb;
                int iZzd = zzejVar.zzd(16);
                zzejVar.zzn(3);
                if (iZzd == 0) {
                    this.zzb.zzn(13);
                } else {
                    int iZzd2 = this.zzb.zzd(13);
                    if (this.zza.zzg.get(iZzd2) == null) {
                        zzano zzanoVar = this.zza;
                        zzanoVar.zzg.put(iZzd2, new zzanh(new zzann(zzanoVar, iZzd2)));
                        this.zza.zzm++;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzb(zzer zzerVar, zzacn zzacnVar, zzans zzansVar) {
    }
}
