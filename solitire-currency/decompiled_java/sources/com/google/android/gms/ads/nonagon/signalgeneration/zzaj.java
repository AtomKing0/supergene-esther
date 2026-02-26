package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzgcf;
import com.ironsource.mediationsdk.metadata.a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaj implements zzgcf {
    final /* synthetic */ zzak zza;

    zzaj(zzak zzakVar) {
        this.zza = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzq.zzd(this.zza.zzp, null, "sgf", new Pair("sgf_reason", th.getMessage()), new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", a.f13688g), new Pair("sgi_rn", Integer.toString(this.zza.zzH.get())));
        com.google.android.gms.ads.internal.util.client.zzm.zzh("Failed to initialize webview for loading SDKCore. ", th);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziO)).booleanValue() || this.zza.zzG.get() || this.zza.zzH.getAndIncrement() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziP)).intValue()) {
            return;
        }
        this.zza.zzT();
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        com.google.android.gms.ads.internal.util.client.zzm.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziO)).booleanValue()) {
            zzq.zzd(this.zza.zzp, null, "sgs", new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", a.f13688g), new Pair("sgi_rn", Integer.toString(this.zza.zzH.get())));
            this.zza.zzG.set(true);
        }
    }
}
