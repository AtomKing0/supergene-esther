package ma;

import ga.e0;
import ga.x;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RealResponseBody.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f31492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f31493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ua.e f31494c;

    public h(@Nullable String str, long j10, @NotNull ua.e source) {
        t.i(source, "source");
        this.f31492a = str;
        this.f31493b = j10;
        this.f31494c = source;
    }

    @Override // ga.e0
    public long contentLength() {
        return this.f31493b;
    }

    @Override // ga.e0
    @Nullable
    public x contentType() {
        String str = this.f31492a;
        if (str == null) {
            return null;
        }
        return x.f26237e.b(str);
    }

    @Override // ga.e0
    @NotNull
    public ua.e source() {
        return this.f31494c;
    }
}
