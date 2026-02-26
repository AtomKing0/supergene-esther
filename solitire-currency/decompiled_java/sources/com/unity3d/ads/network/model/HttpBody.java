package com.unity3d.ads.network.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpBody.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface HttpBody {

    /* JADX INFO: compiled from: HttpBody.kt */
    public static final class ByteArrayBody implements HttpBody {

        @NotNull
        private final byte[] content;

        public ByteArrayBody(@NotNull byte[] content) {
            t.i(content, "content");
            this.content = content;
        }

        @NotNull
        public final byte[] getContent() {
            return this.content;
        }
    }

    /* JADX INFO: compiled from: HttpBody.kt */
    public static final class EmptyBody implements HttpBody {

        @NotNull
        public static final EmptyBody INSTANCE = new EmptyBody();

        private EmptyBody() {
        }
    }

    /* JADX INFO: compiled from: HttpBody.kt */
    public static final class StringBody implements HttpBody {

        @NotNull
        private final String content;

        public StringBody(@NotNull String content) {
            t.i(content, "content");
            this.content = content;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }
    }
}
