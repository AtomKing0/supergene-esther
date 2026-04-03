package z9;

import da.f1;
import da.t1;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SerializersCache.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final t1<? extends Object> f37623a = da.m.a(c.f37629g);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final t1<Object> f37624b = da.m.a(d.f37630g);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final f1<? extends Object> f37625c = da.m.b(a.f37627g);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final f1<Object> f37626d = da.m.b(b.f37628g);

    /* JADX INFO: compiled from: SerializersCache.kt */
    static final class a extends v implements p<KClass<Object>, List<? extends KType>, KSerializer<? extends Object>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f37627g = new a();

        a() {
            super(2);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KSerializer<? extends Object> mo4invoke(@NotNull KClass<Object> clazz, @NotNull List<? extends KType> types) {
            t.i(clazz, "clazz");
            t.i(types, "types");
            List<KSerializer<Object>> listE = l.e(fa.d.a(), types, true);
            t.f(listE);
            return l.a(clazz, types, listE);
        }
    }

    /* JADX INFO: compiled from: SerializersCache.kt */
    static final class b extends v implements p<KClass<Object>, List<? extends KType>, KSerializer<Object>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f37628g = new b();

        b() {
            super(2);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KSerializer<Object> mo4invoke(@NotNull KClass<Object> clazz, @NotNull List<? extends KType> types) {
            KSerializer<Object> kSerializerS;
            t.i(clazz, "clazz");
            t.i(types, "types");
            List<KSerializer<Object>> listE = l.e(fa.d.a(), types, true);
            t.f(listE);
            KSerializer<? extends Object> kSerializerA = l.a(clazz, types, listE);
            if (kSerializerA == null || (kSerializerS = aa.a.s(kSerializerA)) == null) {
                return null;
            }
            return kSerializerS;
        }
    }

    /* JADX INFO: compiled from: SerializersCache.kt */
    static final class c extends v implements h9.l<KClass<?>, KSerializer<? extends Object>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f37629g = new c();

        c() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KSerializer<? extends Object> invoke(@NotNull KClass<?> it) {
            t.i(it, "it");
            return l.d(it);
        }
    }

    /* JADX INFO: compiled from: SerializersCache.kt */
    static final class d extends v implements h9.l<KClass<?>, KSerializer<Object>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f37630g = new d();

        d() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KSerializer<Object> invoke(@NotNull KClass<?> it) {
            KSerializer<Object> kSerializerS;
            t.i(it, "it");
            KSerializer kSerializerD = l.d(it);
            if (kSerializerD == null || (kSerializerS = aa.a.s(kSerializerD)) == null) {
                return null;
            }
            return kSerializerS;
        }
    }

    @Nullable
    public static final KSerializer<Object> a(@NotNull KClass<Object> clazz, boolean z10) {
        t.i(clazz, "clazz");
        if (z10) {
            return f37624b.a(clazz);
        }
        KSerializer<? extends Object> kSerializerA = f37623a.a(clazz);
        if (kSerializerA != null) {
            return kSerializerA;
        }
        return null;
    }

    @NotNull
    public static final Object b(@NotNull KClass<Object> clazz, @NotNull List<? extends KType> types, boolean z10) {
        t.i(clazz, "clazz");
        t.i(types, "types");
        return !z10 ? f37625c.a(clazz, types) : f37626d.a(clazz, types);
    }
}
