package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzft extends IOException {
    public final int zza;

    public zzft(int i10) {
        this.zza = i10;
    }

    public zzft(@Nullable String str, int i10) {
        super(str);
        this.zza = i10;
    }

    public zzft(@Nullable String str, @Nullable Throwable th, int i10) {
        super(str, th);
        this.zza = i10;
    }

    public zzft(@Nullable Throwable th, int i10) {
        super(th);
        this.zza = i10;
    }
}
