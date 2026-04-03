package n9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends n9.a implements f<Character> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f31717e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final c f31718f = new c(1, 0);

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (b() != cVar.b() || e() != cVar.e()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(char c10) {
        return t.k(b(), c10) <= 0 && t.k(c10, e()) <= 0;
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Character getEndInclusive() {
        return Character.valueOf(e());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + e();
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Character getStart() {
        return Character.valueOf(b());
    }

    @Override // n9.f
    public boolean isEmpty() {
        return t.k(b(), e()) > 0;
    }

    @NotNull
    public String toString() {
        return b() + ".." + e();
    }
}
