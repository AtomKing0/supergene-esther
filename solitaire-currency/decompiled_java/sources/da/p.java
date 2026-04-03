package da;

import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Caching.kt */
/* JADX INFO: loaded from: classes5.dex */
final class p<T> implements t1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.l<KClass<?>, KSerializer<T>> f24607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a f24608b;

    /* JADX INFO: compiled from: Caching.kt */
    public static final class a extends ClassValue<k<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p<T> f24609a;

        a(p<T> pVar) {
            this.f24609a = pVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ClassValue
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k<T> computeValue(@NotNull Class<?> type) {
            kotlin.jvm.internal.t.i(type, "type");
            return new k<>((KSerializer) ((p) this.f24609a).f24607a.invoke(g9.a.c(type)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull h9.l<? super KClass<?>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.t.i(compute, "compute");
        this.f24607a = compute;
        this.f24608b = c();
    }

    private final a c() {
        return new a(this);
    }

    @Override // da.t1
    @Nullable
    public KSerializer<T> a(@NotNull KClass<Object> key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.f24608b.get(g9.a.a(key)).f24590a;
    }
}
