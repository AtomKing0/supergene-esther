package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzawr extends zzaxd {
    public zzawr(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i10, int i11) {
        super(zzavpVar, "WfvM4SeNDVyFarUKUVpVTE2MRQkjnaN4GpgwC5lMrmyQkCennlTSSkgCAZvzOVXK", "Kq6mcF8LH4HqXGyg5/DR3VvLtDExNTPXoCRIPhkdOGM=", zzaroVar, i10, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzauv zzauvVar = new zzauv((String) this.zze.invoke(null, this.zza.zzb(), Boolean.valueOf(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcu)).booleanValue())));
        synchronized (this.zzd) {
            this.zzd.zzj(zzauvVar.zza);
            this.zzd.zzC(zzauvVar.zzb);
        }
    }
}
