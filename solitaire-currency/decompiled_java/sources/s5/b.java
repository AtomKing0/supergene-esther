package s5;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* JADX INFO: compiled from: LengthCountingOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f33559a = 0;

    b() {
    }

    long a() {
        return this.f33559a;
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f33559a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f33559a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 >= 0 && i10 <= bArr.length && i11 >= 0 && (i12 = i10 + i11) <= bArr.length && i12 >= 0) {
            this.f33559a += (long) i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
