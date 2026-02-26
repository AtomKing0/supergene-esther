package r;

import a0.j;
import android.net.Uri;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v.n;

/* JADX INFO: compiled from: UriKeyer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements b<Uri> {
    @Override // r.b
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(@NotNull Uri uri, @NotNull n nVar) {
        if (!t.d(uri.getScheme(), "android.resource")) {
            return uri.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append('-');
        sb.append(j.k(nVar.g().getResources().getConfiguration()));
        return sb.toString();
    }
}
