package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbym;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaw {
    private final zzk zza;
    private final zzi zzb;
    private final zzeq zzc;
    private final zzbhc zzd;
    private final zzbsk zze;
    private final zzbhd zzf;
    private zzbts zzg;

    public zzaw(zzk zzkVar, zzi zziVar, zzeq zzeqVar, zzbhc zzbhcVar, zzbws zzbwsVar, zzbsk zzbskVar, zzbhd zzbhdVar) {
        this.zza = zzkVar;
        this.zzb = zziVar;
        this.zzc = zzeqVar;
        this.zzd = zzbhcVar;
        this.zze = zzbskVar;
        this.zzf = zzbhdVar;
    }

    static /* bridge */ /* synthetic */ void zzt(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zzb().zzo(context, zzay.zzc().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbq zzc(Context context, String str, zzbom zzbomVar) {
        return (zzbq) new zzao(this, context, str, zzbomVar).zzd(context, false);
    }

    public final zzbu zzd(Context context, zzq zzqVar, String str, zzbom zzbomVar) {
        return (zzbu) new zzak(this, context, zzqVar, str, zzbomVar).zzd(context, false);
    }

    public final zzbu zze(Context context, zzq zzqVar, String str, zzbom zzbomVar) {
        return (zzbu) new zzam(this, context, zzqVar, str, zzbomVar).zzd(context, false);
    }

    @Nullable
    public final zzdj zzf(Context context, zzbom zzbomVar) {
        return (zzdj) new zzac(this, context, zzbomVar).zzd(context, false);
    }

    public final zzbfh zzh(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbfh) new zzas(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbfn zzi(View view, HashMap map, HashMap map2) {
        return (zzbfn) new zzau(this, view, map, map2).zzd(view.getContext(), false);
    }

    @RequiresApi(api = 21)
    public final zzbjz zzl(Context context, zzbom zzbomVar, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbjz) new zzai(this, context, zzbomVar, onH5AdsEventListener).zzd(context, false);
    }

    @Nullable
    public final zzbsg zzm(Context context, zzbom zzbomVar) {
        return (zzbsg) new zzag(this, context, zzbomVar).zzd(context, false);
    }

    @Nullable
    public final zzbsn zzo(Activity activity) {
        zzaa zzaaVar = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean booleanExtra = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("useClientJar flag not found in activity intent extras.");
        }
        return (zzbsn) zzaaVar.zzd(activity, booleanExtra);
    }

    public final zzbwg zzq(Context context, String str, zzbom zzbomVar) {
        return (zzbwg) new zzav(this, context, str, zzbomVar).zzd(context, false);
    }

    @Nullable
    public final zzbym zzr(Context context, zzbom zzbomVar) {
        return (zzbym) new zzae(this, context, zzbomVar).zzd(context, false);
    }
}
