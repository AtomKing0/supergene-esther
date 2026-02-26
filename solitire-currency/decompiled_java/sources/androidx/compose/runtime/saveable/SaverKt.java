package androidx.compose.runtime.saveable;

import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Saver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SaverKt {

    @NotNull
    private static final Saver<Object, Object> AutoSaver = Saver(SaverKt$AutoSaver$1.INSTANCE, SaverKt$AutoSaver$2.INSTANCE);

    @NotNull
    public static final <Original, Saveable> Saver<Original, Saveable> Saver(@NotNull final p<? super SaverScope, ? super Original, ? extends Saveable> save, @NotNull final l<? super Saveable, ? extends Original> restore) {
        t.i(save, "save");
        t.i(restore, "restore");
        return new Saver<Original, Saveable>() { // from class: androidx.compose.runtime.saveable.SaverKt.Saver.1
            @Override // androidx.compose.runtime.saveable.Saver
            @Nullable
            public Original restore(@NotNull Saveable value) {
                t.i(value, "value");
                return restore.invoke(value);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            @Nullable
            public Saveable save(@NotNull SaverScope saverScope, Original original) {
                t.i(saverScope, "<this>");
                return save.mo4invoke(saverScope, original);
            }
        };
    }

    @NotNull
    public static final <T> Saver<T, Object> autoSaver() {
        return (Saver<T, Object>) AutoSaver;
    }
}
