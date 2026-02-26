package androidx.room;

import androidx.annotation.RestrictTo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RoomMasterTable.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RoomMasterTable {

    @NotNull
    private static final String COLUMN_ID = "id";

    @NotNull
    private static final String COLUMN_IDENTITY_HASH = "identity_hash";

    @NotNull
    public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)";

    @NotNull
    public static final String DEFAULT_ID = "42";

    @NotNull
    public static final RoomMasterTable INSTANCE = new RoomMasterTable();

    @NotNull
    public static final String NAME = "room_master_table";

    @NotNull
    public static final String READ_QUERY = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1";

    @NotNull
    public static final String TABLE_NAME = "room_master_table";

    private RoomMasterTable() {
    }

    @NotNull
    public static final String createInsertQuery(@NotNull String hash) {
        kotlin.jvm.internal.t.i(hash, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')";
    }
}
