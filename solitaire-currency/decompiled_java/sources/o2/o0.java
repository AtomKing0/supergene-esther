package o2;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: MediaDrmCallbackException.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.o f31925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f31926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<String>> f31927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f31928d;

    public o0(z3.o oVar, Uri uri, Map<String, List<String>> map, long j10, Throwable th) {
        super(th);
        this.f31925a = oVar;
        this.f31926b = uri;
        this.f31927c = map;
        this.f31928d = j10;
    }
}
