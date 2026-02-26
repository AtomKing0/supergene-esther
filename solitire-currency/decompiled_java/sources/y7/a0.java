package y7;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultResponseValidation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a0 extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f36649b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(@NotNull b8.c response, @NotNull String cachedResponseText) {
        super(response, cachedResponseText);
        kotlin.jvm.internal.t.i(response, "response");
        kotlin.jvm.internal.t.i(cachedResponseText, "cachedResponseText");
        this.f36649b = "Unhandled redirect: " + response.R().e().getMethod().d() + ' ' + response.R().e().getUrl() + ". Status: " + response.f() + ". Text: \"" + cachedResponseText + '\"';
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.f36649b;
    }
}
