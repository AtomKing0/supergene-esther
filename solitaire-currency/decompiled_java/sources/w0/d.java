package w0;

import java.io.File;
import w0.a;

/* JADX INFO: compiled from: DiskLruCacheFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements a.InterfaceC0717a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f35290b;

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    public interface a {
        File a();
    }

    public d(a aVar, long j10) {
        this.f35289a = j10;
        this.f35290b = aVar;
    }

    @Override // w0.a.InterfaceC0717a
    public w0.a build() {
        File fileA = this.f35290b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.c(fileA, this.f35289a);
        }
        return null;
    }
}
