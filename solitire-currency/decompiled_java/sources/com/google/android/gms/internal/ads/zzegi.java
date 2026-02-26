package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzegi implements zzeet {
    private final Context zza;
    private final zzdgp zzb;
    private final Executor zzc;
    private final zzfek zzd;

    public zzegi(Context context, Executor executor, zzdgp zzdgpVar, zzfek zzfekVar) {
        this.zza = context;
        this.zzb = zzdgpVar;
        this.zzc = executor;
        this.zzd = zzfekVar;
    }

    @Nullable
    private static String zzd(zzfel zzfelVar) {
        try {
            return zzfelVar.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final m zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        String strZzd = zzd(zzfelVar);
        final Uri uri = strZzd != null ? Uri.parse(strZzd) : null;
        return zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzegg
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc(uri, zzfexVar, zzfelVar, obj);
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbct.zzg(context) && !TextUtils.isEmpty(zzd(zzfelVar));
    }

    final /* synthetic */ m zzc(Uri uri, zzfex zzfexVar, zzfel zzfelVar, Object obj) throws Exception {
        try {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            customTabsIntentBuild.intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(customTabsIntentBuild.intent, null);
            final zzbzt zzbztVar = new zzbzt();
            zzdfp zzdfpVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, null), new zzdfs(new zzdgx() { // from class: com.google.android.gms.internal.ads.zzegh
                @Override // com.google.android.gms.internal.ads.zzdgx
                public final void zza(boolean z10, Context context, zzcxd zzcxdVar) {
                    zzbzt zzbztVar2 = zzbztVar;
                    try {
                        com.google.android.gms.ads.internal.zzu.zzi();
                        com.google.android.gms.ads.internal.overlay.zzn.zza(context, (AdOverlayInfoParcel) zzbztVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }, null));
            zzbztVar.zzc(new AdOverlayInfoParcel(zzcVar, null, zzdfpVarZze.zza(), null, new VersionInfoParcel(0, 0, false), null, null));
            this.zzd.zza();
            return zzgcj.zzh(zzdfpVarZze.zzg());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
