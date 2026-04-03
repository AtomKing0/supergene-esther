package z0;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;
import r0.h;
import y0.n;
import y0.o;
import y0.r;

/* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements n<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f36967a;

    /* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
    public static class a implements o<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f36968a;

        public a(Context context) {
            this.f36968a = context;
        }

        @Override // y0.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new c(this.f36968a);
        }
    }

    public c(Context context) {
        this.f36967a = context.getApplicationContext();
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(@NonNull Uri uri, int i10, int i11, @NonNull h hVar) {
        if (t0.b.d(i10, i11)) {
            return new n.a<>(new n1.b(uri), t0.c.f(this.f36967a, uri));
        }
        return null;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return t0.b.a(uri);
    }
}
