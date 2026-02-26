package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzam {

    @Nullable
    private String zza;

    @Nullable
    private Uri zzb;
    private final zzan zzc = new zzan();
    private final List zzd;
    private final zzfxr zze;
    private final zzat zzf;
    private final zzaz zzg;

    public zzam() {
        zzfxr.zzm();
        this.zzd = Collections.emptyList();
        this.zze = zzfxr.zzm();
        this.zzf = new zzat();
        this.zzg = zzaz.zza;
    }

    public final zzam zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzam zzb(@Nullable Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzbc zzc() {
        zzax zzaxVar;
        Uri uri = this.zzb;
        if (uri != null) {
            zzaxVar = new zzax(uri, null, null, null, this.zzd, null, this.zze, null, C.TIME_UNSET, null);
        } else {
            zzaxVar = null;
        }
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzbc(str, new zzar(this.zzc, null), zzaxVar, new zzav(this.zzf, null), zzbh.zza, this.zzg, null);
    }
}
