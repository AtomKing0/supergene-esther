package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Half.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(short s10) {
        return Half.valueOf(s10);
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(float f10) {
        return Half.valueOf(f10);
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(@NotNull String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(double d10) {
        return Half.valueOf((float) d10);
    }
}
