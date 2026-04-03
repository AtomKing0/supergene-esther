package z2;

import java.util.Arrays;

/* JADX INFO: compiled from: NalUnitTargetBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f37333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f37335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f37336e;

    public u(int i10, int i11) {
        this.f37332a = i10;
        byte[] bArr = new byte[i11 + 3];
        this.f37335d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i10, int i11) {
        if (this.f37333b) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f37335d;
            int length = bArr2.length;
            int i13 = this.f37336e;
            if (length < i13 + i12) {
                this.f37335d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, this.f37335d, this.f37336e, i12);
            this.f37336e += i12;
        }
    }

    public boolean b(int i10) {
        if (!this.f37333b) {
            return false;
        }
        this.f37336e -= i10;
        this.f37333b = false;
        this.f37334c = true;
        return true;
    }

    public boolean c() {
        return this.f37334c;
    }

    public void d() {
        this.f37333b = false;
        this.f37334c = false;
    }

    public void e(int i10) {
        a4.a.g(!this.f37333b);
        boolean z10 = i10 == this.f37332a;
        this.f37333b = z10;
        if (z10) {
            this.f37336e = 3;
            this.f37334c = false;
        }
    }
}
