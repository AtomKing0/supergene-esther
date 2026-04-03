package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjj implements zzbix {

    @Nullable
    private final com.google.android.gms.ads.internal.zzb zza;

    @Nullable
    private final zzdsk zzb;

    @Nullable
    private final zzbrk zzd;

    @Nullable
    private final zzedh zze;

    @Nullable
    private final zzcni zzf;
    private com.google.android.gms.ads.internal.overlay.zzy zzg = null;
    private final zzgcu zzh = zzbzo.zzf;
    private final com.google.android.gms.ads.internal.util.client.zzr zzc = new com.google.android.gms.ads.internal.util.client.zzr(null);

    public zzbjj(com.google.android.gms.ads.internal.zzb zzbVar, zzbrk zzbrkVar, zzedh zzedhVar, zzdsk zzdskVar, zzcni zzcniVar) {
        this.zza = zzbVar;
        this.zzd = zzbrkVar;
        this.zze = zzedhVar;
        this.zzb = zzdskVar;
        this.zzf = zzcniVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if (TtmlNode.TAG_P.equalsIgnoreCase(str)) {
            return 7;
        }
        if (CmcdData.Factory.STREAM_TYPE_LIVE.equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    @VisibleForTesting
    static Uri zzc(Context context, zzauo zzauoVar, Uri uri, View view, @Nullable Activity activity, @Nullable zzffk zzffkVar) {
        if (zzauoVar == null) {
            return uri;
        }
        try {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzla)).booleanValue() || zzffkVar == null) {
                if (zzauoVar.zze(uri)) {
                    uri = zzauoVar.zza(uri, context, view, activity);
                }
            } else if (zzauoVar.zze(uri)) {
                uri = zzffkVar.zza(uri, context, view, activity);
            }
        } catch (zzaup unused) {
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "OpenGmsgHandler.maybeAddClickSignalsToUri");
        }
        return uri;
    }

    @VisibleForTesting
    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e10);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.String r29, com.google.android.gms.ads.internal.client.zza r30, java.util.Map r31, java.lang.String r32) {
        /*
            Method dump skipped, instruction units count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzh(java.lang.String, com.google.android.gms.ads.internal.client.zza, java.util.Map, java.lang.String):void");
    }

    private final void zzi(Context context, String str, String str2) {
        this.zze.zzc(str);
        zzdsk zzdskVar = this.zzb;
        if (zzdskVar != null) {
            zzeds.zzd(context, zzdskVar, this.zze, str, "dialog_not_shown", zzfxu.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0152, code lost:
    
        r21 = r6;
        r10 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015a  */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v22, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzj(com.google.android.gms.ads.internal.client.zza r20, java.util.Map r21, boolean r22, java.lang.String r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzj(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzk(boolean z10) {
        zzbrk zzbrkVar = this.zzd;
        if (zzbrkVar != null) {
            zzbrkVar.zza(z10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c1, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzhE)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzhD)).booleanValue()) != false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i10) {
        String str;
        zzdsk zzdskVar = this.zzb;
        if (zzdskVar == null) {
            return;
        }
        zzdsj zzdsjVarZza = zzdskVar.zza();
        zzdsjVarZza.zzb("action", "cct_action");
        switch (i10) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            default:
                str = "WRONG_EXP_SETUP";
                break;
        }
        zzdsjVarZza.zzb("cct_open_status", str);
        zzdsjVarZza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        Map map2 = new HashMap();
        zzcej zzcejVar = (zzcej) zzaVar;
        if (zzcejVar.zzD() != null) {
            map2 = zzcejVar.zzD().zzaw;
        }
        String strZzc = zzbyc.zzc(str, zzcejVar.getContext(), true, map2);
        String str2 = (String) map.get(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY);
        if (str2 == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzc()) {
            zzgcj.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjg)).booleanValue() && this.zzf != null && zzcni.zzj(strZzc)) ? this.zzf.zzb(strZzc, com.google.android.gms.ads.internal.client.zzay.zze()) : zzgcj.zzh(strZzc), new zzbjf(this, map, zzaVar, str2), this.zzh);
        } else {
            this.zza.zzb(strZzc);
        }
    }
}
