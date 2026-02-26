package da;

import ba.j;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CollectionDescriptors.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class w0 implements SerialDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f24644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24647d;

    public /* synthetic */ w0(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, kotlin.jvm.internal.k kVar) {
        this(str, serialDescriptor, serialDescriptor2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        Integer numL = p9.p.l(name);
        if (numL != null) {
            return numL.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.f24647d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String e(int i10) {
        return String.valueOf(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return kotlin.jvm.internal.t.d(h(), w0Var.h()) && kotlin.jvm.internal.t.d(this.f24645b, w0Var.f24645b) && kotlin.jvm.internal.t.d(this.f24646c, w0Var.f24646c);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> f(int i10) {
        if (i10 >= 0) {
            return kotlin.collections.v.l();
        }
        throw new IllegalArgumentException(("Illegal index " + i10 + ", " + h() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor g(int i10) {
        if (i10 >= 0) {
            int i11 = i10 % 2;
            if (i11 == 0) {
                return this.f24645b;
            }
            if (i11 == 1) {
                return this.f24646c;
            }
            throw new IllegalStateException("Unreached".toString());
        }
        throw new IllegalArgumentException(("Illegal index " + i10 + ", " + h() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> getAnnotations() {
        return SerialDescriptor.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public ba.i getKind() {
        return j.c.f2323a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return this.f24644a;
    }

    public int hashCode() {
        return (((h().hashCode() * 31) + this.f24645b.hashCode()) * 31) + this.f24646c.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int i10) {
        if (i10 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i10 + ", " + h() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.a.b(this);
    }

    @NotNull
    public String toString() {
        return h() + '(' + this.f24645b + ", " + this.f24646c + ')';
    }

    private w0(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.f24644a = str;
        this.f24645b = serialDescriptor;
        this.f24646c = serialDescriptor2;
        this.f24647d = 2;
    }
}
