package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineStart.kt */
/* JADX INFO: loaded from: classes5.dex */
public enum q0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* JADX INFO: compiled from: CoroutineStart.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29973a;

        static {
            int[] iArr = new int[q0.values().length];
            try {
                iArr[q0.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q0.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[q0.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[q0.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f29973a = iArr;
        }
    }

    public final <R, T> void c(@NotNull h9.p<? super R, ? super z8.d<? super T>, ? extends Object> pVar, R r10, @NotNull z8.d<? super T> dVar) throws Throwable {
        int i10 = a.f29973a[ordinal()];
        if (i10 == 1) {
            v9.a.d(pVar, r10, dVar, null, 4, null);
            return;
        }
        if (i10 == 2) {
            z8.f.b(pVar, r10, dVar);
        } else if (i10 == 3) {
            v9.b.a(pVar, r10, dVar);
        } else if (i10 != 4) {
            throw new v8.q();
        }
    }

    public final boolean d() {
        return this == LAZY;
    }
}
