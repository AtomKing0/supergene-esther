package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DependencyDao.kt */
/* JADX INFO: loaded from: classes2.dex */
@Dao
public interface DependencyDao {
    @Query("SELECT work_spec_id FROM dependency WHERE prerequisite_id=:id")
    @NotNull
    List<String> getDependentWorkIds(@NotNull String str);

    @Query("SELECT prerequisite_id FROM dependency WHERE work_spec_id=:id")
    @NotNull
    List<String> getPrerequisites(@NotNull String str);

    @Query("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=:id AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)")
    boolean hasCompletedAllPrerequisites(@NotNull String str);

    @Query("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=:id")
    boolean hasDependents(@NotNull String str);

    @Insert(onConflict = 5)
    void insertDependency(@NotNull Dependency dependency);
}
