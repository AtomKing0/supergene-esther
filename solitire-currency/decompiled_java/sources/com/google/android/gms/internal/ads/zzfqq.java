package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqq extends zzfqx {
    private String zza;
    private byte zzb;
    private int zzc;

    zzfqq() {
    }

    public final zzfqx zza(String str) {
        this.zza = "";
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqx zzb(boolean z10) {
        this.zzb = (byte) (this.zzb | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqx zzc(boolean z10) {
        this.zzb = (byte) (this.zzb | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqy zzd() {
        if (this.zzb == 3 && this.zza != null && this.zzc != 0) {
            return new zzfqs(this.zza, false, false, null, null, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if ((this.zzb & 1) == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if ((this.zzb & 2) == 0) {
            sb.append(" skipChecks");
        }
        if (this.zzc == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqx zze(int i10) {
        this.zzc = 1;
        return this;
    }
}
