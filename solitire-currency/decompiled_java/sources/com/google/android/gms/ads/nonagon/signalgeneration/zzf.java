package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzdsp;
import com.ironsource.mediationsdk.metadata.a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzf extends QueryInfoGenerationCallback {
    private final zze zza;
    private final zzdsp zzb;
    private final boolean zzc;
    private final int zzd;
    private final long zze = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();

    @Nullable
    private final Boolean zzf;

    public zzf(zze zzeVar, boolean z10, int i10, @Nullable Boolean bool, zzdsp zzdspVar) {
        this.zza = zzeVar;
        this.zzc = z10;
        this.zzd = i10;
        this.zzf = bool;
        this.zzb = zzdspVar;
    }

    private static long zza() {
        return com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() + ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziX)).longValue();
    }

    private final long zzb() {
        return com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - this.zze;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair("sgf_reason", str);
        pairArr[1] = new Pair("se", "query_g");
        pairArr[2] = new Pair("ad_format", AdFormat.BANNER.name());
        pairArr[3] = new Pair("rtype", Integer.toString(6));
        pairArr[4] = new Pair("scar", a.f13688g);
        pairArr[5] = new Pair("lat_ms", Long.toString(zzb()));
        pairArr[6] = new Pair("sgpc_rn", Integer.toString(this.zzd));
        pairArr[7] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        pairArr[8] = new Pair("tpc", true != this.zzc ? "0" : "1");
        zzq.zzd(this.zzb, null, "sgpcf", pairArr);
        this.zza.zzf(this.zzc, new zzg(null, str, zza(), this.zzd));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        Pair[] pairArr = new Pair[8];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair("ad_format", AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", a.f13688g);
        pairArr[4] = new Pair("lat_ms", Long.toString(zzb()));
        pairArr[5] = new Pair("sgpc_rn", Integer.toString(this.zzd));
        pairArr[6] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        pairArr[7] = new Pair("tpc", true != this.zzc ? "0" : "1");
        zzq.zzd(this.zzb, null, "sgpcs", pairArr);
        this.zza.zzf(this.zzc, new zzg(queryInfo, "", zza(), this.zzd));
    }
}
