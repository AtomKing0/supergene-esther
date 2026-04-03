package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbao extends PushbackInputStream {
    final /* synthetic */ zzbap zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbao(zzbap zzbapVar, InputStream inputStream, int i10) {
        super(inputStream, 1);
        this.zza = zzbapVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        zzbar.zze(this.zza.zzc);
        super.close();
    }
}
