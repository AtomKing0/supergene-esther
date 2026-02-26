package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgao extends AbstractList implements RandomAccess, Serializable {
    final int[] zza;
    final int zzb;
    final int zzc;

    zzgao(int[] iArr, int i10, int i11) {
        this.zza = iArr;
        this.zzb = i10;
        this.zzc = i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return (obj instanceof Integer) && zzgap.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc) != -1;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgao)) {
            return super.equals(obj);
        }
        zzgao zzgaoVar = (zzgao) obj;
        int i10 = this.zzc - this.zzb;
        if (zzgaoVar.zzc - zzgaoVar.zzb != i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.zza[this.zzb + i11] != zzgaoVar.zza[zzgaoVar.zzb + i11]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzfuu.zza(i10, this.zzc - this.zzb, "index");
        return Integer.valueOf(this.zza[this.zzb + i10]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = this.zzb; i11 < this.zzc; i11++) {
            i10 = (i10 * 31) + this.zza[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int iZza;
        if (!(obj instanceof Integer) || (iZza = zzgap.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc)) < 0) {
            return -1;
        }
        return iZza - this.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.zza;
            int iIntValue = ((Integer) obj).intValue();
            int i10 = this.zzb;
            int i11 = this.zzc - 1;
            while (true) {
                if (i11 < i10) {
                    i11 = -1;
                    break;
                }
                if (iArr[i11] == iIntValue) {
                    break;
                }
                i11--;
            }
            if (i11 >= 0) {
                return i11 - this.zzb;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        Integer num = (Integer) obj;
        zzfuu.zza(i10, this.zzc - this.zzb, "index");
        int[] iArr = this.zza;
        int i11 = this.zzb + i10;
        int i12 = iArr[i11];
        num.getClass();
        iArr[i11] = num.intValue();
        return Integer.valueOf(i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc - this.zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i10, int i11) {
        zzfuu.zzi(i10, i11, this.zzc - this.zzb);
        if (i10 == i11) {
            return Collections.emptyList();
        }
        int[] iArr = this.zza;
        int i12 = this.zzb;
        return new zzgao(iArr, i12 + i10, i11 + i12);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder((this.zzc - this.zzb) * 5);
        sb.append('[');
        sb.append(this.zza[this.zzb]);
        int i10 = this.zzb;
        while (true) {
            i10++;
            if (i10 >= this.zzc) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.zza[i10]);
        }
    }
}
