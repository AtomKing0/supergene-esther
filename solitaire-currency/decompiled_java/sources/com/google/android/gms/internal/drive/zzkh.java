package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class zzkh extends zziw<Float> implements zzmc, RandomAccess {
    private static final zzkh zzrm;
    private int size;
    private float[] zzrn;

    static {
        zzkh zzkhVar = new zzkh(new float[0], 0);
        zzrm = zzkhVar;
        zzkhVar.zzbp();
    }

    zzkh() {
        this(new float[10], 0);
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
        zzc(i10, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzkh)) {
            return super.addAll(collection);
        }
        zzkh zzkhVar = (zzkh) collection;
        int i10 = zzkhVar.size;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.size;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.zzrn;
        if (i12 > fArr.length) {
            this.zzrn = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy(zzkhVar.zzrn, 0, this.zzrn, this.size, zzkhVar.size);
        this.size = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkh)) {
            return super.equals(obj);
        }
        zzkh zzkhVar = (zzkh) obj;
        if (this.size != zzkhVar.size) {
            return false;
        }
        float[] fArr = zzkhVar.zzrn;
        for (int i10 = 0; i10 < this.size; i10++) {
            if (Float.floatToIntBits(this.zzrn[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        zzp(i10);
        return Float.valueOf(this.zzrn[i10]);
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i10 = 0; i10 < this.size; i10++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzrn[i10]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbq();
        for (int i10 = 0; i10 < this.size; i10++) {
            if (obj.equals(Float.valueOf(this.zzrn[i10]))) {
                float[] fArr = this.zzrn;
                System.arraycopy(fArr, i10 + 1, fArr, i10, (this.size - i10) - 1);
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
        float[] fArr = this.zzrn;
        System.arraycopy(fArr, i11, fArr, i10, this.size - i11);
        this.size -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzbq();
        zzp(i10);
        float[] fArr = this.zzrn;
        float f10 = fArr[i10];
        fArr[i10] = fFloatValue;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzc(float f10) {
        zzc(this.size, f10);
    }

    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp zzr(int i10) {
        if (i10 >= this.size) {
            return new zzkh(Arrays.copyOf(this.zzrn, i10), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzkh(float[] fArr, int i10) {
        this.zzrn = fArr;
        this.size = i10;
    }

    private final void zzc(int i10, float f10) {
        int i11;
        zzbq();
        if (i10 < 0 || i10 > (i11 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i10));
        }
        float[] fArr = this.zzrn;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[((i11 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.zzrn, i10, fArr2, i10 + 1, this.size - i10);
            this.zzrn = fArr2;
        }
        this.zzrn[i10] = f10;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        zzbq();
        zzp(i10);
        float[] fArr = this.zzrn;
        float f10 = fArr[i10];
        if (i10 < this.size - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }
}
