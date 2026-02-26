package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import h9.p;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import r9.d;
import r9.g;
import r9.u;
import s9.h;
import v8.k0;

/* JADX INFO: compiled from: PredictiveBackHandler.kt */
/* JADX INFO: loaded from: classes.dex */
final class OnBackInstance {

    @NotNull
    private final d<BackEventCompat> channel = g.b(-2, r9.a.SUSPEND, null, 4, null);
    private final boolean isPredictiveBack;

    @NotNull
    private final b2 job;

    public OnBackInstance(@NotNull o0 o0Var, boolean z10, @NotNull p<? super h<BackEventCompat>, ? super z8.d<? super k0>, ? extends Object> pVar) {
        this.isPredictiveBack = z10;
        this.job = k.d(o0Var, null, null, new OnBackInstance$job$1(pVar, this, null), 3, null);
    }

    public final void cancel() {
        this.channel.cancel(new CancellationException("onBack cancelled"));
        b2.a.a(this.job, null, 1, null);
    }

    public final boolean close() {
        return u.a.a(this.channel, null, 1, null);
    }

    @NotNull
    public final d<BackEventCompat> getChannel() {
        return this.channel;
    }

    @NotNull
    public final b2 getJob() {
        return this.job;
    }

    public final boolean isPredictiveBack() {
        return this.isPredictiveBack;
    }

    @NotNull
    /* JADX INFO: renamed from: send-JP2dKIU, reason: not valid java name */
    public final Object m2sendJP2dKIU(@NotNull BackEventCompat backEventCompat) {
        return this.channel.f(backEventCompat);
    }
}
