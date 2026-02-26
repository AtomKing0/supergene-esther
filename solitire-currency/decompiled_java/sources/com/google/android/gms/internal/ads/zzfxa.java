package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfxa extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzfxa() {
        zzp(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] zzA() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    static /* synthetic */ Object zzg(zzfxa zzfxaVar, int i10) {
        return zzfxaVar.zzB()[i10];
    }

    static /* synthetic */ Object zzi(zzfxa zzfxaVar) {
        Object obj = zzfxaVar.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    static /* synthetic */ Object zzj(zzfxa zzfxaVar, int i10) {
        return zzfxaVar.zzC()[i10];
    }

    static /* synthetic */ void zzn(zzfxa zzfxaVar, int i10, Object obj) {
        zzfxaVar.zzC()[i10] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzw(Object obj) {
        if (zzr()) {
            return -1;
        }
        int iZzb = zzfxj.zzb(obj);
        int iZzv = zzv();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int iZzc = zzfxb.zzc(obj2, iZzb & iZzv);
        if (iZzc != 0) {
            int i10 = ~iZzv;
            int i11 = iZzb & i10;
            do {
                int i12 = iZzc - 1;
                int i13 = zzA()[i12];
                if ((i13 & i10) == i11 && zzfur.zza(obj, zzB()[i12])) {
                    return i12;
                }
                iZzc = i13 & iZzv;
            } while (iZzc != 0);
        }
        return -1;
    }

    private final int zzx(int i10, int i11, int i12, int i13) {
        int i14 = i11 - 1;
        Object objZzd = zzfxb.zzd(i11);
        if (i13 != 0) {
            zzfxb.zze(objZzd, i12 & i14, i13 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        for (int i15 = 0; i15 <= i10; i15++) {
            int iZzc = zzfxb.zzc(obj, i15);
            while (iZzc != 0) {
                int i16 = iZzc - 1;
                int i17 = iArrZzA[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int iZzc2 = zzfxb.zzc(objZzd, i19);
                zzfxb.zze(objZzd, i19, iZzc);
                iArrZzA[i16] = ((~i14) & i18) | (iZzc2 & i14);
                iZzc = i17 & i10;
            }
        }
        this.zze = objZzd;
        zzz(i14);
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzy(Object obj) {
        if (!zzr()) {
            int iZzv = zzv();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int iZzb = zzfxb.zzb(obj, null, iZzv, obj2, zzA(), zzB(), null);
            if (iZzb != -1) {
                Object obj3 = zzC()[iZzb];
                zzq(iZzb, iZzv);
                this.zzg--;
                zzo();
                return obj3;
            }
        }
        return zzd;
    }

    private final void zzz(int i10) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i10)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        zzo();
        Map mapZzl = zzl();
        if (mapZzl != null) {
            this.zzf = zzgap.zzc(size(), 3, 1073741823);
            mapZzl.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzB(), 0, this.zzg, (Object) null);
        Arrays.fill(zzC(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzl = zzl();
        return mapZzl != null ? mapZzl.containsKey(obj) : zzw(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.zzg; i10++) {
            if (zzfur.zza(obj, zzC()[i10])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzfwu zzfwuVar = new zzfwu(this);
        this.zzi = zzfwuVar;
        return zzfwuVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.get(obj);
        }
        int iZzw = zzw(obj);
        if (iZzw == -1) {
            return null;
        }
        return zzC()[iZzw];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzfwx zzfwxVar = new zzfwx(this);
        this.zzh = zzfwxVar;
        return zzfwxVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iMin;
        if (zzr()) {
            zzfuu.zzk(zzr(), "Arrays already allocated");
            int i10 = this.zzf;
            int iMax = Math.max(i10 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzfxb.zzd(iMax2);
            zzz(iMax2 - 1);
            this.zza = new int[i10];
            this.zzb = new Object[i10];
            this.zzc = new Object[i10];
        }
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.put(obj, obj2);
        }
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int i11 = this.zzg;
        int i12 = i11 + 1;
        int iZzb = zzfxj.zzb(obj);
        int iZzv = zzv();
        int i13 = iZzb & iZzv;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int iZzc = zzfxb.zzc(obj3, i13);
        if (iZzc != 0) {
            int i14 = ~iZzv;
            int i15 = iZzb & i14;
            int i16 = 0;
            while (true) {
                int i17 = iZzc - 1;
                int i18 = iArrZzA[i17];
                int i19 = i18 & i14;
                if (i19 == i15 && zzfur.zza(obj, objArrZzB[i17])) {
                    Object obj4 = objArrZzC[i17];
                    objArrZzC[i17] = obj2;
                    return obj4;
                }
                int i20 = i18 & iZzv;
                i16++;
                if (i20 != 0) {
                    iZzc = i20;
                } else {
                    if (i16 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                        int iZze = zze();
                        while (iZze >= 0) {
                            linkedHashMap.put(zzB()[iZze], zzC()[iZze]);
                            iZze = zzf(iZze);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i12 > iZzv) {
                        iZzv = zzx(iZzv, zzfxb.zza(iZzv), iZzb, i11);
                    } else {
                        iArrZzA[i17] = (i12 & iZzv) | i19;
                    }
                }
            }
        } else if (i12 > iZzv) {
            iZzv = zzx(iZzv, zzfxb.zza(iZzv), iZzb, i11);
        } else {
            Object obj5 = this.zze;
            Objects.requireNonNull(obj5);
            zzfxb.zze(obj5, i13, i12);
        }
        int length = zzA().length;
        if (i12 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzA(), iMin);
            this.zzb = Arrays.copyOf(zzB(), iMin);
            this.zzc = Arrays.copyOf(zzC(), iMin);
        }
        zzA()[i11] = (~iZzv) & iZzb;
        zzB()[i11] = obj;
        zzC()[i11] = obj2;
        this.zzg = i12;
        zzo();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.remove(obj);
        }
        Object objZzy = zzy(obj);
        if (objZzy == zzd) {
            return null;
        }
        return objZzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzl = zzl();
        return mapZzl != null ? mapZzl.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzfwz zzfwzVar = new zzfwz(this);
        this.zzj = zzfwzVar;
        return zzfwzVar;
    }

    final int zze() {
        return isEmpty() ? -1 : 0;
    }

    final int zzf(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.zzg) {
            return i11;
        }
        return -1;
    }

    final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void zzo() {
        this.zzf += 32;
    }

    final void zzp(int i10) {
        this.zzf = zzgap.zzc(i10, 1, 1073741823);
    }

    final void zzq(int i10, int i11) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int size = size() - 1;
        if (i10 >= size) {
            objArrZzB[i10] = null;
            objArrZzC[i10] = null;
            iArrZzA[i10] = 0;
            return;
        }
        int i12 = i10 + 1;
        Object obj2 = objArrZzB[size];
        objArrZzB[i10] = obj2;
        objArrZzC[i10] = objArrZzC[size];
        objArrZzB[size] = null;
        objArrZzC[size] = null;
        iArrZzA[i10] = iArrZzA[size];
        iArrZzA[size] = 0;
        int iZzb = zzfxj.zzb(obj2) & i11;
        int iZzc = zzfxb.zzc(obj, iZzb);
        int i13 = size + 1;
        if (iZzc == i13) {
            zzfxb.zze(obj, iZzb, i12);
            return;
        }
        while (true) {
            int i14 = iZzc - 1;
            int i15 = iArrZzA[i14];
            int i16 = i15 & i11;
            if (i16 == i13) {
                iArrZzA[i14] = (i15 & (~i11)) | (i11 & i12);
                return;
            }
            iZzc = i16;
        }
    }

    final boolean zzr() {
        return this.zze == null;
    }

    zzfxa(int i10) {
        zzp(8);
    }
}
