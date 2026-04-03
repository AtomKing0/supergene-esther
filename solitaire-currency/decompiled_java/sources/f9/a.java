package f9;

import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends f {
    public /* synthetic */ a(File file, File file2, String str, int i10, kotlin.jvm.internal.k kVar) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(file, file2, str);
        t.i(file, "file");
    }
}
