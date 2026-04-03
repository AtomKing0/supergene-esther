package v0;

/* JADX INFO: compiled from: IntegerArrayAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements a<int[]> {
    @Override // v0.a
    public int a() {
        return 4;
    }

    @Override // v0.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // v0.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i10) {
        return new int[i10];
    }

    @Override // v0.a
    public String getTag() {
        return "IntegerArrayPool";
    }
}
