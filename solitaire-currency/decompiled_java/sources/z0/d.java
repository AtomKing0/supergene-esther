package z0;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b1.e0;
import java.io.InputStream;
import r0.h;
import y0.n;
import y0.o;
import y0.r;

/* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements n<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f36969a;

    /* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
    public static class a implements o<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f36970a;

        public a(Context context) {
            this.f36970a = context;
        }

        @Override // y0.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new d(this.f36970a);
        }
    }

    public d(Context context) {
        this.f36969a = context.getApplicationContext();
    }

    private boolean e(h hVar) {
        Long l10 = (Long) hVar.c(e0.f1831d);
        return l10 != null && l10.longValue() == -1;
    }

    @Override // y0.n
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(@NonNull Uri uri, int i10, int i11, @NonNull h hVar) {
        if (t0.b.d(i10, i11) && e(hVar)) {
            return new n.a<>(new n1.b(uri), t0.c.g(this.f36969a, uri));
        }
        return null;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return t0.b.c(uri);
    }
}
