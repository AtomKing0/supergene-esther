package z;

import android.graphics.drawable.Drawable;
import androidx.annotation.MainThread;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x.a;

/* JADX INFO: compiled from: TransitionTarget.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface d extends x.a {

    /* JADX INFO: compiled from: TransitionTarget.kt */
    public static final class a {
        @MainThread
        public static void a(@NotNull d dVar, @Nullable Drawable drawable) {
            a.C0723a.a(dVar, drawable);
        }

        @MainThread
        public static void b(@NotNull d dVar, @Nullable Drawable drawable) {
            a.C0723a.b(dVar, drawable);
        }

        @MainThread
        public static void c(@NotNull d dVar, @NotNull Drawable drawable) {
            a.C0723a.c(dVar, drawable);
        }
    }

    @Nullable
    Drawable d();
}
