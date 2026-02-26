package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteDatabase, Boolean> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull SupportSQLiteDatabase obj) {
        kotlin.jvm.internal.t.i(obj, "obj");
        return Boolean.valueOf(obj.isReadOnly());
    }
}
