package z9;

import ba.d;
import ba.i;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.p;

/* JADX INFO: compiled from: PolymorphicSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends da.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KClass<T> f37618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private List<? extends Annotation> f37619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final v8.l f37620c;

    /* JADX INFO: compiled from: PolymorphicSerializer.kt */
    static final class a extends v implements h9.a<SerialDescriptor> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e<T> f37621g;

        /* JADX INFO: renamed from: z9.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PolymorphicSerializer.kt */
        static final class C0768a extends v implements h9.l<ba.a, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e<T> f37622g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0768a(e<T> eVar) {
                super(1);
                this.f37622g = eVar;
            }

            public final void a(@NotNull ba.a buildSerialDescriptor) {
                t.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
                ba.a.b(buildSerialDescriptor, "type", aa.a.B(s0.f29840a).getDescriptor(), null, false, 12, null);
                ba.a.b(buildSerialDescriptor, "value", ba.h.d("kotlinx.serialization.Polymorphic<" + this.f37622g.e().getSimpleName() + '>', i.a.f2319a, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
                buildSerialDescriptor.h(((e) this.f37622g).f37619b);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(ba.a aVar) {
                a(aVar);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e<T> eVar) {
            super(0);
            this.f37621g = eVar;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor invoke() {
            return ba.b.c(ba.h.c("kotlinx.serialization.Polymorphic", d.a.f2287a, new SerialDescriptor[0], new C0768a(this.f37621g)), this.f37621g.e());
        }
    }

    public e(@NotNull KClass<T> baseClass) {
        t.i(baseClass, "baseClass");
        this.f37618a = baseClass;
        this.f37619b = kotlin.collections.v.l();
        this.f37620c = v8.n.b(p.f35202b, new a(this));
    }

    @Override // da.b
    @NotNull
    public KClass<T> e() {
        return this.f37618a;
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f37620c.getValue();
    }

    @NotNull
    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + e() + ')';
    }
}
