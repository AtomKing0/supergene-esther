package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SharedSQLiteStatement.kt */
/* JADX INFO: loaded from: classes2.dex */
final class SharedSQLiteStatement$stmt$2 extends kotlin.jvm.internal.v implements h9.a<SupportSQLiteStatement> {
    final /* synthetic */ SharedSQLiteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SharedSQLiteStatement$stmt$2(SharedSQLiteStatement sharedSQLiteStatement) {
        super(0);
        this.this$0 = sharedSQLiteStatement;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final SupportSQLiteStatement invoke() {
        return this.this$0.createNewStatement();
    }
}
