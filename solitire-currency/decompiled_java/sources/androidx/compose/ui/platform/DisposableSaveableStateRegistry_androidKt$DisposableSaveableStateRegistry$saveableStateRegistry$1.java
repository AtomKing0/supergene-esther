package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DisposableSaveableStateRegistry.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1 extends kotlin.jvm.internal.v implements h9.l<Object, Boolean> {
    public static final DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1 INSTANCE = new DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1();

    DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull Object it) {
        kotlin.jvm.internal.t.i(it, "it");
        return Boolean.valueOf(DisposableSaveableStateRegistry_androidKt.canBeSavedToBundle(it));
    }
}
