package com.unity3d.ads.core.data.model;

import com.unity3d.ads.adplayer.model.ShowStatus;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ShowEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ShowEvent {

    /* JADX INFO: compiled from: ShowEvent.kt */
    public static final class CancelTimeout extends ShowEvent {

        @NotNull
        public static final CancelTimeout INSTANCE = new CancelTimeout();

        private CancelTimeout() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ShowEvent.kt */
    public static final class Clicked extends ShowEvent {

        @NotNull
        public static final Clicked INSTANCE = new Clicked();

        private Clicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ShowEvent.kt */
    public static final class Completed extends ShowEvent {

        @NotNull
        private final ShowStatus status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Completed(@NotNull ShowStatus status) {
            super(null);
            t.i(status, "status");
            this.status = status;
        }

        public static /* synthetic */ Completed copy$default(Completed completed, ShowStatus showStatus, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                showStatus = completed.status;
            }
            return completed.copy(showStatus);
        }

        @NotNull
        public final ShowStatus component1() {
            return this.status;
        }

        @NotNull
        public final Completed copy(@NotNull ShowStatus status) {
            t.i(status, "status");
            return new Completed(status);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Completed) && this.status == ((Completed) obj).status;
        }

        @NotNull
        public final ShowStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status.hashCode();
        }

        @NotNull
        public String toString() {
            return "Completed(status=" + this.status + ')';
        }
    }

    /* JADX INFO: compiled from: ShowEvent.kt */
    public static final class Error extends ShowEvent {
        private final int errorCode;

        @NotNull
        private final String message;

        @NotNull
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String message, int i10, @NotNull String reason) {
            super(null);
            t.i(message, "message");
            t.i(reason, "reason");
            this.message = message;
            this.errorCode = i10;
            this.reason = reason;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i10, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.message;
            }
            if ((i11 & 2) != 0) {
                i10 = error.errorCode;
            }
            if ((i11 & 4) != 0) {
                str2 = error.reason;
            }
            return error.copy(str, i10, str2);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        public final int component2() {
            return this.errorCode;
        }

        @NotNull
        public final String component3() {
            return this.reason;
        }

        @NotNull
        public final Error copy(@NotNull String message, int i10, @NotNull String reason) {
            t.i(message, "message");
            t.i(reason, "reason");
            return new Error(message, i10, reason);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return t.d(this.message, error.message) && this.errorCode == error.errorCode && t.d(this.reason, error.reason);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return (((this.message.hashCode() * 31) + this.errorCode) * 31) + this.reason.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(message=" + this.message + ", errorCode=" + this.errorCode + ", reason=" + this.reason + ')';
        }
    }

    /* JADX INFO: compiled from: ShowEvent.kt */
    public static final class LeftApplication extends ShowEvent {

        @NotNull
        public static final LeftApplication INSTANCE = new LeftApplication();

        private LeftApplication() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ShowEvent.kt */
    public static final class Started extends ShowEvent {

        @NotNull
        public static final Started INSTANCE = new Started();

        private Started() {
            super(null);
        }
    }

    private ShowEvent() {
    }

    public /* synthetic */ ShowEvent(k kVar) {
        this();
    }
}
