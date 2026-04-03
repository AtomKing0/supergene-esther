package kotlinx.serialization.json;

import ea.v0;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.collections.d0;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonElement.kt */
/* JADX INFO: loaded from: classes5.dex */
@z9.h(with = s.class)
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, i9.a {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, JsonElement> f30031a;

    /* JADX INFO: compiled from: JsonElement.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<JsonObject> serializer() {
            return s.f30083a;
        }
    }

    /* JADX INFO: compiled from: JsonElement.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<Map.Entry<? extends String, ? extends JsonElement>, CharSequence> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f30032g = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(@NotNull Map.Entry<String, ? extends JsonElement> entry) {
            kotlin.jvm.internal.t.i(entry, "<name for destructuring parameter 0>");
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            v0.c(sb, key);
            sb.append(':');
            sb.append(value);
            String string = sb.toString();
            kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonObject(@NotNull Map<String, ? extends JsonElement> content) {
        super(null);
        kotlin.jvm.internal.t.i(content, "content");
        this.f30031a = content;
    }

    public boolean a(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.f30031a.containsKey(key);
    }

    public boolean b(@NotNull JsonElement value) {
        kotlin.jvm.internal.t.i(value, "value");
        return this.f30031a.containsValue(value);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement compute(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement computeIfAbsent(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement computeIfPresent(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return a((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof JsonElement) {
            return b((JsonElement) obj);
        }
        return false;
    }

    @Nullable
    public JsonElement e(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.f30031a.get(key);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, JsonElement>> entrySet() {
        return f();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return kotlin.jvm.internal.t.d(this.f30031a, obj);
    }

    @NotNull
    public Set<Map.Entry<String, JsonElement>> f() {
        return this.f30031a.entrySet();
    }

    @NotNull
    public Set<String> g() {
        return this.f30031a.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement get(Object obj) {
        if (obj instanceof String) {
            return e((String) obj);
        }
        return null;
    }

    public int h() {
        return this.f30031a.size();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f30031a.hashCode();
    }

    @NotNull
    public Collection<JsonElement> i() {
        return this.f30031a.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f30031a.isEmpty();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public JsonElement remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return g();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement merge(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement put(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement putIfAbsent(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement replace(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return h();
    }

    @NotNull
    public String toString() {
        return d0.r0(this.f30031a.entrySet(), ",", "{", "}", 0, null, a.f30032g, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<JsonElement> values() {
        return i();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
