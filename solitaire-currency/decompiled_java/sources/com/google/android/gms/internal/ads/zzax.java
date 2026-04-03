package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzax {
    public final Uri zza;

    @Nullable
    public final String zzb;

    @Nullable
    public final zzas zzc;

    @Nullable
    public final zzal zzd;
    public final List zze;

    @Nullable
    public final String zzf;
    public final zzfxr zzg;

    @Nullable
    public final Object zzh;
    public final long zzi;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ zzax(Uri uri, String str, zzas zzasVar, zzal zzalVar, List list, String str2, zzfxr zzfxrVar, Object obj, long j10, zzaw zzawVar) {
        this.zza = uri;
        int i10 = zzbn.zza;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfxrVar;
        zzfxo zzfxoVar = new zzfxo();
        if (zzfxrVar.size() > 0) {
            throw null;
        }
        zzfxoVar.zzi();
        this.zzh = null;
        this.zzi = C.TIME_UNSET;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzax)) {
            return false;
        }
        zzax zzaxVar = (zzax) obj;
        if (this.zza.equals(zzaxVar.zza) && zzet.zzG(null, null) && zzet.zzG(null, null) && zzet.zzG(null, null) && this.zze.equals(zzaxVar.zze) && zzet.zzG(null, null) && this.zzg.equals(zzaxVar.zzg) && zzet.zzG(null, null)) {
            Long lValueOf = Long.valueOf(C.TIME_UNSET);
            if (zzet.zzG(lValueOf, lValueOf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) ((((long) (((((this.zza.hashCode() * 923521) + this.zze.hashCode()) * 961) + this.zzg.hashCode()) * 31)) * 31) + C.TIME_UNSET);
    }
}
