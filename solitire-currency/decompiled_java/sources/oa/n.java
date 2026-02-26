package oa;

import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StreamResetException.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final b f32305a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull b errorCode) {
        super(t.r("stream was reset: ", errorCode));
        t.i(errorCode, "errorCode");
        this.f32305a = errorCode;
    }
}
