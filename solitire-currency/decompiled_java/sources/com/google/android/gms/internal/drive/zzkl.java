package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class zzkl extends zziw<Integer> implements zzmc, RandomAccess {
    private static final zzkl zzsl;
    private int size;
    private int[] zzsm;

    static {
        zzkl zzklVar = new zzkl(new int[0], 0);
        zzsl = zzklVar;
        zzklVar.zzbp();
    }

    zzkl() {
        this(new int[10], 0);
    }

    private final void zzo(int i10, int i11) {
        int i12;
        zzbq();
        if (i10 < 0 || i10 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i10));
        }
        int[] iArr = this.zzsm;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i12 - i10);
        } else {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.zzsm, i10, iArr2, i10 + 1, this.size - i10);
            this.zzsm = iArr2;
        }
        this.zzsm[i10] = i11;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    private final void zzp(int i10) {
        if (i10 < 0 || i10 >= this.size) {
            throw new IndexOutOfBoundsException(zzq(i10));
        }
    }

    private final String zzq(int i10) {
        int i11 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i10);
        sb.append(", Size:");
        sb.append(i11);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        zzo(i10, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzkl)) {
            return super.addAll(collection);
        }
        zzkl zzklVar = (zzkl) collection;
        int i10 = zzklVar.size;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.size;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.zzsm;
        if (i12 > iArr.length) {
            this.zzsm = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(zzklVar.zzsm, 0, this.zzsm, this.size, zzklVar.size);
        this.size = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkl)) {
            return super.equals(obj);
        }
        zzkl zzklVar = (zzkl) obj;
        if (this.size != zzklVar.size) {
            return false;
        }
        int[] iArr = zzklVar.zzsm;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (this.zzsm[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Integer.valueOf(getInt(i10));
    }

    public final int getInt(int i10) {
        zzp(i10);
        return this.zzsm[i10];
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.size; i11++) {
            i10 = (i10 * 31) + this.zzsm[i11];
        }
        return i10;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbq();
        for (int i10 = 0; i10 < this.size; i10++) {
            if (obj.equals(Integer.valueOf(this.zzsm[i10]))) {
                int[] iArr = this.zzsm;
                System.arraycopy(iArr, i10 + 1, iArr, i10, (this.size - i10) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i10, int i11) {
        zzbq();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzsm;
        System.arraycopy(iArr, i11, iArr, i10, this.size - i11);
        this.size -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzbq();
        zzp(i10);
        int[] iArr = this.zzsm;
        int i11 = iArr[i10];
        iArr[i10] = iIntValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzam(int i10) {
        zzo(this.size, i10);
    }

    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp zzr(int i10) {
        if (i10 >= this.size) {
            return new zzkl(Arrays.copyOf(this.zzsm, i10), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzkl(int[] iArr, int i10) {
        this.zzsm = iArr;
        this.size = i10;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        zzbq();
        zzp(i10);
        int[] iArr = this.zzsm;
        int i11 = iArr[i10];
        if (i10 < this.size - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }
}
