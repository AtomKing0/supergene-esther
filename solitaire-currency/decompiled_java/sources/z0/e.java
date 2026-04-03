package z0;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.net.URL;
import r0.h;
import y0.g;
import y0.n;
import y0.o;
import y0.r;

/* JADX INFO: compiled from: UrlLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements n<URL, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<g, InputStream> f36971a;

    /* JADX INFO: compiled from: UrlLoader.java */
    public static class a implements o<URL, InputStream> {
        @Override // y0.o
        @NonNull
        public n<URL, InputStream> b(r rVar) {
            return new e(rVar.d(g.class, InputStream.class));
        }
    }

    public e(n<g, InputStream> nVar) {
        this.f36971a = nVar;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(@NonNull URL url, int i10, int i11, @NonNull h hVar) {
        return this.f36971a.b(new g(url), i10, i11, hVar);
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull URL url) {
        return true;
    }
}
