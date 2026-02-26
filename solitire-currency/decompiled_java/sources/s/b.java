package s;

import a0.j;
import android.net.Uri;
import com.ironsource.v8;
import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;
import v.n;

/* JADX INFO: compiled from: FileUriMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements d<Uri, File> {
    private final boolean b(Uri uri) {
        if (j.q(uri)) {
            return false;
        }
        String scheme = uri.getScheme();
        if (!(scheme == null || t.d(scheme, v8.h.f15781b))) {
            return false;
        }
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        return r.H0(path, '/', false, 2, null) && j.h(uri) != null;
    }

    @Override // s.d
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public File a(@NotNull Uri uri, @NotNull n nVar) {
        if (!b(uri)) {
            return null;
        }
        if (uri.getScheme() != null) {
            uri = uri.buildUpon().scheme(null).build();
        }
        return new File(uri.toString());
    }
}
