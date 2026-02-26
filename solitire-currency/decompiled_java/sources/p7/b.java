package p7;

import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SystemLocaleInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {
    @Override // p7.a
    @NotNull
    public String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        t.h(language, "getDefault().language");
        return language;
    }

    @Override // p7.a
    @NotNull
    public String getTimeZoneId() {
        String id = TimeZone.getDefault().getID();
        t.h(id, "getDefault().id");
        return id;
    }
}
