package ea;

import ba.i;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x0 {

    /* JADX INFO: compiled from: TreeJsonEncoder.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<JsonElement, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0<JsonElement> f25506g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.jvm.internal.n0<JsonElement> n0Var) {
            super(1);
            this.f25506g = n0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull JsonElement it) {
            kotlin.jvm.internal.t.i(it, "it");
            this.f25506g.f29834a = it;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(JsonElement jsonElement) {
            a(jsonElement);
            return v8.k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(SerialDescriptor serialDescriptor) {
        return (serialDescriptor.getKind() instanceof ba.e) || serialDescriptor.getKind() == i.b.f2320a;
    }

    @NotNull
    public static final <T> JsonElement c(@NotNull kotlinx.serialization.json.a aVar, T t10, @NotNull z9.j<? super T> serializer) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(serializer, "serializer");
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        new i0(aVar, new a(n0Var)).E(serializer, t10);
        T t11 = n0Var.f29834a;
        if (t11 != null) {
            return (JsonElement) t11;
        }
        kotlin.jvm.internal.t.A("result");
        return null;
    }
}
