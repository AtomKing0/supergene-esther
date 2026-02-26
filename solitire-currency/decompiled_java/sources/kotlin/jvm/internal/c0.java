package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f29813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f29814b;

    public c0(@NotNull Class<?> jClass, @NotNull String moduleName) {
        t.i(jClass, "jClass");
        t.i(moduleName, "moduleName");
        this.f29813a = jClass;
        this.f29814b = moduleName;
    }

    @Override // kotlin.jvm.internal.h
    @NotNull
    public Class<?> a() {
        return this.f29813a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof c0) && t.d(a(), ((c0) obj).a());
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        throw new g9.b();
    }

    public int hashCode() {
        return a().hashCode();
    }

    @NotNull
    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
