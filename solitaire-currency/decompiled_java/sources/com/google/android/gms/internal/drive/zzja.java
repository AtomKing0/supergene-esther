package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class zzja extends zziw<Boolean> implements zzmc, RandomAccess {
    private static final zzja zzno;
    private int size;
    private boolean[] zznp;

    static {
        zzja zzjaVar = new zzja(new boolean[0], 0);
        zzno = zzjaVar;
        zzjaVar.zzbp();
    }

    zzja() {
        this(new boolean[10], 0);
    }

    private final void zza(int i10, boolean z10) {
        int i11;
        zzbq();
        if (i10 < 0 || i10 > (i11 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i10));
        }
        boolean[] zArr = this.zznp;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.zznp, i10, zArr2, i10 + 1, this.size - i10);
            this.zznp = zArr2;
        }
        this.zznp[i10] = z10;
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
        zza(i10, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzja)) {
            return super.addAll(collection);
        }
        zzja zzjaVar = (zzja) collection;
        int i10 = zzjaVar.size;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.size;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.zznp;
        if (i12 > zArr.length) {
            this.zznp = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy(zzjaVar.zznp, 0, this.zznp, this.size, zzjaVar.size);
        this.size = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void addBoolean(boolean z10) {
        zza(this.size, z10);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzja)) {
            return super.equals(obj);
        }
        zzja zzjaVar = (zzja) obj;
        if (this.size != zzjaVar.size) {
            return false;
        }
        boolean[] zArr = zzjaVar.zznp;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (this.zznp[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        zzp(i10);
        return Boolean.valueOf(this.zznp[i10]);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZze = 1;
        for (int i10 = 0; i10 < this.size; i10++) {
            iZze = (iZze * 31) + zzkm.zze(this.zznp[i10]);
        }
        return iZze;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbq();
        for (int i10 = 0; i10 < this.size; i10++) {
            if (obj.equals(Boolean.valueOf(this.zznp[i10]))) {
                boolean[] zArr = this.zznp;
                System.arraycopy(zArr, i10 + 1, zArr, i10, (this.size - i10) - 1);
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
        boolean[] zArr = this.zznp;
        System.arraycopy(zArr, i11, zArr, i10, this.size - i11);
        this.size -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzbq();
        zzp(i10);
        boolean[] zArr = this.zznp;
        boolean z10 = zArr[i10];
        zArr[i10] = zBooleanValue;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp zzr(int i10) {
        if (i10 >= this.size) {
            return new zzja(Arrays.copyOf(this.zznp, i10), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzja(boolean[] zArr, int i10) {
        this.zznp = zArr;
        this.size = i10;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        zzbq();
        zzp(i10);
        boolean[] zArr = this.zznp;
        boolean z10 = zArr[i10];
        if (i10 < this.size - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }
}
