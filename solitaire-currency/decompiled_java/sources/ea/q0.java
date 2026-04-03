package ea;

import ba.i;
import ba.j;
import fa.e;
import java.util.List;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PolymorphismValidator.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q0 implements fa.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f25474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f25475b;

    public q0(boolean z10, @NotNull String discriminator) {
        kotlin.jvm.internal.t.i(discriminator, "discriminator");
        this.f25474a = z10;
        this.f25475b = discriminator;
    }

    private final void f(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        int iD = serialDescriptor.d();
        for (int i10 = 0; i10 < iD; i10++) {
            String strE = serialDescriptor.e(i10);
            if (kotlin.jvm.internal.t.d(strE, this.f25475b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + kClass + " has property '" + strE + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    private final void g(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        ba.i kind = serialDescriptor.getKind();
        if ((kind instanceof ba.d) || kotlin.jvm.internal.t.d(kind, i.a.f2319a)) {
            throw new IllegalArgumentException("Serializer for " + kClass.getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.f25474a) {
            return;
        }
        if (kotlin.jvm.internal.t.d(kind, j.b.f2322a) || kotlin.jvm.internal.t.d(kind, j.c.f2323a) || (kind instanceof ba.e) || (kind instanceof i.b)) {
            throw new IllegalArgumentException("Serializer for " + kClass.getSimpleName() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
        }
    }

    @Override // fa.e
    public <Base> void a(@NotNull KClass<Base> baseClass, @NotNull h9.l<? super Base, ? extends z9.j<? super Base>> defaultSerializerProvider) {
        kotlin.jvm.internal.t.i(baseClass, "baseClass");
        kotlin.jvm.internal.t.i(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // fa.e
    public <Base, Sub extends Base> void b(@NotNull KClass<Base> baseClass, @NotNull KClass<Sub> actualClass, @NotNull KSerializer<Sub> actualSerializer) {
        kotlin.jvm.internal.t.i(baseClass, "baseClass");
        kotlin.jvm.internal.t.i(actualClass, "actualClass");
        kotlin.jvm.internal.t.i(actualSerializer, "actualSerializer");
        SerialDescriptor descriptor = actualSerializer.getDescriptor();
        g(descriptor, actualClass);
        if (this.f25474a) {
            return;
        }
        f(descriptor, actualClass);
    }

    @Override // fa.e
    public <Base> void c(@NotNull KClass<Base> baseClass, @NotNull h9.l<? super String, ? extends z9.b<? extends Base>> defaultDeserializerProvider) {
        kotlin.jvm.internal.t.i(baseClass, "baseClass");
        kotlin.jvm.internal.t.i(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // fa.e
    public <T> void d(@NotNull KClass<T> kClass, @NotNull KSerializer<T> kSerializer) {
        e.a.a(this, kClass, kSerializer);
    }

    @Override // fa.e
    public <T> void e(@NotNull KClass<T> kClass, @NotNull h9.l<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
        kotlin.jvm.internal.t.i(kClass, "kClass");
        kotlin.jvm.internal.t.i(provider, "provider");
    }
}
