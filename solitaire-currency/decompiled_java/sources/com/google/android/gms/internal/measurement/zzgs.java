package com.google.android.gms.internal.measurement;

import android.content.Context;
import e5.l;
import e5.u;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgs extends zzhr {
    private final Context zza;
    private final u<l<zzhe>> zzb;

    zzgs(Context context, u<l<zzhe>> uVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = uVar;
    }

    public final boolean equals(Object obj) {
        u<l<zzhe>> uVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhr) {
            zzhr zzhrVar = (zzhr) obj;
            if (this.zza.equals(zzhrVar.zza()) && ((uVar = this.zzb) != null ? uVar.equals(zzhrVar.zzb()) : zzhrVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        u<l<zzhe>> uVar = this.zzb;
        return iHashCode ^ (uVar == null ? 0 : uVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    @Override // com.google.android.gms.internal.measurement.zzhr
    final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhr
    final u<l<zzhe>> zzb() {
        return this.zzb;
    }
}
