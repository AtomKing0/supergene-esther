package z7;

import io.ktor.utils.io.g;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DelegatedCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends t7.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull s7.a client, @NotNull g content, @NotNull t7.b originCall) {
        super(client);
        t.i(client, "client");
        t.i(content, "content");
        t.i(originCall, "originCall");
        i(new c(this, originCall.e()));
        j(new d(this, content, originCall.f()));
    }
}
