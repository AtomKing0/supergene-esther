package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcq {
    private final zzfxr zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private boolean zzd;

    public zzcq(zzfxr zzfxrVar) {
        this.zza = zzfxrVar;
        zzcr zzcrVar = zzcr.zza;
        this.zzd = false;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z10;
        do {
            int i10 = 0;
            z10 = false;
            while (i10 <= zzi()) {
                if (!this.zzc[i10].hasRemaining()) {
                    zzct zzctVar = (zzct) this.zzb.get(i10);
                    if (!zzctVar.zzh()) {
                        ByteBuffer byteBuffer2 = i10 > 0 ? this.zzc[i10 - 1] : byteBuffer.hasRemaining() ? byteBuffer : zzct.zza;
                        long jRemaining = byteBuffer2.remaining();
                        zzctVar.zze(byteBuffer2);
                        this.zzc[i10] = zzctVar.zzb();
                        long jRemaining2 = jRemaining - ((long) byteBuffer2.remaining());
                        boolean z11 = true;
                        if (jRemaining2 <= 0 && !this.zzc[i10].hasRemaining()) {
                            z11 = false;
                        }
                        z10 |= z11;
                    } else if (!this.zzc[i10].hasRemaining() && i10 < zzi()) {
                        ((zzct) this.zzb.get(i10 + 1)).zzd();
                    }
                }
                i10++;
            }
        } while (z10);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcq)) {
            return false;
        }
        zzcq zzcqVar = (zzcq) obj;
        if (this.zza.size() != zzcqVar.zza.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            if (this.zza.get(i10) != zzcqVar.zza.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzcr zza(zzcr zzcrVar) throws zzcs {
        if (zzcrVar.equals(zzcr.zza)) {
            throw new zzcs("Unhandled input format:", zzcrVar);
        }
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            zzct zzctVar = (zzct) this.zza.get(i10);
            zzcr zzcrVarZza = zzctVar.zza(zzcrVar);
            if (zzctVar.zzg()) {
                zzdi.zzf(!zzcrVarZza.equals(zzcr.zza));
                zzcrVar = zzcrVarZza;
            }
        }
        return zzcrVar;
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzct.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzct.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = false;
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            zzct zzctVar = (zzct) this.zza.get(i10);
            zzctVar.zzc();
            if (zzctVar.zzg()) {
                this.zzb.add(zzctVar);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i11 = 0; i11 <= zzi(); i11++) {
            this.zzc[i11] = ((zzct) this.zzb.get(i11)).zzb();
        }
    }

    public final void zzd() {
        if (!zzh() || this.zzd) {
            return;
        }
        this.zzd = true;
        ((zzct) this.zzb.get(0)).zzd();
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (!zzh() || this.zzd) {
            return;
        }
        zzj(byteBuffer);
    }

    public final void zzf() {
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            zzct zzctVar = (zzct) this.zza.get(i10);
            zzctVar.zzc();
            zzctVar.zzf();
        }
        this.zzc = new ByteBuffer[0];
        zzcr zzcrVar = zzcr.zza;
        this.zzd = false;
    }

    public final boolean zzg() {
        return this.zzd && ((zzct) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining();
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
