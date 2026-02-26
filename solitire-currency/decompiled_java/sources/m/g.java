package m;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DecodeResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Drawable f31101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f31102b;

    public g(@NotNull Drawable drawable, boolean z10) {
        this.f31101a = drawable;
        this.f31102b = z10;
    }

    @NotNull
    public final Drawable a() {
        return this.f31101a;
    }

    public final boolean b() {
        return this.f31102b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (t.d(this.f31101a, gVar.f31101a) && this.f31102b == gVar.f31102b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f31101a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f31102b);
    }
}
