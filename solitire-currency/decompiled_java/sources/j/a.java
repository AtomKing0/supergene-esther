package j;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Coil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f28533a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static e f28534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static f f28535c;

    private a() {
    }

    @NotNull
    public static final e a(@NotNull Context context) {
        e eVar = f28534b;
        return eVar == null ? f28533a.b(context) : eVar;
    }

    private final synchronized e b(Context context) {
        e eVarA;
        e eVar = f28534b;
        if (eVar != null) {
            return eVar;
        }
        f fVar = f28535c;
        if (fVar == null || (eVarA = fVar.a()) == null) {
            Object applicationContext = context.getApplicationContext();
            f fVar2 = applicationContext instanceof f ? (f) applicationContext : null;
            eVarA = fVar2 != null ? fVar2.a() : g.a(context);
        }
        f28535c = null;
        f28534b = eVarA;
        return eVarA;
    }
}
