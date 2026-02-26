package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbtk {
    private final View zza;

    @Nullable
    private final Map zzb;

    @Nullable
    private final zzbym zzc;

    public zzbtk(zzbtj zzbtjVar) {
        View view = zzbtjVar.zza;
        this.zza = view;
        Map map = zzbtjVar.zzb;
        this.zzb = map;
        zzbym zzbymVarZza = zzbte.zza(zzbtjVar.zza.getContext());
        this.zzc = zzbymVarZza;
        if (zzbymVarZza == null || map.isEmpty()) {
            return;
        }
        try {
            zzbymVarZza.zzg(new zzbtl(ObjectWrapper.wrap(view).asBinder(), ObjectWrapper.wrap(map).asBinder()));
        } catch (RemoteException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to call remote method.");
        }
    }

    public final void zza(List list) {
        if (list == null || list.isEmpty()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("No click urls were passed to recordClick");
            return;
        }
        if (this.zzc == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to get internal reporting info generator in recordClick.");
        }
        try {
            this.zzc.zzh(list, ObjectWrapper.wrap(this.zza), new zzbti(this, list));
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("RemoteException recording click: ".concat(e10.toString()));
        }
    }

    public final void zzb(List list) {
        if (list == null || list.isEmpty()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("No impression urls were passed to recordImpression");
            return;
        }
        zzbym zzbymVar = this.zzc;
        if (zzbymVar == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to get internal reporting info generator from recordImpression.");
            return;
        }
        try {
            zzbymVar.zzi(list, ObjectWrapper.wrap(this.zza), new zzbth(this, list));
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("RemoteException recording impression urls: ".concat(e10.toString()));
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzbym zzbymVar = this.zzc;
        if (zzbymVar == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzbymVar.zzk(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to call remote method.");
        }
    }

    public final void zzd(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzl(new ArrayList(Arrays.asList(uri)), ObjectWrapper.wrap(this.zza), new zzbtg(this, updateClickUrlCallback));
        } catch (RemoteException e10) {
            updateClickUrlCallback.onFailure("Internal error: ".concat(e10.toString()));
        }
    }

    public final void zze(List list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzm(list, ObjectWrapper.wrap(this.zza), new zzbtf(this, updateImpressionUrlsCallback));
        } catch (RemoteException e10) {
            updateImpressionUrlsCallback.onFailure("Internal error: ".concat(e10.toString()));
        }
    }
}
