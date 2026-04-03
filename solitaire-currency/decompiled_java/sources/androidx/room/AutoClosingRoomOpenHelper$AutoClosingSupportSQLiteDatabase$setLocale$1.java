package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteDatabase, Object> {
    final /* synthetic */ Locale $locale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(Locale locale) {
        super(1);
        this.$locale = locale;
    }

    @Override // h9.l
    @Nullable
    public final Object invoke(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        db2.setLocale(this.$locale);
        return null;
    }
}
