package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkTagDao.kt */
/* JADX INFO: loaded from: classes2.dex */
@Dao
public interface WorkTagDao {

    /* JADX INFO: compiled from: WorkTagDao.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static void insertTags(@NotNull WorkTagDao workTagDao, @NotNull String id, @NotNull Set<String> tags) {
            t.i(id, "id");
            t.i(tags, "tags");
            c.a(workTagDao, id, tags);
        }
    }

    @Query("DELETE FROM worktag WHERE work_spec_id=:id")
    void deleteByWorkSpecId(@NotNull String str);

    @Query("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=:id")
    @NotNull
    List<String> getTagsForWorkSpecId(@NotNull String str);

    @Query("SELECT work_spec_id FROM worktag WHERE tag=:tag")
    @NotNull
    List<String> getWorkSpecIdsWithTag(@NotNull String str);

    @Insert(onConflict = 5)
    void insert(@NotNull WorkTag workTag);

    void insertTags(@NotNull String str, @NotNull Set<String> set);
}
