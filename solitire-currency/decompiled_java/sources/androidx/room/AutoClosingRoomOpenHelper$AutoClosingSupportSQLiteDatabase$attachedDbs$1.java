package androidx.room;

import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1 extends kotlin.jvm.internal.v implements h9.l<SupportSQLiteDatabase, List<? extends Pair<String, String>>> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    public final List<Pair<String, String>> invoke(@NotNull SupportSQLiteDatabase obj) {
        kotlin.jvm.internal.t.i(obj, "obj");
        return obj.getAttachedDbs();
    }
}
