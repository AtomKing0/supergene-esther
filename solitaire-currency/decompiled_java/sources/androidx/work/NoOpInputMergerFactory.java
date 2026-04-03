package androidx.work;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InputMergerFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoOpInputMergerFactory extends InputMergerFactory {

    @NotNull
    public static final NoOpInputMergerFactory INSTANCE = new NoOpInputMergerFactory();

    private NoOpInputMergerFactory() {
    }

    @Nullable
    /* JADX INFO: renamed from: createInputMerger, reason: collision with other method in class */
    public Void m3945createInputMerger(@NotNull String className) {
        t.i(className, "className");
        return null;
    }

    @Override // androidx.work.InputMergerFactory
    public /* bridge */ /* synthetic */ InputMerger createInputMerger(String str) {
        return (InputMerger) m3945createInputMerger(str);
    }
}
