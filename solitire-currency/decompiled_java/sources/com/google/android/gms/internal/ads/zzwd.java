package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzwd {
    private int zza;
    private final SparseArray zzb;
    private final zzdn zzc;

    public zzwd() {
        this(new zzdn() { // from class: com.google.android.gms.internal.ads.zzwc
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
            }
        });
    }

    public final Object zza(int i10) {
        if (this.zza == -1) {
            this.zza = 0;
        }
        while (true) {
            int i11 = this.zza;
            if (i11 <= 0 || i10 >= this.zzb.keyAt(i11)) {
                break;
            }
            this.zza--;
        }
        while (this.zza < this.zzb.size() - 1 && i10 >= this.zzb.keyAt(this.zza + 1)) {
            this.zza++;
        }
        return this.zzb.valueAt(this.zza);
    }

    public final Object zzb() {
        return this.zzb.valueAt(this.zzb.size() - 1);
    }

    public final void zzc(int i10, Object obj) {
        if (this.zza == -1) {
            zzdi.zzf(this.zzb.size() == 0);
            this.zza = 0;
        }
        if (this.zzb.size() > 0) {
            int iKeyAt = this.zzb.keyAt(r0.size() - 1);
            zzdi.zzd(i10 >= iKeyAt);
            if (iKeyAt == i10) {
                this.zzc.zza(this.zzb.valueAt(r1.size() - 1));
            }
        }
        this.zzb.append(i10, obj);
    }

    public final void zzd() {
        for (int i10 = 0; i10 < this.zzb.size(); i10++) {
            this.zzc.zza(this.zzb.valueAt(i10));
        }
        this.zza = -1;
        this.zzb.clear();
    }

    public final void zze(int i10) {
        int i11 = 0;
        while (i11 < this.zzb.size() - 1) {
            int i12 = i11 + 1;
            if (i10 < this.zzb.keyAt(i12)) {
                return;
            }
            this.zzc.zza(this.zzb.valueAt(i11));
            this.zzb.removeAt(i11);
            int i13 = this.zza;
            if (i13 > 0) {
                this.zza = i13 - 1;
            }
            i11 = i12;
        }
    }

    public final boolean zzf() {
        return this.zzb.size() == 0;
    }

    public zzwd(zzdn zzdnVar) {
        this.zzb = new SparseArray();
        this.zzc = zzdnVar;
        this.zza = -1;
    }
}
