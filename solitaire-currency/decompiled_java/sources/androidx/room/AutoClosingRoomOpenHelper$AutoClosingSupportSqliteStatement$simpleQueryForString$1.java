package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteStatement, String> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    public final String invoke(@NotNull SupportSQLiteStatement obj) {
        kotlin.jvm.internal.t.i(obj, "obj");
        return obj.simpleQueryForString();
    }
}
