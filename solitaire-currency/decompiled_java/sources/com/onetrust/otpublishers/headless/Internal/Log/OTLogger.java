package com.onetrust.otpublishers.headless.Internal.Log;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.onetrust.otpublishers.headless.Internal.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class OTLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f21819a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f21820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f21821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BufferedWriter f21822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f21823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f21824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f21825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f21826h;

    public static int a(@NonNull String str, int i10, @NonNull String str2) {
        int i11 = f21819a;
        int iV = -1;
        if (i11 != -1 && i11 <= i10) {
            switch (i10) {
                case 2:
                    iV = Log.v(str, str2);
                    break;
                case 3:
                    iV = Log.d(str, str2);
                    break;
                case 4:
                    iV = Log.i(str, str2);
                    break;
                case 5:
                    iV = Log.w(str, str2);
                    break;
                case 6:
                    iV = Log.e(str, str2);
                    break;
                case 7:
                    iV = Log.wtf(str, str2);
                    break;
            }
        }
        if ((f21826h && f21825g) || (f21825g && i10 > 3)) {
            c(i10, str, str2);
        }
        return iV;
    }

    public static String b(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        String str4;
        Object[] objArr = new Object[4];
        try {
            str4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        } catch (Exception e10) {
            Log.e("OTLogger", "Error : " + e10.getMessage());
            str4 = null;
        }
        objArr[0] = str4;
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = str3;
        return String.format("%s: /%s %s - %s", objArr);
    }

    public static void c(int i10, @NonNull String str, @Nullable String str2) {
        if (i10 >= f21823e && f21822d != null) {
            try {
                if (f()) {
                    f21822d = new BufferedWriter(new FileWriter(f21821c, true));
                }
                f21822d.write(b(i10 == 2 ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : i10 == 3 ? "D" : i10 == 4 ? "I" : i10 == 5 ? ExifInterface.LONGITUDE_WEST : i10 == 6 ? ExifInterface.LONGITUDE_EAST : i10 == 7 ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : "", str, str2));
                f21822d.newLine();
                f21822d.flush();
            } catch (IOException e10) {
                Log.e("OTLogger", "Error : " + e10.getMessage());
            }
        }
        if (f21822d == null) {
            Log.e("OTLogger", "You have to call OTLogger.open(...) before starting to log");
        }
    }

    public static void d(@NonNull String str) {
        a("OTSDKListFragment", 3, str);
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        if (!c.q(str2)) {
            a("OTLogger", 4, "device : " + str + " - " + str2);
        }
        c(4, str, str2);
        Log.v(str, str2);
    }

    public static boolean f() {
        try {
            if (f21821c.length() > f21824f) {
                File file = new File(f21820b + ".old");
                if (file.exists()) {
                    Log.v("OTLogger", "file deleted : " + file.delete());
                }
                Log.v("OTLogger", "file renamed : " + f21821c.renameTo(file));
                File file2 = new File(f21820b);
                f21821c = file2;
                Log.v("OTLogger", "file created  : " + file2.createNewFile());
                return true;
            }
        } catch (IOException e10) {
            Log.e("OTLogger", "Error : " + e10.getMessage());
        }
        return false;
    }

    public static void g() {
        a("CPWorker", 4, "Consent logging");
    }

    public static void h(@NonNull String str) {
        a("OneTrust", 6, str);
    }

    @Keep
    public static void open(@NonNull String str, int i10, int i11) {
        f21820b = str;
        f21823e = i10;
        f21824f = i11;
        File file = new File(f21820b);
        f21821c = file;
        if (!file.exists()) {
            try {
                Log.v("OTLogger", "file deleted in open method : " + f21821c.createNewFile());
                f21822d = new BufferedWriter(new FileWriter(f21821c, true));
                a.a();
            } catch (IOException e10) {
                Log.e("OTLogger", "Error : " + e10.getMessage());
            }
        }
        f();
        try {
            f21822d = new BufferedWriter(new FileWriter(f21821c, true));
        } catch (IOException e11) {
            Log.e("OTLogger", Log.getStackTraceString(e11));
        }
    }
}
