package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import v0.b;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8244a;

        ImageType(boolean z10) {
            this.f8244a = z10;
        }

        public boolean hasAlpha() {
            return this.f8244a;
        }
    }

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException;

    @NonNull
    ImageType b(@NonNull InputStream inputStream) throws IOException;

    int c(@NonNull InputStream inputStream, @NonNull b bVar) throws IOException;
}
