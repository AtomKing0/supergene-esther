package com.google.android.gms.games;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedData<T> {

    @Nullable
    private final Object zza;
    private final boolean zzb;

    public AnnotatedData(@Nullable Object obj, boolean z10) {
        this.zza = obj;
        this.zzb = z10;
    }

    @Nullable
    public T get() {
        return (T) this.zza;
    }

    public boolean isStale() {
        return this.zzb;
    }
}
