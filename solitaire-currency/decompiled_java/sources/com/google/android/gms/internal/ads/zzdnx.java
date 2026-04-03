package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdnx implements Callable {
    private final com.google.android.gms.ads.internal.zza zza;
    private final Context zzb;
    private final zzdsk zzc;
    private final zzedh zzd;
    private final Executor zze;
    private final zzauo zzf;
    private final VersionInfoParcel zzg;
    private final zzfll zzh;
    private final zzeds zzi;
    private final zzffk zzj;

    public zzdnx(Context context, Executor executor, zzauo zzauoVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzcew zzcewVar, zzedh zzedhVar, zzfll zzfllVar, zzdsk zzdskVar, zzeds zzedsVar, zzffk zzffkVar) {
        this.zzb = context;
        this.zze = executor;
        this.zzf = zzauoVar;
        this.zzg = versionInfoParcel;
        this.zza = zzaVar;
        this.zzd = zzedhVar;
        this.zzh = zzfllVar;
        this.zzc = zzdskVar;
        this.zzi = zzedsVar;
        this.zzj = zzffkVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdoa zzdoaVar = new zzdoa(this);
        zzdoaVar.zzk();
        return zzdoaVar;
    }
}
