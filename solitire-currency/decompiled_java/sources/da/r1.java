package da;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NullableSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r1 implements SerialDescriptor, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f24619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Set<String> f24620c;

    public r1(@NotNull SerialDescriptor original) {
        kotlin.jvm.internal.t.i(original, "original");
        this.f24618a = original;
        this.f24619b = original.h() + '?';
        this.f24620c = h1.a(original);
    }

    @Override // da.l
    @NotNull
    public Set<String> a() {
        return this.f24620c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return this.f24618a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.f24618a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String e(int i10) {
        return this.f24618a.e(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r1) && kotlin.jvm.internal.t.d(this.f24618a, ((r1) obj).f24618a);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> f(int i10) {
        return this.f24618a.f(i10);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor g(int i10) {
        return this.f24618a.g(i10);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.f24618a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public ba.i getKind() {
        return this.f24618a.getKind();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return this.f24619b;
    }

    public int hashCode() {
        return this.f24618a.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int i10) {
        return this.f24618a.i(i10);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f24618a.isInline();
    }

    @NotNull
    public final SerialDescriptor j() {
        return this.f24618a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24618a);
        sb.append('?');
        return sb.toString();
    }
}
