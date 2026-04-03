package l2;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: PlayerId.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t1 f30416b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final a f30417a;

    /* JADX INFO: compiled from: PlayerId.java */
    @RequiresApi(31)
    private static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f30418b = new a(LogSessionId.LOG_SESSION_ID_NONE);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LogSessionId f30419a;

        public a(LogSessionId logSessionId) {
            this.f30419a = logSessionId;
        }
    }

    static {
        f30416b = a4.o0.f214a < 31 ? new t1() : new t1(a.f30418b);
    }

    public t1() {
        this((a) null);
        a4.a.g(a4.o0.f214a < 31);
    }

    @RequiresApi(31)
    public LogSessionId a() {
        return ((a) a4.a.e(this.f30417a)).f30419a;
    }

    @RequiresApi(31)
    public t1(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    private t1(@Nullable a aVar) {
        this.f30417a = aVar;
    }
}
