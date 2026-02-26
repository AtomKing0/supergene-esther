package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d3 extends CancellationException implements i0<d3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final transient b2 f29875a;

    public d3(@NotNull String str, @Nullable b2 b2Var) {
        super(str);
        this.f29875a = b2Var;
    }

    @Override // kotlinx.coroutines.i0
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d3 a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        d3 d3Var = new d3(message, this.f29875a);
        d3Var.initCause(this);
        return d3Var;
    }

    public d3(@NotNull String str) {
        this(str, null);
    }
}
