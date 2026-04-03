package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazg extends zzayx {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzazg(int i10) {
        int i11 = i10 >> 3;
        this.zzc = (i10 & 7) > 0 ? i11 + 1 : i11;
        this.zzd = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzayx
    public final byte[] zzb(String str) {
        synchronized (this.zza) {
            MessageDigest messageDigestZza = zza();
            this.zzb = messageDigestZza;
            if (messageDigestZza == null) {
                return new byte[0];
            }
            messageDigestZza.reset();
            this.zzb.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] bArrDigest = this.zzb.digest();
            int length = bArrDigest.length;
            int i10 = this.zzc;
            if (length > i10) {
                length = i10;
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bArrDigest, 0, bArr, 0, length);
            if ((this.zzd & 7) > 0) {
                long j10 = 0;
                for (int i11 = 0; i11 < length; i11++) {
                    if (i11 > 0) {
                        j10 <<= 8;
                    }
                    j10 += (long) (bArr[i11] & 255);
                }
                long j11 = j10 >>> (8 - (this.zzd & 7));
                int i12 = this.zzc;
                while (true) {
                    i12--;
                    if (i12 < 0) {
                        break;
                    }
                    bArr[i12] = (byte) (255 & j11);
                    j11 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
