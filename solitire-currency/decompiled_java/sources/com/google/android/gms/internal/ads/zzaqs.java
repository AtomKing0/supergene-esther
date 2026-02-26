package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaqs extends zzhen {
    static {
        zzheu.zzb(zzaqs.class);
    }

    public zzaqs(zzheo zzheoVar, zzaqr zzaqrVar) throws IOException {
        zze(zzheoVar, zzheoVar.zzc(), zzaqrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhen
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzhen, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
