package v0;

/* JADX INFO: compiled from: ByteArrayAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements a<byte[]> {
    @Override // v0.a
    public int a() {
        return 1;
    }

    @Override // v0.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // v0.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i10) {
        return new byte[i10];
    }

    @Override // v0.a
    public String getTag() {
        return "ByteArrayPool";
    }
}
