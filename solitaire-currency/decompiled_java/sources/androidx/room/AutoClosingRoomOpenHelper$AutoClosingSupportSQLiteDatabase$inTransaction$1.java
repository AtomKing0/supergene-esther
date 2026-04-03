package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 extends kotlin.jvm.internal.q implements h9.l<SupportSQLiteDatabase, Boolean> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1() {
        super(1, SupportSQLiteDatabase.class, "inTransaction", "inTransaction()Z", 0);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull SupportSQLiteDatabase p02) {
        kotlin.jvm.internal.t.i(p02, "p0");
        return Boolean.valueOf(p02.inTransaction());
    }
}
