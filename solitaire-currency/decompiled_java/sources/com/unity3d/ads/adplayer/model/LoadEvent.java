package com.unity3d.ads.adplayer.model;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LoadEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LoadEvent {

    /* JADX INFO: compiled from: LoadEvent.kt */
    public static final class Completed extends LoadEvent {

        @NotNull
        public static final Completed INSTANCE = new Completed();

        private Completed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: LoadEvent.kt */
    public static final class Error extends LoadEvent {
        private final int errorCode;

        @NotNull
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String message, int i10) {
            super(null);
            t.i(message, "message");
            this.message = message;
            this.errorCode = i10;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.message;
            }
            if ((i11 & 2) != 0) {
                i10 = error.errorCode;
            }
            return error.copy(str, i10);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        public final int component2() {
            return this.errorCode;
        }

        @NotNull
        public final Error copy(@NotNull String message, int i10) {
            t.i(message, "message");
            return new Error(message, i10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return t.d(this.message, error.message) && this.errorCode == error.errorCode;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.errorCode;
        }

        @NotNull
        public String toString() {
            return "Error(message=" + this.message + ", errorCode=" + this.errorCode + ')';
        }
    }

    private LoadEvent() {
    }

    public /* synthetic */ LoadEvent(k kVar) {
        this();
    }
}
