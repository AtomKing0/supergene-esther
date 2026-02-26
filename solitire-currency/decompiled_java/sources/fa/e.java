package fa;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import z9.j;

/* JADX INFO: compiled from: SerializersModuleCollector.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface e {

    /* JADX INFO: compiled from: SerializersModuleCollector.kt */
    public static final class a {

        /* JADX INFO: renamed from: fa.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SerializersModuleCollector.kt */
        static final class C0559a extends v implements l<List<? extends KSerializer<?>>, KSerializer<?>> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ KSerializer<T> f25775g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0559a(KSerializer<T> kSerializer) {
                super(1);
                this.f25775g = kSerializer;
            }

            @Override // h9.l
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final KSerializer<?> invoke(@NotNull List<? extends KSerializer<?>> it) {
                t.i(it, "it");
                return this.f25775g;
            }
        }

        public static <T> void a(@NotNull e eVar, @NotNull KClass<T> kClass, @NotNull KSerializer<T> serializer) {
            t.i(kClass, "kClass");
            t.i(serializer, "serializer");
            eVar.e(kClass, new C0559a(serializer));
        }
    }

    <Base> void a(@NotNull KClass<Base> kClass, @NotNull l<? super Base, ? extends j<? super Base>> lVar);

    <Base, Sub extends Base> void b(@NotNull KClass<Base> kClass, @NotNull KClass<Sub> kClass2, @NotNull KSerializer<Sub> kSerializer);

    <Base> void c(@NotNull KClass<Base> kClass, @NotNull l<? super String, ? extends z9.b<? extends Base>> lVar);

    <T> void d(@NotNull KClass<T> kClass, @NotNull KSerializer<T> kSerializer);

    <T> void e(@NotNull KClass<T> kClass, @NotNull l<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> lVar);
}
