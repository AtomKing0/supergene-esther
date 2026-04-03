package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.work.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkProgressDao.kt */
/* JADX INFO: loaded from: classes2.dex */
@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface WorkProgressDao {
    @Query("DELETE from WorkProgress where work_spec_id=:workSpecId")
    void delete(@NotNull String str);

    @Query("DELETE FROM WorkProgress")
    void deleteAll();

    @Query("SELECT progress FROM WorkProgress WHERE work_spec_id=:workSpecId")
    @Nullable
    Data getProgressForWorkSpecId(@NotNull String str);

    @Insert(onConflict = 1)
    void insert(@NotNull WorkProgress workProgress);
}
