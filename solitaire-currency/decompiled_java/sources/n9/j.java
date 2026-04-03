package n9;

import kotlin.collections.m0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class j implements Iterable<Long>, i9.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f31731d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f31732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f31733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f31734c;

    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public j(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f31732a = j10;
        this.f31733b = c9.c.d(j10, j11, j12);
        this.f31734c = j12;
    }

    public final long b() {
        return this.f31732a;
    }

    public final long e() {
        return this.f31733b;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public m0 iterator() {
        return new k(this.f31732a, this.f31733b, this.f31734c);
    }
}
