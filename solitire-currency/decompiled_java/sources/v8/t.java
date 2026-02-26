package v8;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t<T> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f35208b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f35209a;

    /* JADX INFO: compiled from: Result.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final Throwable f35210a;

        public b(@NotNull Throwable exception) {
            kotlin.jvm.internal.t.i(exception, "exception");
            this.f35210a = exception;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.t.d(this.f35210a, ((b) obj).f35210a);
        }

        public int hashCode() {
            return this.f35210a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + this.f35210a + ')';
        }
    }

    private /* synthetic */ t(Object obj) {
        this.f35209a = obj;
    }

    public static final /* synthetic */ t a(Object obj) {
        return new t(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof t) && kotlin.jvm.internal.t.d(obj, ((t) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.t.d(obj, obj2);
    }

    @Nullable
    public static final Throwable e(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f35210a;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof b;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof b);
    }

    @NotNull
    public static String i(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f35209a, obj);
    }

    public int hashCode() {
        return f(this.f35209a);
    }

    public final /* synthetic */ Object j() {
        return this.f35209a;
    }

    @NotNull
    public String toString() {
        return i(this.f35209a);
    }

    @NotNull
    public static <T> Object b(@Nullable Object obj) {
        return obj;
    }
}
