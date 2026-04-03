package j8;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DateJvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f28772a = TimeZone.getTimeZone("GMT");

    @NotNull
    public static final b a(@Nullable Long l10) {
        Calendar calendar = Calendar.getInstance(f28772a, Locale.ROOT);
        t.f(calendar);
        return c(calendar, l10);
    }

    public static /* synthetic */ b b(Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        return a(l10);
    }

    @NotNull
    public static final b c(@NotNull Calendar calendar, @Nullable Long l10) {
        t.i(calendar, "<this>");
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        int i10 = calendar.get(15) + calendar.get(16);
        return new b(calendar.get(13), calendar.get(12), calendar.get(11), d.f28799b.a(((calendar.get(7) + 7) - 2) % 7), calendar.get(5), calendar.get(6), c.f28784b.a(calendar.get(2)), calendar.get(1), calendar.getTimeInMillis() + ((long) i10));
    }
}
