package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgn extends zzgl {
    public final int zzc;

    public zzgn(int i10, @Nullable String str, @Nullable IOException iOException, Map map, zzfy zzfyVar, byte[] bArr) {
        super("Response code: " + i10, iOException, zzfyVar, 2004, 1);
        this.zzc = i10;
    }
}
