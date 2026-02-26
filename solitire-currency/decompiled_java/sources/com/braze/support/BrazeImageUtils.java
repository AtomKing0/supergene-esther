package com.braze.support;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import bo.app.md;
import bo.app.nd;
import bo.app.od;
import bo.app.pd;
import bo.app.sc;
import bo.app.tc;
import bo.app.u;
import bo.app.uc;
import bo.app.vc;
import bo.app.wc;
import com.braze.enums.BrazeViewBounds;
import com.braze.support.BrazeLogger;
import java.io.InputStream;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import v8.s;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeImageUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeImageUtils");

    public static final int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        long j10;
        long j11;
        t.i(options, "options");
        if (i11 == 0 || i10 == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) sc.f3847a, 14, (Object) null);
            return 1;
        }
        long j12 = options.outHeight;
        long j13 = options.outWidth;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new tc(options, i10, i11), 14, (Object) null);
        l0 l0Var = new l0();
        l0Var.f29831a = 1;
        long j14 = i11;
        if (j12 > j14 || j13 > i10) {
            long j15 = 2;
            long j16 = j12 / j15;
            long j17 = j13 / j15;
            while (true) {
                int i12 = l0Var.f29831a;
                j10 = j13;
                long j18 = i12;
                if (j16 / j18 < j14) {
                    j11 = j14;
                    if (j17 / j18 < i10 && (j10 * j12) / ((long) (i12 * i12)) <= 4194304) {
                        break;
                    }
                } else {
                    j11 = j14;
                }
                l0Var.f29831a = i12 * 2;
                j13 = j10;
                j14 = j11;
            }
        } else {
            j10 = j13;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new uc(l0Var, j10, j12), 14, (Object) null);
        return l0Var.f29831a;
    }

    private static final Bitmap decodeSampledBitmapFromStream(InputStream inputStream, BitmapFactory.Options options, int i10, int i11) {
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static final u getBitmap(Context context, Uri uri, BrazeViewBounds viewBounds) {
        t.i(context, "context");
        t.i(uri, "uri");
        t.i(viewBounds, "viewBounds");
        s<Integer, Integer> destinationHeightAndWidthPixels = getDestinationHeightAndWidthPixels(context, viewBounds);
        int iIntValue = destinationHeightAndWidthPixels.a().intValue();
        int iIntValue2 = destinationHeightAndWidthPixels.b().intValue();
        if (BrazeFileUtils.isLocalUri(uri)) {
            return new u(getLocalBitmap(uri, iIntValue2, iIntValue), null);
        }
        if (BrazeFileUtils.isRemoteUri(uri)) {
            return getRemoteBitmap(uri, iIntValue2, iIntValue);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new vc(uri), 12, (Object) null);
        return new u(null, null);
    }

    public static final BitmapFactory.Options getBitmapMetadataFromStream(InputStream inputStream) {
        t.i(inputStream, "inputStream");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        return options;
    }

    public static final int getDensityDpi(Context context) {
        t.i(context, "context");
        return context.getResources().getConfiguration().densityDpi;
    }

    private static final s<Integer, Integer> getDestinationHeightAndWidthPixels(Context context, BrazeViewBounds brazeViewBounds) {
        s<Integer, Integer> displayHeightAndWidthPixels = getDisplayHeightAndWidthPixels(context);
        int iIntValue = displayHeightAndWidthPixels.a().intValue();
        int iIntValue2 = displayHeightAndWidthPixels.b().intValue();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new wc(iIntValue2, iIntValue), 12, (Object) null);
        if (BrazeViewBounds.NO_BOUNDS == brazeViewBounds) {
            return new s<>(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
        }
        int densityDpi = getDensityDpi(context);
        return new s<>(Integer.valueOf(Math.min(iIntValue, getPixelsFromDensityAndDp(densityDpi, brazeViewBounds.getHeightDp()))), Integer.valueOf(Math.min(iIntValue2, getPixelsFromDensityAndDp(densityDpi, brazeViewBounds.getWidthDp()))));
    }

    public static final s<Integer, Integer> getDisplayHeightAndWidthPixels(Context context) {
        t.i(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new s<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    public static final int getDisplayWidthPixels(Context context) {
        t.i(context, "context");
        return getDisplayHeightAndWidthPixels(context).d().intValue();
    }

    public static final int getImageLoaderCacheSize() {
        return Math.max(1024, Math.min((int) Math.min(Runtime.getRuntime().maxMemory() / ((long) 8), 2147483647L), 33554432));
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.graphics.Bitmap getLocalBitmap(android.net.Uri r22, int r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeImageUtils.getLocalBitmap(android.net.Uri, int, int):android.graphics.Bitmap");
    }

    public static final int getPixelsFromDensityAndDp(int i10, int i11) {
        return Math.abs((i10 * i11) / 160);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final bo.app.u getRemoteBitmap(android.net.Uri r24, int r25, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeImageUtils.getRemoteBitmap(android.net.Uri, int, int):bo.app.u");
    }

    public static final void resizeImageViewToBitmapDimensions(Bitmap bitmap, ImageView imageView) {
        t.i(imageView, "imageView");
        resizeToBitmapDimensions(imageView, bitmap);
    }

    public static final void resizeToBitmapDimensions(ImageView imageView, Bitmap bitmap) {
        t.i(imageView, "<this>");
        if (bitmap == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) md.f3408a, 12, (Object) null);
            return;
        }
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new nd(imageView), 12, (Object) null);
            return;
        }
        if (imageView.getWidth() == 0 || imageView.getHeight() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new od(imageView), 12, (Object) null);
            return;
        }
        float width = bitmap.getWidth() / bitmap.getHeight();
        imageView.getLayoutParams().height = (int) (imageView.getWidth() / width);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new pd(width, imageView), 12, (Object) null);
        imageView.setLayoutParams(imageView.getLayoutParams());
    }
}
