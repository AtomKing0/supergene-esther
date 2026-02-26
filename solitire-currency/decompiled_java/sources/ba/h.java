package ba;

import ba.j;
import da.p1;
import h9.l;
import kotlin.collections.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import p9.q;
import v8.k0;

/* JADX INFO: compiled from: SerialDescriptors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: compiled from: SerialDescriptors.kt */
    public static final class a extends v implements l<ba.a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f2318g = new a();

        a() {
            super(1);
        }

        public final void a(@NotNull ba.a aVar) {
            t.i(aVar, "$this$null");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(ba.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    @NotNull
    public static final SerialDescriptor a(@NotNull String serialName, @NotNull e kind) {
        t.i(serialName, "serialName");
        t.i(kind, "kind");
        if (!q.z(serialName)) {
            return p1.a(serialName, kind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    @NotNull
    public static final SerialDescriptor b(@NotNull String serialName, @NotNull SerialDescriptor[] typeParameters, @NotNull l<? super ba.a, k0> builderAction) {
        t.i(serialName, "serialName");
        t.i(typeParameters, "typeParameters");
        t.i(builderAction, "builderAction");
        if (!(!q.z(serialName))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        ba.a aVar = new ba.a(serialName);
        builderAction.invoke(aVar);
        return new f(serialName, j.a.f2321a, aVar.f().size(), p.o0(typeParameters), aVar);
    }

    @NotNull
    public static final SerialDescriptor c(@NotNull String serialName, @NotNull i kind, @NotNull SerialDescriptor[] typeParameters, @NotNull l<? super ba.a, k0> builder) {
        t.i(serialName, "serialName");
        t.i(kind, "kind");
        t.i(typeParameters, "typeParameters");
        t.i(builder, "builder");
        if (!(!q.z(serialName))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (!(!t.d(kind, j.a.f2321a))) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        ba.a aVar = new ba.a(serialName);
        builder.invoke(aVar);
        return new f(serialName, kind, aVar.f().size(), p.o0(typeParameters), aVar);
    }

    public static /* synthetic */ SerialDescriptor d(String str, i iVar, SerialDescriptor[] serialDescriptorArr, l lVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            lVar = a.f2318g;
        }
        return c(str, iVar, serialDescriptorArr, lVar);
    }
}
