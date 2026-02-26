package o8;

import java.nio.charset.MalformedInputException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CharsetJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c extends MalformedInputException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f32044a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String message) {
        super(0);
        t.i(message, "message");
        this.f32044a = message;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    @Nullable
    public String getMessage() {
        return this.f32044a;
    }
}
