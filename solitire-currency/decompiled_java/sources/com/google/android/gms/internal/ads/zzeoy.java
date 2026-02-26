package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeoy implements zzevn {
    private final com.google.android.gms.ads.internal.client.zzw zza;
    private final VersionInfoParcel zzb;
    private final boolean zzc;

    public zzeoy(com.google.android.gms.ads.internal.client.zzw zzwVar, VersionInfoParcel versionInfoParcel, boolean z10) {
        this.zza = zzwVar;
        this.zzb = versionInfoParcel;
        this.zzc = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeK)).intValue()) {
            bundle.putString("app_open_version", "2");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeL)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        com.google.android.gms.ads.internal.client.zzw zzwVar = this.zza;
        if (zzwVar != null) {
            int i10 = zzwVar.zza;
            if (i10 == 1) {
                bundle.putString("avo", TtmlNode.TAG_P);
            } else if (i10 == 2) {
                bundle.putString("avo", CmcdData.Factory.STREAM_TYPE_LIVE);
            }
        }
    }
}
