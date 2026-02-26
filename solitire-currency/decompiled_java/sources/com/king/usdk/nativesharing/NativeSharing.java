package com.king.usdk.nativesharing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.core.content.FileProvider;
import com.king.usdk.logger.Logger;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class NativeSharing {
    static final long JAVA_RESULT_FILE_CAN_NOT_BE_ATTACHED_TO_INTENT = 2;
    static final long JAVA_RESULT_FILE_CAN_NOT_BE_READ = 1;
    static final long JAVA_RESULT_OK = 0;
    protected static String sCallbackHandleId = "callbackHandleId";
    protected static String sUnknownPackageName = "unknown";
    private final Activity mActivity;
    private final String mClassName = "[com.king.usdk.nativesharing.NativeSharing] ";
    private final Logger mLogger;

    public NativeSharing(Activity activity, long j10, boolean z10) {
        this.mActivity = activity;
        this.mLogger = new Logger(j10, z10);
    }

    public static native void SharedToNetwork(String str, int i10);

    public long share(String str, String str2, String str3, String str4, String str5, int i10) {
        Intent intent = new Intent("android.intent.action.SEND");
        if (str5 != null && !str5.isEmpty()) {
            intent.putExtra("android.intent.extra.SUBJECT", str5);
        }
        if (str3 != null && !str3.isEmpty()) {
            intent.putExtra("android.intent.extra.TEXT", str3);
        }
        if (str2 != null && !str2.isEmpty()) {
            File file = new File(str2);
            if (!file.canRead()) {
                this.mLogger.e("[com.king.usdk.nativesharing.NativeSharing] : cached file can not be read: " + str2);
                return 1L;
            }
            try {
                Uri uriForFile = FileProvider.getUriForFile(this.mActivity, this.mActivity.getPackageName() + ".fileprovider", file);
                this.mLogger.d("[com.king.usdk.nativesharing.NativeSharing] Using cached file with uri: " + uriForFile.toString() + " for sharing.");
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
                intent.addFlags(1);
                intent.setClipData(ClipData.newRawUri("", uriForFile));
            } catch (Exception e10) {
                e10.printStackTrace();
                this.mLogger.e("[com.king.usdk.nativesharing.NativeSharing] : Exception: " + e10.getMessage());
                return JAVA_RESULT_FILE_CAN_NOT_BE_ATTACHED_TO_INTENT;
            }
        }
        intent.setType(str);
        if (str4 == null) {
            str4 = "";
        }
        Intent intent2 = new Intent(this.mActivity, (Class<?>) NativeSharingReceiver.class);
        intent2.putExtra(sCallbackHandleId, i10);
        this.mActivity.startActivityForResult(Intent.createChooser(intent, str4, PendingIntent.getBroadcast(this.mActivity, 0, intent2, 167772160).getIntentSender()), i10);
        return JAVA_RESULT_OK;
    }
}
