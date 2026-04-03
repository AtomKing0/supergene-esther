package androidx.work;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InputMergerFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InputMergerFactory {
    @Nullable
    public abstract InputMerger createInputMerger(@NotNull String str);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final InputMerger createInputMergerWithDefaultFallback(@NotNull String className) {
        t.i(className, "className");
        InputMerger inputMergerCreateInputMerger = createInputMerger(className);
        return inputMergerCreateInputMerger == null ? InputMergerKt.fromClassName(className) : inputMergerCreateInputMerger;
    }
}
