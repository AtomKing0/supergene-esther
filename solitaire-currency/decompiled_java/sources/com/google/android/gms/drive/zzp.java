package com.google.android.gms.drive;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.drive.ExecutionOptions;

/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
public final class zzp extends ExecutionOptions.Builder {
    private boolean zzat = true;

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions build() {
        zzo();
        return new zzn(this.zzaq, this.zzar, this.zzas, this.zzat);
    }

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setConflictStrategy(int i10) {
        super.setConflictStrategy(i10);
        return this;
    }

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setNotifyOnCompletion(boolean z10) {
        super.setNotifyOnCompletion(z10);
        return this;
    }

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setTrackingTag(String str) {
        super.setTrackingTag(str);
        return this;
    }
}
