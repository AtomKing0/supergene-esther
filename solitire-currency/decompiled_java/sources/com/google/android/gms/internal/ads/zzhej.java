package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhej implements zzaqu {
    private static final zzheu zzg = zzheu.zzb(zzhej.class);
    protected final String zza;
    long zzd;
    zzheo zzf;
    private ByteBuffer zzh;
    long zze = -1;
    boolean zzc = true;
    boolean zzb = true;

    protected zzhej(String str) {
        this.zza = str;
    }

    private final synchronized void zzc() {
        if (this.zzc) {
            return;
        }
        try {
            zzheu zzheuVar = zzg;
            String str = this.zza;
            zzheuVar.zza(str.length() != 0 ? "mem mapping ".concat(str) : new String("mem mapping "));
            this.zzh = this.zzf.zzd(this.zzd, this.zze);
            this.zzc = true;
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqu
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqu
    public final void zzb(zzheo zzheoVar, ByteBuffer byteBuffer, long j10, zzaqr zzaqrVar) throws IOException {
        this.zzd = zzheoVar.zzb();
        byteBuffer.remaining();
        this.zze = j10;
        this.zzf = zzheoVar;
        zzheoVar.zze(zzheoVar.zzb() + j10);
        this.zzc = false;
        this.zzb = false;
        zzf();
    }

    protected abstract void zze(ByteBuffer byteBuffer);

    public final synchronized void zzf() {
        zzc();
        zzheu zzheuVar = zzg;
        String str = this.zza;
        zzheuVar.zza(str.length() != 0 ? "parsing details of ".concat(str) : new String("parsing details of "));
        ByteBuffer byteBuffer = this.zzh;
        if (byteBuffer != null) {
            this.zzb = true;
            byteBuffer.rewind();
            zze(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                byteBuffer.slice();
            }
            this.zzh = null;
        }
    }
}
