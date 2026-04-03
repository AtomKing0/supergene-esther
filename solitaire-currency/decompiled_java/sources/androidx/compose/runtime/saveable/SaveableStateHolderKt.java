package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SaveableStateHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateHolderKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.SaveableStateHolderKt$rememberSaveableStateHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: SaveableStateHolder.kt */
    static final class AnonymousClass1 extends v implements a<SaveableStateHolderImpl> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final SaveableStateHolderImpl invoke() {
            return new SaveableStateHolderImpl(null, 1, null);
        }
    }

    @Composable
    @NotNull
    public static final SaveableStateHolder rememberSaveableStateHolder(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(15454635);
        SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) RememberSaveableKt.m1271rememberSaveable(new Object[0], (Saver) SaveableStateHolderImpl.Companion.getSaver(), (String) null, (a) AnonymousClass1.INSTANCE, composer, 8, 4);
        saveableStateHolderImpl.setParentSaveableStateRegistry((SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry()));
        composer.endReplaceableGroup();
        return saveableStateHolderImpl;
    }
}
