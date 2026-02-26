package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlc extends zzhe {
    public static final /* synthetic */ int zzb = 0;
    private final int zzc;
    private final int zzd;
    private final int[] zze;
    private final int[] zzf;
    private final zzcc[] zzg;
    private final Object[] zzh;
    private final HashMap zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzlc(Collection collection, zzwa zzwaVar) {
        zzcc[] zzccVarArr = new zzcc[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            zzccVarArr[i11] = ((zzkl) it.next()).zza();
            i11++;
        }
        Object[] objArr = new Object[collection.size()];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            objArr[i10] = ((zzkl) it2.next()).zzb();
            i10++;
        }
        this(zzccVarArr, objArr, zzwaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    protected final int zzp(Object obj) {
        Integer num = (Integer) this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    protected final int zzq(int i10) {
        return zzet.zzb(this.zze, i10 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    protected final int zzr(int i10) {
        return zzet.zzb(this.zzf, i10 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    protected final int zzs(int i10) {
        return this.zze[i10];
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    protected final int zzt(int i10) {
        return this.zzf[i10];
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    protected final zzcc zzu(int i10) {
        return this.zzg[i10];
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    protected final Object zzv(int i10) {
        return this.zzh[i10];
    }

    final List zzw() {
        return Arrays.asList(this.zzg);
    }

    public final zzlc zzx(zzwa zzwaVar) {
        zzcc[] zzccVarArr = new zzcc[this.zzg.length];
        int i10 = 0;
        while (true) {
            zzcc[] zzccVarArr2 = this.zzg;
            if (i10 >= zzccVarArr2.length) {
                return new zzlc(zzccVarArr, this.zzh, zzwaVar);
            }
            zzccVarArr[i10] = new zzlb(this, zzccVarArr2[i10]);
            i10++;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzlc(zzcc[] zzccVarArr, Object[] objArr, zzwa zzwaVar) {
        super(false, zzwaVar);
        int i10 = 0;
        this.zzg = zzccVarArr;
        int length = zzccVarArr.length;
        this.zze = new int[length];
        this.zzf = new int[length];
        this.zzh = objArr;
        this.zzi = new HashMap();
        int iZzc = 0;
        int iZzb = 0;
        int i11 = 0;
        while (i10 < zzccVarArr.length) {
            zzcc zzccVar = zzccVarArr[i10];
            this.zzg[i11] = zzccVar;
            this.zzf[i11] = iZzc;
            this.zze[i11] = iZzb;
            iZzc += zzccVar.zzc();
            iZzb += this.zzg[i11].zzb();
            this.zzi.put(objArr[i11], Integer.valueOf(i11));
            i10++;
            i11++;
        }
        this.zzc = iZzc;
        this.zzd = iZzb;
    }
}
