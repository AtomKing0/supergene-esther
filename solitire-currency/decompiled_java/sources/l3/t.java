package l3;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: LoadEventInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicLong f30693h = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.o f30695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f30696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f30697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f30698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f30699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f30700g;

    public t(long j10, z3.o oVar, long j11) {
        this(j10, oVar, oVar.f37463a, Collections.emptyMap(), j11, 0L, 0L);
    }

    public static long a() {
        return f30693h.getAndIncrement();
    }

    public t(long j10, z3.o oVar, Uri uri, Map<String, List<String>> map, long j11, long j12, long j13) {
        this.f30694a = j10;
        this.f30695b = oVar;
        this.f30696c = uri;
        this.f30697d = map;
        this.f30698e = j11;
        this.f30699f = j12;
        this.f30700g = j13;
    }
}
