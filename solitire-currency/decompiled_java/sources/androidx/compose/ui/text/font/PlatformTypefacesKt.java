package androidx.compose.ui.text.font;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformTypefaces.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformTypefacesKt {
    @NotNull
    public static final PlatformTypefaces PlatformTypefaces() {
        return Build.VERSION.SDK_INT >= 28 ? new PlatformTypefacesApi28() : new PlatformTypefacesApi();
    }

    @VisibleForTesting
    @NotNull
    public static final String getWeightSuffixForFallbackFamilyName(@NotNull String name, @NotNull FontWeight fontWeight) {
        t.i(name, "name");
        t.i(fontWeight, "fontWeight");
        int weight = fontWeight.getWeight() / 100;
        if (weight >= 0 && weight < 2) {
            return name + "-thin";
        }
        if (2 <= weight && weight < 4) {
            return name + "-light";
        }
        if (weight == 4) {
            return name;
        }
        if (weight == 5) {
            return name + "-medium";
        }
        if (6 <= weight && weight < 8) {
            return name;
        }
        if (!(8 <= weight && weight < 11)) {
            return name;
        }
        return name + "-black";
    }
}
