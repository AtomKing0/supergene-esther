package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfy {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;

    @Nullable
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzbd.zzb("media3.datasource");
    }

    public final String toString() {
        return "DataSpec[GET " + this.zza.toString() + ", " + this.zze + ", " + this.zzf + ", null, " + this.zzg + v8.i.f15839e;
    }

    public final zzfw zza() {
        return new zzfw(this, null);
    }

    public final boolean zzb(int i10) {
        return (this.zzg & i10) == i10;
    }

    private zzfy(Uri uri, long j10, int i10, @Nullable byte[] bArr, Map map, long j11, long j12, @Nullable String str, int i11, @Nullable Object obj) {
        boolean z10 = false;
        boolean z11 = j11 >= 0;
        zzdi.zzd(z11);
        zzdi.zzd(z11);
        if (j12 > 0) {
            z10 = true;
        } else if (j12 == -1) {
            j12 = -1;
            z10 = true;
        }
        zzdi.zzd(z10);
        uri.getClass();
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zze = j11;
        this.zzf = j12;
        this.zzg = i11;
    }

    @Deprecated
    public zzfy(Uri uri, long j10, long j11, @Nullable String str) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j10, j11, null, 0, null);
    }
}
