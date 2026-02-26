package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdx;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzbtl;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzdoa;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzfgf;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzful;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzgbp;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgca;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzak extends zzbyl {
    protected static final List zza = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List zzb = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List zzc = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List zzd = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public static final /* synthetic */ int zze = 0;
    private final List zzB;
    private final List zzC;
    private final List zzD;
    private final List zzE;
    private final zzbcx zzI;
    private final zze zzJ;
    private final zzcgj zzf;
    private Context zzg;
    private final zzauo zzh;
    private final zzffk zzi;
    private final zzfgf zzj;
    private final zzgcu zzk;
    private final ScheduledExecutorService zzl;

    @Nullable
    private zzbtl zzm;
    private final zzdsp zzp;
    private final zzfll zzq;
    private final VersionInfoParcel zzy;
    private String zzz;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final AtomicInteger zzx = new AtomicInteger(0);
    private final AtomicBoolean zzF = new AtomicBoolean(false);
    private final AtomicBoolean zzG = new AtomicBoolean(false);
    private final AtomicInteger zzH = new AtomicInteger(0);
    private final boolean zzr = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgx)).booleanValue();
    private final boolean zzs = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgw)).booleanValue();
    private final boolean zzt = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgz)).booleanValue();
    private final boolean zzu = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgB)).booleanValue();
    private final String zzv = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgA);
    private final String zzw = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgC);
    private final String zzA = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgD);

    public zzak(zzcgj zzcgjVar, Context context, zzauo zzauoVar, zzfgf zzfgfVar, zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzdsp zzdspVar, zzfll zzfllVar, VersionInfoParcel versionInfoParcel, zzbcx zzbcxVar, zzffk zzffkVar, zze zzeVar) {
        List listZzaa;
        this.zzf = zzcgjVar;
        this.zzg = context;
        this.zzh = zzauoVar;
        this.zzi = zzffkVar;
        this.zzj = zzfgfVar;
        this.zzk = zzgcuVar;
        this.zzl = scheduledExecutorService;
        this.zzp = zzdspVar;
        this.zzq = zzfllVar;
        this.zzy = versionInfoParcel;
        this.zzI = zzbcxVar;
        this.zzJ = zzeVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgE)).booleanValue()) {
            this.zzB = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgF));
            this.zzC = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgG));
            this.zzD = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgH));
            listZzaa = zzaa((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgI));
        } else {
            this.zzB = zza;
            this.zzC = zzb;
            this.zzD = zzc;
            listZzaa = zzd;
        }
        this.zzE = listZzaa;
    }

    static /* bridge */ /* synthetic */ void zzH(zzak zzakVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzakVar.zzO((Uri) it.next())) {
                zzakVar.zzx.getAndIncrement();
                return;
            }
        }
    }

    static final /* synthetic */ Uri zzQ(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzZ(uri, "nas", str) : uri;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzs zzR(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.google.android.gms.ads.internal.client.zzq r11, com.google.android.gms.ads.internal.client.zzl r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzak.zzR(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.ads.internal.client.zzl, android.os.Bundle):com.google.android.gms.ads.nonagon.signalgeneration.zzs");
    }

    private final m zzS(final String str) {
        final zzdoa[] zzdoaVarArr = new zzdoa[1];
        m mVarZzn = zzgcj.zzn(this.zzj.zza(), new zzgbq() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzv(zzdoaVarArr, str, (zzdoa) obj);
            }
        }, this.zzk);
        mVarZzn.addListener(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzJ(zzdoaVarArr);
            }
        }, this.zzk);
        return zzgcj.zze(zzgcj.zzm((zzgca) zzgcj.zzo(zzgca.zzu(mVarZzn), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgP)).intValue(), TimeUnit.MILLISECONDS, this.zzl), new zzful() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzac
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                int i10 = zzak.zze;
                return ((JSONObject) obj).optString("nas");
            }
        }, this.zzk), Exception.class, new zzful() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzad
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                int i10 = zzak.zze;
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", (Exception) obj);
                return null;
            }
        }, this.zzk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzT() {
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            this.zzJ.zzb();
        } else {
            zzgcj.zzr(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkg)).booleanValue() ? zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzt
                @Override // com.google.android.gms.internal.ads.zzgbp
                public final m zza() {
                    return this.zza.zzu();
                }
            }, zzbzo.zza) : zzR(this.zzg, null, AdFormat.BANNER.name(), null, null, new Bundle()).zzb(), new zzaj(this), this.zzf.zzB());
        }
    }

    private final void zzU() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziH)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziK)).booleanValue()) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziO)).booleanValue() && this.zzF.getAndSet(true)) {
                return;
            }
            zzT();
        }
    }

    private final void zzV(List list, final IObjectWrapper iObjectWrapper, zzbtc zzbtcVar, boolean z10) {
        m mVarZzb;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("The updating URL feature is not enabled.");
            try {
                zzbtcVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                return;
            }
        }
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (zzO((Uri) it.next())) {
                i10++;
            }
        }
        if (i10 > 1) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Multiple google urls found: ".concat(String.valueOf(list)));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (zzO(uri)) {
                mVarZzb = this.zzk.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzx
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzn(uri, iObjectWrapper);
                    }
                });
                if (zzY()) {
                    mVarZzb = zzgcj.zzn(mVarZzb, new zzgbq() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzy
                        @Override // com.google.android.gms.internal.ads.zzgbq
                        public final m zza(Object obj) {
                            zzak zzakVar = this.zza;
                            return zzgcj.zzm(zzakVar.zzS("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzful(zzakVar, (Uri) obj) { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzz
                                public final /* synthetic */ Uri zza;

                                {
                                    this.zza = uri;
                                }

                                @Override // com.google.android.gms.internal.ads.zzful
                                public final Object apply(Object obj2) {
                                    return zzak.zzQ(this.zza, (String) obj2);
                                }
                            }, zzakVar.zzk);
                        }
                    }, this.zzk);
                } else {
                    com.google.android.gms.ads.internal.util.client.zzm.zzi("Asset view map is empty.");
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                mVarZzb = zzgcj.zzh(uri);
            }
            arrayList.add(mVarZzb);
        }
        zzgcj.zzr(zzgcj.zzd(arrayList), new zzai(this, zzbtcVar, z10), this.zzf.zzB());
    }

    private final void zzW(final List list, final IObjectWrapper iObjectWrapper, zzbtc zzbtcVar, boolean z10) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            try {
                zzbtcVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                return;
            }
        }
        m mVarZzb = this.zzk.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzae
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzC(list, iObjectWrapper);
            }
        });
        if (zzY()) {
            mVarZzb = zzgcj.zzn(mVarZzb, new zzgbq() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaf
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    return this.zza.zzw((ArrayList) obj);
                }
            }, this.zzk);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzi("Asset view map is empty.");
        }
        zzgcj.zzr(mVarZzb, new zzah(this, zzbtcVar, z10), this.zzf.zzB());
    }

    private static boolean zzX(@NonNull Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean zzY() {
        Map map;
        zzbtl zzbtlVar = this.zzm;
        return (zzbtlVar == null || (map = zzbtlVar.zzb) == null || map.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri zzZ(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i10 = iIndexOf + 1;
        return Uri.parse(string.substring(0, i10) + str + v8.i.f15833b + str2 + v8.i.f15835c + string.substring(i10));
    }

    private static final List zzaa(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzfvj.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzfkf zzr(m mVar, zzbyq zzbyqVar) {
        if (!zzfki.zza() || !((Boolean) zzbdl.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfkf zzfkfVarZza = ((zzs) zzgcj.zzp(mVar)).zza();
            zzfkfVarZza.zzd(new ArrayList(Collections.singletonList(zzbyqVar.zzb)));
            com.google.android.gms.ads.internal.client.zzl zzlVar = zzbyqVar.zzd;
            zzfkfVarZza.zzb(zzlVar == null ? "" : zzlVar.zzp);
            zzfkfVarZza.zzf(zzbyqVar.zzd.zzm);
            return zzfkfVarZza;
        } catch (ExecutionException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzP(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzZ(uri, "nas", str));
            }
        }
        return arrayList;
    }

    final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String strZzh = this.zzh.zzc() != null ? this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : "";
        if (TextUtils.isEmpty(strZzh)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzP(uri)) {
                arrayList.add(zzZ(uri, "ms", strZzh));
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                arrayList.add(uri);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }

    final /* synthetic */ void zzJ(zzdoa[] zzdoaVarArr) {
        zzdoa zzdoaVar = zzdoaVarArr[0];
        if (zzdoaVar != null) {
            this.zzj.zzb(zzgcj.zzh(zzdoaVar));
        }
    }

    @VisibleForTesting
    final boolean zzO(@NonNull Uri uri) {
        return zzX(uri, this.zzB, this.zzC);
    }

    @VisibleForTesting
    final boolean zzP(@NonNull Uri uri) {
        return zzX(uri, this.zzD, this.zzE);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziR)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        this.zzI.zzg((Context) ObjectWrapper.unwrap(iObjectWrapper), (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2), str, (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3));
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            this.zzJ.zzb();
        }
        return ObjectWrapper.wrap(this.zzI.zzb());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    @Override // com.google.android.gms.internal.ads.zzbym
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(com.google.android.gms.dynamic.IObjectWrapper r10, final com.google.android.gms.internal.ads.zzbyq r11, com.google.android.gms.internal.ads.zzbyj r12) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzak.zzf(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzbyq, com.google.android.gms.internal.ads.zzbyj):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzg(zzbtl zzbtlVar) {
        this.zzm = zzbtlVar;
        this.zzj.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) {
        zzV(list, iObjectWrapper, zzbtcVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) {
        zzW(list, iObjectWrapper, zzbtcVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    @SuppressLint({"AddJavascriptInterface"})
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziG)).booleanValue()) {
            zzbbn zzbbnVar = zzbbw.zzgM;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                zzU();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("The webView cannot be null.");
                return;
            }
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzp, this.zzq, this.zzi, this.zzJ), "gmaSdk");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziQ)).booleanValue()) {
                com.google.android.gms.ads.internal.zzu.zzo().zzs();
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                zzU();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzk(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbtl zzbtlVar = this.zzm;
            this.zzn = zzbv.zza(motionEvent, zzbtlVar == null ? null : zzbtlVar.zza);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzn;
            motionEventObtain.setLocation(point.x, point.y);
            this.zzh.zzd(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) {
        zzV(list, iObjectWrapper, zzbtcVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) {
        zzW(list, iObjectWrapper, zzbtcVar, false);
    }

    final /* synthetic */ Uri zzn(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzffk zzffkVar;
        try {
            uri = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzla)).booleanValue() || (zzffkVar = this.zzi) == null) ? this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : zzffkVar.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzaup e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e10);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    final /* synthetic */ zzs zzq(zzbyq zzbyqVar, Bundle bundle) throws Exception {
        return zzR(this.zzg, zzbyqVar.zza, zzbyqVar.zzb, zzbyqVar.zzc, zzbyqVar.zzd, bundle);
    }

    final /* synthetic */ m zzu() throws Exception {
        return zzR(this.zzg, null, AdFormat.BANNER.name(), null, null, new Bundle()).zzb();
    }

    final /* synthetic */ m zzv(zzdoa[] zzdoaVarArr, String str, zzdoa zzdoaVar) throws Exception {
        zzdoaVarArr[0] = zzdoaVar;
        Context context = this.zzg;
        zzbtl zzbtlVar = this.zzm;
        Map map = zzbtlVar.zzb;
        JSONObject jSONObjectZzd = zzbv.zzd(context, map, map, zzbtlVar.zza, null);
        JSONObject jSONObjectZzg = zzbv.zzg(this.zzg, this.zzm.zza);
        JSONObject jSONObjectZzf = zzbv.zzf(this.zzm.zza);
        JSONObject jSONObjectZze = zzbv.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", jSONObjectZzd);
        jSONObject.put("ad_view_signal", jSONObjectZzg);
        jSONObject.put("scroll_view_signal", jSONObjectZzf);
        jSONObject.put("lock_screen_signal", jSONObjectZze);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbv.zzc(null, this.zzg, this.zzo, this.zzn));
        }
        return zzdoaVar.zzg(str, jSONObject);
    }

    final /* synthetic */ m zzw(final ArrayList arrayList) throws Exception {
        return zzgcj.zzm(zzS("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzful() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzu
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zzB(arrayList, (String) obj);
            }
        }, this.zzk);
    }
}
