package bo.app;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class vu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f4138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public nr f4140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f4142f;

    public vu(String str, int i10, File file) {
        this.f4137a = str;
        this.f4141e = i10;
        this.f4142f = file;
        this.f4138b = new long[i10];
    }

    public final File a(int i10) {
        return new File(this.f4142f, this.f4137a + "." + i10 + ".tmp");
    }
}
