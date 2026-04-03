package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmj implements zzfmm {
    private static final zzfmj zza = new zzfmj(new zzfmn());
    private Date zzb;
    private boolean zzc;
    private final zzfmn zzd;
    private boolean zze;

    private zzfmj(zzfmn zzfmnVar) {
        this.zzd = zzfmnVar;
    }

    public static zzfmj zza() {
        return zza;
    }

    public final Date zzb() {
        Date date = this.zzb;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfmm
    public final void zzc(boolean z10) {
        if (!this.zze && z10) {
            Date date = new Date();
            Date date2 = this.zzb;
            if (date2 == null || date.after(date2)) {
                this.zzb = date;
                if (this.zzc) {
                    Iterator it = zzfml.zza().zzb().iterator();
                    while (it.hasNext()) {
                        ((zzflu) it.next()).zzg().zzg(zzb());
                    }
                }
            }
        }
        this.zze = z10;
    }

    public final void zzd(@NonNull Context context) {
        if (this.zzc) {
            return;
        }
        this.zzd.zzd(context);
        this.zzd.zze(this);
        this.zzd.zzf();
        this.zze = this.zzd.zza;
        this.zzc = true;
    }
}
