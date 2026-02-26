package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteDatabase, Long> {
    final /* synthetic */ long $numBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(long j10) {
        super(1);
        this.$numBytes = j10;
    }

    @Override // h9.l
    @NotNull
    public final Long invoke(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        return Long.valueOf(db2.setMaximumSize(this.$numBytes));
    }
}
