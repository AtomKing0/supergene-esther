package fa;

import da.g1;
import fa.a;
import h9.l;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.j;

/* JADX INFO: compiled from: SerializersModule.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<KClass<?>, a> f25770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> f25771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<KClass<?>, l<?, j<?>>> f25772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<KClass<?>, Map<String, KSerializer<?>>> f25773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Map<KClass<?>, l<String, z9.b<?>>> f25774e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Map<KClass<?>, ? extends a> class2ContextualFactory, @NotNull Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> polyBase2Serializers, @NotNull Map<KClass<?>, ? extends l<?, ? extends j<?>>> polyBase2DefaultSerializerProvider, @NotNull Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> polyBase2NamedSerializers, @NotNull Map<KClass<?>, ? extends l<? super String, ? extends z9.b<?>>> polyBase2DefaultDeserializerProvider) {
        super(null);
        t.i(class2ContextualFactory, "class2ContextualFactory");
        t.i(polyBase2Serializers, "polyBase2Serializers");
        t.i(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        t.i(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        t.i(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f25770a = class2ContextualFactory;
        this.f25771b = polyBase2Serializers;
        this.f25772c = polyBase2DefaultSerializerProvider;
        this.f25773d = polyBase2NamedSerializers;
        this.f25774e = polyBase2DefaultDeserializerProvider;
    }

    @Override // fa.c
    public void a(@NotNull e collector) {
        t.i(collector, "collector");
        for (Map.Entry<KClass<?>, a> entry : this.f25770a.entrySet()) {
            KClass<?> key = entry.getKey();
            a value = entry.getValue();
            if (value instanceof a.C0558a) {
                t.g(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer<?> kSerializerB = ((a.C0558a) value).b();
                t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.d(key, kSerializerB);
            } else if (value instanceof a.b) {
                collector.e(key, ((a.b) value).b());
            }
        }
        for (Map.Entry<KClass<?>, Map<KClass<?>, KSerializer<?>>> entry2 : this.f25771b.entrySet()) {
            KClass<?> key2 = entry2.getKey();
            for (Map.Entry<KClass<?>, KSerializer<?>> entry3 : entry2.getValue().entrySet()) {
                KClass<?> key3 = entry3.getKey();
                KSerializer<?> value2 = entry3.getValue();
                t.g(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                t.g(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                t.g(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.b(key2, key3, value2);
            }
        }
        for (Map.Entry<KClass<?>, l<?, j<?>>> entry4 : this.f25772c.entrySet()) {
            KClass<?> key4 = entry4.getKey();
            l<?, j<?>> value3 = entry4.getValue();
            t.g(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            t.g(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            collector.a(key4, (l) t0.f(value3, 1));
        }
        for (Map.Entry<KClass<?>, l<String, z9.b<?>>> entry5 : this.f25774e.entrySet()) {
            KClass<?> key5 = entry5.getKey();
            l<String, z9.b<?>> value4 = entry5.getValue();
            t.g(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            t.g(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            collector.c(key5, (l) t0.f(value4, 1));
        }
    }

    @Override // fa.c
    @Nullable
    public <T> KSerializer<T> b(@NotNull KClass<T> kClass, @NotNull List<? extends KSerializer<?>> typeArgumentsSerializers) {
        t.i(kClass, "kClass");
        t.i(typeArgumentsSerializers, "typeArgumentsSerializers");
        a aVar = this.f25770a.get(kClass);
        KSerializer<?> kSerializerA = aVar != null ? aVar.a(typeArgumentsSerializers) : null;
        if (kSerializerA instanceof KSerializer) {
            return (KSerializer<T>) kSerializerA;
        }
        return null;
    }

    @Override // fa.c
    @Nullable
    public <T> z9.b<? extends T> d(@NotNull KClass<? super T> baseClass, @Nullable String str) {
        t.i(baseClass, "baseClass");
        Map<String, KSerializer<?>> map = this.f25773d.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(str) : null;
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        l<String, z9.b<?>> lVar = this.f25774e.get(baseClass);
        l<String, z9.b<?>> lVar2 = t0.m(lVar, 1) ? lVar : null;
        if (lVar2 != null) {
            return (z9.b) lVar2.invoke(str);
        }
        return null;
    }

    @Override // fa.c
    @Nullable
    public <T> j<T> e(@NotNull KClass<? super T> baseClass, @NotNull T value) {
        t.i(baseClass, "baseClass");
        t.i(value, "value");
        if (!g1.i(value, baseClass)) {
            return null;
        }
        Map<KClass<?>, KSerializer<?>> map = this.f25771b.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(o0.b(value.getClass())) : null;
        if (!(kSerializer instanceof j)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        l<?, j<?>> lVar = this.f25772c.get(baseClass);
        l<?, j<?>> lVar2 = t0.m(lVar, 1) ? lVar : null;
        if (lVar2 != null) {
            return (j) lVar2.invoke(value);
        }
        return null;
    }
}
