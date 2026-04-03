package r9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f33392b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final c f33393c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f33394a;

    /* JADX INFO: compiled from: Channel.kt */
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Throwable f33395a;

        public a(@Nullable Throwable th) {
            this.f33395a = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.t.d(this.f33395a, ((a) obj).f33395a);
        }

        public int hashCode() {
            Throwable th = this.f33395a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // r9.h.c
        @NotNull
        public String toString() {
            return "Closed(" + this.f33395a + ')';
        }
    }

    /* JADX INFO: compiled from: Channel.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final <E> Object a(@Nullable Throwable th) {
            return h.c(new a(th));
        }

        @NotNull
        public final <E> Object b() {
            return h.c(h.f33393c);
        }

        @NotNull
        public final <E> Object c(E e10) {
            return h.c(e10);
        }
    }

    /* JADX INFO: compiled from: Channel.kt */
    public static class c {
        @NotNull
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ h(Object obj) {
        this.f33394a = obj;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof h) && kotlin.jvm.internal.t.d(obj, ((h) obj2).k());
    }

    @Nullable
    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f33395a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final T f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    @NotNull
    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f33394a, obj);
    }

    public int hashCode() {
        return g(this.f33394a);
    }

    public final /* synthetic */ Object k() {
        return this.f33394a;
    }

    @NotNull
    public String toString() {
        return j(this.f33394a);
    }

    @NotNull
    public static <T> Object c(@Nullable Object obj) {
        return obj;
    }
}
