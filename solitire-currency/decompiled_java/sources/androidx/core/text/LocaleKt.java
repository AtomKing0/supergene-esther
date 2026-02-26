package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Locale.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleKt {
    public static final int getLayoutDirection(@NotNull Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
