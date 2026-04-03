package androidx.work;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InputMerger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputMergerKt {

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("InputMerger");
        t.h(strTagWithPrefix, "tagWithPrefix(\"InputMerger\")");
        TAG = strTagWithPrefix;
    }

    @Nullable
    public static final InputMerger fromClassName(@NotNull String className) {
        t.i(className, "className");
        try {
            Object objNewInstance = Class.forName(className).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            t.g(objNewInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
            return (InputMerger) objNewInstance;
        } catch (Exception e10) {
            Logger.get().error(TAG, "Trouble instantiating " + className, e10);
            return null;
        }
    }
}
