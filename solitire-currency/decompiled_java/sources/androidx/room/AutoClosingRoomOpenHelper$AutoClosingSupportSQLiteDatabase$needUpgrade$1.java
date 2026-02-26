package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteDatabase, Boolean> {
    final /* synthetic */ int $newVersion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(int i10) {
        super(1);
        this.$newVersion = i10;
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        return Boolean.valueOf(db2.needUpgrade(this.$newVersion));
    }
}
