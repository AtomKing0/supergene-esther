package q9;

import java.text.DecimalFormat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DurationJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f33182a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ThreadLocal<DecimalFormat>[] f33183b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal<>();
        }
        f33183b = threadLocalArr;
    }

    public static final boolean a() {
        return f33182a;
    }
}
