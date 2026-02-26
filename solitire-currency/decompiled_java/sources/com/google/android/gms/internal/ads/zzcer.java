package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.games.GamesActivityResultCodes;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting(otherwise = 3)
public class zzcer extends WebViewClient implements zzcgb {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private int zzB;
    private boolean zzC;

    @Nullable
    private final zzeds zzE;
    private View.OnAttachStateChangeListener zzF;

    @Nullable
    protected zzbxl zza;
    private final zzcej zzc;

    @Nullable
    private final zzbav zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzp zzh;
    private zzcfz zzi;
    private zzcga zzj;
    private zzbhn zzk;
    private zzbhp zzl;
    private zzdeq zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private com.google.android.gms.ads.internal.overlay.zzaa zzv;

    @Nullable
    private zzbrp zzw;
    private com.google.android.gms.ads.internal.zzb zzx;
    private boolean zzz;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbrk zzy = null;
    private final HashSet zzD = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfb)).split(",")));

    @VisibleForTesting
    public zzcer(zzcej zzcejVar, @Nullable zzbav zzbavVar, boolean z10, zzbrp zzbrpVar, @Nullable zzbrk zzbrkVar, @Nullable zzeds zzedsVar) {
        this.zzd = zzbavVar;
        this.zzc = zzcejVar;
        this.zzs = z10;
        this.zzw = zzbrpVar;
        this.zzE = zzedsVar;
    }

    @Nullable
    private static WebResourceResponse zzS() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaB)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ef, code lost:
    
        com.google.android.gms.ads.internal.zzu.zzp();
        com.google.android.gms.ads.internal.zzu.zzp();
        r14 = r3.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fd, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0101, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0103, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0105, code lost:
    
        r6 = r14.split(";")[0].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0110, code lost:
    
        com.google.android.gms.ads.internal.zzu.zzp();
        r14 = r3.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011b, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011d, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x011f, code lost:
    
        r14 = r14.split(";");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0124, code lost:
    
        if (r14.length != 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0127, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0129, code lost:
    
        if (r0 >= r14.length) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0137, code lost:
    
        if (r14[r0].trim().startsWith(com.ironsource.nb.M) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0139, code lost:
    
        r1 = r14[r0].trim().split(com.ironsource.v8.i.f15833b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0146, code lost:
    
        if (r1.length <= 1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0148, code lost:
    
        r4 = r1[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x014f, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0152, code lost:
    
        r14 = r3.getHeaderFields();
        r10 = new java.util.HashMap(r14.size());
        r14 = r14.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x016b, code lost:
    
        if (r14.hasNext() == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016d, code lost:
    
        r0 = r14.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0177, code lost:
    
        if (r0.getKey() == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x017d, code lost:
    
        if (r0.getValue() == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0189, code lost:
    
        if (r0.getValue().isEmpty() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018b, code lost:
    
        r10.put(r0.getKey(), r0.getValue().get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a1, code lost:
    
        r5 = com.google.android.gms.ads.internal.zzu.zzq().zzb(r6, r7, r3.getResponseCode(), r3.getResponseMessage(), r10, r3.getInputStream());
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse zzT(java.lang.String r13, java.util.Map r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcer.zzT(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                com.google.android.gms.ads.internal.util.zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbix) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzV() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzF;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzW(final View view, final zzbxl zzbxlVar, final int i10) {
        if (!zzbxlVar.zzi() || i10 <= 0) {
            return;
        }
        zzbxlVar.zzg(view);
        if (zzbxlVar.zzi()) {
            com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcek
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(view, zzbxlVar, i10);
                }
            }, 100L);
        }
    }

    private static final boolean zzX(zzcej zzcejVar) {
        if (zzcejVar.zzD() != null) {
            return zzcejVar.zzD().zzai;
        }
        return false;
    }

    private static final boolean zzY(boolean z10, zzcej zzcejVar) {
        return (!z10 || zzcejVar.zzO().zzi() || zzcejVar.zzU().equals("interstitial_mb")) ? false : true;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzj(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            if (this.zzc.zzaE()) {
                com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                this.zzc.zzX();
                return;
            }
            this.zzz = true;
            zzcga zzcgaVar = this.zzj;
            if (zzcgaVar != null) {
                zzcgaVar.zza();
                this.zzj = null;
            }
            zzg();
            if (this.zzc.zzL() != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkV)).booleanValue()) {
                    this.zzc.zzL().zzG(str);
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i10, String str, String str2) {
        this.zzo = true;
        this.zzp = i10;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaD(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZza = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzj(uriZza);
        } else {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = uriZza.getScheme();
                if (ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzbxl zzbxlVar = this.zza;
                        if (zzbxlVar != null) {
                            zzbxlVar.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdeq zzdeqVar = this.zzm;
                    if (zzdeqVar != null) {
                        zzdeqVar.zzdG();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.zzc.zzG().willNotDraw()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzauo zzauoVarZzI = this.zzc.zzI();
                    zzffk zzffkVarZzS = this.zzc.zzS();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzla)).booleanValue() || zzffkVarZzS == null) {
                        if (zzauoVarZzI != null && zzauoVarZzI.zzf(uriZza)) {
                            Context context = this.zzc.getContext();
                            zzcej zzcejVar = this.zzc;
                            uriZza = zzauoVarZzI.zza(uriZza, context, (View) zzcejVar, zzcejVar.zzi());
                        }
                    } else if (zzauoVarZzI != null && zzauoVarZzI.zzf(uriZza)) {
                        Context context2 = this.zzc.getContext();
                        zzcej zzcejVar2 = this.zzc;
                        uriZza = zzffkVarZzS.zza(uriZza, context2, (View) zzcejVar2, zzcejVar2.zzi());
                    }
                } catch (zzaup unused) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzx;
                if (zzbVar == null || zzbVar.zzc()) {
                    zzu(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null, null), true, false);
                } else {
                    this.zzx.zzb(str);
                }
            }
        }
        return true;
    }

    public final void zzA(String str, zzbix zzbixVar) {
        synchronized (this.zzf) {
            List copyOnWriteArrayList = (List) this.zze.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.zze.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzbixVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzB(zzcfz zzcfzVar) {
        this.zzi = zzcfzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzC(int i10, int i11) {
        zzbrk zzbrkVar = this.zzy;
        if (zzbrkVar != null) {
            zzbrkVar.zze(i10, i11);
        }
    }

    public final void zzD(boolean z10) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzE(boolean z10) {
        synchronized (this.zzf) {
            this.zzu = z10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzF() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcel
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzG(boolean z10) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzH(zzcga zzcgaVar) {
        this.zzj = zzcgaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzI(zzcni zzcniVar, @Nullable zzedh zzedhVar, @Nullable zzfll zzfllVar) {
        zzL("/click");
        if (zzedhVar == null || zzfllVar == null) {
            zzA("/click", new zzbhv(this.zzm, zzcniVar));
        } else {
            zzA("/click", new zzffo(this.zzm, zzcniVar, zzfllVar, zzedhVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzJ(zzcni zzcniVar) {
        zzL("/click");
        zzA("/click", new zzbhv(this.zzm, zzcniVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzK(zzcni zzcniVar, @Nullable zzedh zzedhVar, @Nullable zzdsk zzdskVar) {
        zzL("/open");
        zzA("/open", new zzbjj(this.zzx, this.zzy, zzedhVar, zzdskVar, zzcniVar));
    }

    public final void zzL(String str) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.clear();
        }
    }

    public final void zzM(String str, zzbix zzbixVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzbixVar);
        }
    }

    public final void zzN(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbix> list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzbix zzbixVar : list) {
                if (predicate.apply(zzbixVar)) {
                    arrayList.add(zzbixVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final boolean zzO() {
        boolean z10;
        synchronized (this.zzf) {
            z10 = this.zzu;
        }
        return z10;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final boolean zzP() {
        boolean z10;
        synchronized (this.zzf) {
            z10 = this.zzs;
        }
        return z10;
    }

    public final boolean zzQ() {
        boolean z10;
        synchronized (this.zzf) {
            z10 = this.zzt;
        }
        return z10;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzR(@Nullable com.google.android.gms.ads.internal.client.zza zzaVar, @Nullable zzbhn zzbhnVar, @Nullable com.google.android.gms.ads.internal.overlay.zzp zzpVar, @Nullable zzbhp zzbhpVar, @Nullable com.google.android.gms.ads.internal.overlay.zzaa zzaaVar, boolean z10, @Nullable zzbja zzbjaVar, @Nullable com.google.android.gms.ads.internal.zzb zzbVar, @Nullable zzbrr zzbrrVar, @Nullable zzbxl zzbxlVar, @Nullable final zzedh zzedhVar, @Nullable final zzfll zzfllVar, @Nullable zzdsk zzdskVar, @Nullable zzbjr zzbjrVar, @Nullable zzdeq zzdeqVar, @Nullable zzbjq zzbjqVar, @Nullable zzbjk zzbjkVar, @Nullable zzbiy zzbiyVar, @Nullable zzcni zzcniVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zzc.getContext(), zzbxlVar, null) : zzbVar;
        this.zzy = new zzbrk(this.zzc, zzbrrVar);
        this.zza = zzbxlVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaI)).booleanValue()) {
            zzA("/adMetadata", new zzbhm(zzbhnVar));
        }
        if (zzbhpVar != null) {
            zzA("/appEvent", new zzbho(zzbhpVar));
        }
        zzA("/backButton", zzbiw.zzj);
        zzA("/refresh", zzbiw.zzk);
        zzA("/canOpenApp", zzbiw.zzb);
        zzA("/canOpenURLs", zzbiw.zza);
        zzA("/canOpenIntents", zzbiw.zzc);
        zzA("/close", zzbiw.zzd);
        zzA("/customClose", zzbiw.zze);
        zzA("/instrument", zzbiw.zzn);
        zzA("/delayPageLoaded", zzbiw.zzp);
        zzA("/delayPageClosed", zzbiw.zzq);
        zzA("/getLocationInfo", zzbiw.zzr);
        zzA("/log", zzbiw.zzg);
        zzA("/mraid", new zzbje(zzbVar2, this.zzy, zzbrrVar));
        zzbrp zzbrpVar = this.zzw;
        if (zzbrpVar != null) {
            zzA("/mraidLoaded", zzbrpVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzA("/open", new zzbjj(zzbVar2, this.zzy, zzedhVar, zzdskVar, zzcniVar));
        zzA("/precache", new zzccw());
        zzA("/touch", zzbiw.zzi);
        zzA("/video", zzbiw.zzl);
        zzA("/videoMeta", zzbiw.zzm);
        if (zzedhVar == null || zzfllVar == null) {
            zzA("/click", new zzbhv(zzdeqVar, zzcniVar));
            zzA("/httpTrack", zzbiw.zzf);
        } else {
            zzA("/click", new zzffo(zzdeqVar, zzcniVar, zzfllVar, zzedhVar));
            zzA("/httpTrack", new zzbix() { // from class: com.google.android.gms.internal.ads.zzffp
                @Override // com.google.android.gms.internal.ads.zzbix
                public final void zza(Object obj, Map map) {
                    zzcea zzceaVar = (zzcea) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzj("URL missing from httpTrack GMSG.");
                    } else if (zzceaVar.zzD().zzai) {
                        zzedhVar.zzd(new zzedj(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis(), ((zzcfm) zzceaVar).zzR().zzb, str, 2));
                    } else {
                        zzfllVar.zzc(str, null);
                    }
                }
            });
        }
        if (com.google.android.gms.ads.internal.zzu.zzn().zzp(this.zzc.getContext())) {
            Map map = new HashMap();
            if (this.zzc.zzD() != null) {
                map = this.zzc.zzD().zzaw;
            }
            zzA("/logScionEvent", new zzbjd(this.zzc.getContext(), map));
        }
        if (zzbjaVar != null) {
            zzA("/setInterstitialProperties", new zzbiz(zzbjaVar));
        }
        if (zzbjrVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue()) {
                zzA("/inspectorNetworkExtras", zzbjrVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzit)).booleanValue() && zzbjqVar != null) {
            zzA("/shareSheet", zzbjqVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziy)).booleanValue() && zzbjkVar != null) {
            zzA("/inspectorOutOfContextTest", zzbjkVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziC)).booleanValue() && zzbiyVar != null) {
            zzA("/inspectorStorage", zzbiyVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkD)).booleanValue()) {
            zzA("/bindPlayStoreOverlay", zzbiw.zzu);
            zzA("/presentPlayStoreOverlay", zzbiw.zzv);
            zzA("/expandPlayStoreOverlay", zzbiw.zzw);
            zzA("/collapsePlayStoreOverlay", zzbiw.zzx);
            zzA("/closePlayStoreOverlay", zzbiw.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcT)).booleanValue()) {
            zzA("/setPAIDPersonalizationEnabled", zzbiw.zzA);
            zzA("/resetPAID", zzbiw.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkU)).booleanValue()) {
            zzcej zzcejVar = this.zzc;
            if (zzcejVar.zzD() != null && zzcejVar.zzD().zzar) {
                zzA("/writeToLocalStorage", zzbiw.zzB);
                zzA("/clearLocalStorageKeys", zzbiw.zzC);
            }
        }
        this.zzg = zzaVar;
        this.zzh = zzpVar;
        this.zzk = zzbhnVar;
        this.zzl = zzbhpVar;
        this.zzv = zzaaVar;
        this.zzx = zzbVar3;
        this.zzm = zzdeqVar;
        this.zzn = z10;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e7 A[Catch: all -> 0x01ce, TryCatch #5 {all -> 0x01ce, blocks: (B:58:0x0180, B:60:0x0192, B:61:0x0199, B:71:0x01d5, B:73:0x01e7, B:74:0x01ee), top: B:106:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0295 A[Catch: Exception | NoClassDefFoundError -> 0x02bf, Exception -> 0x02c1, TryCatch #14 {Exception | NoClassDefFoundError -> 0x02bf, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x0021, B:8:0x0033, B:10:0x003a, B:12:0x0046, B:14:0x0062, B:16:0x007b, B:18:0x0092, B:19:0x0095, B:21:0x0098, B:24:0x00b2, B:26:0x00ca, B:28:0x00e3, B:62:0x01a4, B:63:0x01ca, B:89:0x0295, B:77:0x021c, B:78:0x0245, B:75:0x01f2, B:42:0x0143, B:27:0x00d7, B:79:0x0246, B:81:0x0250, B:83:0x0256, B:85:0x0289, B:91:0x02a4, B:93:0x02aa, B:95:0x02b8), top: B:107:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02aa A[Catch: Exception | NoClassDefFoundError -> 0x02bf, Exception -> 0x02c1, TryCatch #14 {Exception | NoClassDefFoundError -> 0x02bf, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x0021, B:8:0x0033, B:10:0x003a, B:12:0x0046, B:14:0x0062, B:16:0x007b, B:18:0x0092, B:19:0x0095, B:21:0x0098, B:24:0x00b2, B:26:0x00ca, B:28:0x00e3, B:62:0x01a4, B:63:0x01ca, B:89:0x0295, B:77:0x021c, B:78:0x0245, B:75:0x01f2, B:42:0x0143, B:27:0x00d7, B:79:0x0246, B:81:0x0250, B:83:0x0256, B:85:0x0289, B:91:0x02a4, B:93:0x02aa, B:95:0x02b8), top: B:107:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02bd A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v5 */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final android.webkit.WebResourceResponse zzc(java.lang.String r19, java.util.Map r20) {
        /*
            Method dump skipped, instruction units count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcer.zzc(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final com.google.android.gms.ads.internal.zzb zzd() {
        return this.zzx;
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        zzdeq zzdeqVar = this.zzm;
        if (zzdeqVar != null) {
            zzdeqVar.zzdG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
        zzdeq zzdeqVar = this.zzm;
        if (zzdeqVar != null) {
            zzdeqVar.zzdf();
        }
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzz && this.zzB <= 0) || this.zzA || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue() && this.zzc.zzm() != null) {
                zzbcd.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzcfz zzcfzVar = this.zzi;
            boolean z10 = false;
            if (!this.zzA && !this.zzo) {
                z10 = true;
            }
            zzcfzVar.zza(z10, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzaf();
    }

    public final void zzh() {
        zzbxl zzbxlVar = this.zza;
        if (zzbxlVar != null) {
            zzbxlVar.zze();
            this.zza = null;
        }
        zzV();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzv = null;
            this.zzx = null;
            this.zzw = null;
            zzbrk zzbrkVar = this.zzy;
            if (zzbrkVar != null) {
                zzbrkVar.zza(true);
                this.zzy = null;
            }
        }
    }

    public final void zzi(boolean z10) {
        this.zzC = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzj(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(uri)));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgb)).booleanValue() || com.google.android.gms.ads.internal.zzu.zzo().zzg() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcem
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    int i10 = zzcer.zzb;
                    com.google.android.gms.ads.internal.zzu.zzo().zzg().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfa)).booleanValue() && this.zzD.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfc)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgcj.zzr(com.google.android.gms.ads.internal.zzu.zzp().zzb(uri), new zzcep(this, list, path, uri), zzbzo.zze);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzu.zzp();
        zzU(com.google.android.gms.ads.internal.util.zzt.zzP(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzk() {
        zzbav zzbavVar = this.zzd;
        if (zzbavVar != null) {
            zzbavVar.zzc(10005);
        }
        this.zzA = true;
        this.zzp = GamesActivityResultCodes.RESULT_APP_MISCONFIGURED;
        this.zzq = "Page loaded delay cancel.";
        zzg();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzB++;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzm() {
        this.zzB--;
        zzg();
    }

    final /* synthetic */ void zzn() {
        this.zzc.zzad();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zzc.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzz();
        }
    }

    final /* synthetic */ void zzo(boolean z10, long j10) {
        this.zzc.zzv(z10, j10);
    }

    final /* synthetic */ void zzp(View view, zzbxl zzbxlVar, int i10) {
        zzW(view, zzbxlVar, i10 - 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzq(int i10, int i11, boolean z10) {
        zzbrp zzbrpVar = this.zzw;
        if (zzbrpVar != null) {
            zzbrpVar.zzb(i10, i11);
        }
        zzbrk zzbrkVar = this.zzy;
        if (zzbrkVar != null) {
            zzbrkVar.zzd(i10, i11, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzr() {
        zzbxl zzbxlVar = this.zza;
        if (zzbxlVar != null) {
            WebView webViewZzG = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(webViewZzG)) {
                zzW(webViewZzG, zzbxlVar, 10);
                return;
            }
            zzV();
            zzceo zzceoVar = new zzceo(this, zzbxlVar);
            this.zzF = zzceoVar;
            ((View) this.zzc).addOnAttachStateChangeListener(zzceoVar);
        }
    }

    public final void zzu(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z10, boolean z11) {
        zzcej zzcejVar = this.zzc;
        boolean zZzaF = zzcejVar.zzaF();
        boolean z12 = zzY(zZzaF, zzcejVar) || z11;
        boolean z13 = z12 || !z10;
        com.google.android.gms.ads.internal.client.zza zzaVar = z12 ? null : this.zzg;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = zZzaF ? null : this.zzh;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcVar, zzaVar, zzpVar, zzaaVar, zzcejVar2.zzn(), zzcejVar2, z13 ? null : this.zzm));
    }

    public final void zzv(String str, String str2, int i10) {
        zzeds zzedsVar = this.zzE;
        zzcej zzcejVar = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcejVar, zzcejVar.zzn(), str, str2, 14, zzedsVar));
    }

    public final void zzw(boolean z10, int i10, boolean z11) {
        zzcej zzcejVar = this.zzc;
        boolean zZzY = zzY(zzcejVar.zzaF(), zzcejVar);
        boolean z12 = true;
        if (!zZzY && z11) {
            z12 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzY ? null : this.zzg;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzh;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzpVar, zzaaVar, zzcejVar2, z10, i10, zzcejVar2.zzn(), z12 ? null : this.zzm, zzX(this.zzc) ? this.zzE : null));
    }

    public final void zzx(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbrk zzbrkVar = this.zzy;
        boolean zZzf = zzbrkVar != null ? zzbrkVar.zzf() : false;
        com.google.android.gms.ads.internal.zzu.zzi();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zZzf);
        zzbxl zzbxlVar = this.zza;
        if (zzbxlVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzbxlVar.zzh(str);
        }
    }

    public final void zzy(boolean z10, int i10, String str, String str2, boolean z11) {
        zzcej zzcejVar = this.zzc;
        boolean zZzaF = zzcejVar.zzaF();
        boolean zZzY = zzY(zZzaF, zzcejVar);
        boolean z12 = true;
        if (!zZzY && z11) {
            z12 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzY ? null : this.zzg;
        zzceq zzceqVar = zZzaF ? null : new zzceq(this.zzc, this.zzh);
        zzbhn zzbhnVar = this.zzk;
        zzbhp zzbhpVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzceqVar, zzbhnVar, zzbhpVar, zzaaVar, zzcejVar2, z10, i10, str, str2, zzcejVar2.zzn(), z12 ? null : this.zzm, zzX(this.zzc) ? this.zzE : null));
    }

    public final void zzz(boolean z10, int i10, String str, boolean z11, boolean z12) {
        zzcej zzcejVar = this.zzc;
        boolean zZzaF = zzcejVar.zzaF();
        boolean zZzY = zzY(zZzaF, zzcejVar);
        boolean z13 = true;
        if (!zZzY && z11) {
            z13 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzY ? null : this.zzg;
        zzceq zzceqVar = zZzaF ? null : new zzceq(this.zzc, this.zzh);
        zzbhn zzbhnVar = this.zzk;
        zzbhp zzbhpVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzceqVar, zzbhnVar, zzbhpVar, zzaaVar, zzcejVar2, z10, i10, str, zzcejVar2.zzn(), z13 ? null : this.zzm, zzX(this.zzc) ? this.zzE : null, z12));
    }
}
