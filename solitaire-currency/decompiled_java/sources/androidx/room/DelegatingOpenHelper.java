package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DelegatingOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface DelegatingOpenHelper {
    @NotNull
    SupportSQLiteOpenHelper getDelegate();
}
