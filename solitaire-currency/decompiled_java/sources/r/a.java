package r;

import java.io.File;
import org.jetbrains.annotations.NotNull;
import v.n;

/* JADX INFO: compiled from: FileKeyer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements b<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f33231a;

    public a(boolean z10) {
        this.f33231a = z10;
    }

    @Override // r.b
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(@NotNull File file, @NotNull n nVar) {
        if (!this.f33231a) {
            return file.getPath();
        }
        return file.getPath() + ':' + file.lastModified();
    }
}
