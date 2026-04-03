package androidx.compose.runtime;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes.dex */
final class HotReloader {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: Composition.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private final void loadStateAndCompose(Object obj) {
            Recomposer.Companion.loadStateAndComposeForHotReload$runtime_release(obj);
        }

        private final Object saveStateAndDispose(Object obj) {
            return Recomposer.Companion.saveStateAndDisposeForHotReload$runtime_release();
        }

        public final void invalidateGroupsWithKey$runtime_release(int i10) {
            Recomposer.Companion.invalidateGroupsWithKey$runtime_release(i10);
        }

        public final void simulateHotReload$runtime_release(@NotNull Object context) {
            t.i(context, "context");
            loadStateAndCompose(saveStateAndDispose(context));
        }
    }
}
