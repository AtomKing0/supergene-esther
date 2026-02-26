package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SystemIdInfoDao.kt */
/* JADX INFO: loaded from: classes2.dex */
@Dao
public interface SystemIdInfoDao {

    /* JADX INFO: compiled from: SystemIdInfoDao.kt */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static SystemIdInfo getSystemIdInfo(@NotNull SystemIdInfoDao systemIdInfoDao, @NotNull WorkGenerationalId id) {
            t.i(id, "id");
            return a.a(systemIdInfoDao, id);
        }

        @Deprecated
        public static void removeSystemIdInfo(@NotNull SystemIdInfoDao systemIdInfoDao, @NotNull WorkGenerationalId id) {
            t.i(id, "id");
            a.b(systemIdInfoDao, id);
        }
    }

    @Nullable
    SystemIdInfo getSystemIdInfo(@NotNull WorkGenerationalId workGenerationalId);

    @Query("SELECT * FROM SystemIdInfo WHERE work_spec_id=:workSpecId AND generation=:generation")
    @Nullable
    SystemIdInfo getSystemIdInfo(@NotNull String str, int i10);

    @Query("SELECT DISTINCT work_spec_id FROM SystemIdInfo")
    @NotNull
    List<String> getWorkSpecIds();

    @Insert(onConflict = 1)
    void insertSystemIdInfo(@NotNull SystemIdInfo systemIdInfo);

    void removeSystemIdInfo(@NotNull WorkGenerationalId workGenerationalId);

    @Query("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId")
    void removeSystemIdInfo(@NotNull String str);

    @Query("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId AND generation=:generation")
    void removeSystemIdInfo(@NotNull String str, int i10);
}
