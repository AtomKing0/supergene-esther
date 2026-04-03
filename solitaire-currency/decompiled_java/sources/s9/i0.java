package s9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f33702a = a.f33703a;

    /* JADX INFO: compiled from: SharingStarted.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f33703a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private static final i0 f33704b = new j0();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private static final i0 f33705c = new k0();

        private a() {
        }

        public static /* synthetic */ i0 b(a aVar, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = 0;
            }
            if ((i10 & 2) != 0) {
                j11 = Long.MAX_VALUE;
            }
            return aVar.a(j10, j11);
        }

        @NotNull
        public final i0 a(long j10, long j11) {
            return new l0(j10, j11);
        }

        @NotNull
        public final i0 c() {
            return f33704b;
        }

        @NotNull
        public final i0 d() {
            return f33705c;
        }
    }

    @NotNull
    h<g0> a(@NotNull m0<Integer> m0Var);
}
