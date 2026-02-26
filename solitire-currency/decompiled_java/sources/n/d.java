package n;

import kotlin.jvm.internal.k;
import kotlinx.coroutines.k0;
import n.a;
import n.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.f;
import ua.j;
import ua.q0;

/* JADX INFO: compiled from: RealDiskCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements n.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f31550e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f31551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final q0 f31552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final j f31553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final n.b f31554d;

    /* JADX INFO: compiled from: RealDiskCache.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: RealDiskCache.kt */
    private static final class b implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final b.C0630b f31555a;

        public b(@NotNull b.C0630b c0630b) {
            this.f31555a = c0630b;
        }

        @Override // n.a.b
        public void a() {
            this.f31555a.a();
        }

        @Override // n.a.b
        @Nullable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c b() {
            b.d dVarC = this.f31555a.c();
            if (dVarC != null) {
                return new c(dVarC);
            }
            return null;
        }

        @Override // n.a.b
        @NotNull
        public q0 getData() {
            return this.f31555a.f(1);
        }

        @Override // n.a.b
        @NotNull
        public q0 getMetadata() {
            return this.f31555a.f(0);
        }
    }

    /* JADX INFO: compiled from: RealDiskCache.kt */
    private static final class c implements a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final b.d f31556a;

        public c(@NotNull b.d dVar) {
            this.f31556a = dVar;
        }

        @Override // n.a.c
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b u0() {
            b.C0630b c0630bA = this.f31556a.a();
            if (c0630bA != null) {
                return new b(c0630bA);
            }
            return null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f31556a.close();
        }

        @Override // n.a.c
        @NotNull
        public q0 getData() {
            return this.f31556a.c(1);
        }

        @Override // n.a.c
        @NotNull
        public q0 getMetadata() {
            return this.f31556a.c(0);
        }
    }

    public d(long j10, @NotNull q0 q0Var, @NotNull j jVar, @NotNull k0 k0Var) {
        this.f31551a = j10;
        this.f31552b = q0Var;
        this.f31553c = jVar;
        this.f31554d = new n.b(getFileSystem(), b(), k0Var, c(), 1, 2);
    }

    private final String d(String str) {
        return f.f34755d.d(str).A().k();
    }

    @Override // n.a
    @Nullable
    public a.b a(@NotNull String str) {
        b.C0630b c0630bI0 = this.f31554d.I0(d(str));
        if (c0630bI0 != null) {
            return new b(c0630bI0);
        }
        return null;
    }

    @NotNull
    public q0 b() {
        return this.f31552b;
    }

    public long c() {
        return this.f31551a;
    }

    @Override // n.a
    @Nullable
    public a.c get(@NotNull String str) {
        b.d dVarJ0 = this.f31554d.J0(d(str));
        if (dVarJ0 != null) {
            return new c(dVarJ0);
        }
        return null;
    }

    @Override // n.a
    @NotNull
    public j getFileSystem() {
        return this.f31553c;
    }
}
