package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelperFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @NotNull
    private final AutoCloser autoCloser;

    @NotNull
    private final SupportSQLiteOpenHelper.Factory delegate;

    public AutoClosingRoomOpenHelperFactory(@NotNull SupportSQLiteOpenHelper.Factory delegate, @NotNull AutoCloser autoCloser) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NotNull
    public AutoClosingRoomOpenHelper create(@NotNull SupportSQLiteOpenHelper.Configuration configuration) {
        kotlin.jvm.internal.t.i(configuration, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(configuration), this.autoCloser);
    }
}
