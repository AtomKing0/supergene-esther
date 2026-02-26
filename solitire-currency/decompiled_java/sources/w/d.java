package w;

import android.content.Context;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w.c;

/* JADX INFO: compiled from: DisplaySizeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f35262a;

    public d(@NotNull Context context) {
        this.f35262a = context;
    }

    @Override // w.j
    @Nullable
    public Object a(@NotNull z8.d<? super i> dVar) {
        DisplayMetrics displayMetrics = this.f35262a.getResources().getDisplayMetrics();
        c.a aVarA = a.a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new i(aVarA, aVarA);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && t.d(this.f35262a, ((d) obj).f35262a);
    }

    public int hashCode() {
        return this.f35262a.hashCode();
    }
}
