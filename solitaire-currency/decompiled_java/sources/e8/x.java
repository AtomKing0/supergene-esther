package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25403b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@NotNull String headerName, int i10) {
        super("Header name '" + headerName + "' contains illegal character '" + headerName.charAt(i10) + "' (code " + (headerName.charAt(i10) & 255) + ')');
        kotlin.jvm.internal.t.i(headerName, "headerName");
        this.f25402a = headerName;
        this.f25403b = i10;
    }
}
