package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjm {
    public static final zzdjm zza = new zzdjm(new zzdjk());

    @Nullable
    private final zzbge zzb;

    @Nullable
    private final zzbgb zzc;

    @Nullable
    private final zzbgr zzd;

    @Nullable
    private final zzbgo zze;

    @Nullable
    private final zzblq zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    @Nullable
    public final zzbgb zza() {
        return this.zzc;
    }

    @Nullable
    public final zzbge zzb() {
        return this.zzb;
    }

    @Nullable
    public final zzbgh zzc(String str) {
        return (zzbgh) this.zzh.get(str);
    }

    @Nullable
    public final zzbgk zzd(String str) {
        return (zzbgk) this.zzg.get(str);
    }

    @Nullable
    public final zzbgo zze() {
        return this.zze;
    }

    @Nullable
    public final zzbgr zzf() {
        return this.zzd;
    }

    @Nullable
    public final zzblq zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i10 = 0; i10 < this.zzg.size(); i10++) {
            arrayList.add((String) this.zzg.keyAt(i10));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    private zzdjm(zzdjk zzdjkVar) {
        this.zzb = zzdjkVar.zza;
        this.zzc = zzdjkVar.zzb;
        this.zzd = zzdjkVar.zzc;
        this.zzg = new SimpleArrayMap(zzdjkVar.zzf);
        this.zzh = new SimpleArrayMap(zzdjkVar.zzg);
        this.zze = zzdjkVar.zzd;
        this.zzf = zzdjkVar.zze;
    }
}
