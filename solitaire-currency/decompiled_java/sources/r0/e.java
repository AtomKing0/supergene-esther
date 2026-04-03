package r0;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: HttpException.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f33246a;

    public e(int i10) {
        this("Http request failed with status code: " + i10, i10);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i10) {
        this(str, i10, null);
    }

    public e(String str, int i10, @Nullable Throwable th) {
        super(str, th);
        this.f33246a = i10;
    }
}
