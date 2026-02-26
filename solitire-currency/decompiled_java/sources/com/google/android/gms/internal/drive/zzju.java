package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class zzju extends zziw<Double> implements zzmc, RandomAccess {
    private static final zzju zzoi;
    private int size;
    private double[] zzoj;

    static {
        zzju zzjuVar = new zzju(new double[0], 0);
        zzoi = zzjuVar;
        zzjuVar.zzbp();
    }

    zzju() {
        this(new double[10], 0);
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
        zzc(i10, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzju)) {
            return super.addAll(collection);
        }
        zzju zzjuVar = (zzju) collection;
        int i10 = zzjuVar.size;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.size;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        double[] dArr = this.zzoj;
        if (i12 > dArr.length) {
            this.zzoj = Arrays.copyOf(dArr, i12);
        }
        System.arraycopy(zzjuVar.zzoj, 0, this.zzoj, this.size, zzjuVar.size);
        this.size = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzju)) {
            return super.equals(obj);
        }
        zzju zzjuVar = (zzju) obj;
        if (this.size != zzjuVar.size) {
            return false;
        }
        double[] dArr = zzjuVar.zzoj;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (Double.doubleToLongBits(this.zzoj[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        zzp(i10);
        return Double.valueOf(this.zzoj[i10]);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzu = 1;
        for (int i10 = 0; i10 < this.size; i10++) {
            iZzu = (iZzu * 31) + zzkm.zzu(Double.doubleToLongBits(this.zzoj[i10]));
        }
        return iZzu;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbq();
        for (int i10 = 0; i10 < this.size; i10++) {
            if (obj.equals(Double.valueOf(this.zzoj[i10]))) {
                double[] dArr = this.zzoj;
                System.arraycopy(dArr, i10 + 1, dArr, i10, (this.size - i10) - 1);
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
        double[] dArr = this.zzoj;
        System.arraycopy(dArr, i11, dArr, i10, this.size - i11);
        this.size -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzbq();
        zzp(i10);
        double[] dArr = this.zzoj;
        double d10 = dArr[i10];
        dArr[i10] = dDoubleValue;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzc(double d10) {
        zzc(this.size, d10);
    }

    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp zzr(int i10) {
        if (i10 >= this.size) {
            return new zzju(Arrays.copyOf(this.zzoj, i10), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzju(double[] dArr, int i10) {
        this.zzoj = dArr;
        this.size = i10;
    }

    private final void zzc(int i10, double d10) {
        int i11;
        zzbq();
        if (i10 < 0 || i10 > (i11 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i10));
        }
        double[] dArr = this.zzoj;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[((i11 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            System.arraycopy(this.zzoj, i10, dArr2, i10 + 1, this.size - i10);
            this.zzoj = dArr2;
        }
        this.zzoj[i10] = d10;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        zzbq();
        zzp(i10);
        double[] dArr = this.zzoj;
        double d10 = dArr[i10];
        if (i10 < this.size - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (r3 - i10) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }
}
