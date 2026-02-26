package k2;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: ParserException.java */
/* JADX INFO: loaded from: classes2.dex */
public class j2 extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f29195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29196b;

    protected j2(@Nullable String str, @Nullable Throwable th, boolean z10, int i10) {
        super(str, th);
        this.f29195a = z10;
        this.f29196b = i10;
    }

    public static j2 a(@Nullable String str, @Nullable Throwable th) {
        return new j2(str, th, true, 1);
    }

    public static j2 b(@Nullable String str, @Nullable Throwable th) {
        return new j2(str, th, true, 0);
    }

    public static j2 c(@Nullable String str) {
        return new j2(str, null, false, 1);
    }
}
