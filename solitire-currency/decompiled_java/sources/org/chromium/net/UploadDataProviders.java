package org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadDataProviders {

    private static final class ByteBufferUploadProvider extends UploadDataProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f32316a;

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.f32316a.limit();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.f32316a.remaining()) {
                byteBuffer.put(this.f32316a);
            } else {
                int iLimit = this.f32316a.limit();
                ByteBuffer byteBuffer2 = this.f32316a;
                byteBuffer2.limit(byteBuffer2.position() + byteBuffer.remaining());
                byteBuffer.put(this.f32316a);
                this.f32316a.limit(iLimit);
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            this.f32316a.position(0);
            uploadDataSink.onRewindSucceeded();
        }

        private ByteBufferUploadProvider(ByteBuffer byteBuffer) {
            this.f32316a = byteBuffer;
        }
    }

    private interface FileChannelProvider {
        FileChannel a() throws IOException;
    }

    private static final class FileUploadProvider extends UploadDataProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile FileChannel f32317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FileChannelProvider f32318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f32319c;

        private FileChannel a() throws IOException {
            if (this.f32317a == null) {
                synchronized (this.f32319c) {
                    if (this.f32317a == null) {
                        this.f32317a = this.f32318b.a();
                    }
                }
            }
            return this.f32317a;
        }

        @Override // org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            FileChannel fileChannel = this.f32317a;
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() throws IOException {
            return a().size();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            FileChannel fileChannelA = a();
            int i10 = 0;
            while (i10 == 0) {
                int i11 = fileChannelA.read(byteBuffer);
                if (i11 == -1) {
                    break;
                } else {
                    i10 += i11;
                }
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) throws IOException {
            a().position(0L);
            uploadDataSink.onRewindSucceeded();
        }

        private FileUploadProvider(FileChannelProvider fileChannelProvider) {
            this.f32319c = new Object();
            this.f32318b = fileChannelProvider;
        }
    }

    private UploadDataProviders() {
    }

    public static UploadDataProvider create(final File file) {
        return new FileUploadProvider(new FileChannelProvider() { // from class: org.chromium.net.UploadDataProviders.1
            @Override // org.chromium.net.UploadDataProviders.FileChannelProvider
            public FileChannel a() throws IOException {
                return new FileInputStream(file).getChannel();
            }
        });
    }

    public static UploadDataProvider create(final ParcelFileDescriptor parcelFileDescriptor) {
        return new FileUploadProvider(new FileChannelProvider() { // from class: org.chromium.net.UploadDataProviders.2
            @Override // org.chromium.net.UploadDataProviders.FileChannelProvider
            public FileChannel a() throws IOException {
                if (parcelFileDescriptor.getStatSize() != -1) {
                    return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor).getChannel();
                }
                parcelFileDescriptor.close();
                throw new IllegalArgumentException("Not a file: " + parcelFileDescriptor);
            }
        });
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return new ByteBufferUploadProvider(byteBuffer.slice());
    }

    public static UploadDataProvider create(byte[] bArr, int i10, int i11) {
        return new ByteBufferUploadProvider(ByteBuffer.wrap(bArr, i10, i11).slice());
    }

    public static UploadDataProvider create(byte[] bArr) {
        return create(bArr, 0, bArr.length);
    }
}
