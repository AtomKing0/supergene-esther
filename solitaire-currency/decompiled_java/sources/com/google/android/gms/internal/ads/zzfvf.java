package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfvf extends zzfue {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = Integer.MAX_VALUE;

    protected zzfvf(zzfvh zzfvhVar, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzfue
    protected final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int i10 = this.zzc;
        while (true) {
            int i11 = this.zzc;
            if (i11 == -1) {
                zzb();
                return null;
            }
            int iZzd = zzd(i11);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zzc = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zzc = iZzc;
            }
            if (iZzc != i10) {
                if (i10 < iZzd) {
                    this.zzb.charAt(i10);
                }
                if (i10 < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                int i12 = this.zzd;
                if (i12 == 1) {
                    iZzd = this.zzb.length();
                    this.zzc = -1;
                    if (iZzd > i10) {
                        this.zzb.charAt(iZzd - 1);
                    }
                } else {
                    this.zzd = i12 - 1;
                }
                return this.zzb.subSequence(i10, iZzd).toString();
            }
            int i13 = iZzc + 1;
            this.zzc = i13;
            if (i13 > this.zzb.length()) {
                this.zzc = -1;
            }
        }
    }

    abstract int zzc(int i10);

    abstract int zzd(int i10);
}
