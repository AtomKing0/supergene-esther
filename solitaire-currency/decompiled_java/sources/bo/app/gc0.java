package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class gc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2896a = {1, 2, 3, 4};

    public static /* synthetic */ int a(int i10) {
        if (i10 != 0) {
            return i10 - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] b(int i10) {
        int[] iArr = new int[i10];
        System.arraycopy(f2896a, 0, iArr, 0, i10);
        return iArr;
    }
}
