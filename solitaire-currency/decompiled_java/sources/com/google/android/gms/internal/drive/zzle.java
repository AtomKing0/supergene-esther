package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class zzle extends zziw<Long> implements zzmc, RandomAccess {
    private static final zzle zztp;
    private int size;
    private long[] zztq;

    static {
        zzle zzleVar = new zzle(new long[0], 0);
        zztp = zzleVar;
        zzleVar.zzbp();
    }

    zzle() {
        this(new long[10], 0);
    }

    private final void zzk(int i10, long j10) {
        int i11;
        zzbq();
        if (i10 < 0 || i10 > (i11 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i10));
        }
        long[] jArr = this.zztq;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.zztq, i10, jArr2, i10 + 1, this.size - i10);
            this.zztq = jArr2;
        }
        this.zztq[i10] = j10;
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
        zzk(i10, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzle)) {
            return super.addAll(collection);
        }
        zzle zzleVar = (zzle) collection;
        int i10 = zzleVar.size;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.size;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.zztq;
        if (i12 > jArr.length) {
            this.zztq = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(zzleVar.zztq, 0, this.zztq, this.size, zzleVar.size);
        this.size = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzle)) {
            return super.equals(obj);
        }
        zzle zzleVar = (zzle) obj;
        if (this.size != zzleVar.size) {
            return false;
        }
        long[] jArr = zzleVar.zztq;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (this.zztq[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Long.valueOf(getLong(i10));
    }

    public final long getLong(int i10) {
        zzp(i10);
        return this.zztq[i10];
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzu = 1;
        for (int i10 = 0; i10 < this.size; i10++) {
            iZzu = (iZzu * 31) + zzkm.zzu(this.zztq[i10]);
        }
        return iZzu;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbq();
        for (int i10 = 0; i10 < this.size; i10++) {
            if (obj.equals(Long.valueOf(this.zztq[i10]))) {
                long[] jArr = this.zztq;
                System.arraycopy(jArr, i10 + 1, jArr, i10, (this.size - i10) - 1);
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
        long[] jArr = this.zztq;
        System.arraycopy(jArr, i11, jArr, i10, this.size - i11);
        this.size -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzbq();
        zzp(i10);
        long[] jArr = this.zztq;
        long j10 = jArr[i10];
        jArr[i10] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp zzr(int i10) {
        if (i10 >= this.size) {
            return new zzle(Arrays.copyOf(this.zztq, i10), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzv(long j10) {
        zzk(this.size, j10);
    }

    private zzle(long[] jArr, int i10) {
        this.zztq = jArr;
        this.size = i10;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        zzbq();
        zzp(i10);
        long[] jArr = this.zztq;
        long j10 = jArr[i10];
        if (i10 < this.size - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }
}
