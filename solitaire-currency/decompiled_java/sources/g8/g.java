package g8;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CaseInsensitiveMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g<Value> implements Map<String, Value>, i9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<h, Value> f25889a = new LinkedHashMap();

    /* JADX INFO: compiled from: CaseInsensitiveMap.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<Map.Entry<h, Value>, Map.Entry<String, Value>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f25890g = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map.Entry<String, Value> invoke(@NotNull Map.Entry<h, Value> $receiver) {
            kotlin.jvm.internal.t.i($receiver, "$this$$receiver");
            return new o($receiver.getKey().a(), $receiver.getValue());
        }
    }

    /* JADX INFO: compiled from: CaseInsensitiveMap.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<Map.Entry<String, Value>, Map.Entry<h, Value>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f25891g = new b();

        b() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map.Entry<h, Value> invoke(@NotNull Map.Entry<String, Value> $receiver) {
            kotlin.jvm.internal.t.i($receiver, "$this$$receiver");
            return new o(y.a($receiver.getKey()), $receiver.getValue());
        }
    }

    /* JADX INFO: compiled from: CaseInsensitiveMap.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.l<h, String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f25892g = new c();

        c() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(@NotNull h $receiver) {
            kotlin.jvm.internal.t.i($receiver, "$this$$receiver");
            return $receiver.a();
        }
    }

    /* JADX INFO: compiled from: CaseInsensitiveMap.kt */
    static final class d extends kotlin.jvm.internal.v implements h9.l<String, h> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f25893g = new d();

        d() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke(@NotNull String $receiver) {
            kotlin.jvm.internal.t.i($receiver, "$this$$receiver");
            return y.a($receiver);
        }
    }

    public boolean a(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.f25889a.containsKey(new h(key));
    }

    @Nullable
    public Value b(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.f25889a.get(y.a(key));
    }

    @NotNull
    public Set<Map.Entry<String, Value>> c() {
        return new n(this.f25889a.entrySet(), a.f25890g, b.f25891g);
    }

    @Override // java.util.Map
    public void clear() {
        this.f25889a.clear();
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return a((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f25889a.containsValue(obj);
    }

    @NotNull
    public Set<String> e() {
        return new n(this.f25889a.keySet(), c.f25892g, d.f25893g);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Value>> entrySet() {
        return c();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        return kotlin.jvm.internal.t.d(((g) obj).f25889a, this.f25889a);
    }

    public int f() {
        return this.f25889a.size();
    }

    @NotNull
    public Collection<Value> g() {
        return this.f25889a.values();
    }

    @Override // java.util.Map
    public final /* bridge */ Value get(Object obj) {
        if (obj instanceof String) {
            return b((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    @Nullable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Value put(@NotNull String key, @NotNull Value value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        return this.f25889a.put(y.a(key), value);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f25889a.hashCode();
    }

    @Nullable
    public Value i(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.f25889a.remove(y.a(key));
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f25889a.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return e();
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends String, ? extends Value> from) {
        kotlin.jvm.internal.t.i(from, "from");
        for (Map.Entry<? extends String, ? extends Value> entry : from.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Value remove(Object obj) {
        if (obj instanceof String) {
            return i((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Value> values() {
        return g();
    }
}
