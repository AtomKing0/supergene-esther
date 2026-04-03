package s;

import android.net.Uri;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v.n;

/* JADX INFO: compiled from: StringMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements d<String, Uri> {
    @Override // s.d
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Uri a(@NotNull String str, @NotNull n nVar) {
        Uri uri = Uri.parse(str);
        t.h(uri, "parse(this)");
        return uri;
    }
}
