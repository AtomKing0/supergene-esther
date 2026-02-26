package ea;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElementMarker.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final da.y f25504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25505b;

    /* JADX INFO: compiled from: JsonElementMarker.kt */
    /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.p<SerialDescriptor, Integer, Boolean> {
        a(Object obj) {
            super(2, obj, x.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        @NotNull
        public final Boolean a(@NotNull SerialDescriptor p02, int i10) {
            kotlin.jvm.internal.t.i(p02, "p0");
            return Boolean.valueOf(((x) this.receiver).e(p02, i10));
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Boolean mo4invoke(SerialDescriptor serialDescriptor, Integer num) {
            return a(serialDescriptor, num.intValue());
        }
    }

    public x(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        this.f25504a = new da.y(descriptor, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(SerialDescriptor serialDescriptor, int i10) {
        boolean z10 = !serialDescriptor.i(i10) && serialDescriptor.g(i10).b();
        this.f25505b = z10;
        return z10;
    }

    public final boolean b() {
        return this.f25505b;
    }

    public final void c(int i10) {
        this.f25504a.a(i10);
    }

    public final int d() {
        return this.f25504a.d();
    }
}
