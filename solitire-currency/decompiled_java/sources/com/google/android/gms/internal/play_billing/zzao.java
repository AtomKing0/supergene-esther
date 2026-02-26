package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzao extends zzai {
    static final zzai zza = new zzao(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzao(Object[] objArr, int i10) {
        this.zzb = objArr;
        this.zzc = i10;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        zzaa.zza(i10, this.zzc, "index");
        Object obj = this.zzb[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzai, com.google.android.gms.internal.play_billing.zzaf
    final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    final Object[] zzg() {
        return this.zzb;
    }
}
