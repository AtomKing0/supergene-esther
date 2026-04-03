package n;

import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.j;
import ua.q0;

/* JADX INFO: compiled from: DiskCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskCache.kt */
    public static final class C0629a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private q0 f31502a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f31507f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private j f31503b = j.f34780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f31504c = 0.02d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f31505d = 10485760;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f31506e = 262144000;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private k0 f31508g = e1.b();

        @NotNull
        public final a a() {
            long jP;
            q0 q0Var = this.f31502a;
            if (q0Var == null) {
                throw new IllegalStateException("directory == null".toString());
            }
            if (this.f31504c > 0.0d) {
                try {
                    StatFs statFs = new StatFs(q0Var.toFile().getAbsolutePath());
                    jP = o.p((long) (this.f31504c * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), this.f31505d, this.f31506e);
                } catch (Exception unused) {
                    jP = this.f31505d;
                }
            } else {
                jP = this.f31507f;
            }
            return new d(jP, q0Var, this.f31503b, this.f31508g);
        }

        @NotNull
        public final C0629a b(@NotNull File file) {
            return c(q0.a.d(q0.f34806b, file, false, 1, null));
        }

        @NotNull
        public final C0629a c(@NotNull q0 q0Var) {
            this.f31502a = q0Var;
            return this;
        }
    }

    /* JADX INFO: compiled from: DiskCache.kt */
    public interface b {
        void a();

        @Nullable
        c b();

        @NotNull
        q0 getData();

        @NotNull
        q0 getMetadata();
    }

    /* JADX INFO: compiled from: DiskCache.kt */
    public interface c extends Closeable {
        @NotNull
        q0 getData();

        @NotNull
        q0 getMetadata();

        @Nullable
        b u0();
    }

    @Nullable
    b a(@NotNull String str);

    @Nullable
    c get(@NotNull String str);

    @NotNull
    j getFileSystem();
}
