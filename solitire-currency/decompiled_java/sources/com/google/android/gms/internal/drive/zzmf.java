package com.google.android.gms.internal.drive;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
interface zzmf<T> {
    boolean equals(T t10, T t11);

    int hashCode(T t10);

    T newInstance();

    void zza(T t10, zzns zznsVar) throws IOException;

    void zza(T t10, byte[] bArr, int i10, int i11, zziz zzizVar) throws IOException;

    void zzc(T t10, T t11);

    void zzd(T t10);

    int zzn(T t10);

    boolean zzp(T t10);
}
