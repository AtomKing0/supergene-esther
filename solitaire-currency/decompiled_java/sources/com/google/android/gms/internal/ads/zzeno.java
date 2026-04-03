package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeno implements zzevn {
    public final Context zza;
    public final com.google.android.gms.ads.internal.client.zzq zzb;
    public final List zzc;

    public zzeno(Context context, com.google.android.gms.ads.internal.client.zzq zzqVar, List list) {
        this.zza = context;
        this.zzb = zzqVar;
        this.zzc = list;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzbdv.zza.zze()).booleanValue()) {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.ads.internal.zzu.zzp();
            String className = null;
            try {
                ActivityManager activityManager = (ActivityManager) this.zza.getSystemService("activity");
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                    className = runningTaskInfo.topActivity.getClassName();
                }
            } catch (Exception unused) {
            }
            bundle2.putString("activity", className);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzb.zze);
            bundle3.putInt("height", this.zzb.zzb);
            bundle2.putBundle("size", bundle3);
            if (!this.zzc.isEmpty()) {
                List list = this.zzc;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
