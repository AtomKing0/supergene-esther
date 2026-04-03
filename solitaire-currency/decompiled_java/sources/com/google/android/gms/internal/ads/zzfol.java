package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfol extends zzfoi {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private byte zzd;

    zzfol() {
    }

    @Override // com.google.android.gms.internal.ads.zzfoi
    public final zzfoi zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientVersion");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfoi
    public final zzfoi zzb(boolean z10) {
        this.zzc = true;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfoi
    public final zzfoi zzc(boolean z10) {
        this.zzb = z10;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfoi
    public final zzfoj zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzfon(str, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" clientVersion");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
