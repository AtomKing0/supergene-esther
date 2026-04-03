package y0;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import y0.n;

/* JADX INFO: compiled from: UrlUriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class x<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f36344b = Collections.unmodifiableSet(new HashSet(Arrays.asList(ProxyConfig.MATCH_HTTP, "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<g, Data> f36345a;

    /* JADX INFO: compiled from: UrlUriLoader.java */
    public static class a implements o<Uri, InputStream> {
        @Override // y0.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f36345a = nVar;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(@NonNull Uri uri, int i10, int i11, @NonNull r0.h hVar) {
        return this.f36345a.b(new g(uri.toString()), i10, i11, hVar);
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return f36344b.contains(uri.getScheme());
    }
}
