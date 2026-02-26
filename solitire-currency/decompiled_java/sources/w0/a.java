package w0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: DiskCache.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: w0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskCache.java */
    public interface InterfaceC0717a {
        @Nullable
        a build();
    }

    /* JADX INFO: compiled from: DiskCache.java */
    public interface b {
        boolean a(@NonNull File file);
    }

    @Nullable
    File a(r0.f fVar);

    void b(r0.f fVar, b bVar);
}
