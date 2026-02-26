package androidx.media3.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import com.google.common.util.concurrent.m;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.p;
import e5.u;
import e5.v;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class DataSourceBitmapLoader implements BitmapLoader {
    public static final u<o> DEFAULT_EXECUTOR_SERVICE = v.a(new u() { // from class: androidx.media3.datasource.c
        @Override // e5.u
        public final Object get() {
            return DataSourceBitmapLoader.lambda$static$0();
        }
    });
    private final DataSource.Factory dataSourceFactory;
    private final o listeningExecutorService;

    @Nullable
    private final BitmapFactory.Options options;

    public DataSourceBitmapLoader(Context context) {
        this((o) Assertions.checkStateNotNull(DEFAULT_EXECUTOR_SERVICE.get()), new DefaultDataSource.Factory(context));
    }

    private static Bitmap decode(byte[] bArr, @Nullable BitmapFactory.Options options) throws IOException {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        Assertions.checkArgument(bitmapDecodeByteArray != null, "Could not decode image data");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            ExifInterface exifInterface = new ExifInterface(byteArrayInputStream);
            byteArrayInputStream.close();
            int rotationDegrees = exifInterface.getRotationDegrees();
            if (rotationDegrees == 0) {
                return bitmapDecodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(rotationDegrees);
            return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap lambda$decodeBitmap$1(byte[] bArr) throws Exception {
        return decode(bArr, this.options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap lambda$loadBitmap$2(Uri uri) throws Exception {
        return load(this.dataSourceFactory.createDataSource(), uri, this.options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$static$0() {
        return p.b(Executors.newSingleThreadExecutor());
    }

    private static Bitmap load(DataSource dataSource, Uri uri, @Nullable BitmapFactory.Options options) throws IOException {
        try {
            dataSource.open(new DataSpec(uri));
            return decode(DataSourceUtil.readToEnd(dataSource), options);
        } finally {
            dataSource.close();
        }
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public m<Bitmap> decodeBitmap(final byte[] bArr) {
        return this.listeningExecutorService.submit(new Callable() { // from class: androidx.media3.datasource.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1116a.lambda$decodeBitmap$1(bArr);
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public m<Bitmap> loadBitmap(final Uri uri) {
        return this.listeningExecutorService.submit(new Callable() { // from class: androidx.media3.datasource.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1118a.lambda$loadBitmap$2(uri);
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public /* synthetic */ m loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        return androidx.media3.common.util.a.a(this, mediaMetadata);
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public boolean supportsMimeType(String str) {
        return Util.isBitmapFactorySupportedMimeType(str);
    }

    public DataSourceBitmapLoader(o oVar, DataSource.Factory factory) {
        this(oVar, factory, null);
    }

    public DataSourceBitmapLoader(o oVar, DataSource.Factory factory, @Nullable BitmapFactory.Options options) {
        this.listeningExecutorService = oVar;
        this.dataSourceFactory = factory;
        this.options = options;
    }
}
