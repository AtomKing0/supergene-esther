package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfq extends zzfl {

    @Nullable
    private zzfy zza;

    @Nullable
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzfq() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.zzd;
        if (i12 == 0) {
            return -1;
        }
        int iMin = Math.min(i11, i12);
        byte[] bArr2 = this.zzb;
        int i13 = zzet.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i10, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws IOException {
        zzi(zzfyVar);
        this.zza = zzfyVar;
        Uri uriNormalizeScheme = zzfyVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzdi.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i10 = zzet.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzbo.zzb("Unexpected URI format: ".concat(String.valueOf(uriNormalizeScheme)), null);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str, 0);
            } catch (IllegalArgumentException e10) {
                throw zzbo.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e10);
            }
        } else {
            this.zzb = URLDecoder.decode(str, zzfuj.zza.name()).getBytes(zzfuj.zzc);
        }
        long j10 = zzfyVar.zze;
        int length = this.zzb.length;
        if (j10 > length) {
            this.zzb = null;
            throw new zzft(2008);
        }
        int i11 = (int) j10;
        this.zzc = i11;
        int i12 = length - i11;
        this.zzd = i12;
        long j11 = zzfyVar.zzf;
        if (j11 != -1) {
            this.zzd = (int) Math.min(i12, j11);
        }
        zzj(zzfyVar);
        long j12 = zzfyVar.zzf;
        return j12 != -1 ? j12 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Uri zzc() {
        zzfy zzfyVar = this.zza;
        if (zzfyVar != null) {
            return zzfyVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
