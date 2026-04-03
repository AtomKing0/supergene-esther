package androidx.compose.ui.text.intl;

import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidLocaleDelegate.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 24)
public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {
    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    @NotNull
    public List<PlatformLocale> getCurrent() {
        android.os.LocaleList localeList = android.os.LocaleList.getDefault();
        t.h(localeList, "getDefault()");
        ArrayList arrayList = new ArrayList();
        int size = localeList.size();
        for (int i10 = 0; i10 < size; i10++) {
            java.util.Locale locale = localeList.get(i10);
            t.h(locale, "localeList[i]");
            arrayList.add(new AndroidLocale(locale));
        }
        return arrayList;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    @NotNull
    public PlatformLocale parseLanguageTag(@NotNull String languageTag) {
        t.i(languageTag, "languageTag");
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(languageTag);
        t.h(localeForLanguageTag, "forLanguageTag(languageTag)");
        return new AndroidLocale(localeForLanguageTag);
    }
}
