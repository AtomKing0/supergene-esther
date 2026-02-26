package ba;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes5.dex */
final class c implements SerialDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f2284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final KClass<?> f2285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f2286c;

    public c(@NotNull SerialDescriptor original, @NotNull KClass<?> kClass) {
        t.i(original, "original");
        t.i(kClass, "kClass");
        this.f2284a = original;
        this.f2285b = kClass;
        this.f2286c = original.h() + '<' + kClass.getSimpleName() + '>';
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return this.f2284a.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(@NotNull String name) {
        t.i(name, "name");
        return this.f2284a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.f2284a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String e(int i10) {
        return this.f2284a.e(i10);
    }

    public boolean equals(@Nullable Object obj) {
        c cVar = obj instanceof c ? (c) obj : null;
        return cVar != null && t.d(this.f2284a, cVar.f2284a) && t.d(cVar.f2285b, this.f2285b);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> f(int i10) {
        return this.f2284a.f(i10);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor g(int i10) {
        return this.f2284a.g(i10);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.f2284a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public i getKind() {
        return this.f2284a.getKind();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return this.f2286c;
    }

    public int hashCode() {
        return (this.f2285b.hashCode() * 31) + h().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int i10) {
        return this.f2284a.i(i10);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f2284a.isInline();
    }

    @NotNull
    public String toString() {
        return "ContextDescriptor(kClass: " + this.f2285b + ", original: " + this.f2284a + ')';
    }
}
