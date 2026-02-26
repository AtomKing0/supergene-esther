package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgn implements zzcw {
    static final zzcw zza = new zzgn();

    private zzgn() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzcw
    public final boolean zza(int i10) {
        zzgo zzgoVar = zzgo.BROADCAST_ACTION_UNSPECIFIED;
        return (i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? null : zzgo.ALTERNATIVE_BILLING_ACTION : zzgo.LOCAL_PURCHASES_UPDATED_ACTION : zzgo.PURCHASES_UPDATED_ACTION : zzgo.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
