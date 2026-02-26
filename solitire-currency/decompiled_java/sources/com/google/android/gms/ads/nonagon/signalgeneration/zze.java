package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsp;
import com.ironsource.mediationsdk.metadata.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Context zzc;
    private final zzdsp zzd;
    private final ExecutorService zze;

    zze(Context context, zzdsp zzdspVar, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = zzdspVar;
        this.zze = executorService;
    }

    private final void zzh(final boolean z10) {
        Map map = this.zzb;
        Boolean boolValueOf = Boolean.valueOf(z10);
        if (map.containsKey(boolValueOf)) {
            return;
        }
        this.zzb.put(boolValueOf, new ArrayList());
        this.zze.submit(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzc
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(z10);
            }
        });
    }

    private final void zzi(zzg zzgVar, Pair pair, boolean z10) {
        zzgVar.zzd();
        QueryInfo queryInfoZzb = zzgVar.zzb();
        if (queryInfoZzb != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(queryInfoZzb);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzgVar.zzc());
        }
        zzdsp zzdspVar = this.zzd;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair("ad_format", AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", a.f13688g);
        pairArr[4] = new Pair("lat_ms", Long.toString(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - ((Long) pair.second).longValue()));
        pairArr[5] = new Pair("sgpc_h", Boolean.toString(z10));
        pairArr[6] = new Pair("sgpc_rs", Boolean.toString(zzgVar.zzb() != null));
        zzq.zzd(zzdspVar, null, "sgpcr", pairArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzd(boolean z10, boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        bundle.putBoolean("accept_3p_cookie", z10);
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(z10);
        zzg zzgVar = (zzg) map.get(boolValueOf);
        int iZza = 0;
        if (z11 && zzgVar != null) {
            iZza = zzgVar.zza() + 1;
        }
        int i10 = iZza;
        zzg zzgVar2 = (zzg) this.zza.get(boolValueOf);
        final zzf zzfVar = new zzf(this, z10, i10, zzgVar2 == null ? null : Boolean.valueOf(zzgVar2.zzf()), this.zzd);
        final AdRequest adRequestBuild = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkg)).booleanValue()) {
            this.zze.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzd
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zza(adRequestBuild, zzfVar);
                }
            });
        } else {
            QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequestBuild, zzfVar);
        }
    }

    final /* synthetic */ Object zza(AdRequest adRequest, zzf zzfVar) throws Exception {
        QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequest, zzfVar);
        return Boolean.TRUE;
    }

    public final synchronized void zzb() {
        zzh(true);
        zzh(false);
    }

    final /* synthetic */ void zzc(boolean z10) {
        zzd(z10, false);
    }

    final /* synthetic */ void zze(Object obj, Pair pair) {
        boolean zAcceptThirdPartyCookies = false;
        if (obj instanceof WebView) {
            CookieManager cookieManagerZza = com.google.android.gms.ads.internal.zzu.zzq().zza(this.zzc);
            if (cookieManagerZza != null) {
                zAcceptThirdPartyCookies = cookieManagerZza.acceptThirdPartyCookies((WebView) obj);
            }
        }
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(zAcceptThirdPartyCookies);
        zzg zzgVar = (zzg) map.get(boolValueOf);
        if (zzgVar != null && !zzgVar.zze()) {
            zzi(zzgVar, pair, true);
            return;
        }
        List arrayList = (List) this.zzb.get(boolValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzb.put(boolValueOf, arrayList);
        }
        arrayList.add(pair);
    }

    final synchronized void zzf(final boolean z10, zzg zzgVar) {
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(z10);
        zzg zzgVar2 = (zzg) map.get(boolValueOf);
        if (zzgVar2 == null || zzgVar2.zze() || zzgVar2.zzb() == null || zzgVar.zzb() != null) {
            this.zza.put(boolValueOf, zzgVar);
        }
        int iIntValue = (zzgVar.zzb() != null ? (Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziY) : (Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziZ)).intValue();
        final boolean z11 = zzgVar.zzb() == null;
        zzbzo.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(z10, z11);
            }
        }, iIntValue, TimeUnit.SECONDS);
        List list = (List) this.zzb.get(boolValueOf);
        this.zzb.put(boolValueOf, new ArrayList());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzi(zzgVar, (Pair) it.next(), false);
            }
        }
    }

    public final synchronized void zzg(final Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        final Pair pair = new Pair(queryInfoGenerationCallback, Long.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis()));
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zza
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(obj, pair);
            }
        });
    }
}
