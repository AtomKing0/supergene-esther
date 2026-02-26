package z0;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import r0.h;
import y0.g;
import y0.n;
import y0.o;
import y0.r;

/* JADX INFO: compiled from: HttpUriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements n<Uri, InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f36965b = Collections.unmodifiableSet(new HashSet(Arrays.asList(ProxyConfig.MATCH_HTTP, "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<g, InputStream> f36966a;

    /* JADX INFO: compiled from: HttpUriLoader.java */
    public static class a implements o<Uri, InputStream> {
        @Override // y0.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new b(rVar.d(g.class, InputStream.class));
        }
    }

    public b(n<g, InputStream> nVar) {
        this.f36966a = nVar;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(@NonNull Uri uri, int i10, int i11, @NonNull h hVar) {
        return this.f36966a.b(new g(uri.toString()), i10, i11, hVar);
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return f36965b.contains(uri.getScheme());
    }
}
