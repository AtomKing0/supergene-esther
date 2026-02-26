package a0;

import android.content.Context;
import n.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f61a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static n.a f62b;

    private s() {
    }

    @NotNull
    public final synchronized n.a a(@NotNull Context context) {
        n.a aVarA;
        aVarA = f62b;
        if (aVarA == null) {
            aVarA = new a.C0629a().b(f9.m.s(j.m(context), "image_cache")).a();
            f62b = aVarA;
        }
        return aVarA;
    }
}
