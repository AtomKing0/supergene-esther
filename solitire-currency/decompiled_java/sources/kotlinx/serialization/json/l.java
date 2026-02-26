package kotlinx.serialization.json;

import ea.q0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Json.kt */
/* JADX INFO: loaded from: classes5.dex */
final class l extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull e configuration, @NotNull fa.c module) {
        super(configuration, module, null);
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(module, "module");
        g();
    }

    private final void g() {
        if (kotlin.jvm.internal.t.d(a(), fa.d.a())) {
            return;
        }
        a().a(new q0(e().k(), e().c()));
    }
}
