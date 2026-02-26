package n9;

import kotlin.collections.s;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a implements Iterable<Character>, i9.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0632a f31709d = new C0632a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f31710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f31711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f31712c;

    /* JADX INFO: renamed from: n9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Progressions.kt */
    public static final class C0632a {
        private C0632a() {
        }

        public /* synthetic */ C0632a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f31710a = c10;
        this.f31711b = (char) c9.c.c(c10, c11, i10);
        this.f31712c = i10;
    }

    public final char b() {
        return this.f31710a;
    }

    public final char e() {
        return this.f31711b;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public s iterator() {
        return new b(this.f31710a, this.f31711b, this.f31712c);
    }
}
