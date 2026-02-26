package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzccv implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzccv(zzcbk zzcbkVar) {
        Context context = zzcbkVar.getContext();
        this.zza = context;
        this.zzb = com.google.android.gms.ads.internal.zzu.zzp().zzc(context, zzcbkVar.zzn().afmaVersion);
        this.zzc = new WeakReference(zzcbkVar);
    }

    static /* bridge */ /* synthetic */ void zze(zzccv zzccvVar, String str, Map map) {
        zzcbk zzcbkVar = (zzcbk) zzccvVar.zzc.get();
        if (zzcbkVar != null) {
            zzcbkVar.zzd("onPrecacheEvent", map);
        }
    }

    public abstract void zzf();

    public final void zzg(String str, @Nullable String str2, String str3, @Nullable String str4) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzccu(this, str, str2, str3, str4));
    }

    protected final void zzh(String str, String str2, int i10) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzccs(this, str, str2, i10));
    }

    public final void zzj(String str, String str2, long j10) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcct(this, str, str2, j10));
    }

    public final void zzn(String str, String str2, int i10, int i11, long j10, long j11, boolean z10, int i12, int i13) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzccr(this, str, str2, i10, i11, j10, j11, z10, i12, i13));
    }

    public final void zzo(String str, String str2, long j10, long j11, boolean z10, long j12, long j13, long j14, int i10, int i11) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzccq(this, str, str2, j10, j11, j12, j13, j14, z10, i10, i11));
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzccn zzccnVar) {
        return zzt(str);
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    protected void zzp(int i10) {
    }

    protected void zzq(int i10) {
    }

    protected void zzr(int i10) {
    }

    protected void zzs(int i10) {
    }
}
