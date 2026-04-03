package com.google.android.gms.drive;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
@Deprecated
public final class zzn extends ExecutionOptions {
    private boolean zzat;

    private zzn(@Nullable String str, boolean z10, int i10, boolean z11) {
        super(str, z10, i10);
        this.zzat = z11;
    }

    public static zzn zza(@Nullable ExecutionOptions executionOptions) {
        zzp zzpVar = new zzp();
        if (executionOptions != null) {
            zzpVar.setConflictStrategy(executionOptions.zzn());
            zzpVar.setNotifyOnCompletion(executionOptions.zzm());
            String strZzl = executionOptions.zzl();
            if (strZzl != null) {
                zzpVar.setTrackingTag(strZzl);
            }
        }
        return (zzn) zzpVar.build();
    }

    public final boolean zzp() {
        return this.zzat;
    }
}
