package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccz extends zzccv {
    public zzccz(zzcbk zzcbkVar) {
        super(zzcbkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzt(String str) {
        String strZzf = com.google.android.gms.ads.internal.util.client.zzf.zzf(str);
        zzcbk zzcbkVar = (zzcbk) this.zzc.get();
        if (zzcbkVar != null && strZzf != null) {
            zzcbkVar.zzt(strZzf, this);
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, strZzf, "noop", "Noop cache is a noop.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzf() {
    }
}
