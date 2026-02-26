package da;

import ba.i;
import ba.j;
import java.util.Iterator;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Enums.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class z extends PluginGeneratedSerialDescriptor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final ba.i f24669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final v8.l f24670n;

    /* JADX INFO: compiled from: Enums.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor[]> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f24671g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f24672h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ z f24673i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i10, String str, z zVar) {
            super(0);
            this.f24671g = i10;
            this.f24672h = str;
            this.f24673i = zVar;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor[] invoke() {
            int i10 = this.f24671g;
            SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                serialDescriptorArr[i11] = ba.h.d(this.f24672h + '.' + this.f24673i.e(i11), j.d.f2324a, new SerialDescriptor[0], null, 8, null);
            }
            return serialDescriptorArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull String name, int i10) {
        super(name, null, i10, 2, null);
        kotlin.jvm.internal.t.i(name, "name");
        this.f24669m = i.b.f2320a;
        this.f24670n = v8.n.a(new a(i10, name, this));
    }

    private final SerialDescriptor[] q() {
        return (SerialDescriptor[]) this.f24670n.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        return serialDescriptor.getKind() == i.b.f2320a && kotlin.jvm.internal.t.d(h(), serialDescriptor.h()) && kotlin.jvm.internal.t.d(h1.a(this), h1.a(serialDescriptor));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor g(int i10) {
        return q()[i10];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public ba.i getKind() {
        return this.f24669m;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int iHashCode = h().hashCode();
        Iterator<String> it = ba.g.b(this).iterator();
        int iHashCode2 = 1;
        while (it.hasNext()) {
            int i10 = iHashCode2 * 31;
            String next = it.next();
            iHashCode2 = i10 + (next != null ? next.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    @NotNull
    public String toString() {
        return kotlin.collections.d0.r0(ba.g.b(this), ", ", h() + '(', ")", 0, null, null, 56, null);
    }
}
