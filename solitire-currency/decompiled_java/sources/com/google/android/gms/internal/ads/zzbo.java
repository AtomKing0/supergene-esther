package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzbo extends IOException {
    public final boolean zza;
    public final int zzb;

    protected zzbo(@Nullable String str, @Nullable Throwable th, boolean z10, int i10) {
        super(str, th);
        this.zza = z10;
        this.zzb = i10;
    }

    public static zzbo zza(@Nullable String str, @Nullable Throwable th) {
        return new zzbo(str, th, true, 1);
    }

    public static zzbo zzb(@Nullable String str, @Nullable Throwable th) {
        return new zzbo(str, th, true, 0);
    }

    public static zzbo zzc(@Nullable String str) {
        return new zzbo(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    @Nullable
    public final String getMessage() {
        return super.getMessage() + "{contentIsMalformed=" + this.zza + ", dataType=" + this.zzb + "}";
    }
}
