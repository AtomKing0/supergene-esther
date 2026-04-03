package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfxt {
    Object[] zza;
    int zzb;
    zzfxs zzc;

    public zzfxt() {
        this(4);
    }

    private final void zzd(int i10) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i11 = i10 + i10;
        if (i11 > length) {
            this.zza = Arrays.copyOf(objArr, zzfxl.zze(length, i11));
        }
    }

    public final zzfxt zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfwo.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i10 = this.zzb;
        int i11 = i10 + i10;
        objArr[i11] = obj;
        objArr[i11 + 1] = obj2;
        this.zzb = i10 + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzfxt zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfxu zzc() {
        zzfxs zzfxsVar = this.zzc;
        if (zzfxsVar != null) {
            throw zzfxsVar.zza();
        }
        zzfzi zzfziVarZzj = zzfzi.zzj(this.zzb, this.zza, this);
        zzfxs zzfxsVar2 = this.zzc;
        if (zzfxsVar2 == null) {
            return zzfziVarZzj;
        }
        throw zzfxsVar2.zza();
    }

    zzfxt(int i10) {
        this.zza = new Object[i10 + i10];
        this.zzb = 0;
    }
}
