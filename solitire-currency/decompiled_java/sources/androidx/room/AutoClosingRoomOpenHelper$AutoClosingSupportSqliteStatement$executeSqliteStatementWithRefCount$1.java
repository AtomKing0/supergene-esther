package androidx.room;

import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1<T> extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteDatabase, T> {
    final /* synthetic */ h9.l<SupportSQLiteStatement, T> $block;
    final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, h9.l<? super SupportSQLiteStatement, ? extends T> lVar) {
        super(1);
        this.this$0 = autoClosingSupportSqliteStatement;
        this.$block = lVar;
    }

    @Override // h9.l
    public final T invoke(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = db2.compileStatement(this.this$0.sql);
        this.this$0.doBinds(supportSQLiteStatementCompileStatement);
        return this.$block.invoke(supportSQLiteStatementCompileStatement);
    }
}
