package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbcs;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzhfv;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzo implements zzbcs {
    final /* synthetic */ zzbct zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzo(zzt zztVar, zzbct zzbctVar, Context context, Uri uri) {
        this.zza = zzbctVar;
        this.zzb = context;
        this.zzc = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zza() {
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder(this.zza.zza()).build();
        customTabsIntentBuild.intent.setPackage(zzhfv.zza(this.zzb));
        customTabsIntentBuild.launchUrl(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
