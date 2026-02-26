package p;

import android.webkit.MimeTypeMap;
import java.io.File;
import m.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import ua.q0;
import v.n;

/* JADX INFO: compiled from: FileFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final File f32348a;

    /* JADX INFO: compiled from: FileFetcher.kt */
    public static final class a implements i.a<File> {
        @Override // p.i.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull File file, @NotNull n nVar, @NotNull j.e eVar) {
            return new j(file);
        }
    }

    public j(@NotNull File file) {
        this.f32348a = file;
    }

    @Override // p.i
    @Nullable
    public Object a(@NotNull z8.d<? super h> dVar) {
        return new m(q.d(q0.a.d(q0.f34806b, this.f32348a, false, 1, null), null, null, null, 14, null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(f9.m.q(this.f32348a)), m.f.DISK);
    }
}
