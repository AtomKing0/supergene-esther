package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteStatement, Object> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    public final Object invoke(@NotNull SupportSQLiteStatement statement) {
        kotlin.jvm.internal.t.i(statement, "statement");
        statement.execute();
        return null;
    }
}
