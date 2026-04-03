package androidx.compose.ui.node;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OwnerSnapshotObserver.kt */
/* JADX INFO: loaded from: classes.dex */
final class OwnerSnapshotObserver$clearInvalidObservations$1 extends v implements l<Object, Boolean> {
    public static final OwnerSnapshotObserver$clearInvalidObservations$1 INSTANCE = new OwnerSnapshotObserver$clearInvalidObservations$1();

    OwnerSnapshotObserver$clearInvalidObservations$1() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull Object it) {
        t.i(it, "it");
        return Boolean.valueOf(!((OwnerScope) it).isValid());
    }
}
