package u9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SystemProps.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f34667a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f34667a;
    }

    @Nullable
    public static final String b(@NotNull String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
