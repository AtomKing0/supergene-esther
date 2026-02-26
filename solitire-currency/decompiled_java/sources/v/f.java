package v;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Drawable f34880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f34881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Throwable f34882c;

    public f(@Nullable Drawable drawable, @NotNull i iVar, @NotNull Throwable th) {
        super(null);
        this.f34880a = drawable;
        this.f34881b = iVar;
        this.f34882c = th;
    }

    @Override // v.j
    @Nullable
    public Drawable a() {
        return this.f34880a;
    }

    @Override // v.j
    @NotNull
    public i b() {
        return this.f34881b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (kotlin.jvm.internal.t.d(a(), fVar.a()) && kotlin.jvm.internal.t.d(b(), fVar.b()) && kotlin.jvm.internal.t.d(this.f34882c, fVar.f34882c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Drawable drawableA = a();
        return ((((drawableA != null ? drawableA.hashCode() : 0) * 31) + b().hashCode()) * 31) + this.f34882c.hashCode();
    }
}
