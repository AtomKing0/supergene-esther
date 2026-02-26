package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FrameworkSQLiteOpenHelper$lazyDelegate$1 extends v implements h9.a<FrameworkSQLiteOpenHelper.OpenHelper> {
    final /* synthetic */ FrameworkSQLiteOpenHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrameworkSQLiteOpenHelper$lazyDelegate$1(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        super(0);
        this.this$0 = frameworkSQLiteOpenHelper;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
        FrameworkSQLiteOpenHelper.OpenHelper openHelper;
        if (this.this$0.name == null || !this.this$0.useNoBackupDirectory) {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, this.this$0.name, new FrameworkSQLiteOpenHelper.DBRefHolder(null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        } else {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(this.this$0.context), this.this$0.name).getAbsolutePath(), new FrameworkSQLiteOpenHelper.DBRefHolder(null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        }
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, this.this$0.writeAheadLoggingEnabled);
        return openHelper;
    }
}
