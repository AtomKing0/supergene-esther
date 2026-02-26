package androidx.core.net;

import android.net.Uri;
import com.ironsource.v8;
import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Uri.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        if (!t.d(uri.getScheme(), v8.h.f15781b)) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String str) {
        return Uri.parse(str);
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        return Uri.fromFile(file);
    }
}
