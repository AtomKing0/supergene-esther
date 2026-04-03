package da;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Primitives.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o1 implements SerialDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f24605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ba.e f24606b;

    public o1(@NotNull String serialName, @NotNull ba.e kind) {
        kotlin.jvm.internal.t.i(serialName, "serialName");
        kotlin.jvm.internal.t.i(kind, "kind");
        this.f24605a = serialName;
        this.f24606b = kind;
    }

    private final Void a() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        a();
        throw new v8.h();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String e(int i10) {
        a();
        throw new v8.h();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> f(int i10) {
        a();
        throw new v8.h();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor g(int i10) {
        a();
        throw new v8.h();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> getAnnotations() {
        return SerialDescriptor.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return this.f24605a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int i10) {
        a();
        throw new v8.h();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public ba.e getKind() {
        return this.f24606b;
    }

    @NotNull
    public String toString() {
        return "PrimitiveDescriptor(" + h() + ')';
    }
}
