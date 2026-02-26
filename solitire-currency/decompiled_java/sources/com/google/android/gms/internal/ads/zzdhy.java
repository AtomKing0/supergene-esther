package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import com.ironsource.w8;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdhy implements zzdjj {
    private com.google.android.gms.ads.internal.client.zzcs zzC;
    private final Context zza;
    private final zzdjm zzb;
    private final JSONObject zzc;
    private final zzdoa zzd;
    private final zzdjb zze;
    private final zzauo zzf;
    private final zzcxi zzg;
    private final zzcwo zzh;
    private final zzdeo zzi;
    private final zzfel zzj;
    private final VersionInfoParcel zzk;
    private final zzffg zzl;
    private final zzcof zzm;
    private final zzdkf zzn;
    private final Clock zzo;
    private final zzdek zzp;
    private final zzfll zzq;
    private final zzdpq zzr;
    private final zzfkf zzs;
    private final zzeds zzt;
    private boolean zzv;
    private boolean zzu = false;
    private boolean zzw = false;
    private boolean zzx = false;
    private Point zzy = new Point();
    private Point zzz = new Point();
    private long zzA = 0;
    private long zzB = 0;

    public zzdhy(Context context, zzdjm zzdjmVar, JSONObject jSONObject, zzdoa zzdoaVar, zzdjb zzdjbVar, zzauo zzauoVar, zzcxi zzcxiVar, zzcwo zzcwoVar, zzdeo zzdeoVar, zzfel zzfelVar, VersionInfoParcel versionInfoParcel, zzffg zzffgVar, zzcof zzcofVar, zzdkf zzdkfVar, Clock clock, zzdek zzdekVar, zzfll zzfllVar, zzfkf zzfkfVar, zzeds zzedsVar, zzdpq zzdpqVar) {
        this.zza = context;
        this.zzb = zzdjmVar;
        this.zzc = jSONObject;
        this.zzd = zzdoaVar;
        this.zze = zzdjbVar;
        this.zzf = zzauoVar;
        this.zzg = zzcxiVar;
        this.zzh = zzcwoVar;
        this.zzi = zzdeoVar;
        this.zzj = zzfelVar;
        this.zzk = versionInfoParcel;
        this.zzl = zzffgVar;
        this.zzm = zzcofVar;
        this.zzn = zzdkfVar;
        this.zzo = clock;
        this.zzp = zzdekVar;
        this.zzq = zzfllVar;
        this.zzs = zzfkfVar;
        this.zzt = zzedsVar;
        this.zzr = zzdpqVar;
    }

    @Nullable
    private final String zzD(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdf)).booleanValue()) {
            return null;
        }
        try {
            return this.zzf.zzc().zzh(this.zza, view, null);
        } catch (Exception unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Exception getting data.");
            return null;
        }
    }

    @Nullable
    private final String zzE(@Nullable View view, @Nullable Map map) {
        if (map != null && view != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        int iZzc = this.zze.zzc();
        if (iZzc == 1) {
            return "1099";
        }
        if (iZzc == 2) {
            return "2099";
        }
        if (iZzc != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzF(String str) {
        JSONObject jSONObjectOptJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        return jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean(str, false);
    }

    private final boolean zzG() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zzH(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, boolean z10) {
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzc);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdf)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z10);
            Context context = this.zza;
            JSONObject jSONObject7 = new JSONObject();
            com.google.android.gms.ads.internal.zzu.zzp();
            DisplayMetrics displayMetricsZzt = com.google.android.gms.ads.internal.util.zzt.zzt((WindowManager) context.getSystemService("window"));
            zzdhu zzdhuVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            try {
                jSONObject7.put("width", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, displayMetricsZzt.widthPixels));
                jSONObject7.put("height", com.google.android.gms.ads.internal.client.zzay.zzb().zzb(context, displayMetricsZzt.heightPixels));
            } catch (JSONException unused) {
                jSONObject7 = null;
            }
            jSONObject6.put("screen", jSONObject7);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhK)).booleanValue()) {
                this.zzd.zzl("/clickRecorded", new zzdhv(this, zzdhuVar));
            } else {
                this.zzd.zzl("/logScionEvent", new zzdht(this, objArr == true ? 1 : 0));
            }
            this.zzd.zzl("/nativeImpression", new zzdhx(this, objArr2 == true ? 1 : 0));
            zzbzr.zza(this.zzd.zzg("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzu) {
                return true;
            }
            this.zzu = com.google.android.gms.ads.internal.zzu.zzs().zzn(this.zza, this.zzk.afmaVersion, this.zzj.zzC.toString(), this.zzl.zzf);
            return true;
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to create impression JSON.", e10);
            return false;
        }
    }

    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$0(ClassGen.java:366)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:367)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:329)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
     */
    static /* bridge */ /* synthetic */ zzdeo zzd(zzdhy zzdhyVar) {
        return zzdhyVar.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzA() {
        if (zza() == 0) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkE)).booleanValue()) {
            return this.zzl.zzi.zzj;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzB() {
        return zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzC(Bundle bundle) {
        if (zzF("impression_reporting")) {
            return zzH(null, null, null, null, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkA)).booleanValue() ? zzD(null) : null, com.google.android.gms.ads.internal.client.zzay.zzb().zzk(bundle, null), false);
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzg("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final int zza() {
        if (this.zzl.zzi == null) {
            return 0;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkE)).booleanValue()) {
            return this.zzl.zzi.zzi;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    @Nullable
    public final JSONObject zze(@Nullable View view, @Nullable Map map, @Nullable Map map2, @Nullable ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject jSONObjectZzd = com.google.android.gms.ads.internal.util.zzbv.zzd(context, map, map2, view, scaleType);
        JSONObject jSONObjectZzg = com.google.android.gms.ads.internal.util.zzbv.zzg(context, view);
        JSONObject jSONObjectZzf = com.google.android.gms.ads.internal.util.zzbv.zzf(view);
        JSONObject jSONObjectZze = com.google.android.gms.ads.internal.util.zzbv.zze(context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", jSONObjectZzd);
            jSONObject.put("ad_view_signal", jSONObjectZzg);
            jSONObject.put("scroll_view_signal", jSONObjectZzf);
            jSONObject.put("lock_screen_signal", jSONObjectZze);
            return jSONObject;
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to create native ad view signals JSON.", e10);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    @Nullable
    public final JSONObject zzf(@Nullable View view, @Nullable Map map, @Nullable Map map2, @Nullable ImageView.ScaleType scaleType) {
        JSONObject jSONObjectZze = zze(view, map, map2, scaleType);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.zzx && zzG()) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (jSONObjectZze != null) {
                jSONObject.put("nas", jSONObjectZze);
            }
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to create native click meta data JSON.", e10);
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzg() {
        try {
            com.google.android.gms.ads.internal.client.zzcs zzcsVar = this.zzC;
            if (zzcsVar != null) {
                zzcsVar.zze();
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzh() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzi() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzj(@Nullable com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        try {
            if (this.zzw) {
                return;
            }
            if (zzcwVar == null) {
                zzdjb zzdjbVar = this.zze;
                if (zzdjbVar.zzk() != null) {
                    this.zzw = true;
                    this.zzq.zzc(zzdjbVar.zzk().zzf(), this.zzs);
                    zzg();
                    return;
                }
            }
            this.zzw = true;
            this.zzq.zzc(zzcwVar.zzf(), this.zzs);
            zzg();
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzk(View view, @Nullable View view2, @Nullable Map map, @Nullable Map map2, boolean z10, @Nullable ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject jSONObjectZzd = com.google.android.gms.ads.internal.util.zzbv.zzd(context, map, map2, view2, scaleType);
        JSONObject jSONObjectZzg = com.google.android.gms.ads.internal.util.zzbv.zzg(context, view2);
        JSONObject jSONObjectZzf = com.google.android.gms.ads.internal.util.zzbv.zzf(view2);
        JSONObject jSONObjectZze = com.google.android.gms.ads.internal.util.zzbv.zze(context, view2);
        String strZzE = zzE(view, map);
        zzn(true == ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdm)).booleanValue() ? view2 : view, jSONObjectZzg, jSONObjectZzd, jSONObjectZzf, jSONObjectZze, strZzE, com.google.android.gms.ads.internal.util.zzbv.zzc(strZzE, context, this.zzz, this.zzy), null, z10, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzl(String str) {
        zzn(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzm(@Nullable Bundle bundle) {
        if (bundle == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Click data is null. No click is reported.");
        } else if (!zzF("click_reporting")) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zzn(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, com.google.android.gms.ads.internal.client.zzay.zzb().zzk(bundle, null), false, false);
        }
    }

    @VisibleForTesting
    protected final void zzn(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z10, boolean z11) {
        String strZze;
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzc);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.zzb.zzc(this.zze.zzA()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put(com.vungle.ads.internal.model.b.KEY_TEMPLATE, this.zze.zzc());
            jSONObject8.put("view_aware_api_used", z10);
            zzbes zzbesVar = this.zzl.zzi;
            jSONObject8.put("custom_mute_requested", zzbesVar != null && zzbesVar.zzg);
            jSONObject8.put("custom_mute_enabled", (this.zze.zzH().isEmpty() || this.zze.zzk() == null) ? false : true);
            if (this.zzn.zza() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzo.currentTimeMillis());
            if (this.zzx && zzG()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z11) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.zzb.zzc(this.zze.zzA()) != null);
            try {
                JSONObject jSONObjectOptJSONObject = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                strZze = this.zzf.zzc().zze(this.zza, jSONObjectOptJSONObject.optString("click_string"), view);
            } catch (Exception e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Exception obtaining click signals", e10);
                strZze = null;
            }
            jSONObject8.put("click_signals", strZze);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzee)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhO)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhP)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put(w8.f16021d, jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long jCurrentTimeMillis = this.zzo.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", jCurrentTimeMillis - this.zzA);
            jSONObject9.put("time_from_last_touch", jCurrentTimeMillis - this.zzB);
            jSONObject7.put("touch_signal", jSONObject9);
            if (this.zzj.zzai) {
                JSONObject jSONObject10 = (JSONObject) this.zzc.get("tracking_urls_and_actions");
                String string = jSONObject10 != null ? jSONObject10.getString("gws_query_id") : null;
                if (string != null) {
                    this.zzt.zzq(string, this.zze);
                }
            }
            zzbzr.zza(this.zzd.zzg("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e11) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to create click JSON.", e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzo(@Nullable View view, @Nullable View view2, @Nullable Map map, @Nullable Map map2, boolean z10, @Nullable ImageView.ScaleType scaleType, int i10) {
        JSONObject jSONObject;
        boolean z11 = false;
        if (this.zzc.optBoolean("allow_sdk_custom_click_gesture", false)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkE)).booleanValue()) {
                z11 = true;
            }
        }
        if (!z11) {
            if (!this.zzx) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Custom click reporting failed. enableCustomClickGesture is not set.");
                return;
            } else if (!zzG()) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Custom click reporting failed. Ad unit id not in the allow list.");
                return;
            }
        }
        JSONObject jSONObjectZzd = com.google.android.gms.ads.internal.util.zzbv.zzd(this.zza, map, map2, view2, scaleType);
        JSONObject jSONObjectZzg = com.google.android.gms.ads.internal.util.zzbv.zzg(this.zza, view2);
        JSONObject jSONObjectZzf = com.google.android.gms.ads.internal.util.zzbv.zzf(view2);
        JSONObject jSONObjectZze = com.google.android.gms.ads.internal.util.zzbv.zze(this.zza, view2);
        String strZzE = zzE(view, map);
        JSONObject jSONObjectZzc = com.google.android.gms.ads.internal.util.zzbv.zzc(strZzE, this.zza, this.zzz, this.zzy);
        if (z11) {
            try {
                JSONObject jSONObject2 = this.zzc;
                Point point = this.zzz;
                Point point2 = this.zzy;
                try {
                    jSONObject = new JSONObject();
                } catch (Exception e10) {
                    e = e10;
                    jSONObject = null;
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    if (point != null) {
                        jSONObject3.put(ViewHierarchyNode.JsonKeys.X, point.x);
                        jSONObject3.put(ViewHierarchyNode.JsonKeys.Y, point.y);
                    }
                    if (point2 != null) {
                        jSONObject4.put(ViewHierarchyNode.JsonKeys.X, point2.x);
                        jSONObject4.put(ViewHierarchyNode.JsonKeys.Y, point2.y);
                    }
                    jSONObject.put("start_point", jSONObject3);
                    jSONObject.put("end_point", jSONObject4);
                    jSONObject.put("duration_ms", i10);
                } catch (Exception e11) {
                    e = e11;
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while grabbing custom click gesture signals.", e);
                }
                jSONObject2.put("custom_click_gesture_signal", jSONObject);
            } catch (JSONException e12) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while adding CustomClickGestureSignals to adJson.", e12);
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e12, "FirstPartyNativeAdCore.performCustomClickGesture");
            }
        }
        zzn(view2, jSONObjectZzg, jSONObjectZzd, jSONObjectZzf, jSONObjectZze, strZzE, jSONObjectZzc, null, z10, true);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            zzbzr.zza(this.zzd.zzg("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzq(@Nullable View view, @Nullable Map map, @Nullable Map map2, @Nullable ImageView.ScaleType scaleType) {
        Context context = this.zza;
        zzH(com.google.android.gms.ads.internal.util.zzbv.zzg(context, view), com.google.android.gms.ads.internal.util.zzbv.zzd(context, map, map2, view, scaleType), com.google.android.gms.ads.internal.util.zzbv.zzf(view), com.google.android.gms.ads.internal.util.zzbv.zze(context, view), zzD(view), null, com.google.android.gms.ads.internal.util.zzbv.zzh(context, this.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzr() {
        zzH(null, null, null, null, null, null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzs(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        this.zzy = com.google.android.gms.ads.internal.util.zzbv.zza(motionEvent, view2);
        long jCurrentTimeMillis = this.zzo.currentTimeMillis();
        this.zzB = jCurrentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
            this.zzA = jCurrentTimeMillis;
            this.zzz = this.zzy;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzy;
        motionEventObtain.setLocation(point.x, point.y);
        this.zzf.zzd(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzt(@Nullable Bundle bundle) {
        if (bundle == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!zzF("touch_reporting")) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
            return;
        }
        this.zzf.zzc().zzl((int) bundle.getFloat(ViewHierarchyNode.JsonKeys.X), (int) bundle.getFloat(ViewHierarchyNode.JsonKeys.Y), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzu(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdkf zzdkfVar = this.zzn;
        if (view == null) {
            return;
        }
        view.setOnClickListener(zzdkfVar);
        view.setClickable(true);
        zzdkfVar.zzc = new WeakReference(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzv() {
        this.zzx = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzw(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzC = zzcsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzx(zzbgx zzbgxVar) {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzc(zzbgxVar);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzy(View view, @Nullable Map map, @Nullable Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (!this.zzv) {
            this.zzp.zza(view);
            this.zzv = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzm.zzi(this);
        boolean zZzi = com.google.android.gms.ads.internal.util.zzbv.zzi(this.zzk.clientJarVersion);
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                if (view2 != null) {
                    if (zZzi) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = (View) ((WeakReference) ((Map.Entry) it2.next()).getValue()).get();
                if (view3 != null) {
                    if (zZzi) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzz(@Nullable View view, @Nullable Map map) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (view != null) {
            this.zzp.zzb(view);
        }
        this.zzv = false;
    }
}
