package y7;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultResponseValidation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f36653b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull b8.c response, @NotNull String cachedResponseText) {
        super(response, cachedResponseText);
        kotlin.jvm.internal.t.i(response, "response");
        kotlin.jvm.internal.t.i(cachedResponseText, "cachedResponseText");
        this.f36653b = "Client request(" + response.R().e().getMethod().d() + ' ' + response.R().e().getUrl() + ") invalid: " + response.f() + ". Text: \"" + cachedResponseText + '\"';
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.f36653b;
    }
}
