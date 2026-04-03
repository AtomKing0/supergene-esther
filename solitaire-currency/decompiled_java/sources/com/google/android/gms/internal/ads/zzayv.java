package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.PlatformVersion;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayv extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzaym zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzayv() {
        zzaym zzaymVar = new zzaym();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzaymVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbdj.zzd.zze()).intValue();
        this.zzg = ((Long) zzbdj.zza.zze()).intValue();
        this.zzh = ((Long) zzbdj.zze.zze()).intValue();
        this.zzi = ((Long) zzbdj.zzc.zze()).intValue();
        this.zzj = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzL)).intValue();
        this.zzk = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzM)).intValue();
        this.zzl = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzN)).intValue();
        this.zze = ((Long) zzbdj.zzf.zze()).intValue();
        this.zzm = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzP);
        this.zzn = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzQ)).booleanValue();
        this.zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzR)).booleanValue();
        this.zzp = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzS)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r3.importance != 100) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r2.inKeyguardRestrictedInputMode() != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        r0 = (android.os.PowerManager) r0.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r0 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r0.isScreenOn() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        r0 = com.google.android.gms.ads.internal.zzu.zzb().zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzm.zze("ContentFetchThread: no activity. Sleeping.");
        zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (r0.getWindow() == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        if (r0.getWindow().getDecorView() == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
    
        r1 = r0.getWindow().getDecorView().findViewById(android.R.id.content);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        com.google.android.gms.ads.internal.zzu.zzo().zzw(r0, "ContentFetchTask.extractContent");
        com.google.android.gms.ads.internal.util.client.zzm.zze("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c4, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzm.zzh("Error in ContentFetchTask", r0);
        com.google.android.gms.ads.internal.zzu.zzo().zzw(r0, "ContentFetchTask.run");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d4, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzm.zzh("Error in ContentFetchTask", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dc A[EXC_TOP_SPLITTER, LOOP:1: B:65:0x00dc->B:70:0x00dc, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayv.run():void");
    }

    public final zzayl zza() {
        return this.zzd.zza(this.zzp);
    }

    @VisibleForTesting
    final zzayu zzb(@Nullable View view, zzayl zzaylVar) {
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                CharSequence text = ((TextView) view).getText();
                if (!TextUtils.isEmpty(text)) {
                    zzaylVar.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                    return new zzayu(this, 1, 0);
                }
            } else if ((view instanceof WebView) && !(view instanceof zzcej)) {
                WebView webView = (WebView) view;
                if (PlatformVersion.isAtLeastKitKat()) {
                    zzaylVar.zzh();
                    webView.post(new zzayt(this, zzaylVar, webView, globalVisibleRect));
                    return new zzayu(this, 0, 1);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                    zzayu zzayuVarZzb = zzb(viewGroup.getChildAt(i12), zzaylVar);
                    i10 += zzayuVarZzb.zza;
                    i11 += zzayuVarZzb.zzb;
                }
                return new zzayu(this, i10, i11);
            }
        }
        return new zzayu(this, 0, 0);
    }

    @VisibleForTesting
    final void zzc(View view) {
        try {
            zzayl zzaylVar = new zzayl(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZzb = com.google.android.gms.ads.internal.zzu.zzb().zzb();
            if (contextZzb != null && !TextUtils.isEmpty(this.zzm)) {
                String str = (String) view.getTag(contextZzb.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzO), "id", contextZzb.getPackageName()));
                if (str != null && str.equals(this.zzm)) {
                    return;
                }
            }
            zzayu zzayuVarZzb = zzb(view, zzaylVar);
            zzaylVar.zzm();
            if (zzayuVarZzb.zza == 0 && zzayuVarZzb.zzb == 0) {
                return;
            }
            int i10 = zzayuVarZzb.zzb;
            if (i10 != 0) {
                if (i10 == 0) {
                }
                this.zzd.zzb(zzaylVar);
            } else if (zzaylVar.zzc() == 0) {
                return;
            }
            if (this.zzd.zzd(zzaylVar)) {
                return;
            }
            this.zzd.zzb(zzaylVar);
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Exception in fetchContentOnUIThread", e10);
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    final void zzd(zzayl zzaylVar, WebView webView, String str, boolean z10) {
        zzaylVar.zzg();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzaylVar.zzl(strOptString, z10, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzaylVar.zzl(webView.getTitle() + "\n" + strOptString, z10, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzaylVar.zzo()) {
                this.zzd.zzc(zzaylVar);
            }
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Json string may be malformed.");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzf("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            if (this.zza) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Content hash thread already started, quitting...");
            } else {
                this.zza = true;
                start();
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            com.google.android.gms.ads.internal.util.client.zzm.zze("ContentFetchThread: paused, pause = true");
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            com.google.android.gms.ads.internal.util.client.zzm.zze("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
