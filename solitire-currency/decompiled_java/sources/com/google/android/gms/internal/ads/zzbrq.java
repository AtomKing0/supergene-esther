package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.Key;
import io.sentry.protocol.ViewHierarchyNode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzbrq {
    private final zzcej zza;
    private final String zzb;

    public zzbrq(zzcej zzcejVar, String str) {
        this.zza = zzcejVar;
        this.zzb = str;
    }

    public final void zzg(int i10, int i11, int i12, int i13) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put(ViewHierarchyNode.JsonKeys.X, i10).put(ViewHierarchyNode.JsonKeys.Y, i11).put("width", i12).put("height", i13));
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while dispatching default position.", e10);
        }
    }

    public final void zzh(String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("message", str).put("action", this.zzb);
            zzcej zzcejVar = this.zza;
            if (zzcejVar != null) {
                zzcejVar.zze("onError", jSONObjectPut);
            }
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while dispatching error event.", e10);
        }
    }

    public final void zzi(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while dispatching ready Event.", e10);
        }
    }

    public final void zzj(int i10, int i11, int i12, int i13, float f10, int i14) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put("width", i10).put("height", i11).put("maxSizeWidth", i12).put("maxSizeHeight", i13).put("density", f10).put(Key.ROTATION, i14));
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while obtaining screen information.", e10);
        }
    }

    public final void zzk(int i10, int i11, int i12, int i13) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put(ViewHierarchyNode.JsonKeys.X, i10).put(ViewHierarchyNode.JsonKeys.Y, i11).put("width", i12).put("height", i13));
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while dispatching size change.", e10);
        }
    }

    public final void zzl(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error occurred while dispatching state change.", e10);
        }
    }
}
