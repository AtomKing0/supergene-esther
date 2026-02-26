package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteStatement, Long> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Long invoke(@NotNull SupportSQLiteStatement obj) {
        kotlin.jvm.internal.t.i(obj, "obj");
        return Long.valueOf(obj.executeInsert());
    }
}
