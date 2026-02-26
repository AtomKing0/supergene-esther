package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteDatabase, Object> {
    final /* synthetic */ String $sql;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(String str) {
        super(1);
        this.$sql = str;
    }

    @Override // h9.l
    @Nullable
    public final Object invoke(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        db2.execSQL(this.$sql);
        return null;
    }
}
