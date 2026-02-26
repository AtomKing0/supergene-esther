package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.zzau;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
final class zzh extends RelativeLayout {

    @VisibleForTesting
    final zzau zza;

    @VisibleForTesting
    boolean zzb;

    public zzh(Context context, String str, String str2, String str3) {
        super(context);
        zzau zzauVar = new zzau(context, str);
        this.zza = zzauVar;
        zzauVar.zzo(str2);
        zzauVar.zzn(str3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zzm(motionEvent);
        return false;
    }
}
