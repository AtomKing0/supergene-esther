package f9;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class f extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final File f25735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final File f25736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f25737c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(d.b(file, file2, str));
        t.i(file, "file");
        this.f25735a = file;
        this.f25736b = file2;
        this.f25737c = str;
    }
}
