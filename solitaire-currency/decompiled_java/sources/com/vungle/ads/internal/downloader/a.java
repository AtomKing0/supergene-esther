package com.vungle.ads.internal.downloader;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AssetDownloadListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.vungle.ads.internal.downloader.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetDownloadListener.kt */
    public static final class C0502a {

        @NotNull
        public static final C0503a Companion = new C0503a(null);
        public static final int DEFAULT_SERVER_CODE = -1;

        @NotNull
        private final Throwable cause;

        @b
        private final int reason;
        private final int serverCode;

        /* JADX INFO: renamed from: com.vungle.ads.internal.downloader.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AssetDownloadListener.kt */
        public static final class C0503a {
            private C0503a() {
            }

            public /* synthetic */ C0503a(k kVar) {
                this();
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.downloader.a$a$b */
        /* JADX INFO: compiled from: AssetDownloadListener.kt */
        @Retention(RetentionPolicy.RUNTIME)
        public @interface b {

            @NotNull
            public static final C0504a Companion = C0504a.$$INSTANCE;

            /* JADX INFO: renamed from: com.vungle.ads.internal.downloader.a$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: AssetDownloadListener.kt */
            public static final class C0504a {
                private static int CONNECTION_ERROR;
                static final /* synthetic */ C0504a $$INSTANCE = new C0504a();
                private static int REQUEST_ERROR = 1;
                private static int DISK_ERROR = 2;
                private static int FILE_NOT_FOUND_ERROR = 3;
                private static int INTERNAL_ERROR = 4;

                private C0504a() {
                }

                public final int getCONNECTION_ERROR() {
                    return CONNECTION_ERROR;
                }

                public final int getDISK_ERROR() {
                    return DISK_ERROR;
                }

                public final int getFILE_NOT_FOUND_ERROR() {
                    return FILE_NOT_FOUND_ERROR;
                }

                public final int getINTERNAL_ERROR() {
                    return INTERNAL_ERROR;
                }

                public final int getREQUEST_ERROR() {
                    return REQUEST_ERROR;
                }

                public final void setCONNECTION_ERROR(int i10) {
                    CONNECTION_ERROR = i10;
                }

                public final void setDISK_ERROR(int i10) {
                    DISK_ERROR = i10;
                }

                public final void setFILE_NOT_FOUND_ERROR(int i10) {
                    FILE_NOT_FOUND_ERROR = i10;
                }

                public final void setINTERNAL_ERROR(int i10) {
                    INTERNAL_ERROR = i10;
                }

                public final void setREQUEST_ERROR(int i10) {
                    REQUEST_ERROR = i10;
                }
            }
        }

        public C0502a(int i10, @NotNull Throwable cause, int i11) {
            t.i(cause, "cause");
            this.serverCode = i10;
            this.cause = cause;
            this.reason = i11;
        }

        @NotNull
        public final Throwable getCause() {
            return this.cause;
        }

        public final int getReason() {
            return this.reason;
        }

        public final int getServerCode() {
            return this.serverCode;
        }
    }

    void onError(@Nullable C0502a c0502a, @NotNull d dVar);

    void onSuccess(@NotNull File file, @NotNull d dVar);

    /* JADX INFO: compiled from: AssetDownloadListener.kt */
    public static final class b {

        @NotNull
        public static final C0505a Companion = new C0505a(null);
        private int progressPercent;
        private long sizeBytes;
        private long startBytes;
        private int status;
        private long timestampDownloadStart;

        /* JADX INFO: renamed from: com.vungle.ads.internal.downloader.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AssetDownloadListener.kt */
        public static final class C0505a {
            private C0505a() {
            }

            public /* synthetic */ C0505a(k kVar) {
                this();
            }

            @NotNull
            public final b copy(@NotNull b progress) {
                t.i(progress, "progress");
                b bVar = new b();
                bVar.setStatus(progress.getStatus());
                bVar.setProgressPercent(progress.getProgressPercent());
                bVar.setTimestampDownloadStart(progress.getTimestampDownloadStart());
                bVar.setSizeBytes(progress.getSizeBytes());
                bVar.setStartBytes(progress.getStartBytes());
                return bVar;
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.downloader.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AssetDownloadListener.kt */
        @Retention(RetentionPolicy.RUNTIME)
        public @interface InterfaceC0506b {

            @NotNull
            public static final C0507a Companion = C0507a.$$INSTANCE;

            /* JADX INFO: renamed from: com.vungle.ads.internal.downloader.a$b$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: AssetDownloadListener.kt */
            public static final class C0507a {
                private static int STARTED;
                static final /* synthetic */ C0507a $$INSTANCE = new C0507a();
                private static int IN_PROGRESS = 1;
                private static int PAUSED = 2;
                private static int CANCELLED = 3;
                private static int DONE = 4;
                private static int LOST_CONNECTION = 5;
                private static int STATE_CHANGED = 6;
                private static int ERROR = 7;

                private C0507a() {
                }

                public final int getCANCELLED() {
                    return CANCELLED;
                }

                public final int getDONE() {
                    return DONE;
                }

                public final int getERROR() {
                    return ERROR;
                }

                public final int getIN_PROGRESS() {
                    return IN_PROGRESS;
                }

                public final int getLOST_CONNECTION() {
                    return LOST_CONNECTION;
                }

                public final int getPAUSED() {
                    return PAUSED;
                }

                public final int getSTARTED() {
                    return STARTED;
                }

                public final int getSTATE_CHANGED() {
                    return STATE_CHANGED;
                }

                public final void setCANCELLED(int i10) {
                    CANCELLED = i10;
                }

                public final void setDONE(int i10) {
                    DONE = i10;
                }

                public final void setERROR(int i10) {
                    ERROR = i10;
                }

                public final void setIN_PROGRESS(int i10) {
                    IN_PROGRESS = i10;
                }

                public final void setLOST_CONNECTION(int i10) {
                    LOST_CONNECTION = i10;
                }

                public final void setPAUSED(int i10) {
                    PAUSED = i10;
                }

                public final void setSTARTED(int i10) {
                    STARTED = i10;
                }

                public final void setSTATE_CHANGED(int i10) {
                    STATE_CHANGED = i10;
                }
            }
        }

        public final int getProgressPercent() {
            return this.progressPercent;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final long getStartBytes() {
            return this.startBytes;
        }

        public final int getStatus() {
            return this.status;
        }

        public final long getTimestampDownloadStart() {
            return this.timestampDownloadStart;
        }

        public final void setProgressPercent(int i10) {
            this.progressPercent = i10;
        }

        public final void setSizeBytes(long j10) {
            this.sizeBytes = j10;
        }

        public final void setStartBytes(long j10) {
            this.startBytes = j10;
        }

        public final void setStatus(int i10) {
            this.status = i10;
        }

        public final void setTimestampDownloadStart(long j10) {
            this.timestampDownloadStart = j10;
        }

        @InterfaceC0506b
        public static /* synthetic */ void getStatus$annotations() {
        }
    }
}
