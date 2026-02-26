package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfux implements Serializable, zzfuv {
    private final List zza;

    public final boolean equals(Object obj) {
        if (obj instanceof zzfux) {
            return this.zza.equals(((zzfux) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append("and(");
        boolean z10 = true;
        for (Object obj : this.zza) {
            if (!z10) {
                sb.append(',');
            }
            sb.append(obj);
            z10 = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfuv
    public final boolean zza(Object obj) {
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            if (!((zzfuv) this.zza.get(i10)).zza(obj)) {
                return false;
            }
        }
        return true;
    }
}
