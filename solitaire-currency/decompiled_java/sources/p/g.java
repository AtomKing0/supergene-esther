package p;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FetchResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Drawable f32345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f32346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final m.f f32347c;

    public g(@NotNull Drawable drawable, boolean z10, @NotNull m.f fVar) {
        super(null);
        this.f32345a = drawable;
        this.f32346b = z10;
        this.f32347c = fVar;
    }

    @NotNull
    public final m.f a() {
        return this.f32347c;
    }

    @NotNull
    public final Drawable b() {
        return this.f32345a;
    }

    public final boolean c() {
        return this.f32346b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (t.d(this.f32345a, gVar.f32345a) && this.f32346b == gVar.f32346b && this.f32347c == gVar.f32347c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f32345a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f32346b)) * 31) + this.f32347c.hashCode();
    }
}
