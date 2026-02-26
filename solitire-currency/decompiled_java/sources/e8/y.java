package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class y extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25405b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@NotNull String headerValue, int i10) {
        super("Header value '" + headerValue + "' contains illegal character '" + headerValue.charAt(i10) + "' (code " + (headerValue.charAt(i10) & 255) + ')');
        kotlin.jvm.internal.t.i(headerValue, "headerValue");
        this.f25404a = headerValue;
        this.f25405b = i10;
    }
}
