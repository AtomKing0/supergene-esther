package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmk extends zzfmn {

    @SuppressLint({"StaticFieldLeak"})
    private static final zzfmk zzb = new zzfmk();

    private zzfmk() {
    }

    public static zzfmk zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final void zzb(boolean z10) {
        Iterator it = zzfml.zza().zzc().iterator();
        while (it.hasNext()) {
            ((zzflu) it.next()).zzg().zzk(z10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final boolean zzc() {
        Iterator it = zzfml.zza().zzb().iterator();
        while (it.hasNext()) {
            View viewZzf = ((zzflu) it.next()).zzf();
            if (viewZzf != null && viewZzf.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
