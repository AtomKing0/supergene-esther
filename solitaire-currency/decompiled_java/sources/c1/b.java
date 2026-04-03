package c1;

import androidx.annotation.NonNull;
import o1.j;
import u0.v;

/* JADX INFO: compiled from: BytesResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements v<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f4491a;

    public b(byte[] bArr) {
        this.f4491a = (byte[]) j.d(bArr);
    }

    @Override // u0.v
    @NonNull
    public Class<byte[]> a() {
        return byte[].class;
    }

    @Override // u0.v
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f4491a;
    }

    @Override // u0.v
    public int getSize() {
        return this.f4491a.length;
    }

    @Override // u0.v
    public void recycle() {
    }
}
