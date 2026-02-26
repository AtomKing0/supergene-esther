package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPath.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPath_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final Path Path() {
        return new AndroidPath(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public static final android.graphics.Path asAndroidPath(@NotNull Path path) {
        kotlin.jvm.internal.t.i(path, "<this>");
        if (path instanceof AndroidPath) {
            return ((AndroidPath) path).getInternalPath();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @NotNull
    public static final Path asComposePath(@NotNull android.graphics.Path path) {
        kotlin.jvm.internal.t.i(path, "<this>");
        return new AndroidPath(path);
    }
}
