package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Applier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Applier<N> {

    /* JADX INFO: compiled from: Applier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <N> void onBeginChanges(@NotNull Applier<N> applier) {
            a.a(applier);
        }

        @Deprecated
        public static <N> void onEndChanges(@NotNull Applier<N> applier) {
            a.b(applier);
        }
    }

    void clear();

    void down(N n10);

    N getCurrent();

    void insertBottomUp(int i10, N n10);

    void insertTopDown(int i10, N n10);

    void move(int i10, int i11, int i12);

    void onBeginChanges();

    void onEndChanges();

    void remove(int i10, int i11);

    void up();
}
