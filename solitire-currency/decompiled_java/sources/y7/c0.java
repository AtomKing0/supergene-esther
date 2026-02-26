package y7;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultResponseValidation.kt */
/* JADX INFO: loaded from: classes4.dex */
public class c0 extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final transient b8.c f36654a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@NotNull b8.c response, @NotNull String cachedResponseText) {
        super("Bad response: " + response + ". Text: \"" + cachedResponseText + '\"');
        kotlin.jvm.internal.t.i(response, "response");
        kotlin.jvm.internal.t.i(cachedResponseText, "cachedResponseText");
        this.f36654a = response;
    }
}
