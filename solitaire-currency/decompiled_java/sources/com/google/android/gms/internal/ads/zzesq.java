package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesq implements zzevo {
    private final zzgcu zza;

    @Nullable
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzesq(zzgcu zzgcuVar, @Nullable ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgcuVar;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 22;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzesr zzc() throws Exception {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfl)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzesr(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        Boolean boolValueOf = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfm)).booleanValue() && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        boolValueOf = Boolean.valueOf((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    boolValueOf = Boolean.TRUE;
                }
                return new zzesr(boolValueOf);
            }
        }
        return new zzesr(null);
    }
}
