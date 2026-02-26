package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfwn implements zzfyp {
    private transient Set zza;
    private transient Collection zzb;
    private transient Map zzc;

    zzfwn() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfyp) {
            return zzs().equals(((zzfyp) obj).zzs());
        }
        return false;
    }

    public final int hashCode() {
        return zzs().hashCode();
    }

    public final String toString() {
        return zzs().toString();
    }

    abstract Collection zzf();

    Iterator zzg() {
        throw null;
    }

    abstract Map zzj();

    abstract Set zzl();

    @Override // com.google.android.gms.internal.ads.zzfyp
    public boolean zzq(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    public final Collection zzr() {
        Collection collection = this.zzb;
        if (collection != null) {
            return collection;
        }
        Collection collectionZzf = zzf();
        this.zzb = collectionZzf;
        return collectionZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    public final Map zzs() {
        Map map = this.zzc;
        if (map != null) {
            return map;
        }
        Map mapZzj = zzj();
        this.zzc = mapZzj;
        return mapZzj;
    }

    public final Set zzt() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set setZzl = zzl();
        this.zza = setZzl;
        return setZzl;
    }
}
