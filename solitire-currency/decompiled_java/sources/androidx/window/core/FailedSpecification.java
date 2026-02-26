package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import h9.l;
import kotlin.collections.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: SpecificationComputer.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FailedSpecification<T> extends SpecificationComputer<T> {

    @NotNull
    private final WindowStrictModeException exception;

    @NotNull
    private final Logger logger;

    @NotNull
    private final String message;

    @NotNull
    private final String tag;

    @NotNull
    private final T value;

    @NotNull
    private final SpecificationComputer.VerificationMode verificationMode;

    /* JADX INFO: compiled from: SpecificationComputer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FailedSpecification(@NotNull T value, @NotNull String tag, @NotNull String message, @NotNull Logger logger, @NotNull SpecificationComputer.VerificationMode verificationMode) {
        t.i(value, "value");
        t.i(tag, "tag");
        t.i(message, "message");
        t.i(logger, "logger");
        t.i(verificationMode, "verificationMode");
        this.value = value;
        this.tag = tag;
        this.message = message;
        this.logger = logger;
        this.verificationMode = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(value, message));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        t.h(stackTrace, "stackTrace");
        Object[] array = p.J(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.exception = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    @Nullable
    public T compute() throws WindowStrictModeException {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if (i10 == 1) {
            throw this.exception;
        }
        if (i10 == 2) {
            this.logger.debug(this.tag, createMessage(this.value, this.message));
            return null;
        }
        if (i10 == 3) {
            return null;
        }
        throw new q();
    }

    @NotNull
    public final WindowStrictModeException getException() {
        return this.exception;
    }

    @NotNull
    public final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final T getValue() {
        return this.value;
    }

    @NotNull
    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    @Override // androidx.window.core.SpecificationComputer
    @NotNull
    public SpecificationComputer<T> require(@NotNull String message, @NotNull l<? super T, Boolean> condition) {
        t.i(message, "message");
        t.i(condition, "condition");
        return this;
    }
}
