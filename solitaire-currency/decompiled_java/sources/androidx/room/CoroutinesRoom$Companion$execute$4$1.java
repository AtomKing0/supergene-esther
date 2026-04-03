package androidx.room;

import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteCompat;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: classes2.dex */
final class CoroutinesRoom$Companion$execute$4$1 extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ b2 $job;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$4$1(CancellationSignal cancellationSignal, b2 b2Var) {
        super(1);
        this.$cancellationSignal = cancellationSignal;
        this.$job = b2Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        SupportSQLiteCompat.Api16Impl.cancel(this.$cancellationSignal);
        b2.a.a(this.$job, null, 1, null);
    }
}
