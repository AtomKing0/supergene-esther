package androidx.core.text;

import android.text.TextUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StringKt {
    @NotNull
    public static final String htmlEncode(@NotNull String str) {
        return TextUtils.htmlEncode(str);
    }
}
