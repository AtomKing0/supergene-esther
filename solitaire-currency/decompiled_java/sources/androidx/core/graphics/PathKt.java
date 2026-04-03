package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Path;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class PathKt {
    @NotNull
    public static final Path and(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    @NotNull
    public static final Iterable<PathSegment> flatten(@NotNull Path path, float f10) {
        return PathUtils.flatten(path, f10);
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.5f;
        }
        return flatten(path, f10);
    }

    @NotNull
    public static final Path minus(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @NotNull
    public static final Path or(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @NotNull
    public static final Path plus(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @NotNull
    public static final Path xor(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
