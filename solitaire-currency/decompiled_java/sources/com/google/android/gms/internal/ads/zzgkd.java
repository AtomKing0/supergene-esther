package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgkd extends zzgke {
    public zzgkd(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgke
    final zzgkc zza(byte[] bArr, int i10) throws InvalidKeyException {
        return new zzgkb(bArr, i10);
    }
}
