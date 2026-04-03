package v;

import java.util.Map;
import kotlin.collections.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tags.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f34970b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final s f34971c = new s(r0.g());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<Class<?>, Object> f34972a;

    /* JADX INFO: compiled from: Tags.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final s a(@NotNull Map<Class<?>, ? extends Object> map) {
            return new s(a0.c.b(map), null);
        }
    }

    public /* synthetic */ s(Map map, kotlin.jvm.internal.k kVar) {
        this(map);
    }

    @NotNull
    public final Map<Class<?>, Object> a() {
        return this.f34972a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && kotlin.jvm.internal.t.d(this.f34972a, ((s) obj).f34972a);
    }

    public int hashCode() {
        return this.f34972a.hashCode();
    }

    @NotNull
    public String toString() {
        return "Tags(tags=" + this.f34972a + ')';
    }

    private s(Map<Class<?>, ? extends Object> map) {
        this.f34972a = map;
    }
}
