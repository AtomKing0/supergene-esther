package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfxw<E> extends zzfxm<E> implements Set<E> {
    private transient zzfxr zza;

    zzfxw() {
    }

    static int zzh(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= 751619276) {
            zzfuu.zzf(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzfxv zzj(int i10) {
        return new zzfxv(i10);
    }

    public static zzfxw zzl(Collection collection) {
        if ((collection instanceof zzfxw) && !(collection instanceof SortedSet)) {
            zzfxw zzfxwVar = (zzfxw) collection;
            if (!zzfxwVar.zzf()) {
                return zzfxwVar;
            }
        }
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzfxw zzm(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? zzv(length, (Object[]) objArr.clone()) : new zzfzu(objArr[0]) : zzfzj.zza;
    }

    public static zzfxw zzn() {
        return zzfzj.zza;
    }

    public static zzfxw zzo(Object obj) {
        return new zzfzu(obj);
    }

    public static zzfxw zzp(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzfxw zzq(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzfxw zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfxw zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[11];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 5);
        return zzv(11, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfxw zzv(int i10, Object... objArr) {
        if (i10 == 0) {
            return zzfzj.zza;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzfzu(obj);
        }
        int iZzh = zzh(i10);
        Object[] objArr2 = new Object[iZzh];
        int i11 = iZzh - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object obj2 = objArr[i14];
            zzfzb.zza(obj2, i14);
            int iHashCode = obj2.hashCode();
            int iZza = zzfxj.zza(iHashCode);
            while (true) {
                int i15 = iZza & i11;
                Object obj3 = objArr2[i15];
                if (obj3 == null) {
                    objArr[i13] = obj2;
                    objArr2[i15] = obj2;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzfzu(obj4);
        }
        if (zzh(i13) < iZzh / 2) {
            return zzv(i13, objArr);
        }
        if (zzw(i13, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new zzfzj(objArr, i12, objArr2, i11, i13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfxw) && zzu() && ((zzfxw) obj).zzu() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzfzt.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzfzt.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public zzfxr zzd() {
        zzfxr zzfxrVar = this.zza;
        if (zzfxrVar != null) {
            return zzfxrVar;
        }
        zzfxr zzfxrVarZzi = zzi();
        this.zza = zzfxrVarZzi;
        return zzfxrVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzfzx iterator();

    zzfxr zzi() {
        Object[] array = toArray();
        int i10 = zzfxr.zzd;
        return zzfxr.zzj(array, array.length);
    }

    boolean zzu() {
        return false;
    }
}
