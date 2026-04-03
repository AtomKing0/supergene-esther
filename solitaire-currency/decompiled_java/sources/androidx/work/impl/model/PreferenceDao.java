package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PreferenceDao.kt */
/* JADX INFO: loaded from: classes2.dex */
@Dao
public interface PreferenceDao {
    @Query("SELECT long_value FROM Preference where `key`=:key")
    @Nullable
    Long getLongValue(@NotNull String str);

    @Query("SELECT long_value FROM Preference where `key`=:key")
    @NotNull
    LiveData<Long> getObservableLongValue(@NotNull String str);

    @Insert(onConflict = 1)
    void insertPreference(@NotNull Preference preference);
}
