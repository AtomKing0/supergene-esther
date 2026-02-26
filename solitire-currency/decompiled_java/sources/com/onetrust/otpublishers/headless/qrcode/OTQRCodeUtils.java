package com.onetrust.otpublishers.headless.qrcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.c;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes4.dex */
public final class OTQRCodeUtils {
    private OTQRCodeUtils() {
    }

    public static BitMatrix a(@NonNull String str, int i10, int i11, boolean z10) {
        int i12 = z10 ? 1 : 2;
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            enumMap.put(EncodeHintType.MARGIN, Integer.valueOf(i12));
            return new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i11, i10, enumMap);
        } catch (Exception e10) {
            OTLogger.a("OTQRCodeUtils", 6, "encodeToBitmap(): " + e10);
            return null;
        }
    }

    public static void b(@NonNull String str, @NonNull FragmentActivity fragmentActivity, String str2, String str3, ImageView imageView, boolean z10) {
        boolean z11;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            fragmentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            try {
                Class.forName("com.google.zxing.MultiFormatWriter");
                z11 = false;
            } catch (ClassNotFoundException unused) {
                OTLogger.a("OTQRCodeUtils", 6, "Add implementation 'com.google.zxing:core:3.3.0' to gradle file and try again to support QR code");
                z11 = true;
            }
            if (z11) {
                return;
            }
            int i10 = (int) (((double) displayMetrics.heightPixels) * 0.3d);
            int i11 = (int) (((double) displayMetrics.widthPixels) * 0.2d);
            BitMatrix bitMatrixA = a(str, i10, i11, z10);
            if (bitMatrixA == null) {
                OTLogger.a("OTQRCodeUtils", 6, "encodeToBitmap(): null bitMatrix");
                return;
            }
            int width = bitMatrixA.getWidth();
            int height = bitMatrixA.getHeight();
            int[] iArr = new int[width * height];
            if (c.q(str2) || c.q(str3)) {
                return;
            }
            int color = Color.parseColor(str2);
            int color2 = Color.parseColor(str3);
            for (int i12 = 0; i12 < height; i12++) {
                int i13 = i12 * width;
                for (int i14 = 0; i14 < width; i14++) {
                    iArr[i13 + i14] = bitMatrixA.get(i14, i12) ? color2 : color;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i11, 0, 0, width, height);
            imageView.setImageBitmap(bitmapCreateBitmap);
        } catch (Exception e10) {
            OTLogger.a("OTQRCodeUtils", 6, "encodeToBitmap(): " + e10);
        }
    }
}
