package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzfgi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzn extends WebViewClient {
    final /* synthetic */ zzt zza;

    zzn(zzt zztVar) {
        this.zza = zztVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzt zztVar = this.zza;
        if (zztVar.zzg != null) {
            try {
                zztVar.zzg.zzf(zzfgi.zzd(1, null, null));
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
            }
        }
        zzt zztVar2 = this.zza;
        if (zztVar2.zzg != null) {
            try {
                zztVar2.zzg.zze(0);
            } catch (RemoteException e11) {
                com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e11);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zza.zzq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzt zztVar = this.zza;
            if (zztVar.zzg != null) {
                try {
                    zztVar.zzg.zzf(zzfgi.zzd(3, null, null));
                } catch (RemoteException e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
                }
            }
            zzt zztVar2 = this.zza;
            if (zztVar2.zzg != null) {
                try {
                    zztVar2.zzg.zze(3);
                } catch (RemoteException e11) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e11);
                }
            }
            this.zza.zzV(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzt zztVar3 = this.zza;
            if (zztVar3.zzg != null) {
                try {
                    zztVar3.zzg.zzf(zzfgi.zzd(1, null, null));
                } catch (RemoteException e12) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e12);
                }
            }
            zzt zztVar4 = this.zza;
            if (zztVar4.zzg != null) {
                try {
                    zztVar4.zzg.zze(0);
                } catch (RemoteException e13) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e13);
                }
            }
            this.zza.zzV(0);
            return true;
        }
        if (str.startsWith("gmsg://adResized")) {
            zzt zztVar5 = this.zza;
            if (zztVar5.zzg != null) {
                try {
                    zztVar5.zzg.zzi();
                } catch (RemoteException e14) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e14);
                }
            }
            this.zza.zzV(this.zza.zzb(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        zzt zztVar6 = this.zza;
        if (zztVar6.zzg != null) {
            try {
                zztVar6.zzg.zzc();
                this.zza.zzg.zzh();
            } catch (RemoteException e15) {
                com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e15);
            }
        }
        zzt.zzw(this.zza, zzt.zzo(this.zza, str));
        return true;
    }
}
