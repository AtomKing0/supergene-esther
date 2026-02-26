package ba;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SerialKinds.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i {

    /* JADX INFO: compiled from: SerialKinds.kt */
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f2319a = new a();

        private a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SerialKinds.kt */
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f2320a = new b();

        private b() {
            super(null);
        }
    }

    public /* synthetic */ i(k kVar) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NotNull
    public String toString() {
        String simpleName = o0.b(getClass()).getSimpleName();
        t.f(simpleName);
        return simpleName;
    }

    private i() {
    }
}
