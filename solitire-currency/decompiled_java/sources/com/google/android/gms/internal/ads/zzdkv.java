package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkv {
    private final zzdpl zza;
    private final zzdoa zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdkv(zzdpl zzdplVar, zzdoa zzdoaVar) {
        this.zza = zzdplVar;
        this.zzb = zzdoaVar;
    }

    private static final int zzf(Context context, String str, int i10) {
        try {
            i10 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzy(context, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza(@NonNull final View view, @NonNull final WindowManager windowManager) throws zzcev {
        zzcej zzcejVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        View view2 = (View) zzcejVarZza;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zzcejVarZza.zzag("/sendMessageToSdk", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkp
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcej) obj, map);
            }
        });
        zzcejVarZza.zzag("/hideValidatorOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkq
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzc(windowManager, view, (zzcej) obj, map);
            }
        });
        zzcejVarZza.zzag("/open", new zzbjj(null, null, null, null, null));
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/loadNativeAdPolicyViolations", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkr
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zze(view, windowManager, (zzcej) obj, map);
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/showValidatorOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdks
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Show native ad policy validator overlay.");
                ((zzcej) obj).zzF().setVisibility(0);
            }
        });
        return (View) zzcejVarZza;
    }

    final /* synthetic */ void zzb(zzcej zzcejVar, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcej zzcejVar, Map map) {
        com.google.android.gms.ads.internal.util.client.zzm.zze("Hide native ad policy validator overlay.");
        zzcejVar.zzF().setVisibility(8);
        if (zzcejVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcejVar.zzF());
        }
        zzcejVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzc);
    }

    final /* synthetic */ void zzd(Map map, boolean z10, int i10, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", map2);
    }

    final /* synthetic */ void zze(final View view, final WindowManager windowManager, final zzcej zzcejVar, final Map map) {
        zzcejVar.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdku
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z10, int i10, String str, String str2) {
                this.zza.zzd(map, z10, i10, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int iZzf = zzf(context, (String) map.get("validator_width"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhl)).intValue());
        int iZzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhm)).intValue());
        int iZzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int iZzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcejVar.zzaj(zzcgd.zzb(iZzf, iZzf2));
        try {
            zzcejVar.zzG().getSettings().setUseWideViewPort(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhn)).booleanValue());
            zzcejVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzho)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsZzb = com.google.android.gms.ads.internal.util.zzbv.zzb();
        layoutParamsZzb.x = iZzf3;
        layoutParamsZzb.y = iZzf4;
        windowManager.updateViewLayout(zzcejVar.zzF(), layoutParamsZzb);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i10 = (("1".equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - iZzf4;
            this.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdkt
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcej zzcejVar2 = zzcejVar;
                        if (zzcejVar2.zzF().getWindowToken() == null) {
                            return;
                        }
                        int i11 = i10;
                        WindowManager.LayoutParams layoutParams = layoutParamsZzb;
                        String str2 = str;
                        if ("1".equals(str2) || "2".equals(str2)) {
                            layoutParams.y = rect2.bottom - i11;
                        } else {
                            layoutParams.y = rect2.top - i11;
                        }
                        windowManager.updateViewLayout(zzcejVar2.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzc);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzcejVar.loadUrl(str2);
    }
}
