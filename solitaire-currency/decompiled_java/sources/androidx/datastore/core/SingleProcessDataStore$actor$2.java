package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import h9.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
final class SingleProcessDataStore$actor$2<T> extends v implements p<SingleProcessDataStore.Message<T>, Throwable, k0> {
    public static final SingleProcessDataStore$actor$2 INSTANCE = new SingleProcessDataStore$actor$2();

    SingleProcessDataStore$actor$2() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Object obj, Throwable th) {
        invoke((SingleProcessDataStore.Message) obj, th);
        return k0.f35197a;
    }

    public final void invoke(@NotNull SingleProcessDataStore.Message<T> msg, @Nullable Throwable th) {
        t.i(msg, "msg");
        if (msg instanceof SingleProcessDataStore.Message.Update) {
            x<T> ack = ((SingleProcessDataStore.Message.Update) msg).getAck();
            if (th == null) {
                th = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            ack.c(th);
        }
    }
}
