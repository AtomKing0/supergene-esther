package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public interface InspectableValue {

    /* JADX INFO: compiled from: InspectableValue.kt */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static o9.g<ValueElement> getInspectableElements(@NotNull InspectableValue inspectableValue) {
            return v.a(inspectableValue);
        }

        @Deprecated
        @Nullable
        public static String getNameFallback(@NotNull InspectableValue inspectableValue) {
            return v.b(inspectableValue);
        }

        @Deprecated
        @Nullable
        public static Object getValueOverride(@NotNull InspectableValue inspectableValue) {
            return v.c(inspectableValue);
        }
    }

    @NotNull
    o9.g<ValueElement> getInspectableElements();

    @Nullable
    String getNameFallback();

    @Nullable
    Object getValueOverride();
}
