package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzfru;
import com.google.common.util.concurrent.m;
import com.ironsource.Cif;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
@VisibleForTesting
final class zzcfi extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcej {
    public static final /* synthetic */ int zza = 0;
    private final String zzA;
    private zzcfl zzB;
    private boolean zzC;
    private boolean zzD;
    private zzber zzE;
    private zzbep zzF;
    private zzazj zzG;
    private int zzH;
    private int zzI;
    private zzbci zzJ;
    private final zzbci zzK;
    private zzbci zzL;
    private final zzbcj zzM;
    private int zzN;
    private com.google.android.gms.ads.internal.overlay.zzm zzO;
    private boolean zzP;
    private final com.google.android.gms.ads.internal.util.zzck zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private Map zzV;
    private final WindowManager zzW;
    private final zzbav zzX;
    private boolean zzY;
    private final zzcgc zzb;
    private final zzauo zzc;
    private final zzffk zzd;
    private final zzbcz zze;
    private final VersionInfoParcel zzf;
    private com.google.android.gms.ads.internal.zzm zzg;
    private final com.google.android.gms.ads.internal.zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzfel zzk;
    private zzfeo zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcer zzo;
    private com.google.android.gms.ads.internal.overlay.zzm zzp;
    private zzeeo zzq;
    private zzeem zzr;
    private zzcgd zzs;
    private final String zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private Boolean zzy;
    private boolean zzz;

    @VisibleForTesting
    protected zzcfi(zzcgc zzcgcVar, zzcgd zzcgdVar, String str, boolean z10, boolean z11, zzauo zzauoVar, zzbcz zzbczVar, VersionInfoParcel versionInfoParcel, zzbcl zzbclVar, com.google.android.gms.ads.internal.zzm zzmVar, com.google.android.gms.ads.internal.zza zzaVar, zzbav zzbavVar, zzfel zzfelVar, zzfeo zzfeoVar, zzffk zzffkVar) {
        zzfeo zzfeoVar2;
        super(zzcgcVar);
        this.zzm = false;
        this.zzn = false;
        this.zzz = true;
        this.zzA = "";
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzU = -1;
        this.zzb = zzcgcVar;
        this.zzs = zzcgdVar;
        this.zzt = str;
        this.zzw = z10;
        this.zzc = zzauoVar;
        this.zzd = zzffkVar;
        this.zze = zzbczVar;
        this.zzf = versionInfoParcel;
        this.zzg = zzmVar;
        this.zzh = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzW = windowManager;
        com.google.android.gms.ads.internal.zzu.zzp();
        DisplayMetrics displayMetricsZzt = com.google.android.gms.ads.internal.util.zzt.zzt(windowManager);
        this.zzi = displayMetricsZzt;
        this.zzj = displayMetricsZzt.density;
        this.zzX = zzbavVar;
        this.zzk = zzfelVar;
        this.zzl = zzfeoVar;
        this.zzQ = new com.google.android.gms.ads.internal.util.zzck(zzcgcVar.zza(), this, this, null);
        this.zzY = false;
        setBackgroundColor(0);
        final WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to enable Javascript.", e10);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkJ)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzu.zzp().zzc(zzcgcVar, versionInfoParcel.afmaVersion));
        com.google.android.gms.ads.internal.zzu.zzp();
        final Context context = getContext();
        com.google.android.gms.ads.internal.util.zzcd.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfru zzfruVar = zzt.zza;
                String absolutePath = context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
                WebSettings webSettings = settings;
                webSettings.setDatabasePath(absolutePath);
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaC)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return Boolean.TRUE;
            }
        });
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzba();
        addJavascriptInterface(new zzcfp(this, new zzcfo(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbi();
        zzbcj zzbcjVar = new zzbcj(new zzbcl(true, "make_wv", this.zzt));
        this.zzM = zzbcjVar;
        zzbcjVar.zza().zzc(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue() && (zzfeoVar2 = this.zzl) != null && zzfeoVar2.zzb != null) {
            zzbcjVar.zza().zzd("gqi", this.zzl.zzb);
        }
        zzbcjVar.zza();
        zzbci zzbciVarZzf = zzbcl.zzf();
        this.zzK = zzbciVarZzf;
        zzbcjVar.zzb("native:view_create", zzbciVarZzf);
        this.zzL = null;
        this.zzJ = null;
        com.google.android.gms.ads.internal.util.zzcg.zza().zzb(zzcgcVar);
        com.google.android.gms.ads.internal.zzu.zzo().zzt();
    }

    private final synchronized void zzba() {
        zzfel zzfelVar = this.zzk;
        if (zzfelVar != null && zzfelVar.zzam) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Disabling hardware acceleration on an overlay.");
            zzbc();
            return;
        }
        if (!this.zzw && !this.zzs.zzi()) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Enabling hardware acceleration on an AdView.");
            zzbe();
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Enabling hardware acceleration on an overlay.");
        zzbe();
    }

    private final synchronized void zzbb() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        com.google.android.gms.ads.internal.zzu.zzo().zzr();
    }

    private final synchronized void zzbc() {
        if (!this.zzx) {
            setLayerType(1, null);
        }
        this.zzx = true;
    }

    private final void zzbd(boolean z10) {
        HashMap map = new HashMap();
        map.put(Cif.f12602k, true != z10 ? "0" : "1");
        zzd("onAdVisibilityChanged", map);
    }

    private final synchronized void zzbe() {
        if (this.zzx) {
            setLayerType(0, null);
        }
        this.zzx = false;
    }

    private final synchronized void zzbf(String str) {
        try {
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkq)).booleanValue();
            final String str2 = AndroidWebViewClient.BLANK_PAGE;
            if (zBooleanValue) {
                com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable(str2) { // from class: com.google.android.gms.internal.ads.zzcfd
                    public final /* synthetic */ String zzb = AndroidWebViewClient.BLANK_PAGE;

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzaW(this.zzb);
                    }
                });
            } else {
                super.loadUrl(AndroidWebViewClient.BLANK_PAGE);
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "AdWebViewImpl.loadUrlUnsafe");
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzbg() {
        zzbcd.zza(this.zzM.zza(), this.zzK, "aeh2");
    }

    private final synchronized void zzbh() {
        Map map = this.zzV;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzccv) it.next()).release();
            }
        }
        this.zzV = null;
    }

    private final void zzbi() {
        zzbcj zzbcjVar = this.zzM;
        if (zzbcjVar == null) {
            return;
        }
        zzbcl zzbclVarZza = zzbcjVar.zza();
        zzbcb zzbcbVarZzg = com.google.android.gms.ads.internal.zzu.zzo().zzg();
        if (zzbcbVarZzg != null) {
            zzbcbVarZzg.zzf(zzbclVarZza);
        }
    }

    private final synchronized void zzbj() {
        Boolean boolZzl = com.google.android.gms.ads.internal.zzu.zzo().zzl();
        this.zzy = boolZzl;
        if (boolZzl == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaY(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zzaY(Boolean.FALSE);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void destroy() {
        zzbi();
        this.zzQ.zza();
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzb();
            this.zzp.zzm();
            this.zzp = null;
        }
        this.zzq = null;
        this.zzr = null;
        this.zzo.zzh();
        this.zzG = null;
        this.zzg = null;
        setOnClickListener(null);
        setOnTouchListener(null);
        if (this.zzv) {
            return;
        }
        com.google.android.gms.ads.internal.zzu.zzy().zzd(this);
        zzbh();
        this.zzv = true;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjS)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
            zzX();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
            com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
            zzbf(AndroidWebViewClient.BLANK_PAGE);
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzaE()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjT)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzbzo.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzaU(str, valueCallback);
                }
            });
        }
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzv) {
                    this.zzo.zzh();
                    com.google.android.gms.ads.internal.zzu.zzy().zzd(this);
                    zzbh();
                    zzbb();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void loadData(String str, String str2, String str3) {
        if (zzaE()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (zzaE()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void loadUrl(final String str) {
        if (zzaE()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkq)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcff
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzaV(str);
                    }
                });
            } else {
                super.loadUrl(str);
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "AdWebViewImpl.loadUrl");
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaE()) {
            this.zzQ.zzc();
        }
        if (this.zzY) {
            onResume();
            this.zzY = false;
        }
        boolean z10 = this.zzC;
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null && zzcerVar.zzQ()) {
            if (!this.zzD) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzD = true;
            }
            zzaZ();
            z10 = true;
        }
        zzbd(z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzcer zzcerVar;
        synchronized (this) {
            if (!zzaE()) {
                this.zzQ.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzD && (zzcerVar = this.zzo) != null && zzcerVar.zzQ() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzD = false;
            }
        }
        zzbd(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzke)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.zzu.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzT(getContext(), intent);
        } catch (ActivityNotFoundException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (zzaE()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaZ = zzaZ();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL == null || !zZzaZ) {
            return;
        }
        zzmVarZzL.zzn();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final synchronized void onMeasure(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfi.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final void onPause() {
        if (zzaE()) {
            return;
        }
        try {
            super.onPause();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlE)).booleanValue() && WebViewFeature.isFeatureSupported(WebViewFeature.MUTE_AUDIO)) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Muting webview");
                WebViewCompat.setAudioMuted(this, true);
            }
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Could not pause webview.", e10);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlH)).booleanValue()) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdWebViewImpl.onPause");
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final void onResume() {
        if (zzaE()) {
            return;
        }
        try {
            super.onResume();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlE)).booleanValue() && WebViewFeature.isFeatureSupported(WebViewFeature.MUTE_AUDIO)) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Unmuting webview");
                WebViewCompat.setAudioMuted(this, false);
            }
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Could not resume webview.", e10);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlH)).booleanValue()) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdWebViewImpl.onResume");
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzo.zzQ() || this.zzo.zzO()) {
            zzauo zzauoVar = this.zzc;
            if (zzauoVar != null) {
                zzauoVar.zzd(motionEvent);
            }
            zzbcz zzbczVar = this.zze;
            if (zzbczVar != null) {
                zzbczVar.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzber zzberVar = this.zzE;
                if (zzberVar != null) {
                    zzberVar.zzd(motionEvent);
                }
            }
        }
        if (zzaE()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcer) {
            this.zzo = (zzcer) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaE()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Could not stop loading webview.", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzA(int i10) {
        this.zzN = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzC(zzcfl zzcflVar) {
        if (this.zzB != null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzB = zzcflVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcea
    public final zzfel zzD() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final WebViewClient zzH() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfw
    public final zzauo zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzazj zzJ() {
        return this.zzG;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzber zzK() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zzO;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final /* synthetic */ zzcgb zzN() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfv
    public final synchronized zzcgd zzO() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzeem zzP() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzeeo zzQ() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfm
    public final zzfeo zzR() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzffk zzS() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final m zzT() {
        zzbcz zzbczVar = this.zze;
        return zzbczVar == null ? zzgcj.zzh(null) : zzbczVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized String zzU() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final List zzV() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzW(zzfel zzfelVar, zzfeo zzfeoVar) {
        this.zzk = zzfelVar;
        this.zzl = zzfeoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzX() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzbb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfh(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzY() {
        zzbg();
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.afmaVersion);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzZ(int i10) {
        if (i10 == 0) {
            zzbcj zzbcjVar = this.zzM;
            zzbcd.zza(zzbcjVar.zza(), this.zzK, "aebb2");
        }
        zzbg();
        this.zzM.zza();
        this.zzM.zza().zzd("close_type", String.valueOf(i10));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i10));
        map.put("version", this.zzf.afmaVersion);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zza(String str) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaA(String str, Predicate predicate) {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzN(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaB() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaC() {
        return this.zzH > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaD(final boolean z10, final int i10) {
        destroy();
        this.zzX.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzcfe
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                int i11 = zzcfi.zza;
                zzbbc.zzbl.zza zzaVarZzc = zzbbc.zzbl.zzc();
                boolean zZzf = zzaVarZzc.zzf();
                boolean z11 = z10;
                if (zZzf != z11) {
                    zzaVarZzc.zzd(z11);
                }
                zzaVarZzc.zze(i10);
                zzaVar.zzab(zzaVarZzc.zzbr());
            }
        });
        this.zzX.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaE() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaF() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaG() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaH() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaJ(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z10, boolean z11) {
        this.zzo.zzu(zzcVar, z10, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaK(String str, String str2, int i10) {
        this.zzo.zzv(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaL(boolean z10, int i10, boolean z11) {
        this.zzo.zzw(z10, i10, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaM(boolean z10, int i10, String str, String str2, boolean z11) {
        this.zzo.zzy(z10, i10, str, str2, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaN(boolean z10, int i10, String str, boolean z11, boolean z12) {
        this.zzo.zzz(z10, i10, str, z11, z12);
    }

    public final zzcer zzaO() {
        return this.zzo;
    }

    @VisibleForTesting
    final synchronized Boolean zzaP() {
        return this.zzy;
    }

    protected final synchronized void zzaS(String str, ValueCallback valueCallback) {
        if (zzaE()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            evaluateJavascript(str, null);
        }
    }

    protected final void zzaT(String str) {
        if (!PlatformVersion.isAtLeastKitKat()) {
            zzaX("javascript:".concat(str));
            return;
        }
        if (zzaP() == null) {
            zzbj();
        }
        if (zzaP().booleanValue()) {
            zzaS(str, null);
        } else {
            zzaX("javascript:".concat(str));
        }
    }

    final /* synthetic */ void zzaU(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    final /* synthetic */ void zzaV(String str) {
        super.loadUrl(str);
    }

    final /* synthetic */ void zzaW(String str) {
        super.loadUrl(AndroidWebViewClient.BLANK_PAGE);
    }

    protected final synchronized void zzaX(String str) {
        if (zzaE()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    @VisibleForTesting
    final void zzaY(Boolean bool) {
        synchronized (this) {
            this.zzy = bool;
        }
        com.google.android.gms.ads.internal.zzu.zzo().zzy(bool);
    }

    public final boolean zzaZ() {
        int i10;
        int iZzw;
        if (this.zzo.zzP() || this.zzo.zzQ()) {
            com.google.android.gms.ads.internal.client.zzay.zzb();
            DisplayMetrics displayMetrics = this.zzi;
            int iZzw2 = com.google.android.gms.ads.internal.util.client.zzf.zzw(displayMetrics, displayMetrics.widthPixels);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            DisplayMetrics displayMetrics2 = this.zzi;
            int iZzw3 = com.google.android.gms.ads.internal.util.client.zzf.zzw(displayMetrics2, displayMetrics2.heightPixels);
            Activity activityZza = this.zzb.zza();
            if (activityZza == null || activityZza.getWindow() == null) {
                i10 = iZzw2;
                iZzw = iZzw3;
            } else {
                com.google.android.gms.ads.internal.zzu.zzp();
                int[] iArrZzQ = com.google.android.gms.ads.internal.util.zzt.zzQ(activityZza);
                com.google.android.gms.ads.internal.client.zzay.zzb();
                int iZzw4 = com.google.android.gms.ads.internal.util.client.zzf.zzw(this.zzi, iArrZzQ[0]);
                com.google.android.gms.ads.internal.client.zzay.zzb();
                iZzw = com.google.android.gms.ads.internal.util.client.zzf.zzw(this.zzi, iArrZzQ[1]);
                i10 = iZzw4;
            }
            int i11 = this.zzS;
            if (i11 != iZzw2 || this.zzR != iZzw3 || this.zzT != i10 || this.zzU != iZzw) {
                boolean z10 = (i11 == iZzw2 && this.zzR == iZzw3) ? false : true;
                this.zzS = iZzw2;
                this.zzR = iZzw3;
                this.zzT = i10;
                this.zzU = iZzw;
                new zzbrq(this, "").zzj(iZzw2, iZzw3, i10, iZzw, this.zzi.density, this.zzW.getDefaultDisplay().getRotation());
                return z10;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaa() {
        if (this.zzJ == null) {
            zzbcj zzbcjVar = this.zzM;
            zzbcd.zza(zzbcjVar.zza(), this.zzK, "aes2");
            this.zzM.zza();
            zzbci zzbciVarZzf = zzbcl.zzf();
            this.zzJ = zzbciVarZzf;
            this.zzM.zzb("native:view_show", zzbciVarZzf);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.afmaVersion);
        zzd("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzab() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzac(boolean z10) {
        this.zzo.zzi(z10);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzad() {
        this.zzQ.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzae(String str, String str2, String str3) {
        String str4;
        if (zzaE()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        String[] strArr = new String[1];
        String str5 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzI);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", str5);
            jSONObject.put(ServiceProvider.NAMED_SDK, "Google Mobile Ads");
            jSONObject.put("sdkVersion", "12.4.51-000");
            str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Unable to build MRAID_ENV", e10);
            str4 = null;
        }
        strArr[0] = str4;
        super.loadDataWithBaseURL(str, zzcfu.zzb(str2, strArr), "text/html", "UTF-8", null);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaf() {
        if (this.zzL == null) {
            this.zzM.zza();
            zzbci zzbciVarZzf = zzbcl.zzf();
            this.zzL = zzbciVarZzf;
            this.zzM.zzb("native:view_load", zzbciVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzag(String str, zzbix zzbixVar) {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzA(str, zzbixVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzah() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzai(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzp = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzaj(zzcgd zzcgdVar) {
        this.zzs = zzcgdVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzak(zzazj zzazjVar) {
        this.zzG = zzazjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzal(boolean z10) {
        this.zzz = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzam() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzan(Context context) {
        this.zzb.setBaseContext(context);
        this.zzQ.zze(this.zzb.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzao(boolean z10) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzy(this.zzo.zzP(), z10);
        } else {
            this.zzu = z10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzap(zzbep zzbepVar) {
        this.zzF = zzbepVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzaq(boolean z10) {
        boolean z11 = this.zzw;
        this.zzw = z10;
        zzba();
        if (z10 != z11) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzJ)).booleanValue() || !this.zzs.zzi()) {
                new zzbrq(this, "").zzl(true != z10 ? "default" : "expanded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzar(zzber zzberVar) {
        this.zzE = zzberVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzas(zzeem zzeemVar) {
        this.zzr = zzeemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzat(zzeeo zzeeoVar) {
        this.zzq = zzeeoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzau(int i10) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzA(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzav(boolean z10) {
        this.zzY = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzaw(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzO = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzax(boolean z10) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i10 = this.zzH + (true != z10 ? -1 : 1);
        this.zzH = i10;
        if (i10 > 0 || (zzmVar = this.zzp) == null) {
            return;
        }
        zzmVar.zzE();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000b A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0007, B:8:0x000b), top: B:16:0x0004 }] */
    @Override // com.google.android.gms.internal.ads.zzcej
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzay(boolean r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L7
            r0 = 0
            r1.setBackgroundColor(r0)     // Catch: java.lang.Throwable -> L12
        L7:
            com.google.android.gms.ads.internal.overlay.zzm r0 = r1.zzp     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            r0.zzB(r2)     // Catch: java.lang.Throwable -> L12
            monitor-exit(r1)
            return
        L10:
            monitor-exit(r1)
            return
        L12:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfi.zzay(boolean):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaz(String str, zzbix zzbixVar) {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzM(str, zzbixVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zzb(String str, String str2) {
        zzaT(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzd(String str, Map map) {
        try {
            zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzj(map));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzdG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzdf();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final synchronized void zzdg() {
        com.google.android.gms.ads.internal.zzm zzmVar = this.zzg;
        if (zzmVar != null) {
            zzmVar.zzdg();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final synchronized void zzdh() {
        com.google.android.gms.ads.internal.zzm zzmVar = this.zzg;
        if (zzmVar != null) {
            zzmVar.zzdh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized String zzdi() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        boolean z10;
        synchronized (this) {
            z10 = zzaxvVar.zzj;
            this.zzC = z10;
        }
        zzbd(z10);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        com.google.android.gms.ads.internal.util.client.zzm.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzaT(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized int zzf() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcbk
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzbci zzk() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final zzbcj zzm() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfx, com.google.android.gms.internal.ads.zzcbk
    public final VersionInfoParcel zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzcaz zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized zzccv zzp(String str) {
        Map map = this.zzV;
        if (map == null) {
            return null;
        }
        return (zzccv) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final synchronized zzcfl zzq() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized String zzr() {
        zzfeo zzfeoVar = this.zzl;
        if (zzfeoVar == null) {
            return null;
        }
        return zzfeoVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzt(String str, zzccv zzccvVar) {
        if (this.zzV == null) {
            this.zzV = new HashMap();
        }
        this.zzV.put(str, zzccvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzu() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzv(boolean z10, long j10) {
        HashMap map = new HashMap(2);
        map.put("success", true != z10 ? "0" : "1");
        map.put("duration", Long.toString(j10));
        zzd("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzw() {
        zzbep zzbepVar = this.zzF;
        if (zzbepVar != null) {
            final zzdnb zzdnbVar = (zzdnb) zzbepVar;
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmz
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdnbVar.zzd();
                    } catch (RemoteException e10) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzz(boolean z10) {
        this.zzo.zzD(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfy
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzB(int i10) {
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzx(int i10) {
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzy(int i10) {
    }
}
