package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzag extends zzac {
    private final zzai zza;

    zzag(zzai zzaiVar, int i10) {
        super(zzaiVar.size(), i10);
        this.zza = zzaiVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    protected final Object zza(int i10) {
        return this.zza.get(i10);
    }
}
