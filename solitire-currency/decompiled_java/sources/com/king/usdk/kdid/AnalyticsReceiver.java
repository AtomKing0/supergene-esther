package com.king.usdk.kdid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import androidx.annotation.Keep;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AnalyticsReceiver extends BroadcastReceiver {
    private static final String CONST_INTENT_VERSION = "1.0.0";
    private static final String CONST_KEY_KING_DEVICE_ID = "king_device_id";
    private static final String CONST_PREF_FILE_NAME = "analytics_share";
    private static final List<String> PREFERRED_APP_PREFIXES;

    static {
        ArrayList arrayList = new ArrayList();
        PREFERRED_APP_PREFIXES = arrayList;
        arrayList.add("com.king.");
        arrayList.add("com.midasplayer.");
    }

    private static native void HandleRequestResponse(String str, String str2);

    private static Intent createIntent(Context context, String str, String str2, boolean z10, String str3) {
        Intent intent = new Intent(str2);
        if (context == null || str2 == null || str2.isEmpty() || str3 == null) {
            return intent;
        }
        intent.putExtra(IntentField.KEY.getValue(), str);
        intent.putExtra(IntentField.ACTION.getValue(), str2);
        intent.putExtra(IntentField.VERSION.getValue(), CONST_INTENT_VERSION);
        intent.putExtra(IntentField.SENDER.getValue(), context.getPackageName());
        intent.addFlags(32);
        if (z10) {
            intent.putExtra(IntentField.TOKEN.getValue(), generateToken(context, str3));
        }
        return intent;
    }

    private void executeReceiveValue(Context context, String str, String str2, String str3, String str4, TokenMetaData tokenMetaData) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CONST_PREF_FILE_NAME, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str3);
        editorEdit.apply();
        if (validateKeyValue(str, str2)) {
            if (sharedPreferences.contains(str)) {
                return;
            }
            editorEdit.putString(str, str2);
            editorEdit.apply();
            try {
                HandleRequestResponse(str, str2);
                return;
            } catch (UnsatisfiedLinkError e10) {
                Log.e("AnalyticsReceiver", "Can't call the native code!", e10);
                return;
            }
        }
        int iIndexOf = tokenMetaData.packageNames.indexOf(str4);
        if (iIndexOf >= 0) {
            tokenMetaData.packageNames.remove(iIndexOf);
        }
        if (tokenMetaData.packageNames.size() <= 0) {
            try {
                HandleRequestResponse(str, str2);
                return;
            } catch (UnsatisfiedLinkError e11) {
                Log.e("AnalyticsReceiver", "Can't call the native code!", e11);
                return;
            }
        }
        String preferredApp = getPreferredApp(tokenMetaData.packageNames);
        String value = IntentActions.REQUEST_VALUE.getValue();
        Intent intentCreateIntent = createIntent(context, str, value, true, JsonParser.serialize(TokenMetaData.class, new TokenMetaData(str, value, tokenMetaData.packageNames.get(0), tokenMetaData.packageNames)));
        intentCreateIntent.setPackage(preferredApp);
        context.sendBroadcast(intentCreateIntent);
    }

    private void executeRequestValue(Context context, String str, String str2, String str3) {
        String string = context.getSharedPreferences(CONST_PREF_FILE_NAME, 0).getString(str, null);
        Intent intentCreateIntent = createIntent(context, str, IntentActions.RECEIVE_VALUE.getValue(), false, "");
        intentCreateIntent.setPackage(str2);
        intentCreateIntent.putExtra(IntentField.TOKEN.getValue(), str3);
        intentCreateIntent.putExtra(IntentField.VALUE.getValue(), string);
        context.sendBroadcast(intentCreateIntent);
    }

    private static String generateToken(Context context, String str) {
        String string = new BigInteger(130, new SecureRandom()).toString(32);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(CONST_PREF_FILE_NAME, 0).edit();
        editorEdit.putString(string, str);
        editorEdit.apply();
        return string;
    }

    private static List<String> getPackageNames(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (context == null || intent == null) {
            return arrayList;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 128);
        if (listQueryBroadcastReceivers.size() >= 1) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                if (!resolveInfo.activityInfo.packageName.equals(packageName)) {
                    arrayList.add(resolveInfo.activityInfo.packageName);
                }
            }
        }
        return arrayList;
    }

    private static String getPreferredApp(List<String> list) {
        for (String str : list) {
            Iterator<String> it = PREFERRED_APP_PREFIXES.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    return str;
                }
            }
        }
        return list.get(0);
    }

    public static void getValue(String str, Activity activity) {
        Context applicationContext;
        if (str == null || str.isEmpty() || (applicationContext = activity.getApplicationContext()) == null) {
            return;
        }
        String value = IntentActions.REQUEST_VALUE.getValue();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(CONST_PREF_FILE_NAME, 0);
        if (sharedPreferences.contains(str)) {
            HandleRequestResponse(str, sharedPreferences.getString(str, null));
            return;
        }
        List<String> packageNames = getPackageNames(applicationContext, new Intent(value));
        if (packageNames.isEmpty()) {
            HandleRequestResponse(str, null);
            return;
        }
        String preferredApp = getPreferredApp(packageNames);
        Intent intentCreateIntent = createIntent(applicationContext, str, value, true, JsonParser.serialize(TokenMetaData.class, new TokenMetaData(str, value, packageNames.get(0), packageNames)));
        intentCreateIntent.setPackage(preferredApp);
        applicationContext.sendBroadcast(intentCreateIntent);
    }

    private static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static void setValue(String str, String str2, Activity activity) {
        if (str == null || str.isEmpty()) {
            return;
        }
        SharedPreferences sharedPreferences = activity.getApplicationContext().getSharedPreferences(CONST_PREF_FILE_NAME, 0);
        if (sharedPreferences.contains(str) || !isLong(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    private boolean validateIntentParameters(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            Log.d("AnalyticsReceiver", "Problem with action");
            return false;
        }
        String stringExtra = intent.getStringExtra(IntentField.SENDER.getValue());
        if (stringExtra == null || stringExtra.isEmpty()) {
            Log.d("AnalyticsReceiver", "ValidateIntentParameters entered");
            return false;
        }
        if (stringExtra.equals(context.getPackageName())) {
            Log.d("AnalyticsReceiver", "Sender pkg eq context pkg");
            return false;
        }
        String stringExtra2 = intent.getStringExtra(IntentField.TOKEN.getValue());
        if (stringExtra2 == null || stringExtra2.length() != 26) {
            Log.d("AnalyticsReceiver", "Token wrong!");
            return false;
        }
        String stringExtra3 = intent.getStringExtra(IntentField.VERSION.getValue());
        if (stringExtra3 == null || stringExtra3.isEmpty()) {
            Log.d("AnalyticsReceiver", "Version problems");
            return false;
        }
        String stringExtra4 = intent.getStringExtra(IntentField.KEY.getValue());
        if (stringExtra4 != null && !stringExtra4.isEmpty()) {
            return true;
        }
        Log.d("AnalyticsReceiver", "Key problems");
        return false;
    }

    private boolean validateKeyValue(String str, String str2) {
        return str != null && str2 != null && str.equals(CONST_KEY_KING_DEVICE_ID) && isLong(str2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        TokenMetaData tokenMetaData;
        if (context == null || intent == null || !validateIntentParameters(context, intent)) {
            return;
        }
        String stringExtra = intent.getStringExtra(IntentField.KEY.getValue());
        String stringExtra2 = intent.getStringExtra(IntentField.SENDER.getValue());
        String stringExtra3 = intent.getStringExtra(IntentField.TOKEN.getValue());
        if (IntentActions.REQUEST_VALUE.getValue().equals(intent.getAction())) {
            executeRequestValue(context, stringExtra, stringExtra2, stringExtra3);
            return;
        }
        if (IntentActions.RECEIVE_VALUE.getValue().equals(intent.getAction())) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(CONST_PREF_FILE_NAME, 0);
            if (!sharedPreferences.contains(stringExtra3) || (string = sharedPreferences.getString(stringExtra3, null)) == null || string.isEmpty() || (tokenMetaData = (TokenMetaData) JsonParser.parse(TokenMetaData.class, string)) == null || !tokenMetaData.key.equals(stringExtra)) {
                return;
            }
            executeReceiveValue(context, stringExtra, intent.getStringExtra(IntentField.VALUE.getValue()), stringExtra3, stringExtra2, tokenMetaData);
        }
    }
}
