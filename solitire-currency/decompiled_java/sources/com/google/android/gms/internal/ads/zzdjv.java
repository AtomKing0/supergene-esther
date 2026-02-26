package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjv extends zzbfm implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdkx {
    private final WeakReference zza;
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzdiw zze;
    private zzaxx zzf;

    public zzdjv(View view, HashMap map, HashMap map2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        com.google.android.gms.ads.internal.zzu.zzx();
        zzcab.zza(view, this);
        com.google.android.gms.ads.internal.zzu.zzx();
        zzcab.zzb(view, this);
        this.zza = new WeakReference(view);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.zzb.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzd.putAll(this.zzb);
        for (Map.Entry entry2 : map2.entrySet()) {
            View view3 = (View) entry2.getValue();
            if (view3 != null) {
                this.zzc.put((String) entry2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzd.putAll(this.zzc);
        this.zzf = new zzaxx(view.getContext(), view);
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzdiw zzdiwVar = this.zze;
        if (zzdiwVar != null) {
            zzdiwVar.zzD(view, zzf(), zzl(), zzm(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdiw zzdiwVar = this.zze;
        if (zzdiwVar != null) {
            zzdiwVar.zzB(zzf(), zzl(), zzm(), zzdiw.zzX(zzf()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdiw zzdiwVar = this.zze;
        if (zzdiwVar != null) {
            zzdiwVar.zzB(zzf(), zzl(), zzm(), zzdiw.zzX(zzf()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdiw zzdiwVar = this.zze;
        if (zzdiwVar != null) {
            zzdiwVar.zzK(view, motionEvent, zzf());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzb(IObjectWrapper iObjectWrapper) {
        if (this.zze != null) {
            Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(objUnwrap instanceof View)) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zze.zzM((View) objUnwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzc(IObjectWrapper iObjectWrapper) {
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof zzdiw)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzdiw zzdiwVar = this.zze;
        if (zzdiwVar != null) {
            zzdiwVar.zzS(this);
        }
        zzdiw zzdiwVar2 = (zzdiw) objUnwrap;
        if (!zzdiwVar2.zzT()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
            return;
        }
        this.zze = zzdiwVar2;
        zzdiwVar2.zzR(this);
        this.zze.zzJ(zzf());
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzd() {
        zzdiw zzdiwVar = this.zze;
        if (zzdiwVar != null) {
            zzdiwVar.zzS(this);
            this.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    @Nullable
    public final View zzf() {
        return (View) this.zza.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    @Nullable
    public final synchronized View zzg(String str) {
        WeakReference weakReference = (WeakReference) this.zzd.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    @Nullable
    public final FrameLayout zzh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final zzaxx zzi() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    @Nullable
    public final synchronized IObjectWrapper zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized String zzk() {
        return "1007";
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized Map zzl() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized Map zzm() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    @Nullable
    public final synchronized Map zzn() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    @Nullable
    public final synchronized JSONObject zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    @Nullable
    public final synchronized JSONObject zzp() {
        zzdiw zzdiwVar = this.zze;
        if (zzdiwVar == null) {
            return null;
        }
        return zzdiwVar.zzj(zzf(), zzl(), zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized void zzq(String str, View view, boolean z10) {
        this.zzd.put(str, new WeakReference(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
            this.zzb.put(str, new WeakReference(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }
}
