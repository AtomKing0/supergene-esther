package p2;

/* JADX INFO: compiled from: VorbisBitArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f32482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32485d;

    public g0(byte[] bArr) {
        this.f32482a = bArr;
        this.f32483b = bArr.length;
    }

    private void a() {
        int i10;
        int i11 = this.f32484c;
        a4.a.g(i11 >= 0 && (i11 < (i10 = this.f32483b) || (i11 == i10 && this.f32485d == 0)));
    }

    public int b() {
        return (this.f32484c * 8) + this.f32485d;
    }

    public boolean c() {
        boolean z10 = (((this.f32482a[this.f32484c] & 255) >> this.f32485d) & 1) == 1;
        e(1);
        return z10;
    }

    public int d(int i10) {
        int i11 = this.f32484c;
        int iMin = Math.min(i10, 8 - this.f32485d);
        int i12 = i11 + 1;
        int i13 = ((this.f32482a[i11] & 255) >> this.f32485d) & (255 >> (8 - iMin));
        while (iMin < i10) {
            i13 |= (this.f32482a[i12] & 255) << iMin;
            iMin += 8;
            i12++;
        }
        int i14 = i13 & ((-1) >>> (32 - i10));
        e(i10);
        return i14;
    }

    public void e(int i10) {
        int i11 = i10 / 8;
        int i12 = this.f32484c + i11;
        this.f32484c = i12;
        int i13 = this.f32485d + (i10 - (i11 * 8));
        this.f32485d = i13;
        if (i13 > 7) {
            this.f32484c = i12 + 1;
            this.f32485d = i13 - 8;
        }
        a();
    }
}
