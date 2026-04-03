package z3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StatsDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f37444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f37445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f37446c = Uri.EMPTY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, List<String>> f37447d = Collections.emptyMap();

    public l0(k kVar) {
        this.f37444a = (k) a4.a.e(kVar);
    }

    @Override // z3.k
    public long a(o oVar) throws IOException {
        this.f37446c = oVar.f37463a;
        this.f37447d = Collections.emptyMap();
        long jA = this.f37444a.a(oVar);
        this.f37446c = (Uri) a4.a.e(getUri());
        this.f37447d = getResponseHeaders();
        return jA;
    }

    @Override // z3.k
    public void b(m0 m0Var) {
        a4.a.e(m0Var);
        this.f37444a.b(m0Var);
    }

    public long c() {
        return this.f37445b;
    }

    @Override // z3.k
    public void close() throws IOException {
        this.f37444a.close();
    }

    public Uri d() {
        return this.f37446c;
    }

    public Map<String, List<String>> e() {
        return this.f37447d;
    }

    public void f() {
        this.f37445b = 0L;
    }

    @Override // z3.k
    public Map<String, List<String>> getResponseHeaders() {
        return this.f37444a.getResponseHeaders();
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return this.f37444a.getUri();
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f37444a.read(bArr, i10, i11);
        if (i12 != -1) {
            this.f37445b += (long) i12;
        }
        return i12;
    }
}
