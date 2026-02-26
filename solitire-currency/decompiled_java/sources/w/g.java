package w;

import android.view.View;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w.l;

/* JADX INFO: compiled from: RealViewSizeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T extends View> implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final T f35268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f35269b;

    public g(@NotNull T t10, boolean z10) {
        this.f35268a = t10;
        this.f35269b = z10;
    }

    @Override // w.j
    @Nullable
    public Object a(@NotNull z8.d<? super i> dVar) {
        return l.a.h(this, dVar);
    }

    @Override // w.l
    public boolean b() {
        return this.f35269b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (t.d(getView(), gVar.getView()) && b() == gVar.b()) {
                return true;
            }
        }
        return false;
    }

    @Override // w.l
    @NotNull
    public T getView() {
        return this.f35268a;
    }

    public int hashCode() {
        return (getView().hashCode() * 31) + androidx.compose.foundation.e.a(b());
    }
}
